package d.a.a;

import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.baidu.searchbox.track.ui.TrackUI;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final m f41126a = new m();

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f41127b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, List<Layer>> f41128c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, g> f41129d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, d.a.a.s.c> f41130e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArrayCompat<d.a.a.s.d> f41131f;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<Layer> f41132g;

    /* renamed from: h  reason: collision with root package name */
    public List<Layer> f41133h;
    public Rect i;
    public float j;
    public float k;
    public float l;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        Log.w("LOTTIE", str);
        this.f41127b.add(str);
    }

    public Rect b() {
        return this.i;
    }

    public SparseArrayCompat<d.a.a.s.d> c() {
        return this.f41131f;
    }

    public float d() {
        return (e() / this.l) * 1000.0f;
    }

    public float e() {
        return this.k - this.j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float f() {
        return this.k;
    }

    public Map<String, d.a.a.s.c> g() {
        return this.f41130e;
    }

    public float h() {
        return this.l;
    }

    public Map<String, g> i() {
        return this.f41129d;
    }

    public List<Layer> j() {
        return this.f41133h;
    }

    public m k() {
        return this.f41126a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> l(String str) {
        return this.f41128c.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float m() {
        return this.j;
    }

    public void n(Rect rect, float f2, float f3, float f4, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<d.a.a.s.d> sparseArrayCompat, Map<String, d.a.a.s.c> map3) {
        this.i = rect;
        this.j = f2;
        this.k = f3;
        this.l = f4;
        this.f41133h = list;
        this.f41132g = longSparseArray;
        this.f41128c = map;
        this.f41129d = map2;
        this.f41131f = sparseArrayCompat;
        this.f41130e = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer o(long j) {
        return this.f41132g.get(j);
    }

    public void p(boolean z) {
        this.f41126a.b(z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.f41133h) {
            sb.append(layer.v(TrackUI.SEPERATOR));
        }
        return sb.toString();
    }
}
