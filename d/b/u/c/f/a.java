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
    public static final String f64749f = "a";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f64750a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64751b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.u.c.g.a f64752c;

    /* renamed from: d  reason: collision with root package name */
    public e f64753d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f64754e = false;

    /* renamed from: d.b.u.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1774a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f64755a;

        /* renamed from: b  reason: collision with root package name */
        public int f64756b;

        /* renamed from: c  reason: collision with root package name */
        public long f64757c;

        public C1774a(a aVar, ByteBuffer byteBuffer, int i, long j) {
            this.f64755a = byteBuffer;
            this.f64756b = i;
            this.f64757c = j;
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
                    C1774a c1774a = (C1774a) message.obj;
                    a.this.h(c1774a.f64755a, c1774a.f64756b, c1774a.f64757c);
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
        C1774a c1774a = new C1774a(this, byteBuffer, i, j);
        if (this.f64751b == null || !this.f64754e) {
            return;
        }
        Handler handler = this.f64751b;
        handler.sendMessage(handler.obtainMessage(1003, c1774a));
    }

    public final void h(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64752c.a(false, byteBuffer, i, j);
        }
    }

    public final void i() {
        Handler handler = this.f64751b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f64751b = null;
        }
        HandlerThread handlerThread = this.f64750a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f64750a = null;
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 18) {
            d.b.u.c.g.a aVar = this.f64752c;
            if (aVar != null) {
                aVar.i();
                this.f64752c.e();
            }
            this.f64752c = null;
            this.f64753d = null;
        }
    }

    public final void k(d dVar) {
        d.b.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64752c) == null) {
            return;
        }
        aVar.k(dVar, this.f64753d);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64752c.h();
        }
    }

    public final void m() {
        d.b.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64752c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.f64750a = handlerThread;
        handlerThread.start();
        this.f64751b = new b(this.f64750a.getLooper());
        try {
            this.f64752c = new d.b.u.c.g.a();
        } catch (VerifyError unused) {
            Log.e(f64749f, "initRecorder verifyError");
            if (this.f64752c == null) {
                return;
            }
        }
        this.f64753d = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64752c.f(cVar);
        }
    }

    public boolean o() {
        HandlerThread handlerThread = this.f64750a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void p() {
        Handler handler = this.f64751b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f64751b;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f64751b;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean q(d dVar, e eVar, c cVar) {
        if (o()) {
            Log.e(f64749f, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        n(eVar, cVar);
        Handler handler = this.f64751b;
        handler.sendMessage(handler.obtainMessage(1001, dVar));
        this.f64754e = true;
        return true;
    }

    public void r() {
        Handler handler = this.f64751b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void s() {
        if (this.f64751b == null || !this.f64754e) {
            return;
        }
        this.f64754e = false;
        Handler handler = this.f64751b;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
