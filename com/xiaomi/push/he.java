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
/* loaded from: classes18.dex */
public class he {

    /* renamed from: a  reason: collision with root package name */
    private int f4946a;

    /* renamed from: a  reason: collision with other field name */
    private long f431a;

    /* renamed from: a  reason: collision with other field name */
    private hd f433a;

    /* renamed from: a  reason: collision with other field name */
    private String f434a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f435a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f432a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final he f4947a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f124a == 0) {
            if (aVar.f125a instanceof fi) {
                return (fi) aVar.f125a;
            }
            return null;
        }
        fi m339a = m339a();
        m339a.a(fh.CHANNEL_STATS_COUNTER.a());
        m339a.c(aVar.f124a);
        m339a.c(aVar.f126a);
        return m339a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f434a, arrayList);
        if (!az.d(this.f433a.f428a)) {
            fjVar.a(i.m(this.f433a.f428a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m164a = this.f432a.m164a();
        while (m164a.size() > 0) {
            try {
                fi a3 = a(m164a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jqVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m164a.removeLast();
            } catch (jc e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fjVar;
    }

    public static hd a() {
        hd hdVar;
        synchronized (a.f4947a) {
            hdVar = a.f4947a.f433a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m337a() {
        return a.f4947a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m338a() {
        if (!this.f435a || System.currentTimeMillis() - this.f431a <= this.f4946a) {
            return;
        }
        this.f435a = false;
        this.f431a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m339a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m143a((Context) this.f433a.f428a));
        fiVar.f326a = (byte) 0;
        fiVar.f330b = 1;
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        return fiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fj m340a() {
        fj fjVar;
        fjVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!az.d(this.f433a.f428a)) {
                i = 375;
            }
            fjVar = a(i);
        }
        return fjVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m341a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.f4946a == i2 && this.f435a) {
                return;
            }
            this.f435a = true;
            this.f431a = System.currentTimeMillis();
            this.f4946a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f431a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f432a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f433a = new hd(xMPushService);
        this.f434a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m342a() {
        return this.f435a;
    }

    boolean b() {
        m338a();
        return this.f435a && this.f432a.m163a() > 0;
    }
}
