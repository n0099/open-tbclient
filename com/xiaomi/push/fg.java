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
    public long f362a;

    /* renamed from: a  reason: collision with other field name */
    public ff f364a;

    /* renamed from: a  reason: collision with other field name */
    public String f365a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f366a = false;

    /* renamed from: a  reason: collision with other field name */
    public bk f363a = bk.a();

    /* loaded from: classes10.dex */
    public static class a {
        public static final fg a = new fg();
    }

    private ez a(bk.a aVar) {
        if (aVar.f141a == 0) {
            Object obj = aVar.f142a;
            if (obj instanceof ez) {
                return (ez) obj;
            }
            return null;
        }
        ez m487a = m487a();
        m487a.a(ey.CHANNEL_STATS_COUNTER.a());
        m487a.c(aVar.f141a);
        m487a.c(aVar.f143a);
        return m487a;
    }

    private fa a(int i) {
        ArrayList arrayList = new ArrayList();
        fa faVar = new fa(this.f365a, arrayList);
        if (!bi.e(this.f364a.f359a)) {
            faVar.a(i.i(this.f364a.f359a));
        }
        jl jlVar = new jl(i);
        jd a2 = new jj.a().a(jlVar);
        try {
            faVar.b(a2);
        } catch (ix unused) {
        }
        LinkedList<bk.a> m305a = this.f363a.m305a();
        while (m305a.size() > 0) {
            try {
                ez a3 = a(m305a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jlVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m305a.removeLast();
            } catch (ix | NoSuchElementException unused2) {
            }
        }
        return faVar;
    }

    public static ff a() {
        ff ffVar;
        synchronized (a.a) {
            ffVar = a.a.f364a;
        }
        return ffVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static fg m485a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m486a() {
        if (!this.f366a || System.currentTimeMillis() - this.f362a <= this.a) {
            return;
        }
        this.f366a = false;
        this.f362a = 0L;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ez m487a() {
        ez ezVar;
        ezVar = new ez();
        ezVar.a(bi.m298a((Context) this.f364a.f359a));
        ezVar.f336a = (byte) 0;
        ezVar.f340b = 1;
        ezVar.d((int) (System.currentTimeMillis() / 1000));
        return ezVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized fa m488a() {
        fa faVar;
        faVar = null;
        if (b()) {
            int i = PassBiometricUtil.k;
            if (!bi.e(this.f364a.f359a)) {
                i = 375;
            }
            faVar = a(i);
        }
        return faVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m489a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.a == i2 && this.f366a) {
                return;
            }
            this.f366a = true;
            this.f362a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f362a);
        }
    }

    public synchronized void a(ez ezVar) {
        this.f363a.a(ezVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f364a = new ff(xMPushService);
        this.f365a = "";
        com.xiaomi.push.service.bv.a().a(new fh(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m490a() {
        return this.f366a;
    }

    public boolean b() {
        m486a();
        return this.f366a && this.f363a.m304a() > 0;
    }
}
