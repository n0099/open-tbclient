package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k implements e {

    /* loaded from: classes4.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final k f12042a = new k();
    }

    private k() {
    }

    public static k a() {
        return a.f12042a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject d = dVar.d();
        if (d == null || !d.has("url")) {
            return;
        }
        String optString = d.optString("url");
        boolean optBoolean = d.optBoolean("imp", false);
        if (StringUtil.isEmpty(optString)) {
            return;
        }
        af.a(optString, optBoolean);
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "ping";
    }
}
