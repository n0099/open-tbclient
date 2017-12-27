package com.meizu.cloud.pushsdk.a.f;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {
    private static final String a = a.class.getSimpleName();
    private static a d = null;
    private final Set<com.meizu.cloud.pushsdk.a.a.b> b = new HashSet();
    private AtomicInteger c = new AtomicInteger();

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public int b() {
        return this.c.incrementAndGet();
    }

    public com.meizu.cloud.pushsdk.a.a.b a(com.meizu.cloud.pushsdk.a.a.b bVar) {
        synchronized (this.b) {
            try {
                this.b.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            bVar.a(b());
            if (bVar.d() == com.meizu.cloud.pushsdk.a.a.d.IMMEDIATE) {
                bVar.a(com.meizu.cloud.pushsdk.a.b.b.a().b().b().submit(new c(bVar)));
            } else {
                bVar.a(com.meizu.cloud.pushsdk.a.b.b.a().b().a().submit(new c(bVar)));
            }
            com.meizu.cloud.pushsdk.a.a.a.a("addRequest: after addition - mCurrentRequests size: " + this.b.size());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public void b(com.meizu.cloud.pushsdk.a.a.b bVar) {
        synchronized (this.b) {
            try {
                this.b.remove(bVar);
                com.meizu.cloud.pushsdk.a.a.a.a("finish: after removal - mCurrentRequests size: " + this.b.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
