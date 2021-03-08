package com.bytedance.tea.crash.e.a;

import android.content.Context;
import android.os.Process;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.bytedance.tea.crash.g.n;
import com.bytedance.tea.crash.h;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected com.bytedance.tea.crash.c f5169a;
    protected Context b;
    protected com.bytedance.tea.crash.d pyq = h.erv().ero();
    protected b pyr;
    protected d pys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.bytedance.tea.crash.c cVar, Context context, b bVar, d dVar) {
        this.f5169a = cVar;
        this.b = context;
        this.pyr = bVar;
        this.pys = dVar;
    }

    public com.bytedance.tea.crash.c.a a(com.bytedance.tea.crash.c.a aVar) {
        if (aVar == null) {
            aVar = new com.bytedance.tea.crash.c.a();
        }
        b(aVar);
        d(aVar);
        return aVar;
    }

    void b(com.bytedance.tea.crash.c.a aVar) {
        if (b() && this.pyr != null) {
            aVar.a(this.pyr);
        }
        aVar.iy(h.f());
        aVar.a("is_background", Boolean.valueOf(!com.bytedance.tea.crash.g.a.a(this.b)));
        aVar.a("pid", Integer.valueOf(Process.myPid()));
        aVar.a("battery", Integer.valueOf(this.pys.a()));
        aVar.L(this.pyq.e());
        aVar.M(h.erz());
        aVar.ci(h.j(), h.k());
        aVar.gG(this.pyq.f());
        aVar.eW(n.a(this.b));
        if (a()) {
            e(aVar);
        }
        aVar.Zl(this.pyq.d());
        String g = h.g();
        if (g != null) {
            aVar.a(Constant.KEY_BUSINESS, g);
        }
        if (h.h()) {
            aVar.a("is_mp", 1);
        }
        aVar.N(h.erw().a());
        aVar.a("crash_uuid", UUID.randomUUID().toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.tea.crash.c.a aVar) {
        Map<String, Object> a2 = h.erv().a();
        if (a2 != null) {
            if (a2.containsKey("app_version")) {
                aVar.a("crash_version", a2.get("app_version"));
            }
            if (a2.containsKey(SharedPrefConfig.VERSION_NAME)) {
                aVar.a("app_version", a2.get(SharedPrefConfig.VERSION_NAME));
            }
            if (a2.containsKey("version_code")) {
                try {
                    aVar.a("crash_version_code", Integer.valueOf(Integer.parseInt(a2.get("version_code").toString())));
                } catch (Exception e) {
                    aVar.a("crash_version_code", a2.get("version_code"));
                }
            }
            if (a2.containsKey("update_version_code")) {
                try {
                    aVar.a("crash_update_version_code", Integer.valueOf(Integer.parseInt(a2.get("update_version_code").toString())));
                } catch (Exception e2) {
                    aVar.a("crash_update_version_code", a2.get("update_version_code"));
                }
            }
        }
    }

    private void d(com.bytedance.tea.crash.c.a aVar) {
        List<com.bytedance.tea.crash.a> b = h.erw().b(this.f5169a);
        if (b != null) {
            JSONObject jSONObject = new JSONObject();
            for (com.bytedance.tea.crash.a aVar2 : b) {
                Map<? extends String, ? extends String> a2 = aVar2.a(this.f5169a);
                if (a2 != null) {
                    try {
                        for (String str : a2.keySet()) {
                            jSONObject.put(str, a2.get(str));
                        }
                    } catch (Throwable th) {
                    }
                }
            }
            aVar.a("custom", jSONObject);
        }
    }

    protected void e(com.bytedance.tea.crash.c.a aVar) {
        aVar.gH(com.bytedance.tea.crash.e.e.a(h.ery().b(), h.ery().c()));
    }

    protected boolean a() {
        return true;
    }

    protected boolean b() {
        return true;
    }
}
