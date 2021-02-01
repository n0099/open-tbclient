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
    private int f14083a;

    /* renamed from: a  reason: collision with other field name */
    private long f507a;

    /* renamed from: a  reason: collision with other field name */
    private hd f509a;

    /* renamed from: a  reason: collision with other field name */
    private String f510a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f511a = false;

    /* renamed from: a  reason: collision with other field name */
    private bb f508a = bb.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final he f14084a = new he();
    }

    private fi a(bb.a aVar) {
        if (aVar.f200a == 0) {
            if (aVar.f201a instanceof fi) {
                return (fi) aVar.f201a;
            }
            return null;
        }
        fi m362a = m362a();
        m362a.a(fh.CHANNEL_STATS_COUNTER.a());
        m362a.c(aVar.f200a);
        m362a.c(aVar.f202a);
        return m362a;
    }

    private fj a(int i) {
        ArrayList arrayList = new ArrayList();
        fj fjVar = new fj(this.f510a, arrayList);
        if (!az.d(this.f509a.f504a)) {
            fjVar.a(i.m(this.f509a.f504a));
        }
        jq jqVar = new jq(i);
        ji a2 = new jo.a().a(jqVar);
        try {
            fjVar.b(a2);
        } catch (jc e) {
        }
        LinkedList<bb.a> m187a = this.f508a.m187a();
        while (m187a.size() > 0) {
            try {
                fi a3 = a(m187a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jqVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m187a.removeLast();
            } catch (jc e2) {
            } catch (NoSuchElementException e3) {
            }
        }
        return fjVar;
    }

    public static hd a() {
        hd hdVar;
        synchronized (a.f14084a) {
            hdVar = a.f14084a.f509a;
        }
        return hdVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static he m360a() {
        return a.f14084a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m361a() {
        if (!this.f511a || System.currentTimeMillis() - this.f507a <= this.f14083a) {
            return;
        }
        this.f511a = false;
        this.f507a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fi m362a() {
        fi fiVar;
        fiVar = new fi();
        fiVar.a(az.m166a((Context) this.f509a.f504a));
        fiVar.f402a = (byte) 0;
        fiVar.f406b = 1;
        fiVar.d((int) (System.currentTimeMillis() / 1000));
        return fiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fj m363a() {
        fj fjVar;
        fjVar = null;
        if (b()) {
            int i = FormCard.WIDTH_DEFAULT_SIZE;
            if (!az.d(this.f509a.f504a)) {
                i = 375;
            }
            fjVar = a(i);
        }
        return fjVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m364a(int i) {
        int i2 = PersonListModel.CACHETIME;
        if (i > 0) {
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.f14083a == i2 && this.f511a) {
                return;
            }
            this.f511a = true;
            this.f507a = System.currentTimeMillis();
            this.f14083a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f507a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fi fiVar) {
        this.f508a.a(fiVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f509a = new hd(xMPushService);
        this.f510a = "";
        com.xiaomi.push.service.be.a().a(new hf(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m365a() {
        return this.f511a;
    }

    boolean b() {
        m361a();
        return this.f511a && this.f508a.m186a() > 0;
    }
}
