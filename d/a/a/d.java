package d.a.a;

import android.graphics.Rect;
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

    /* renamed from: c  reason: collision with root package name */
    public Map<String, List<Layer>> f41512c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, g> f41513d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, d.a.a.u.b> f41514e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.a.u.g> f41515f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArrayCompat<d.a.a.u.c> f41516g;

    /* renamed from: h  reason: collision with root package name */
    public LongSparseArray<Layer> f41517h;
    public List<Layer> i;
    public Rect j;
    public float k;
    public float l;
    public float m;
    public boolean n;

    /* renamed from: a  reason: collision with root package name */
    public final n f41510a = new n();

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f41511b = new HashSet<>();
    public int o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        d.a.a.x.d.c(str);
        this.f41511b.add(str);
    }

    public Rect b() {
        return this.j;
    }

    public SparseArrayCompat<d.a.a.u.c> c() {
        return this.f41516g;
    }

    public float d() {
        return (e() / this.m) * 1000.0f;
    }

    public float e() {
        return this.l - this.k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float f() {
        return this.l;
    }

    public Map<String, d.a.a.u.b> g() {
        return this.f41514e;
    }

    public float h() {
        return this.m;
    }

    public Map<String, g> i() {
        return this.f41513d;
    }

    public List<Layer> j() {
        return this.i;
    }

    @Nullable
    public d.a.a.u.g k(String str) {
        this.f41515f.size();
        for (int i = 0; i < this.f41515f.size(); i++) {
            d.a.a.u.g gVar = this.f41515f.get(i);
            if (gVar.a(str)) {
                return gVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int l() {
        return this.o;
    }

    public n m() {
        return this.f41510a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> n(String str) {
        return this.f41512c.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float o() {
        return this.k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean p() {
        return this.n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void q(int i) {
        this.o += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r(Rect rect, float f2, float f3, float f4, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<d.a.a.u.c> sparseArrayCompat, Map<String, d.a.a.u.b> map3, List<d.a.a.u.g> list2) {
        this.j = rect;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.i = list;
        this.f41517h = longSparseArray;
        this.f41512c = map;
        this.f41513d = map2;
        this.f41516g = sparseArrayCompat;
        this.f41514e = map3;
        this.f41515f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer s(long j) {
        return this.f41517h.get(j);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void t(boolean z) {
        this.n = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.i) {
            sb.append(layer.w(TrackUI.SEPERATOR));
        }
        return sb.toString();
    }

    public void u(boolean z) {
        this.f41510a.b(z);
    }
}
