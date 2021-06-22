package d.a.m0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
import d.a.m0.h.b.a;
import d.a.m0.h.b.e;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f50913i;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f50914a;

    /* renamed from: b  reason: collision with root package name */
    public e f50915b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.h.b.b f50916c;

    /* renamed from: d  reason: collision with root package name */
    public long f50917d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.h.b.c f50920g;

    /* renamed from: e  reason: collision with root package name */
    public int f50918e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f50919f = 300000;

    /* renamed from: h  reason: collision with root package name */
    public e.c f50921h = new C1069d();

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.m0.h.b.a.d
        public void onFail(String str) {
            if (k.f46983a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // d.a.m0.h.b.a.d
        public void onSuccess() {
            Activity o = d.this.o();
            if (o == null) {
                return;
            }
            d.a.m0.a.z1.b.f.e.f(o, d.a.m0.f.g.aiapps_anti_addiction_success).F();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50923a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f50924b;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public a() {
            }

            @Override // d.a.m0.h.b.e.c
            public void onFail(String str) {
                b.this.f50924b.onFail(str);
            }

            @Override // d.a.m0.h.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                f fVar = (f) obj;
                if (k.f46983a) {
                    Log.d("AntiAddictionManager", fVar.toString());
                }
                int i2 = fVar.f50932a;
                if (i2 == 0) {
                    b.this.f50924b.onSuccess();
                } else if (1 == i2) {
                    b.this.f50924b.onFail(fVar.f50933b);
                } else {
                    b.this.f50924b.onFail(fVar.f50933b);
                    if (TextUtils.isEmpty(fVar.f50933b) || (o = d.this.o()) == null) {
                        return;
                    }
                    d.this.f50920g.f(o, fVar.f50933b, o.getString(d.a.m0.f.g.aiapps_anti_addiction_dialog_ok), true, null);
                }
            }
        }

        public b(String str, a.d dVar) {
            this.f50923a = str;
            this.f50924b = dVar;
        }

        @Override // d.a.m0.h.b.a.d
        public void onFail(String str) {
            this.f50924b.onFail(str);
        }

        @Override // d.a.m0.h.b.a.d
        public void onSuccess() {
            d.a.m0.h.b.e.c(this.f50923a, new a());
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

    /* renamed from: d.a.m0.h.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1069d implements e.c {
        public C1069d() {
        }

        @Override // d.a.m0.h.b.e.c
        public void onFail(String str) {
            if (k.f46983a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.a.m0.h.b.e.c
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (k.f46983a) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.f50917d = System.currentTimeMillis();
            if (d.this.t(gVar.f50936c)) {
                d.this.s(gVar.f50937d * 1000);
                d.this.q(gVar.f50934a, gVar.f50935b);
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
            if (1 == d.this.f50918e) {
                return;
            }
            sendEmptyMessageDelayed(1, d.this.f50919f);
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
        if (f50913i == null) {
            synchronized (d.class) {
                if (f50913i == null) {
                    f50913i = new d();
                }
            }
        }
        return f50913i;
    }

    public static synchronized void w() {
        synchronized (d.class) {
            if (f50913i != null) {
                f50913i.m();
                f50913i = null;
            }
        }
    }

    public void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str)) {
            dVar.onFail("orderInfo is null");
        } else if (!u()) {
            dVar.onSuccess();
        } else {
            d.a.m0.h.b.a.b(new b(str, dVar));
        }
    }

    public final void k() {
        l();
        z(true);
        y();
        this.f50920g = new d.a.m0.h.b.c();
    }

    public final void l() {
        if (this.f50914a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f50914a = handlerThread;
            handlerThread.start();
            this.f50915b = new e(this.f50914a.getLooper());
        }
    }

    public final synchronized void m() {
        this.f50915b.a();
        if (this.f50914a != null) {
            this.f50914a.quitSafely();
            this.f50914a = null;
        }
        if (this.f50920g != null) {
            this.f50920g.e();
            this.f50920g = null;
        }
    }

    public synchronized void n() {
        if (u()) {
            z(false);
        }
        this.f50915b.a();
    }

    public final Activity o() {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null || Q.x() == null) {
            return null;
        }
        return Q.x();
    }

    public final void q(int i2, String str) {
        if (i2 < 0) {
            if (k.f46983a) {
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
            this.f50920g.f(o, o.getString(d.a.m0.f.g.aiapps_anti_addiction_dialog_message), o.getString(d.a.m0.f.g.aiapps_anti_addiction_dialog_auth), true, new c());
        }
    }

    public void r() {
        d.a.m0.h.b.a.c(new a());
    }

    public final void s(long j) {
        if (300000 < j) {
            this.f50919f = j;
        } else {
            this.f50919f = 300000L;
        }
    }

    public final boolean t(int i2) {
        this.f50918e = i2;
        if (1 == i2) {
            n();
            return false;
        }
        return true;
    }

    public final boolean u() {
        return this.f50918e == 0;
    }

    public final void v(int i2, String str) {
        d.a.m0.h.b.b bVar = this.f50916c;
        if (bVar != null) {
            try {
                bVar.z(i2, str);
            } catch (JSONException e2) {
                if (k.f46983a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void x(d.a.m0.h.b.b bVar) {
        this.f50916c = bVar;
    }

    public synchronized void y() {
        if (u() && !this.f50915b.b()) {
            this.f50917d = System.currentTimeMillis();
            this.f50915b.c();
        }
    }

    public final void z(boolean z) {
        long j;
        if (z) {
            j = 0;
        } else {
            j = System.currentTimeMillis() - this.f50917d;
            if (180000 > j) {
                return;
            }
        }
        if (k.f46983a) {
            Log.d("AntiAddictionManager", "Request upUseTime");
        }
        d.a.m0.h.b.e.d(j, this.f50921h);
    }
}
