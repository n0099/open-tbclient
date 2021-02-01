package com.bytedance.sdk.openadsdk.j;

import androidx.annotation.NonNull;
import com.baidubce.http.Headers;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.j.i;
import com.bytedance.sdk.openadsdk.j.l;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class a implements k {
    private static final AtomicLong m = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    protected volatile com.bytedance.sdk.openadsdk.j.a.a f7219a;

    /* renamed from: b  reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.j.b.c f7220b;
    protected com.bytedance.sdk.openadsdk.j.d.a e;
    protected volatile List<i.b> f;
    protected volatile String g;
    protected volatile String h;
    protected volatile i i;
    protected volatile l j;
    protected final AtomicInteger c = new AtomicInteger();
    protected final AtomicLong d = new AtomicLong();
    protected volatile boolean k = false;
    public final long l = m.incrementAndGet();
    private final AtomicInteger n = new AtomicInteger(0);
    private int o = -1;

    public a(com.bytedance.sdk.openadsdk.j.a.a aVar, com.bytedance.sdk.openadsdk.j.b.c cVar) {
        this.f7219a = aVar;
        this.f7220b = cVar;
    }

    public void a() {
        this.n.compareAndSet(0, 1);
    }

    public boolean b() {
        return this.n.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.n.compareAndSet(0, 2);
    }

    public boolean d() {
        return this.n.get() == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() throws com.bytedance.sdk.openadsdk.j.c.a {
        if (b()) {
            throw new com.bytedance.sdk.openadsdk.j.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bytedance.sdk.openadsdk.j.e.a a(l.a aVar, int i, int i2, String str) throws IOException, VAdError {
        com.bytedance.sdk.openadsdk.j.e.b b2 = com.bytedance.sdk.openadsdk.j.e.c.a().b();
        com.bytedance.sdk.openadsdk.j.e.f fVar = new com.bytedance.sdk.openadsdk.j.e.f();
        HashMap hashMap = new HashMap();
        fVar.f7265b = aVar.f7311a;
        fVar.f7264a = 0;
        if (HttpHead.METHOD_NAME.equalsIgnoreCase(str)) {
            fVar.f7264a = 4;
        }
        List<i.b> list = this.f;
        if (list != null && !list.isEmpty()) {
            for (i.b bVar : list) {
                if (!Headers.RANGE.equalsIgnoreCase(bVar.f7303a) && !HTTP.CONN_DIRECTIVE.equalsIgnoreCase(bVar.f7303a) && !"Proxy-Connection".equalsIgnoreCase(bVar.f7303a) && !"Host".equalsIgnoreCase(bVar.f7303a)) {
                    hashMap.put(bVar.f7303a, bVar.f7304b);
                }
            }
        }
        String a2 = com.bytedance.sdk.openadsdk.j.g.d.a(i, i2);
        if (a2 != null) {
            hashMap.put(Headers.RANGE, a2);
        }
        if (e.f) {
            hashMap.put(Headers.CACHE_CONTROL, "no-cache");
        }
        d c = d.c();
        f a3 = f.a();
        boolean z = this.i == null;
        c a4 = z ? c.a() : a3.b();
        c b3 = z ? c.b() : a3.c();
        if (a4 != null || b3 != null) {
            if (a4 != null) {
                fVar.c = a4.a(aVar.f7312b);
            }
            if (b3 != null) {
                fVar.d = b3.a(aVar.f7312b);
            }
        }
        fVar.e = hashMap;
        if (this.k) {
            this.k = false;
            return null;
        }
        return b2.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        if (this.i != null) {
            return this.i.c.f7301a;
        }
        return this.f7219a instanceof com.bytedance.sdk.openadsdk.j.a.b ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        return f() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2) {
        if (i > 0 && i2 >= 0) {
            int i3 = e.g;
            int f = f();
            if (i3 == 1 || (i3 == 2 && f == 1)) {
                int i4 = (int) ((i2 / i) * 100.0f);
                int i5 = i4 <= 100 ? i4 : 100;
                synchronized (this) {
                    if (i5 > this.o) {
                        this.o = i5;
                        com.bytedance.sdk.openadsdk.j.g.d.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.e != null) {
                                    a.this.e.a(a.this.j, a.this.o);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Boolean bool, String str, @NonNull Throwable th) {
    }
}
