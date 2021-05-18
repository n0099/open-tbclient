package d.a.k0.q3.m;

import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* loaded from: classes5.dex */
    public static class b implements Comparator<Camera.Size> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            int i2 = size.width;
            int i3 = size2.width;
            return i2 != i3 ? i2 - i3 : size.height - size2.height;
        }
    }

    public static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public static int b(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            int e2 = e(activity);
            if (cameraInfo.facing == 1) {
                return (360 - ((cameraInfo.orientation + e2) % 360)) % 360;
            }
            return ((cameraInfo.orientation - e2) + 360) % 360;
        }
        return 0;
    }

    public static int c(boolean z) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo[] cameraInfoArr = new Camera.CameraInfo[numberOfCameras];
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            cameraInfoArr[i2] = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfoArr[i2]);
        }
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < numberOfCameras; i5++) {
            if (i4 == -1 && cameraInfoArr[i5].facing == 0) {
                i4 = i5;
            } else if (i3 == -1 && cameraInfoArr[i5].facing == 1) {
                i3 = i5;
            }
        }
        if (i3 == -1 || !z) {
            if (i4 == -1 || z) {
                if (z && i3 == -1) {
                    return i4;
                }
                if (i3 != -1) {
                    return i3;
                }
                if (i4 != -1) {
                    return i4;
                }
                return -1;
            }
            return i4;
        }
        return i3;
    }

    public static Camera.Size d(Camera camera, int i2, int i3) {
        List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
        Camera.Size size = null;
        Collections.sort(supportedPreviewSizes, new b());
        if (supportedPreviewSizes != null && supportedPreviewSizes.size() > 0) {
            boolean z = false;
            Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
            int i4 = -1;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next = it.next();
                i4++;
                if (next != null && next.width >= i3 && next.height >= i2) {
                    size = next;
                    z = true;
                    break;
                }
            }
            if (!z) {
                i4 = supportedPreviewSizes.size() - 1;
                size = supportedPreviewSizes.get(i4);
            }
            int i5 = ((int) (((float) IdCardOcrCameraActivity.G) * ((i3 * 1.0f) / i2))) * IdCardOcrCameraActivity.G;
            while (size.width * size.height > i5 && i4 > 0) {
                i4--;
                size = supportedPreviewSizes.get(i4);
            }
        }
        return size;
    }

    public static int e(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    return rotation != 3 ? 0 : 270;
                }
                return 180;
            }
            return 90;
        }
        return 0;
    }

    public static boolean f(boolean z) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo[] cameraInfoArr = new Camera.CameraInfo[numberOfCameras];
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            cameraInfoArr[i2] = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfoArr[i2]);
        }
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < numberOfCameras; i5++) {
            if (i4 == -1 && cameraInfoArr[i5].facing == 0) {
                i4 = i5;
            } else if (i3 == -1 && cameraInfoArr[i5].facing == 1) {
                i3 = i5;
            }
        }
        if (i3 == -1 || !z) {
            return (i4 == -1 || z) ? false : true;
        }
        return true;
    }

    public static boolean g(PackageManager packageManager) {
        FeatureInfo[] systemAvailableFeatures;
        if (packageManager != null && (systemAvailableFeatures = packageManager.getSystemAvailableFeatures()) != null) {
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if (featureInfo != null && "android.hardware.camera.flash".equals(featureInfo.name)) {
                    return true;
                }
            }
        }
        return false;
    }
}
