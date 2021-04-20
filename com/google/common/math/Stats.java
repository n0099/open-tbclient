package com.google.common.math;

import com.google.common.primitives.Doubles;
import d.g.c.a.j;
import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.f.b;
import d.g.c.f.f;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class Stats implements Serializable {
    public static final int BYTES = 40;
    public static final long serialVersionUID = 0;
    public final long count;
    public final double max;
    public final double mean;
    public final double min;
    public final double sumOfSquaresOfDeltas;

    public Stats(long j, double d2, double d3, double d4, double d5) {
        this.count = j;
        this.mean = d2;
        this.sumOfSquaresOfDeltas = d3;
        this.min = d4;
        this.max = d5;
    }

    public static Stats fromByteArray(byte[] bArr) {
        n.p(bArr);
        n.g(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        f fVar = new f();
        fVar.b(iterable);
        return fVar.h();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        n.p(byteBuffer);
        n.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object obj) {
        if (obj != null && Stats.class == obj.getClass()) {
            Stats stats = (Stats) obj;
            return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
        }
        return false;
    }

    public int hashCode() {
        return k.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        n.w(this.count != 0);
        return this.max;
    }

    public double mean() {
        n.w(this.count != 0);
        return this.mean;
    }

    public double min() {
        n.w(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        n.w(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return b.a(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        n.w(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return b.a(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            j.b b2 = j.b(this);
            b2.c("count", this.count);
            b2.a("mean", this.mean);
            b2.a("populationStandardDeviation", populationStandardDeviation());
            b2.a("min", this.min);
            b2.a("max", this.max);
            return b2.toString();
        }
        j.b b3 = j.b(this);
        b3.c("count", this.count);
        return b3.toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        n.p(byteBuffer);
        n.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
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

    public static Stats of(Iterator<? extends Number> it) {
        f fVar = new f();
        fVar.c(it);
        return fVar.h();
    }

    public static Stats of(double... dArr) {
        f fVar = new f();
        fVar.d(dArr);
        return fVar.h();
    }

    public static double meanOf(double... dArr) {
        n.d(dArr.length > 0);
        double d2 = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d3 = dArr[i];
            d2 = (Doubles.f(d3) && Doubles.f(d2)) ? d2 + ((d3 - d2) / (i + 1)) : f.g(d2, d3);
        }
        return d2;
    }

    public static Stats of(int... iArr) {
        f fVar = new f();
        fVar.e(iArr);
        return fVar.h();
    }

    public static Stats of(long... jArr) {
        f fVar = new f();
        fVar.f(jArr);
        return fVar.h();
    }

    public static double meanOf(int... iArr) {
        n.d(iArr.length > 0);
        double d2 = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d3 = iArr[i];
            d2 = (Doubles.f(d3) && Doubles.f(d2)) ? d2 + ((d3 - d2) / (i + 1)) : f.g(d2, d3);
        }
        return d2;
    }

    public static double meanOf(long... jArr) {
        n.d(jArr.length > 0);
        double d2 = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d3 = jArr[i];
            d2 = (Doubles.f(d3) && Doubles.f(d2)) ? d2 + ((d3 - d2) / (i + 1)) : f.g(d2, d3);
        }
        return d2;
    }
}
