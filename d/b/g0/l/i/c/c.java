package d.b.g0.l.i.c;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f48891a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f48892b;

    public c() {
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        return this.f48891a.get(cls);
    }

    public <T> Uri b(Class<T> cls) {
        return this.f48892b.get(cls);
    }

    public final void c() {
        this.f48891a = new ConcurrentHashMap<>();
        this.f48892b = new ConcurrentHashMap<>();
        this.f48891a.put(d.b.g0.l.k.f.class, new f());
        this.f48891a.put(d.b.g0.l.k.g.class, new g());
        this.f48891a.put(d.b.g0.l.k.d.class, new e());
        this.f48891a.put(d.b.g0.l.k.b.class, new d());
        this.f48891a.put(PMSAppInfo.class, new a());
        this.f48891a.put(d.b.g0.l.k.h.class, new h());
        this.f48891a.put(d.b.g0.l.k.i.class, new i());
        this.f48891a.put(d.b.g0.l.j.a.class, new d.b.g0.l.j.b.b());
        this.f48892b.put(d.b.g0.l.k.f.class, d.b.g0.l.i.e.b.f48900e);
        this.f48892b.put(d.b.g0.l.k.g.class, d.b.g0.l.i.e.b.f48901f);
        this.f48892b.put(d.b.g0.l.k.d.class, d.b.g0.l.i.e.b.f48898c);
        this.f48892b.put(d.b.g0.l.k.b.class, d.b.g0.l.i.e.b.f48902g);
        this.f48892b.put(PMSAppInfo.class, d.b.g0.l.i.e.b.f48899d);
        this.f48892b.put(d.b.g0.l.k.h.class, d.b.g0.l.i.e.b.f48903h);
        this.f48892b.put(d.b.g0.l.k.i.class, d.b.g0.l.i.e.b.i);
        this.f48892b.put(d.b.g0.l.j.a.class, d.b.g0.l.i.e.b.j);
    }
}
