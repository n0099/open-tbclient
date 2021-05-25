package d.a.l0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.h.b.a;
import d.a.l0.h.b.e;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f47131i;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f47132a;

    /* renamed from: b  reason: collision with root package name */
    public e f47133b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.h.b.b f47134c;

    /* renamed from: d  reason: collision with root package name */
    public long f47135d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.h.b.c f47138g;

    /* renamed from: e  reason: collision with root package name */
    public int f47136e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f47137f = 300000;

    /* renamed from: h  reason: collision with root package name */
    public e.c f47139h = new C1010d();

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.l0.h.b.a.d
        public void a(String str) {
            if (k.f43199a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // d.a.l0.h.b.a.d
        public void onSuccess() {
            Activity o = d.this.o();
            if (o == null) {
                return;
            }
            d.a.l0.a.z1.b.f.e.f(o, d.a.l0.f.g.aiapps_anti_addiction_success).F();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47141a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f47142b;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public a() {
            }

            @Override // d.a.l0.h.b.e.c
            public void a(String str) {
                b.this.f47142b.a(str);
            }

            @Override // d.a.l0.h.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                f fVar = (f) obj;
                if (k.f43199a) {
                    Log.d("AntiAddictionManager", fVar.toString());
                }
                int i2 = fVar.f47150a;
                if (i2 == 0) {
                    b.this.f47142b.onSuccess();
                } else if (1 == i2) {
                    b.this.f47142b.a(fVar.f47151b);
                } else {
                    b.this.f47142b.a(fVar.f47151b);
                    if (TextUtils.isEmpty(fVar.f47151b) || (o = d.this.o()) == null) {
                        return;
                    }
                    d.this.f47138g.f(o, fVar.f47151b, o.getString(d.a.l0.f.g.aiapps_anti_addiction_dialog_ok), true, null);
                }
            }
        }

        public b(String str, a.d dVar) {
            this.f47141a = str;
            this.f47142b = dVar;
        }

        @Override // d.a.l0.h.b.a.d
        public void a(String str) {
            this.f47142b.a(str);
        }

        @Override // d.a.l0.h.b.a.d
        public void onSuccess() {
            d.a.l0.h.b.e.c(this.f47141a, new a());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.this.r();
        }
    }

    /* renamed from: d.a.l0.h.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1010d implements e.c {
        public C1010d() {
        }

        @Override // d.a.l0.h.b.e.c
        public void a(String str) {
            if (k.f43199a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.a.l0.h.b.e.c
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (k.f43199a) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.f47135d = System.currentTimeMillis();
            if (d.this.t(gVar.f47154c)) {
                d.this.s(gVar.f47155d * 1000);
                d.this.q(gVar.f47152a, gVar.f47153b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        public void a() {
            removeCallbacksAndMessages(null);
        }

        public boolean b() {
            return hasMessages(1);
        }

        public void c() {
            if (1 == d.this.f47136e) {
                return;
            }
            sendEmptyMessageDelayed(1, d.this.f47137f);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            d.this.z(false);
            c();
        }
    }

    public d() {
        k();
    }

    public static d p() {
        if (f47131i == null) {
            synchronized (d.class) {
                if (f47131i == null) {
                    f47131i = new d();
                }
            }
        }
        return f47131i;
    }

    public static synchronized void w() {
        synchronized (d.class) {
            if (f47131i != null) {
                f47131i.m();
                f47131i = null;
            }
        }
    }

    public void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str)) {
            dVar.a("orderInfo is null");
        } else if (!u()) {
            dVar.onSuccess();
        } else {
            d.a.l0.h.b.a.b(new b(str, dVar));
        }
    }

    public final void k() {
        l();
        z(true);
        y();
        this.f47138g = new d.a.l0.h.b.c();
    }

    public final void l() {
        if (this.f47132a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f47132a = handlerThread;
            handlerThread.start();
            this.f47133b = new e(this.f47132a.getLooper());
        }
    }

    public final synchronized void m() {
        this.f47133b.a();
        if (this.f47132a != null) {
            this.f47132a.quitSafely();
            this.f47132a = null;
        }
        if (this.f47138g != null) {
            this.f47138g.e();
            this.f47138g = null;
        }
    }

    public synchronized void n() {
        if (u()) {
            z(false);
        }
        this.f47133b.a();
    }

    public final Activity o() {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null || Q.x() == null) {
            return null;
        }
        return Q.x();
    }

    public final void q(int i2, String str) {
        if (i2 < 0) {
            if (k.f43199a) {
                Log.e("AntiAddictionManager", "server AntiAddiction state error = " + i2 + " msg = " + str);
            }
        } else if (i2 != 0) {
            if (i2 != 1) {
                v(i2, str);
                return;
            }
            Activity o = o();
            if (o == null) {
                return;
            }
            this.f47138g.f(o, o.getString(d.a.l0.f.g.aiapps_anti_addiction_dialog_message), o.getString(d.a.l0.f.g.aiapps_anti_addiction_dialog_auth), true, new c());
        }
    }

    public void r() {
        d.a.l0.h.b.a.c(new a());
    }

    public final void s(long j) {
        if (300000 < j) {
            this.f47137f = j;
        } else {
            this.f47137f = 300000L;
        }
    }

    public final boolean t(int i2) {
        this.f47136e = i2;
        if (1 == i2) {
            n();
            return false;
        }
        return true;
    }

    public final boolean u() {
        return this.f47136e == 0;
    }

    public final void v(int i2, String str) {
        d.a.l0.h.b.b bVar = this.f47134c;
        if (bVar != null) {
            try {
                bVar.z(i2, str);
            } catch (JSONException e2) {
                if (k.f43199a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void x(d.a.l0.h.b.b bVar) {
        this.f47134c = bVar;
    }

    public synchronized void y() {
        if (u() && !this.f47133b.b()) {
            this.f47135d = System.currentTimeMillis();
            this.f47133b.c();
        }
    }

    public final void z(boolean z) {
        long j;
        if (z) {
            j = 0;
        } else {
            j = System.currentTimeMillis() - this.f47135d;
            if (180000 > j) {
                return;
            }
        }
        if (k.f43199a) {
            Log.d("AntiAddictionManager", "Request upUseTime");
        }
        d.a.l0.h.b.e.d(j, this.f47139h);
    }
}
