package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class p {
    private static final Comparator<a> mHL = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    private static final Comparator<a> mHM = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.2
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
    private final int mHN;
    private int mHR;
    private int mHS;
    private int mHT;
    private final a[] mHP = new a[5];
    private final ArrayList<a> mHO = new ArrayList<>();
    private int mHQ = -1;

    public p(int i) {
        this.mHN = i;
    }

    public void r(int i, float f) {
        a aVar;
        dzO();
        if (this.mHT > 0) {
            a[] aVarArr = this.mHP;
            int i2 = this.mHT - 1;
            this.mHT = i2;
            aVar = aVarArr[i2];
        } else {
            aVar = new a();
        }
        int i3 = this.mHR;
        this.mHR = i3 + 1;
        aVar.index = i3;
        aVar.weight = i;
        aVar.value = f;
        this.mHO.add(aVar);
        this.mHS += i;
        while (this.mHS > this.mHN) {
            int i4 = this.mHS - this.mHN;
            a aVar2 = this.mHO.get(0);
            if (aVar2.weight <= i4) {
                this.mHS -= aVar2.weight;
                this.mHO.remove(0);
                if (this.mHT < 5) {
                    a[] aVarArr2 = this.mHP;
                    int i5 = this.mHT;
                    this.mHT = i5 + 1;
                    aVarArr2[i5] = aVar2;
                }
            } else {
                aVar2.weight -= i4;
                this.mHS -= i4;
            }
        }
    }

    public float bD(float f) {
        dzP();
        float f2 = f * this.mHS;
        int i = 0;
        for (int i2 = 0; i2 < this.mHO.size(); i2++) {
            a aVar = this.mHO.get(i2);
            i += aVar.weight;
            if (i >= f2) {
                return aVar.value;
            }
        }
        if (this.mHO.isEmpty()) {
            return Float.NaN;
        }
        return this.mHO.get(this.mHO.size() - 1).value;
    }

    private void dzO() {
        if (this.mHQ != 1) {
            Collections.sort(this.mHO, mHL);
            this.mHQ = 1;
        }
    }

    private void dzP() {
        if (this.mHQ != 0) {
            Collections.sort(this.mHO, mHM);
            this.mHQ = 0;
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
