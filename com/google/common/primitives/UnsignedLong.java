package com.google.common.primitives;

import androidx.core.view.InputDeviceCompat;
import b.h.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes11.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final UnsignedLong MAX_VALUE;
    public static final UnsignedLong ONE;
    public static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO;
    public transient /* synthetic */ FieldHolder $fh;
    public final long value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1281539119, "Lcom/google/common/primitives/UnsignedLong;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1281539119, "Lcom/google/common/primitives/UnsignedLong;");
                return;
            }
        }
        ZERO = new UnsignedLong(0L);
        ONE = new UnsignedLong(1L);
        MAX_VALUE = new UnsignedLong(-1L);
    }

    public UnsignedLong(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = j;
    }

    public static UnsignedLong fromLongBits(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? new UnsignedLong(j) : (UnsignedLong) invokeJ.objValue;
    }

    public static UnsignedLong valueOf(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            n.h(j >= 0, "value (%s) is outside the range for an unsigned long value", j);
            return fromLongBits(j);
        }
        return (UnsignedLong) invokeJ.objValue;
    }

    public BigInteger bigIntegerValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
            return this.value < 0 ? valueOf.setBit(63) : valueOf;
        }
        return (BigInteger) invokeV.objValue;
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unsignedLong)) == null) {
            long j = this.value;
            n.p(unsignedLong);
            return fromLongBits(UnsignedLongs.b(j, unsignedLong.value));
        }
        return (UnsignedLong) invokeL.objValue;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long j = this.value;
            double d2 = Long.MAX_VALUE & j;
            return j < 0 ? d2 + 9.223372036854776E18d : d2;
        }
        return invokeV.doubleValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value : invokeL.booleanValue;
    }

    @Override // java.lang.Number
    public float floatValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long j = this.value;
            float f2 = (float) (Long.MAX_VALUE & j);
            return j < 0 ? f2 + 9.223372E18f : f2;
        }
        return invokeV.floatValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Longs.e(this.value) : invokeV.intValue;
    }

    @Override // java.lang.Number
    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) this.value : invokeV.intValue;
    }

    @Override // java.lang.Number
    public long longValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.value : invokeV.longValue;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, unsignedLong)) == null) {
            long j = this.value;
            n.p(unsignedLong);
            return fromLongBits(j - unsignedLong.value);
        }
        return (UnsignedLong) invokeL.objValue;
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, unsignedLong)) == null) {
            long j = this.value;
            n.p(unsignedLong);
            return fromLongBits(UnsignedLongs.e(j, unsignedLong.value));
        }
        return (UnsignedLong) invokeL.objValue;
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, unsignedLong)) == null) {
            long j = this.value;
            n.p(unsignedLong);
            return fromLongBits(j + unsignedLong.value);
        }
        return (UnsignedLong) invokeL.objValue;
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, unsignedLong)) == null) {
            long j = this.value;
            n.p(unsignedLong);
            return fromLongBits(j * unsignedLong.value);
        }
        return (UnsignedLong) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? UnsignedLongs.f(this.value) : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unsignedLong)) == null) {
            n.p(unsignedLong);
            return UnsignedLongs.a(this.value, unsignedLong.value);
        }
        return invokeL.intValue;
    }

    public String toString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? UnsignedLongs.g(this.value, i2) : (String) invokeI.objValue;
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bigInteger)) == null) {
            n.p(bigInteger);
            n.k(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
            return fromLongBits(bigInteger.longValue());
        }
        return (UnsignedLong) invokeL.objValue;
    }

    public static UnsignedLong valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? valueOf(str, 10) : (UnsignedLong) invokeL.objValue;
    }

    public static UnsignedLong valueOf(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) ? fromLongBits(UnsignedLongs.d(str, i2)) : (UnsignedLong) invokeLI.objValue;
    }
}
