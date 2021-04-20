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
    public HandlerThread f48280a;

    /* renamed from: b  reason: collision with root package name */
    public e f48281b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.g.b.b f48282c;

    /* renamed from: d  reason: collision with root package name */
    public long f48283d;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.b.c f48286g;

    /* renamed from: e  reason: collision with root package name */
    public int f48284e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f48285f = 300000;

    /* renamed from: h  reason: collision with root package name */
    public e.c f48287h = new C0963d();

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.b.g0.g.b.a.d
        public void onFail(String str) {
            if (k.f45443a) {
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
        public final /* synthetic */ String f48289a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f48290b;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public a() {
            }

            @Override // d.b.g0.g.b.e.c
            public void onFail(String str) {
                b.this.f48290b.onFail(str);
            }

            @Override // d.b.g0.g.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                f fVar = (f) obj;
                if (k.f45443a) {
                    Log.d("AntiAddictionManager", fVar.toString());
                }
                int i = fVar.f48298a;
                if (i == 0) {
                    b.this.f48290b.onSuccess();
                } else if (1 == i) {
                    b.this.f48290b.onFail(fVar.f48299b);
                } else {
                    b.this.f48290b.onFail(fVar.f48299b);
                    if (TextUtils.isEmpty(fVar.f48299b) || (o = d.this.o()) == null) {
                        return;
                    }
                    d.this.f48286g.f(o, fVar.f48299b, o.getString(h.swan_game_anti_addiction_dialog_ok), true, null);
                }
            }
        }

        public b(String str, a.d dVar) {
            this.f48289a = str;
            this.f48290b = dVar;
        }

        @Override // d.b.g0.g.b.a.d
        public void onFail(String str) {
            this.f48290b.onFail(str);
        }

        @Override // d.b.g0.g.b.a.d
        public void onSuccess() {
            d.b.g0.g.b.e.c(this.f48289a, new a());
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
    public class C0963d implements e.c {
        public C0963d() {
        }

        @Override // d.b.g0.g.b.e.c
        public void onFail(String str) {
            if (k.f45443a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.b.g0.g.b.e.c
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (k.f45443a) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.f48283d = System.currentTimeMillis();
            if (d.this.t(gVar.f48302c)) {
                d.this.s(gVar.f48303d * 1000);
                d.this.q(gVar.f48300a, gVar.f48301b);
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
            if (1 == d.this.f48284e) {
                return;
            }
            sendEmptyMessageDelayed(1, d.this.f48285f);
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
        this.f48286g = new d.b.g0.g.b.c();
    }

    public final void l() {
        if (this.f48280a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f48280a = handlerThread;
            handlerThread.start();
            this.f48281b = new e(this.f48280a.getLooper());
        }
    }

    public final synchronized void m() {
        this.f48281b.a();
        if (this.f48280a != null) {
            this.f48280a.quitSafely();
            this.f48280a = null;
        }
        if (this.f48286g != null) {
            this.f48286g.e();
            this.f48286g = null;
        }
    }

    public synchronized void n() {
        if (u()) {
            z(false);
        }
        this.f48281b.a();
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
            if (k.f45443a) {
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
            this.f48286g.f(o, o.getString(h.swan_game_anti_addiction_dialog_message), o.getString(h.swan_game_anti_addiction_dialog_auth), true, new c());
        }
    }

    public void r() {
        d.b.g0.g.b.a.c(new a());
    }

    public final void s(long j) {
        if (300000 < j) {
            this.f48285f = j;
        } else {
            this.f48285f = 300000L;
        }
    }

    public final boolean t(int i2) {
        this.f48284e = i2;
        if (1 == i2) {
            n();
            return false;
        }
        return true;
    }

    public final boolean u() {
        return this.f48284e == 0;
    }

    public final void v(int i2, String str) {
        d.b.g0.g.b.b bVar = this.f48282c;
        if (bVar != null) {
            try {
                bVar.A(i2, str);
            } catch (JSONException e2) {
                if (k.f45443a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void x(d.b.g0.g.b.b bVar) {
        this.f48282c = bVar;
    }

    public synchronized void y() {
        if (u() && !this.f48281b.b()) {
            this.f48283d = System.currentTimeMillis();
            this.f48281b.c();
        }
    }

    public final void z(boolean z) {
        long j;
        if (z) {
            j = 0;
        } else {
            j = System.currentTimeMillis() - this.f48283d;
            if (180000 > j) {
                return;
            }
        }
        if (k.f45443a) {
            Log.d("AntiAddictionManager", "Request upUseTime");
        }
        d.b.g0.g.b.e.d(j, this.f48287h);
    }
}
