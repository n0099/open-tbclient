package org.webrtc;

import android.hardware.Camera;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;
/* loaded from: classes16.dex */
public class Camera1Enumerator implements CameraEnumerator {
    private static final String TAG = "Camera1Enumerator";
    private static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    private final boolean captureToTexture;

    public Camera1Enumerator() {
        this(true);
    }

    public Camera1Enumerator(boolean z) {
        this.captureToTexture = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> list) {
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : list) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(iArr[0], iArr[1]));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Size> convertSizes(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : list) {
            arrayList.add(new Size(size.width, size.height));
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x00fc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00fe */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0024 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.hardware.Camera] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.hardware.Camera] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.hardware.Camera] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, java.util.List<org.webrtc.CameraEnumerationAndroid$CaptureFormat>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7 */
    private static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int i) {
        int i2;
        ?? r1 = 0;
        r1 = 0;
        int i3 = 0;
        Logging.d(TAG, "Get supported formats for camera index " + i + ".");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            try {
                Logging.d(TAG, "Opening camera with index " + i);
                r1 = Camera.open(i);
            } catch (Throwable th) {
                th = th;
            }
        } catch (RuntimeException e) {
            e = e;
        }
        try {
            Camera.Parameters parameters = r1.getParameters();
            if (r1 != 0) {
                r1.release();
            }
            r1 = new ArrayList();
            try {
                List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (supportedPreviewFpsRange != null) {
                    int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
                    i2 = iArr[0];
                    i3 = iArr[1];
                } else {
                    i2 = 0;
                }
                for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
                    r1.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, i2, i3));
                }
            } catch (Exception e2) {
                Logging.e(TAG, "getSupportedFormats() failed on camera index " + i, e2);
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            Logging.d(TAG, "Get supported formats for camera index " + i + " done. Time spent: " + (elapsedRealtime2 - elapsedRealtime) + " ms.");
            return r1;
        } catch (RuntimeException e3) {
            e = e3;
            Logging.e(TAG, "Open camera failed on camera index " + i, e);
            ArrayList arrayList = new ArrayList();
            if (r1 != 0) {
                r1.release();
                return arrayList;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
                r1.release();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getCameraIndex(String str) {
        Logging.d(TAG, "getCameraIndex: " + str);
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            if (str.equals(getDeviceName(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException("No such camera: " + str);
    }

    @Nullable
    private static Camera.CameraInfo getCameraInfo(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i, cameraInfo);
            return cameraInfo;
        } catch (Exception e) {
            Logging.e(TAG, "getCameraInfo failed on index " + i, e);
            return null;
        }
    }

    @Nullable
    static String getDeviceName(int i) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i);
        if (cameraInfo == null) {
            return null;
        }
        String str = cameraInfo.facing == 1 ? "front" : "back";
        return "Camera " + i + ", Facing " + str + ", Orientation " + cameraInfo.orientation;
    }

    static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int i) {
        List<CameraEnumerationAndroid.CaptureFormat> list;
        synchronized (Camera1Enumerator.class) {
            try {
                if (cachedSupportedFormats == null) {
                    cachedSupportedFormats = new ArrayList();
                    for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                        cachedSupportedFormats.add(enumerateFormats(i2));
                    }
                }
                list = cachedSupportedFormats.get(i);
            } catch (Throwable th) {
                throw th;
            }
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
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            String deviceName = getDeviceName(i);
            if (deviceName != null) {
                arrayList.add(deviceName);
                Logging.d(TAG, "Index: " + i + ". " + deviceName);
            } else {
                Logging.e(TAG, "Index: " + i + ". Failed to query camera name.");
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
