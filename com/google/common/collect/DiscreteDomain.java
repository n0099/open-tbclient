package com.google.common.collect;

import com.google.common.primitives.Ints;
import d.h.c.a.n;
import d.h.c.c.m;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class DiscreteDomain<C extends Comparable> {
    public final boolean supportsFastOffset;

    /* loaded from: classes6.dex */
    public static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        public static final BigIntegerDomain f30850e = new BigIntegerDomain();

        /* renamed from: f  reason: collision with root package name */
        public static final BigInteger f30851f = BigInteger.valueOf(Long.MIN_VALUE);

        /* renamed from: g  reason: collision with root package name */
        public static final BigInteger f30852g = BigInteger.valueOf(Long.MAX_VALUE);
        public static final long serialVersionUID = 0;

        public BigIntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f30850e;
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(f30851f).min(f30852g).longValue();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger next(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger offset(BigInteger bigInteger, long j) {
            m.c(j, "distance");
            return bigInteger.add(BigInteger.valueOf(j));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger previous(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }
    }

    /* loaded from: classes6.dex */
    public static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        public static final IntegerDomain f30853e = new IntegerDomain();
        public static final long serialVersionUID = 0;

        public IntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f30853e;
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer next(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue + 1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer offset(Integer num, long j) {
            m.c(j, "distance");
            return Integer.valueOf(Ints.c(num.longValue() + j));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer previous(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue - 1);
        }
    }

    /* loaded from: classes6.dex */
    public static final class LongDomain extends DiscreteDomain<Long> implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        public static final LongDomain f30854e = new LongDomain();
        public static final long serialVersionUID = 0;

        public LongDomain() {
            super(true);
        }

        private Object readResolve() {
            return f30854e;
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(Long l, Long l2) {
            long longValue = l2.longValue() - l.longValue();
            if (l2.longValue() <= l.longValue() || longValue >= 0) {
                if (l2.longValue() >= l.longValue() || longValue <= 0) {
                    return longValue;
                }
                return Long.MIN_VALUE;
            }
            return Long.MAX_VALUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long next(Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(longValue + 1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long offset(Long l, long j) {
            m.c(j, "distance");
            long longValue = l.longValue() + j;
            if (longValue < 0) {
                n.e(l.longValue() < 0, "overflow");
            }
            return Long.valueOf(longValue);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long previous(Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(longValue - 1);
        }
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.f30850e;
    }

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.f30853e;
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.f30854e;
    }

    public abstract long distance(C c2, C c3);

    public C maxValue() {
        throw new NoSuchElementException();
    }

    public C minValue() {
        throw new NoSuchElementException();
    }

    public abstract C next(C c2);

    public abstract C offset(C c2, long j);

    public abstract C previous(C c2);

    public DiscreteDomain() {
        this(false);
    }

    public DiscreteDomain(boolean z) {
        this.supportsFastOffset = z;
    }
}
