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
/* loaded from: classes16.dex */
public class d {
    private Map<String, List<Layer>> Bj;
    private Map<String, com.tb.airbnb.lottie.model.c> Bk;
    private SparseArrayCompat<com.tb.airbnb.lottie.model.d> Bl;
    private LongSparseArray<Layer> Bm;
    private List<Layer> Bn;
    private float Bo;
    private float Bp;
    private float Bq;
    private Rect bounds;
    private Map<String, g> images;
    private final m oHa = new m();
    private final HashSet<String> Bi = new HashSet<>();

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.tb.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.tb.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.Bo = f;
        this.Bp = f2;
        this.Bq = f3;
        this.Bn = list;
        this.Bm = longSparseArray;
        this.Bj = map;
        this.images = map2;
        this.Bl = sparseArrayCompat;
        this.Bk = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bc(String str) {
        Log.w("LOTTIE", str);
        this.Bi.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.oHa.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.oHa;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer hq(long j) {
        return this.Bm.get(j);
    }

    public Rect iu() {
        return this.bounds;
    }

    public float iv() {
        return (iD() / this.Bq) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float iw() {
        return this.Bo;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float ix() {
        return this.Bp;
    }

    public float iy() {
        return this.Bq;
    }

    public List<Layer> iz() {
        return this.Bn;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bd(String str) {
        return this.Bj.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.d> iA() {
        return this.Bl;
    }

    public Map<String, com.tb.airbnb.lottie.model.c> iB() {
        return this.Bk;
    }

    public Map<String, g> iC() {
        return this.images;
    }

    public float iD() {
        return this.Bp - this.Bo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.Bn) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
