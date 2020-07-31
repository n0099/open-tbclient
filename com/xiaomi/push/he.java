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
    private long f430a;

    /* renamed from: a  reason: collision with other field name */
    private hd f432a;

    /* renamed from: a  reason: collision with other field name */
    private String f433a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f434a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f431a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a {
        static final he a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f123a == 0) {
            if (aVar.f124a instanceof fi) {
                return (fi) aVar.f124a;
            }
            return null;
        }
        fi m331a = m331a();
        m331a.a(fh.CHANNEL_STATS_COUNTER.a());
        m331a.c(aVar.f123a);
        m331a.c(aVar.f125a);
        return m331a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f433a, arrayList);
        if (!az.d(this.f432a.f427a)) {
            fjVar.a(i.m(this.f432a.f427a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m156a = this.f431a.m156a();
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
            hdVar = a.a.f432a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m329a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m330a() {
        if (!this.f434a || System.currentTimeMillis() - this.f430a <= this.a) {
            return;
        }
        this.f434a = false;
        this.f430a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m331a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m135a((Context) this.f432a.f427a));
        fiVar.f325a = (byte) 0;
        fiVar.f329b = 1;
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
            if (!az.d(this.f432a.f427a)) {
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
            if (this.a == i2 && this.f434a) {
                return;
            }
            this.f434a = true;
            this.f430a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f430a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f431a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f432a = new hd(xMPushService);
        this.f433a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m334a() {
        return this.f434a;
    }

    boolean b() {
        m330a();
        return this.f434a && this.f431a.m155a() > 0;
    }
}
