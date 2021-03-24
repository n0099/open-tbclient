package d.b.u.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.b.u.c.g.c;
import d.b.u.c.g.d;
import d.b.u.c.g.e;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f64748f = "a";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f64749a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64750b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.u.c.g.a f64751c;

    /* renamed from: d  reason: collision with root package name */
    public e f64752d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f64753e = false;

    /* renamed from: d.b.u.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1773a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f64754a;

        /* renamed from: b  reason: collision with root package name */
        public int f64755b;

        /* renamed from: c  reason: collision with root package name */
        public long f64756c;

        public C1773a(a aVar, ByteBuffer byteBuffer, int i, long j) {
            this.f64754a = byteBuffer;
            this.f64755b = i;
            this.f64756c = j;
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
                    C1773a c1773a = (C1773a) message.obj;
                    a.this.h(c1773a.f64754a, c1773a.f64755b, c1773a.f64756c);
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

    public void g(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer == null || i <= 0) {
            return;
        }
        C1773a c1773a = new C1773a(this, byteBuffer, i, j);
        if (this.f64750b == null || !this.f64753e) {
            return;
        }
        Handler handler = this.f64750b;
        handler.sendMessage(handler.obtainMessage(1003, c1773a));
    }

    public final void h(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64751c.a(false, byteBuffer, i, j);
        }
    }

    public final void i() {
        Handler handler = this.f64750b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f64750b = null;
        }
        HandlerThread handlerThread = this.f64749a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f64749a = null;
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 18) {
            d.b.u.c.g.a aVar = this.f64751c;
            if (aVar != null) {
                aVar.i();
                this.f64751c.e();
            }
            this.f64751c = null;
            this.f64752d = null;
        }
    }

    public final void k(d dVar) {
        d.b.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64751c) == null) {
            return;
        }
        aVar.k(dVar, this.f64752d);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64751c.h();
        }
    }

    public final void m() {
        d.b.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64751c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.f64749a = handlerThread;
        handlerThread.start();
        this.f64750b = new b(this.f64749a.getLooper());
        try {
            this.f64751c = new d.b.u.c.g.a();
        } catch (VerifyError unused) {
            Log.e(f64748f, "initRecorder verifyError");
            if (this.f64751c == null) {
                return;
            }
        }
        this.f64752d = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64751c.f(cVar);
        }
    }

    public boolean o() {
        HandlerThread handlerThread = this.f64749a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void p() {
        Handler handler = this.f64750b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f64750b;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f64750b;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean q(d dVar, e eVar, c cVar) {
        if (o()) {
            Log.e(f64748f, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        n(eVar, cVar);
        Handler handler = this.f64750b;
        handler.sendMessage(handler.obtainMessage(1001, dVar));
        this.f64753e = true;
        return true;
    }

    public void r() {
        Handler handler = this.f64750b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void s() {
        if (this.f64750b == null || !this.f64753e) {
            return;
        }
        this.f64753e = false;
        Handler handler = this.f64750b;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
