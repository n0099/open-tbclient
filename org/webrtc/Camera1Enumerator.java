package org.webrtc;

import android.hardware.Camera;
import android.os.SystemClock;
import com.alipay.sdk.widget.j;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;
/* loaded from: classes7.dex */
public class Camera1Enumerator implements CameraEnumerator {
    public static final String TAG = "Camera1Enumerator";
    public static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    public final boolean captureToTexture;

    public Camera1Enumerator() {
        this(true);
    }

    public Camera1Enumerator(boolean z) {
        this.captureToTexture = z;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> list) {
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : list) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(iArr[0], iArr[1]));
        }
        return arrayList;
    }

    public static List<Size> convertSizes(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : list) {
            arrayList.add(new Size(size.width, size.height));
        }
        return arrayList;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int i2) {
        int i3;
        Logging.d(TAG, "Get supported formats for camera index " + i2 + ".");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Camera camera = null;
        try {
            try {
                Logging.d(TAG, "Opening camera with index " + i2);
                camera = Camera.open(i2);
                Camera.Parameters parameters = camera.getParameters();
                if (camera != null) {
                    camera.release();
                }
                ArrayList arrayList = new ArrayList();
                try {
                    List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    int i4 = 0;
                    if (supportedPreviewFpsRange != null) {
                        int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
                        i4 = iArr[0];
                        i3 = iArr[1];
                    } else {
                        i3 = 0;
                    }
                    for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
                        arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, i4, i3));
                    }
                } catch (Exception e2) {
                    Logging.e(TAG, "getSupportedFormats() failed on camera index " + i2, e2);
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                Logging.d(TAG, "Get supported formats for camera index " + i2 + " done. Time spent: " + (elapsedRealtime2 - elapsedRealtime) + " ms.");
                return arrayList;
            } catch (RuntimeException e3) {
                Logging.e(TAG, "Open camera failed on camera index " + i2, e3);
                ArrayList arrayList2 = new ArrayList();
                if (camera != null) {
                    camera.release();
                }
                return arrayList2;
            }
        } catch (Throwable th) {
            if (camera != null) {
                camera.release();
            }
            throw th;
        }
    }

    public static int getCameraIndex(String str) {
        Logging.d(TAG, "getCameraIndex: " + str);
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            if (str.equals(getDeviceName(i2))) {
                return i2;
            }
        }
        throw new IllegalArgumentException("No such camera: " + str);
    }

    @Nullable
    public static Camera.CameraInfo getCameraInfo(int i2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i2, cameraInfo);
            return cameraInfo;
        } catch (Exception e2) {
            Logging.e(TAG, "getCameraInfo failed on index " + i2, e2);
            return null;
        }
    }

    @Nullable
    public static String getDeviceName(int i2) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i2);
        if (cameraInfo == null) {
            return null;
        }
        String str = cameraInfo.facing == 1 ? "front" : j.j;
        return "Camera " + i2 + ", Facing " + str + ", Orientation " + cameraInfo.orientation;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int i2) {
        List<CameraEnumerationAndroid.CaptureFormat> list;
        synchronized (Camera1Enumerator.class) {
            if (cachedSupportedFormats == null) {
                cachedSupportedFormats = new ArrayList();
                for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
                    cachedSupportedFormats.add(enumerateFormats(i3));
                }
            }
            list = cachedSupportedFormats.get(i2);
        }
        return list;
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        return new Camera1Capturer(str, cameraEventsHandler, this.captureToTexture);
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            String deviceName = getDeviceName(i2);
            if (deviceName != null) {
                arrayList.add(deviceName);
                Logging.d(TAG, "Index: " + i2 + ". " + deviceName);
            } else {
                Logging.e(TAG, "Index: " + i2 + ". Failed to query camera name.");
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // org.webrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str) {
        return getSupportedFormats(getCameraIndex(str));
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
        return cameraInfo != null && cameraInfo.facing == 0;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
        return cameraInfo != null && cameraInfo.facing == 1;
    }
}
