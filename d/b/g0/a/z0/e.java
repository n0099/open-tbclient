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
/* loaded from: classes2.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47159e = k.f45051a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47162c;

    /* renamed from: a  reason: collision with root package name */
    public c f47160a = new c(this);

    /* renamed from: b  reason: collision with root package name */
    public a f47161b = new a();

    /* renamed from: d  reason: collision with root package name */
    public final d.b.g0.a.z0.j.a f47163d = d.b.g0.a.z0.j.c.f();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f47164a;

        /* renamed from: b  reason: collision with root package name */
        public Timer f47165b;

        /* renamed from: c  reason: collision with root package name */
        public long f47166c = 300;

        /* renamed from: d  reason: collision with root package name */
        public int f47167d = 0;

        /* renamed from: d.b.g0.a.z0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0892a extends TimerTask {
            public C0892a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (e.f47159e) {
                    Log.d("SwanAppCollectionPolicy", "task run: " + a.this.f47166c);
                }
                a.this.f47166c -= 10;
                if (a.this.f47166c > 0 || a.this.f47164a == null) {
                    return;
                }
                a.this.f47164a.n(1);
                a.this.l();
            }
        }

        public final synchronized void d() {
            if (this.f47165b != null) {
                this.f47165b.cancel();
                this.f47165b.purge();
                this.f47165b = null;
            }
        }

        public final TimerTask e() {
            return new C0892a();
        }

        public void f() {
            if (this.f47167d == 2) {
                return;
            }
            this.f47167d = 4;
            d();
        }

        public final void g() {
            this.f47166c = d.b.g0.a.j1.m.d.a();
            if (e.f47159e && d.b.g0.a.m1.a.a.r().getBoolean("swan_5min_back_optimize", false)) {
                this.f47166c = 30L;
            }
        }

        public void h() {
            if (this.f47167d != 4) {
                return;
            }
            this.f47167d = 3;
            d();
            i();
        }

        public final void i() {
            Timer timer = new Timer();
            this.f47165b = timer;
            timer.schedule(e(), 0L, 10000L);
        }

        public void j(b bVar) {
            this.f47164a = bVar;
        }

        public void k() {
            this.f47167d = 1;
            g();
            d();
            i();
        }

        public void l() {
            this.f47167d = 2;
            d();
            g();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void n(int i);
    }

    /* loaded from: classes2.dex */
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
        if (this.f47162c) {
            return;
        }
        this.f47162c = true;
        context.registerReceiver(this.f47160a, c.getIntentFilter());
    }

    public final void d(boolean z) {
        if (f47159e) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            g();
        } else {
            e();
        }
    }

    public final void e() {
        this.f47161b.f();
    }

    public void f(Context context) {
        if (this.f47162c) {
            this.f47162c = false;
            try {
                context.unregisterReceiver(this.f47160a);
            } catch (IllegalArgumentException e2) {
                if (f47159e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g() {
        this.f47161b.h();
    }

    public void h(b bVar) {
        this.f47161b.j(bVar);
    }

    public void i() {
        if (f47159e) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.f47163d.onPause();
        this.f47161b.k();
    }

    public void j() {
        if (f47159e) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.f47163d.onResume();
        this.f47161b.l();
    }
}
