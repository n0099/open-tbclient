package com.google.zxing.qrcode.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class ErrorCorrectionLevel {
    public static final /* synthetic */ ErrorCorrectionLevel[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ErrorCorrectionLevel[] FOR_BITS;
    public static final ErrorCorrectionLevel H;
    public static final ErrorCorrectionLevel L;
    public static final ErrorCorrectionLevel M;
    public static final ErrorCorrectionLevel Q;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bits;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593518856, "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593518856, "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;");
                return;
            }
        }
        L = new ErrorCorrectionLevel("L", 0, 1);
        M = new ErrorCorrectionLevel("M", 1, 0);
        Q = new ErrorCorrectionLevel("Q", 2, 3);
        ErrorCorrectionLevel errorCorrectionLevel = new ErrorCorrectionLevel("H", 3, 2);
        H = errorCorrectionLevel;
        ErrorCorrectionLevel errorCorrectionLevel2 = L;
        ErrorCorrectionLevel errorCorrectionLevel3 = M;
        ErrorCorrectionLevel errorCorrectionLevel4 = Q;
        $VALUES = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel3, errorCorrectionLevel4, errorCorrectionLevel};
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel3, errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4};
    }

    public ErrorCorrectionLevel(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bits = i2;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i >= 0) {
                ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
                if (i < errorCorrectionLevelArr.length) {
                    return errorCorrectionLevelArr[i];
                }
            }
            throw new IllegalArgumentException();
        }
        return (ErrorCorrectionLevel) invokeI.objValue;
    }

    public static ErrorCorrectionLevel valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (ErrorCorrectionLevel) Enum.valueOf(ErrorCorrectionLevel.class, str);
        }
        return (ErrorCorrectionLevel) invokeL.objValue;
    }

    public static ErrorCorrectionLevel[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (ErrorCorrectionLevel[]) $VALUES.clone();
        }
        return (ErrorCorrectionLevel[]) invokeV.objValue;
    }

    public int getBits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bits;
        }
        return invokeV.intValue;
    }
}
