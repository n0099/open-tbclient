package com.meizu.cloud.pushsdk.networking.e;

import com.meizu.cloud.pushsdk.networking.b.k;
import com.meizu.cloud.pushsdk.networking.common.ResponseType;
/* loaded from: classes3.dex */
public final class a {
    public static void a(k kVar, com.meizu.cloud.pushsdk.networking.common.b bVar) {
        if (bVar.g() != ResponseType.OK_HTTP_RESPONSE && kVar != null && kVar.b() != null && kVar.b().a() != null) {
            try {
                kVar.b().a().close();
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.networking.common.a.a("Unable to close source data");
            }
        }
    }
}
