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
    public static final boolean f45588e = k.f46875a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45591c;

    /* renamed from: a  reason: collision with root package name */
    public c f45589a = new c(this);

    /* renamed from: b  reason: collision with root package name */
    public a f45590b = new a();

    /* renamed from: d  reason: collision with root package name */
    public final d.a.l0.a.g1.j.a f45592d = d.a.l0.a.g1.j.c.f();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f45593a;

        /* renamed from: b  reason: collision with root package name */
        public Timer f45594b;

        /* renamed from: c  reason: collision with root package name */
        public long f45595c = 300;

        /* renamed from: d  reason: collision with root package name */
        public int f45596d = 0;

        /* renamed from: d.a.l0.a.g1.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0697a extends TimerTask {
            public C0697a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (e.f45588e) {
                    Log.d("SwanAppCollectionPolicy", "task run: " + a.this.f45595c);
                }
                a.this.f45595c -= 10;
                if (a.this.f45595c > 0 || a.this.f45593a == null) {
                    return;
                }
                a.this.f45593a.g(1);
                a.this.l();
            }
        }

        public final synchronized void d() {
            if (this.f45594b != null) {
                this.f45594b.cancel();
                this.f45594b.purge();
                this.f45594b = null;
            }
        }

        public final TimerTask e() {
            return new C0697a();
        }

        public void f() {
            if (this.f45596d == 2) {
                return;
            }
            this.f45596d = 4;
            d();
        }

        public final void g() {
            this.f45595c = d.a.l0.a.r1.l.c.a();
            if (e.f45588e && d.a.l0.a.u1.a.a.t().getBoolean("swan_5min_back_optimize", false)) {
                this.f45595c = 30L;
            }
        }

        public void h() {
            if (this.f45596d != 4) {
                return;
            }
            this.f45596d = 3;
            d();
            i();
        }

        public final void i() {
            Timer timer = new Timer();
            this.f45594b = timer;
            timer.schedule(e(), 0L, 10000L);
        }

        public void j(b bVar) {
            this.f45593a = bVar;
        }

        public void k() {
            this.f45596d = 1;
            g();
            d();
            i();
        }

        public void l() {
            this.f45596d = 2;
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
        if (this.f45591c) {
            return;
        }
        if (context == null && (context = d.a.l0.a.c1.a.b()) == null) {
            return;
        }
        this.f45591c = true;
        context.registerReceiver(this.f45589a, c.getIntentFilter());
    }

    public final void d(boolean z) {
        if (f45588e) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            g();
        } else {
            e();
        }
    }

    public final void e() {
        this.f45590b.f();
    }

    public void f(Context context) {
        if (this.f45591c) {
            if (context == null && (context = d.a.l0.a.c1.a.b()) == null) {
                return;
            }
            this.f45591c = false;
            try {
                context.unregisterReceiver(this.f45589a);
            } catch (IllegalArgumentException e2) {
                if (f45588e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g() {
        this.f45590b.h();
    }

    public void h(b bVar) {
        this.f45590b.j(bVar);
    }

    public void i() {
        if (f45588e) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.f45592d.onPause();
        this.f45590b.k();
    }

    public void j() {
        if (f45588e) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.f45592d.onResume();
        this.f45590b.l();
    }
}
