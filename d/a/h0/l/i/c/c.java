package d.a.h0.l.i.c;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f47120a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f47121b;

    public c() {
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        return this.f47120a.get(cls);
    }

    public <T> Uri b(Class<T> cls) {
        return this.f47121b.get(cls);
    }

    public final void c() {
        this.f47120a = new ConcurrentHashMap<>();
        this.f47121b = new ConcurrentHashMap<>();
        this.f47120a.put(d.a.h0.l.k.f.class, new f());
        this.f47120a.put(d.a.h0.l.k.g.class, new g());
        this.f47120a.put(d.a.h0.l.k.d.class, new e());
        this.f47120a.put(d.a.h0.l.k.b.class, new d());
        this.f47120a.put(PMSAppInfo.class, new a());
        this.f47120a.put(d.a.h0.l.k.h.class, new h());
        this.f47120a.put(d.a.h0.l.k.i.class, new i());
        this.f47120a.put(d.a.h0.l.j.a.class, new d.a.h0.l.j.b.b());
        this.f47121b.put(d.a.h0.l.k.f.class, d.a.h0.l.i.e.b.f47129e);
        this.f47121b.put(d.a.h0.l.k.g.class, d.a.h0.l.i.e.b.f47130f);
        this.f47121b.put(d.a.h0.l.k.d.class, d.a.h0.l.i.e.b.f47127c);
        this.f47121b.put(d.a.h0.l.k.b.class, d.a.h0.l.i.e.b.f47131g);
        this.f47121b.put(PMSAppInfo.class, d.a.h0.l.i.e.b.f47128d);
        this.f47121b.put(d.a.h0.l.k.h.class, d.a.h0.l.i.e.b.f47132h);
        this.f47121b.put(d.a.h0.l.k.i.class, d.a.h0.l.i.e.b.f47133i);
        this.f47121b.put(d.a.h0.l.j.a.class, d.a.h0.l.i.e.b.j);
    }
}
