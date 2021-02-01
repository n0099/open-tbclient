package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.util.GDTLogger;
import com.vivo.push.PushClientConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class i implements e {

    /* loaded from: classes15.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final i f11742a = new i();
    }

    private i() {
    }

    public static i a() {
        return a.f11742a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        List<com.qq.e.comm.plugin.a.c> d = com.qq.e.comm.plugin.a.l.a().d();
        if (d == null || d.isEmpty()) {
            hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.ERROR, ""));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            for (com.qq.e.comm.plugin.a.c cVar : d) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("taskId", cVar.m());
                jSONObject2.put("logoUrl", cVar.i());
                jSONObject2.put("appName", cVar.f());
                jSONObject2.put(PushClientConstants.TAG_PKG_NAME, cVar.h());
                jSONObject2.put("progress", cVar.b("progress"));
                jSONObject2.put("totalSize", cVar.c("totalSize"));
                jSONObject2.put("status", cVar.o());
                jSONObject2.put("nTag", cVar.a("notifyTag"));
                jSONObject2.put("nId", cVar.b("notifyId"));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("list", jSONArray);
        } catch (JSONException e) {
            hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.ERROR, ""));
            GDTLogger.w("LoadDownloadingTask Json Err");
        }
        hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.OK, jSONObject));
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "loadDownloadingTask";
    }
}
