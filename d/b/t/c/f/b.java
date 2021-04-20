package d.b.t.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.b.t.b.g.c;
import d.b.t.c.g.d;
import d.b.t.c.g.e;
import d.b.t.c.g.g;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final String f65453h = "b";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f65454a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f65455b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.t.b.a f65456c;

    /* renamed from: d  reason: collision with root package name */
    public g f65457d;

    /* renamed from: e  reason: collision with root package name */
    public e f65458e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f65459f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65460g = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<c> f65461a;

        /* renamed from: b  reason: collision with root package name */
        public d f65462b;

        public a(b bVar, ArrayList<c> arrayList, d dVar) {
            this.f65461a = arrayList;
            this.f65462b = dVar;
        }
    }

    /* renamed from: d.b.t.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1787b extends Handler {
        public HandlerC1787b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.n(aVar.f65461a, aVar.f65462b);
                    return;
                case 1002:
                    b.this.o();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.q((d.b.t.b.e.c) message.obj);
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
        if (this.f65455b == null || !this.f65459f) {
            return;
        }
        Handler handler = this.f65455b;
        handler.sendMessage(handler.obtainMessage(1005, i, i2));
        synchronized (this.f65456c) {
            try {
                if (this.f65460g) {
                    this.f65456c.wait(12L);
                } else {
                    this.f65456c.wait(2L);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public long j() {
        g gVar = this.f65457d;
        if (gVar != null) {
            return gVar.d();
        }
        return 0L;
    }

    public final void k(long j) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65457d) == null) {
            return;
        }
        gVar.c(false);
        this.f65456c.a(j);
    }

    public final void l() {
        Handler handler = this.f65455b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f65455b = null;
        }
        HandlerThread handlerThread = this.f65454a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f65454a = null;
        }
    }

    public final void m() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65457d) == null) {
            return;
        }
        gVar.i();
        this.f65457d.e();
        this.f65457d = null;
        this.f65458e = null;
        this.f65456c.c();
        this.f65456c = null;
    }

    public final void n(ArrayList<c> arrayList, d dVar) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65457d) == null) {
            return;
        }
        gVar.l(dVar, this.f65458e);
        if (this.f65456c == null) {
            this.f65456c = new d.b.t.b.a(this.f65457d.k(), arrayList);
        }
    }

    public final void o() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65457d) == null) {
            return;
        }
        gVar.h();
    }

    public final void p() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65457d) == null) {
            return;
        }
        gVar.c(true);
    }

    public final void q(d.b.t.b.e.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65456c.d(cVar);
        }
    }

    public final void r(ArrayList<c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65456c.e(arrayList);
        }
    }

    public final void s(e eVar, d.b.t.c.g.c cVar) {
        HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
        this.f65454a = handlerThread;
        handlerThread.start();
        this.f65455b = new HandlerC1787b(this.f65454a.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.f65457d = new g();
            } catch (VerifyError unused) {
                Log.e(f65453h, "initRecorder videorecorder verifyError");
                if (this.f65457d == null) {
                    return;
                }
            }
            this.f65457d.f(cVar);
            this.f65458e = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.f65460g = true;
        } else {
            this.f65460g = false;
        }
    }

    public boolean t() {
        HandlerThread handlerThread = this.f65454a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void u() {
        if (this.f65455b == null || !this.f65459f) {
            return;
        }
        this.f65455b.removeMessages(1005);
    }

    public void v() {
        Handler handler = this.f65455b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f65455b;
            handler2.sendMessage(handler2.obtainMessage(1007));
            Handler handler3 = this.f65455b;
            handler3.sendMessage(handler3.obtainMessage(1008));
        }
    }

    public boolean w(ArrayList<c> arrayList, d dVar, e eVar, d.b.t.c.g.c cVar) {
        if (t()) {
            Log.e(f65453h, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        s(eVar, cVar);
        a aVar = new a(this, arrayList, dVar);
        Handler handler = this.f65455b;
        handler.sendMessage(handler.obtainMessage(1001, aVar));
        this.f65459f = true;
        return true;
    }

    public void x() {
        Handler handler = this.f65455b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void y() {
        if (this.f65455b == null || !this.f65459f) {
            return;
        }
        this.f65459f = false;
        this.f65455b.removeMessages(1005);
        Handler handler = this.f65455b;
        handler.sendMessage(handler.obtainMessage(1006));
    }

    public void z(ArrayList<c> arrayList) {
        Handler handler = this.f65455b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1003, arrayList));
        }
    }
}
