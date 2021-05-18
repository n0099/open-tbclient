package d.a.i0.a.l2.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43236f = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l2.d.b f43237a = new d.a.i0.a.l2.d.b();

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.l2.b f43238b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f43239c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f43240d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f43241e;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 101) {
                b.this.f();
                if (!b.this.f43239c) {
                    b.this.f43241e.removeMessages(101);
                } else {
                    b.this.f43237a.c();
                }
            }
        }
    }

    public b(d.a.i0.a.l2.b bVar) {
        this.f43238b = bVar;
    }

    public synchronized void c() {
        if (this.f43239c) {
            return;
        }
        d();
        this.f43241e.sendMessage(this.f43241e.obtainMessage(101));
    }

    public final void d() {
        if (this.f43241e == null) {
            HandlerThread handlerThread = new HandlerThread("cookieSync");
            this.f43240d = handlerThread;
            handlerThread.start();
            this.f43241e = new a(this.f43240d.getLooper());
        }
    }

    public synchronized void e() {
        this.f43239c = true;
        if (this.f43240d != null) {
            this.f43240d.quitSafely();
        }
        this.f43241e = null;
        this.f43240d = null;
    }

    public abstract void f();

    public synchronized void g() {
        if (this.f43239c) {
            return;
        }
        d();
        this.f43241e.sendMessageDelayed(this.f43241e.obtainMessage(101), 5000L);
    }
}
