package com.google.android.exoplayer2.source;

import java.util.Random;
/* loaded from: classes6.dex */
public interface r {
    int KO(int i);

    int KP(int i);

    int bTa();

    int dwH();

    int dwI();

    /* loaded from: classes6.dex */
    public static class a implements r {
        private final int[] msV;
        private final int[] msW;
        private final Random random;

        public a(int i) {
            this(i, new Random());
        }

        private a(int i, Random random) {
            this(a(i, random), random);
        }

        private a(int[] iArr, Random random) {
            this.msV = iArr;
            this.random = random;
            this.msW = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.msW[iArr[i]] = i;
            }
        }

        @Override // com.google.android.exoplayer2.source.r
        public int bTa() {
            return this.msV.length;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int KO(int i) {
            int i2 = this.msW[i] + 1;
            if (i2 < this.msV.length) {
                return this.msV[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int KP(int i) {
            int i2 = this.msW[i] - 1;
            if (i2 >= 0) {
                return this.msV[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int dwH() {
            if (this.msV.length > 0) {
                return this.msV[this.msV.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int dwI() {
            if (this.msV.length > 0) {
                return this.msV[0];
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
