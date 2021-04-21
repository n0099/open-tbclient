package com.google.common.hash;

import com.google.common.hash.BloomFilterStrategies;
import com.google.common.primitives.SignedBytes;
import d.h.c.a.k;
import d.h.c.a.n;
import d.h.c.a.o;
import d.h.c.g.b;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
/* loaded from: classes6.dex */
public final class BloomFilter<T> implements o<T>, Serializable {
    public final BloomFilterStrategies.a bits;
    public final Funnel<? super T> funnel;
    public final int numHashFunctions;
    public final Strategy strategy;

    /* loaded from: classes6.dex */
    public static class SerialForm<T> implements Serializable {
        public static final long serialVersionUID = 1;
        public final long[] data;
        public final Funnel<? super T> funnel;
        public final int numHashFunctions;
        public final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.a.g(bloomFilter.bits.f31187a);
            this.numHashFunctions = bloomFilter.numHashFunctions;
            this.funnel = bloomFilter.funnel;
            this.strategy = bloomFilter.strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    /* loaded from: classes6.dex */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.a aVar);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i, double d2) {
        return create(funnel, i, d2);
    }

    public static long optimalNumOfBits(long j, double d2) {
        if (d2 == 0.0d) {
            d2 = Double.MIN_VALUE;
        }
        return (long) (((-j) * Math.log(d2)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    public static int optimalNumOfHashFunctions(long j, long j2) {
        return Math.max(1, (int) Math.round((j2 / j) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i;
        int i2;
        int readInt;
        n.q(inputStream, "InputStream");
        n.q(funnel, "Funnel");
        byte b2 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i2 = b.c(dataInputStream.readByte());
            } catch (RuntimeException e2) {
                e = e2;
                i2 = -1;
            }
            try {
                readInt = dataInputStream.readInt();
            } catch (RuntimeException e3) {
                e = e3;
                b2 = readByte;
                i = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b2) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
            try {
                BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                long[] jArr = new long[readInt];
                for (int i3 = 0; i3 < readInt; i3++) {
                    jArr[i3] = dataInputStream.readLong();
                }
                return new BloomFilter<>(new BloomFilterStrategies.a(jArr), i2, funnel, bloomFilterStrategies);
            } catch (RuntimeException e4) {
                e = e4;
                b2 = readByte;
                i = readInt;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b2) + " numHashFunctions: " + i2 + " dataLength: " + i, e);
            }
        } catch (RuntimeException e5) {
            e = e5;
            i = -1;
            i2 = -1;
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // d.h.c.a.o
    @Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    public long approximateElementCount() {
        double b2 = this.bits.b();
        return d.h.c.f.a.c(((-Math.log1p(-(this.bits.a() / b2))) * b2) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    public long bitSize() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // d.h.c.a.o
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BloomFilter) {
            BloomFilter bloomFilter = (BloomFilter) obj;
            return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
        }
        return false;
    }

    public double expectedFpp() {
        return Math.pow(this.bits.a() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return k.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        n.p(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        n.p(bloomFilter);
        n.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        n.g(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
        n.i(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        n.l(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        n.l(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(b.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f31187a.length());
        for (int i = 0; i < this.bits.f31187a.length(); i++) {
            dataOutputStream.writeLong(this.bits.f31187a.get(i));
        }
    }

    public BloomFilter(BloomFilterStrategies.a aVar, int i, Funnel<? super T> funnel, Strategy strategy) {
        n.f(i > 0, "numHashFunctions (%s) must be > 0", i);
        n.f(i <= 255, "numHashFunctions (%s) must be <= 255", i);
        n.p(aVar);
        this.bits = aVar;
        this.numHashFunctions = i;
        n.p(funnel);
        this.funnel = funnel;
        n.p(strategy);
        this.strategy = strategy;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d2) {
        return create(funnel, j, d2, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d2, Strategy strategy) {
        n.p(funnel);
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        n.h(i >= 0, "Expected insertions (%s) must be >= 0", j);
        n.k(d2 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d2));
        n.k(d2 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d2));
        n.p(strategy);
        if (i == 0) {
            j = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j, d2);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.a(optimalNumOfBits), optimalNumOfHashFunctions(j, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e2);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i) {
        return create(funnel, i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j) {
        return create(funnel, j, 0.03d);
    }
}
