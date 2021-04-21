package com.google.common.hash;

import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import d.h.c.a.n;
import d.h.c.d.i;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes6.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilterStrategies, com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            long asLong = Hashing.a().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!aVar.d(i5 % b2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilterStrategies, com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            long asLong = Hashing.a().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                z |= aVar.f(i5 % b2);
            }
            return z;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.d(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.d(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilterStrategies, com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            byte[] bytesInternal = Hashing.a().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i2 = 0; i2 < i; i2++) {
                if (!aVar.d((Long.MAX_VALUE & lowerEight) % b2)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilterStrategies, com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar) {
            long b2 = aVar.b();
            byte[] bytesInternal = Hashing.a().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= aVar.f((Long.MAX_VALUE & lowerEight) % b2);
                lowerEight += upperEight;
            }
            return z;
        }
    };

    @Override // com.google.common.hash.BloomFilter.Strategy
    public abstract /* synthetic */ <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a aVar);

    @Override // com.google.common.hash.BloomFilter.Strategy
    public abstract /* synthetic */ <T> boolean put(T t, Funnel<? super T> funnel, int i, a aVar);

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicLongArray f31187a;

        /* renamed from: b  reason: collision with root package name */
        public final i f31188b;

        public a(long j) {
            n.e(j > 0, "data length is zero!");
            this.f31187a = new AtomicLongArray(Ints.c(LongMath.a(j, 64L, RoundingMode.CEILING)));
            this.f31188b = LongAddables.a();
        }

        public static long[] g(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        public long a() {
            return this.f31188b.sum();
        }

        public long b() {
            return this.f31187a.length() * 64;
        }

        public a c() {
            return new a(g(this.f31187a));
        }

        public boolean d(long j) {
            return ((1 << ((int) j)) & this.f31187a.get((int) (j >>> 6))) != 0;
        }

        public void e(a aVar) {
            long j;
            long j2;
            boolean z;
            n.g(this.f31187a.length() == aVar.f31187a.length(), "BitArrays must be of equal length (%s != %s)", this.f31187a.length(), aVar.f31187a.length());
            for (int i = 0; i < this.f31187a.length(); i++) {
                long j3 = aVar.f31187a.get(i);
                while (true) {
                    j = this.f31187a.get(i);
                    j2 = j | j3;
                    if (j == j2) {
                        z = false;
                        break;
                    } else if (this.f31187a.compareAndSet(i, j, j2)) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.f31188b.add(Long.bitCount(j2) - Long.bitCount(j));
                }
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(g(this.f31187a), g(((a) obj).f31187a));
            }
            return false;
        }

        public boolean f(long j) {
            long j2;
            long j3;
            if (d(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.f31187a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.f31187a.compareAndSet(i, j2, j3));
            this.f31188b.increment();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(g(this.f31187a));
        }

        public a(long[] jArr) {
            n.e(jArr.length > 0, "data length is zero!");
            this.f31187a = new AtomicLongArray(jArr);
            this.f31188b = LongAddables.a();
            long j = 0;
            for (long j2 : jArr) {
                j += Long.bitCount(j2);
            }
            this.f31188b.add(j);
        }
    }
}
