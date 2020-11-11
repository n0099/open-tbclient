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
/* loaded from: classes12.dex */
public class he {

    /* renamed from: a  reason: collision with root package name */
    private int f4946a;

    /* renamed from: a  reason: collision with other field name */
    private long f428a;

    /* renamed from: a  reason: collision with other field name */
    private hd f430a;

    /* renamed from: a  reason: collision with other field name */
    private String f431a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f432a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f429a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final he f4947a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f121a == 0) {
            if (aVar.f122a instanceof fi) {
                return (fi) aVar.f122a;
            }
            return null;
        }
        fi m336a = m336a();
        m336a.a(fh.CHANNEL_STATS_COUNTER.a());
        m336a.c(aVar.f121a);
        m336a.c(aVar.f123a);
        return m336a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f431a, arrayList);
        if (!az.d(this.f430a.f425a)) {
            fjVar.a(i.m(this.f430a.f425a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m161a = this.f429a.m161a();
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
        synchronized (a.f4947a) {
            hdVar = a.f4947a.f430a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m334a() {
        return a.f4947a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m335a() {
        if (!this.f432a || System.currentTimeMillis() - this.f428a <= this.f4946a) {
            return;
        }
        this.f432a = false;
        this.f428a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m336a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m140a((Context) this.f430a.f425a));
        fiVar.f323a = (byte) 0;
        fiVar.f327b = 1;
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
            if (!az.d(this.f430a.f425a)) {
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
            if (this.f4946a == i2 && this.f432a) {
                return;
            }
            this.f432a = true;
            this.f428a = System.currentTimeMillis();
            this.f4946a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f428a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f429a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f430a = new hd(xMPushService);
        this.f431a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m339a() {
        return this.f432a;
    }

    boolean b() {
        m335a();
        return this.f432a && this.f429a.m160a() > 0;
    }
}
