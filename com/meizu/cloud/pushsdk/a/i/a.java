package com.meizu.cloud.pushsdk.a.i;

import com.meizu.cloud.pushsdk.a.a.e;
import com.meizu.cloud.pushsdk.a.d.k;
/* loaded from: classes2.dex */
public final class a {
    public static void a(k kVar, com.meizu.cloud.pushsdk.a.a.b bVar) {
        if (bVar.g() != e.OK_HTTP_RESPONSE && kVar != null && kVar.b() != null && kVar.b().a() != null) {
            try {
                kVar.b().a().close();
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.a.a.a.a("Unable to close source data");
            }
        }
    }
}
