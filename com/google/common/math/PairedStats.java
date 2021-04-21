package com.google.common.math;

import d.h.c.a.j;
import d.h.c.a.k;
import d.h.c.a.n;
import d.h.c.f.d;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public final class PairedStats implements Serializable {
    public static final int BYTES = 88;
    public static final long serialVersionUID = 0;
    public final double sumOfProductsOfDeltas;
    public final Stats xStats;
    public final Stats yStats;

    public PairedStats(Stats stats, Stats stats2, double d2) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d2;
    }

    public static double ensureInUnitRange(double d2) {
        if (d2 >= 1.0d) {
            return 1.0d;
        }
        if (d2 <= -1.0d) {
            return -1.0d;
        }
        return d2;
    }

    public static double ensurePositive(double d2) {
        if (d2 > 0.0d) {
            return d2;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        n.p(bArr);
        n.g(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(order), Stats.readFrom(order), order.getDouble());
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(Object obj) {
        if (obj != null && PairedStats.class == obj.getClass()) {
            PairedStats pairedStats = (PairedStats) obj;
            return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
        }
        return false;
    }

    public int hashCode() {
        return k.b(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas));
    }

    public d leastSquaresFit() {
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

    public double pearsonsCorrelationCoefficient() {
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

    public double populationCovariance() {
        n.w(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        n.w(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(order);
        this.yStats.writeTo(order);
        order.putDouble(this.sumOfProductsOfDeltas);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            j.b b2 = j.b(this);
            b2.d("xStats", this.xStats);
            b2.d("yStats", this.yStats);
            b2.a("populationCovariance", populationCovariance());
            return b2.toString();
        }
        j.b b3 = j.b(this);
        b3.d("xStats", this.xStats);
        b3.d("yStats", this.yStats);
        return b3.toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
