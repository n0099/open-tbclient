package d.a.h0.a.z0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45316e = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45319c;

    /* renamed from: a  reason: collision with root package name */
    public c f45317a = new c(this);

    /* renamed from: b  reason: collision with root package name */
    public a f45318b = new a();

    /* renamed from: d  reason: collision with root package name */
    public final d.a.h0.a.z0.j.a f45320d = d.a.h0.a.z0.j.c.f();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f45321a;

        /* renamed from: b  reason: collision with root package name */
        public Timer f45322b;

        /* renamed from: c  reason: collision with root package name */
        public long f45323c = 300;

        /* renamed from: d  reason: collision with root package name */
        public int f45324d = 0;

        /* renamed from: d.a.h0.a.z0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0863a extends TimerTask {
            public C0863a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (e.f45316e) {
                    Log.d("SwanAppCollectionPolicy", "task run: " + a.this.f45323c);
                }
                a.this.f45323c -= 10;
                if (a.this.f45323c > 0 || a.this.f45321a == null) {
                    return;
                }
                a.this.f45321a.i(1);
                a.this.l();
            }
        }

        public final synchronized void d() {
            if (this.f45322b != null) {
                this.f45322b.cancel();
                this.f45322b.purge();
                this.f45322b = null;
            }
        }

        public final TimerTask e() {
            return new C0863a();
        }

        public void f() {
            if (this.f45324d == 2) {
                return;
            }
            this.f45324d = 4;
            d();
        }

        public final void g() {
            this.f45323c = d.a.h0.a.j1.m.d.a();
            if (e.f45316e && d.a.h0.a.m1.a.a.r().getBoolean("swan_5min_back_optimize", false)) {
                this.f45323c = 30L;
            }
        }

        public void h() {
            if (this.f45324d != 4) {
                return;
            }
            this.f45324d = 3;
            d();
            i();
        }

        public final void i() {
            Timer timer = new Timer();
            this.f45322b = timer;
            timer.schedule(e(), 0L, 10000L);
        }

        public void j(b bVar) {
            this.f45321a = bVar;
        }

        public void k() {
            this.f45324d = 1;
            g();
            d();
            i();
        }

        public void l() {
            this.f45324d = 2;
            d();
            g();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void i(int i2);
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
        if (this.f45319c) {
            return;
        }
        this.f45319c = true;
        context.registerReceiver(this.f45317a, c.getIntentFilter());
    }

    public final void d(boolean z) {
        if (f45316e) {
            Log.d("SwanAppCollectionPolicy", "onScreenStatusChanged isOn: " + z);
        }
        if (z) {
            g();
        } else {
            e();
        }
    }

    public final void e() {
        this.f45318b.f();
    }

    public void f(Context context) {
        if (this.f45319c) {
            this.f45319c = false;
            try {
                context.unregisterReceiver(this.f45317a);
            } catch (IllegalArgumentException e2) {
                if (f45316e) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g() {
        this.f45318b.h();
    }

    public void h(b bVar) {
        this.f45318b.j(bVar);
    }

    public void i() {
        if (f45316e) {
            Log.d("SwanAppCollectionPolicy", "startCollectionTimeOut");
        }
        this.f45320d.onPause();
        this.f45318b.k();
    }

    public void j() {
        if (f45316e) {
            Log.d("SwanAppCollectionPolicy", "stopCollectionTimeOut");
        }
        this.f45320d.onResume();
        this.f45318b.l();
    }
}
