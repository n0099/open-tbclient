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
    public static final String f65707f = "a";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f65708a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f65709b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.u.c.g.a f65710c;

    /* renamed from: d  reason: collision with root package name */
    public e f65711d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f65712e = false;

    /* renamed from: d.b.u.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1805a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f65713a;

        /* renamed from: b  reason: collision with root package name */
        public int f65714b;

        /* renamed from: c  reason: collision with root package name */
        public long f65715c;

        public C1805a(a aVar, ByteBuffer byteBuffer, int i, long j) {
            this.f65713a = byteBuffer;
            this.f65714b = i;
            this.f65715c = j;
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
                    C1805a c1805a = (C1805a) message.obj;
                    a.this.h(c1805a.f65713a, c1805a.f65714b, c1805a.f65715c);
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
        C1805a c1805a = new C1805a(this, byteBuffer, i, j);
        if (this.f65709b == null || !this.f65712e) {
            return;
        }
        Handler handler = this.f65709b;
        handler.sendMessage(handler.obtainMessage(1003, c1805a));
    }

    public final void h(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65710c.a(false, byteBuffer, i, j);
        }
    }

    public final void i() {
        Handler handler = this.f65709b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f65709b = null;
        }
        HandlerThread handlerThread = this.f65708a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f65708a = null;
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 18) {
            d.b.u.c.g.a aVar = this.f65710c;
            if (aVar != null) {
                aVar.i();
                this.f65710c.e();
            }
            this.f65710c = null;
            this.f65711d = null;
        }
    }

    public final void k(d dVar) {
        d.b.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f65710c) == null) {
            return;
        }
        aVar.k(dVar, this.f65711d);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65710c.h();
        }
    }

    public final void m() {
        d.b.u.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f65710c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.f65708a = handlerThread;
        handlerThread.start();
        this.f65709b = new b(this.f65708a.getLooper());
        try {
            this.f65710c = new d.b.u.c.g.a();
        } catch (VerifyError unused) {
            Log.e(f65707f, "initRecorder verifyError");
            if (this.f65710c == null) {
                return;
            }
        }
        this.f65711d = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65710c.f(cVar);
        }
    }

    public boolean o() {
        HandlerThread handlerThread = this.f65708a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void p() {
        Handler handler = this.f65709b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f65709b;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f65709b;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean q(d dVar, e eVar, c cVar) {
        if (o()) {
            Log.e(f65707f, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        n(eVar, cVar);
        Handler handler = this.f65709b;
        handler.sendMessage(handler.obtainMessage(1001, dVar));
        this.f65712e = true;
        return true;
    }

    public void r() {
        Handler handler = this.f65709b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void s() {
        if (this.f65709b == null || !this.f65712e) {
            return;
        }
        this.f65712e = false;
        Handler handler = this.f65709b;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
