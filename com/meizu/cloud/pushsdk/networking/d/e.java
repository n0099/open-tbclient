package com.meizu.cloud.pushsdk.networking.d;

import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.meizu.cloud.pushsdk.networking.b.k;
import com.meizu.cloud.pushsdk.networking.common.ResponseType;
import com.meizu.cloud.pushsdk.networking.error.ANError;
/* loaded from: classes3.dex */
public final class e {
    public static <T> com.meizu.cloud.pushsdk.networking.common.c<T> a(com.meizu.cloud.pushsdk.networking.common.b bVar) {
        switch (bVar.h()) {
            case 0:
                return b(bVar);
            case 1:
                return c(bVar);
            case 2:
                return d(bVar);
            default:
                return new com.meizu.cloud.pushsdk.networking.common.c<>(new ANError());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [87=6] */
    private static <T> com.meizu.cloud.pushsdk.networking.common.c<T> b(com.meizu.cloud.pushsdk.networking.common.b bVar) {
        k kVar;
        Exception exc;
        ANError aNError;
        com.meizu.cloud.pushsdk.networking.common.c<T> cVar;
        k a;
        k kVar2 = null;
        try {
            try {
                try {
                    a = b.a(bVar);
                } catch (Throwable th) {
                    th = th;
                    kVar2 = kVar;
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar2, bVar);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                com.meizu.cloud.pushsdk.networking.e.a.a(kVar2, bVar);
                throw th;
            }
        } catch (ANError e) {
            kVar = null;
            aNError = e;
        } catch (Exception e2) {
            kVar = null;
            exc = e2;
        }
        try {
            if (a == null) {
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(new ANError()));
                com.meizu.cloud.pushsdk.networking.e.a.a(a, bVar);
            } else if (bVar.g() == ResponseType.OK_HTTP_RESPONSE) {
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(a);
                cVar.a(a);
                com.meizu.cloud.pushsdk.networking.e.a.a(a, bVar);
            } else if (a.a() >= 400) {
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(a), bVar, a.a()));
                cVar.a(a);
                com.meizu.cloud.pushsdk.networking.e.a.a(a, bVar);
            } else {
                cVar = bVar.a(a);
                cVar.a(a);
                com.meizu.cloud.pushsdk.networking.e.a.a(a, bVar);
            }
        } catch (ANError e3) {
            kVar = a;
            aNError = e3;
            cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(aNError)));
            com.meizu.cloud.pushsdk.networking.e.a.a(kVar, bVar);
            return cVar;
        } catch (Exception e4) {
            kVar = a;
            exc = e4;
            cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(exc));
            com.meizu.cloud.pushsdk.networking.e.a.a(kVar, bVar);
            return cVar;
        }
        return cVar;
    }

    private static <T> com.meizu.cloud.pushsdk.networking.common.c<T> c(com.meizu.cloud.pushsdk.networking.common.b bVar) {
        com.meizu.cloud.pushsdk.networking.common.c<T> cVar;
        try {
            k b = b.b(bVar);
            if (b == null) {
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(new ANError()));
            } else if (b.a() >= 400) {
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(b), bVar, b.a()));
                cVar.a(b);
            } else {
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(ImagesInvalidReceiver.SUCCESS);
                cVar.a(b);
            }
            return cVar;
        } catch (ANError e) {
            return new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(e)));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(e2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [142=6] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0018 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: com.meizu.cloud.pushsdk.networking.error.ANError */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.meizu.cloud.pushsdk.networking.error.ANError */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0075 -> B:38:0x0018). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0086 -> B:20:0x005c). Please submit an issue!!! */
    private static <T> com.meizu.cloud.pushsdk.networking.common.c<T> d(com.meizu.cloud.pushsdk.networking.common.b bVar) {
        k kVar;
        Exception exc;
        ANError aNError;
        com.meizu.cloud.pushsdk.networking.common.c<T> cVar;
        k kVar2;
        k kVar3 = null;
        try {
            try {
                try {
                    kVar2 = b.c(bVar);
                } catch (Throwable th) {
                    th = th;
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar3, bVar);
                    throw th;
                }
            } catch (ANError e) {
                kVar = null;
                aNError = e;
                ANError a = com.meizu.cloud.pushsdk.networking.e.b.a(aNError);
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(a);
                com.meizu.cloud.pushsdk.networking.e.a.a(kVar, bVar);
                kVar2 = a;
                return cVar;
            } catch (Exception e2) {
                kVar = null;
                exc = e2;
                ANError a2 = com.meizu.cloud.pushsdk.networking.e.b.a(exc);
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(a2);
                com.meizu.cloud.pushsdk.networking.e.a.a(kVar, bVar);
                kVar2 = a2;
                return cVar;
            }
            try {
                if (kVar2 == null) {
                    cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(new ANError()));
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar2, bVar);
                } else if (bVar.g() == ResponseType.OK_HTTP_RESPONSE) {
                    cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(kVar2);
                    cVar.a(kVar2);
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar2, bVar);
                } else if (kVar2.a() >= 400) {
                    cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(com.meizu.cloud.pushsdk.networking.e.b.a(new ANError(kVar2), bVar, kVar2.a()));
                    cVar.a(kVar2);
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar2, bVar);
                } else {
                    cVar = bVar.a(kVar2);
                    cVar.a(kVar2);
                    com.meizu.cloud.pushsdk.networking.e.a.a(kVar2, bVar);
                }
            } catch (ANError e3) {
                kVar = kVar2;
                aNError = e3;
                ANError a3 = com.meizu.cloud.pushsdk.networking.e.b.a(aNError);
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(a3);
                com.meizu.cloud.pushsdk.networking.e.a.a(kVar, bVar);
                kVar2 = a3;
                return cVar;
            } catch (Exception e4) {
                kVar = kVar2;
                exc = e4;
                ANError a22 = com.meizu.cloud.pushsdk.networking.e.b.a(exc);
                cVar = new com.meizu.cloud.pushsdk.networking.common.c<>(a22);
                com.meizu.cloud.pushsdk.networking.e.a.a(kVar, bVar);
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
