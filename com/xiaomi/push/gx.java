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
    public int f40617a;

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
        public static final gx f40618a = new gx();
    }

    private ex a(bi.a aVar) {
        if (aVar.f150a == 0) {
            Object obj = aVar.f151a;
            if (obj instanceof ex) {
                return (ex) obj;
            }
            return null;
        }
        ex m346a = m346a();
        m346a.a(ew.CHANNEL_STATS_COUNTER.a());
        m346a.c(aVar.f150a);
        m346a.c(aVar.f152a);
        return m346a;
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
        LinkedList<bi.a> m160a = this.f459a.m160a();
        while (m160a.size() > 0) {
            try {
                ex a3 = a(m160a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jjVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m160a.removeLast();
            } catch (iv | NoSuchElementException unused2) {
            }
        }
        return eyVar;
    }

    public static gw a() {
        gw gwVar;
        synchronized (a.f40618a) {
            gwVar = a.f40618a.f460a;
        }
        return gwVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gx m344a() {
        return a.f40618a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m345a() {
        if (!this.f462a || System.currentTimeMillis() - this.f458a <= this.f40617a) {
            return;
        }
        this.f462a = false;
        this.f458a = 0L;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ex m346a() {
        ex exVar;
        exVar = new ex();
        exVar.a(bg.m153a((Context) this.f460a.f455a));
        exVar.f341a = (byte) 0;
        exVar.f345b = 1;
        exVar.d((int) (System.currentTimeMillis() / 1000));
        return exVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ey m347a() {
        ey eyVar;
        eyVar = null;
        if (b()) {
            eyVar = a(bg.e(this.f460a.f455a) ? 750 : 375);
        }
        return eyVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m348a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.f40617a == i2 && this.f462a) {
                return;
            }
            this.f462a = true;
            this.f458a = System.currentTimeMillis();
            this.f40617a = i2;
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
    public boolean m349a() {
        return this.f462a;
    }

    public boolean b() {
        m345a();
        return this.f462a && this.f459a.m159a() > 0;
    }
}
