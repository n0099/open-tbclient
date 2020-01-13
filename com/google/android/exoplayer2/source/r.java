package com.google.android.exoplayer2.source;

import java.util.Random;
/* loaded from: classes5.dex */
public interface r {
    int KJ(int i);

    int KK(int i);

    int bRx();

    int dvt();

    int dvu();

    /* loaded from: classes5.dex */
    public static class a implements r {
        private final int[] msi;
        private final int[] msj;
        private final Random random;

        public a(int i) {
            this(i, new Random());
        }

        private a(int i, Random random) {
            this(a(i, random), random);
        }

        private a(int[] iArr, Random random) {
            this.msi = iArr;
            this.random = random;
            this.msj = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.msj[iArr[i]] = i;
            }
        }

        @Override // com.google.android.exoplayer2.source.r
        public int bRx() {
            return this.msi.length;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int KJ(int i) {
            int i2 = this.msj[i] + 1;
            if (i2 < this.msi.length) {
                return this.msi[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int KK(int i) {
            int i2 = this.msj[i] - 1;
            if (i2 >= 0) {
                return this.msi[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int dvt() {
            if (this.msi.length > 0) {
                return this.msi[this.msi.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int dvu() {
            if (this.msi.length > 0) {
                return this.msi[0];
            }
            return -1;
        }

        private static int[] a(int i, Random random) {
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                int nextInt = random.nextInt(i2 + 1);
                iArr[i2] = iArr[nextInt];
                iArr[nextInt] = i2;
            }
            return iArr;
        }
    }
}
