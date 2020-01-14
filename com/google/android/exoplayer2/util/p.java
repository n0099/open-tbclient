package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class p {
    private static final Comparator<a> mGT = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.index - aVar2.index;
        }
    };
    private static final Comparator<a> mGU = new Comparator<a>() { // from class: com.google.android.exoplayer2.util.p.2
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
    private final int mGV;
    private int mGZ;
    private int mHa;
    private int mHb;
    private final a[] mGX = new a[5];
    private final ArrayList<a> mGW = new ArrayList<>();
    private int mGY = -1;

    public p(int i) {
        this.mGV = i;
    }

    public void r(int i, float f) {
        a aVar;
        dyB();
        if (this.mHb > 0) {
            a[] aVarArr = this.mGX;
            int i2 = this.mHb - 1;
            this.mHb = i2;
            aVar = aVarArr[i2];
        } else {
            aVar = new a();
        }
        int i3 = this.mGZ;
        this.mGZ = i3 + 1;
        aVar.index = i3;
        aVar.weight = i;
        aVar.value = f;
        this.mGW.add(aVar);
        this.mHa += i;
        while (this.mHa > this.mGV) {
            int i4 = this.mHa - this.mGV;
            a aVar2 = this.mGW.get(0);
            if (aVar2.weight <= i4) {
                this.mHa -= aVar2.weight;
                this.mGW.remove(0);
                if (this.mHb < 5) {
                    a[] aVarArr2 = this.mGX;
                    int i5 = this.mHb;
                    this.mHb = i5 + 1;
                    aVarArr2[i5] = aVar2;
                }
            } else {
                aVar2.weight -= i4;
                this.mHa -= i4;
            }
        }
    }

    public float bE(float f) {
        dyC();
        float f2 = f * this.mHa;
        int i = 0;
        for (int i2 = 0; i2 < this.mGW.size(); i2++) {
            a aVar = this.mGW.get(i2);
            i += aVar.weight;
            if (i >= f2) {
                return aVar.value;
            }
        }
        if (this.mGW.isEmpty()) {
            return Float.NaN;
        }
        return this.mGW.get(this.mGW.size() - 1).value;
    }

    private void dyB() {
        if (this.mGY != 1) {
            Collections.sort(this.mGW, mGT);
            this.mGY = 1;
        }
    }

    private void dyC() {
        if (this.mGY != 0) {
            Collections.sort(this.mGW, mGU);
            this.mGY = 0;
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
