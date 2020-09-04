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
/* loaded from: classes7.dex */
public class he {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f429a;

    /* renamed from: a  reason: collision with other field name */
    private hd f431a;

    /* renamed from: a  reason: collision with other field name */
    private String f432a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f433a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f430a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        static final he a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f122a == 0) {
            if (aVar.f123a instanceof fi) {
                return (fi) aVar.f123a;
            }
            return null;
        }
        fi m336a = m336a();
        m336a.a(fh.CHANNEL_STATS_COUNTER.a());
        m336a.c(aVar.f122a);
        m336a.c(aVar.f124a);
        return m336a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f432a, arrayList);
        if (!az.d(this.f431a.f426a)) {
            fjVar.a(i.m(this.f431a.f426a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m161a = this.f430a.m161a();
        while (m161a.size() > 0) {
            try {
                fi a3 = a(m161a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jqVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m161a.removeLast();
            } catch (jc e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fjVar;
    }

    public static hd a() {
        hd hdVar;
        synchronized (a.a) {
            hdVar = a.a.f431a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m334a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m335a() {
        if (!this.f433a || System.currentTimeMillis() - this.f429a <= this.a) {
            return;
        }
        this.f433a = false;
        this.f429a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m336a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m140a((Context) this.f431a.f426a));
        fiVar.f324a = (byte) 0;
        fiVar.f328b = 1;
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        return fiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fj m337a() {
        fj fjVar;
        fjVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!az.d(this.f431a.f426a)) {
                i = 375;
            }
            fjVar = a(i);
        }
        return fjVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m338a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.a == i2 && this.f433a) {
                return;
            }
            this.f433a = true;
            this.f429a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f429a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f430a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f431a = new hd(xMPushService);
        this.f432a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m339a() {
        return this.f433a;
    }

    boolean b() {
        m335a();
        return this.f433a && this.f430a.m160a() > 0;
    }
}
