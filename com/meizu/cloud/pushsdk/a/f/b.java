package com.meizu.cloud.pushsdk.a.f;

import com.meizu.cloud.pushsdk.a.d.i;
import com.meizu.cloud.pushsdk.a.d.k;
import java.io.File;
import java.io.IOException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public final class b {
    public static String a = null;

    public static k a(com.meizu.cloud.pushsdk.a.a.b bVar) throws com.meizu.cloud.pushsdk.a.c.a {
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
            bVar.a(new com.meizu.cloud.pushsdk.a.d.e(a2.c()));
            return bVar.n().a();
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.a.c.a(e);
        }
    }

    public static k b(com.meizu.cloud.pushsdk.a.a.b bVar) throws com.meizu.cloud.pushsdk.a.c.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            bVar.a(new com.meizu.cloud.pushsdk.a.d.e(a2.a().c()));
            k a3 = bVar.n().a();
            com.meizu.cloud.pushsdk.a.i.b.a(a3, bVar.l(), bVar.m());
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
            throw new com.meizu.cloud.pushsdk.a.c.a(e);
        }
    }

    public static k c(com.meizu.cloud.pushsdk.a.a.b bVar) throws com.meizu.cloud.pushsdk.a.c.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            bVar.a(new com.meizu.cloud.pushsdk.a.d.e(a2.a(new d(bVar.r(), bVar.k())).c()));
            return bVar.n().a();
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.a.c.a(e);
        }
    }

    public static void a(i.a aVar, com.meizu.cloud.pushsdk.a.a.b bVar) {
        if (bVar.i() != null) {
            aVar.a(HTTP.USER_AGENT, bVar.i());
        } else if (a != null) {
            bVar.a(a);
            aVar.a(HTTP.USER_AGENT, a);
        }
        com.meizu.cloud.pushsdk.a.d.c s = bVar.s();
        if (s != null) {
            aVar.a(s);
            if (bVar.i() != null && !s.b().contains(HTTP.USER_AGENT)) {
                aVar.a(HTTP.USER_AGENT, bVar.i());
            }
        }
    }
}
