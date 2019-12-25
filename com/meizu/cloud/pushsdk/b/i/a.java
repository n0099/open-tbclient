package com.meizu.cloud.pushsdk.b.i;

import com.meizu.cloud.pushsdk.b.a.e;
import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes5.dex */
public final class a {
    public static void a(k kVar, com.meizu.cloud.pushsdk.b.a.b bVar) {
        if (bVar.f() == e.OK_HTTP_RESPONSE || kVar == null || kVar.b() == null || kVar.b().a() == null) {
            return;
        }
        try {
            kVar.b().a().close();
        } catch (Exception e) {
            com.meizu.cloud.pushsdk.b.a.a.a("Unable to close source data");
        }
    }
}
