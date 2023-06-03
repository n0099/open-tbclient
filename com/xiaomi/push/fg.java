package com.xiaomi.push;

import android.content.Context;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.xiaomi.push.bk;
import com.xiaomi.push.jj;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/* loaded from: classes10.dex */
public class fg {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f366a;

    /* renamed from: a  reason: collision with other field name */
    public ff f368a;

    /* renamed from: a  reason: collision with other field name */
    public String f369a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f370a = false;

    /* renamed from: a  reason: collision with other field name */
    public bk f367a = bk.a();

    /* loaded from: classes10.dex */
    public static class a {
        public static final fg a = new fg();
    }

    private ez a(bk.a aVar) {
        if (aVar.f145a == 0) {
            Object obj = aVar.f146a;
            if (obj instanceof ez) {
                return (ez) obj;
            }
            return null;
        }
        ez m472a = m472a();
        m472a.a(ey.CHANNEL_STATS_COUNTER.a());
        m472a.c(aVar.f145a);
        m472a.c(aVar.f147a);
        return m472a;
    }

    private fa a(int i) {
        ArrayList arrayList = new ArrayList();
        fa faVar = new fa(this.f369a, arrayList);
        if (!bi.e(this.f368a.f363a)) {
            faVar.a(i.i(this.f368a.f363a));
        }
        jl jlVar = new jl(i);
        jd a2 = new jj.a().a(jlVar);
        try {
            faVar.b(a2);
        } catch (ix unused) {
        }
        LinkedList<bk.a> m290a = this.f367a.m290a();
        while (m290a.size() > 0) {
            try {
                ez a3 = a(m290a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jlVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m290a.removeLast();
            } catch (ix | NoSuchElementException unused2) {
            }
        }
        return faVar;
    }

    public static ff a() {
        ff ffVar;
        synchronized (a.a) {
            ffVar = a.a.f368a;
        }
        return ffVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static fg m470a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m471a() {
        if (!this.f370a || System.currentTimeMillis() - this.f366a <= this.a) {
            return;
        }
        this.f370a = false;
        this.f366a = 0L;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ez m472a() {
        ez ezVar;
        ezVar = new ez();
        ezVar.a(bi.m283a((Context) this.f368a.f363a));
        ezVar.f340a = (byte) 0;
        ezVar.f344b = 1;
        ezVar.d((int) (System.currentTimeMillis() / 1000));
        return ezVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized fa m473a() {
        fa faVar;
        faVar = null;
        if (b()) {
            int i = PassBiometricUtil.k;
            if (!bi.e(this.f368a.f363a)) {
                i = 375;
            }
            faVar = a(i);
        }
        return faVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m474a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.a == i2 && this.f370a) {
                return;
            }
            this.f370a = true;
            this.f366a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f366a);
        }
    }

    public synchronized void a(ez ezVar) {
        this.f367a.a(ezVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f368a = new ff(xMPushService);
        this.f369a = "";
        com.xiaomi.push.service.bv.a().a(new fh(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m475a() {
        return this.f370a;
    }

    public boolean b() {
        m471a();
        return this.f370a && this.f367a.m289a() > 0;
    }
}
