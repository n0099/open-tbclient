package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.ImmutableLongArray;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes6.dex */
public class AtomicDoubleArray implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient AtomicLongArray longs;

    public AtomicDoubleArray(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.longs = new AtomicLongArray(i2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            int readInt = objectInputStream.readInt();
            ImmutableLongArray.b builder = ImmutableLongArray.builder();
            for (int i2 = 0; i2 < readInt; i2++) {
                builder.a(Double.doubleToRawLongBits(objectInputStream.readDouble()));
            }
            this.longs = new AtomicLongArray(builder.d().toArray());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            int length = length();
            objectOutputStream.writeInt(length);
            for (int i2 = 0; i2 < length; i2++) {
                objectOutputStream.writeDouble(get(i2));
            }
        }
    }

    public double addAndGet(int i2, double d2) {
        long j;
        double longBitsToDouble;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) {
            do {
                j = this.longs.get(i2);
                longBitsToDouble = Double.longBitsToDouble(j) + d2;
            } while (!this.longs.compareAndSet(i2, j, Double.doubleToRawLongBits(longBitsToDouble)));
            return longBitsToDouble;
        }
        return invokeCommon.doubleValue;
    }

    public final boolean compareAndSet(int i2, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3)})) == null) ? this.longs.compareAndSet(i2, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3)) : invokeCommon.booleanValue;
    }

    public final double get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? Double.longBitsToDouble(this.longs.get(i2)) : invokeI.doubleValue;
    }

    public final double getAndAdd(int i2, double d2) {
        long j;
        double longBitsToDouble;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) {
            do {
                j = this.longs.get(i2);
                longBitsToDouble = Double.longBitsToDouble(j);
            } while (!this.longs.compareAndSet(i2, j, Double.doubleToRawLongBits(longBitsToDouble + d2)));
            return longBitsToDouble;
        }
        return invokeCommon.doubleValue;
    }

    public final double getAndSet(int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) ? Double.longBitsToDouble(this.longs.getAndSet(i2, Double.doubleToRawLongBits(d2))) : invokeCommon.doubleValue;
    }

    public final void lazySet(int i2, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)}) == null) {
            this.longs.lazySet(i2, Double.doubleToRawLongBits(d2));
        }
    }

    public final int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.longs.length() : invokeV.intValue;
    }

    public final void set(int i2, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)}) == null) {
            this.longs.set(i2, Double.doubleToRawLongBits(d2));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) != null) {
            return (String) invokeV.objValue;
        }
        int length = length() - 1;
        if (length == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder((length + 1) * 19);
        sb.append('[');
        int i2 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.longs.get(i2)));
            if (i2 == length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(' ');
            i2++;
        }
    }

    public final boolean weakCompareAndSet(int i2, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3)})) == null) ? this.longs.weakCompareAndSet(i2, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3)) : invokeCommon.booleanValue;
    }

    public AtomicDoubleArray(double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i4 = 0; i4 < length; i4++) {
            jArr[i4] = Double.doubleToRawLongBits(dArr[i4]);
        }
        this.longs = new AtomicLongArray(jArr);
    }
}
