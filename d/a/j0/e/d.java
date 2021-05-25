package d.a.j0.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f40321c;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f40322a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f40323b;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(d dVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = new b();
            bVar.f40301a = message.arg2;
            int i2 = message.arg1;
            if (i2 == -1) {
                i2 = c.i().a();
            }
            c.i().c(message.what, 3, 2019, i2, "out time.", bVar, true);
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("callback-handler");
        this.f40322a = handlerThread;
        this.f40323b = null;
        handlerThread.start();
        this.f40323b = new a(this, this.f40322a.getLooper());
    }

    public static d a() {
        if (f40321c == null) {
            synchronized (d.class) {
                if (f40321c == null) {
                    f40321c = new d();
                }
            }
        }
        return f40321c;
    }

    public void b(int i2) {
        this.f40323b.removeMessages(i2);
    }

    public void c(Message message, long j) {
        this.f40323b.sendMessageDelayed(message, j);
    }
}
