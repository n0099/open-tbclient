package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.e;
import com.meizu.cloud.pushsdk.b.c.i;
import com.meizu.cloud.pushsdk.b.c.k;
import java.io.File;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f11184a = null;

    public static k a(com.meizu.cloud.pushsdk.b.a.b bVar) throws com.meizu.cloud.pushsdk.b.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            switch (bVar.d()) {
                case 0:
                    a2 = a2.a();
                    break;
                case 1:
                    a2 = a2.a(bVar.m());
                    break;
                case 2:
                    a2 = a2.c(bVar.m());
                    break;
                case 3:
                    a2 = a2.b(bVar.m());
                    break;
                case 4:
                    a2 = a2.b();
                    break;
                case 5:
                    a2 = a2.d(bVar.m());
                    break;
            }
            i c = a2.c();
            bVar.a(new e());
            return bVar.l().a(c);
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.b.b.a(e);
        }
    }

    public static void a(i.a aVar, com.meizu.cloud.pushsdk.b.a.b bVar) {
        if (bVar.h() != null) {
            aVar.a("User-Agent", bVar.h());
        } else if (f11184a != null) {
            bVar.a(f11184a);
            aVar.a("User-Agent", f11184a);
        }
        com.meizu.cloud.pushsdk.b.c.c o = bVar.o();
        if (o != null) {
            aVar.a(o);
            if (bVar.h() == null || o.b().contains("User-Agent")) {
                return;
            }
            aVar.a("User-Agent", bVar.h());
        }
    }

    public static k b(com.meizu.cloud.pushsdk.b.a.b bVar) throws com.meizu.cloud.pushsdk.b.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            i c = a2.a().c();
            bVar.a(new e());
            k a3 = bVar.l().a(c);
            com.meizu.cloud.pushsdk.b.i.b.a(a3, bVar.j(), bVar.k());
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
            throw new com.meizu.cloud.pushsdk.b.b.a(e);
        }
    }

    public static k c(com.meizu.cloud.pushsdk.b.a.b bVar) throws com.meizu.cloud.pushsdk.b.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            i c = a2.a(new b(bVar.n(), bVar.i())).c();
            bVar.a(new e());
            return bVar.l().a(c);
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.b.b.a(e);
        }
    }
}
