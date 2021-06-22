package d.a.m0.a.l2.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47194f = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l2.d.b f47195a = new d.a.m0.a.l2.d.b();

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.l2.b f47196b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f47197c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f47198d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f47199e;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 101) {
                b.this.f();
                if (!b.this.f47197c) {
                    b.this.f47199e.removeMessages(101);
                } else {
                    b.this.f47195a.c();
                }
            }
        }
    }

    public b(d.a.m0.a.l2.b bVar) {
        this.f47196b = bVar;
    }

    public synchronized void c() {
        if (this.f47197c) {
            return;
        }
        d();
        this.f47199e.sendMessage(this.f47199e.obtainMessage(101));
    }

    public final void d() {
        if (this.f47199e == null) {
            HandlerThread handlerThread = new HandlerThread("cookieSync");
            this.f47198d = handlerThread;
            handlerThread.start();
            this.f47199e = new a(this.f47198d.getLooper());
        }
    }

    public synchronized void e() {
        this.f47197c = true;
        if (this.f47198d != null) {
            this.f47198d.quitSafely();
        }
        this.f47199e = null;
        this.f47198d = null;
    }

    public abstract void f();

    public synchronized void g() {
        if (this.f47197c) {
            return;
        }
        d();
        this.f47199e.sendMessageDelayed(this.f47199e.obtainMessage(101), 5000L);
    }
}
