package com.google.android.exoplayer2.source;

import java.util.Random;
/* loaded from: classes6.dex */
public interface r {
    int KO(int i);

    int KP(int i);

    int bSY();

    int dwF();

    int dwG();

    /* loaded from: classes6.dex */
    public static class a implements r {
        private final int[] msT;
        private final int[] msU;
        private final Random random;

        public a(int i) {
            this(i, new Random());
        }

        private a(int i, Random random) {
            this(a(i, random), random);
        }

        private a(int[] iArr, Random random) {
            this.msT = iArr;
            this.random = random;
            this.msU = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.msU[iArr[i]] = i;
            }
        }

        @Override // com.google.android.exoplayer2.source.r
        public int bSY() {
            return this.msT.length;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int KO(int i) {
            int i2 = this.msU[i] + 1;
            if (i2 < this.msT.length) {
                return this.msT[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int KP(int i) {
            int i2 = this.msU[i] - 1;
            if (i2 >= 0) {
                return this.msT[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int dwF() {
            if (this.msT.length > 0) {
                return this.msT[this.msT.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int dwG() {
            if (this.msT.length > 0) {
                return this.msT[0];
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
