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
/* loaded from: classes17.dex */
public class d {
    private Map<String, List<Layer>> AQ;
    private Map<String, com.tb.airbnb.lottie.model.c> AR;
    private SparseArrayCompat<com.tb.airbnb.lottie.model.d> AU;
    private LongSparseArray<Layer> AV;
    private List<Layer> AW;
    private float AX;
    private float AY;
    private float AZ;
    private Rect bounds;
    private Map<String, g> images;
    private final m orK = new m();
    private final HashSet<String> AP = new HashSet<>();

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.tb.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.tb.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.AX = f;
        this.AY = f2;
        this.AZ = f3;
        this.AW = list;
        this.AV = longSparseArray;
        this.AQ = map;
        this.images = map2;
        this.AU = sparseArrayCompat;
        this.AR = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bc(String str) {
        Log.w("LOTTIE", str);
        this.AP.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.orK.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.orK;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer gY(long j) {
        return this.AV.get(j);
    }

    public Rect it() {
        return this.bounds;
    }

    public float iu() {
        return (iC() / this.AZ) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float iv() {
        return this.AX;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float iw() {
        return this.AY;
    }

    public float ix() {
        return this.AZ;
    }

    public List<Layer> iy() {
        return this.AW;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bd(String str) {
        return this.AQ.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.d> iz() {
        return this.AU;
    }

    public Map<String, com.tb.airbnb.lottie.model.c> iA() {
        return this.AR;
    }

    public Map<String, g> iB() {
        return this.images;
    }

    public float iC() {
        return this.AY - this.AX;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.AW) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
