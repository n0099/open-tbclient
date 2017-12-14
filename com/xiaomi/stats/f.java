package com.xiaomi.stats;

import com.xiaomi.channel.commonutils.stats.a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.at;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.apache.thrift.protocol.k;
/* loaded from: classes2.dex */
public class f {
    private String a;
    private int c;
    private long d;
    private e e;
    private boolean b = false;
    private com.xiaomi.channel.commonutils.stats.a f = com.xiaomi.channel.commonutils.stats.a.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        static final f a = new f();
    }

    private com.xiaomi.push.thrift.b a(a.C0174a c0174a) {
        if (c0174a.a == 0) {
            if (c0174a.c instanceof com.xiaomi.push.thrift.b) {
                return (com.xiaomi.push.thrift.b) c0174a.c;
            }
            return null;
        }
        com.xiaomi.push.thrift.b f = f();
        f.a(com.xiaomi.push.thrift.a.CHANNEL_STATS_COUNTER.a());
        f.c(c0174a.a);
        f.c(c0174a.b);
        return f;
    }

    public static f a() {
        return a.a;
    }

    private com.xiaomi.push.thrift.c b(int i) {
        ArrayList arrayList = new ArrayList();
        com.xiaomi.push.thrift.c cVar = new com.xiaomi.push.thrift.c(this.a, arrayList);
        if (!com.xiaomi.channel.commonutils.network.d.f(this.e.a)) {
            cVar.a(com.xiaomi.channel.commonutils.android.e.f(this.e.a));
        }
        org.apache.thrift.transport.b bVar = new org.apache.thrift.transport.b(i);
        org.apache.thrift.protocol.e a2 = new k.a().a(bVar);
        try {
            cVar.b(a2);
        } catch (org.apache.thrift.f e) {
        }
        LinkedList<a.C0174a> c = this.f.c();
        while (c.size() > 0) {
            try {
                com.xiaomi.push.thrift.b a3 = a(c.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (bVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                c.removeLast();
            } catch (NoSuchElementException e2) {
            } catch (org.apache.thrift.f e3) {
            }
        }
        return cVar;
    }

    public static e b() {
        e eVar;
        synchronized (a.a) {
            eVar = a.a.e;
        }
        return eVar;
    }

    private void g() {
        if (!this.b || System.currentTimeMillis() - this.d <= this.c) {
            return;
        }
        this.b = false;
        this.d = 0L;
    }

    public void a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            int i3 = i2 <= 604800000 ? i2 : 604800000;
            if (this.c == i3 && this.b) {
                return;
            }
            this.b = true;
            this.d = System.currentTimeMillis();
            this.c = i3;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i3 + " start = " + this.d);
        }
    }

    public synchronized void a(XMPushService xMPushService) {
        this.e = new e(xMPushService);
        this.a = "";
        at.a().a(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.xiaomi.push.thrift.b bVar) {
        this.f.a(bVar);
    }

    public boolean c() {
        return this.b;
    }

    boolean d() {
        g();
        return this.b && this.f.b() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.xiaomi.push.thrift.c e() {
        com.xiaomi.push.thrift.c cVar;
        cVar = null;
        if (d()) {
            cVar = b(com.xiaomi.channel.commonutils.network.d.f(this.e.a) ? 750 : 375);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.xiaomi.push.thrift.b f() {
        com.xiaomi.push.thrift.b bVar;
        bVar = new com.xiaomi.push.thrift.b();
        bVar.a(com.xiaomi.channel.commonutils.network.d.k(this.e.a));
        bVar.a = (byte) 0;
        bVar.c = 1;
        bVar.d((int) (System.currentTimeMillis() / 1000));
        if (this.e.b != null) {
            bVar.e(this.e.b.f());
        }
        return bVar;
    }
}
