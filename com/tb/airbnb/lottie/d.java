package com.tb.airbnb.lottie;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.tb.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {
    private Rect bounds;
    private Map<String, g> images;
    private final m njm = new m();
    private final HashSet<String> zH = new HashSet<>();
    private Map<String, List<Layer>> zI;
    private Map<String, com.tb.airbnb.lottie.model.c> zJ;
    private SparseArrayCompat<com.tb.airbnb.lottie.model.d> zK;
    private LongSparseArray<Layer> zL;
    private List<Layer> zM;
    private float zN;
    private float zO;
    private float zP;

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.tb.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.tb.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.zN = f;
        this.zO = f2;
        this.zP = f3;
        this.zM = list;
        this.zL = longSparseArray;
        this.zI = map;
        this.images = map2;
        this.zK = sparseArrayCompat;
        this.zJ = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void aW(String str) {
        Log.w("LOTTIE", str);
        this.zH.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.njm.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.njm;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer gd(long j) {
        return this.zL.get(j);
    }

    public Rect gC() {
        return this.bounds;
    }

    public float gD() {
        return (gL() / this.zP) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gE() {
        return this.zN;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gF() {
        return this.zO;
    }

    public float gG() {
        return this.zP;
    }

    public List<Layer> gH() {
        return this.zM;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> aX(String str) {
        return this.zI.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.d> gI() {
        return this.zK;
    }

    public Map<String, com.tb.airbnb.lottie.model.c> gJ() {
        return this.zJ;
    }

    public Map<String, g> gK() {
        return this.images;
    }

    public float gL() {
        return this.zO - this.zN;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.zM) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
