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
/* loaded from: classes5.dex */
public class d {
    private Map<String, List<Layer>> Al;
    private Map<String, com.tb.airbnb.lottie.model.c> Am;
    private SparseArrayCompat<com.tb.airbnb.lottie.model.d> An;
    private LongSparseArray<Layer> Ao;
    private List<Layer> Ap;
    private float Aq;
    private float Ar;
    private float As;
    private Rect bounds;
    private Map<String, g> images;
    private final m nNM = new m();
    private final HashSet<String> Ak = new HashSet<>();

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.tb.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.tb.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.Aq = f;
        this.Ar = f2;
        this.As = f3;
        this.Ap = list;
        this.Ao = longSparseArray;
        this.Al = map;
        this.images = map2;
        this.An = sparseArrayCompat;
        this.Am = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void aX(String str) {
        Log.w("LOTTIE", str);
        this.Ak.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.nNM.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.nNM;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer gv(long j) {
        return this.Ao.get(j);
    }

    public Rect gS() {
        return this.bounds;
    }

    public float gT() {
        return (hb() / this.As) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gU() {
        return this.Aq;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gV() {
        return this.Ar;
    }

    public float gW() {
        return this.As;
    }

    public List<Layer> gX() {
        return this.Ap;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> aY(String str) {
        return this.Al.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.d> gY() {
        return this.An;
    }

    public Map<String, com.tb.airbnb.lottie.model.c> gZ() {
        return this.Am;
    }

    public Map<String, g> ha() {
        return this.images;
    }

    public float hb() {
        return this.Ar - this.Aq;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.Ap) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
