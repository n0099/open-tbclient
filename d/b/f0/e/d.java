package d.b.f0.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f42880c;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f42881a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f42882b;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(d dVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = new b();
            bVar.f42860a = message.arg2;
            int i = message.arg1;
            if (i == -1) {
                i = c.i().a();
            }
            c.i().c(message.what, 3, 2019, i, "out time.", bVar, true);
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("callback-handler");
        this.f42881a = handlerThread;
        this.f42882b = null;
        handlerThread.start();
        this.f42882b = new a(this, this.f42881a.getLooper());
    }

    public static d a() {
        if (f42880c == null) {
            synchronized (d.class) {
                if (f42880c == null) {
                    f42880c = new d();
                }
            }
        }
        return f42880c;
    }

    public void b(int i) {
        this.f42882b.removeMessages(i);
    }

    public void c(Message message, long j) {
        this.f42882b.sendMessageDelayed(message, j);
    }
}
