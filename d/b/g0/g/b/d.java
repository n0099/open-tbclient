package d.b.g0.g.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.h;
import d.b.g0.a.k;
import d.b.g0.g.b.a;
import d.b.g0.g.b.e;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class d {
    public static volatile d i;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f47887a;

    /* renamed from: b  reason: collision with root package name */
    public e f47888b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.g.b.b f47889c;

    /* renamed from: d  reason: collision with root package name */
    public long f47890d;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.b.c f47893g;

    /* renamed from: e  reason: collision with root package name */
    public int f47891e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f47892f = 300000;

    /* renamed from: h  reason: collision with root package name */
    public e.c f47894h = new C0950d();

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.b.g0.g.b.a.d
        public void onFail(String str) {
            if (k.f45050a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // d.b.g0.g.b.a.d
        public void onSuccess() {
            Activity o = d.this.o();
            if (o == null) {
                return;
            }
            d.b.g0.a.q1.b.f.d.e(o, h.swan_game_anti_addiction_success).C();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47896a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f47897b;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public a() {
            }

            @Override // d.b.g0.g.b.e.c
            public void onFail(String str) {
                b.this.f47897b.onFail(str);
            }

            @Override // d.b.g0.g.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                f fVar = (f) obj;
                if (k.f45050a) {
                    Log.d("AntiAddictionManager", fVar.toString());
                }
                int i = fVar.f47905a;
                if (i == 0) {
                    b.this.f47897b.onSuccess();
                } else if (1 == i) {
                    b.this.f47897b.onFail(fVar.f47906b);
                } else {
                    b.this.f47897b.onFail(fVar.f47906b);
                    if (TextUtils.isEmpty(fVar.f47906b) || (o = d.this.o()) == null) {
                        return;
                    }
                    d.this.f47893g.f(o, fVar.f47906b, o.getString(h.swan_game_anti_addiction_dialog_ok), true, null);
                }
            }
        }

        public b(String str, a.d dVar) {
            this.f47896a = str;
            this.f47897b = dVar;
        }

        @Override // d.b.g0.g.b.a.d
        public void onFail(String str) {
            this.f47897b.onFail(str);
        }

        @Override // d.b.g0.g.b.a.d
        public void onSuccess() {
            d.b.g0.g.b.e.c(this.f47896a, new a());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            d.this.r();
        }
    }

    /* renamed from: d.b.g0.g.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0950d implements e.c {
        public C0950d() {
        }

        @Override // d.b.g0.g.b.e.c
        public void onFail(String str) {
            if (k.f45050a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.b.g0.g.b.e.c
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (k.f45050a) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.f47890d = System.currentTimeMillis();
            if (d.this.t(gVar.f47909c)) {
                d.this.s(gVar.f47910d * 1000);
                d.this.q(gVar.f47907a, gVar.f47908b);
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
            if (1 == d.this.f47891e) {
                return;
            }
            sendEmptyMessageDelayed(1, d.this.f47892f);
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
        if (i == null) {
            synchronized (d.class) {
                if (i == null) {
                    i = new d();
                }
            }
        }
        return i;
    }

    public static synchronized void w() {
        synchronized (d.class) {
            if (i != null) {
                i.m();
                i = null;
            }
        }
    }

    public void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str)) {
            dVar.onFail("orderInfo is null");
        } else if (!u()) {
            dVar.onSuccess();
        } else {
            d.b.g0.g.b.a.b(new b(str, dVar));
        }
    }

    public final void k() {
        l();
        z(true);
        y();
        this.f47893g = new d.b.g0.g.b.c();
    }

    public final void l() {
        if (this.f47887a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f47887a = handlerThread;
            handlerThread.start();
            this.f47888b = new e(this.f47887a.getLooper());
        }
    }

    public final synchronized void m() {
        this.f47888b.a();
        if (this.f47887a != null) {
            this.f47887a.quitSafely();
            this.f47887a = null;
        }
        if (this.f47893g != null) {
            this.f47893g.e();
            this.f47893g = null;
        }
    }

    public synchronized void n() {
        if (u()) {
            z(false);
        }
        this.f47888b.a();
    }

    public final Activity o() {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null || O.n() == null) {
            return null;
        }
        return O.n();
    }

    public final void q(int i2, String str) {
        if (i2 < 0) {
            if (k.f45050a) {
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
            this.f47893g.f(o, o.getString(h.swan_game_anti_addiction_dialog_message), o.getString(h.swan_game_anti_addiction_dialog_auth), true, new c());
        }
    }

    public void r() {
        d.b.g0.g.b.a.c(new a());
    }

    public final void s(long j) {
        if (300000 < j) {
            this.f47892f = j;
        } else {
            this.f47892f = 300000L;
        }
    }

    public final boolean t(int i2) {
        this.f47891e = i2;
        if (1 == i2) {
            n();
            return false;
        }
        return true;
    }

    public final boolean u() {
        return this.f47891e == 0;
    }

    public final void v(int i2, String str) {
        d.b.g0.g.b.b bVar = this.f47889c;
        if (bVar != null) {
            try {
                bVar.A(i2, str);
            } catch (JSONException e2) {
                if (k.f45050a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void x(d.b.g0.g.b.b bVar) {
        this.f47889c = bVar;
    }

    public synchronized void y() {
        if (u() && !this.f47888b.b()) {
            this.f47890d = System.currentTimeMillis();
            this.f47888b.c();
        }
    }

    public final void z(boolean z) {
        long j;
        if (z) {
            j = 0;
        } else {
            j = System.currentTimeMillis() - this.f47890d;
            if (180000 > j) {
                return;
            }
        }
        if (k.f45050a) {
            Log.d("AntiAddictionManager", "Request upUseTime");
        }
        d.b.g0.g.b.e.d(j, this.f47894h);
    }
}
