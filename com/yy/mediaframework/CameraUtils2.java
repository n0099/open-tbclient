package com.yy.mediaframework;

import android.hardware.Camera;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.utils.YMFLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public class CameraUtils2 {
    private static final float RATIO_16_9 = 1.7777778f;
    private static final float RATIO_3_4 = 0.75f;
    private static final float RATIO_4_3 = 1.3333334f;
    private static final float RATIO_9_16 = 0.5625f;
    private static final String TAG = "CameraUtils2";

    public static void chooseBestAspectPreviewSize(int i, int i2, int i3, Camera.Parameters parameters, double d, CameraInterface.CameraResolutionMode cameraResolutionMode) {
        int i4;
        int i5;
        YMFLog.info(null, "[CCapture]", "chooseBestAspectPreviewSize width:" + i2 + "  height:" + i3);
        Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
        if (preferredPreviewSizeForVideo != null) {
            YMFLog.info(null, "[CCapture]", "Camera preferred preview size:" + preferredPreviewSizeForVideo.width + Config.EVENT_HEAT_X + preferredPreviewSizeForVideo.height);
        }
        if (cameraResolutionMode == CameraInterface.CameraResolutionMode.CAMERA_RESOLUTION_RANGE_MODE) {
            float f = (i2 * 1.0f) / i3;
            if (i2 > i3) {
                if (Math.abs(f - RATIO_16_9) > Math.abs(f - RATIO_4_3)) {
                    i4 = 480;
                    i5 = 640;
                } else {
                    i4 = 720;
                    i5 = 1280;
                }
            } else if (Math.abs(f - RATIO_9_16) > Math.abs(f - RATIO_3_4)) {
                i4 = 640;
                i5 = 480;
            } else {
                i4 = 1280;
                i5 = 720;
            }
        } else {
            i4 = i3;
            i5 = i2;
        }
        YMFLog.info(null, "[CCapture]", "chooseBestAspectPreviewSize secondly width:" + i5 + ", height:" + i4 + " , displayOrientation:" + i);
        Camera.Size bestAspectPreviewSize = getBestAspectPreviewSize(i, i5, i4, parameters, d);
        if (bestAspectPreviewSize != null) {
            YMFLog.info(null, "[CCapture]", "prefer preview size secondly size:" + i5 + Config.EVENT_HEAT_X + i4 + ", choose " + bestAspectPreviewSize.width + Config.EVENT_HEAT_X + bestAspectPreviewSize.height);
            parameters.setPreviewSize(bestAspectPreviewSize.width, bestAspectPreviewSize.height);
            return;
        }
        YMFLog.warn(null, "[CCapture]", "Unable to set preview size:" + i5 + Config.EVENT_HEAT_X + i4);
        if (preferredPreviewSizeForVideo != null) {
            parameters.setPreviewSize(preferredPreviewSizeForVideo.width, preferredPreviewSizeForVideo.height);
        }
    }

    public static Camera.Size getBestAspectPreviewSize(int i, int i2, int i3, Camera.Parameters parameters) {
        return getBestAspectPreviewSize(i, i2, i3, parameters, 0.0d);
    }

    public static Camera.Size getBestAspectPreviewSize(int i, int i2, int i3, Camera.Parameters parameters, double d) {
        int abs;
        Camera.Size size = null;
        double d2 = Double.MAX_VALUE;
        double d3 = ((i == 90 || i == 270) && i2 > i3) ? i2 / i3 : i3 / i2;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            return null;
        }
        Collections.sort(supportedPreviewSizes, Collections.reverseOrder(new SizeComparator()));
        int i4 = Integer.MAX_VALUE;
        for (Camera.Size size2 : supportedPreviewSizes) {
            double d4 = size2.width / size2.height;
            YMFLog.info(null, "[CCapture]", "getSupportedPreviewSizes:" + size2.width + Config.EVENT_HEAT_X + size2.height + ", ratio:" + d4);
            if (i == 90 || i == 270) {
                abs = Math.abs(size2.width - i2) + Math.abs(size2.height - i3);
            } else {
                abs = Math.abs(size2.width - i3) + Math.abs(size2.height - i2);
            }
            if (Math.abs(d4 - d3) < d2) {
                d2 = Math.abs(d4 - d3);
                i4 = abs;
                size = size2;
            }
            if (Math.abs(Math.abs(d4 - d3) - d2) <= d && abs < i4) {
                d2 = Math.abs(d4 - d3);
                i4 = abs;
                size = size2;
            }
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SizeComparator implements Comparator<Camera.Size> {
        SizeComparator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            int i = size.width * size.height;
            int i2 = size2.width * size2.height;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            return 0;
        }
    }
}
