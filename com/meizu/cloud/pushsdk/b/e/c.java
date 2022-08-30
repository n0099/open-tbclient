package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.a.e;
import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes7.dex */
public final class c {
    public static <T> com.meizu.cloud.pushsdk.b.a.c<T> a(com.meizu.cloud.pushsdk.b.a.b bVar) {
        int g = bVar.g();
        return g != 0 ? g != 1 ? g != 2 ? new com.meizu.cloud.pushsdk.b.a.c<>(new com.meizu.cloud.pushsdk.b.b.a()) : d(bVar) : c(bVar) : b(bVar);
    }

    public static <T> com.meizu.cloud.pushsdk.b.a.c<T> b(com.meizu.cloud.pushsdk.b.a.b bVar) {
        try {
            try {
                k a = a.a(bVar);
                if (a == null) {
                    com.meizu.cloud.pushsdk.b.a.c<T> cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
                    com.meizu.cloud.pushsdk.b.i.a.a(a, bVar);
                    return cVar;
                } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                    com.meizu.cloud.pushsdk.b.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.b.a.c<>(a);
                    cVar2.a(a);
                    com.meizu.cloud.pushsdk.b.i.a.a(a, bVar);
                    return cVar2;
                } else if (a.a() >= 400) {
                    com.meizu.cloud.pushsdk.b.a.c<T> cVar3 = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(a), bVar, a.a()));
                    cVar3.a(a);
                    com.meizu.cloud.pushsdk.b.i.a.a(a, bVar);
                    return cVar3;
                } else {
                    com.meizu.cloud.pushsdk.b.a.c<T> a2 = bVar.a(a);
                    a2.a(a);
                    com.meizu.cloud.pushsdk.b.i.a.a(a, bVar);
                    return a2;
                }
            } catch (com.meizu.cloud.pushsdk.b.b.a e) {
                com.meizu.cloud.pushsdk.b.a.c<T> cVar4 = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(e)));
                com.meizu.cloud.pushsdk.b.i.a.a(null, bVar);
                return cVar4;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.b.a.c<T> cVar5 = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e2));
                com.meizu.cloud.pushsdk.b.i.a.a(null, bVar);
                return cVar5;
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.b.i.a.a(null, bVar);
            throw th;
        }
    }

    public static <T> com.meizu.cloud.pushsdk.b.a.c<T> c(com.meizu.cloud.pushsdk.b.a.b bVar) {
        try {
            k b = a.b(bVar);
            if (b == null) {
                return new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
            }
            if (b.a() >= 400) {
                com.meizu.cloud.pushsdk.b.a.c<T> cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(b), bVar, b.a()));
                cVar.a(b);
                return cVar;
            }
            com.meizu.cloud.pushsdk.b.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.b.a.c<>("success");
            cVar2.a(b);
            return cVar2;
        } catch (com.meizu.cloud.pushsdk.b.b.a e) {
            return new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(e)));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e2));
        }
    }

    public static <T> com.meizu.cloud.pushsdk.b.a.c<T> d(com.meizu.cloud.pushsdk.b.a.b bVar) {
        try {
            try {
                k c = a.c(bVar);
                if (c == null) {
                    com.meizu.cloud.pushsdk.b.a.c<T> cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
                    com.meizu.cloud.pushsdk.b.i.a.a(c, bVar);
                    return cVar;
                } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                    com.meizu.cloud.pushsdk.b.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.b.a.c<>(c);
                    cVar2.a(c);
                    com.meizu.cloud.pushsdk.b.i.a.a(c, bVar);
                    return cVar2;
                } else if (c.a() >= 400) {
                    com.meizu.cloud.pushsdk.b.a.c<T> cVar3 = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(c), bVar, c.a()));
                    cVar3.a(c);
                    com.meizu.cloud.pushsdk.b.i.a.a(c, bVar);
                    return cVar3;
                } else {
                    com.meizu.cloud.pushsdk.b.a.c<T> a = bVar.a(c);
                    a.a(c);
                    com.meizu.cloud.pushsdk.b.i.a.a(c, bVar);
                    return a;
                }
            } catch (com.meizu.cloud.pushsdk.b.b.a e) {
                com.meizu.cloud.pushsdk.b.a.c<T> cVar4 = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e));
                com.meizu.cloud.pushsdk.b.i.a.a(null, bVar);
                return cVar4;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.b.a.c<T> cVar5 = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e2));
                com.meizu.cloud.pushsdk.b.i.a.a(null, bVar);
                return cVar5;
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.b.i.a.a(null, bVar);
            throw th;
        }
    }
}
