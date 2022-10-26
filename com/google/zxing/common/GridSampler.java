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
/* loaded from: classes7.dex */
public abstract class GridSampler {
    public static /* synthetic */ Interceptable $ic;
    public static GridSampler gridSampler;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static GridSampler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return gridSampler;
        }
        return (GridSampler) invokeV.objValue;
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
            for (int i = 0; i < fArr.length && z; i += 2) {
                int i2 = (int) fArr[i];
                int i3 = i + 1;
                int i4 = (int) fArr[i3];
                if (i2 >= -1 && i2 <= width && i4 >= -1 && i4 <= height) {
                    if (i2 == -1) {
                        fArr[i] = 0.0f;
                    } else if (i2 == width) {
                        fArr[i] = width - 1;
                    } else {
                        z = false;
                        if (i4 != -1) {
                            fArr[i3] = 0.0f;
                        } else if (i4 == height) {
                            fArr[i3] = height - 1;
                        }
                        z = true;
                    }
                    z = true;
                    if (i4 != -1) {
                    }
                    z = true;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            boolean z2 = true;
            for (int length = fArr.length - 2; length >= 0 && z2; length -= 2) {
                int i5 = (int) fArr[length];
                int i6 = length + 1;
                int i7 = (int) fArr[i6];
                if (i5 >= -1 && i5 <= width && i7 >= -1 && i7 <= height) {
                    if (i5 == -1) {
                        fArr[length] = 0.0f;
                    } else if (i5 == width) {
                        fArr[length] = width - 1;
                    } else {
                        z2 = false;
                        if (i7 != -1) {
                            fArr[i6] = 0.0f;
                        } else if (i7 == height) {
                            fArr[i6] = height - 1;
                        }
                        z2 = true;
                    }
                    z2 = true;
                    if (i7 != -1) {
                    }
                    z2 = true;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    public static void setGridSampler(GridSampler gridSampler2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gridSampler2) == null) {
            gridSampler = gridSampler2;
        }
    }
}
