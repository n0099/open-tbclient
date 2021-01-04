package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements e {

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final m f12043a = new m();
    }

    private m() {
    }

    public static m a() {
        return a.f12043a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject d = dVar.d();
        if (d == null) {
            return;
        }
        int optInt = d.optInt("taskId");
        if (!com.qq.e.comm.plugin.a.l.a().a(optInt)) {
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
        return "resumeDownloadTask";
    }
}
