package org.apache.commons.lang3.mutable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.math.NumberUtils;
/* loaded from: classes2.dex */
public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1585823265;
    public transient /* synthetic */ FieldHolder $fh;
    public byte value;

    public MutableByte() {
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

    public void add(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048576, this, b2) == null) {
            this.value = (byte) (this.value + b2);
        }
    }

    public byte addAndGet(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2)) == null) {
            byte b3 = (byte) (this.value + b2);
            this.value = b3;
            return b3;
        }
        return invokeB.byteValue;
    }

    @Override // java.lang.Number
    public byte byteValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.value : invokeV.byteValue;
    }

    public void decrement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.value = (byte) (this.value - 1);
        }
    }

    public byte decrementAndGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            byte b2 = (byte) (this.value - 1);
            this.value = b2;
            return b2;
        }
        return invokeV.byteValue;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.value : invokeV.doubleValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) ? (obj instanceof MutableByte) && this.value == ((MutableByte) obj).byteValue() : invokeL.booleanValue;
    }

    @Override // java.lang.Number
    public float floatValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.value : invokeV.floatValue;
    }

    public byte getAndAdd(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048588, this, b2)) == null) {
            byte b3 = this.value;
            this.value = (byte) (b2 + b3);
            return b3;
        }
        return invokeB.byteValue;
    }

    public byte getAndDecrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            byte b2 = this.value;
            this.value = (byte) (b2 - 1);
            return b2;
        }
        return invokeV.byteValue;
    }

    public byte getAndIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            byte b2 = this.value;
            this.value = (byte) (b2 + 1);
            return b2;
        }
        return invokeV.byteValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.value : invokeV.intValue;
    }

    public void increment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.value = (byte) (this.value + 1);
        }
    }

    public byte incrementAndGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            byte b2 = (byte) (this.value + 1);
            this.value = b2;
            return b2;
        }
        return invokeV.byteValue;
    }

    @Override // java.lang.Number
    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.value : invokeV.intValue;
    }

    @Override // java.lang.Number
    public long longValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.value : invokeV.longValue;
    }

    public void subtract(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048602, this, b2) == null) {
            this.value = (byte) (this.value - b2);
        }
    }

    public Byte toByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? Byte.valueOf(byteValue()) : (Byte) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? String.valueOf((int) this.value) : (String) invokeV.objValue;
    }

    public MutableByte(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Byte.valueOf(b2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = b2;
    }

    public void add(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, number) == null) {
            this.value = (byte) (this.value + number.byteValue());
        }
    }

    public byte addAndGet(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, number)) == null) {
            byte byteValue = (byte) (this.value + number.byteValue());
            this.value = byteValue;
            return byteValue;
        }
        return invokeL.byteValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(MutableByte mutableByte) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mutableByte)) == null) ? NumberUtils.compare(this.value, mutableByte.value) : invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'java.lang.Byte' to match base method */
    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? Byte.valueOf(this.value) : (Byte) invokeV.objValue;
    }

    public void setValue(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048599, this, b2) == null) {
            this.value = b2;
        }
    }

    public void subtract(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, number) == null) {
            this.value = (byte) (this.value - number.byteValue());
        }
    }

    public byte getAndAdd(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, number)) == null) {
            byte b2 = this.value;
            this.value = (byte) (number.byteValue() + b2);
            return b2;
        }
        return invokeL.byteValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, number) == null) {
            this.value = number.byteValue();
        }
    }

    public MutableByte(Number number) {
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
        this.value = number.byteValue();
    }

    public MutableByte(String str) throws NumberFormatException {
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
        this.value = Byte.parseByte(str);
    }
}
