package com.repackage;

import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class tq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b implements Comparator<Camera.Size> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, size, size2)) == null) {
                int i = size.width;
                int i2 = size2.width;
                return i != i2 ? i - i2 : size.height - size2.height;
            }
            return invokeLL.intValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static int a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65536, null, i, i2, i3)) == null) ? i > i3 ? i3 : i < i2 ? i2 : i : invokeIII.intValue;
    }

    public static int b(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, activity, i)) == null) {
            if (Build.VERSION.SDK_INT > 8) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                int e = e(activity);
                if (cameraInfo.facing == 1) {
                    return (360 - ((cameraInfo.orientation + e) % 360)) % 360;
                }
                return ((cameraInfo.orientation - e) + 360) % 360;
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public static int c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
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
        return invokeZ.intValue;
    }

    public static Camera.Size d(Camera camera, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, camera, i, i2)) == null) {
            List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            Camera.Size size = null;
            Collections.sort(supportedPreviewSizes, new b(null));
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
        return (Camera.Size) invokeLII.objValue;
    }

    public static int e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
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
        return invokeL.intValue;
    }

    public static boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) {
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
        return invokeZ.booleanValue;
    }

    public static boolean g(PackageManager packageManager) {
        InterceptResult invokeL;
        FeatureInfo[] systemAvailableFeatures;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, packageManager)) == null) {
            if (packageManager != null && (systemAvailableFeatures = packageManager.getSystemAvailableFeatures()) != null) {
                for (FeatureInfo featureInfo : systemAvailableFeatures) {
                    if (featureInfo != null && "android.hardware.camera.flash".equals(featureInfo.name)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
