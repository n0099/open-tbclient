package kotlin.random;

import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class d {
    public static final b mXX = new b(null);
    private static final d mXV = kotlin.internal.b.mXE.dDN();
    public static final a mXW = a.mXY;

    public abstract int Jg(int i);

    public int nextInt() {
        return Jg(32);
    }

    public int nextInt(int i) {
        return dF(0, i);
    }

    public int dF(int i, int i2) {
        int nextInt;
        int i3;
        e.dH(i, i2);
        int i4 = i2 - i;
        if (i4 > 0 || i4 == Integer.MIN_VALUE) {
            if (((-i4) & i4) == i4) {
                i3 = Jg(c.Jh(i4));
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
        return Jg(1) != 0;
    }

    public double nextDouble() {
        return c.dE(Jg(26), Jg(27));
    }

    public float nextFloat() {
        return Jg(24) / 16777216;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] u(byte[] bArr, int i, int i2) {
        boolean z;
        q.j(bArr, com.baidu.fsg.base.statistics.b.j);
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
                    int Jg = Jg(i5 * 8);
                    for (int i6 = 0; i6 < i5; i6++) {
                        bArr[i + i6] = (byte) (Jg >>> (i6 * 8));
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

    public byte[] ap(byte[] bArr) {
        q.j(bArr, com.baidu.fsg.base.statistics.b.j);
        return u(bArr, 0, bArr.length);
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
        public int Jg(int i) {
            return d.mXV.Jg(i);
        }

        @Override // kotlin.random.d
        public int nextInt() {
            return d.mXV.nextInt();
        }

        @Override // kotlin.random.d
        public int nextInt(int i) {
            return d.mXV.nextInt(i);
        }

        @Override // kotlin.random.d
        public int dF(int i, int i2) {
            return d.mXV.dF(i, i2);
        }

        @Override // kotlin.random.d
        public long nextLong() {
            return d.mXV.nextLong();
        }

        @Override // kotlin.random.d
        public boolean nextBoolean() {
            return d.mXV.nextBoolean();
        }

        @Override // kotlin.random.d
        public double nextDouble() {
            return d.mXV.nextDouble();
        }

        @Override // kotlin.random.d
        public float nextFloat() {
            return d.mXV.nextFloat();
        }

        @Override // kotlin.random.d
        public byte[] ap(byte[] bArr) {
            q.j(bArr, com.baidu.fsg.base.statistics.b.j);
            return d.mXV.ap(bArr);
        }

        @Override // kotlin.random.d
        public byte[] u(byte[] bArr, int i, int i2) {
            q.j(bArr, com.baidu.fsg.base.statistics.b.j);
            return d.mXV.u(bArr, i, i2);
        }
    }

    @h
    /* loaded from: classes7.dex */
    public static final class a extends d {
        public static final a mXY = new a();

        private a() {
        }

        @Override // kotlin.random.d
        public int Jg(int i) {
            return d.mXX.Jg(i);
        }
    }
}
