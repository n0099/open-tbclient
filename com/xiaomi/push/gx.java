package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.bi;
import com.xiaomi.push.jh;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public class gx {

    /* renamed from: a  reason: collision with root package name */
    public int f40906a;

    /* renamed from: a  reason: collision with other field name */
    public long f458a;

    /* renamed from: a  reason: collision with other field name */
    public gw f460a;

    /* renamed from: a  reason: collision with other field name */
    public String f461a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f462a = false;

    /* renamed from: a  reason: collision with other field name */
    public bi f459a = bi.a();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final gx f40907a = new gx();
    }

    private ex a(bi.a aVar) {
        if (aVar.f150a == 0) {
            Object obj = aVar.f151a;
            if (obj instanceof ex) {
                return (ex) obj;
            }
            return null;
        }
        ex m350a = m350a();
        m350a.a(ew.CHANNEL_STATS_COUNTER.a());
        m350a.c(aVar.f150a);
        m350a.c(aVar.f152a);
        return m350a;
    }

    private ey a(int i) {
        ArrayList arrayList = new ArrayList();
        ey eyVar = new ey(this.f461a, arrayList);
        if (!bg.e(this.f460a.f455a)) {
            eyVar.a(i.m(this.f460a.f455a));
        }
        jj jjVar = new jj(i);
        jb a2 = new jh.a().a(jjVar);
        try {
            eyVar.b(a2);
        } catch (iv unused) {
        }
        LinkedList<bi.a> m164a = this.f459a.m164a();
        while (m164a.size() > 0) {
            try {
                ex a3 = a(m164a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jjVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m164a.removeLast();
            } catch (iv | NoSuchElementException unused2) {
            }
        }
        return eyVar;
    }

    public static gw a() {
        gw gwVar;
        synchronized (a.f40907a) {
            gwVar = a.f40907a.f460a;
        }
        return gwVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gx m348a() {
        return a.f40907a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m349a() {
        if (!this.f462a || System.currentTimeMillis() - this.f458a <= this.f40906a) {
            return;
        }
        this.f462a = false;
        this.f458a = 0L;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ex m350a() {
        ex exVar;
        exVar = new ex();
        exVar.a(bg.m157a((Context) this.f460a.f455a));
        exVar.f341a = (byte) 0;
        exVar.f345b = 1;
        exVar.d((int) (System.currentTimeMillis() / 1000));
        return exVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ey m351a() {
        ey eyVar;
        eyVar = null;
        if (b()) {
            eyVar = a(bg.e(this.f460a.f455a) ? 750 : 375);
        }
        return eyVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m352a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.f40906a == i2 && this.f462a) {
                return;
            }
            this.f462a = true;
            this.f458a = System.currentTimeMillis();
            this.f40906a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f458a);
        }
    }

    public synchronized void a(ex exVar) {
        this.f459a.a(exVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f460a = new gw(xMPushService);
        this.f461a = "";
        com.xiaomi.push.service.bi.a().a(new gy(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m353a() {
        return this.f462a;
    }

    public boolean b() {
        m349a();
        return this.f462a && this.f459a.m163a() > 0;
    }
}
