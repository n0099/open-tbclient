package d.a.c.e.n.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {

    /* renamed from: i  reason: collision with root package name */
    public static volatile g f42579i;

    /* renamed from: b  reason: collision with root package name */
    public String f42581b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.n.b f42582c;

    /* renamed from: d  reason: collision with root package name */
    public i f42583d;

    /* renamed from: e  reason: collision with root package name */
    public f f42584e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.e.n.c f42585f;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, d.a.c.e.n.h.a> f42580a = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public Handler f42586g = new a(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public j f42587h = new e();

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 6) {
                return;
            }
            for (Map.Entry entry : g.this.f42580a.entrySet()) {
                d.a.c.e.n.h.a aVar = (d.a.c.e.n.h.a) entry.getValue();
                if (aVar.u() > 0) {
                    g.this.x(aVar, true, true);
                }
                if (aVar.t() > 0) {
                    d.a.c.e.n.m.d.c(aVar, true, true, true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends DiskFileOperate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f42589a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42590b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f42591c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            this.f42589a = aVar;
            this.f42590b = z;
            this.f42591c = z2;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42589a.H(0L);
                d.a.c.e.n.l.b.m().r(this.f42589a, this.f42590b, true, this.f42591c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends DiskFileOperate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f42592a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar) {
            super(str, str2, str3, str4, action);
            this.f42592a = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42592a.H(0L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends d.a.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f42593c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g gVar, String str, String str2, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar) {
            super(str, str2, action);
            this.f42593c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42593c.H(getFileInfo().length());
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements j {
        public e() {
        }

        @Override // d.a.c.e.n.m.j
        public void a(d.a.c.e.n.h.a aVar) {
            if (g.this.n(aVar)) {
                g.this.y(aVar);
            }
            if (g.this.l(aVar)) {
                g.this.t(aVar);
            }
            if (g.this.m(aVar)) {
                g.this.w(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            g.this.B(intent.getStringExtra("intent_data_userid"));
            g.this.o();
        }

        public /* synthetic */ f(g gVar, a aVar) {
            this();
        }
    }

    public static g h() {
        if (f42579i == null) {
            synchronized (g.class) {
                if (f42579i == null) {
                    f42579i = new g();
                }
            }
        }
        return f42579i;
    }

    public void A(d.a.c.e.n.h.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.l() > 0) {
            z(aVar, true);
        } else if (aVar.v() > 0) {
            h.b(aVar);
        }
    }

    public void B(String str) {
        this.f42581b = str;
    }

    public void C(String str, String str2, String str3, String str4, d.a.c.e.n.a aVar, Object... objArr) {
        d.a.c.e.n.h.a i2;
        if (str == null && str2 == null) {
            return;
        }
        if ((aVar == null && (objArr == null || objArr.length == 0)) || (i2 = i(str)) == null || !d.a.c.e.n.k.a.o().v(str, str2)) {
            return;
        }
        if (aVar == null) {
            aVar = new d.a.c.e.n.a(str);
        }
        if (!str.equals("stat") && !str.equals("crash")) {
            aVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
        }
        if (objArr != null && objArr.length > 0) {
            aVar.c(objArr);
        }
        if (this.f42581b != null && !str.equals("stat")) {
            aVar.b("uid", this.f42581b);
        }
        if (str3 != null && !str.equals("stat")) {
            aVar.b("c_logid", str3);
        }
        if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
            aVar.b("seq_id", str4);
        }
        if (!str.equals("stat")) {
            aVar.b("net", d.a.c.e.n.d.a(BdBaseApplication.getInst()));
        }
        if (!str.equals("stat") && !str.equals("pfmonitor")) {
            aVar.c("pid", Integer.valueOf(Process.myPid()));
            if (BdStatisticsManager.getInstance().isMainProcess()) {
                aVar.b("ismainproc", "1");
            } else {
                aVar.b("ismainproc", "0");
            }
        }
        if (d.a.c.e.n.f.e() && d.a.c.e.n.f.d(i2)) {
            aVar.d(this.f42585f);
            i2.c(aVar);
        }
        if (d.a.c.e.n.k.a.o().u(str, str2)) {
            i2.a(aVar);
        } else {
            i2.b(aVar);
        }
    }

    public void e() {
        for (Map.Entry<String, d.a.c.e.n.h.a> entry : this.f42580a.entrySet()) {
            d.a.c.e.n.h.a value = entry.getValue();
            d.a.c.e.n.b bVar = this.f42582c;
            if (bVar != null) {
                long logUploadTime = bVar.getLogUploadTime(value.o());
                if (logUploadTime <= 0) {
                    logUploadTime = System.currentTimeMillis();
                    this.f42582c.setLogUploadTime(value.o(), logUploadTime);
                }
                value.L(logUploadTime);
            }
            if (value != null) {
                if (value.l() > 0) {
                    z(value, false);
                }
                if (value.v() > 20480) {
                    h.b(value);
                } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                    h.b(value);
                }
                if (value.m() > 0) {
                    u(value, false);
                }
                if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    d.a.c.e.n.m.d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                    d.a.c.e.n.m.d.c(value, false, false, false);
                }
            }
        }
    }

    public void f() {
        if (this.f42583d == null) {
            this.f42583d = new i();
        }
        this.f42583d.a();
    }

    public final void g() {
        Message obtainMessage = this.f42586g.obtainMessage();
        obtainMessage.what = 6;
        this.f42586g.removeMessages(6);
        this.f42586g.sendMessageDelayed(obtainMessage, 3000L);
    }

    public synchronized d.a.c.e.n.h.a i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String g2 = d.a.c.e.n.h.a.g(str);
        d.a.c.e.n.h.a aVar = this.f42580a.get(g2);
        if (aVar == null) {
            if ("alert".equals(g2)) {
                aVar = new d.a.c.e.n.m.a(null);
            } else if ("error".equals(g2)) {
                aVar = new d.a.c.e.n.m.c(this.f42587h);
            } else if ("dbg".equals(g2)) {
                aVar = new d.a.c.e.n.m.b(this.f42587h);
            } else if ("stat".equals(g2)) {
                aVar = new d.a.c.e.n.m.f(this.f42587h);
            } else if ("pfmonitor".equals(g2)) {
                aVar = new d.a.c.e.n.m.e(this.f42587h);
            } else {
                aVar = new d.a.c.e.n.m.c(this.f42587h);
            }
            aVar.I(g2);
            this.f42580a.put(g2, aVar);
        }
        return aVar;
    }

    public String j() {
        return this.f42581b;
    }

    public void k(d.a.c.e.n.c cVar) {
        if (this.f42584e == null) {
            this.f42584e = new f(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.f42584e, intentFilter);
        }
        this.f42582c = BdStatisticsManager.getInstance().getBdLogSetting();
        this.f42585f = cVar;
    }

    public final boolean l(d.a.c.e.n.h.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.i() >= 60000;
        if (d.a.c.e.n.k.a.o().s(aVar.o())) {
            z = true;
        }
        if (aVar.m() >= 10) {
            return true;
        }
        return z;
    }

    public final boolean m(d.a.c.e.n.h.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.j() >= 60000;
        if (d.a.c.e.n.k.a.o().s(aVar.o())) {
            z = true;
        }
        if (aVar.n() >= 10) {
            return true;
        }
        return z;
    }

    public final boolean n(d.a.c.e.n.h.a aVar) {
        if (aVar != null && d.a.c.e.n.f.e() && d.a.c.e.n.f.d(aVar)) {
            boolean z = System.currentTimeMillis() - aVar.k() >= 60000;
            if (d.a.c.e.n.k.a.o().s(aVar.o())) {
                z = true;
            }
            if (aVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return false;
    }

    public void o() {
        for (Map.Entry<String, d.a.c.e.n.h.a> entry : this.f42580a.entrySet()) {
            d.a.c.e.n.h.a value = entry.getValue();
            y(value);
            t(value);
        }
    }

    public void p() {
        for (Map.Entry<String, d.a.c.e.n.h.a> entry : this.f42580a.entrySet()) {
            d.a.c.e.n.h.a value = entry.getValue();
            A(value);
            v(value);
        }
    }

    public void q(String str) {
        d.a.c.e.n.h.a i2 = h().i(str);
        A(i2);
        x(i2, false, true);
        v(i2);
    }

    public void r() {
        for (Map.Entry<String, d.a.c.e.n.h.a> entry : this.f42580a.entrySet()) {
            d.a.c.e.n.h.a value = entry.getValue();
            A(value);
            x(value, false, false);
            v(value);
        }
    }

    public void s() {
        for (Map.Entry<String, d.a.c.e.n.h.a> entry : this.f42580a.entrySet()) {
            d.a.c.e.n.h.a value = entry.getValue();
            y(value);
            t(value);
            w(value);
        }
        g();
    }

    public void t(d.a.c.e.n.h.a aVar) {
        u(aVar, false);
    }

    public final void u(d.a.c.e.n.h.a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        if (d.a.c.e.n.m.d.b(aVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            d.a.c.e.n.m.d.c(aVar, false, false, false);
        }
        d.a.c.e.n.m.d.d(aVar, z);
    }

    public void v(d.a.c.e.n.h.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.m() > 0) {
            u(aVar, true);
        } else if (aVar.t() > 0) {
            d.a.c.e.n.m.d.c(aVar, false, false, false);
        }
    }

    public void w(d.a.c.e.n.h.a aVar) {
        if (aVar == null || aVar.n() == 0) {
            return;
        }
        if (aVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar);
            cVar.setSdCard(aVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            d.a.c.e.a.d.g().a(cVar);
        }
        d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), DiskFileOperate.Action.APPEND, aVar);
        dVar.setSdCard(aVar.E());
        dVar.b(aVar.y().toString());
        aVar.e();
        if (!aVar.A()) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        d.a.c.e.a.d.g().a(dVar);
    }

    public void x(d.a.c.e.n.h.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            bVar.setSdCard(aVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            d.a.c.e.a.d.g().a(bVar);
        }
    }

    public void y(d.a.c.e.n.h.a aVar) {
        z(aVar, false);
    }

    public final void z(d.a.c.e.n.h.a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        if (h.a(aVar) > 20480) {
            h.b(aVar);
        }
        h.c(aVar, z);
    }
}
