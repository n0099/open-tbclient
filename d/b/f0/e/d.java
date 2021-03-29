package d.b.f0.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f42881c;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f42882a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f42883b;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(d dVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = new b();
            bVar.f42861a = message.arg2;
            int i = message.arg1;
            if (i == -1) {
                i = c.i().a();
            }
            c.i().c(message.what, 3, 2019, i, "out time.", bVar, true);
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("callback-handler");
        this.f42882a = handlerThread;
        this.f42883b = null;
        handlerThread.start();
        this.f42883b = new a(this, this.f42882a.getLooper());
    }

    public static d a() {
        if (f42881c == null) {
            synchronized (d.class) {
                if (f42881c == null) {
                    f42881c = new d();
                }
            }
        }
        return f42881c;
    }

    public void b(int i) {
        this.f42883b.removeMessages(i);
    }

    public void c(Message message, long j) {
        this.f42883b.sendMessageDelayed(message, j);
    }
}
