package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements e {

    /* renamed from: com.qq.e.comm.plugin.ab.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C1186a {

        /* renamed from: a  reason: collision with root package name */
        static final a f11726a = new a();
    }

    private a() {
    }

    public static final a a() {
        return C1186a.f11726a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject d = dVar.d();
        String optString = d.optString("type", "");
        JSONObject optJSONObject = d.optJSONObject("paras");
        if (StringUtil.isEmpty(optString)) {
            GDTLogger.report("Invoke ADEvent Handler with out evtType in paras");
            return;
        }
        com.qq.e.comm.plugin.ab.a.a a2 = com.qq.e.comm.plugin.ab.a.a.a(optString, optJSONObject);
        if (a2 != null) {
            for (com.qq.e.comm.plugin.ab.a.b bVar : hVar.d()) {
                bVar.a(a2);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "adEvent";
    }
}
