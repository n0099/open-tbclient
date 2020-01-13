package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class p {
    private static final Comparator<a> mGO = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    private static final Comparator<a> mGP = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.2
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
    private final int mGQ;
    private int mGU;
    private int mGV;
    private int mGW;
    private final a[] mGS = new a[5];
    private final ArrayList<a> mGR = new ArrayList<>();
    private int mGT = -1;

    public p(int i) {
        this.mGQ = i;
    }

    public void r(int i, float f) {
        a aVar;
        dyz();
        if (this.mGW > 0) {
            a[] aVarArr = this.mGS;
            int i2 = this.mGW - 1;
            this.mGW = i2;
            aVar = aVarArr[i2];
        } else {
            aVar = new a();
        }
        int i3 = this.mGU;
        this.mGU = i3 + 1;
        aVar.index = i3;
        aVar.weight = i;
        aVar.value = f;
        this.mGR.add(aVar);
        this.mGV += i;
        while (this.mGV > this.mGQ) {
            int i4 = this.mGV - this.mGQ;
            a aVar2 = this.mGR.get(0);
            if (aVar2.weight <= i4) {
                this.mGV -= aVar2.weight;
                this.mGR.remove(0);
                if (this.mGW < 5) {
                    a[] aVarArr2 = this.mGS;
                    int i5 = this.mGW;
                    this.mGW = i5 + 1;
                    aVarArr2[i5] = aVar2;
                }
            } else {
                aVar2.weight -= i4;
                this.mGV -= i4;
            }
        }
    }

    public float bE(float f) {
        dyA();
        float f2 = f * this.mGV;
        int i = 0;
        for (int i2 = 0; i2 < this.mGR.size(); i2++) {
            a aVar = this.mGR.get(i2);
            i += aVar.weight;
            if (i >= f2) {
                return aVar.value;
            }
        }
        if (this.mGR.isEmpty()) {
            return Float.NaN;
        }
        return this.mGR.get(this.mGR.size() - 1).value;
    }

    private void dyz() {
        if (this.mGT != 1) {
            Collections.sort(this.mGR, mGO);
            this.mGT = 1;
        }
    }

    private void dyA() {
        if (this.mGT != 0) {
            Collections.sort(this.mGR, mGP);
            this.mGT = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        public int index;
        public float value;
        public int weight;

        private a() {
        }
    }
}
