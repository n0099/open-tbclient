package com.google.zxing.pdf417.decoder.ec;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.pdf417.PDF417Common;
/* loaded from: classes10.dex */
public final class ModulusGF {
    public static /* synthetic */ Interceptable $ic;
    public static final ModulusGF PDF417_GF;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] expTable;
    public final int[] logTable;
    public final int modulus;
    public final ModulusPoly one;
    public final ModulusPoly zero;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-825236373, "Lcom/google/zxing/pdf417/decoder/ec/ModulusGF;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-825236373, "Lcom/google/zxing/pdf417/decoder/ec/ModulusGF;");
                return;
            }
        }
        PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    }

    public ModulusGF(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.modulus = i2;
        this.expTable = new int[i2];
        this.logTable = new int[i2];
        int i6 = 1;
        for (int i7 = 0; i7 < i2; i7++) {
            this.expTable[i7] = i6;
            i6 = (i6 * i3) % i2;
        }
        for (int i8 = 0; i8 < i2 - 1; i8++) {
            this.logTable[this.expTable[i8]] = i8;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    public int add(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? (i2 + i3) % this.modulus : invokeII.intValue;
    }

    public ModulusPoly buildMonomial(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (i2 >= 0) {
                if (i3 == 0) {
                    return this.zero;
                }
                int[] iArr = new int[i2 + 1];
                iArr[0] = i3;
                return new ModulusPoly(this, iArr);
            }
            throw new IllegalArgumentException();
        }
        return (ModulusPoly) invokeII.objValue;
    }

    public int exp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.expTable[i2] : invokeI.intValue;
    }

    public ModulusPoly getOne() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.one : (ModulusPoly) invokeV.objValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.modulus : invokeV.intValue;
    }

    public ModulusPoly getZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.zero : (ModulusPoly) invokeV.objValue;
    }

    public int inverse(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != 0) {
                return this.expTable[(this.modulus - this.logTable[i2]) - 1];
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
            return iArr[(iArr2[i2] + iArr2[i3]) % (this.modulus - 1)];
        }
        return invokeII.intValue;
    }

    public int subtract(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            int i4 = this.modulus;
            return ((i2 + i4) - i3) % i4;
        }
        return invokeII.intValue;
    }
}
