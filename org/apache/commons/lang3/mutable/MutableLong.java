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
public class MutableLong extends Number implements Comparable<MutableLong>, Mutable<Number> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 62986528375L;
    public transient /* synthetic */ FieldHolder $fh;
    public long value;

    public MutableLong() {
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

    public void add(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.value += j;
        }
    }

    public long addAndGet(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            long j2 = this.value + j;
            this.value = j2;
            return j2;
        }
        return invokeJ.longValue;
    }

    public void decrement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.value--;
        }
    }

    public long decrementAndGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long j = this.value - 1;
            this.value = j;
            return j;
        }
        return invokeV.longValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? (obj instanceof MutableLong) && this.value == ((MutableLong) obj).longValue() : invokeL.booleanValue;
    }

    @Override // java.lang.Number
    public float floatValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (float) this.value : invokeV.floatValue;
    }

    public long getAndAdd(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            long j2 = this.value;
            this.value = j + j2;
            return j2;
        }
        return invokeJ.longValue;
    }

    public long getAndDecrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            long j = this.value;
            this.value = j - 1;
            return j;
        }
        return invokeV.longValue;
    }

    public long getAndIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            long j = this.value;
            this.value = 1 + j;
            return j;
        }
        return invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            long j = this.value;
            return (int) (j ^ (j >>> 32));
        }
        return invokeV.intValue;
    }

    public void increment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.value++;
        }
    }

    public long incrementAndGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            long j = this.value + 1;
            this.value = j;
            return j;
        }
        return invokeV.longValue;
    }

    @Override // java.lang.Number
    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (int) this.value : invokeV.intValue;
    }

    @Override // java.lang.Number
    public long longValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.value : invokeV.longValue;
    }

    public void subtract(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.value -= j;
        }
    }

    public Long toLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? Long.valueOf(longValue()) : (Long) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? String.valueOf(this.value) : (String) invokeV.objValue;
    }

    public MutableLong(long j) {
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

    public void add(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, number) == null) {
            this.value += number.longValue();
        }
    }

    public long addAndGet(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, number)) == null) {
            long longValue = this.value + number.longValue();
            this.value = longValue;
            return longValue;
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(MutableLong mutableLong) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mutableLong)) == null) ? NumberUtils.compare(this.value, mutableLong.value) : invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'java.lang.Long' to match base method */
    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? Long.valueOf(this.value) : (Long) invokeV.objValue;
    }

    public void setValue(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.value = j;
        }
    }

    public void subtract(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, number) == null) {
            this.value -= number.longValue();
        }
    }

    public long getAndAdd(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, number)) == null) {
            long j = this.value;
            this.value = number.longValue() + j;
            return j;
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, number) == null) {
            this.value = number.longValue();
        }
    }

    public MutableLong(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {number};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.value = number.longValue();
    }

    public MutableLong(String str) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.value = Long.parseLong(str);
    }
}
