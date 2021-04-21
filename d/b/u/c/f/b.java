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
    public static final String f65717h = "b";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f65718a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f65719b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.u.b.a f65720c;

    /* renamed from: d  reason: collision with root package name */
    public g f65721d;

    /* renamed from: e  reason: collision with root package name */
    public e f65722e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f65723f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65724g = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<c> f65725a;

        /* renamed from: b  reason: collision with root package name */
        public d f65726b;

        public a(b bVar, ArrayList<c> arrayList, d dVar) {
            this.f65725a = arrayList;
            this.f65726b = dVar;
        }
    }

    /* renamed from: d.b.u.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1806b extends Handler {
        public HandlerC1806b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.n(aVar.f65725a, aVar.f65726b);
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
        if (this.f65719b == null || !this.f65723f) {
            return;
        }
        Handler handler = this.f65719b;
        handler.sendMessage(handler.obtainMessage(1005, i, i2));
        synchronized (this.f65720c) {
            try {
                if (this.f65724g) {
                    this.f65720c.wait(12L);
                } else {
                    this.f65720c.wait(2L);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public long j() {
        g gVar = this.f65721d;
        if (gVar != null) {
            return gVar.d();
        }
        return 0L;
    }

    public final void k(long j) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65721d) == null) {
            return;
        }
        gVar.c(false);
        this.f65720c.a(j);
    }

    public final void l() {
        Handler handler = this.f65719b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f65719b = null;
        }
        HandlerThread handlerThread = this.f65718a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f65718a = null;
        }
    }

    public final void m() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65721d) == null) {
            return;
        }
        gVar.i();
        this.f65721d.e();
        this.f65721d = null;
        this.f65722e = null;
        this.f65720c.c();
        this.f65720c = null;
    }

    public final void n(ArrayList<c> arrayList, d dVar) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65721d) == null) {
            return;
        }
        gVar.l(dVar, this.f65722e);
        if (this.f65720c == null) {
            this.f65720c = new d.b.u.b.a(this.f65721d.k(), arrayList);
        }
    }

    public final void o() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65721d) == null) {
            return;
        }
        gVar.h();
    }

    public final void p() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f65721d) == null) {
            return;
        }
        gVar.c(true);
    }

    public final void q(d.b.u.b.e.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65720c.d(cVar);
        }
    }

    public final void r(ArrayList<c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65720c.e(arrayList);
        }
    }

    public final void s(e eVar, d.b.u.c.g.c cVar) {
        HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
        this.f65718a = handlerThread;
        handlerThread.start();
        this.f65719b = new HandlerC1806b(this.f65718a.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.f65721d = new g();
            } catch (VerifyError unused) {
                Log.e(f65717h, "initRecorder videorecorder verifyError");
                if (this.f65721d == null) {
                    return;
                }
            }
            this.f65721d.f(cVar);
            this.f65722e = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.f65724g = true;
        } else {
            this.f65724g = false;
        }
    }

    public boolean t() {
        HandlerThread handlerThread = this.f65718a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void u() {
        if (this.f65719b == null || !this.f65723f) {
            return;
        }
        this.f65719b.removeMessages(1005);
    }

    public void v() {
        Handler handler = this.f65719b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f65719b;
            handler2.sendMessage(handler2.obtainMessage(1007));
            Handler handler3 = this.f65719b;
            handler3.sendMessage(handler3.obtainMessage(1008));
        }
    }

    public boolean w(ArrayList<c> arrayList, d dVar, e eVar, d.b.u.c.g.c cVar) {
        if (t()) {
            Log.e(f65717h, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        s(eVar, cVar);
        a aVar = new a(this, arrayList, dVar);
        Handler handler = this.f65719b;
        handler.sendMessage(handler.obtainMessage(1001, aVar));
        this.f65723f = true;
        return true;
    }

    public void x() {
        Handler handler = this.f65719b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void y() {
        if (this.f65719b == null || !this.f65723f) {
            return;
        }
        this.f65723f = false;
        this.f65719b.removeMessages(1005);
        Handler handler = this.f65719b;
        handler.sendMessage(handler.obtainMessage(1006));
    }

    public void z(ArrayList<c> arrayList) {
        Handler handler = this.f65719b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1003, arrayList));
        }
    }
}
