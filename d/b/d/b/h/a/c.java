package d.b.d.b.h.a;

import android.content.Context;
import android.os.Process;
import com.baidu.searchbox.perfframe.ioc.Constant;
import d.b.d.b.l;
import d.b.d.b.m;
import io.reactivex.annotations.SchedulerSupport;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.tea.crash.c f65182a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65183b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.d.b.g f65184c = m.a().d();

    /* renamed from: d  reason: collision with root package name */
    public b f65185d;

    /* renamed from: e  reason: collision with root package name */
    public d f65186e;

    public c(com.bytedance.tea.crash.c cVar, Context context, b bVar, d dVar) {
        this.f65182a = cVar;
        this.f65183b = context;
        this.f65185d = bVar;
        this.f65186e = dVar;
    }

    public d.b.d.b.e.a a(d.b.d.b.e.a aVar) {
        if (aVar == null) {
            aVar = new d.b.d.b.e.a();
        }
        c(aVar);
        g(aVar);
        return aVar;
    }

    public boolean b() {
        return true;
    }

    public void c(d.b.d.b.e.a aVar) {
        b bVar;
        if (d() && (bVar = this.f65185d) != null) {
            aVar.e(bVar);
        }
        aVar.b(m.g());
        aVar.k("is_background", Boolean.valueOf(!l.b.g(this.f65183b)));
        aVar.k("pid", Integer.valueOf(Process.myPid()));
        aVar.k("battery", Integer.valueOf(this.f65186e.a()));
        aVar.h(this.f65184c.e());
        aVar.m(m.j());
        aVar.a(m.k(), m.l());
        aVar.g(this.f65184c.f());
        aVar.i(l.o.b(this.f65183b));
        if (b()) {
            f(aVar);
        }
        aVar.f(this.f65184c.d());
        String h2 = m.h();
        if (h2 != null) {
            aVar.k(Constant.KEY_BUSINESS, h2);
        }
        if (m.i()) {
            aVar.k("is_mp", 1);
        }
        aVar.n(m.c().b());
        aVar.k("crash_uuid", UUID.randomUUID().toString());
    }

    public boolean d() {
        return true;
    }

    public void e(d.b.d.b.e.a aVar) {
        Map<String, Object> a2 = m.a().a();
        if (a2 == null) {
            return;
        }
        if (a2.containsKey("app_version")) {
            aVar.k("crash_version", a2.get("app_version"));
        }
        if (a2.containsKey("version_name")) {
            aVar.k("app_version", a2.get("version_name"));
        }
        if (a2.containsKey("version_code")) {
            try {
                aVar.k("crash_version_code", Integer.valueOf(Integer.parseInt(a2.get("version_code").toString())));
            } catch (Exception unused) {
                aVar.k("crash_version_code", a2.get("version_code"));
            }
        }
        if (a2.containsKey("update_version_code")) {
            try {
                aVar.k("crash_update_version_code", Integer.valueOf(Integer.parseInt(a2.get("update_version_code").toString())));
            } catch (Exception unused2) {
                aVar.k("crash_update_version_code", a2.get("update_version_code"));
            }
        }
    }

    public void f(d.b.d.b.e.a aVar) {
        aVar.l(d.b.d.b.h.f.b(m.f().b(), m.f().c()));
    }

    public final void g(d.b.d.b.e.a aVar) {
        List<d.b.d.b.b> a2 = m.c().a(this.f65182a);
        if (a2 != null) {
            JSONObject jSONObject = new JSONObject();
            for (d.b.d.b.b bVar : a2) {
                Map<? extends String, ? extends String> a3 = bVar.a(this.f65182a);
                if (a3 != null) {
                    try {
                        for (String str : a3.keySet()) {
                            jSONObject.put(str, a3.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            aVar.k(SchedulerSupport.CUSTOM, jSONObject);
        }
    }
}
