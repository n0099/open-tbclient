package d.a.u.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.a.u.c.g.c;
import d.a.u.c.g.d;
import d.a.u.c.g.e;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f64059f = "a";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f64060a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64061b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.u.c.g.a f64062c;

    /* renamed from: d  reason: collision with root package name */
    public e f64063d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f64064e = false;

    /* renamed from: d.a.u.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1745a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f64065a;

        /* renamed from: b  reason: collision with root package name */
        public int f64066b;

        /* renamed from: c  reason: collision with root package name */
        public long f64067c;

        public C1745a(a aVar, ByteBuffer byteBuffer, int i2, long j) {
            this.f64065a = byteBuffer;
            this.f64066b = i2;
            this.f64067c = j;
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
                    C1745a c1745a = (C1745a) message.obj;
                    a.this.h(c1745a.f64065a, c1745a.f64066b, c1745a.f64067c);
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
        C1745a c1745a = new C1745a(this, byteBuffer, i2, j);
        if (this.f64061b == null || !this.f64064e) {
            return;
        }
        Handler handler = this.f64061b;
        handler.sendMessage(handler.obtainMessage(1003, c1745a));
    }

    public final void h(ByteBuffer byteBuffer, int i2, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64062c.a(false, byteBuffer, i2, j);
        }
    }

    public final void i() {
        Handler handler = this.f64061b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f64061b = null;
        }
        HandlerThread handlerThread = this.f64060a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f64060a = null;
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 18) {
            d.a.u.c.g.a aVar = this.f64062c;
            if (aVar != null) {
                aVar.i();
                this.f64062c.e();
            }
            this.f64062c = null;
            this.f64063d = null;
        }
    }

    public final void k(d dVar) {
        d.a.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64062c) == null) {
            return;
        }
        aVar.k(dVar, this.f64063d);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64062c.h();
        }
    }

    public final void m() {
        d.a.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64062c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.f64060a = handlerThread;
        handlerThread.start();
        this.f64061b = new b(this.f64060a.getLooper());
        try {
            this.f64062c = new d.a.u.c.g.a();
        } catch (VerifyError unused) {
            Log.e(f64059f, "initRecorder verifyError");
            if (this.f64062c == null) {
                return;
            }
        }
        this.f64063d = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64062c.f(cVar);
        }
    }

    public boolean o() {
        HandlerThread handlerThread = this.f64060a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void p() {
        Handler handler = this.f64061b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f64061b;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f64061b;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean q(d dVar, e eVar, c cVar) {
        if (o()) {
            Log.e(f64059f, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        n(eVar, cVar);
        Handler handler = this.f64061b;
        handler.sendMessage(handler.obtainMessage(1001, dVar));
        this.f64064e = true;
        return true;
    }

    public void r() {
        Handler handler = this.f64061b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void s() {
        if (this.f64061b == null || !this.f64064e) {
            return;
        }
        this.f64064e = false;
        Handler handler = this.f64061b;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
