package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.c.e;
import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.c.c.k;
import java.io.File;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class a {
    public static String a;

    public static k a(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            int d = bVar.d();
            if (d == 0) {
                a2 = a2.a();
            } else if (d == 1) {
                a2 = a2.a(bVar.m());
            } else if (d == 2) {
                a2 = a2.c(bVar.m());
            } else if (d == 3) {
                a2 = a2.b(bVar.m());
            } else if (d == 4) {
                a2 = a2.b();
            } else if (d == 5) {
                a2 = a2.d(bVar.m());
            }
            i c = a2.c();
            bVar.a(new e());
            return bVar.l().a(c);
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(i.a aVar, com.meizu.cloud.pushsdk.c.a.b bVar) {
        String str;
        com.meizu.cloud.pushsdk.c.c.c o;
        if (bVar.h() == null) {
            String str2 = a;
            if (str2 != null) {
                bVar.a(str2);
                str = a;
            }
            o = bVar.o();
            if (o == null) {
                aVar.a(o);
                if (bVar.h() == null || o.b().contains("User-Agent")) {
                    return;
                }
                aVar.a("User-Agent", bVar.h());
                return;
            }
            return;
        }
        str = bVar.h();
        aVar.a("User-Agent", str);
        o = bVar.o();
        if (o == null) {
        }
    }

    public static k b(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            i c = a2.a().c();
            bVar.a(new e());
            k a3 = bVar.l().a(c);
            com.meizu.cloud.pushsdk.c.h.b.a(a3, bVar.j(), bVar.k());
            return a3;
        } catch (IOException e) {
            try {
                File file = new File(bVar.j() + File.separator + bVar.k());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }

    public static k c(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            i c = a2.a(new b(bVar.n(), bVar.i())).c();
            bVar.a(new e());
            return bVar.l().a(c);
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }
}
