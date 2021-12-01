package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, d2 = {"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes3.dex */
public class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(T a, T b2) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        return a.compareTo(b2) >= 0 ? a : b2;
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(T a, T b2) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        return a.compareTo(b2) <= 0 ? a : b2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte maxOf(byte b2, byte b3) {
        return (byte) Math.max((int) b2, (int) b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte minOf(byte b2, byte b3) {
        return (byte) Math.min((int) b2, (int) b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short maxOf(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short minOf(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int maxOf(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int minOf(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long maxOf(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long minOf(long j2, long j3) {
        return Math.min(j2, j3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final float maxOf(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final float minOf(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final double maxOf(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final double minOf(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(T a, T b2, T c2) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        Intrinsics.checkNotNullParameter(c2, "c");
        return (T) maxOf(a, maxOf(b2, c2));
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(T a, T b2, T c2) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        Intrinsics.checkNotNullParameter(c2, "c");
        return (T) minOf(a, minOf(b2, c2));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte maxOf(byte b2, byte b3, byte b4) {
        return (byte) Math.max((int) b2, Math.max((int) b3, (int) b4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte minOf(byte b2, byte b3, byte b4) {
        return (byte) Math.min((int) b2, Math.min((int) b3, (int) b4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short maxOf(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short minOf(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int maxOf(int i2, int i3, int i4) {
        return Math.max(i2, Math.max(i3, i4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int minOf(int i2, int i3, int i4) {
        return Math.min(i2, Math.min(i3, i4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long maxOf(long j2, long j3, long j4) {
        return Math.max(j2, Math.max(j3, j4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long minOf(long j2, long j3, long j4) {
        return Math.min(j2, Math.min(j3, j4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final float maxOf(float f2, float f3, float f4) {
        return Math.max(f2, Math.max(f3, f4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final float minOf(float f2, float f3, float f4) {
        return Math.min(f2, Math.min(f3, f4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final double maxOf(double d2, double d3, double d4) {
        return Math.max(d2, Math.max(d3, d4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final double minOf(double d2, double d3, double d4) {
        return Math.min(d2, Math.min(d3, d4));
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T maxOf(T a, T... other) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        for (T t : other) {
            a = (T) maxOf(a, t);
        }
        return a;
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T minOf(T a, T... other) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        for (T t : other) {
            a = (T) minOf(a, t);
        }
        return a;
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte b2, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b3 : other) {
            b2 = (byte) Math.max((int) b2, (int) b3);
        }
        return b2;
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte b2, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b3 : other) {
            b2 = (byte) Math.min((int) b2, (int) b3);
        }
        return b2;
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s2 : other) {
            s = (short) Math.max((int) s, (int) s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s2 : other) {
            s = (short) Math.min((int) s, (int) s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int i2, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i3 : other) {
            i2 = Math.max(i2, i3);
        }
        return i2;
    }

    @SinceKotlin(version = "1.4")
    public static final int minOf(int i2, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i3 : other) {
            i2 = Math.min(i2, i3);
        }
        return i2;
    }

    @SinceKotlin(version = "1.4")
    public static final long maxOf(long j2, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j3 : other) {
            j2 = Math.max(j2, j3);
        }
        return j2;
    }

    @SinceKotlin(version = "1.4")
    public static final long minOf(long j2, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j3 : other) {
            j2 = Math.min(j2, j3);
        }
        return j2;
    }

    @SinceKotlin(version = "1.4")
    public static final float maxOf(float f2, float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (float f3 : other) {
            f2 = Math.max(f2, f3);
        }
        return f2;
    }

    @SinceKotlin(version = "1.4")
    public static final float minOf(float f2, float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (float f3 : other) {
            f2 = Math.min(f2, f3);
        }
        return f2;
    }

    @SinceKotlin(version = "1.4")
    public static final double maxOf(double d2, double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (double d3 : other) {
            d2 = Math.max(d2, d3);
        }
        return d2;
    }

    @SinceKotlin(version = "1.4")
    public static final double minOf(double d2, double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (double d3 : other) {
            d2 = Math.min(d2, d3);
        }
        return d2;
    }
}
