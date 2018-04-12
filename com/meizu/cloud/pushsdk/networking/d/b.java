package com.meizu.cloud.pushsdk.networking.d;

import com.meizu.cloud.pushsdk.networking.b.i;
import com.meizu.cloud.pushsdk.networking.b.k;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import java.io.File;
import java.io.IOException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class b {
    public static String a = null;

    public static k a(com.meizu.cloud.pushsdk.networking.common.b bVar) throws ANError {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            switch (bVar.c()) {
                case 0:
                    a2 = a2.a();
                    break;
                case 1:
                    a2 = a2.a(bVar.q());
                    break;
                case 2:
                    a2 = a2.c(bVar.q());
                    break;
                case 3:
                    a2 = a2.b(bVar.q());
                    break;
                case 4:
                    a2 = a2.b();
                    break;
                case 5:
                    a2 = a2.d(bVar.q());
                    break;
            }
            bVar.a(new com.meizu.cloud.pushsdk.networking.b.e(a2.c()));
            return bVar.n().a();
        } catch (IOException e) {
            throw new ANError(e);
        }
    }

    public static k b(com.meizu.cloud.pushsdk.networking.common.b bVar) throws ANError {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            bVar.a(new com.meizu.cloud.pushsdk.networking.b.e(a2.a().c()));
            k a3 = bVar.n().a();
            com.meizu.cloud.pushsdk.networking.e.b.a(a3, bVar.l(), bVar.m());
            return a3;
        } catch (IOException e) {
            try {
                File file = new File(bVar.l() + File.separator + bVar.m());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new ANError(e);
        }
    }

    public static k c(com.meizu.cloud.pushsdk.networking.common.b bVar) throws ANError {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            bVar.a(new com.meizu.cloud.pushsdk.networking.b.e(a2.a(new d(bVar.r(), bVar.k())).c()));
            return bVar.n().a();
        } catch (IOException e) {
            throw new ANError(e);
        }
    }

    public static void a(i.a aVar, com.meizu.cloud.pushsdk.networking.common.b bVar) {
        if (bVar.i() != null) {
            aVar.a(HTTP.USER_AGENT, bVar.i());
        } else if (a != null) {
            bVar.a(a);
            aVar.a(HTTP.USER_AGENT, a);
        }
        com.meizu.cloud.pushsdk.networking.b.c s = bVar.s();
        if (s != null) {
            aVar.a(s);
            if (bVar.i() != null && !s.b().contains(HTTP.USER_AGENT)) {
                aVar.a(HTTP.USER_AGENT, bVar.i());
            }
        }
    }
}
