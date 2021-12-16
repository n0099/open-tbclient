package com.google.zxing.oned.rss;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
/* loaded from: classes3.dex */
public abstract class AbstractRSSReader extends OneDReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float MAX_AVG_VARIANCE = 0.2f;
    public static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    public static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    public static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] dataCharacterCounters;
    public final int[] decodeFinderCounters;
    public final int[] evenCounts;
    public final float[] evenRoundingErrors;
    public final int[] oddCounts;
    public final float[] oddRoundingErrors;

    public AbstractRSSReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.decodeFinderCounters = new int[4];
        int[] iArr = new int[8];
        this.dataCharacterCounters = iArr;
        this.oddRoundingErrors = new float[4];
        this.evenRoundingErrors = new float[4];
        this.oddCounts = new int[iArr.length / 2];
        this.evenCounts = new int[iArr.length / 2];
    }

    @Deprecated
    public static int count(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iArr)) == null) ? MathUtils.sum(iArr) : invokeL.intValue;
    }

    public static void decrement(int[] iArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, iArr, fArr) == null) {
            int i2 = 0;
            float f2 = fArr[0];
            for (int i3 = 1; i3 < iArr.length; i3++) {
                if (fArr[i3] < f2) {
                    f2 = fArr[i3];
                    i2 = i3;
                }
            }
            iArr[i2] = iArr[i2] - 1;
        }
    }

    public static void increment(int[] iArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, iArr, fArr) == null) {
            int i2 = 0;
            float f2 = fArr[0];
            for (int i3 = 1; i3 < iArr.length; i3++) {
                if (fArr[i3] > f2) {
                    f2 = fArr[i3];
                    i2 = i3;
                }
            }
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public static boolean isFinderPattern(int[] iArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr)) == null) {
            float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + i2) + iArr[3]);
            if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MIN_VALUE;
                for (int i5 : iArr) {
                    if (i5 > i4) {
                        i4 = i5;
                    }
                    if (i5 < i3) {
                        i3 = i5;
                    }
                }
                if (i4 < i3 * 10) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, iArr, iArr2)) == null) {
            for (int i2 = 0; i2 < iArr2.length; i2++) {
                if (OneDReader.patternMatchVariance(iArr, iArr2[i2], 0.45f) < 0.2f) {
                    return i2;
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLL.intValue;
    }

    public final int[] getDataCharacterCounters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dataCharacterCounters : (int[]) invokeV.objValue;
    }

    public final int[] getDecodeFinderCounters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.decodeFinderCounters : (int[]) invokeV.objValue;
    }

    public final int[] getEvenCounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.evenCounts : (int[]) invokeV.objValue;
    }

    public final float[] getEvenRoundingErrors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.evenRoundingErrors : (float[]) invokeV.objValue;
    }

    public final int[] getOddCounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.oddCounts : (int[]) invokeV.objValue;
    }

    public final float[] getOddRoundingErrors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.oddRoundingErrors : (float[]) invokeV.objValue;
    }
}
