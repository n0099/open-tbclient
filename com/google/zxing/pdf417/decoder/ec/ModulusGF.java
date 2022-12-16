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
/* loaded from: classes8.dex */
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

    public ModulusPoly getOne() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.one;
        }
        return (ModulusPoly) invokeV.objValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.modulus;
        }
        return invokeV.intValue;
    }

    public ModulusPoly getZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.zero;
        }
        return (ModulusPoly) invokeV.objValue;
    }

    public ModulusGF(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.modulus = i;
        this.expTable = new int[i];
        this.logTable = new int[i];
        int i5 = 1;
        for (int i6 = 0; i6 < i; i6++) {
            this.expTable[i6] = i5;
            i5 = (i5 * i2) % i;
        }
        for (int i7 = 0; i7 < i - 1; i7++) {
            this.logTable[this.expTable[i7]] = i7;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    public int add(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            return (i + i2) % this.modulus;
        }
        return invokeII.intValue;
    }

    public ModulusPoly buildMonomial(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if (i >= 0) {
                if (i2 == 0) {
                    return this.zero;
                }
                int[] iArr = new int[i + 1];
                iArr[0] = i2;
                return new ModulusPoly(this, iArr);
            }
            throw new IllegalArgumentException();
        }
        return (ModulusPoly) invokeII.objValue;
    }

    public int multiply(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            if (i != 0 && i2 != 0) {
                int[] iArr = this.expTable;
                int[] iArr2 = this.logTable;
                return iArr[(iArr2[i] + iArr2[i2]) % (this.modulus - 1)];
            }
            return 0;
        }
        return invokeII.intValue;
    }

    public int subtract(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            int i3 = this.modulus;
            return ((i + i3) - i2) % i3;
        }
        return invokeII.intValue;
    }

    public int exp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.expTable[i];
        }
        return invokeI.intValue;
    }

    public int inverse(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i != 0) {
                return this.expTable[(this.modulus - this.logTable[i]) - 1];
            }
            throw new ArithmeticException();
        }
        return invokeI.intValue;
    }

    public int log(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i != 0) {
                return this.logTable[i];
            }
            throw new IllegalArgumentException();
        }
        return invokeI.intValue;
    }
}
