package d.a.i0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import d.a.i0.h.b.a;
import d.a.i0.h.b.e;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f46955i;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f46956a;

    /* renamed from: b  reason: collision with root package name */
    public e f46957b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.h.b.b f46958c;

    /* renamed from: d  reason: collision with root package name */
    public long f46959d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.h.b.c f46962g;

    /* renamed from: e  reason: collision with root package name */
    public int f46960e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f46961f = 300000;

    /* renamed from: h  reason: collision with root package name */
    public e.c f46963h = new C0999d();

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.i0.h.b.a.d
        public void a(String str) {
            if (k.f43025a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // d.a.i0.h.b.a.d
        public void onSuccess() {
            Activity o = d.this.o();
            if (o == null) {
                return;
            }
            d.a.i0.a.z1.b.f.e.f(o, d.a.i0.f.g.aiapps_anti_addiction_success).F();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46965a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f46966b;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public a() {
            }

            @Override // d.a.i0.h.b.e.c
            public void a(String str) {
                b.this.f46966b.a(str);
            }

            @Override // d.a.i0.h.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                f fVar = (f) obj;
                if (k.f43025a) {
                    Log.d("AntiAddictionManager", fVar.toString());
                }
                int i2 = fVar.f46974a;
                if (i2 == 0) {
                    b.this.f46966b.onSuccess();
                } else if (1 == i2) {
                    b.this.f46966b.a(fVar.f46975b);
                } else {
                    b.this.f46966b.a(fVar.f46975b);
                    if (TextUtils.isEmpty(fVar.f46975b) || (o = d.this.o()) == null) {
                        return;
                    }
                    d.this.f46962g.f(o, fVar.f46975b, o.getString(d.a.i0.f.g.aiapps_anti_addiction_dialog_ok), true, null);
                }
            }
        }

        public b(String str, a.d dVar) {
            this.f46965a = str;
            this.f46966b = dVar;
        }

        @Override // d.a.i0.h.b.a.d
        public void a(String str) {
            this.f46966b.a(str);
        }

        @Override // d.a.i0.h.b.a.d
        public void onSuccess() {
            d.a.i0.h.b.e.c(this.f46965a, new a());
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

    /* renamed from: d.a.i0.h.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0999d implements e.c {
        public C0999d() {
        }

        @Override // d.a.i0.h.b.e.c
        public void a(String str) {
            if (k.f43025a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.a.i0.h.b.e.c
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (k.f43025a) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.f46959d = System.currentTimeMillis();
            if (d.this.t(gVar.f46978c)) {
                d.this.s(gVar.f46979d * 1000);
                d.this.q(gVar.f46976a, gVar.f46977b);
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
            if (1 == d.this.f46960e) {
                return;
            }
            sendEmptyMessageDelayed(1, d.this.f46961f);
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
        if (f46955i == null) {
            synchronized (d.class) {
                if (f46955i == null) {
                    f46955i = new d();
                }
            }
        }
        return f46955i;
    }

    public static synchronized void w() {
        synchronized (d.class) {
            if (f46955i != null) {
                f46955i.m();
                f46955i = null;
            }
        }
    }

    public void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str)) {
            dVar.a("orderInfo is null");
        } else if (!u()) {
            dVar.onSuccess();
        } else {
            d.a.i0.h.b.a.b(new b(str, dVar));
        }
    }

    public final void k() {
        l();
        z(true);
        y();
        this.f46962g = new d.a.i0.h.b.c();
    }

    public final void l() {
        if (this.f46956a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f46956a = handlerThread;
            handlerThread.start();
            this.f46957b = new e(this.f46956a.getLooper());
        }
    }

    public final synchronized void m() {
        this.f46957b.a();
        if (this.f46956a != null) {
            this.f46956a.quitSafely();
            this.f46956a = null;
        }
        if (this.f46962g != null) {
            this.f46962g.e();
            this.f46962g = null;
        }
    }

    public synchronized void n() {
        if (u()) {
            z(false);
        }
        this.f46957b.a();
    }

    public final Activity o() {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null || Q.x() == null) {
            return null;
        }
        return Q.x();
    }

    public final void q(int i2, String str) {
        if (i2 < 0) {
            if (k.f43025a) {
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
            this.f46962g.f(o, o.getString(d.a.i0.f.g.aiapps_anti_addiction_dialog_message), o.getString(d.a.i0.f.g.aiapps_anti_addiction_dialog_auth), true, new c());
        }
    }

    public void r() {
        d.a.i0.h.b.a.c(new a());
    }

    public final void s(long j) {
        if (300000 < j) {
            this.f46961f = j;
        } else {
            this.f46961f = 300000L;
        }
    }

    public final boolean t(int i2) {
        this.f46960e = i2;
        if (1 == i2) {
            n();
            return false;
        }
        return true;
    }

    public final boolean u() {
        return this.f46960e == 0;
    }

    public final void v(int i2, String str) {
        d.a.i0.h.b.b bVar = this.f46958c;
        if (bVar != null) {
            try {
                bVar.z(i2, str);
            } catch (JSONException e2) {
                if (k.f43025a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void x(d.a.i0.h.b.b bVar) {
        this.f46958c = bVar;
    }

    public synchronized void y() {
        if (u() && !this.f46957b.b()) {
            this.f46959d = System.currentTimeMillis();
            this.f46957b.c();
        }
    }

    public final void z(boolean z) {
        long j;
        if (z) {
            j = 0;
        } else {
            j = System.currentTimeMillis() - this.f46959d;
            if (180000 > j) {
                return;
            }
        }
        if (k.f43025a) {
            Log.d("AntiAddictionManager", "Request upUseTime");
        }
        d.a.i0.h.b.e.d(j, this.f46963h);
    }
}
