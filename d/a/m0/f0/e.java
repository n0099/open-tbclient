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
    public b f53039a;

    /* renamed from: b  reason: collision with root package name */
    public c f53040b;

    /* renamed from: c  reason: collision with root package name */
    public Application f53041c;

    /* renamed from: d  reason: collision with root package name */
    public String f53042d = null;

    /* renamed from: e  reason: collision with root package name */
    public final j f53043e = new j();

    /* renamed from: f  reason: collision with root package name */
    public final k f53044f = new k();

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.a.m0.f0.a a2;
            if (intent == null || !"intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) || (a2 = e.this.f53043e.a(intent)) == null) {
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
            if (e.this.f53040b != null) {
                e.this.f53040b.a(a2);
            }
        }
    }

    public e(Application application) {
        this.f53041c = application;
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
        this.f53040b = cVar;
    }

    public final String f() {
        Application application;
        if (this.f53042d == null && (application = this.f53041c) != null) {
            this.f53042d = application.getPackageName();
        }
        return this.f53042d;
    }

    public final void g() {
        try {
            i();
            this.f53039a = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
            this.f53041c.registerReceiver(this.f53039a, intentFilter);
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
                this.f53044f.a(intent, aVar);
                this.f53041c.sendBroadcast(intent);
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
            if (this.f53039a == null || this.f53041c == null) {
                return;
            }
            this.f53041c.unregisterReceiver(this.f53039a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
