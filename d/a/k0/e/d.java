package d.a.k0.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f44140c;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f44141a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f44142b;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(d dVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = new b();
            bVar.f44119a = message.arg2;
            int i2 = message.arg1;
            if (i2 == -1) {
                i2 = c.j().a();
            }
            c.j().c(message.what, 3, 2019, i2, "out time.", bVar, true);
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("callback-handler");
        this.f44141a = handlerThread;
        this.f44142b = null;
        handlerThread.start();
        this.f44142b = new a(this, this.f44141a.getLooper());
    }

    public static d a() {
        if (f44140c == null) {
            synchronized (d.class) {
                if (f44140c == null) {
                    f44140c = new d();
                }
            }
        }
        return f44140c;
    }

    public void b(int i2) {
        this.f44142b.removeMessages(i2);
    }

    public void c(Message message, long j) {
        this.f44142b.sendMessageDelayed(message, j);
    }
}
