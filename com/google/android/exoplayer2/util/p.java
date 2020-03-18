package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class p {
    private static final Comparator<a> mJv = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    private static final Comparator<a> mJw = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.value < aVar2.value) {
                return -1;
            }
            return aVar2.value < aVar.value ? 1 : 0;
        }
    };
    private int mJB;
    private int mJC;
    private int mJD;
    private final int mJx;
    private final a[] mJz = new a[5];
    private final ArrayList<a> mJy = new ArrayList<>();
    private int mJA = -1;

    public p(int i) {
        this.mJx = i;
    }

    public void r(int i, float f) {
        a aVar;
        dAl();
        if (this.mJD > 0) {
            a[] aVarArr = this.mJz;
            int i2 = this.mJD - 1;
            this.mJD = i2;
            aVar = aVarArr[i2];
        } else {
            aVar = new a();
        }
        int i3 = this.mJB;
        this.mJB = i3 + 1;
        aVar.index = i3;
        aVar.weight = i;
        aVar.value = f;
        this.mJy.add(aVar);
        this.mJC += i;
        while (this.mJC > this.mJx) {
            int i4 = this.mJC - this.mJx;
            a aVar2 = this.mJy.get(0);
            if (aVar2.weight <= i4) {
                this.mJC -= aVar2.weight;
                this.mJy.remove(0);
                if (this.mJD < 5) {
                    a[] aVarArr2 = this.mJz;
                    int i5 = this.mJD;
                    this.mJD = i5 + 1;
                    aVarArr2[i5] = aVar2;
                }
            } else {
                aVar2.weight -= i4;
                this.mJC -= i4;
            }
        }
    }

    public float bD(float f) {
        dAm();
        float f2 = f * this.mJC;
        int i = 0;
        for (int i2 = 0; i2 < this.mJy.size(); i2++) {
            a aVar = this.mJy.get(i2);
            i += aVar.weight;
            if (i >= f2) {
                return aVar.value;
            }
        }
        if (this.mJy.isEmpty()) {
            return Float.NaN;
        }
        return this.mJy.get(this.mJy.size() - 1).value;
    }

    private void dAl() {
        if (this.mJA != 1) {
            Collections.sort(this.mJy, mJv);
            this.mJA = 1;
        }
    }

    private void dAm() {
        if (this.mJA != 0) {
            Collections.sort(this.mJy, mJw);
            this.mJA = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        public int index;
        public float value;
        public int weight;

        private a() {
        }
    }
}
