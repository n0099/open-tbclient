package d.a.m0.f0;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public b f49365a;

    /* renamed from: b  reason: collision with root package name */
    public c f49366b;

    /* renamed from: c  reason: collision with root package name */
    public Application f49367c;

    /* renamed from: d  reason: collision with root package name */
    public String f49368d = null;

    /* renamed from: e  reason: collision with root package name */
    public final j f49369e = new j();

    /* renamed from: f  reason: collision with root package name */
    public final k f49370f = new k();

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.a.m0.f0.a a2;
            if (intent == null || !"intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) || (a2 = e.this.f49369e.a(intent)) == null) {
                return;
            }
            int myPid = Process.myPid();
            int pid = a2.getPid();
            if (a2 == null || a2.getType() != 1) {
                if (a2.getType() == 2) {
                    if (myPid != pid) {
                        return;
                    }
                } else if (a2.getType() == 3 && !TbadkCoreApplication.getInst().isMainProcess(true)) {
                    return;
                }
            } else if (myPid == pid) {
                return;
            }
            if (e.this.f49366b != null) {
                e.this.f49366b.a(a2);
            }
        }
    }

    public e(Application application) {
        this.f49367c = application;
    }

    @Override // d.a.m0.f0.d
    public void a() {
        g();
    }

    @Override // d.a.m0.f0.d
    public void b(d.a.m0.f0.a aVar) {
        h(aVar);
    }

    @Override // d.a.m0.f0.d
    public void c(c cVar) {
        this.f49366b = cVar;
    }

    public final String f() {
        Application application;
        if (this.f49368d == null && (application = this.f49367c) != null) {
            this.f49368d = application.getPackageName();
        }
        return this.f49368d;
    }

    public final void g() {
        try {
            i();
            this.f49365a = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
            this.f49367c.registerReceiver(this.f49365a, intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void h(d.a.m0.f0.a aVar) {
        if (aVar != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(f());
                intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
                this.f49370f.a(intent, aVar);
                this.f49367c.sendBroadcast(intent);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        throw new NullPointerException("send multi-process message is null");
    }

    public final void i() {
        try {
            if (this.f49365a == null || this.f49367c == null) {
                return;
            }
            this.f49367c.unregisterReceiver(this.f49365a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
