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
    public volatile com.bytedance.sdk.openadsdk.k.a.a f29319a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.k.b.c f29320b;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.k.d.a f29323e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<i.b> f29324f;

    /* renamed from: g  reason: collision with root package name */
    public volatile String f29325g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f29326h;

    /* renamed from: i  reason: collision with root package name */
    public volatile i f29327i;
    public volatile l j;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f29321c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f29322d = new AtomicLong();
    public volatile boolean k = false;
    public final long l = m.incrementAndGet();
    public final AtomicInteger n = new AtomicInteger(0);
    public int o = -1;

    public a(com.bytedance.sdk.openadsdk.k.a.a aVar, com.bytedance.sdk.openadsdk.k.b.c cVar) {
        this.f29319a = aVar;
        this.f29320b = cVar;
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
        if (this.f29327i != null) {
            return this.f29327i.f29478c.f29479a;
        }
        return this.f29319a instanceof com.bytedance.sdk.openadsdk.k.a.b ? 1 : 0;
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
        fVar.f29413b = aVar.f29502a;
        fVar.f29412a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            fVar.f29412a = 4;
        }
        List<i.b> list = this.f29324f;
        if (list != null && !list.isEmpty()) {
            for (i.b bVar : list) {
                if (!"Range".equalsIgnoreCase(bVar.f29486a) && !HTTP.CONN_DIRECTIVE.equalsIgnoreCase(bVar.f29486a) && !"Proxy-Connection".equalsIgnoreCase(bVar.f29486a) && !"Host".equalsIgnoreCase(bVar.f29486a)) {
                    hashMap.put(bVar.f29486a, bVar.f29487b);
                }
            }
        }
        String a2 = com.bytedance.sdk.openadsdk.k.g.d.a(i2, i3);
        if (a2 != null) {
            hashMap.put("Range", a2);
        }
        if (e.f29404f) {
            hashMap.put("Cache-Control", "no-cache");
        }
        d c2 = d.c();
        f a3 = f.a();
        boolean z = this.f29327i == null;
        c a4 = z ? c2.a() : a3.b();
        c b3 = z ? c2.b() : a3.c();
        if (a4 != null || b3 != null) {
            if (a4 != null) {
                fVar.f29414c = a4.a(aVar.f29503b);
            }
            if (b3 != null) {
                fVar.f29415d = b3.a(aVar.f29503b);
            }
        }
        fVar.f29416e = hashMap;
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
        int i4 = e.f29405g;
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
                        com.bytedance.sdk.openadsdk.k.d.a aVar2 = aVar.f29323e;
                        if (aVar2 != null) {
                            aVar2.a(aVar.j, a.this.o);
                        }
                    }
                });
            }
        }
    }
}
