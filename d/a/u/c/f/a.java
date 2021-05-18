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
    public static final String f64746f = "a";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f64747a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64748b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.u.c.g.a f64749c;

    /* renamed from: d  reason: collision with root package name */
    public e f64750d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f64751e = false;

    /* renamed from: d.a.u.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1809a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f64752a;

        /* renamed from: b  reason: collision with root package name */
        public int f64753b;

        /* renamed from: c  reason: collision with root package name */
        public long f64754c;

        public C1809a(a aVar, ByteBuffer byteBuffer, int i2, long j) {
            this.f64752a = byteBuffer;
            this.f64753b = i2;
            this.f64754c = j;
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
                    C1809a c1809a = (C1809a) message.obj;
                    a.this.h(c1809a.f64752a, c1809a.f64753b, c1809a.f64754c);
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
        C1809a c1809a = new C1809a(this, byteBuffer, i2, j);
        if (this.f64748b == null || !this.f64751e) {
            return;
        }
        Handler handler = this.f64748b;
        handler.sendMessage(handler.obtainMessage(1003, c1809a));
    }

    public final void h(ByteBuffer byteBuffer, int i2, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64749c.a(false, byteBuffer, i2, j);
        }
    }

    public final void i() {
        Handler handler = this.f64748b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f64748b = null;
        }
        HandlerThread handlerThread = this.f64747a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f64747a = null;
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 18) {
            d.a.u.c.g.a aVar = this.f64749c;
            if (aVar != null) {
                aVar.i();
                this.f64749c.e();
            }
            this.f64749c = null;
            this.f64750d = null;
        }
    }

    public final void k(d dVar) {
        d.a.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64749c) == null) {
            return;
        }
        aVar.k(dVar, this.f64750d);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64749c.h();
        }
    }

    public final void m() {
        d.a.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f64749c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.f64747a = handlerThread;
        handlerThread.start();
        this.f64748b = new b(this.f64747a.getLooper());
        try {
            this.f64749c = new d.a.u.c.g.a();
        } catch (VerifyError unused) {
            Log.e(f64746f, "initRecorder verifyError");
            if (this.f64749c == null) {
                return;
            }
        }
        this.f64750d = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f64749c.f(cVar);
        }
    }

    public boolean o() {
        HandlerThread handlerThread = this.f64747a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void p() {
        Handler handler = this.f64748b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f64748b;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f64748b;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean q(d dVar, e eVar, c cVar) {
        if (o()) {
            Log.e(f64746f, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        n(eVar, cVar);
        Handler handler = this.f64748b;
        handler.sendMessage(handler.obtainMessage(1001, dVar));
        this.f64751e = true;
        return true;
    }

    public void r() {
        Handler handler = this.f64748b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void s() {
        if (this.f64748b == null || !this.f64751e) {
            return;
        }
        this.f64751e = false;
        Handler handler = this.f64748b;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
