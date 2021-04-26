package d.a.h0.g.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.h;
import d.a.h0.a.k;
import d.a.h0.g.b.a;
import d.a.h0.g.b.e;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f46072i;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f46073a;

    /* renamed from: b  reason: collision with root package name */
    public e f46074b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.g.b.b f46075c;

    /* renamed from: d  reason: collision with root package name */
    public long f46076d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.g.b.c f46079g;

    /* renamed from: e  reason: collision with root package name */
    public int f46077e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f46078f = 300000;

    /* renamed from: h  reason: collision with root package name */
    public e.c f46080h = new C0922d();

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.h0.g.b.a.d
        public void onFail(String str) {
            if (k.f43101a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // d.a.h0.g.b.a.d
        public void onSuccess() {
            Activity o = d.this.o();
            if (o == null) {
                return;
            }
            d.a.h0.a.q1.b.f.d.e(o, h.swan_game_anti_addiction_success).C();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46082a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f46083b;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public a() {
            }

            @Override // d.a.h0.g.b.e.c
            public void onFail(String str) {
                b.this.f46083b.onFail(str);
            }

            @Override // d.a.h0.g.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                f fVar = (f) obj;
                if (k.f43101a) {
                    Log.d("AntiAddictionManager", fVar.toString());
                }
                int i2 = fVar.f46091a;
                if (i2 == 0) {
                    b.this.f46083b.onSuccess();
                } else if (1 == i2) {
                    b.this.f46083b.onFail(fVar.f46092b);
                } else {
                    b.this.f46083b.onFail(fVar.f46092b);
                    if (TextUtils.isEmpty(fVar.f46092b) || (o = d.this.o()) == null) {
                        return;
                    }
                    d.this.f46079g.f(o, fVar.f46092b, o.getString(h.swan_game_anti_addiction_dialog_ok), true, null);
                }
            }
        }

        public b(String str, a.d dVar) {
            this.f46082a = str;
            this.f46083b = dVar;
        }

        @Override // d.a.h0.g.b.a.d
        public void onFail(String str) {
            this.f46083b.onFail(str);
        }

        @Override // d.a.h0.g.b.a.d
        public void onSuccess() {
            d.a.h0.g.b.e.c(this.f46082a, new a());
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

    /* renamed from: d.a.h0.g.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0922d implements e.c {
        public C0922d() {
        }

        @Override // d.a.h0.g.b.e.c
        public void onFail(String str) {
            if (k.f43101a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.a.h0.g.b.e.c
        public void onSuccess(Object obj) {
            g gVar = (g) obj;
            if (k.f43101a) {
                Log.d("AntiAddictionManager", gVar.toString());
            }
            d.this.f46076d = System.currentTimeMillis();
            if (d.this.t(gVar.f46095c)) {
                d.this.s(gVar.f46096d * 1000);
                d.this.q(gVar.f46093a, gVar.f46094b);
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
            if (1 == d.this.f46077e) {
                return;
            }
            sendEmptyMessageDelayed(1, d.this.f46078f);
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
        if (f46072i == null) {
            synchronized (d.class) {
                if (f46072i == null) {
                    f46072i = new d();
                }
            }
        }
        return f46072i;
    }

    public static synchronized void w() {
        synchronized (d.class) {
            if (f46072i != null) {
                f46072i.m();
                f46072i = null;
            }
        }
    }

    public void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str)) {
            dVar.onFail("orderInfo is null");
        } else if (!u()) {
            dVar.onSuccess();
        } else {
            d.a.h0.g.b.a.b(new b(str, dVar));
        }
    }

    public final void k() {
        l();
        z(true);
        y();
        this.f46079g = new d.a.h0.g.b.c();
    }

    public final void l() {
        if (this.f46073a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f46073a = handlerThread;
            handlerThread.start();
            this.f46074b = new e(this.f46073a.getLooper());
        }
    }

    public final synchronized void m() {
        this.f46074b.a();
        if (this.f46073a != null) {
            this.f46073a.quitSafely();
            this.f46073a = null;
        }
        if (this.f46079g != null) {
            this.f46079g.e();
            this.f46079g = null;
        }
    }

    public synchronized void n() {
        if (u()) {
            z(false);
        }
        this.f46074b.a();
    }

    public final Activity o() {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null || O.v() == null) {
            return null;
        }
        return O.v();
    }

    public final void q(int i2, String str) {
        if (i2 < 0) {
            if (k.f43101a) {
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
            this.f46079g.f(o, o.getString(h.swan_game_anti_addiction_dialog_message), o.getString(h.swan_game_anti_addiction_dialog_auth), true, new c());
        }
    }

    public void r() {
        d.a.h0.g.b.a.c(new a());
    }

    public final void s(long j) {
        if (300000 < j) {
            this.f46078f = j;
        } else {
            this.f46078f = 300000L;
        }
    }

    public final boolean t(int i2) {
        this.f46077e = i2;
        if (1 == i2) {
            n();
            return false;
        }
        return true;
    }

    public final boolean u() {
        return this.f46077e == 0;
    }

    public final void v(int i2, String str) {
        d.a.h0.g.b.b bVar = this.f46075c;
        if (bVar != null) {
            try {
                bVar.A(i2, str);
            } catch (JSONException e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void x(d.a.h0.g.b.b bVar) {
        this.f46075c = bVar;
    }

    public synchronized void y() {
        if (u() && !this.f46074b.b()) {
            this.f46076d = System.currentTimeMillis();
            this.f46074b.c();
        }
    }

    public final void z(boolean z) {
        long j;
        if (z) {
            j = 0;
        } else {
            j = System.currentTimeMillis() - this.f46076d;
            if (180000 > j) {
                return;
            }
        }
        if (k.f43101a) {
            Log.d("AntiAddictionManager", "Request upUseTime");
        }
        d.a.h0.g.b.e.d(j, this.f46080h);
    }
}
