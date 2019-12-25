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
/* loaded from: classes5.dex */
public class gy {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f446a;

    /* renamed from: a  reason: collision with other field name */
    private gx f448a;

    /* renamed from: a  reason: collision with other field name */
    private String f449a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f450a = false;

    /* renamed from: a  reason: collision with other field name */
    private au f447a = au.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        static final gy a = new gy();
    }

    private fc a(au.a aVar) {
        if (aVar.f135a == 0) {
            if (aVar.f136a instanceof fc) {
                return (fc) aVar.f136a;
            }
            return null;
        }
        fc m311a = m311a();
        m311a.a(fb.CHANNEL_STATS_COUNTER.a());
        m311a.c(aVar.f135a);
        m311a.c(aVar.f137a);
        return m311a;
    }

    private fd a(int i) {
        ArrayList arrayList = new ArrayList();
        fd fdVar = new fd(this.f449a, arrayList);
        if (!as.d(this.f448a.f443a)) {
            fdVar.a(i.m(this.f448a.f443a));
        }
        jk jkVar = new jk(i);
        jc a2 = new ji.a().a(jkVar);
        try {
            fdVar.b(a2);
        } catch (iw e) {
        }
        LinkedList<au.a> m125a = this.f447a.m125a();
        while (m125a.size() > 0) {
            try {
                fc a3 = a(m125a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jkVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m125a.removeLast();
            } catch (iw e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fdVar;
    }

    public static gx a() {
        gx gxVar;
        synchronized (a.a) {
            gxVar = a.a.f448a;
        }
        return gxVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gy m309a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m310a() {
        if (!this.f450a || System.currentTimeMillis() - this.f446a <= this.a) {
            return;
        }
        this.f450a = false;
        this.f446a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fc m311a() {
        fc fcVar;
        fcVar = new fc();
        fcVar.a(as.m118a((Context) this.f448a.f443a));
        fcVar.f341a = (byte) 0;
        fcVar.f345b = 1;
        fcVar.d((int) (System.currentTimeMillis() / 1000));
        return fcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fd m312a() {
        fd fdVar;
        fdVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!as.d(this.f448a.f443a)) {
                i = 375;
            }
            fdVar = a(i);
        }
        return fdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m313a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.a == i2 && this.f450a) {
                return;
            }
            this.f450a = true;
            this.f446a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f446a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fc fcVar) {
        this.f447a.a(fcVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f448a = new gx(xMPushService);
        this.f449a = "";
        com.xiaomi.push.service.ba.a().a(new gz(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m314a() {
        return this.f450a;
    }

    boolean b() {
        m310a();
        return this.f450a && this.f447a.m124a() > 0;
    }
}
