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
    public static volatile d f50805i;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f50806a;

    /* renamed from: b  reason: collision with root package name */
    public e f50807b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.h.b.b f50808c;

    /* renamed from: d  reason: collision with root package name */
    public long f50809d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.h.b.c f50812g;

    /* renamed from: e  reason: collision with root package name */
    public int f50810e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f50811f = 300000;

    /* renamed from: h  reason: collision with root package name */
    public e.c f50813h = new C1066d();

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.l0.h.b.a.d
        public void onFail(String str) {
            if (k.f46875a) {
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
        public final /* synthetic */ String f50815a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f50816b;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public a() {
            }

            @Override // d.a.l0.h.b.e.c
            public void onFail(String str) {
                b.this.f50816b.onFail(str);
            }

            @Override // d.a.l0.h.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                f fVar = (f) obj;
                if (k.f46875a) {
                    Log.d("AntiAddictionManager", fVar.toString());
                }
                int i2 = fVar.f50824a;
                if (i2 == 0) {
                    b.this.f50816b.onSuccess();
                } else if (1 == i2) {
                    b.this.f50816b.onFail(fVar.f50825b);
                } else {
                    b.this.f50816b.onFail(fVar.f50825b);
                    if (TextUtils.isEmpty(fVar.f50825b) || (o = d.this.o()) == null) {
                        return;
                    }
                    d.this.f50812g.f(o, fVar.f50825b, o.getString(d.a.l0.f.g.aiapps_anti_addiction_dialog_ok), true, null);
                }
            }
        }

        public b(String str, a.d dVar) {
            this.f50815a = str;
            this.f50816b = dVar;
        }

        @Override // d.a.l0.h.b.a.d
        public void onFail(String str) {
            this.f50816b.onFail(str);
        }

        @Override // d.a.l0.h.b.a.d
        public void onSuccess() {
            d.a.l0.h.b.e.c(this.f50815a, new a());
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
    public class C1066d implements e.c {
        public C1066d() {
        }

        @Override // d.a.l0.h.b.e.c
        public void onFail(String str) {
            if (k.f46875a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.a.l0.h.b.e.c
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (k.f46875a) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.f50809d = System.currentTimeMillis();
            if (d.this.t(gVar.f50828c)) {
                d.this.s(gVar.f50829d * 1000);
                d.this.q(gVar.f50826a, gVar.f50827b);
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
            if (1 == d.this.f50810e) {
                return;
            }
            sendEmptyMessageDelayed(1, d.this.f50811f);
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
        if (f50805i == null) {
            synchronized (d.class) {
                if (f50805i == null) {
                    f50805i = new d();
                }
            }
        }
        return f50805i;
    }

    public static synchronized void w() {
        synchronized (d.class) {
            if (f50805i != null) {
                f50805i.m();
                f50805i = null;
            }
        }
    }

    public void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str)) {
            dVar.onFail("orderInfo is null");
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
        this.f50812g = new d.a.l0.h.b.c();
    }

    public final void l() {
        if (this.f50806a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f50806a = handlerThread;
            handlerThread.start();
            this.f50807b = new e(this.f50806a.getLooper());
        }
    }

    public final synchronized void m() {
        this.f50807b.a();
        if (this.f50806a != null) {
            this.f50806a.quitSafely();
            this.f50806a = null;
        }
        if (this.f50812g != null) {
            this.f50812g.e();
            this.f50812g = null;
        }
    }

    public synchronized void n() {
        if (u()) {
            z(false);
        }
        this.f50807b.a();
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
            if (k.f46875a) {
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
            this.f50812g.f(o, o.getString(d.a.l0.f.g.aiapps_anti_addiction_dialog_message), o.getString(d.a.l0.f.g.aiapps_anti_addiction_dialog_auth), true, new c());
        }
    }

    public void r() {
        d.a.l0.h.b.a.c(new a());
    }

    public final void s(long j) {
        if (300000 < j) {
            this.f50811f = j;
        } else {
            this.f50811f = 300000L;
        }
    }

    public final boolean t(int i2) {
        this.f50810e = i2;
        if (1 == i2) {
            n();
            return false;
        }
        return true;
    }

    public final boolean u() {
        return this.f50810e == 0;
    }

    public final void v(int i2, String str) {
        d.a.l0.h.b.b bVar = this.f50808c;
        if (bVar != null) {
            try {
                bVar.z(i2, str);
            } catch (JSONException e2) {
                if (k.f46875a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void x(d.a.l0.h.b.b bVar) {
        this.f50808c = bVar;
    }

    public synchronized void y() {
        if (u() && !this.f50807b.b()) {
            this.f50809d = System.currentTimeMillis();
            this.f50807b.c();
        }
    }

    public final void z(boolean z) {
        long j;
        if (z) {
            j = 0;
        } else {
            j = System.currentTimeMillis() - this.f50809d;
            if (180000 > j) {
                return;
            }
        }
        if (k.f46875a) {
            Log.d("AntiAddictionManager", "Request upUseTime");
        }
        d.a.l0.h.b.e.d(j, this.f50813h);
    }
}
