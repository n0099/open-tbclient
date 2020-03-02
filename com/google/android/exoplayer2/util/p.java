package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class p {
    private static final Comparator<a> mHA = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    private static final Comparator<a> mHB = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.2
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
    private final int mHC;
    private int mHG;
    private int mHH;
    private int mHI;
    private final a[] mHE = new a[5];
    private final ArrayList<a> mHD = new ArrayList<>();
    private int mHF = -1;

    public p(int i) {
        this.mHC = i;
    }

    public void r(int i, float f) {
        a aVar;
        dzN();
        if (this.mHI > 0) {
            a[] aVarArr = this.mHE;
            int i2 = this.mHI - 1;
            this.mHI = i2;
            aVar = aVarArr[i2];
        } else {
            aVar = new a();
        }
        int i3 = this.mHG;
        this.mHG = i3 + 1;
        aVar.index = i3;
        aVar.weight = i;
        aVar.value = f;
        this.mHD.add(aVar);
        this.mHH += i;
        while (this.mHH > this.mHC) {
            int i4 = this.mHH - this.mHC;
            a aVar2 = this.mHD.get(0);
            if (aVar2.weight <= i4) {
                this.mHH -= aVar2.weight;
                this.mHD.remove(0);
                if (this.mHI < 5) {
                    a[] aVarArr2 = this.mHE;
                    int i5 = this.mHI;
                    this.mHI = i5 + 1;
                    aVarArr2[i5] = aVar2;
                }
            } else {
                aVar2.weight -= i4;
                this.mHH -= i4;
            }
        }
    }

    public float bD(float f) {
        dzO();
        float f2 = f * this.mHH;
        int i = 0;
        for (int i2 = 0; i2 < this.mHD.size(); i2++) {
            a aVar = this.mHD.get(i2);
            i += aVar.weight;
            if (i >= f2) {
                return aVar.value;
            }
        }
        if (this.mHD.isEmpty()) {
            return Float.NaN;
        }
        return this.mHD.get(this.mHD.size() - 1).value;
    }

    private void dzN() {
        if (this.mHF != 1) {
            Collections.sort(this.mHD, mHA);
            this.mHF = 1;
        }
    }

    private void dzO() {
        if (this.mHF != 0) {
            Collections.sort(this.mHD, mHB);
            this.mHF = 0;
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
