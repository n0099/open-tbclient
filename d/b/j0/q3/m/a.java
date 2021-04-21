package d.b.j0.q3.m;

import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
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
            int i = size.width;
            int i2 = size2.width;
            return i != i2 ? i - i2 : size.height - size2.height;
        }
    }

    public static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static int b(Activity activity, int i) {
        if (Build.VERSION.SDK_INT > 8) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
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
        for (int i = 0; i < numberOfCameras; i++) {
            cameraInfoArr[i] = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfoArr[i]);
        }
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            if (i3 == -1 && cameraInfoArr[i4].facing == 0) {
                i3 = i4;
            } else if (i2 == -1 && cameraInfoArr[i4].facing == 1) {
                i2 = i4;
            }
        }
        if (i2 == -1 || !z) {
            if (i3 == -1 || z) {
                if (z && i2 == -1) {
                    return i3;
                }
                if (i2 != -1) {
                    return i2;
                }
                if (i3 != -1) {
                    return i3;
                }
                return -1;
            }
            return i3;
        }
        return i2;
    }

    public static Camera.Size d(Camera camera, int i, int i2) {
        List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
        Camera.Size size = null;
        Collections.sort(supportedPreviewSizes, new b());
        if (supportedPreviewSizes != null && supportedPreviewSizes.size() > 0) {
            boolean z = false;
            Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
            int i3 = -1;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next = it.next();
                i3++;
                if (next != null && next.width >= i2 && next.height >= i) {
                    size = next;
                    z = true;
                    break;
                }
            }
            if (!z) {
                i3 = supportedPreviewSizes.size() - 1;
                size = supportedPreviewSizes.get(i3);
            }
            int i4 = ((int) (1080 * ((i2 * 1.0f) / i))) * 1080;
            while (size.width * size.height > i4 && i3 > 0) {
                i3--;
                size = supportedPreviewSizes.get(i3);
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
        for (int i = 0; i < numberOfCameras; i++) {
            cameraInfoArr[i] = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfoArr[i]);
        }
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            if (i3 == -1 && cameraInfoArr[i4].facing == 0) {
                i3 = i4;
            } else if (i2 == -1 && cameraInfoArr[i4].facing == 1) {
                i2 = i4;
            }
        }
        if (i2 == -1 || !z) {
            return (i3 == -1 || z) ? false : true;
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
