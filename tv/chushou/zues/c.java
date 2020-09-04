package tv.chushou.zues;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class c {
    private final Handler.Callback mCallback;
    private Lock mLock;
    private final b oMR;
    @VisibleForTesting
    final a oMS;

    public c() {
        this.mLock = new ReentrantLock();
        this.oMS = new a(this.mLock, null);
        this.mCallback = null;
        this.oMR = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.oMS = new a(this.mLock, null);
        this.mCallback = callback;
        this.oMR = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.oMS = new a(this.mLock, null);
        this.mCallback = null;
        this.oMR = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.oMS = new a(this.mLock, null);
        this.mCallback = callback;
        this.oMR = new b(looper, new WeakReference(callback));
    }

    public final boolean o(@NonNull Runnable runnable) {
        return this.oMR.post(M(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.oMR.postDelayed(M(runnable), j);
    }

    public final void L(Runnable runnable) {
        RunnableC1009c N = this.oMS.N(runnable);
        if (N != null) {
            this.oMR.removeCallbacks(N);
        }
    }

    public final boolean S(Message message) {
        return this.oMR.sendMessage(message);
    }

    public final boolean Ow(int i) {
        return this.oMR.sendEmptyMessage(i);
    }

    public final boolean B(int i, long j) {
        return this.oMR.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.oMR.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.oMR.removeMessages(i);
    }

    public final void cl(Object obj) {
        this.oMR.removeCallbacksAndMessages(obj);
    }

    public final boolean Ox(int i) {
        return this.oMR.hasMessages(i);
    }

    public final Message Oy(int i) {
        return this.oMR.obtainMessage(i);
    }

    private RunnableC1009c M(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.oMS.a(aVar);
        return aVar.oMV;
    }

    /* loaded from: classes6.dex */
    private static class b extends Handler {
        private final WeakReference<Handler.Callback> mCallback;

        b() {
            this.mCallback = null;
        }

        b(WeakReference<Handler.Callback> weakReference) {
            this.mCallback = weakReference;
        }

        b(Looper looper) {
            super(looper);
            this.mCallback = null;
        }

        b(Looper looper, WeakReference<Handler.Callback> weakReference) {
            super(looper);
            this.mCallback = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Handler.Callback callback;
            if (this.mCallback != null && (callback = this.mCallback.get()) != null) {
                callback.handleMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.chushou.zues.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class RunnableC1009c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> oMW;

        RunnableC1009c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.oMW = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.oMW.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.eml();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        @NonNull
        Lock lock;
        @Nullable
        a oMT;
        @Nullable
        a oMU;
        @NonNull
        final RunnableC1009c oMV;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.oMV = new RunnableC1009c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC1009c eml() {
            this.lock.lock();
            try {
                if (this.oMU != null) {
                    this.oMU.oMT = this.oMT;
                }
                if (this.oMT != null) {
                    this.oMT.oMU = this.oMU;
                }
                this.oMU = null;
                this.oMT = null;
                this.lock.unlock();
                return this.oMV;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.oMT != null) {
                    this.oMT.oMU = aVar;
                }
                aVar.oMT = this.oMT;
                this.oMT = aVar;
                aVar.oMU = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC1009c N(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.oMT; aVar != null; aVar = aVar.oMT) {
                    if (aVar.runnable == runnable) {
                        return aVar.eml();
                    }
                }
                this.lock.unlock();
                return null;
            } finally {
                this.lock.unlock();
            }
        }
    }
}
