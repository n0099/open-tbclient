package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class l implements e {

    /* loaded from: classes15.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final l f11745a = new l();
    }

    private l() {
    }

    public static l a() {
        return a.f11745a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject d = dVar.d();
        if (d == null) {
            return;
        }
        int optInt = d.optInt("taskId");
        int optInt2 = d.optInt("nId");
        if (!com.qq.e.comm.plugin.a.l.a().a(optInt, d.optString("nTag"), optInt2)) {
            hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.ERROR, ""));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taskId", optInt);
        } catch (JSONException e) {
            hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.ERROR, ""));
        }
        hVar.b().a(new com.qq.e.comm.plugin.ab.b.e(dVar, e.a.OK, jSONObject));
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "removeDownloadTask";
    }
}
