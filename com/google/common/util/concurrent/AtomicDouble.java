package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class AtomicDouble extends Number implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient AtomicLong value;

    public AtomicDouble(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = new AtomicLong(Double.doubleToRawLongBits(d2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            this.value = new AtomicLong();
            set(objectInputStream.readDouble());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeDouble(get());
        }
    }

    public final double addAndGet(double d2) {
        long j;
        double longBitsToDouble;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) {
            do {
                j = this.value.get();
                longBitsToDouble = Double.longBitsToDouble(j) + d2;
            } while (!this.value.compareAndSet(j, Double.doubleToRawLongBits(longBitsToDouble)));
            return longBitsToDouble;
        }
        return invokeCommon.doubleValue;
    }

    public final boolean compareAndSet(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? this.value.compareAndSet(Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3)) : invokeCommon.booleanValue;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? get() : invokeV.doubleValue;
    }

    @Override // java.lang.Number
    public float floatValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (float) get() : invokeV.floatValue;
    }

    public final double get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Double.longBitsToDouble(this.value.get()) : invokeV.doubleValue;
    }

    public final double getAndAdd(double d2) {
        long j;
        double longBitsToDouble;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d2)})) == null) {
            do {
                j = this.value.get();
                longBitsToDouble = Double.longBitsToDouble(j);
            } while (!this.value.compareAndSet(j, Double.doubleToRawLongBits(longBitsToDouble + d2)));
            return longBitsToDouble;
        }
        return invokeCommon.doubleValue;
    }

    public final double getAndSet(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)})) == null) ? Double.longBitsToDouble(this.value.getAndSet(Double.doubleToRawLongBits(d2))) : invokeCommon.doubleValue;
    }

    @Override // java.lang.Number
    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (int) get() : invokeV.intValue;
    }

    public final void lazySet(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.value.lazySet(Double.doubleToRawLongBits(d2));
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (long) get() : invokeV.longValue;
    }

    public final void set(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.value.set(Double.doubleToRawLongBits(d2));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Double.toString(get()) : (String) invokeV.objValue;
    }

    public final boolean weakCompareAndSet(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? this.value.weakCompareAndSet(Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3)) : invokeCommon.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AtomicDouble() {
        this(0.0d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Double) newInitContext.callArgs[0]).doubleValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
