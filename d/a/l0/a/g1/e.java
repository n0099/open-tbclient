package d.a.l0.a.g1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41912e = k.f43199a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41915c;

    /* renamed from: a  reason: collision with root package name */
    public c f41913a = new c(this);

    /* renamed from: b  reason: collision with root package name */
    public a f41914b = new a();

    /* renamed from: d  reason: collision with root package name */
    public final d.a.l0.a.g1.j.a f41916d = d.a.l0.a.g1.j.c.f();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f41917a;

        /* renamed from: b  reason: collision with root package name */
        public Timer f41918b;

        /* renamed from: c  reason: collision with root package name */
        public long f41919c = 300;

        /* renamed from: d  reason: collision with root package name */
        public int f41920d = 0;

        /* renamed from: d.a.l0.a.g1.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0641a extends TimerTask {
            public C0641a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (e.f41912e) {
                    Log.d("SwanAppCollectionPolicy", "task run: " + a.this.f41919c);
                }
                a.this.f41919c -= 10;
                if (a.this.f41919c > 0 || a.this.f41917a == null) {
                    return;
                }
                a.this.f41917a.g(1);
                a.this.l();
            }
        }

        public final synchronized void d() {
            if (this.f41918b != null) {
                this.f41918b.cancel();
                this.f41918b.purge();
                this.f41918b = null;
            }
        }

        public final TimerTask e() {
            return new C0641a();
        }

        public void f() {
            if (this.f41920d == 2) {
                return;
            }
            this.f41920d = 4;
            d();
        }

        public final void g() {
            this.f41919c = d.a.l0.a.r1.l.c.a();
            if (e.f41912e && d.a.l0.a.u1.a.a.t().getBoolean("swan_5min_back_optimize", false)) {
                this.f41919c = 30L;
            }
        }

        public void h() {
            if (this.f41920d != 4) {
                return;
            }
            this.f41920d = 3;
            d();
            i();
        }

        public final void i() {
            Timer timer = new Timer();
            this.f41918b = timer;
            timer.schedule(e(), 0L, 10000L);
        }

        public void j(b bVar) {
            this.f41917a = bVar;
        }

        public void k() {
            this.f41920d = 1;
            g();
            d();
            i();
        }

        public void l() {
            this.f41920d = 2;
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
        if (this.f41915c) {
            return;
        }
        if (context == null && (context = d.a.l0.a.c1.a.b()) == null) {
            return;
        }
        this.f41915c = true;
        context.registerReceiver(this.f41913a, c.getIntentFilter());
    }

    public final void d(boolean z) {
        if (f41912e) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            g();
        } else {
            e();
        }
    }

    public final void e() {
        this.f41914b.f();
    }

    public void f(Context context) {
        if (this.f41915c) {
            if (context == null && (context = d.a.l0.a.c1.a.b()) == null) {
                return;
            }
            this.f41915c = false;
            try {
                context.unregisterReceiver(this.f41913a);
            } catch (IllegalArgumentException e2) {
                if (f41912e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g() {
        this.f41914b.h();
    }

    public void h(b bVar) {
        this.f41914b.j(bVar);
    }

    public void i() {
        if (f41912e) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.f41916d.onPause();
        this.f41914b.k();
    }

    public void j() {
        if (f41912e) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.f41916d.onResume();
        this.f41914b.l();
    }
}
