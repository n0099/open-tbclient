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
    protected com.bytedance.tea.crash.c f7638a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f7639b;
    protected com.bytedance.tea.crash.d pwn = h.erl().erf();
    protected b pwo;
    protected d pwp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.bytedance.tea.crash.c cVar, Context context, b bVar, d dVar) {
        this.f7638a = cVar;
        this.f7639b = context;
        this.pwo = bVar;
        this.pwp = dVar;
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
        if (b() && this.pwo != null) {
            aVar.a(this.pwo);
        }
        aVar.iy(h.f());
        aVar.a("is_background", Boolean.valueOf(!com.bytedance.tea.crash.g.a.a(this.f7639b)));
        aVar.a("pid", Integer.valueOf(Process.myPid()));
        aVar.a("battery", Integer.valueOf(this.pwp.a()));
        aVar.L(this.pwn.e());
        aVar.M(h.erp());
        aVar.ci(h.j(), h.k());
        aVar.gG(this.pwn.f());
        aVar.eT(n.a(this.f7639b));
        if (a()) {
            e(aVar);
        }
        aVar.Ze(this.pwn.d());
        String g = h.g();
        if (g != null) {
            aVar.a(Constant.KEY_BUSINESS, g);
        }
        if (h.h()) {
            aVar.a("is_mp", 1);
        }
        aVar.N(h.erm().a());
        aVar.a("crash_uuid", UUID.randomUUID().toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.tea.crash.c.a aVar) {
        Map<String, Object> a2 = h.erl().a();
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
        List<com.bytedance.tea.crash.a> b2 = h.erm().b(this.f7638a);
        if (b2 != null) {
            JSONObject jSONObject = new JSONObject();
            for (com.bytedance.tea.crash.a aVar2 : b2) {
                Map<? extends String, ? extends String> a2 = aVar2.a(this.f7638a);
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
        aVar.gH(com.bytedance.tea.crash.e.e.a(h.ero().b(), h.ero().c()));
    }

    protected boolean a() {
        return true;
    }

    protected boolean b() {
        return true;
    }
}
