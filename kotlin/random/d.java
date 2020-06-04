package kotlin.random;

import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class d {
    public static final b nuj = new b(null);
    private static final d nuh = kotlin.internal.b.ntQ.dLW();
    public static final a nui = a.nuk;

    public abstract int JT(int i);

    public int nextInt() {
        return JT(32);
    }

    public int nextInt(int i) {
        return dK(0, i);
    }

    public int dK(int i, int i2) {
        int nextInt;
        int i3;
        e.dM(i, i2);
        int i4 = i2 - i;
        if (i4 > 0 || i4 == Integer.MIN_VALUE) {
            if (((-i4) & i4) == i4) {
                i3 = JT(c.JU(i4));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i3 = nextInt % i4;
                } while ((nextInt - i3) + (i4 - 1) < 0);
            }
            return i3 + i;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i <= nextInt2 && i2 > nextInt2) {
                return nextInt2;
            }
        }
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public boolean nextBoolean() {
        return JT(1) != 0;
    }

    public double nextDouble() {
        return c.dJ(JT(26), JT(27));
    }

    public float nextFloat() {
        return JT(24) / 16777216;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] v(byte[] bArr, int i, int i2) {
        boolean z;
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        int length = bArr.length;
        if (i >= 0 && length >= i) {
            int length2 = bArr.length;
            if (i2 >= 0 && length2 >= i2) {
                z = true;
                if (z) {
                    throw new IllegalArgumentException(("fromIndex (" + i + ") or toIndex (" + i2 + ") are out of range: 0.." + bArr.length + '.').toString());
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
                    int JT = JT(i5 * 8);
                    for (int i6 = 0; i6 < i5; i6++) {
                        bArr[i + i6] = (byte) (JT >>> (i6 * 8));
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

    public byte[] aw(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        return v(bArr, 0, bArr.length);
    }

    @h
    /* loaded from: classes7.dex */
    public static final class b extends d {
        private b() {
        }

        public /* synthetic */ b(o oVar) {
            this();
        }

        @Override // kotlin.random.d
        public int JT(int i) {
            return d.nuh.JT(i);
        }

        @Override // kotlin.random.d
        public int nextInt() {
            return d.nuh.nextInt();
        }

        @Override // kotlin.random.d
        public int nextInt(int i) {
            return d.nuh.nextInt(i);
        }

        @Override // kotlin.random.d
        public int dK(int i, int i2) {
            return d.nuh.dK(i, i2);
        }

        @Override // kotlin.random.d
        public long nextLong() {
            return d.nuh.nextLong();
        }

        @Override // kotlin.random.d
        public boolean nextBoolean() {
            return d.nuh.nextBoolean();
        }

        @Override // kotlin.random.d
        public double nextDouble() {
            return d.nuh.nextDouble();
        }

        @Override // kotlin.random.d
        public float nextFloat() {
            return d.nuh.nextFloat();
        }

        @Override // kotlin.random.d
        public byte[] aw(byte[] bArr) {
            q.m(bArr, com.baidu.fsg.base.statistics.b.j);
            return d.nuh.aw(bArr);
        }

        @Override // kotlin.random.d
        public byte[] v(byte[] bArr, int i, int i2) {
            q.m(bArr, com.baidu.fsg.base.statistics.b.j);
            return d.nuh.v(bArr, i, i2);
        }
    }

    @h
    /* loaded from: classes7.dex */
    public static final class a extends d {
        public static final a nuk = new a();

        private a() {
        }

        @Override // kotlin.random.d
        public int JT(int i) {
            return d.nuj.JT(i);
        }
    }
}
