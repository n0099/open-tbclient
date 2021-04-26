package d.a.g0.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f40815c;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f40816a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f40817b;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(d dVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = new b();
            bVar.f40795a = message.arg2;
            int i2 = message.arg1;
            if (i2 == -1) {
                i2 = c.i().a();
            }
            c.i().c(message.what, 3, 2019, i2, "out time.", bVar, true);
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("callback-handler");
        this.f40816a = handlerThread;
        this.f40817b = null;
        handlerThread.start();
        this.f40817b = new a(this, this.f40816a.getLooper());
    }

    public static d a() {
        if (f40815c == null) {
            synchronized (d.class) {
                if (f40815c == null) {
                    f40815c = new d();
                }
            }
        }
        return f40815c;
    }

    public void b(int i2) {
        this.f40817b.removeMessages(i2);
    }

    public void c(Message message, long j) {
        this.f40817b.sendMessageDelayed(message, j);
    }
}
