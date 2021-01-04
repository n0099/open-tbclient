package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements e {

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final c f12027a = new c();
    }

    private c() {
    }

    public static c a() {
        return a.f12027a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject d = dVar.d();
        if (d == null || !d.has("url")) {
            GDTLogger.e("InvokeBrowserHandler with illegal paras,request:" + dVar);
        } else {
            a(hVar, d.optString("url"), d.optString("browsertype"));
        }
    }

    public void a(com.qq.e.comm.plugin.ab.h hVar, String str, String str2) {
        if ("innerbrowser".equals(str2)) {
            com.qq.e.comm.plugin.c.c.a(str, null);
        } else if ("website".equals(str2)) {
            com.qq.e.comm.plugin.c.c.a(str);
        } else if ("loadurl".equals(str2)) {
            hVar.a(str);
        } else {
            com.qq.e.comm.plugin.c.c.a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "loadURL";
    }
}
