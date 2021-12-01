package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public abstract class Random {
    public static final Default Default = new Default(null);
    public static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class Default extends Random implements Serializable {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes3.dex */
        public static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            public static final long serialVersionUID = 0;

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public Default() {
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i2) {
            return Random.defaultRandom.nextBits(i2);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int i2) {
            return Random.defaultRandom.nextBytes(i2);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d2) {
            return Random.defaultRandom.nextDouble(d2);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i2) {
            return Random.defaultRandom.nextInt(i2);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j2) {
            return Random.defaultRandom.nextLong(j2);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array, int i2, int i3) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.defaultRandom.nextBytes(array, i2, i3);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d2, double d3) {
            return Random.defaultRandom.nextDouble(d2, d3);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i2, int i3) {
            return Random.defaultRandom.nextInt(i2, i3);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j2, long j3) {
            return Random.defaultRandom.nextLong(j2, j3);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return random.nextBytes(bArr, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i2);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] nextBytes(byte[] array, int i2, int i3) {
        boolean z;
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        if (i2 >= 0 && length >= i2) {
            int length2 = array.length;
            if (i3 >= 0 && length2 >= i3) {
                z = true;
                if (z) {
                    throw new IllegalArgumentException(("fromIndex (" + i2 + ") or toIndex (" + i3 + ") are out of range: 0.." + array.length + '.').toString());
                }
                if (i2 <= i3) {
                    int i4 = (i3 - i2) / 4;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int nextInt = nextInt();
                        array[i2] = (byte) nextInt;
                        array[i2 + 1] = (byte) (nextInt >>> 8);
                        array[i2 + 2] = (byte) (nextInt >>> 16);
                        array[i2 + 3] = (byte) (nextInt >>> 24);
                        i2 += 4;
                    }
                    int i6 = i3 - i2;
                    int nextBits = nextBits(i6 * 8);
                    for (int i7 = 0; i7 < i6; i7++) {
                        array[i2 + i7] = (byte) (nextBits >>> (i7 * 8));
                    }
                    return array;
                }
                throw new IllegalArgumentException(("fromIndex (" + i2 + ") must be not greater than toIndex (" + i3 + ").").toString());
            }
        }
        z = false;
        if (z) {
        }
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 16777216;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public double nextDouble(double d2) {
        return nextDouble(0.0d, d2);
    }

    public int nextInt(int i2) {
        return nextInt(0, i2);
    }

    public long nextLong(long j2) {
        return nextLong(0L, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double nextDouble(double d2, double d3) {
        double nextDouble;
        RandomKt.checkRangeBounds(d2, d3);
        double d4 = d3 - d2;
        if (Double.isInfinite(d4)) {
            boolean z = true;
            if ((Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true) {
                if ((Double.isInfinite(d3) || Double.isNaN(d3)) ? false : false) {
                    double d5 = 2;
                    double nextDouble2 = nextDouble() * ((d3 / d5) - (d2 / d5));
                    nextDouble = d2 + nextDouble2 + nextDouble2;
                    return nextDouble < d3 ? Math.nextAfter(d3, Double.NEGATIVE_INFINITY) : nextDouble;
                }
            }
        }
        nextDouble = d2 + (nextDouble() * d4);
        if (nextDouble < d3) {
        }
    }

    public int nextInt(int i2, int i3) {
        int nextInt;
        int i4;
        int i5;
        RandomKt.checkRangeBounds(i2, i3);
        int i6 = i3 - i2;
        if (i6 > 0 || i6 == Integer.MIN_VALUE) {
            if (((-i6) & i6) == i6) {
                i5 = nextBits(RandomKt.fastLog2(i6));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i4 = nextInt % i6;
                } while ((nextInt - i4) + (i6 - 1) < 0);
                i5 = i4;
            }
            return i2 + i5;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i2 <= nextInt2 && i3 > nextInt2) {
                return nextInt2;
            }
        }
    }

    public long nextLong(long j2, long j3) {
        long nextLong;
        long j4;
        long j5;
        int nextInt;
        RandomKt.checkRangeBounds(j2, j3);
        long j6 = j3 - j2;
        if (j6 > 0) {
            if (((-j6) & j6) == j6) {
                int i2 = (int) j6;
                int i3 = (int) (j6 >>> 32);
                if (i2 != 0) {
                    nextInt = nextBits(RandomKt.fastLog2(i2));
                } else if (i3 == 1) {
                    nextInt = nextInt();
                } else {
                    j5 = (nextBits(RandomKt.fastLog2(i3)) << 32) + nextInt();
                }
                j5 = nextInt & 4294967295L;
            } else {
                do {
                    nextLong = nextLong() >>> 1;
                    j4 = nextLong % j6;
                } while ((nextLong - j4) + (j6 - 1) < 0);
                j5 = j4;
            }
            return j2 + j5;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j2 <= nextLong2 && j3 > nextLong2) {
                return nextLong2;
            }
        }
    }

    public byte[] nextBytes(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(int i2) {
        return nextBytes(new byte[i2]);
    }
}
