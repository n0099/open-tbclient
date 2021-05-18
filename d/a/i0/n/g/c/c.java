package d.a.i0.n.g.c;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f47811a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f47812b;

    public c() {
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        return this.f47811a.get(cls);
    }

    public <T> Uri b(Class<T> cls) {
        return this.f47812b.get(cls);
    }

    public final void c() {
        this.f47811a = new ConcurrentHashMap<>();
        this.f47812b = new ConcurrentHashMap<>();
        this.f47811a.put(d.a.i0.n.h.f.class, new f());
        this.f47811a.put(d.a.i0.n.h.g.class, new g());
        this.f47811a.put(d.a.i0.n.h.d.class, new e());
        this.f47811a.put(d.a.i0.n.h.b.class, new d());
        this.f47811a.put(PMSAppInfo.class, new a());
        this.f47811a.put(d.a.i0.n.h.h.class, new h());
        this.f47811a.put(d.a.i0.n.h.i.class, new i());
        this.f47812b.put(d.a.i0.n.h.f.class, d.a.i0.n.g.e.b.f47820e);
        this.f47812b.put(d.a.i0.n.h.g.class, d.a.i0.n.g.e.b.f47821f);
        this.f47812b.put(d.a.i0.n.h.d.class, d.a.i0.n.g.e.b.f47818c);
        this.f47812b.put(d.a.i0.n.h.b.class, d.a.i0.n.g.e.b.f47822g);
        this.f47812b.put(PMSAppInfo.class, d.a.i0.n.g.e.b.f47819d);
        this.f47812b.put(d.a.i0.n.h.h.class, d.a.i0.n.g.e.b.f47823h);
        this.f47812b.put(d.a.i0.n.h.i.class, d.a.i0.n.g.e.b.f47824i);
    }
}
