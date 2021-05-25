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
    public static final String f64799f = "a";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f64800a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64801b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w.c.g.a f64802c;

    /* renamed from: d  reason: collision with root package name */
    public e f64803d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f64804e = false;

    /* renamed from: d.a.w.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1816a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f64805a;

        /* renamed from: b  reason: collision with root package name */
        public int f64806b;

        /* renamed from: c  reason: collision with root package name */
        public long f64807c;

        public C1816a(a aVar, ByteBuffer byteBuffer, int i2, long j) {
            this.f64805a = byteBuffer;
            this.f64806b = i2;
            this.f64807c = j;
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
                    C1816a c1816a = (C1816a) message.obj;
                    a.this.h(c1816a.f64805a, c1816a.f64806b, c1816a.f64807c);
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
        C1816a c1816a = new C1816a(this, byteBuffer, i2, j);
        if (this.f64801b == null || !this.f64804e) {
            return;
        }
        Handler handler = this.f64801b;
        handler.sendMessage(handler.obtainMessage(1003, c1816a));
    }

    public final void h(ByteBuffer byteBuffer, int i2, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64802c.a(false, byteBuffer, i2, j);
        }
    }

    public final void i() {
        Handler handler = this.f64801b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f64801b = null;
        }
        HandlerThread handlerThread = this.f64800a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f64800a = null;
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 18) {
            d.a.w.c.g.a aVar = this.f64802c;
            if (aVar != null) {
                aVar.i();
                this.f64802c.e();
            }
            this.f64802c = null;
            this.f64803d = null;
        }
    }

    public final void k(d dVar) {
        d.a.w.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64802c) == null) {
            return;
        }
        aVar.k(dVar, this.f64803d);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64802c.h();
        }
    }

    public final void m() {
        d.a.w.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64802c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.f64800a = handlerThread;
        handlerThread.start();
        this.f64801b = new b(this.f64800a.getLooper());
        try {
            this.f64802c = new d.a.w.c.g.a();
        } catch (VerifyError unused) {
            Log.e(f64799f, "initRecorder verifyError");
            if (this.f64802c == null) {
                return;
            }
        }
        this.f64803d = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64802c.f(cVar);
        }
    }

    public boolean o() {
        HandlerThread handlerThread = this.f64800a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void p() {
        Handler handler = this.f64801b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f64801b;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f64801b;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean q(d dVar, e eVar, c cVar) {
        if (o()) {
            Log.e(f64799f, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        n(eVar, cVar);
        Handler handler = this.f64801b;
        handler.sendMessage(handler.obtainMessage(1001, dVar));
        this.f64804e = true;
        return true;
    }

    public void r() {
        Handler handler = this.f64801b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void s() {
        if (this.f64801b == null || !this.f64804e) {
            return;
        }
        this.f64804e = false;
        Handler handler = this.f64801b;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
