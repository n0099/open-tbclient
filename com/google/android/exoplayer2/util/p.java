package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes4.dex */
public class p {
    private static final Comparator<a> mCX = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    private static final Comparator<a> mCY = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.2
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
    private final int mCZ;
    private int mDe;
    private int mDf;
    private int mDg;
    private final a[] mDc = new a[5];
    private final ArrayList<a> mDa = new ArrayList<>();
    private int mDd = -1;

    public p(int i) {
        this.mCZ = i;
    }

    public void q(int i, float f) {
        a aVar;
        dxp();
        if (this.mDg > 0) {
            a[] aVarArr = this.mDc;
            int i2 = this.mDg - 1;
            this.mDg = i2;
            aVar = aVarArr[i2];
        } else {
            aVar = new a();
        }
        int i3 = this.mDe;
        this.mDe = i3 + 1;
        aVar.index = i3;
        aVar.weight = i;
        aVar.value = f;
        this.mDa.add(aVar);
        this.mDf += i;
        while (this.mDf > this.mCZ) {
            int i4 = this.mDf - this.mCZ;
            a aVar2 = this.mDa.get(0);
            if (aVar2.weight <= i4) {
                this.mDf -= aVar2.weight;
                this.mDa.remove(0);
                if (this.mDg < 5) {
                    a[] aVarArr2 = this.mDc;
                    int i5 = this.mDg;
                    this.mDg = i5 + 1;
                    aVarArr2[i5] = aVar2;
                }
            } else {
                aVar2.weight -= i4;
                this.mDf -= i4;
            }
        }
    }

    public float bE(float f) {
        dxq();
        float f2 = f * this.mDf;
        int i = 0;
        for (int i2 = 0; i2 < this.mDa.size(); i2++) {
            a aVar = this.mDa.get(i2);
            i += aVar.weight;
            if (i >= f2) {
                return aVar.value;
            }
        }
        if (this.mDa.isEmpty()) {
            return Float.NaN;
        }
        return this.mDa.get(this.mDa.size() - 1).value;
    }

    private void dxp() {
        if (this.mDd != 1) {
            Collections.sort(this.mDa, mCX);
            this.mDd = 1;
        }
    }

    private void dxq() {
        if (this.mDd != 0) {
            Collections.sort(this.mDa, mCY);
            this.mDd = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        public int index;
        public float value;
        public int weight;

        private a() {
        }
    }
}
