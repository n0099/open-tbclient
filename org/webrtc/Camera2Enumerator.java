package org.webrtc;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.SystemClock;
import android.util.AndroidException;
import android.util.Range;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;
/* loaded from: classes7.dex */
public class Camera2Enumerator implements CameraEnumerator {
    public static final double NANO_SECONDS_PER_SECOND = 1.0E9d;
    public static final String TAG = "Camera2Enumerator";
    public static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats = new HashMap();
    public static boolean disableExtraCamera = false;
    public final CameraManager cameraManager;
    public final Context context;

    public Camera2Enumerator(Context context) {
        this.context = context;
        this.cameraManager = (CameraManager) context.getSystemService(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA);
    }

    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] rangeArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (Range<Integer> range : rangeArr) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(range.getLower().intValue() * i, range.getUpper().intValue() * i));
        }
        return arrayList;
    }

    public static List<Size> convertSizes(android.util.Size[] sizeArr) {
        ArrayList arrayList = new ArrayList();
        for (android.util.Size size : sizeArr) {
            arrayList.add(new Size(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    public static void disableExtraCamera(boolean z) {
        disableExtraCamera = z;
    }

    private CameraCharacteristics getCameraCharacteristics(String str) {
        try {
            return this.cameraManager.getCameraCharacteristics(str);
        } catch (AndroidException e2) {
            Logging.e(TAG, "Camera access exception: " + e2);
            return null;
        }
    }

    public static int getFpsUnitFactor(Range<Integer>[] rangeArr) {
        return (rangeArr.length != 0 && rangeArr[0].getUpper().intValue() >= 1000) ? 1 : 1000;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context context, String str) {
        return getSupportedFormats((CameraManager) context.getSystemService(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA), str);
    }

    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager cameraManager, String str) {
        long j;
        int round;
        synchronized (cachedSupportedFormats) {
            if (cachedSupportedFormats.containsKey(str)) {
                return cachedSupportedFormats.get(str);
            }
            Logging.d(TAG, "Get supported formats for camera index " + str + ".");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates = convertFramerates(rangeArr, getFpsUnitFactor(rangeArr));
                List<Size> supportedSizes = getSupportedSizes(cameraCharacteristics);
                int i = 0;
                for (CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange : convertFramerates) {
                    i = Math.max(i, framerateRange.max);
                }
                ArrayList arrayList = new ArrayList();
                for (Size size : supportedSizes) {
                    try {
                        j = streamConfigurationMap.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(size.width, size.height));
                    } catch (Exception unused) {
                        j = 0;
                    }
                    if (j == 0) {
                        round = i;
                    } else {
                        double d2 = j;
                        Double.isNaN(d2);
                        round = ((int) Math.round(1.0E9d / d2)) * 1000;
                    }
                    arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, 0, round));
                    Logging.d(TAG, "Format: " + size.width + "x" + size.height + "@" + round);
                }
                cachedSupportedFormats.put(str, arrayList);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                Logging.d(TAG, "Get supported formats for camera index " + str + " done. Time spent: " + (elapsedRealtime2 - elapsedRealtime) + " ms.");
                return arrayList;
            } catch (Exception e2) {
                Logging.e(TAG, "getCameraCharacteristics(): " + e2);
                return new ArrayList();
            }
        }
    }

    public static List<Size> getSupportedSizes(CameraCharacteristics cameraCharacteristics) {
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        List<Size> convertSizes = convertSizes(((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class));
        if (Build.VERSION.SDK_INT >= 22 || intValue != 2) {
            return convertSizes;
        }
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        ArrayList arrayList = new ArrayList();
        for (Size size : convertSizes) {
            if (rect.width() * size.height == rect.height() * size.width) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    public static boolean isSupported(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA);
        try {
            for (String str : cameraManager.getCameraIdList()) {
                if (((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                    return false;
                }
            }
            return true;
        } catch (AndroidException e2) {
            Logging.e(TAG, "Camera access exception: " + e2);
            return false;
        }
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        return new Camera2Capturer(this.context, str, cameraEventsHandler);
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        try {
            String[] cameraIdList = this.cameraManager.getCameraIdList();
            if (cameraIdList.length > 2) {
                if (disableExtraCamera) {
                    return new String[]{cameraIdList[0], cameraIdList[1]};
                }
            }
            return cameraIdList;
        } catch (AndroidException e2) {
            Logging.e(TAG, "Camera access exception: " + e2);
            return new String[0];
        }
    }

    @Override // org.webrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str) {
        return getSupportedFormats(this.context, str);
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(str);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(str);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
