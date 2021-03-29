package com.ksad.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.baidu.searchbox.track.ui.TrackUI;
import com.ksad.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final l f31347a = new l();

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f31348b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, List<Layer>> f31349c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, g> f31350d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, com.ksad.lottie.model.c> f31351e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArrayCompat<com.ksad.lottie.model.d> f31352f;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<Layer> f31353g;

    /* renamed from: h  reason: collision with root package name */
    public List<Layer> f31354h;
    public Rect i;
    public float j;
    public float k;
    public float l;

    public l a() {
        return this.f31347a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer a(long j) {
        return this.f31353g.get(j);
    }

    public void a(Rect rect, float f2, float f3, float f4, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.ksad.lottie.model.d> sparseArrayCompat, Map<String, com.ksad.lottie.model.c> map3) {
        this.i = rect;
        this.j = f2;
        this.k = f3;
        this.l = f4;
        this.f31354h = list;
        this.f31353g = longSparseArray;
        this.f31349c = map;
        this.f31350d = map2;
        this.f31352f = sparseArrayCompat;
        this.f31351e = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        Log.w("LOTTIE", str);
        this.f31348b.add(str);
    }

    public void a(boolean z) {
        this.f31347a.a(z);
    }

    public Rect b() {
        return this.i;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> b(String str) {
        return this.f31349c.get(str);
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
        return this.f31354h;
    }

    public SparseArrayCompat<com.ksad.lottie.model.d> h() {
        return this.f31352f;
    }

    public Map<String, com.ksad.lottie.model.c> i() {
        return this.f31351e;
    }

    public Map<String, g> j() {
        return this.f31350d;
    }

    public float k() {
        return this.k - this.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.f31354h) {
            sb.append(layer.a(TrackUI.SEPERATOR));
        }
        return sb.toString();
    }
}
