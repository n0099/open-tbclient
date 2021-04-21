package d.b.g0.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f43570c;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f43571a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f43572b;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(d dVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = new b();
            bVar.f43550a = message.arg2;
            int i = message.arg1;
            if (i == -1) {
                i = c.i().a();
            }
            c.i().c(message.what, 3, 2019, i, "out time.", bVar, true);
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("callback-handler");
        this.f43571a = handlerThread;
        this.f43572b = null;
        handlerThread.start();
        this.f43572b = new a(this, this.f43571a.getLooper());
    }

    public static d a() {
        if (f43570c == null) {
            synchronized (d.class) {
                if (f43570c == null) {
                    f43570c = new d();
                }
            }
        }
        return f43570c;
    }

    public void b(int i) {
        this.f43572b.removeMessages(i);
    }

    public void c(Message message, long j) {
        this.f43572b.sendMessageDelayed(message, j);
    }
}
