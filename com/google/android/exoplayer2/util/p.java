package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class p {
    private static final Comparator<a> mHy = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    private static final Comparator<a> mHz = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.2
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
    private final int mHA;
    private int mHE;
    private int mHF;
    private int mHG;
    private final a[] mHC = new a[5];
    private final ArrayList<a> mHB = new ArrayList<>();
    private int mHD = -1;

    public p(int i) {
        this.mHA = i;
    }

    public void r(int i, float f) {
        a aVar;
        dzL();
        if (this.mHG > 0) {
            a[] aVarArr = this.mHC;
            int i2 = this.mHG - 1;
            this.mHG = i2;
            aVar = aVarArr[i2];
        } else {
            aVar = new a();
        }
        int i3 = this.mHE;
        this.mHE = i3 + 1;
        aVar.index = i3;
        aVar.weight = i;
        aVar.value = f;
        this.mHB.add(aVar);
        this.mHF += i;
        while (this.mHF > this.mHA) {
            int i4 = this.mHF - this.mHA;
            a aVar2 = this.mHB.get(0);
            if (aVar2.weight <= i4) {
                this.mHF -= aVar2.weight;
                this.mHB.remove(0);
                if (this.mHG < 5) {
                    a[] aVarArr2 = this.mHC;
                    int i5 = this.mHG;
                    this.mHG = i5 + 1;
                    aVarArr2[i5] = aVar2;
                }
            } else {
                aVar2.weight -= i4;
                this.mHF -= i4;
            }
        }
    }

    public float bD(float f) {
        dzM();
        float f2 = f * this.mHF;
        int i = 0;
        for (int i2 = 0; i2 < this.mHB.size(); i2++) {
            a aVar = this.mHB.get(i2);
            i += aVar.weight;
            if (i >= f2) {
                return aVar.value;
            }
        }
        if (this.mHB.isEmpty()) {
            return Float.NaN;
        }
        return this.mHB.get(this.mHB.size() - 1).value;
    }

    private void dzL() {
        if (this.mHD != 1) {
            Collections.sort(this.mHB, mHy);
            this.mHD = 1;
        }
    }

    private void dzM() {
        if (this.mHD != 0) {
            Collections.sort(this.mHB, mHz);
            this.mHD = 0;
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
