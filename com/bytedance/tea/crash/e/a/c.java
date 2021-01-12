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
/* loaded from: classes4.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected com.bytedance.tea.crash.c f7636a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f7637b;
    protected com.bytedance.tea.crash.d plx = h.eoL().eoF();
    protected b ply;
    protected d plz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.bytedance.tea.crash.c cVar, Context context, b bVar, d dVar) {
        this.f7636a = cVar;
        this.f7637b = context;
        this.ply = bVar;
        this.plz = dVar;
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
        if (b() && this.ply != null) {
            aVar.a(this.ply);
        }
        aVar.iv(h.f());
        aVar.a("is_background", Boolean.valueOf(!com.bytedance.tea.crash.g.a.a(this.f7637b)));
        aVar.a("pid", Integer.valueOf(Process.myPid()));
        aVar.a("battery", Integer.valueOf(this.plz.a()));
        aVar.J(this.plx.e());
        aVar.K(h.eoP());
        aVar.cb(h.j(), h.k());
        aVar.gI(this.plx.f());
        aVar.eS(n.a(this.f7637b));
        if (a()) {
            e(aVar);
        }
        aVar.XQ(this.plx.d());
        String g = h.g();
        if (g != null) {
            aVar.a(Constant.KEY_BUSINESS, g);
        }
        if (h.h()) {
            aVar.a("is_mp", 1);
        }
        aVar.L(h.eoM().a());
        aVar.a("crash_uuid", UUID.randomUUID().toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.tea.crash.c.a aVar) {
        Map<String, Object> a2 = h.eoL().a();
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
        List<com.bytedance.tea.crash.a> b2 = h.eoM().b(this.f7636a);
        if (b2 != null) {
            JSONObject jSONObject = new JSONObject();
            for (com.bytedance.tea.crash.a aVar2 : b2) {
                Map<? extends String, ? extends String> a2 = aVar2.a(this.f7636a);
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
        aVar.gJ(com.bytedance.tea.crash.e.e.a(h.eoO().b(), h.eoO().c()));
    }

    protected boolean a() {
        return true;
    }

    protected boolean b() {
        return true;
    }
}
