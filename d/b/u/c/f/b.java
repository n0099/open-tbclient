package d.b.u.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.b.u.b.g.c;
import d.b.u.c.g.d;
import d.b.u.c.g.e;
import d.b.u.c.g.g;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final String f64758h = "b";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f64759a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64760b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.u.b.a f64761c;

    /* renamed from: d  reason: collision with root package name */
    public g f64762d;

    /* renamed from: e  reason: collision with root package name */
    public e f64763e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f64764f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64765g = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<c> f64766a;

        /* renamed from: b  reason: collision with root package name */
        public d f64767b;

        public a(b bVar, ArrayList<c> arrayList, d dVar) {
            this.f64766a = arrayList;
            this.f64767b = dVar;
        }
    }

    /* renamed from: d.b.u.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1774b extends Handler {
        public HandlerC1774b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.n(aVar.f64766a, aVar.f64767b);
                    return;
                case 1002:
                    b.this.o();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.q((d.b.u.b.e.c) message.obj);
                    return;
                case 1005:
                    b.this.k((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.p();
                    return;
                case 1007:
                    b.this.m();
                    return;
                case 1008:
                    b.this.l();
                    return;
                default:
                    return;
            }
        }
    }

    public void i(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.f64760b == null || !this.f64764f) {
            return;
        }
        Handler handler = this.f64760b;
        handler.sendMessage(handler.obtainMessage(1005, i, i2));
        synchronized (this.f64761c) {
            try {
                if (this.f64765g) {
                    this.f64761c.wait(12L);
                } else {
                    this.f64761c.wait(2L);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public long j() {
        g gVar = this.f64762d;
        if (gVar != null) {
            return gVar.d();
        }
        return 0L;
    }

    public final void k(long j) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64762d) == null) {
            return;
        }
        gVar.c(false);
        this.f64761c.a(j);
    }

    public final void l() {
        Handler handler = this.f64760b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f64760b = null;
        }
        HandlerThread handlerThread = this.f64759a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f64759a = null;
        }
    }

    public final void m() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64762d) == null) {
            return;
        }
        gVar.i();
        this.f64762d.e();
        this.f64762d = null;
        this.f64763e = null;
        this.f64761c.c();
        this.f64761c = null;
    }

    public final void n(ArrayList<c> arrayList, d dVar) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64762d) == null) {
            return;
        }
        gVar.l(dVar, this.f64763e);
        if (this.f64761c == null) {
            this.f64761c = new d.b.u.b.a(this.f64762d.k(), arrayList);
        }
    }

    public final void o() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64762d) == null) {
            return;
        }
        gVar.h();
    }

    public final void p() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64762d) == null) {
            return;
        }
        gVar.c(true);
    }

    public final void q(d.b.u.b.e.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64761c.d(cVar);
        }
    }

    public final void r(ArrayList<c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64761c.e(arrayList);
        }
    }

    public final void s(e eVar, d.b.u.c.g.c cVar) {
        HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
        this.f64759a = handlerThread;
        handlerThread.start();
        this.f64760b = new HandlerC1774b(this.f64759a.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.f64762d = new g();
            } catch (VerifyError unused) {
                Log.e(f64758h, "initRecorder videorecorder verifyError");
                if (this.f64762d == null) {
                    return;
                }
            }
            this.f64762d.f(cVar);
            this.f64763e = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.f64765g = true;
        } else {
            this.f64765g = false;
        }
    }

    public boolean t() {
        HandlerThread handlerThread = this.f64759a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void u() {
        if (this.f64760b == null || !this.f64764f) {
            return;
        }
        this.f64760b.removeMessages(1005);
    }

    public void v() {
        Handler handler = this.f64760b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f64760b;
            handler2.sendMessage(handler2.obtainMessage(1007));
            Handler handler3 = this.f64760b;
            handler3.sendMessage(handler3.obtainMessage(1008));
        }
    }

    public boolean w(ArrayList<c> arrayList, d dVar, e eVar, d.b.u.c.g.c cVar) {
        if (t()) {
            Log.e(f64758h, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        s(eVar, cVar);
        a aVar = new a(this, arrayList, dVar);
        Handler handler = this.f64760b;
        handler.sendMessage(handler.obtainMessage(1001, aVar));
        this.f64764f = true;
        return true;
    }

    public void x() {
        Handler handler = this.f64760b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void y() {
        if (this.f64760b == null || !this.f64764f) {
            return;
        }
        this.f64764f = false;
        this.f64760b.removeMessages(1005);
        Handler handler = this.f64760b;
        handler.sendMessage(handler.obtainMessage(1006));
    }

    public void z(ArrayList<c> arrayList) {
        Handler handler = this.f64760b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1003, arrayList));
        }
    }
}
