package com.google.android.exoplayer2.source;

import java.util.Random;
/* loaded from: classes4.dex */
public interface r {
    int KA(int i);

    int KB(int i);

    int bQo();

    int dui();

    int duj();

    /* loaded from: classes4.dex */
    public static class a implements r {
        private final int[] mot;
        private final int[] mou;
        private final Random random;

        public a(int i) {
            this(i, new Random());
        }

        private a(int i, Random random) {
            this(a(i, random), random);
        }

        private a(int[] iArr, Random random) {
            this.mot = iArr;
            this.random = random;
            this.mou = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.mou[iArr[i]] = i;
            }
        }

        @Override // com.google.android.exoplayer2.source.r
        public int bQo() {
            return this.mot.length;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int KA(int i) {
            int i2 = this.mou[i] + 1;
            if (i2 < this.mot.length) {
                return this.mot[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int KB(int i) {
            int i2 = this.mou[i] - 1;
            if (i2 >= 0) {
                return this.mot[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int dui() {
            if (this.mot.length > 0) {
                return this.mot[this.mot.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.r
        public int duj() {
            if (this.mot.length > 0) {
                return this.mot[0];
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
