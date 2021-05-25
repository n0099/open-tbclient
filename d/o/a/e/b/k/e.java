package d.o.a.e.b.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public final class e implements Handler.Callback {

    /* renamed from: e  reason: collision with root package name */
    public volatile Handler f67342e = new Handler(a.f67343a, this);

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Looper f67343a;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            f67343a = handlerThread.getLooper();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        long a();
    }

    public static Looper a() {
        return a.f67343a;
    }

    public void b(b bVar, long j) {
        Handler handler = this.f67342e;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = bVar;
        handler.sendMessageDelayed(obtain, j);
    }

    public void c() {
        Handler handler = this.f67342e;
        if (handler == null) {
            return;
        }
        this.f67342e = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            b bVar = (b) message.obj;
            long a2 = bVar.a();
            if (a2 > 0) {
                b(bVar, a2);
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }
}
