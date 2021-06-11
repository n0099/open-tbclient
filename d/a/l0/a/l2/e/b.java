package d.a.l0.a.l2.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47086f = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l2.d.b f47087a = new d.a.l0.a.l2.d.b();

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.l2.b f47088b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f47089c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f47090d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f47091e;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 101) {
                b.this.f();
                if (!b.this.f47089c) {
                    b.this.f47091e.removeMessages(101);
                } else {
                    b.this.f47087a.c();
                }
            }
        }
    }

    public b(d.a.l0.a.l2.b bVar) {
        this.f47088b = bVar;
    }

    public synchronized void c() {
        if (this.f47089c) {
            return;
        }
        d();
        this.f47091e.sendMessage(this.f47091e.obtainMessage(101));
    }

    public final void d() {
        if (this.f47091e == null) {
            HandlerThread handlerThread = new HandlerThread("cookieSync");
            this.f47090d = handlerThread;
            handlerThread.start();
            this.f47091e = new a(this.f47090d.getLooper());
        }
    }

    public synchronized void e() {
        this.f47089c = true;
        if (this.f47090d != null) {
            this.f47090d.quitSafely();
        }
        this.f47091e = null;
        this.f47090d = null;
    }

    public abstract void f();

    public synchronized void g() {
        if (this.f47089c) {
            return;
        }
        d();
        this.f47091e.sendMessageDelayed(this.f47091e.obtainMessage(101), 5000L);
    }
}
