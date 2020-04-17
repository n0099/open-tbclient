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
    private long f442a;

    /* renamed from: a  reason: collision with other field name */
    private gx f444a;

    /* renamed from: a  reason: collision with other field name */
    private String f445a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f446a = false;

    /* renamed from: a  reason: collision with other field name */
    private au f443a = au.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        static final gy a = new gy();
    }

    private fc a(au.a aVar) {
        if (aVar.f131a == 0) {
            if (aVar.f132a instanceof fc) {
                return (fc) aVar.f132a;
            }
            return null;
        }
        fc m328a = m328a();
        m328a.a(fb.CHANNEL_STATS_COUNTER.a());
        m328a.c(aVar.f131a);
        m328a.c(aVar.f133a);
        return m328a;
    }

    private fd a(int i) {
        ArrayList arrayList = new ArrayList();
        fd fdVar = new fd(this.f445a, arrayList);
        if (!as.d(this.f444a.f439a)) {
            fdVar.a(i.m(this.f444a.f439a));
        }
        jk jkVar = new jk(i);
        jc a2 = new ji.a().a(jkVar);
        try {
            fdVar.b(a2);
        } catch (iw e) {
        }
        LinkedList<au.a> m142a = this.f443a.m142a();
        while (m142a.size() > 0) {
            try {
                fc a3 = a(m142a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jkVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m142a.removeLast();
            } catch (iw e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fdVar;
    }

    public static gx a() {
        gx gxVar;
        synchronized (a.a) {
            gxVar = a.a.f444a;
        }
        return gxVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gy m326a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m327a() {
        if (!this.f446a || System.currentTimeMillis() - this.f442a <= this.a) {
            return;
        }
        this.f446a = false;
        this.f442a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fc m328a() {
        fc fcVar;
        fcVar = new fc();
        fcVar.a(as.m135a((Context) this.f444a.f439a));
        fcVar.f337a = (byte) 0;
        fcVar.f341b = 1;
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        return fcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fd m329a() {
        fd fdVar;
        fdVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!as.d(this.f444a.f439a)) {
                i = 375;
            }
            fdVar = a(i);
        }
        return fdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m330a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.a == i2 && this.f446a) {
                return;
            }
            this.f446a = true;
            this.f442a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f442a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fc fcVar) {
        this.f443a.a(fcVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f444a = new gx(xMPushService);
        this.f445a = "";
        com.xiaomi.push.service.ba.a().a(new gz(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m331a() {
        return this.f446a;
    }

    boolean b() {
        m327a();
        return this.f446a && this.f443a.m141a() > 0;
    }
}
