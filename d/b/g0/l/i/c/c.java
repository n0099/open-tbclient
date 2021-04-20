package d.b.g0.l.i.c;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f49284a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f49285b;

    public c() {
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        return this.f49284a.get(cls);
    }

    public <T> Uri b(Class<T> cls) {
        return this.f49285b.get(cls);
    }

    public final void c() {
        this.f49284a = new ConcurrentHashMap<>();
        this.f49285b = new ConcurrentHashMap<>();
        this.f49284a.put(d.b.g0.l.k.f.class, new f());
        this.f49284a.put(d.b.g0.l.k.g.class, new g());
        this.f49284a.put(d.b.g0.l.k.d.class, new e());
        this.f49284a.put(d.b.g0.l.k.b.class, new d());
        this.f49284a.put(PMSAppInfo.class, new a());
        this.f49284a.put(d.b.g0.l.k.h.class, new h());
        this.f49284a.put(d.b.g0.l.k.i.class, new i());
        this.f49284a.put(d.b.g0.l.j.a.class, new d.b.g0.l.j.b.b());
        this.f49285b.put(d.b.g0.l.k.f.class, d.b.g0.l.i.e.b.f49293e);
        this.f49285b.put(d.b.g0.l.k.g.class, d.b.g0.l.i.e.b.f49294f);
        this.f49285b.put(d.b.g0.l.k.d.class, d.b.g0.l.i.e.b.f49291c);
        this.f49285b.put(d.b.g0.l.k.b.class, d.b.g0.l.i.e.b.f49295g);
        this.f49285b.put(PMSAppInfo.class, d.b.g0.l.i.e.b.f49292d);
        this.f49285b.put(d.b.g0.l.k.h.class, d.b.g0.l.i.e.b.f49296h);
        this.f49285b.put(d.b.g0.l.k.i.class, d.b.g0.l.i.e.b.i);
        this.f49285b.put(d.b.g0.l.j.a.class, d.b.g0.l.i.e.b.j);
    }
}
