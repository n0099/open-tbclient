package com.facebook.imagepipeline.animated.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class AnimatedDrawableUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRAME_DURATION_MS_FOR_MIN = 100;
    public static final int MIN_FRAME_DURATION_MS = 11;
    public transient /* synthetic */ FieldHolder $fh;

    public AnimatedDrawableUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isOutsideRange(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i2, i3, i4)) == null) {
            if (i2 == -1 || i3 == -1) {
                return true;
            }
            if (i2 <= i3) {
                if (i4 < i2 || i4 > i3) {
                    return true;
                }
            } else if (i4 < i2 && i4 > i3) {
                return true;
            }
            return false;
        }
        return invokeIII.booleanValue;
    }

    public void fixFrameDurations(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iArr) == null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (iArr[i2] < 11) {
                    iArr[i2] = 100;
                }
            }
        }
    }

    public int getFrameForTimestampMs(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, i2)) == null) {
            int binarySearch = Arrays.binarySearch(iArr, i2);
            return binarySearch < 0 ? ((-binarySearch) - 1) - 1 : binarySearch;
        }
        return invokeLI.intValue;
    }

    public int[] getFrameTimeStampsFromDurations(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr)) == null) {
            int[] iArr2 = new int[iArr.length];
            int i2 = 0;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = i2;
                i2 += iArr[i3];
            }
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public int getSizeOfBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bitmap)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i2 >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getWidth() * bitmap.getHeight() * 4;
        }
        return invokeL.intValue;
    }

    public int getTotalDurationFromFrameDurations(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iArr)) == null) {
            int i2 = 0;
            for (int i3 : iArr) {
                i2 += i3;
            }
            return i2;
        }
        return invokeL.intValue;
    }
}
