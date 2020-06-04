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
    private long f427a;

    /* renamed from: a  reason: collision with other field name */
    private hd f429a;

    /* renamed from: a  reason: collision with other field name */
    private String f430a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f431a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f428a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        static final he a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f120a == 0) {
            if (aVar.f121a instanceof fi) {
                return (fi) aVar.f121a;
            }
            return null;
        }
        fi m333a = m333a();
        m333a.a(fh.CHANNEL_STATS_COUNTER.a());
        m333a.c(aVar.f120a);
        m333a.c(aVar.f122a);
        return m333a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f430a, arrayList);
        if (!az.d(this.f429a.f424a)) {
            fjVar.a(i.m(this.f429a.f424a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m158a = this.f428a.m158a();
        while (m158a.size() > 0) {
            try {
                fi a3 = a(m158a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jqVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m158a.removeLast();
            } catch (jc e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fjVar;
    }

    public static hd a() {
        hd hdVar;
        synchronized (a.a) {
            hdVar = a.a.f429a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m331a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m332a() {
        if (!this.f431a || System.currentTimeMillis() - this.f427a <= this.a) {
            return;
        }
        this.f431a = false;
        this.f427a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m333a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m137a((Context) this.f429a.f424a));
        fiVar.f322a = (byte) 0;
        fiVar.f326b = 1;
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        return fiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fj m334a() {
        fj fjVar;
        fjVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!az.d(this.f429a.f424a)) {
                i = 375;
            }
            fjVar = a(i);
        }
        return fjVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m335a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.a == i2 && this.f431a) {
                return;
            }
            this.f431a = true;
            this.f427a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f427a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f428a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f429a = new hd(xMPushService);
        this.f430a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m336a() {
        return this.f431a;
    }

    boolean b() {
        m332a();
        return this.f431a && this.f428a.m157a() > 0;
    }
}
