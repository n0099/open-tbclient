package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.a.e;
import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes5.dex */
public final class c {
    public static <T> com.meizu.cloud.pushsdk.b.a.c<T> a(com.meizu.cloud.pushsdk.b.a.b bVar) {
        switch (bVar.g()) {
            case 0:
                return b(bVar);
            case 1:
                return c(bVar);
            case 2:
                return d(bVar);
            default:
                return new com.meizu.cloud.pushsdk.b.a.c<>(new com.meizu.cloud.pushsdk.b.b.a());
        }
    }

    private static <T> com.meizu.cloud.pushsdk.b.a.c<T> b(com.meizu.cloud.pushsdk.b.a.b bVar) {
        com.meizu.cloud.pushsdk.b.a.c<T> cVar;
        k kVar = null;
        try {
            kVar = a.a(bVar);
            if (kVar == null) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
            } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(kVar);
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
            } else if (kVar.a() >= 400) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(kVar), bVar, kVar.a()));
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
            } else {
                cVar = bVar.a(kVar);
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
            }
        } catch (com.meizu.cloud.pushsdk.b.b.a e) {
            cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(e)));
        } catch (Exception e2) {
            cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e2));
        } finally {
            com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
        }
        return cVar;
    }

    private static <T> com.meizu.cloud.pushsdk.b.a.c<T> c(com.meizu.cloud.pushsdk.b.a.b bVar) {
        com.meizu.cloud.pushsdk.b.a.c<T> cVar;
        try {
            k b2 = a.b(bVar);
            if (b2 == null) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
            } else if (b2.a() >= 400) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(b2), bVar, b2.a()));
                cVar.a(b2);
            } else {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>("success");
                cVar.a(b2);
            }
            return cVar;
        } catch (com.meizu.cloud.pushsdk.b.b.a e) {
            return new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(e)));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e2));
        }
    }

    private static <T> com.meizu.cloud.pushsdk.b.a.c<T> d(com.meizu.cloud.pushsdk.b.a.b bVar) {
        com.meizu.cloud.pushsdk.b.a.c<T> cVar;
        k kVar = null;
        try {
            kVar = a.c(bVar);
            if (kVar == null) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
            } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(kVar);
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
            } else if (kVar.a() >= 400) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(kVar), bVar, kVar.a()));
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
            } else {
                cVar = bVar.a(kVar);
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
            }
        } catch (com.meizu.cloud.pushsdk.b.b.a e) {
            cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e));
        } catch (Exception e2) {
            cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e2));
        } finally {
            com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
        }
        return cVar;
    }
}
