package d.a.l0.n.g.c;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f47987a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f47988b;

    public c() {
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        return this.f47987a.get(cls);
    }

    public <T> Uri b(Class<T> cls) {
        return this.f47988b.get(cls);
    }

    public final void c() {
        this.f47987a = new ConcurrentHashMap<>();
        this.f47988b = new ConcurrentHashMap<>();
        this.f47987a.put(d.a.l0.n.h.f.class, new f());
        this.f47987a.put(d.a.l0.n.h.g.class, new g());
        this.f47987a.put(d.a.l0.n.h.d.class, new e());
        this.f47987a.put(d.a.l0.n.h.b.class, new d());
        this.f47987a.put(PMSAppInfo.class, new a());
        this.f47987a.put(d.a.l0.n.h.h.class, new h());
        this.f47987a.put(d.a.l0.n.h.i.class, new i());
        this.f47988b.put(d.a.l0.n.h.f.class, d.a.l0.n.g.e.b.f47996e);
        this.f47988b.put(d.a.l0.n.h.g.class, d.a.l0.n.g.e.b.f47997f);
        this.f47988b.put(d.a.l0.n.h.d.class, d.a.l0.n.g.e.b.f47994c);
        this.f47988b.put(d.a.l0.n.h.b.class, d.a.l0.n.g.e.b.f47998g);
        this.f47988b.put(PMSAppInfo.class, d.a.l0.n.g.e.b.f47995d);
        this.f47988b.put(d.a.l0.n.h.h.class, d.a.l0.n.g.e.b.f47999h);
        this.f47988b.put(d.a.l0.n.h.i.class, d.a.l0.n.g.e.b.f48000i);
    }
}
