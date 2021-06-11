package d.a.l0.n.g.c;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f51661a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f51662b;

    public c() {
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        return this.f51661a.get(cls);
    }

    public <T> Uri b(Class<T> cls) {
        return this.f51662b.get(cls);
    }

    public final void c() {
        this.f51661a = new ConcurrentHashMap<>();
        this.f51662b = new ConcurrentHashMap<>();
        this.f51661a.put(d.a.l0.n.h.f.class, new f());
        this.f51661a.put(d.a.l0.n.h.g.class, new g());
        this.f51661a.put(d.a.l0.n.h.d.class, new e());
        this.f51661a.put(d.a.l0.n.h.b.class, new d());
        this.f51661a.put(PMSAppInfo.class, new a());
        this.f51661a.put(d.a.l0.n.h.h.class, new h());
        this.f51661a.put(d.a.l0.n.h.i.class, new i());
        this.f51662b.put(d.a.l0.n.h.f.class, d.a.l0.n.g.e.b.f51670e);
        this.f51662b.put(d.a.l0.n.h.g.class, d.a.l0.n.g.e.b.f51671f);
        this.f51662b.put(d.a.l0.n.h.d.class, d.a.l0.n.g.e.b.f51668c);
        this.f51662b.put(d.a.l0.n.h.b.class, d.a.l0.n.g.e.b.f51672g);
        this.f51662b.put(PMSAppInfo.class, d.a.l0.n.g.e.b.f51669d);
        this.f51662b.put(d.a.l0.n.h.h.class, d.a.l0.n.g.e.b.f51673h);
        this.f51662b.put(d.a.l0.n.h.i.class, d.a.l0.n.g.e.b.f51674i);
    }
}
