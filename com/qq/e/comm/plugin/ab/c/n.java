package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.services.RetCodeService;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n implements e {

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static n f11745a = new n();
    }

    private n() {
    }

    public static n a() {
        return a.f11745a;
    }

    private void a(JSONObject jSONObject) {
        try {
            RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo(jSONObject.getString("host"), jSONObject.getString("cgi"), jSONObject.getString("jsver"), jSONObject.getInt("code"), jSONObject.getInt("duration"), jSONObject.optInt("reqsize", 0), jSONObject.optInt("rspsize", 0), jSONObject.optInt("type")));
        } catch (JSONException e) {
            GDTLogger.report("Exception While sendingRetCode", e);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        a(dVar.d());
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "sendRetCode";
    }
}
