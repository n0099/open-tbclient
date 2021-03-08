package com.yy.mediaframework;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class CameraUtils {
    private static final int DEFAULT_PREVIEW_HEIGHT = 720;
    private static final int DEFAULT_PREVIEW_WIDTH = 1280;
    private static final String TAG = "CameraUtils";
    public static ArrayList<Long> mCameraBufferHashCode = new ArrayList<>();

    /* loaded from: classes6.dex */
    public enum CameraFacing {
        FacingFront,
        FacingBack
    }

    public static void setCameraBufferHashCode(long j) {
        synchronized (mCameraBufferHashCode) {
            if (j == 0) {
                mCameraBufferHashCode.clear();
            }
            mCameraBufferHashCode.add(Long.valueOf(j));
        }
    }

    public static boolean queryCameraBufferHashCode(long j) {
        boolean contains;
        synchronized (mCameraBufferHashCode) {
            contains = mCameraBufferHashCode.contains(Long.valueOf(j));
        }
        return contains;
    }

    public static void setCameraDisplayOrientation(Context context, Camera camera, Camera.CameraInfo cameraInfo) {
        int i;
        if (context != null && camera != null) {
            int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
            switch (rotation) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    i = 90;
                    break;
                case 2:
                    i = 180;
                    break;
                case 3:
                    i = 270;
                    break;
                default:
                    YMFLog.error((Object) null, "[CCapture]", "invalid rotation:" + rotation);
                    i = 0;
                    break;
            }
            YMFLog.info(null, "[CCapture]", "setCameraDisplayOrientation degrees:" + i);
            setCameraDisplayOrientation(i, camera, cameraInfo);
        }
    }

    public static void setCameraDisplayOrientation(int i, Camera camera, Camera.CameraInfo cameraInfo) {
        if (camera != null) {
            int i2 = 90;
            if (cameraInfo != null) {
                if (cameraInfo.facing == 1) {
                    i2 = (360 - ((cameraInfo.orientation + i) % EncoderTextureDrawer.X264_WIDTH)) % EncoderTextureDrawer.X264_WIDTH;
                } else {
                    i2 = ((cameraInfo.orientation - i) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
                }
            } else {
                YMFLog.error((Object) null, "[CCapture]", "setCameraDisplayOrientation cameraInfo null");
            }
            YMFLog.info(null, "[CCapture]", "setCameraDisplayOrientation:" + i2 + " ,displayRotation:" + i);
            camera.setDisplayOrientation(i2);
            CameraInterface.getInstance().setRotation(i2);
        }
    }

    public static Camera.Size selectPreferredSize(Camera.Parameters parameters, int i, int i2) {
        Camera.Size size;
        Camera.Size size2;
        Camera.Size size3;
        int i3;
        int i4 = Integer.MAX_VALUE;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        int size4 = supportedPreviewSizes.size();
        for (int i5 = 0; i5 < size4; i5++) {
            Camera.Size size5 = supportedPreviewSizes.get(i5);
            YMFLog.info(null, "[CCapture]", "camera preview size:" + size5.width + Config.EVENT_HEAT_X + size5.height);
        }
        Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
        while (true) {
            if (!it.hasNext()) {
                size = null;
                break;
            }
            size = it.next();
            if (size.width == i && size.height == i2) {
                break;
            }
        }
        if (size == null) {
            Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
            int i6 = Integer.MAX_VALUE;
            while (true) {
                size3 = size;
                if (!it2.hasNext()) {
                    break;
                }
                size = it2.next();
                if (size.width < i || size.height < i2 || (i3 = ((size.width - i) + size.height) - i2) >= i6) {
                    size = size3;
                } else {
                    i6 = i3;
                }
            }
            size = size3;
        }
        if (size == null) {
            Iterator<Camera.Size> it3 = supportedPreviewSizes.iterator();
            while (true) {
                size2 = size;
                if (!it3.hasNext()) {
                    break;
                }
                size = it3.next();
                int abs = Math.abs(size.width - i) + Math.abs(size.height - i2);
                if (abs < i4) {
                    i4 = abs;
                } else {
                    size = size2;
                }
            }
        } else {
            size2 = size;
        }
        if (size2 != null) {
            parameters.setPreviewSize(size2.width, size2.height);
        }
        return size2;
    }

    public static void choosePreviewSize(Camera.Parameters parameters, int i, int i2) {
        Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
        if (preferredPreviewSizeForVideo != null) {
            YMFLog.info(null, "[CCapture]", "Camera preferred preview size for video is:" + preferredPreviewSizeForVideo.width + Config.EVENT_HEAT_X + preferredPreviewSizeForVideo.height);
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
            YMFLog.info(null, "[CCapture]", " supported size:" + size.width + Config.EVENT_HEAT_X + size.height);
            if (size.width >= i && size.height >= i2 && size.width <= i4 && size.height <= i3) {
                i4 = size.width;
                i3 = size.height;
            }
            i3 = i3;
        }
        if (i4 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            YMFLog.info(null, "[CCapture]", "prefer size:" + i + Config.EVENT_HEAT_X + i2 + ", choose " + i4 + Config.EVENT_HEAT_X + i3);
            parameters.setPreviewSize(i4, i3);
        } else if (preferredPreviewSizeForVideo != null) {
            parameters.setPreviewSize(preferredPreviewSizeForVideo.width, preferredPreviewSizeForVideo.height);
        }
    }

    public static int chooseFixedPreviewFps(Camera.Parameters parameters, int i) {
        int i2;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            YMFLog.info(null, "[CCapture]", "getSupportedPreviewFpsRange entry:" + iArr[0] + " - " + iArr[1]);
            if (iArr[0] == iArr[1] && iArr[0] == i) {
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                return iArr[0];
            }
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (iArr2[0] == iArr2[1]) {
            i2 = iArr2[0];
        } else {
            i2 = iArr2[1] / 2;
        }
        YMFLog.info(null, "[CCapture]", "Couldn't find match for " + i + ", using " + i2);
        return i2;
    }

    public static Camera openCamera(CameraFacing cameraFacing) {
        return openCamera(cameraFacing, null);
    }

    public static Camera openCamera(CameraFacing cameraFacing, Camera.CameraInfo cameraInfo) {
        Camera camera;
        if (cameraInfo == null) {
            cameraInfo = new Camera.CameraInfo();
        }
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            int i = 0;
            while (true) {
                if (i >= numberOfCameras) {
                    camera = null;
                    break;
                }
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraFacing == CameraFacing.FacingFront) {
                    if (cameraInfo.facing != 1) {
                        i++;
                    } else {
                        camera = Camera.open(i);
                        break;
                    }
                } else if (cameraInfo.facing != 0) {
                    i++;
                } else {
                    camera = Camera.open(i);
                    break;
                }
            }
            if (camera == null) {
                try {
                    Log.d(TAG, "No front-facing camera found; opening default");
                    return Camera.open();
                } catch (Throwable th) {
                    th = th;
                    YMFLog.error((Object) null, "[CCapture]", "openCamera exception:" + th);
                    return camera;
                }
            }
            return camera;
        } catch (Throwable th2) {
            th = th2;
            camera = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class PreviewSize {
        public int height;
        public int width;

        public PreviewSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public String toString() {
            return "" + this.width + Config.EVENT_HEAT_X + this.height;
        }
    }

    public static PreviewSize getSpecialCameraPreviewSizeWithModel(String str, Camera.Size size, CameraFacing cameraFacing) {
        PreviewSize previewSize;
        if ("MI 4LTE".equalsIgnoreCase(str)) {
            if (size != null && size.width != 1280 && size.height != 720 && cameraFacing == CameraFacing.FacingBack) {
                previewSize = new PreviewSize(1280, 720);
            }
            previewSize = null;
        } else if ("HM NOTE 1W".equalsIgnoreCase(str)) {
            if (size != null && size.width != 1280 && size.height != 720) {
                previewSize = new PreviewSize(1280, 720);
            }
            previewSize = null;
        } else if ("2013023".equalsIgnoreCase(str)) {
            if (size != null && size.width == 960 && size.height == 540) {
                previewSize = new PreviewSize(1280, 720);
            }
            previewSize = null;
        } else {
            if ("vivo X5L".equalsIgnoreCase(str) && size != null && size.width == 960 && size.height == 540) {
                previewSize = new PreviewSize(1280, 720);
            }
            previewSize = null;
        }
        if (previewSize != null) {
            YMFLog.info(null, "[CCapture]", "getSpecialCameraPreviewSizeWithModel size:" + previewSize + ", model:" + str + ", " + cameraFacing);
        }
        return previewSize;
    }

    public static int toAndroidCameraFacing(CameraFacing cameraFacing) {
        return cameraFacing == CameraFacing.FacingFront ? 1 : 0;
    }

    public static boolean isCameraAvailable(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (i == cameraInfo.facing) {
                YMFLog.info(null, "[CCapture]", "isCameraAvailable true:" + i);
                return true;
            }
        }
        YMFLog.info(null, "[CCapture]", "isCameraAvailable false:" + i);
        return false;
    }

    public static int[] getMaxFrameRateRange(Camera.Parameters parameters) {
        int[] iArr = null;
        for (int[] iArr2 : parameters.getSupportedPreviewFpsRange()) {
            if (iArr != null && iArr2[1] <= iArr[1] && (iArr2[1] != iArr[1] || iArr2[0] >= iArr[0])) {
                iArr2 = iArr;
            }
            iArr = iArr2;
        }
        return iArr;
    }

    @TargetApi(14)
    public static boolean isMeteringAreaSupported(Camera.Parameters parameters) {
        return Build.VERSION.SDK_INT >= 14 && parameters.getMaxNumMeteringAreas() > 0;
    }

    @TargetApi(14)
    public static boolean isFocusAreaSupported(Camera.Parameters parameters) {
        return Build.VERSION.SDK_INT >= 14 && parameters.getMaxNumFocusAreas() > 0 && isSupported("auto", parameters.getSupportedFocusModes());
    }

    @TargetApi(14)
    public static boolean isFaceDetectionSupported(Camera.Parameters parameters) {
        return Build.VERSION.SDK_INT >= 14 && parameters.getMaxNumDetectedFaces() > 0;
    }

    public static boolean isTorchSupported(Camera.Parameters parameters) {
        List<String> supportedFlashModes;
        return parameters != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && supportedFlashModes.contains("off") && supportedFlashModes.contains("torch");
    }

    public static boolean isSupported(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public static int clamp(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    public static void rectFToRect(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }

    public static void prepareMatrix(Matrix matrix, boolean z, int i, int i2, int i3) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(i);
        matrix.postScale(i2 / 2000.0f, i3 / 2000.0f);
        matrix.postTranslate(i2 / 2.0f, i3 / 2.0f);
    }
}
