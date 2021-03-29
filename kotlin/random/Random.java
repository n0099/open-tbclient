package kotlin.random;

import com.baidu.android.common.others.IStringUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b'\u0018\u0000 %:\u0002&%B\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000eJ\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\n\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0015J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u001f\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010!J\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010\"¨\u0006'"}, d2 = {"Lkotlin/random/Random;", "", "bitCount", "nextBits", "(I)I", "", "nextBoolean", "()Z", "", "array", "nextBytes", "([B)[B", "fromIndex", "toIndex", "([BII)[B", "size", "(I)[B", "", "nextDouble", "()D", "until", "(D)D", "from", "(DD)D", "", "nextFloat", "()F", "nextInt", "()I", "(II)I", "", "nextLong", "()J", "(J)J", "(JJ)J", "<init>", "()V", "Default", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public abstract class Random {
    public static final Default Default = new Default(null);
    public static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    @JvmField
    public static final Companion Companion = Companion.INSTANCE;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Default companion object instead")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "", "bitCount", "nextBits", "(I)I", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion extends Random {
        public static final Companion INSTANCE = new Companion();

        @Override // kotlin.random.Random
        public int nextBits(int i) {
            return Random.Default.nextBits(i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010(J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0016J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u001f\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010\"J\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010#R\u001c\u0010%\u001a\u00020$8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u0012\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "", "bitCount", "nextBits", "(I)I", "", "nextBoolean", "()Z", "", "array", "nextBytes", "([B)[B", "fromIndex", "toIndex", "([BII)[B", "size", "(I)[B", "", "nextDouble", "()D", "until", "(D)D", "from", "(DD)D", "", "nextFloat", "()F", "nextInt", "()I", "(II)I", "", "nextLong", "()J", "(J)J", "(JJ)J", "Lkotlin/random/Random$Companion;", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "()V", "defaultRandom", "Lkotlin/random/Random;", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Default extends Random {
        public Default() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Default companion object instead")
        public static /* synthetic */ void Companion$annotations() {
        }

        @Override // kotlin.random.Random
        public int nextBits(int i) {
            return Random.defaultRandom.nextBits(i);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] bArr) {
            return Random.defaultRandom.nextBytes(bArr);
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
        public byte[] nextBytes(int i) {
            return Random.defaultRandom.nextBytes(i);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d2) {
            return Random.defaultRandom.nextDouble(d2);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i) {
            return Random.defaultRandom.nextInt(i);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j) {
            return Random.defaultRandom.nextLong(j);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] bArr, int i, int i2) {
            return Random.defaultRandom.nextBytes(bArr, i, i2);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d2, double d3) {
            return Random.defaultRandom.nextDouble(d2, d3);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i, int i2) {
            return Random.defaultRandom.nextInt(i, i2);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j, long j2) {
            return Random.defaultRandom.nextLong(j, j2);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return random.nextBytes(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] nextBytes(byte[] bArr, int i, int i2) {
        boolean z;
        int length = bArr.length;
        if (i >= 0 && length >= i) {
            int length2 = bArr.length;
            if (i2 >= 0 && length2 >= i2) {
                z = true;
                if (z) {
                    throw new IllegalArgumentException(("fromIndex (" + i + ") or toIndex (" + i2 + ") are out of range: 0.." + bArr.length + IStringUtil.EXTENSION_SEPARATOR).toString());
                }
                if (i <= i2) {
                    int i3 = (i2 - i) / 4;
                    for (int i4 = 0; i4 < i3; i4++) {
                        int nextInt = nextInt();
                        bArr[i] = (byte) nextInt;
                        bArr[i + 1] = (byte) (nextInt >>> 8);
                        bArr[i + 2] = (byte) (nextInt >>> 16);
                        bArr[i + 3] = (byte) (nextInt >>> 24);
                        i += 4;
                    }
                    int i5 = i2 - i;
                    int nextBits = nextBits(i5 * 8);
                    for (int i6 = 0; i6 < i5; i6++) {
                        bArr[i + i6] = (byte) (nextBits >>> (i6 * 8));
                    }
                    return bArr;
                }
                throw new IllegalArgumentException(("fromIndex (" + i + ") must be not greater than toIndex (" + i2 + ").").toString());
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

    public int nextInt(int i) {
        return nextInt(0, i);
    }

    public long nextLong(long j) {
        return nextLong(0L, j);
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
                    return nextDouble < d3 ? Math.nextAfter(d3, DoubleCompanionObject.INSTANCE.getNEGATIVE_INFINITY()) : nextDouble;
                }
            }
        }
        nextDouble = d2 + (nextDouble() * d4);
        if (nextDouble < d3) {
        }
    }

    public int nextInt(int i, int i2) {
        int nextInt;
        int i3;
        int i4;
        RandomKt.checkRangeBounds(i, i2);
        int i5 = i2 - i;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                i4 = nextBits(RandomKt.fastLog2(i5));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i3 = nextInt % i5;
                } while ((nextInt - i3) + (i5 - 1) < 0);
                i4 = i3;
            }
            return i + i4;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i <= nextInt2 && i2 > nextInt2) {
                return nextInt2;
            }
        }
    }

    public long nextLong(long j, long j2) {
        long nextLong;
        long j3;
        long j4;
        int nextInt;
        RandomKt.checkRangeBounds(j, j2);
        long j5 = j2 - j;
        if (j5 > 0) {
            if (((-j5) & j5) == j5) {
                int i = (int) j5;
                int i2 = (int) (j5 >>> 32);
                if (i != 0) {
                    nextInt = nextBits(RandomKt.fastLog2(i));
                } else if (i2 == 1) {
                    nextInt = nextInt();
                } else {
                    j4 = (nextBits(RandomKt.fastLog2(i2)) << 32) + nextInt();
                }
                j4 = nextInt & 4294967295L;
            } else {
                do {
                    nextLong = nextLong() >>> 1;
                    j3 = nextLong % j5;
                } while ((nextLong - j3) + (j5 - 1) < 0);
                j4 = j3;
            }
            return j + j4;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j <= nextLong2 && j2 > nextLong2) {
                return nextLong2;
            }
        }
    }

    public byte[] nextBytes(byte[] bArr) {
        return nextBytes(bArr, 0, bArr.length);
    }

    public byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }
}
