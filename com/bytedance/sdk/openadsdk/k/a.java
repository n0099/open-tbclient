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
/* loaded from: classes6.dex */
public abstract class a implements k {
    public static final AtomicLong m = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.k.a.a f29554a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.k.b.c f29555b;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.k.d.a f29558e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<i.b> f29559f;

    /* renamed from: g  reason: collision with root package name */
    public volatile String f29560g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f29561h;
    public volatile i i;
    public volatile l j;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f29556c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f29557d = new AtomicLong();
    public volatile boolean k = false;
    public final long l = m.incrementAndGet();
    public final AtomicInteger n = new AtomicInteger(0);
    public int o = -1;

    public a(com.bytedance.sdk.openadsdk.k.a.a aVar, com.bytedance.sdk.openadsdk.k.b.c cVar) {
        this.f29554a = aVar;
        this.f29555b = cVar;
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
        if (this.i != null) {
            return this.i.f29707c.f29708a;
        }
        return this.f29554a instanceof com.bytedance.sdk.openadsdk.k.a.b ? 1 : 0;
    }

    public boolean g() {
        return f() == 1;
    }

    public void a() {
        this.n.compareAndSet(0, 1);
    }

    public com.bytedance.sdk.openadsdk.k.e.a a(l.a aVar, int i, int i2, String str) throws IOException, VAdError {
        com.bytedance.sdk.openadsdk.k.e.b b2 = com.bytedance.sdk.openadsdk.k.e.c.a().b();
        com.bytedance.sdk.openadsdk.k.e.f fVar = new com.bytedance.sdk.openadsdk.k.e.f();
        HashMap hashMap = new HashMap();
        fVar.f29643b = aVar.f29731a;
        fVar.f29642a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            fVar.f29642a = 4;
        }
        List<i.b> list = this.f29559f;
        if (list != null && !list.isEmpty()) {
            for (i.b bVar : list) {
                if (!"Range".equalsIgnoreCase(bVar.f29715a) && !HTTP.CONN_DIRECTIVE.equalsIgnoreCase(bVar.f29715a) && !"Proxy-Connection".equalsIgnoreCase(bVar.f29715a) && !"Host".equalsIgnoreCase(bVar.f29715a)) {
                    hashMap.put(bVar.f29715a, bVar.f29716b);
                }
            }
        }
        String a2 = com.bytedance.sdk.openadsdk.k.g.d.a(i, i2);
        if (a2 != null) {
            hashMap.put("Range", a2);
        }
        if (e.f29635f) {
            hashMap.put("Cache-Control", "no-cache");
        }
        d c2 = d.c();
        f a3 = f.a();
        boolean z = this.i == null;
        c a4 = z ? c2.a() : a3.b();
        c b3 = z ? c2.b() : a3.c();
        if (a4 != null || b3 != null) {
            if (a4 != null) {
                fVar.f29644c = a4.a(aVar.f29732b);
            }
            if (b3 != null) {
                fVar.f29645d = b3.a(aVar.f29732b);
            }
        }
        fVar.f29646e = hashMap;
        if (this.k) {
            this.k = false;
            return null;
        }
        return b2.a(fVar);
    }

    public void a(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = e.f29636g;
        int f2 = f();
        if (i3 == 1 || (i3 == 2 && f2 == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.o) {
                    return;
                }
                this.o = i4;
                com.bytedance.sdk.openadsdk.k.g.d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar = a.this;
                        com.bytedance.sdk.openadsdk.k.d.a aVar2 = aVar.f29558e;
                        if (aVar2 != null) {
                            aVar2.a(aVar.j, a.this.o);
                        }
                    }
                });
            }
        }
    }
}
