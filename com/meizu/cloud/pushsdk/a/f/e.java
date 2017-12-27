package com.meizu.cloud.pushsdk.a.f;

import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.meizu.cloud.pushsdk.a.d.k;
/* loaded from: classes2.dex */
public final class e {
    public static <T> com.meizu.cloud.pushsdk.a.a.c<T> a(com.meizu.cloud.pushsdk.a.a.b bVar) {
        switch (bVar.h()) {
            case 0:
                return b(bVar);
            case 1:
                return c(bVar);
            case 2:
                return d(bVar);
            default:
                return new com.meizu.cloud.pushsdk.a.a.c<>(new com.meizu.cloud.pushsdk.a.c.a());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [87=6] */
    private static <T> com.meizu.cloud.pushsdk.a.a.c<T> b(com.meizu.cloud.pushsdk.a.a.b bVar) {
        k kVar;
        Exception exc;
        com.meizu.cloud.pushsdk.a.c.a aVar;
        com.meizu.cloud.pushsdk.a.a.c<T> cVar;
        k a;
        k kVar2 = null;
        try {
            try {
                try {
                    a = b.a(bVar);
                } catch (Throwable th) {
                    th = th;
                    kVar2 = kVar;
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar2, bVar);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                com.meizu.cloud.pushsdk.a.i.a.a(kVar2, bVar);
                throw th;
            }
        } catch (com.meizu.cloud.pushsdk.a.c.a e) {
            kVar = null;
            aVar = e;
        } catch (Exception e2) {
            kVar = null;
            exc = e2;
        }
        try {
            if (a == null) {
                cVar = new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
                com.meizu.cloud.pushsdk.a.i.a.a(a, bVar);
            } else if (bVar.g() == com.meizu.cloud.pushsdk.a.a.e.OK_HTTP_RESPONSE) {
                cVar = new com.meizu.cloud.pushsdk.a.a.c<>(a);
                cVar.a(a);
                com.meizu.cloud.pushsdk.a.i.a.a(a, bVar);
            } else if (a.a() >= 400) {
                cVar = new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(a), bVar, a.a()));
                cVar.a(a);
                com.meizu.cloud.pushsdk.a.i.a.a(a, bVar);
            } else {
                cVar = bVar.a(a);
                cVar.a(a);
                com.meizu.cloud.pushsdk.a.i.a.a(a, bVar);
            }
        } catch (com.meizu.cloud.pushsdk.a.c.a e3) {
            kVar = a;
            aVar = e3;
            cVar = new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(aVar)));
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
            return cVar;
        } catch (Exception e4) {
            kVar = a;
            exc = e4;
            cVar = new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(exc));
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
            return cVar;
        }
        return cVar;
    }

    private static <T> com.meizu.cloud.pushsdk.a.a.c<T> c(com.meizu.cloud.pushsdk.a.a.b bVar) {
        com.meizu.cloud.pushsdk.a.a.c<T> cVar;
        try {
            k b = b.b(bVar);
            if (b == null) {
                cVar = new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
            } else if (b.a() >= 400) {
                cVar = new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(b), bVar, b.a()));
                cVar.a(b);
            } else {
                cVar = new com.meizu.cloud.pushsdk.a.a.c<>(ImagesInvalidReceiver.SUCCESS);
                cVar.a(b);
            }
            return cVar;
        } catch (com.meizu.cloud.pushsdk.a.c.a e) {
            return new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(e)));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(e2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [142=6] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0018 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: com.meizu.cloud.pushsdk.a.c.a */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.meizu.cloud.pushsdk.a.c.a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0018 -> B:7:0x0018). Please submit an issue!!! */
    private static <T> com.meizu.cloud.pushsdk.a.a.c<T> d(com.meizu.cloud.pushsdk.a.a.b bVar) {
        k kVar;
        Exception exc;
        com.meizu.cloud.pushsdk.a.c.a aVar;
        com.meizu.cloud.pushsdk.a.a.c<T> cVar;
        k kVar2;
        k kVar3 = null;
        try {
            try {
                try {
                    kVar2 = b.c(bVar);
                    try {
                        if (kVar2 == null) {
                            cVar = new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
                            com.meizu.cloud.pushsdk.a.i.a.a(kVar2, bVar);
                        } else if (bVar.g() == com.meizu.cloud.pushsdk.a.a.e.OK_HTTP_RESPONSE) {
                            cVar = new com.meizu.cloud.pushsdk.a.a.c<>(kVar2);
                            cVar.a(kVar2);
                            com.meizu.cloud.pushsdk.a.i.a.a(kVar2, bVar);
                        } else if (kVar2.a() >= 400) {
                            cVar = new com.meizu.cloud.pushsdk.a.a.c<>(com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(kVar2), bVar, kVar2.a()));
                            cVar.a(kVar2);
                            com.meizu.cloud.pushsdk.a.i.a.a(kVar2, bVar);
                        } else {
                            cVar = bVar.a(kVar2);
                            cVar.a(kVar2);
                            com.meizu.cloud.pushsdk.a.i.a.a(kVar2, bVar);
                        }
                    } catch (com.meizu.cloud.pushsdk.a.c.a e) {
                        kVar = kVar2;
                        aVar = e;
                        com.meizu.cloud.pushsdk.a.c.a a = com.meizu.cloud.pushsdk.a.i.b.a(aVar);
                        cVar = new com.meizu.cloud.pushsdk.a.a.c<>(a);
                        com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                        kVar2 = a;
                        return cVar;
                    } catch (Exception e2) {
                        kVar = kVar2;
                        exc = e2;
                        com.meizu.cloud.pushsdk.a.c.a a2 = com.meizu.cloud.pushsdk.a.i.b.a(exc);
                        cVar = new com.meizu.cloud.pushsdk.a.a.c<>(a2);
                        com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                        kVar2 = a2;
                        return cVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar3, bVar);
                    throw th;
                }
            } catch (com.meizu.cloud.pushsdk.a.c.a e3) {
                kVar = null;
                aVar = e3;
                com.meizu.cloud.pushsdk.a.c.a a3 = com.meizu.cloud.pushsdk.a.i.b.a(aVar);
                cVar = new com.meizu.cloud.pushsdk.a.a.c<>(a3);
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                kVar2 = a3;
                return cVar;
            } catch (Exception e4) {
                kVar = null;
                exc = e4;
                com.meizu.cloud.pushsdk.a.c.a a22 = com.meizu.cloud.pushsdk.a.i.b.a(exc);
                cVar = new com.meizu.cloud.pushsdk.a.a.c<>(a22);
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
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
