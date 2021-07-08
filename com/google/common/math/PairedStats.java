package com.google.common.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.j;
import d.f.d.a.k;
import d.f.d.a.n;
import d.f.d.f.d;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public final class PairedStats implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BYTES = 88;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final double sumOfProductsOfDeltas;
    public final Stats xStats;
    public final Stats yStats;

    public PairedStats(Stats stats, Stats stats2, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {stats, stats2, Double.valueOf(d2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d2;
    }

    public static double ensureInUnitRange(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            if (d2 <= -1.0d) {
                return -1.0d;
            }
            return d2;
        }
        return invokeCommon.doubleValue;
    }

    public static double ensurePositive(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 > 0.0d) {
                return d2;
            }
            return Double.MIN_VALUE;
        }
        return invokeCommon.doubleValue;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            n.p(bArr);
            n.g(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new PairedStats(Stats.readFrom(order), Stats.readFrom(order), order.getDouble());
        }
        return (PairedStats) invokeL.objValue;
    }

    public long count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.xStats.count() : invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj != null && PairedStats.class == obj.getClass()) {
                PairedStats pairedStats = (PairedStats) obj;
                return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k.b(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas)) : invokeV.intValue;
    }

    public d leastSquaresFit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n.w(count() > 1);
            if (Double.isNaN(this.sumOfProductsOfDeltas)) {
                return d.a();
            }
            double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
            if (sumOfSquaresOfDeltas > 0.0d) {
                if (this.yStats.sumOfSquaresOfDeltas() > 0.0d) {
                    return d.c(this.xStats.mean(), this.yStats.mean()).a(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
                }
                return d.b(this.yStats.mean());
            }
            n.w(this.yStats.sumOfSquaresOfDeltas() > 0.0d);
            return d.d(this.xStats.mean());
        }
        return (d) invokeV.objValue;
    }

    public double pearsonsCorrelationCoefficient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n.w(count() > 1);
            if (Double.isNaN(this.sumOfProductsOfDeltas)) {
                return Double.NaN;
            }
            double sumOfSquaresOfDeltas = xStats().sumOfSquaresOfDeltas();
            double sumOfSquaresOfDeltas2 = yStats().sumOfSquaresOfDeltas();
            n.w(sumOfSquaresOfDeltas > 0.0d);
            n.w(sumOfSquaresOfDeltas2 > 0.0d);
            return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
        }
        return invokeV.doubleValue;
    }

    public double populationCovariance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            n.w(count() != 0);
            return this.sumOfProductsOfDeltas / count();
        }
        return invokeV.doubleValue;
    }

    public double sampleCovariance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            n.w(count() > 1);
            return this.sumOfProductsOfDeltas / (count() - 1);
        }
        return invokeV.doubleValue;
    }

    public double sumOfProductsOfDeltas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.sumOfProductsOfDeltas : invokeV.doubleValue;
    }

    public byte[] toByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
            this.xStats.writeTo(order);
            this.yStats.writeTo(order);
            order.putDouble(this.sumOfProductsOfDeltas);
            return order.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (count() > 0) {
                j.b c2 = j.c(this);
                c2.d("xStats", this.xStats);
                c2.d("yStats", this.yStats);
                c2.a("populationCovariance", populationCovariance());
                return c2.toString();
            }
            j.b c3 = j.c(this);
            c3.d("xStats", this.xStats);
            c3.d("yStats", this.yStats);
            return c3.toString();
        }
        return (String) invokeV.objValue;
    }

    public Stats xStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.xStats : (Stats) invokeV.objValue;
    }

    public Stats yStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.yStats : (Stats) invokeV.objValue;
    }
}
