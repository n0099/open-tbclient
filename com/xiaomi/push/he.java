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
/* loaded from: classes6.dex */
public class he {

    /* renamed from: a  reason: collision with root package name */
    private int f14381a;

    /* renamed from: a  reason: collision with other field name */
    private long f508a;

    /* renamed from: a  reason: collision with other field name */
    private hd f510a;

    /* renamed from: a  reason: collision with other field name */
    private String f511a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f512a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f509a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final he f14382a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f201a == 0) {
            if (aVar.f202a instanceof fi) {
                return (fi) aVar.f202a;
            }
            return null;
        }
        fi m366a = m366a();
        m366a.a(fh.CHANNEL_STATS_COUNTER.a());
        m366a.c(aVar.f201a);
        m366a.c(aVar.f203a);
        return m366a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f511a, arrayList);
        if (!az.d(this.f510a.f505a)) {
            fjVar.a(i.m(this.f510a.f505a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m191a = this.f509a.m191a();
        while (m191a.size() > 0) {
            try {
                fi a3 = a(m191a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jqVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m191a.removeLast();
            } catch (jc e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fjVar;
    }

    public static hd a() {
        hd hdVar;
        synchronized (a.f14382a) {
            hdVar = a.f14382a.f510a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m364a() {
        return a.f14382a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m365a() {
        if (!this.f512a || System.currentTimeMillis() - this.f508a <= this.f14381a) {
            return;
        }
        this.f512a = false;
        this.f508a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m366a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m170a((Context) this.f510a.f505a));
        fiVar.f403a = (byte) 0;
        fiVar.f407b = 1;
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        return fiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fj m367a() {
        fj fjVar;
        fjVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!az.d(this.f510a.f505a)) {
                i = 375;
            }
            fjVar = a(i);
        }
        return fjVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m368a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.f14381a == i2 && this.f512a) {
                return;
            }
            this.f512a = true;
            this.f508a = System.currentTimeMillis();
            this.f14381a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f508a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f509a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f510a = new hd(xMPushService);
        this.f511a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m369a() {
        return this.f512a;
    }

    boolean b() {
        m365a();
        return this.f512a && this.f509a.m190a() > 0;
    }
}
