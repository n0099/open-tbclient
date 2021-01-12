package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class af {
    public static void a(String str) {
        a(str, true, null);
    }

    public static void a(String str, com.qq.e.comm.plugin.t.b bVar) {
        a(str, true, bVar);
    }

    public static void a(String str, boolean z) {
        a(str, z, null);
    }

    public static void a(final String str, boolean z, com.qq.e.comm.plugin.t.b bVar) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.d("ping url null!");
            return;
        }
        GDTLogger.d("PingUrlUtil        ping, url : " + str);
        com.qq.e.comm.plugin.t.b.c cVar = new com.qq.e.comm.plugin.t.b.c(str, e.a.GET, (byte[]) null);
        ai.a("gdt_tag_net", ai.a(cVar));
        com.qq.e.comm.plugin.t.c a2 = com.qq.e.comm.plugin.t.d.a();
        c.a aVar = z ? c.a.High : c.a.Low;
        if (bVar == null) {
            bVar = new com.qq.e.comm.plugin.t.b() { // from class: com.qq.e.comm.plugin.util.af.1
                @Override // com.qq.e.comm.plugin.t.b
                public void a(com.qq.e.comm.plugin.t.b.e eVar, com.qq.e.comm.plugin.t.b.f fVar) {
                    GDTLogger.d("PingUrlUtil  onResponse, url : " + str + " responseStatus : " + fVar.e());
                }

                @Override // com.qq.e.comm.plugin.t.b
                public void a(Exception exc) {
                    GDTLogger.e("PingUrlUtil onException, url:" + str + " errMsg : " + exc.getMessage());
                }
            };
        }
        a2.a(cVar, aVar, bVar);
    }
}
