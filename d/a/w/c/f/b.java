package d.a.w.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.a.w.b.g.c;
import d.a.w.c.g.d;
import d.a.w.c.g.e;
import d.a.w.c.g.g;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final String f68631h = "b";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f68632a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68633b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w.b.a f68634c;

    /* renamed from: d  reason: collision with root package name */
    public g f68635d;

    /* renamed from: e  reason: collision with root package name */
    public e f68636e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f68637f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68638g = false;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<c> f68639a;

        /* renamed from: b  reason: collision with root package name */
        public d f68640b;

        public a(b bVar, ArrayList<c> arrayList, d dVar) {
            this.f68639a = arrayList;
            this.f68640b = dVar;
        }
    }

    /* renamed from: d.a.w.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1878b extends Handler {
        public HandlerC1878b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.n(aVar.f68639a, aVar.f68640b);
                    return;
                case 1002:
                    b.this.o();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.q((d.a.w.b.e.c) message.obj);
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
        if (this.f68633b == null || !this.f68637f) {
            return;
        }
        Handler handler = this.f68633b;
        handler.sendMessage(handler.obtainMessage(1005, i2, i3));
        synchronized (this.f68634c) {
            try {
                if (this.f68638g) {
                    this.f68634c.wait(12L);
                } else {
                    this.f68634c.wait(2L);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public long j() {
        g gVar = this.f68635d;
        if (gVar != null) {
            return gVar.d();
        }
        return 0L;
    }

    public final void k(long j) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f68635d) == null) {
            return;
        }
        gVar.c(false);
        this.f68634c.a(j);
    }

    public final void l() {
        Handler handler = this.f68633b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f68633b = null;
        }
        HandlerThread handlerThread = this.f68632a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f68632a = null;
        }
    }

    public final void m() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f68635d) == null) {
            return;
        }
        gVar.i();
        this.f68635d.e();
        this.f68635d = null;
        this.f68636e = null;
        this.f68634c.c();
        this.f68634c = null;
    }

    public final void n(ArrayList<c> arrayList, d dVar) {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f68635d) == null) {
            return;
        }
        gVar.l(dVar, this.f68636e);
        if (this.f68634c == null) {
            this.f68634c = new d.a.w.b.a(this.f68635d.k(), arrayList);
        }
    }

    public final void o() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f68635d) == null) {
            return;
        }
        gVar.h();
    }

    public final void p() {
        g gVar;
        if (Build.VERSION.SDK_INT < 18 || (gVar = this.f68635d) == null) {
            return;
        }
        gVar.c(true);
    }

    public final void q(d.a.w.b.e.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f68634c.d(cVar);
        }
    }

    public final void r(ArrayList<c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f68634c.e(arrayList);
        }
    }

    public final void s(e eVar, d.a.w.c.g.c cVar) {
        HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
        this.f68632a = handlerThread;
        handlerThread.start();
        this.f68633b = new HandlerC1878b(this.f68632a.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.f68635d = new g();
            } catch (VerifyError unused) {
                Log.e(f68631h, "initRecorder videorecorder verifyError");
                if (this.f68635d == null) {
                    return;
                }
            }
            this.f68635d.f(cVar);
            this.f68636e = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.f68638g = true;
        } else {
            this.f68638g = false;
        }
    }

    public boolean t() {
        HandlerThread handlerThread = this.f68632a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void u() {
        if (this.f68633b == null || !this.f68637f) {
            return;
        }
        this.f68633b.removeMessages(1005);
    }

    public void v() {
        Handler handler = this.f68633b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f68633b;
            handler2.sendMessage(handler2.obtainMessage(1007));
            Handler handler3 = this.f68633b;
            handler3.sendMessage(handler3.obtainMessage(1008));
        }
    }

    public boolean w(ArrayList<c> arrayList, d dVar, e eVar, d.a.w.c.g.c cVar) {
        if (t()) {
            Log.e(f68631h, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        s(eVar, cVar);
        a aVar = new a(this, arrayList, dVar);
        Handler handler = this.f68633b;
        handler.sendMessage(handler.obtainMessage(1001, aVar));
        this.f68637f = true;
        return true;
    }

    public void x() {
        Handler handler = this.f68633b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void y() {
        if (this.f68633b == null || !this.f68637f) {
            return;
        }
        this.f68637f = false;
        this.f68633b.removeMessages(1005);
        Handler handler = this.f68633b;
        handler.sendMessage(handler.obtainMessage(1006));
    }

    public void z(ArrayList<c> arrayList) {
        Handler handler = this.f68633b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1003, arrayList));
        }
    }
}
