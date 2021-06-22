package d.a.m0.n.g.c;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f51769a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f51770b;

    public c() {
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        return this.f51769a.get(cls);
    }

    public <T> Uri b(Class<T> cls) {
        return this.f51770b.get(cls);
    }

    public final void c() {
        this.f51769a = new ConcurrentHashMap<>();
        this.f51770b = new ConcurrentHashMap<>();
        this.f51769a.put(d.a.m0.n.h.f.class, new f());
        this.f51769a.put(d.a.m0.n.h.g.class, new g());
        this.f51769a.put(d.a.m0.n.h.d.class, new e());
        this.f51769a.put(d.a.m0.n.h.b.class, new d());
        this.f51769a.put(PMSAppInfo.class, new a());
        this.f51769a.put(d.a.m0.n.h.h.class, new h());
        this.f51769a.put(d.a.m0.n.h.i.class, new i());
        this.f51770b.put(d.a.m0.n.h.f.class, d.a.m0.n.g.e.b.f51778e);
        this.f51770b.put(d.a.m0.n.h.g.class, d.a.m0.n.g.e.b.f51779f);
        this.f51770b.put(d.a.m0.n.h.d.class, d.a.m0.n.g.e.b.f51776c);
        this.f51770b.put(d.a.m0.n.h.b.class, d.a.m0.n.g.e.b.f51780g);
        this.f51770b.put(PMSAppInfo.class, d.a.m0.n.g.e.b.f51777d);
        this.f51770b.put(d.a.m0.n.h.h.class, d.a.m0.n.g.e.b.f51781h);
        this.f51770b.put(d.a.m0.n.h.i.class, d.a.m0.n.g.e.b.f51782i);
    }
}
