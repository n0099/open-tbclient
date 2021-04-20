package d.b.t.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import d.b.t.c.g.c;
import d.b.t.c.g.d;
import d.b.t.c.g.e;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f65443f = "a";

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f65444a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f65445b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.t.c.g.a f65446c;

    /* renamed from: d  reason: collision with root package name */
    public e f65447d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f65448e = false;

    /* renamed from: d.b.t.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1786a {

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f65449a;

        /* renamed from: b  reason: collision with root package name */
        public int f65450b;

        /* renamed from: c  reason: collision with root package name */
        public long f65451c;

        public C1786a(a aVar, ByteBuffer byteBuffer, int i, long j) {
            this.f65449a = byteBuffer;
            this.f65450b = i;
            this.f65451c = j;
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
                    C1786a c1786a = (C1786a) message.obj;
                    a.this.h(c1786a.f65449a, c1786a.f65450b, c1786a.f65451c);
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
        C1786a c1786a = new C1786a(this, byteBuffer, i, j);
        if (this.f65445b == null || !this.f65448e) {
            return;
        }
        Handler handler = this.f65445b;
        handler.sendMessage(handler.obtainMessage(1003, c1786a));
    }

    public final void h(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65446c.a(false, byteBuffer, i, j);
        }
    }

    public final void i() {
        Handler handler = this.f65445b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f65445b = null;
        }
        HandlerThread handlerThread = this.f65444a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f65444a = null;
        }
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 18) {
            d.b.t.c.g.a aVar = this.f65446c;
            if (aVar != null) {
                aVar.i();
                this.f65446c.e();
            }
            this.f65446c = null;
            this.f65447d = null;
        }
    }

    public final void k(d dVar) {
        d.b.t.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f65446c) == null) {
            return;
        }
        aVar.k(dVar, this.f65447d);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65446c.h();
        }
    }

    public final void m() {
        d.b.t.c.g.a aVar;
        if (Build.VERSION.SDK_INT < 18 || (aVar = this.f65446c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.f65444a = handlerThread;
        handlerThread.start();
        this.f65445b = new b(this.f65444a.getLooper());
        try {
            this.f65446c = new d.b.t.c.g.a();
        } catch (VerifyError unused) {
            Log.e(f65443f, "initRecorder verifyError");
            if (this.f65446c == null) {
                return;
            }
        }
        this.f65447d = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f65446c.f(cVar);
        }
    }

    public boolean o() {
        HandlerThread handlerThread = this.f65444a;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void p() {
        Handler handler = this.f65445b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.f65445b;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.f65445b;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean q(d dVar, e eVar, c cVar) {
        if (o()) {
            Log.e(f65443f, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        n(eVar, cVar);
        Handler handler = this.f65445b;
        handler.sendMessage(handler.obtainMessage(1001, dVar));
        this.f65448e = true;
        return true;
    }

    public void r() {
        Handler handler = this.f65445b;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void s() {
        if (this.f65445b == null || !this.f65448e) {
            return;
        }
        this.f65448e = false;
        Handler handler = this.f65445b;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
