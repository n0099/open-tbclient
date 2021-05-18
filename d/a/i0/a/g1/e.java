package d.a.i0.a.g1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41738e = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41741c;

    /* renamed from: a  reason: collision with root package name */
    public c f41739a = new c(this);

    /* renamed from: b  reason: collision with root package name */
    public a f41740b = new a();

    /* renamed from: d  reason: collision with root package name */
    public final d.a.i0.a.g1.j.a f41742d = d.a.i0.a.g1.j.c.f();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f41743a;

        /* renamed from: b  reason: collision with root package name */
        public Timer f41744b;

        /* renamed from: c  reason: collision with root package name */
        public long f41745c = 300;

        /* renamed from: d  reason: collision with root package name */
        public int f41746d = 0;

        /* renamed from: d.a.i0.a.g1.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0630a extends TimerTask {
            public C0630a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (e.f41738e) {
                    Log.d("SwanAppCollectionPolicy", "task run: " + a.this.f41745c);
                }
                a.this.f41745c -= 10;
                if (a.this.f41745c > 0 || a.this.f41743a == null) {
                    return;
                }
                a.this.f41743a.g(1);
                a.this.l();
            }
        }

        public final synchronized void d() {
            if (this.f41744b != null) {
                this.f41744b.cancel();
                this.f41744b.purge();
                this.f41744b = null;
            }
        }

        public final TimerTask e() {
            return new C0630a();
        }

        public void f() {
            if (this.f41746d == 2) {
                return;
            }
            this.f41746d = 4;
            d();
        }

        public final void g() {
            this.f41745c = d.a.i0.a.r1.l.c.a();
            if (e.f41738e && d.a.i0.a.u1.a.a.t().getBoolean("swan_5min_back_optimize", false)) {
                this.f41745c = 30L;
            }
        }

        public void h() {
            if (this.f41746d != 4) {
                return;
            }
            this.f41746d = 3;
            d();
            i();
        }

        public final void i() {
            Timer timer = new Timer();
            this.f41744b = timer;
            timer.schedule(e(), 0L, 10000L);
        }

        public void j(b bVar) {
            this.f41743a = bVar;
        }

        public void k() {
            this.f41746d = 1;
            g();
            d();
            i();
        }

        public void l() {
            this.f41746d = 2;
            d();
            g();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void g(int i2);
    }

    /* loaded from: classes3.dex */
    public static class c extends BroadcastReceiver {
        public WeakReference<e> mPolicyRef;

        public c(e eVar) {
            this.mPolicyRef = new WeakReference<>(eVar);
        }

        public static IntentFilter getIntentFilter() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            return intentFilter;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e eVar;
            if (intent == null || TextUtils.isEmpty(intent.getAction()) || (eVar = this.mPolicyRef.get()) == null) {
                return;
            }
            String action = intent.getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -2128145023) {
                if (hashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                    c2 = 0;
                }
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                c2 = 1;
            }
            if (c2 == 0) {
                eVar.d(true);
            } else if (c2 != 1) {
            } else {
                eVar.d(false);
            }
        }
    }

    public void c(Context context) {
        if (this.f41741c) {
            return;
        }
        if (context == null && (context = d.a.i0.a.c1.a.b()) == null) {
            return;
        }
        this.f41741c = true;
        context.registerReceiver(this.f41739a, c.getIntentFilter());
    }

    public final void d(boolean z) {
        if (f41738e) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            g();
        } else {
            e();
        }
    }

    public final void e() {
        this.f41740b.f();
    }

    public void f(Context context) {
        if (this.f41741c) {
            if (context == null && (context = d.a.i0.a.c1.a.b()) == null) {
                return;
            }
            this.f41741c = false;
            try {
                context.unregisterReceiver(this.f41739a);
            } catch (IllegalArgumentException e2) {
                if (f41738e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g() {
        this.f41740b.h();
    }

    public void h(b bVar) {
        this.f41740b.j(bVar);
    }

    public void i() {
        if (f41738e) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.f41742d.onPause();
        this.f41740b.k();
    }

    public void j() {
        if (f41738e) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.f41742d.onResume();
        this.f41740b.l();
    }
}
