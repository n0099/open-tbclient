package com.qq.e.comm.plugin.ab.c;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h implements e {

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final h f11739a = new h();
    }

    private h() {
    }

    public static h a() {
        return a.f11739a;
    }

    private com.qq.e.comm.plugin.ad.b a(com.qq.e.comm.plugin.ad.e eVar, JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("jsver");
        JSONObject optJSONObject = jSONObject.optJSONObject("extreq");
        int optInt = jSONObject.optInt("adposcount");
        int optInt2 = jSONObject.optInt("count");
        int optInt3 = jSONObject.optInt("posw");
        int optInt4 = jSONObject.optInt("posh");
        int optInt5 = jSONObject.optInt("reqtype");
        com.qq.e.comm.plugin.ad.b bVar = new com.qq.e.comm.plugin.ad.b();
        bVar.a(optJSONObject);
        if (optInt <= 0) {
            optInt = 1;
        }
        bVar.c(optInt);
        bVar.d(optInt2 > 0 ? optInt2 : eVar.c());
        bVar.a(str);
        if (optInt3 <= 0 || optInt4 <= 0) {
            com.qq.e.comm.plugin.ad.d a2 = com.qq.e.comm.plugin.ad.c.a(eVar, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
            bVar.f(a2.a());
            bVar.g(a2.b());
        } else {
            bVar.f(optInt3);
            bVar.g(optInt4);
        }
        if (eVar == com.qq.e.comm.plugin.ad.e.APP_WALL) {
            bVar.i(optInt5);
        }
        bVar.e(2);
        bVar.h(eVar.b());
        bVar.b(optString);
        return bVar;
    }

    private void a(final com.qq.e.comm.plugin.ab.h hVar, final com.qq.e.comm.plugin.ab.b.d dVar, String str, com.qq.e.comm.plugin.ad.b bVar) throws JSONException {
        com.qq.e.comm.plugin.ad.e c = hVar.e().c();
        com.qq.e.comm.plugin.w.e.a(bVar, new com.qq.e.comm.plugin.w.b(hVar.e().a(), c, str), new e.a() { // from class: com.qq.e.comm.plugin.ab.c.h.1
            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(com.qq.e.comm.plugin.k.a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(TiebaInitialize.LogFields.ERROR_CODE, Integer.valueOf(aVar.a()));
                hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.ERROR, new JSONObject(hashMap)));
            }

            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(JSONObject jSONObject) {
                hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.OK, jSONObject.toString()));
            }
        });
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        String b2 = dVar.b();
        com.qq.e.comm.plugin.ad.e a2 = com.qq.e.comm.plugin.ad.e.a(b2);
        if (a2 == null) {
            GDTLogger.e("loadAD with error action(adtype)" + b2);
            return;
        }
        JSONObject d = dVar.d();
        if (d == null) {
            GDTLogger.e("ParaObj should not be null while loadAD");
            return;
        }
        try {
            String optString = d.optString("posid");
            a(hVar, dVar, optString, a(a2, d, optString));
        } catch (Throwable th) {
            GDTLogger.report("Exception occurred while Loading AD,request=" + dVar, th);
            hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.ERROR, "Exception occurred when fetching ad"));
        }
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "loadAD";
    }
}
