package com.google.common.primitives;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.n;
import java.math.BigInteger;
/* loaded from: classes6.dex */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static /* synthetic */ Interceptable $ic;
    public static final UnsignedInteger MAX_VALUE;
    public static final UnsignedInteger ONE;
    public static final UnsignedInteger ZERO;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1282028083, "Lcom/google/common/primitives/UnsignedInteger;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1282028083, "Lcom/google/common/primitives/UnsignedInteger;");
                return;
            }
        }
        ZERO = fromIntBits(0);
        ONE = fromIntBits(1);
        MAX_VALUE = fromIntBits(-1);
    }

    public UnsignedInteger(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i2 & (-1);
    }

    public static UnsignedInteger fromIntBits(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? new UnsignedInteger(i2) : (UnsignedInteger) invokeI.objValue;
    }

    public static UnsignedInteger valueOf(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            n.h((4294967295L & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
            return fromIntBits((int) j);
        }
        return (UnsignedInteger) invokeJ.objValue;
    }

    public BigInteger bigIntegerValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? BigInteger.valueOf(longValue()) : (BigInteger) invokeV.objValue;
    }

    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unsignedInteger)) == null) {
            int i2 = this.value;
            n.p(unsignedInteger);
            return fromIntBits(UnsignedInts.b(i2, unsignedInteger.value));
        }
        return (UnsignedInteger) invokeL.objValue;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? longValue() : invokeV.doubleValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? (obj instanceof UnsignedInteger) && this.value == ((UnsignedInteger) obj).value : invokeL.booleanValue;
    }

    @Override // java.lang.Number
    public float floatValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (float) longValue() : invokeV.floatValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.value : invokeV.intValue;
    }

    @Override // java.lang.Number
    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.value : invokeV.intValue;
    }

    @Override // java.lang.Number
    public long longValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? UnsignedInts.f(this.value) : invokeV.longValue;
    }

    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, unsignedInteger)) == null) {
            int i2 = this.value;
            n.p(unsignedInteger);
            return fromIntBits(i2 - unsignedInteger.value);
        }
        return (UnsignedInteger) invokeL.objValue;
    }

    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, unsignedInteger)) == null) {
            int i2 = this.value;
            n.p(unsignedInteger);
            return fromIntBits(UnsignedInts.e(i2, unsignedInteger.value));
        }
        return (UnsignedInteger) invokeL.objValue;
    }

    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, unsignedInteger)) == null) {
            int i2 = this.value;
            n.p(unsignedInteger);
            return fromIntBits(i2 + unsignedInteger.value);
        }
        return (UnsignedInteger) invokeL.objValue;
    }

    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, unsignedInteger)) == null) {
            int i2 = this.value;
            n.p(unsignedInteger);
            return fromIntBits(i2 * unsignedInteger.value);
        }
        return (UnsignedInteger) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? toString(10) : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(UnsignedInteger unsignedInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unsignedInteger)) == null) {
            n.p(unsignedInteger);
            return UnsignedInts.a(this.value, unsignedInteger.value);
        }
        return invokeL.intValue;
    }

    public String toString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? UnsignedInts.g(this.value, i2) : (String) invokeI.objValue;
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bigInteger)) == null) {
            n.p(bigInteger);
            n.k(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
            return fromIntBits(bigInteger.intValue());
        }
        return (UnsignedInteger) invokeL.objValue;
    }

    public static UnsignedInteger valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? valueOf(str, 10) : (UnsignedInteger) invokeL.objValue;
    }

    public static UnsignedInteger valueOf(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) ? fromIntBits(UnsignedInts.d(str, i2)) : (UnsignedInteger) invokeLI.objValue;
    }
}
