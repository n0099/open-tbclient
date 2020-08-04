package com.xiaomi.push;

import android.content.Context;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.xiaomi.push.bb;
import com.xiaomi.push.jo;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/* loaded from: classes9.dex */
public class he {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f433a;

    /* renamed from: a  reason: collision with other field name */
    private hd f435a;

    /* renamed from: a  reason: collision with other field name */
    private String f436a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f437a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f434a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a {
        static final he a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f126a == 0) {
            if (aVar.f127a instanceof fi) {
                return (fi) aVar.f127a;
            }
            return null;
        }
        fi m331a = m331a();
        m331a.a(fh.CHANNEL_STATS_COUNTER.a());
        m331a.c(aVar.f126a);
        m331a.c(aVar.f128a);
        return m331a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f436a, arrayList);
        if (!az.d(this.f435a.f430a)) {
            fjVar.a(i.m(this.f435a.f430a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m156a = this.f434a.m156a();
        while (m156a.size() > 0) {
            try {
                fi a3 = a(m156a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jqVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m156a.removeLast();
            } catch (jc e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fjVar;
    }

    public static hd a() {
        hd hdVar;
        synchronized (a.a) {
            hdVar = a.a.f435a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m329a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m330a() {
        if (!this.f437a || System.currentTimeMillis() - this.f433a <= this.a) {
            return;
        }
        this.f437a = false;
        this.f433a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m331a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m135a((Context) this.f435a.f430a));
        fiVar.f328a = (byte) 0;
        fiVar.f332b = 1;
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        return fiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fj m332a() {
        fj fjVar;
        fjVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!az.d(this.f435a.f430a)) {
                i = 375;
            }
            fjVar = a(i);
        }
        return fjVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m333a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.a == i2 && this.f437a) {
                return;
            }
            this.f437a = true;
            this.f433a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f433a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f434a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f435a = new hd(xMPushService);
        this.f436a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m334a() {
        return this.f437a;
    }

    boolean b() {
        m330a();
        return this.f437a && this.f434a.m155a() > 0;
    }
}
