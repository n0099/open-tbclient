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
/* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isOutsideRange(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i, i2, i3)) == null) {
            if (i == -1 || i2 == -1) {
                return true;
            }
            if (i <= i2) {
                if (i3 < i || i3 > i2) {
                    return true;
                }
            } else if (i3 < i && i3 > i2) {
                return true;
            }
            return false;
        }
        return invokeIII.booleanValue;
    }

    public void fixFrameDurations(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iArr) == null) {
            for (int i = 0; i < iArr.length; i++) {
                if (iArr[i] < 11) {
                    iArr[i] = 100;
                }
            }
        }
    }

    public int getFrameForTimestampMs(int[] iArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, i)) == null) {
            int binarySearch = Arrays.binarySearch(iArr, i);
            return binarySearch < 0 ? ((-binarySearch) - 1) - 1 : binarySearch;
        }
        return invokeLI.intValue;
    }

    public int[] getFrameTimeStampsFromDurations(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr)) == null) {
            int[] iArr2 = new int[iArr.length];
            int i = 0;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = i;
                i += iArr[i2];
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
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i >= 12) {
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
            int i = 0;
            for (int i2 : iArr) {
                i += i2;
            }
            return i;
        }
        return invokeL.intValue;
    }
}
