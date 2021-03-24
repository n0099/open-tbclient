package d.b.g0.a.z0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47158e = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47161c;

    /* renamed from: a  reason: collision with root package name */
    public c f47159a = new c(this);

    /* renamed from: b  reason: collision with root package name */
    public a f47160b = new a();

    /* renamed from: d  reason: collision with root package name */
    public final d.b.g0.a.z0.j.a f47162d = d.b.g0.a.z0.j.c.f();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f47163a;

        /* renamed from: b  reason: collision with root package name */
        public Timer f47164b;

        /* renamed from: c  reason: collision with root package name */
        public long f47165c = 300;

        /* renamed from: d  reason: collision with root package name */
        public int f47166d = 0;

        /* renamed from: d.b.g0.a.z0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0891a extends TimerTask {
            public C0891a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (e.f47158e) {
                    Log.d("SwanAppCollectionPolicy", "task run: " + a.this.f47165c);
                }
                a.this.f47165c -= 10;
                if (a.this.f47165c > 0 || a.this.f47163a == null) {
                    return;
                }
                a.this.f47163a.n(1);
                a.this.l();
            }
        }

        public final synchronized void d() {
            if (this.f47164b != null) {
                this.f47164b.cancel();
                this.f47164b.purge();
                this.f47164b = null;
            }
        }

        public final TimerTask e() {
            return new C0891a();
        }

        public void f() {
            if (this.f47166d == 2) {
                return;
            }
            this.f47166d = 4;
            d();
        }

        public final void g() {
            this.f47165c = d.b.g0.a.j1.m.d.a();
            if (e.f47158e && d.b.g0.a.m1.a.a.r().getBoolean("swan_5min_back_optimize", false)) {
                this.f47165c = 30L;
            }
        }

        public void h() {
            if (this.f47166d != 4) {
                return;
            }
            this.f47166d = 3;
            d();
            i();
        }

        public final void i() {
            Timer timer = new Timer();
            this.f47164b = timer;
            timer.schedule(e(), 0L, 10000L);
        }

        public void j(b bVar) {
            this.f47163a = bVar;
        }

        public void k() {
            this.f47166d = 1;
            g();
            d();
            i();
        }

        public void l() {
            this.f47166d = 2;
            d();
            g();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void n(int i);
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
        if (this.f47161c) {
            return;
        }
        this.f47161c = true;
        context.registerReceiver(this.f47159a, c.getIntentFilter());
    }

    public final void d(boolean z) {
        if (f47158e) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            g();
        } else {
            e();
        }
    }

    public final void e() {
        this.f47160b.f();
    }

    public void f(Context context) {
        if (this.f47161c) {
            this.f47161c = false;
            try {
                context.unregisterReceiver(this.f47159a);
            } catch (IllegalArgumentException e2) {
                if (f47158e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g() {
        this.f47160b.h();
    }

    public void h(b bVar) {
        this.f47160b.j(bVar);
    }

    public void i() {
        if (f47158e) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.f47162d.onPause();
        this.f47160b.k();
    }

    public void j() {
        if (f47158e) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.f47162d.onResume();
        this.f47160b.l();
    }
}
