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
    public long f367a;

    /* renamed from: a  reason: collision with other field name */
    public ff f369a;

    /* renamed from: a  reason: collision with other field name */
    public String f370a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f371a = false;

    /* renamed from: a  reason: collision with other field name */
    public bk f368a = bk.a();

    /* loaded from: classes10.dex */
    public static class a {
        public static final fg a = new fg();
    }

    private ez a(bk.a aVar) {
        if (aVar.f146a == 0) {
            Object obj = aVar.f147a;
            if (obj instanceof ez) {
                return (ez) obj;
            }
            return null;
        }
        ez m477a = m477a();
        m477a.a(ey.CHANNEL_STATS_COUNTER.a());
        m477a.c(aVar.f146a);
        m477a.c(aVar.f148a);
        return m477a;
    }

    private fa a(int i) {
        ArrayList arrayList = new ArrayList();
        fa faVar = new fa(this.f370a, arrayList);
        if (!bi.e(this.f369a.f364a)) {
            faVar.a(i.i(this.f369a.f364a));
        }
        jl jlVar = new jl(i);
        jd a2 = new jj.a().a(jlVar);
        try {
            faVar.b(a2);
        } catch (ix unused) {
        }
        LinkedList<bk.a> m295a = this.f368a.m295a();
        while (m295a.size() > 0) {
            try {
                ez a3 = a(m295a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jlVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m295a.removeLast();
            } catch (ix | NoSuchElementException unused2) {
            }
        }
        return faVar;
    }

    public static ff a() {
        ff ffVar;
        synchronized (a.a) {
            ffVar = a.a.f369a;
        }
        return ffVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static fg m475a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m476a() {
        if (!this.f371a || System.currentTimeMillis() - this.f367a <= this.a) {
            return;
        }
        this.f371a = false;
        this.f367a = 0L;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ez m477a() {
        ez ezVar;
        ezVar = new ez();
        ezVar.a(bi.m288a((Context) this.f369a.f364a));
        ezVar.f341a = (byte) 0;
        ezVar.f345b = 1;
        ezVar.d((int) (System.currentTimeMillis() / 1000));
        return ezVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized fa m478a() {
        fa faVar;
        faVar = null;
        if (b()) {
            int i = PassBiometricUtil.k;
            if (!bi.e(this.f369a.f364a)) {
                i = 375;
            }
            faVar = a(i);
        }
        return faVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m479a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.a == i2 && this.f371a) {
                return;
            }
            this.f371a = true;
            this.f367a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f367a);
        }
    }

    public synchronized void a(ez ezVar) {
        this.f368a.a(ezVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f369a = new ff(xMPushService);
        this.f370a = "";
        com.xiaomi.push.service.bv.a().a(new fh(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m480a() {
        return this.f371a;
    }

    public boolean b() {
        m476a();
        return this.f371a && this.f368a.m294a() > 0;
    }
}
