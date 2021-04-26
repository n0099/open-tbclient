package com.bytedance.sdk.openadsdk.k;

import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.k.i;
import com.bytedance.sdk.openadsdk.k.l;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public abstract class a implements k {
    public static final AtomicLong m = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.a f30145a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.k.b.c f30146b;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.k.d.a f30149e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<i.b> f30150f;

    /* renamed from: g  reason: collision with root package name */
    public volatile String f30151g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f30152h;

    /* renamed from: i  reason: collision with root package name */
    public volatile i f30153i;
    public volatile l j;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f30147c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f30148d = new AtomicLong();
    public volatile boolean k = false;
    public final long l = m.incrementAndGet();
    public final AtomicInteger n = new AtomicInteger(0);
    public int o = -1;

    public a(com.bytedance.sdk.openadsdk.k.a.a aVar, com.bytedance.sdk.openadsdk.k.b.c cVar) {
        this.f30145a = aVar;
        this.f30146b = cVar;
    }

    public void a(Boolean bool, String str, @NonNull Throwable th) {
    }

    public boolean b() {
        return this.n.get() == 1;
    }

    public void c() {
        this.n.compareAndSet(0, 2);
    }

    public boolean d() {
        return this.n.get() == 2;
    }

    public void e() throws com.bytedance.sdk.openadsdk.k.c.a {
        if (b()) {
            throw new com.bytedance.sdk.openadsdk.k.c.a();
        }
    }

    public int f() {
        if (this.f30153i != null) {
            return this.f30153i.f30304c.f30305a;
        }
        return this.f30145a instanceof com.bytedance.sdk.openadsdk.k.a.b ? 1 : 0;
    }

    public boolean g() {
        return f() == 1;
    }

    public void a() {
        this.n.compareAndSet(0, 1);
    }

    public com.bytedance.sdk.openadsdk.k.e.a a(l.a aVar, int i2, int i3, String str) throws IOException, VAdError {
        com.bytedance.sdk.openadsdk.k.e.b b2 = com.bytedance.sdk.openadsdk.k.e.c.a().b();
        com.bytedance.sdk.openadsdk.k.e.f fVar = new com.bytedance.sdk.openadsdk.k.e.f();
        HashMap hashMap = new HashMap();
        fVar.f30239b = aVar.f30328a;
        fVar.f30238a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            fVar.f30238a = 4;
        }
        List<i.b> list = this.f30150f;
        if (list != null && !list.isEmpty()) {
            for (i.b bVar : list) {
                if (!"Range".equalsIgnoreCase(bVar.f30312a) && !HTTP.CONN_DIRECTIVE.equalsIgnoreCase(bVar.f30312a) && !"Proxy-Connection".equalsIgnoreCase(bVar.f30312a) && !"Host".equalsIgnoreCase(bVar.f30312a)) {
                    hashMap.put(bVar.f30312a, bVar.f30313b);
                }
            }
        }
        String a2 = com.bytedance.sdk.openadsdk.k.g.d.a(i2, i3);
        if (a2 != null) {
            hashMap.put("Range", a2);
        }
        if (e.f30230f) {
            hashMap.put("Cache-Control", "no-cache");
        }
        d c2 = d.c();
        f a3 = f.a();
        boolean z = this.f30153i == null;
        c a4 = z ? c2.a() : a3.b();
        c b3 = z ? c2.b() : a3.c();
        if (a4 != null || b3 != null) {
            if (a4 != null) {
                fVar.f30240c = a4.a(aVar.f30329b);
            }
            if (b3 != null) {
                fVar.f30241d = b3.a(aVar.f30329b);
            }
        }
        fVar.f30242e = hashMap;
        if (this.k) {
            this.k = false;
            return null;
        }
        return b2.a(fVar);
    }

    public void a(int i2, int i3) {
        if (i2 <= 0 || i3 < 0) {
            return;
        }
        int i4 = e.f30231g;
        int f2 = f();
        if (i4 == 1 || (i4 == 2 && f2 == 1)) {
            int i5 = (int) ((i3 / i2) * 100.0f);
            if (i5 > 100) {
                i5 = 100;
            }
            synchronized (this) {
                if (i5 <= this.o) {
                    return;
                }
                this.o = i5;
                com.bytedance.sdk.openadsdk.k.g.d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar = a.this;
                        com.bytedance.sdk.openadsdk.k.d.a aVar2 = aVar.f30149e;
                        if (aVar2 != null) {
                            aVar2.a(aVar.j, a.this.o);
                        }
                    }
                });
            }
        }
    }
}
