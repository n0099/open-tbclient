package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes8.dex */
public final class e implements Handler.Callback {
    public volatile Handler a = new Handler(a.a, this);

    /* loaded from: classes8.dex */
    public interface b {
        long a();
    }

    /* loaded from: classes8.dex */
    public class a {
        public static final Looper a;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            a = handlerThread.getLooper();
        }
    }

    public static Looper a() {
        return a.a;
    }

    public void b() {
        Handler handler = this.a;
        if (handler == null) {
            return;
        }
        this.a = null;
        handler.removeCallbacksAndMessages(null);
    }

    public void a(b bVar, long j) {
        Handler handler = this.a;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = bVar;
        handler.sendMessageDelayed(obtain, j);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            try {
                b bVar = (b) message.obj;
                long a2 = bVar.a();
                if (a2 > 0) {
                    a(bVar, a2);
                    return true;
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return true;
    }
}
