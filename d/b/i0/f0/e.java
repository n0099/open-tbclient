package d.b.i0.f0;

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
    public b f50914a;

    /* renamed from: b  reason: collision with root package name */
    public c f50915b;

    /* renamed from: c  reason: collision with root package name */
    public Application f50916c;

    /* renamed from: d  reason: collision with root package name */
    public String f50917d = null;

    /* renamed from: e  reason: collision with root package name */
    public final j f50918e = new j();

    /* renamed from: f  reason: collision with root package name */
    public final k f50919f = new k();

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.b.i0.f0.a a2;
            if (intent == null || !"intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) || (a2 = e.this.f50918e.a(intent)) == null) {
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
            if (e.this.f50915b != null) {
                e.this.f50915b.a(a2);
            }
        }
    }

    public e(Application application) {
        this.f50916c = application;
    }

    @Override // d.b.i0.f0.d
    public void a(d.b.i0.f0.a aVar) {
        h(aVar);
    }

    @Override // d.b.i0.f0.d
    public void b(c cVar) {
        this.f50915b = cVar;
    }

    @Override // d.b.i0.f0.d
    public void c() {
        g();
    }

    public final String f() {
        Application application;
        if (this.f50917d == null && (application = this.f50916c) != null) {
            this.f50917d = application.getPackageName();
        }
        return this.f50917d;
    }

    public final void g() {
        try {
            i();
            this.f50914a = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
            this.f50916c.registerReceiver(this.f50914a, intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void h(d.b.i0.f0.a aVar) {
        if (aVar != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(f());
                intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
                this.f50919f.a(intent, aVar);
                this.f50916c.sendBroadcast(intent);
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
            if (this.f50914a == null || this.f50916c == null) {
                return;
            }
            this.f50916c.unregisterReceiver(this.f50914a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
