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
    private final b qmx;
    @VisibleForTesting
    final a qmy;

    public c() {
        this.mLock = new ReentrantLock();
        this.qmy = new a(this.mLock, null);
        this.mCallback = null;
        this.qmx = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.qmy = new a(this.mLock, null);
        this.mCallback = callback;
        this.qmx = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.qmy = new a(this.mLock, null);
        this.mCallback = null;
        this.qmx = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.qmy = new a(this.mLock, null);
        this.mCallback = callback;
        this.qmx = new b(looper, new WeakReference(callback));
    }

    public final boolean o(@NonNull Runnable runnable) {
        return this.qmx.post(O(runnable));
    }

    public final boolean f(Runnable runnable, long j) {
        return this.qmx.postDelayed(O(runnable), j);
    }

    public final void N(Runnable runnable) {
        RunnableC1116c P = this.qmy.P(runnable);
        if (P != null) {
            this.qmx.removeCallbacks(P);
        }
    }

    public final boolean X(Message message) {
        return this.qmx.sendMessage(message);
    }

    public final boolean RT(int i) {
        return this.qmx.sendEmptyMessage(i);
    }

    public final boolean D(int i, long j) {
        return this.qmx.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.qmx.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.qmx.removeMessages(i);
    }

    public final void cs(Object obj) {
        this.qmx.removeCallbacksAndMessages(obj);
    }

    public final boolean RU(int i) {
        return this.qmx.hasMessages(i);
    }

    public final Message RV(int i) {
        return this.qmx.obtainMessage(i);
    }

    private RunnableC1116c O(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.qmy.a(aVar);
        return aVar.qmB;
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
    public static class RunnableC1116c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> qmC;

        RunnableC1116c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.qmC = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.qmC.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.eHH();
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
        a qmA;
        @NonNull
        final RunnableC1116c qmB;
        @Nullable
        a qmz;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.qmB = new RunnableC1116c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC1116c eHH() {
            this.lock.lock();
            try {
                if (this.qmA != null) {
                    this.qmA.qmz = this.qmz;
                }
                if (this.qmz != null) {
                    this.qmz.qmA = this.qmA;
                }
                this.qmA = null;
                this.qmz = null;
                this.lock.unlock();
                return this.qmB;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.qmz != null) {
                    this.qmz.qmA = aVar;
                }
                aVar.qmz = this.qmz;
                this.qmz = aVar;
                aVar.qmA = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC1116c P(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.qmz; aVar != null; aVar = aVar.qmz) {
                    if (aVar.runnable == runnable) {
                        return aVar.eHH();
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
