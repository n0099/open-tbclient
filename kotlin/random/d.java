package kotlin.random;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public abstract class d {
    public static final b nBO = new b(null);
    private static final d nBM = kotlin.internal.b.nBv.dJg();
    public static final a nBN = a.nBP;

    public abstract int ND(int i);

    public int nextInt() {
        return ND(32);
    }

    public int nextInt(int i) {
        return eq(0, i);
    }

    public int eq(int i, int i2) {
        int nextInt;
        int i3;
        e.es(i, i2);
        int i4 = i2 - i;
        if (i4 > 0 || i4 == Integer.MIN_VALUE) {
            if (((-i4) & i4) == i4) {
                i3 = ND(c.NE(i4));
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
        return ND(1) != 0;
    }

    public double nextDouble() {
        return c.ep(ND(26), ND(27));
    }

    public float nextFloat() {
        return ND(24) / 16777216;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] F(byte[] bArr, int i, int i2) {
        boolean z;
        q.j(bArr, "array");
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
                    int ND = ND(i5 * 8);
                    for (int i6 = 0; i6 < i5; i6++) {
                        bArr[i + i6] = (byte) (ND >>> (i6 * 8));
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

    public byte[] aF(byte[] bArr) {
        q.j(bArr, "array");
        return F(bArr, 0, bArr.length);
    }

    /* loaded from: classes5.dex */
    public static final class b extends d {
        private b() {
        }

        public /* synthetic */ b(o oVar) {
            this();
        }

        @Override // kotlin.random.d
        public int ND(int i) {
            return d.nBM.ND(i);
        }

        @Override // kotlin.random.d
        public int nextInt() {
            return d.nBM.nextInt();
        }

        @Override // kotlin.random.d
        public int nextInt(int i) {
            return d.nBM.nextInt(i);
        }

        @Override // kotlin.random.d
        public int eq(int i, int i2) {
            return d.nBM.eq(i, i2);
        }

        @Override // kotlin.random.d
        public long nextLong() {
            return d.nBM.nextLong();
        }

        @Override // kotlin.random.d
        public boolean nextBoolean() {
            return d.nBM.nextBoolean();
        }

        @Override // kotlin.random.d
        public double nextDouble() {
            return d.nBM.nextDouble();
        }

        @Override // kotlin.random.d
        public float nextFloat() {
            return d.nBM.nextFloat();
        }

        @Override // kotlin.random.d
        public byte[] aF(byte[] bArr) {
            q.j(bArr, "array");
            return d.nBM.aF(bArr);
        }

        @Override // kotlin.random.d
        public byte[] F(byte[] bArr, int i, int i2) {
            q.j(bArr, "array");
            return d.nBM.F(bArr, i, i2);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends d {
        public static final a nBP = new a();

        private a() {
        }

        @Override // kotlin.random.d
        public int ND(int i) {
            return d.nBO.ND(i);
        }
    }
}
