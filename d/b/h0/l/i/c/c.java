package d.b.h0.l.i.c;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f49613a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f49614b;

    public c() {
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        return this.f49613a.get(cls);
    }

    public <T> Uri b(Class<T> cls) {
        return this.f49614b.get(cls);
    }

    public final void c() {
        this.f49613a = new ConcurrentHashMap<>();
        this.f49614b = new ConcurrentHashMap<>();
        this.f49613a.put(d.b.h0.l.k.f.class, new f());
        this.f49613a.put(d.b.h0.l.k.g.class, new g());
        this.f49613a.put(d.b.h0.l.k.d.class, new e());
        this.f49613a.put(d.b.h0.l.k.b.class, new d());
        this.f49613a.put(PMSAppInfo.class, new a());
        this.f49613a.put(d.b.h0.l.k.h.class, new h());
        this.f49613a.put(d.b.h0.l.k.i.class, new i());
        this.f49613a.put(d.b.h0.l.j.a.class, new d.b.h0.l.j.b.b());
        this.f49614b.put(d.b.h0.l.k.f.class, d.b.h0.l.i.e.b.f49622e);
        this.f49614b.put(d.b.h0.l.k.g.class, d.b.h0.l.i.e.b.f49623f);
        this.f49614b.put(d.b.h0.l.k.d.class, d.b.h0.l.i.e.b.f49620c);
        this.f49614b.put(d.b.h0.l.k.b.class, d.b.h0.l.i.e.b.f49624g);
        this.f49614b.put(PMSAppInfo.class, d.b.h0.l.i.e.b.f49621d);
        this.f49614b.put(d.b.h0.l.k.h.class, d.b.h0.l.i.e.b.f49625h);
        this.f49614b.put(d.b.h0.l.k.i.class, d.b.h0.l.i.e.b.i);
        this.f49614b.put(d.b.h0.l.j.a.class, d.b.h0.l.i.e.b.j);
    }
}
