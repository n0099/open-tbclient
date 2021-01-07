package com.qq.e.comm.plugin.ab.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p implements e {

    /* loaded from: classes4.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final p f12047a = new p();
    }

    private p() {
    }

    public static p a() {
        return a.f12047a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject d = dVar.d();
        if (d == null) {
            return;
        }
        com.qq.e.comm.plugin.a.l.a().a(d.optInt("taskId"), d.optInt("progress"), d.optLong("totalSize"));
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "updateDownloadProgress";
    }
}
