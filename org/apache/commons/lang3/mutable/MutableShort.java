package org.apache.commons.lang3.mutable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.math.NumberUtils;
/* loaded from: classes3.dex */
public class MutableShort extends Number implements Comparable<MutableShort>, Mutable<Number> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2135791679;
    public transient /* synthetic */ FieldHolder $fh;
    public short value;

    public MutableShort() {
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

    public void add(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Short.valueOf(s)}) == null) {
            this.value = (short) (this.value + s);
        }
    }

    public short addAndGet(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Short.valueOf(s)})) == null) {
            short s2 = (short) (this.value + s);
            this.value = s2;
            return s2;
        }
        return invokeCommon.shortValue;
    }

    public void decrement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.value = (short) (this.value - 1);
        }
    }

    public short decrementAndGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            short s = (short) (this.value - 1);
            this.value = s;
            return s;
        }
        return invokeV.shortValue;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.value : invokeV.doubleValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? (obj instanceof MutableShort) && this.value == ((MutableShort) obj).shortValue() : invokeL.booleanValue;
    }

    @Override // java.lang.Number
    public float floatValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.value : invokeV.floatValue;
    }

    public short getAndAdd(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Short.valueOf(s)})) == null) {
            short s2 = this.value;
            this.value = (short) (s + s2);
            return s2;
        }
        return invokeCommon.shortValue;
    }

    public short getAndDecrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            short s = this.value;
            this.value = (short) (s - 1);
            return s;
        }
        return invokeV.shortValue;
    }

    public short getAndIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            short s = this.value;
            this.value = (short) (s + 1);
            return s;
        }
        return invokeV.shortValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.value : invokeV.intValue;
    }

    public void increment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.value = (short) (this.value + 1);
        }
    }

    public short incrementAndGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            short s = (short) (this.value + 1);
            this.value = s;
            return s;
        }
        return invokeV.shortValue;
    }

    @Override // java.lang.Number
    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.value : invokeV.intValue;
    }

    @Override // java.lang.Number
    public long longValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.value : invokeV.longValue;
    }

    @Override // java.lang.Number
    public short shortValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.value : invokeV.shortValue;
    }

    public void subtract(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Short.valueOf(s)}) == null) {
            this.value = (short) (this.value - s);
        }
    }

    public Short toShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? Short.valueOf(shortValue()) : (Short) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? String.valueOf((int) this.value) : (String) invokeV.objValue;
    }

    public MutableShort(short s) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Short.valueOf(s)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.value = s;
    }

    public void add(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, number) == null) {
            this.value = (short) (this.value + number.shortValue());
        }
    }

    public short addAndGet(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, number)) == null) {
            short shortValue = (short) (this.value + number.shortValue());
            this.value = shortValue;
            return shortValue;
        }
        return invokeL.shortValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(MutableShort mutableShort) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mutableShort)) == null) ? NumberUtils.compare(this.value, mutableShort.value) : invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'java.lang.Short' to match base method */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public Number getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? Short.valueOf(this.value) : (Short) invokeV.objValue;
    }

    public void setValue(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Short.valueOf(s)}) == null) {
            this.value = s;
        }
    }

    public void subtract(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, number) == null) {
            this.value = (short) (this.value - number.shortValue());
        }
    }

    public short getAndAdd(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, number)) == null) {
            short s = this.value;
            this.value = (short) (number.shortValue() + s);
            return s;
        }
        return invokeL.shortValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, number) == null) {
            this.value = number.shortValue();
        }
    }

    public MutableShort(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {number};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = number.shortValue();
    }

    public MutableShort(String str) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.value = Short.parseShort(str);
    }
}
