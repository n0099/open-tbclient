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
/* loaded from: classes8.dex */
public class gy {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f441a;

    /* renamed from: a  reason: collision with other field name */
    private gx f443a;

    /* renamed from: a  reason: collision with other field name */
    private String f444a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f445a = false;

    /* renamed from: a  reason: collision with other field name */
    private au f442a = au.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        static final gy a = new gy();
    }

    private fc a(au.a aVar) {
        if (aVar.f130a == 0) {
            if (aVar.f131a instanceof fc) {
                return (fc) aVar.f131a;
            }
            return null;
        }
        fc m323a = m323a();
        m323a.a(fb.CHANNEL_STATS_COUNTER.a());
        m323a.c(aVar.f130a);
        m323a.c(aVar.f132a);
        return m323a;
    }

    private fd a(int i) {
        ArrayList arrayList = new ArrayList();
        fd fdVar = new fd(this.f444a, arrayList);
        if (!as.d(this.f443a.f438a)) {
            fdVar.a(i.m(this.f443a.f438a));
        }
        jk jkVar = new jk(i);
        jc a2 = new ji.a().a(jkVar);
        try {
            fdVar.b(a2);
        } catch (iw e) {
        }
        LinkedList<au.a> m137a = this.f442a.m137a();
        while (m137a.size() > 0) {
            try {
                fc a3 = a(m137a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jkVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m137a.removeLast();
            } catch (iw e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fdVar;
    }

    public static gx a() {
        gx gxVar;
        synchronized (a.a) {
            gxVar = a.a.f443a;
        }
        return gxVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gy m321a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m322a() {
        if (!this.f445a || System.currentTimeMillis() - this.f441a <= this.a) {
            return;
        }
        this.f445a = false;
        this.f441a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fc m323a() {
        fc fcVar;
        fcVar = new fc();
        fcVar.a(as.m130a((Context) this.f443a.f438a));
        fcVar.f336a = (byte) 0;
        fcVar.f340b = 1;
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        return fcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fd m324a() {
        fd fdVar;
        fdVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!as.d(this.f443a.f438a)) {
                i = 375;
            }
            fdVar = a(i);
        }
        return fdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m325a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.a == i2 && this.f445a) {
                return;
            }
            this.f445a = true;
            this.f441a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f441a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fc fcVar) {
        this.f442a.a(fcVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f443a = new gx(xMPushService);
        this.f444a = "";
        com.xiaomi.push.service.ba.a().a(new gz(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m326a() {
        return this.f445a;
    }

    boolean b() {
        m322a();
        return this.f445a && this.f442a.m136a() > 0;
    }
}
