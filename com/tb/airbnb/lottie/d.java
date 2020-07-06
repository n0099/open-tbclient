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
    private Map<String, List<Layer>> Aj;
    private Map<String, com.tb.airbnb.lottie.model.c> Ak;
    private SparseArrayCompat<com.tb.airbnb.lottie.model.d> Al;
    private LongSparseArray<Layer> Am;
    private List<Layer> An;
    private float Ao;
    private float Ap;
    private float Aq;
    private Rect bounds;
    private Map<String, g> images;
    private final m nFe = new m();
    private final HashSet<String> Ai = new HashSet<>();

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.tb.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.tb.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.Ao = f;
        this.Ap = f2;
        this.Aq = f3;
        this.An = list;
        this.Am = longSparseArray;
        this.Aj = map;
        this.images = map2;
        this.Al = sparseArrayCompat;
        this.Ak = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void aX(String str) {
        Log.w("LOTTIE", str);
        this.Ai.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.nFe.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.nFe;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer gi(long j) {
        return this.Am.get(j);
    }

    public Rect gS() {
        return this.bounds;
    }

    public float gT() {
        return (hb() / this.Aq) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gU() {
        return this.Ao;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gV() {
        return this.Ap;
    }

    public float gW() {
        return this.Aq;
    }

    public List<Layer> gX() {
        return this.An;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> aY(String str) {
        return this.Aj.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.d> gY() {
        return this.Al;
    }

    public Map<String, com.tb.airbnb.lottie.model.c> gZ() {
        return this.Ak;
    }

    public Map<String, g> ha() {
        return this.images;
    }

    public float hb() {
        return this.Ap - this.Ao;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.An) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
