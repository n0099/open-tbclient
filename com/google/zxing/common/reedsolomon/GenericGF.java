package com.google.zxing.common.reedsolomon;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.DebugConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class GenericGF {
    public static /* synthetic */ Interceptable $ic;
    public static final GenericGF AZTEC_DATA_10;
    public static final GenericGF AZTEC_DATA_12;
    public static final GenericGF AZTEC_DATA_6;
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM;
    public static final GenericGF DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64;
    public static final GenericGF QR_CODE_FIELD_256;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] expTable;
    public final int generatorBase;
    public final int[] logTable;
    public final GenericGFPoly one;
    public final int primitive;
    public final int size;
    public final GenericGFPoly zero;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1666331830, "Lcom/google/zxing/common/reedsolomon/GenericGF;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1666331830, "Lcom/google/zxing/common/reedsolomon/GenericGF;");
                return;
            }
        }
        AZTEC_DATA_12 = new GenericGF(4201, 4096, 1);
        AZTEC_DATA_10 = new GenericGF(DebugConstants.HTTP_ERRCODE_VERSION_HIGH, 1024, 1);
        AZTEC_DATA_6 = new GenericGF(67, 64, 1);
        AZTEC_PARAM = new GenericGF(19, 16, 1);
        QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);
        GenericGF genericGF = new GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = genericGF;
        AZTEC_DATA_8 = genericGF;
        MAXICODE_FIELD_64 = AZTEC_DATA_6;
    }

    public GenericGF(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.primitive = i2;
        this.size = i3;
        this.generatorBase = i4;
        this.expTable = new int[i3];
        this.logTable = new int[i3];
        int i7 = 1;
        for (int i8 = 0; i8 < i3; i8++) {
            this.expTable[i8] = i7;
            i7 <<= 1;
            if (i7 >= i3) {
                i7 = (i7 ^ i2) & (i3 - 1);
            }
        }
        for (int i9 = 0; i9 < i3 - 1; i9++) {
            this.logTable[this.expTable[i9]] = i9;
        }
        this.zero = new GenericGFPoly(this, new int[]{0});
        this.one = new GenericGFPoly(this, new int[]{1});
    }

    public static int addOrSubtract(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? i2 ^ i3 : invokeII.intValue;
    }

    public GenericGFPoly buildMonomial(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            if (i2 >= 0) {
                if (i3 == 0) {
                    return this.zero;
                }
                int[] iArr = new int[i2 + 1];
                iArr[0] = i3;
                return new GenericGFPoly(this, iArr);
            }
            throw new IllegalArgumentException();
        }
        return (GenericGFPoly) invokeII.objValue;
    }

    public int exp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.expTable[i2] : invokeI.intValue;
    }

    public int getGeneratorBase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.generatorBase : invokeV.intValue;
    }

    public GenericGFPoly getOne() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.one : (GenericGFPoly) invokeV.objValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.size : invokeV.intValue;
    }

    public GenericGFPoly getZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.zero : (GenericGFPoly) invokeV.objValue;
    }

    public int inverse(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != 0) {
                return this.expTable[(this.size - this.logTable[i2]) - 1];
            }
            throw new ArithmeticException();
        }
        return invokeI.intValue;
    }

    public int log(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 != 0) {
                return this.logTable[i2];
            }
            throw new IllegalArgumentException();
        }
        return invokeI.intValue;
    }

    public int multiply(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            if (i2 == 0 || i3 == 0) {
                return 0;
            }
            int[] iArr = this.expTable;
            int[] iArr2 = this.logTable;
            return iArr[(iArr2[i2] + iArr2[i3]) % (this.size - 1)];
        }
        return invokeII.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "GF(0x" + Integer.toHexString(this.primitive) + ',' + this.size + ')';
        }
        return (String) invokeV.objValue;
    }
}
