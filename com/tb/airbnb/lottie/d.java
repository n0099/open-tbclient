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
    private Rect bounds;
    private Map<String, List<Layer>> dW;
    private Map<String, com.tb.airbnb.lottie.model.c> dX;
    private SparseArrayCompat<com.tb.airbnb.lottie.model.d> dY;
    private LongSparseArray<Layer> dZ;
    private List<Layer> eb;
    private float ec;
    private float ed;
    private float frameRate;
    private Map<String, g> images;
    private final m noJ = new m();
    private final HashSet<String> dV = new HashSet<>();

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.tb.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.tb.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.ec = f;
        this.ed = f2;
        this.frameRate = f3;
        this.eb = list;
        this.dZ = longSparseArray;
        this.dW = map;
        this.images = map2;
        this.dY = sparseArrayCompat;
        this.dX = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void G(String str) {
        Log.w("LOTTIE", str);
        this.dV.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.noJ.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.noJ;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer hc(long j) {
        return this.dZ.get(j);
    }

    public Rect be() {
        return this.bounds;
    }

    public float bf() {
        return (bn() / this.frameRate) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float bg() {
        return this.ec;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float bh() {
        return this.ed;
    }

    public float bi() {
        return this.frameRate;
    }

    public List<Layer> bj() {
        return this.eb;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> H(String str) {
        return this.dW.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.d> bk() {
        return this.dY;
    }

    public Map<String, com.tb.airbnb.lottie.model.c> bl() {
        return this.dX;
    }

    public Map<String, g> bm() {
        return this.images;
    }

    public float bn() {
        return this.ed - this.ec;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.eb) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
