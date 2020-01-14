package com.xiaomi.push;

import android.content.Context;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.xiaomi.push.au;
import com.xiaomi.push.ji;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public class gy {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f445a;

    /* renamed from: a  reason: collision with other field name */
    private gx f447a;

    /* renamed from: a  reason: collision with other field name */
    private String f448a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f449a = false;

    /* renamed from: a  reason: collision with other field name */
    private au f446a = au.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        static final gy a = new gy();
    }

    private fc a(au.a aVar) {
        if (aVar.f134a == 0) {
            if (aVar.f135a instanceof fc) {
                return (fc) aVar.f135a;
            }
            return null;
        }
        fc m320a = m320a();
        m320a.a(fb.CHANNEL_STATS_COUNTER.a());
        m320a.c(aVar.f134a);
        m320a.c(aVar.f136a);
        return m320a;
    }

    private fd a(int i) {
        ArrayList arrayList = new ArrayList();
        fd fdVar = new fd(this.f448a, arrayList);
        if (!as.d(this.f447a.f442a)) {
            fdVar.a(i.m(this.f447a.f442a));
        }
        jk jkVar = new jk(i);
        jc a2 = new ji.a().a(jkVar);
        try {
            fdVar.b(a2);
        } catch (iw e) {
        }
        LinkedList<au.a> m134a = this.f446a.m134a();
        while (m134a.size() > 0) {
            try {
                fc a3 = a(m134a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jkVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m134a.removeLast();
            } catch (iw e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fdVar;
    }

    public static gx a() {
        gx gxVar;
        synchronized (a.a) {
            gxVar = a.a.f447a;
        }
        return gxVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gy m318a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m319a() {
        if (!this.f449a || System.currentTimeMillis() - this.f445a <= this.a) {
            return;
        }
        this.f449a = false;
        this.f445a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fc m320a() {
        fc fcVar;
        fcVar = new fc();
        fcVar.a(as.m127a((Context) this.f447a.f442a));
        fcVar.f340a = (byte) 0;
        fcVar.f344b = 1;
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        return fcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fd m321a() {
        fd fdVar;
        fdVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!as.d(this.f447a.f442a)) {
                i = 375;
            }
            fdVar = a(i);
        }
        return fdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m322a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.a == i2 && this.f449a) {
                return;
            }
            this.f449a = true;
            this.f445a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f445a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fc fcVar) {
        this.f446a.a(fcVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f447a = new gx(xMPushService);
        this.f448a = "";
        com.xiaomi.push.service.ba.a().a(new gz(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m323a() {
        return this.f449a;
    }

    boolean b() {
        m319a();
        return this.f449a && this.f446a.m133a() > 0;
    }
}
