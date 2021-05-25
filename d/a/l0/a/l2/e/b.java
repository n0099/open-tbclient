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
    public static final boolean f43410f = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l2.d.b f43411a = new d.a.l0.a.l2.d.b();

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.l2.b f43412b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f43413c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f43414d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f43415e;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 101) {
                b.this.f();
                if (!b.this.f43413c) {
                    b.this.f43415e.removeMessages(101);
                } else {
                    b.this.f43411a.c();
                }
            }
        }
    }

    public b(d.a.l0.a.l2.b bVar) {
        this.f43412b = bVar;
    }

    public synchronized void c() {
        if (this.f43413c) {
            return;
        }
        d();
        this.f43415e.sendMessage(this.f43415e.obtainMessage(101));
    }

    public final void d() {
        if (this.f43415e == null) {
            HandlerThread handlerThread = new HandlerThread("cookieSync");
            this.f43414d = handlerThread;
            handlerThread.start();
            this.f43415e = new a(this.f43414d.getLooper());
        }
    }

    public synchronized void e() {
        this.f43413c = true;
        if (this.f43414d != null) {
            this.f43414d.quitSafely();
        }
        this.f43415e = null;
        this.f43414d = null;
    }

    public abstract void f();

    public synchronized void g() {
        if (this.f43413c) {
            return;
        }
        d();
        this.f43415e.sendMessageDelayed(this.f43415e.obtainMessage(101), 5000L);
    }
}
