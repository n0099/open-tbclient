package com.google.zxing.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
/* loaded from: classes6.dex */
public abstract class GridSampler {
    public static /* synthetic */ Interceptable $ic;
    public static GridSampler gridSampler;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-985492874, "Lcom/google/zxing/common/GridSampler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-985492874, "Lcom/google/zxing/common/GridSampler;");
                return;
            }
        }
        gridSampler = new DefaultGridSampler();
    }

    public GridSampler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void checkAndNudgePoints(BitMatrix bitMatrix, float[] fArr) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bitMatrix, fArr) == null) {
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            boolean z = true;
            for (int i2 = 0; i2 < fArr.length && z; i2 += 2) {
                int i3 = (int) fArr[i2];
                int i4 = i2 + 1;
                int i5 = (int) fArr[i4];
                if (i3 < -1 || i3 > width || i5 < -1 || i5 > height) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i3 == -1) {
                    fArr[i2] = 0.0f;
                } else if (i3 == width) {
                    fArr[i2] = width - 1;
                } else {
                    z = false;
                    if (i5 != -1) {
                        fArr[i4] = 0.0f;
                    } else if (i5 == height) {
                        fArr[i4] = height - 1;
                    }
                    z = true;
                }
                z = true;
                if (i5 != -1) {
                }
                z = true;
            }
            boolean z2 = true;
            for (int length = fArr.length - 2; length >= 0 && z2; length -= 2) {
                int i6 = (int) fArr[length];
                int i7 = length + 1;
                int i8 = (int) fArr[i7];
                if (i6 < -1 || i6 > width || i8 < -1 || i8 > height) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i6 == -1) {
                    fArr[length] = 0.0f;
                } else if (i6 == width) {
                    fArr[length] = width - 1;
                } else {
                    z2 = false;
                    if (i8 != -1) {
                        fArr[i7] = 0.0f;
                    } else if (i8 == height) {
                        fArr[i7] = height - 1;
                    }
                    z2 = true;
                }
                z2 = true;
                if (i8 != -1) {
                }
                z2 = true;
            }
        }
    }

    public static GridSampler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? gridSampler : (GridSampler) invokeV.objValue;
    }

    public static void setGridSampler(GridSampler gridSampler2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gridSampler2) == null) {
            gridSampler = gridSampler2;
        }
    }

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, PerspectiveTransform perspectiveTransform) throws NotFoundException;
}
