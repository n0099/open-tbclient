package com.google.common.math;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.j;
import b.i.d.a.k;
import b.i.d.a.n;
import b.i.d.f.b;
import b.i.d.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class Stats implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BYTES = 40;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final long count;
    public final double max;
    public final double mean;
    public final double min;
    public final double sumOfSquaresOfDeltas;

    public Stats(long j, double d2, double d3, double d4, double d5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.count = j;
        this.mean = d2;
        this.sumOfSquaresOfDeltas = d3;
        this.min = d4;
        this.max = d5;
    }

    public static Stats fromByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            n.p(bArr);
            n.g(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
            return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
        }
        return (Stats) invokeL.objValue;
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iterable)) == null) ? meanOf(iterable.iterator()) : invokeL.doubleValue;
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            f fVar = new f();
            fVar.b(iterable);
            return fVar.h();
        }
        return (Stats) invokeL.objValue;
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, byteBuffer)) == null) {
            n.p(byteBuffer);
            n.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
            return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
        }
        return (Stats) invokeL.objValue;
    }

    public long count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.count : invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj != null && Stats.class == obj.getClass()) {
                Stats stats = (Stats) obj;
                return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)) : invokeV.intValue;
    }

    public double max() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n.w(this.count != 0);
            return this.max;
        }
        return invokeV.doubleValue;
    }

    public double mean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n.w(this.count != 0);
            return this.mean;
        }
        return invokeV.doubleValue;
    }

    public double min() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            n.w(this.count != 0);
            return this.min;
        }
        return invokeV.doubleValue;
    }

    public double populationStandardDeviation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Math.sqrt(populationVariance()) : invokeV.doubleValue;
    }

    public double populationVariance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            n.w(this.count > 0);
            if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
                return Double.NaN;
            }
            if (this.count == 1) {
                return 0.0d;
            }
            return b.a(this.sumOfSquaresOfDeltas) / count();
        }
        return invokeV.doubleValue;
    }

    public double sampleStandardDeviation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Math.sqrt(sampleVariance()) : invokeV.doubleValue;
    }

    public double sampleVariance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            n.w(this.count > 1);
            if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
                return Double.NaN;
            }
            return b.a(this.sumOfSquaresOfDeltas) / (this.count - 1);
        }
        return invokeV.doubleValue;
    }

    public double sum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mean * this.count : invokeV.doubleValue;
    }

    public double sumOfSquaresOfDeltas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.sumOfSquaresOfDeltas : invokeV.doubleValue;
    }

    public byte[] toByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
            writeTo(order);
            return order.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (count() > 0) {
                j.b c2 = j.c(this);
                c2.c("count", this.count);
                c2.a("mean", this.mean);
                c2.a("populationStandardDeviation", populationStandardDeviation());
                c2.a("min", this.min);
                c2.a("max", this.max);
                return c2.toString();
            }
            j.b c3 = j.c(this);
            c3.c("count", this.count);
            return c3.toString();
        }
        return (String) invokeV.objValue;
    }

    public void writeTo(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, byteBuffer) == null) {
            n.p(byteBuffer);
            n.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
            byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
        }
    }

    public static double meanOf(Iterator<? extends Number> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, it)) == null) {
            n.d(it.hasNext());
            double doubleValue = it.next().doubleValue();
            long j = 1;
            while (it.hasNext()) {
                double doubleValue2 = it.next().doubleValue();
                j++;
                doubleValue = (Doubles.f(doubleValue2) && Doubles.f(doubleValue)) ? doubleValue + ((doubleValue2 - doubleValue) / j) : f.g(doubleValue, doubleValue2);
            }
            return doubleValue;
        }
        return invokeL.doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, it)) == null) {
            f fVar = new f();
            fVar.c(it);
            return fVar.h();
        }
        return (Stats) invokeL.objValue;
    }

    public static Stats of(double... dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, dArr)) == null) {
            f fVar = new f();
            fVar.d(dArr);
            return fVar.h();
        }
        return (Stats) invokeL.objValue;
    }

    public static double meanOf(double... dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dArr)) == null) {
            n.d(dArr.length > 0);
            double d2 = dArr[0];
            for (int i2 = 1; i2 < dArr.length; i2++) {
                double d3 = dArr[i2];
                d2 = (Doubles.f(d3) && Doubles.f(d2)) ? d2 + ((d3 - d2) / (i2 + 1)) : f.g(d2, d3);
            }
            return d2;
        }
        return invokeL.doubleValue;
    }

    public static Stats of(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iArr)) == null) {
            f fVar = new f();
            fVar.e(iArr);
            return fVar.h();
        }
        return (Stats) invokeL.objValue;
    }

    public static Stats of(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jArr)) == null) {
            f fVar = new f();
            fVar.f(jArr);
            return fVar.h();
        }
        return (Stats) invokeL.objValue;
    }

    public static double meanOf(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, iArr)) == null) {
            n.d(iArr.length > 0);
            double d2 = iArr[0];
            for (int i2 = 1; i2 < iArr.length; i2++) {
                double d3 = iArr[i2];
                d2 = (Doubles.f(d3) && Doubles.f(d2)) ? d2 + ((d3 - d2) / (i2 + 1)) : f.g(d2, d3);
            }
            return d2;
        }
        return invokeL.doubleValue;
    }

    public static double meanOf(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jArr)) == null) {
            n.d(jArr.length > 0);
            double d2 = jArr[0];
            for (int i2 = 1; i2 < jArr.length; i2++) {
                double d3 = jArr[i2];
                d2 = (Doubles.f(d3) && Doubles.f(d2)) ? d2 + ((d3 - d2) / (i2 + 1)) : f.g(d2, d3);
            }
            return d2;
        }
        return invokeL.doubleValue;
    }
}
