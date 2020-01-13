package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.a.e;
import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
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
        k kVar;
        Exception exc;
        com.meizu.cloud.pushsdk.b.b.a aVar;
        com.meizu.cloud.pushsdk.b.a.c<T> cVar;
        k kVar2 = null;
        try {
            try {
                try {
                    k a = a.a(bVar);
                    try {
                        if (a == null) {
                            cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
                            com.meizu.cloud.pushsdk.b.i.a.a(a, bVar);
                        } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                            cVar = new com.meizu.cloud.pushsdk.b.a.c<>(a);
                            cVar.a(a);
                            com.meizu.cloud.pushsdk.b.i.a.a(a, bVar);
                        } else if (a.a() >= 400) {
                            cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(a), bVar, a.a()));
                            cVar.a(a);
                            com.meizu.cloud.pushsdk.b.i.a.a(a, bVar);
                        } else {
                            cVar = bVar.a(a);
                            cVar.a(a);
                            com.meizu.cloud.pushsdk.b.i.a.a(a, bVar);
                        }
                    } catch (com.meizu.cloud.pushsdk.b.b.a e) {
                        kVar = a;
                        aVar = e;
                        cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(aVar)));
                        com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
                        return cVar;
                    } catch (Exception e2) {
                        kVar = a;
                        exc = e2;
                        cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(exc));
                        com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
                        return cVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    kVar2 = kVar;
                    com.meizu.cloud.pushsdk.b.i.a.a(kVar2, bVar);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                com.meizu.cloud.pushsdk.b.i.a.a(kVar2, bVar);
                throw th;
            }
        } catch (com.meizu.cloud.pushsdk.b.b.a e3) {
            kVar = null;
            aVar = e3;
        } catch (Exception e4) {
            kVar = null;
            exc = e4;
        }
        return cVar;
    }

    private static <T> com.meizu.cloud.pushsdk.b.a.c<T> c(com.meizu.cloud.pushsdk.b.a.b bVar) {
        com.meizu.cloud.pushsdk.b.a.c<T> cVar;
        try {
            k b = a.b(bVar);
            if (b == null) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
            } else if (b.a() >= 400) {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(b), bVar, b.a()));
                cVar.a(b);
            } else {
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>("success");
                cVar.a(b);
            }
            return cVar;
        } catch (com.meizu.cloud.pushsdk.b.b.a e) {
            return new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(e)));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(e2));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0018 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: com.meizu.cloud.pushsdk.b.b.a */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.meizu.cloud.pushsdk.b.b.a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0075 -> B:38:0x0018). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0086 -> B:20:0x005c). Please submit an issue!!! */
    private static <T> com.meizu.cloud.pushsdk.b.a.c<T> d(com.meizu.cloud.pushsdk.b.a.b bVar) {
        k kVar;
        Exception exc;
        com.meizu.cloud.pushsdk.b.b.a aVar;
        com.meizu.cloud.pushsdk.b.a.c<T> cVar;
        k kVar2;
        k kVar3 = null;
        try {
            try {
                try {
                    kVar2 = a.c(bVar);
                } catch (Throwable th) {
                    th = th;
                    com.meizu.cloud.pushsdk.b.i.a.a(kVar3, bVar);
                    throw th;
                }
            } catch (com.meizu.cloud.pushsdk.b.b.a e) {
                kVar = null;
                aVar = e;
                com.meizu.cloud.pushsdk.b.b.a a = com.meizu.cloud.pushsdk.b.i.b.a(aVar);
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(a);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
                kVar2 = a;
                return cVar;
            } catch (Exception e2) {
                kVar = null;
                exc = e2;
                com.meizu.cloud.pushsdk.b.b.a a2 = com.meizu.cloud.pushsdk.b.i.b.a(exc);
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(a2);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
                kVar2 = a2;
                return cVar;
            }
            try {
                if (kVar2 == null) {
                    cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a()));
                    com.meizu.cloud.pushsdk.b.i.a.a(kVar2, bVar);
                } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                    cVar = new com.meizu.cloud.pushsdk.b.a.c<>(kVar2);
                    cVar.a(kVar2);
                    com.meizu.cloud.pushsdk.b.i.a.a(kVar2, bVar);
                } else if (kVar2.a() >= 400) {
                    cVar = new com.meizu.cloud.pushsdk.b.a.c<>(com.meizu.cloud.pushsdk.b.i.b.a(new com.meizu.cloud.pushsdk.b.b.a(kVar2), bVar, kVar2.a()));
                    cVar.a(kVar2);
                    com.meizu.cloud.pushsdk.b.i.a.a(kVar2, bVar);
                } else {
                    cVar = bVar.a(kVar2);
                    cVar.a(kVar2);
                    com.meizu.cloud.pushsdk.b.i.a.a(kVar2, bVar);
                }
            } catch (com.meizu.cloud.pushsdk.b.b.a e3) {
                kVar = kVar2;
                aVar = e3;
                com.meizu.cloud.pushsdk.b.b.a a3 = com.meizu.cloud.pushsdk.b.i.b.a(aVar);
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(a3);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
                kVar2 = a3;
                return cVar;
            } catch (Exception e4) {
                kVar = kVar2;
                exc = e4;
                com.meizu.cloud.pushsdk.b.b.a a22 = com.meizu.cloud.pushsdk.b.i.b.a(exc);
                cVar = new com.meizu.cloud.pushsdk.b.a.c<>(a22);
                com.meizu.cloud.pushsdk.b.i.a.a(kVar, bVar);
                kVar2 = a22;
                return cVar;
            }
            return cVar;
        } catch (Throwable th2) {
            th = th2;
            kVar3 = kVar;
        }
    }
}
