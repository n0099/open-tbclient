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
    private Map<String, List<Layer>> dX;
    private Map<String, com.tb.airbnb.lottie.model.c> dY;
    private SparseArrayCompat<com.tb.airbnb.lottie.model.d> dZ;
    private LongSparseArray<Layer> eb;
    private List<Layer> ec;
    private float ed;
    private float ee;
    private float frameRate;
    private Map<String, g> images;
    private final m npl = new m();
    private final HashSet<String> dW = new HashSet<>();

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.tb.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.tb.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.ed = f;
        this.ee = f2;
        this.frameRate = f3;
        this.ec = list;
        this.eb = longSparseArray;
        this.dX = map;
        this.images = map2;
        this.dZ = sparseArrayCompat;
        this.dY = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void G(String str) {
        Log.w("LOTTIE", str);
        this.dW.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.npl.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.npl;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer ha(long j) {
        return this.eb.get(j);
    }

    public Rect bf() {
        return this.bounds;
    }

    public float bg() {
        return (bo() / this.frameRate) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float bh() {
        return this.ed;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float bi() {
        return this.ee;
    }

    public float bj() {
        return this.frameRate;
    }

    public List<Layer> bk() {
        return this.ec;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> H(String str) {
        return this.dX.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.d> bl() {
        return this.dZ;
    }

    public Map<String, com.tb.airbnb.lottie.model.c> bm() {
        return this.dY;
    }

    public Map<String, g> bn() {
        return this.images;
    }

    public float bo() {
        return this.ee - this.ed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.ec) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
