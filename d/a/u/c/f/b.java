package d.a.u.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.a.u.b.g.c;
import d.a.u.c.g.d;
import d.a.u.c.g.e;
import d.a.u.c.g.g;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final String f64069h = "b";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f64070a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64071b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.u.b.a f64072c;

    /* renamed from: d  reason: collision with root package name */
    public g f64073d;

    /* renamed from: e  reason: collision with root package name */
    public e f64074e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f64075f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64076g = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<c> f64077a;

        /* renamed from: b  reason: collision with root package name */
        public d f64078b;

        public a(b bVar, ArrayList<c> arrayList, d dVar) {
            this.f64077a = arrayList;
            this.f64078b = dVar;
        }
    }

    /* renamed from: d.a.u.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1746b extends Handler {
        public HandlerC1746b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.n(aVar.f64077a, aVar.f64078b);
                    return;
                case 1002:
                    b.this.o();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.q((d.a.u.b.e.c) message.obj);
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
        int i2 = (int) (j >> 32);
        int i3 = (int) j;
        if (this.f64071b == null || !this.f64075f) {
            return;
        }
        Handler handler = this.f64071b;
        handler.sendMessage(handler.obtainMessage(1005, i2, i3));
        synchronized (this.f64072c) {
            try {
                if (this.f64076g) {
                    this.f64072c.wait(12L);
                } else {
                    this.f64072c.wait(2L);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public long j() {
        g gVar = this.f64073d;
        if (gVar != null) {
            return gVar.d();
        }
        return 0L;
    }

    public final void k(long j) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64073d) == null) {
            return;
        }
        gVar.c(false);
        this.f64072c.a(j);
    }

    public final void l() {
        Handler handler = this.f64071b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f64071b = null;
        }
        HandlerThread handlerThread = this.f64070a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f64070a = null;
        }
    }

    public final void m() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64073d) == null) {
            return;
        }
        gVar.i();
        this.f64073d.e();
        this.f64073d = null;
        this.f64074e = null;
        this.f64072c.c();
        this.f64072c = null;
    }

    public final void n(ArrayList<c> arrayList, d dVar) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64073d) == null) {
            return;
        }
        gVar.l(dVar, this.f64074e);
        if (this.f64072c == null) {
            this.f64072c = new d.a.u.b.a(this.f64073d.k(), arrayList);
        }
    }

    public final void o() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64073d) == null) {
            return;
        }
        gVar.h();
    }

    public final void p() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f64073d) == null) {
            return;
        }
        gVar.c(true);
    }

    public final void q(d.a.u.b.e.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64072c.d(cVar);
        }
    }

    public final void r(ArrayList<c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64072c.e(arrayList);
        }
    }

    public final void s(e eVar, d.a.u.c.g.c cVar) {
        HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
        this.f64070a = handlerThread;
        handlerThread.start();
        this.f64071b = new HandlerC1746b(this.f64070a.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.f64073d = new g();
            } catch (VerifyError unused) {
                Log.e(f64069h, "initRecorder videorecorder verifyError");
                if (this.f64073d == null) {
                    return;
                }
            }
            this.f64073d.f(cVar);
            this.f64074e = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.f64076g = true;
        } else {
            this.f64076g = false;
        }
    }

    public boolean t() {
        HandlerThread handlerThread = this.f64070a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void u() {
        if (this.f64071b == null || !this.f64075f) {
            return;
        }
        this.f64071b.removeMessages(1005);
    }

    public void v() {
        Handler handler = this.f64071b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f64071b;
            handler2.sendMessage(handler2.obtainMessage(1007));
            Handler handler3 = this.f64071b;
            handler3.sendMessage(handler3.obtainMessage(1008));
        }
    }

    public boolean w(ArrayList<c> arrayList, d dVar, e eVar, d.a.u.c.g.c cVar) {
        if (t()) {
            Log.e(f64069h, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        s(eVar, cVar);
        a aVar = new a(this, arrayList, dVar);
        Handler handler = this.f64071b;
        handler.sendMessage(handler.obtainMessage(1001, aVar));
        this.f64075f = true;
        return true;
    }

    public void x() {
        Handler handler = this.f64071b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void y() {
        if (this.f64071b == null || !this.f64075f) {
            return;
        }
        this.f64075f = false;
        this.f64071b.removeMessages(1005);
        Handler handler = this.f64071b;
        handler.sendMessage(handler.obtainMessage(1006));
    }

    public void z(ArrayList<c> arrayList) {
        Handler handler = this.f64071b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1003, arrayList));
        }
    }
}
