package d.a.a.q.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a<K, A> {

    /* renamed from: c  reason: collision with root package name */
    public final List<? extends d.a.a.w.a<K>> f41290c;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public d.a.a.w.c<A> f41292e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public d.a.a.w.a<K> f41293f;

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0528a> f41288a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f41289b = false;

    /* renamed from: d  reason: collision with root package name */
    public float f41291d = 0.0f;

    /* renamed from: d.a.a.q.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0528a {
        void a();
    }

    public a(List<? extends d.a.a.w.a<K>> list) {
        this.f41290c = list;
    }

    public void a(InterfaceC0528a interfaceC0528a) {
        this.f41288a.add(interfaceC0528a);
    }

    public final d.a.a.w.a<K> b() {
        List<? extends d.a.a.w.a<K>> list;
        d.a.a.w.a<K> aVar = this.f41293f;
        if (aVar != null && aVar.a(this.f41291d)) {
            return this.f41293f;
        }
        d.a.a.w.a<K> aVar2 = this.f41290c.get(list.size() - 1);
        if (this.f41291d < aVar2.c()) {
            for (int size = this.f41290c.size() - 1; size >= 0; size--) {
                aVar2 = this.f41290c.get(size);
                if (aVar2.a(this.f41291d)) {
                    break;
                }
            }
        }
        this.f41293f = aVar2;
        return aVar2;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float c() {
        if (this.f41290c.isEmpty()) {
            return 1.0f;
        }
        List<? extends d.a.a.w.a<K>> list = this.f41290c;
        return list.get(list.size() - 1).b();
    }

    public final float d() {
        d.a.a.w.a<K> b2 = b();
        if (b2.d()) {
            return 0.0f;
        }
        return b2.f41452d.getInterpolation(e());
    }

    public float e() {
        if (this.f41289b) {
            return 0.0f;
        }
        d.a.a.w.a<K> b2 = b();
        if (b2.d()) {
            return 0.0f;
        }
        return (this.f41291d - b2.c()) / (b2.b() - b2.c());
    }

    public float f() {
        return this.f41291d;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public final float g() {
        if (this.f41290c.isEmpty()) {
            return 0.0f;
        }
        return this.f41290c.get(0).c();
    }

    public A h() {
        return i(b(), d());
    }

    public abstract A i(d.a.a.w.a<K> aVar, float f2);

    public void j() {
        for (int i = 0; i < this.f41288a.size(); i++) {
            this.f41288a.get(i).a();
        }
    }

    public void k() {
        this.f41289b = true;
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.f41291d) {
            return;
        }
        this.f41291d = f2;
        j();
    }

    public void m(@Nullable d.a.a.w.c<A> cVar) {
        d.a.a.w.c<A> cVar2 = this.f41292e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f41292e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
