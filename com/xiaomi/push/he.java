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
/* loaded from: classes8.dex */
public class he {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f434a;

    /* renamed from: a  reason: collision with other field name */
    private hd f436a;

    /* renamed from: a  reason: collision with other field name */
    private String f437a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f438a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f435a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        static final he a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f127a == 0) {
            if (aVar.f128a instanceof fi) {
                return (fi) aVar.f128a;
            }
            return null;
        }
        fi m330a = m330a();
        m330a.a(fh.CHANNEL_STATS_COUNTER.a());
        m330a.c(aVar.f127a);
        m330a.c(aVar.f129a);
        return m330a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f437a, arrayList);
        if (!az.d(this.f436a.f431a)) {
            fjVar.a(i.m(this.f436a.f431a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m155a = this.f435a.m155a();
        while (m155a.size() > 0) {
            try {
                fi a3 = a(m155a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jqVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m155a.removeLast();
            } catch (jc e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fjVar;
    }

    public static hd a() {
        hd hdVar;
        synchronized (a.a) {
            hdVar = a.a.f436a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m328a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m329a() {
        if (!this.f438a || System.currentTimeMillis() - this.f434a <= this.a) {
            return;
        }
        this.f438a = false;
        this.f434a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m330a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m134a((Context) this.f436a.f431a));
        fiVar.f329a = (byte) 0;
        fiVar.f333b = 1;
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        return fiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fj m331a() {
        fj fjVar;
        fjVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!az.d(this.f436a.f431a)) {
                i = 375;
            }
            fjVar = a(i);
        }
        return fjVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m332a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.a == i2 && this.f438a) {
                return;
            }
            this.f438a = true;
            this.f434a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f434a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f435a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f436a = new hd(xMPushService);
        this.f437a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m333a() {
        return this.f438a;
    }

    boolean b() {
        m329a();
        return this.f438a && this.f435a.m154a() > 0;
    }
}
