package com.repackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755367523, "Lcom/repackage/qu8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755367523, "Lcom/repackage/qu8;");
        }
    }

    public static int a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i, i2, i3)) == null) ? i > i3 ? i3 : i < i2 ? i2 : i : invokeIII.intValue;
    }

    public static int b(TbPageContext tbPageContext, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, tbPageContext, i)) == null) {
            int i3 = 0;
            try {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                int d = d(tbPageContext);
                if (cameraInfo.facing == 1) {
                    i3 = (cameraInfo.orientation + d) % 360;
                    i2 = (360 - i3) % 360;
                } else {
                    i2 = ((cameraInfo.orientation - d) + 360) % 360;
                }
                return i2;
            } catch (RuntimeException e) {
                w89.g(e);
                return i3;
            }
        }
        return invokeLI.intValue;
    }

    public static int c(Camera.Parameters parameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, parameters)) == null) {
            if (parameters == null) {
                return -1;
            }
            try {
                if (parameters.isZoomSupported()) {
                    return Math.min(parameters.getMaxZoom(), 40);
                }
                return -1;
            } catch (Exception e) {
                w89.g(e);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int d(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            int rotation = tbPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getRotation();
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

    public static void e(TbPageContext tbPageContext, int i, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65541, null, tbPageContext, i, matrix) == null) || matrix == null) {
            return;
        }
        matrix.setScale(1 == i ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(b(tbPageContext, i));
        matrix.postScale(p99.e() / 2000.0f, p99.d() / 2000.0f);
        matrix.postTranslate(p99.e() / 2.0f, p99.d() / 2.0f);
    }

    public static void f(RectF rectF, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, rectF, rect) == null) {
            rect.left = Math.round(rectF.left);
            rect.top = Math.round(rectF.top);
            rect.right = Math.round(rectF.right);
            rect.bottom = Math.round(rectF.bottom);
        }
    }

    public static void g(int i, int i2, Camera camera) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65543, null, i, i2, camera) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            int i4 = 0;
            if (i != 0) {
                if (i == 1) {
                    i4 = 90;
                } else if (i == 2) {
                    i4 = 180;
                } else if (i == 3) {
                    i4 = 270;
                }
            }
            if (cameraInfo.facing == 1) {
                i3 = (360 - ((cameraInfo.orientation + i4) % 360)) % 360;
            } else {
                i3 = ((cameraInfo.orientation - i4) + 360) % 360;
            }
            camera.setDisplayOrientation(i3);
        }
    }

    public static void h(TbPageContext tbPageContext, int i, Camera camera) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, tbPageContext, i, camera) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            int d = d(tbPageContext);
            if (cameraInfo.facing == 1) {
                i2 = (360 - ((cameraInfo.orientation + d) % 360)) % 360;
            } else {
                i2 = ((cameraInfo.orientation - d) + 360) % 360;
            }
            camera.setDisplayOrientation(i2);
        }
    }
}
