package com.ksad.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.ksad.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final l f5339a = new l();
    private final HashSet<String> b = new HashSet<>();
    private Map<String, List<Layer>> c;
    private Map<String, g> d;
    private Map<String, com.ksad.lottie.model.c> e;
    private SparseArrayCompat<com.ksad.lottie.model.d> f;
    private LongSparseArray<Layer> g;
    private List<Layer> h;
    private Rect i;
    private float j;
    private float k;
    private float l;

    public l a() {
        return this.f5339a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer a(long j) {
        return this.g.get(j);
    }

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.ksad.lottie.model.d> sparseArrayCompat, Map<String, com.ksad.lottie.model.c> map3) {
        this.i = rect;
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.h = list;
        this.g = longSparseArray;
        this.c = map;
        this.d = map2;
        this.f = sparseArrayCompat;
        this.e = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        Log.w("LOTTIE", str);
        this.b.add(str);
    }

    public void a(boolean z) {
        this.f5339a.a(z);
    }

    public Rect b() {
        return this.i;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> b(String str) {
        return this.c.get(str);
    }

    public float c() {
        return (k() / this.l) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float d() {
        return this.j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float e() {
        return this.k;
    }

    public float f() {
        return this.l;
    }

    public List<Layer> g() {
        return this.h;
    }

    public SparseArrayCompat<com.ksad.lottie.model.d> h() {
        return this.f;
    }

    public Map<String, com.ksad.lottie.model.c> i() {
        return this.e;
    }

    public Map<String, g> j() {
        return this.d;
    }

    public float k() {
        return this.k - this.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.h) {
            sb.append(layer.a("\t"));
        }
        return sb.toString();
    }
}
