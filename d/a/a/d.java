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
    public Map<String, List<Layer>> f41417c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, g> f41418d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, d.a.a.u.b> f41419e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.a.u.g> f41420f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArrayCompat<d.a.a.u.c> f41421g;

    /* renamed from: h  reason: collision with root package name */
    public LongSparseArray<Layer> f41422h;
    public List<Layer> i;
    public Rect j;
    public float k;
    public float l;
    public float m;
    public boolean n;

    /* renamed from: a  reason: collision with root package name */
    public final n f41415a = new n();

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f41416b = new HashSet<>();
    public int o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        d.a.a.x.d.c(str);
        this.f41416b.add(str);
    }

    public Rect b() {
        return this.j;
    }

    public SparseArrayCompat<d.a.a.u.c> c() {
        return this.f41421g;
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
        return this.f41419e;
    }

    public float h() {
        return this.m;
    }

    public Map<String, g> i() {
        return this.f41418d;
    }

    public List<Layer> j() {
        return this.i;
    }

    @Nullable
    public d.a.a.u.g k(String str) {
        this.f41420f.size();
        for (int i = 0; i < this.f41420f.size(); i++) {
            d.a.a.u.g gVar = this.f41420f.get(i);
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
        return this.f41415a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> n(String str) {
        return this.f41417c.get(str);
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
        this.f41422h = longSparseArray;
        this.f41417c = map;
        this.f41418d = map2;
        this.f41421g = sparseArrayCompat;
        this.f41419e = map3;
        this.f41420f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer s(long j) {
        return this.f41422h.get(j);
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
        this.f41415a.b(z);
    }
}
