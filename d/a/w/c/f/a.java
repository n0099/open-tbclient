package d.a.w.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.a.w.c.g.c;
import d.a.w.c.g.d;
import d.a.w.c.g.e;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f68517f = "a";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f68518a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68519b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w.c.g.a f68520c;

    /* renamed from: d  reason: collision with root package name */
    public e f68521d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f68522e = false;

    /* renamed from: d.a.w.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1874a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f68523a;

        /* renamed from: b  reason: collision with root package name */
        public int f68524b;

        /* renamed from: c  reason: collision with root package name */
        public long f68525c;

        public C1874a(a aVar, ByteBuffer byteBuffer, int i2, long j) {
            this.f68523a = byteBuffer;
            this.f68524b = i2;
            this.f68525c = j;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a.this.k((d) message.obj);
                    return;
                case 1002:
                    a.this.l();
                    return;
                case 1003:
                    C1874a c1874a = (C1874a) message.obj;
                    a.this.h(c1874a.f68523a, c1874a.f68524b, c1874a.f68525c);
                    return;
                case 1004:
                    a.this.m();
                    return;
                case 1005:
                    a.this.j();
                    return;
                case 1006:
                    a.this.i();
                    return;
                default:
                    return;
            }
        }
    }

    public void g(ByteBuffer byteBuffer, int i2, long j) {
        if (byteBuffer == null || i2 <= 0) {
            return;
        }
        C1874a c1874a = new C1874a(this, byteBuffer, i2, j);
        if (this.f68519b == null || !this.f68522e) {
            return;
        }
        Handler handler = this.f68519b;
        handler.sendMessage(handler.obtainMessage(1003, c1874a));
    }

    public final void h(ByteBuffer byteBuffer, int i2, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f68520c.a(false, byteBuffer, i2, j);
        }
    }

    public final void i() {
        Handler handler = this.f68519b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f68519b = null;
        }
        HandlerThread handlerThread = this.f68518a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f68518a = null;
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 18) {
            d.a.w.c.g.a aVar = this.f68520c;
            if (aVar != null) {
                aVar.i();
                this.f68520c.e();
            }
            this.f68520c = null;
            this.f68521d = null;
        }
    }

    public final void k(d dVar) {
        d.a.w.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f68520c) == null) {
            return;
        }
        aVar.k(dVar, this.f68521d);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f68520c.h();
        }
    }

    public final void m() {
        d.a.w.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f68520c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.f68518a = handlerThread;
        handlerThread.start();
        this.f68519b = new b(this.f68518a.getLooper());
        try {
            this.f68520c = new d.a.w.c.g.a();
        } catch (VerifyError unused) {
            Log.e(f68517f, "initRecorder verifyError");
            if (this.f68520c == null) {
                return;
            }
        }
        this.f68521d = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f68520c.f(cVar);
        }
    }

    public boolean o() {
        HandlerThread handlerThread = this.f68518a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void p() {
        Handler handler = this.f68519b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f68519b;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f68519b;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean q(d dVar, e eVar, c cVar) {
        if (o()) {
            Log.e(f68517f, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        n(eVar, cVar);
        Handler handler = this.f68519b;
        handler.sendMessage(handler.obtainMessage(1001, dVar));
        this.f68522e = true;
        return true;
    }

    public void r() {
        Handler handler = this.f68519b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void s() {
        if (this.f68519b == null || !this.f68522e) {
            return;
        }
        this.f68522e = false;
        Handler handler = this.f68519b;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
