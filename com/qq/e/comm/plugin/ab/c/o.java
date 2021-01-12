package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.y.u;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o implements e {

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final o f11746a = new o();
    }

    public static final o a() {
        return a.f11746a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject d = dVar.d();
        int optInt = d.optInt("code", 0);
        JSONObject optJSONObject = d.optJSONObject("paras");
        if (optJSONObject != null) {
            u.a(90002, optInt, null, new com.qq.e.comm.plugin.y.d(optJSONObject));
        }
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "sdkServerReport";
    }
}
