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
    private final b plN;
    @VisibleForTesting
    final a plO;

    public c() {
        this.mLock = new ReentrantLock();
        this.plO = new a(this.mLock, null);
        this.mCallback = null;
        this.plN = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.plO = new a(this.mLock, null);
        this.mCallback = callback;
        this.plN = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.plO = new a(this.mLock, null);
        this.mCallback = null;
        this.plN = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.plO = new a(this.mLock, null);
        this.mCallback = callback;
        this.plN = new b(looper, new WeakReference(callback));
    }

    public final boolean o(@NonNull Runnable runnable) {
        return this.plN.post(M(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.plN.postDelayed(M(runnable), j);
    }

    public final void L(Runnable runnable) {
        RunnableC1024c N = this.plO.N(runnable);
        if (N != null) {
            this.plN.removeCallbacks(N);
        }
    }

    public final boolean S(Message message) {
        return this.plN.sendMessage(message);
    }

    public final boolean PH(int i) {
        return this.plN.sendEmptyMessage(i);
    }

    public final boolean D(int i, long j) {
        return this.plN.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.plN.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.plN.removeMessages(i);
    }

    public final void co(Object obj) {
        this.plN.removeCallbacksAndMessages(obj);
    }

    public final boolean PI(int i) {
        return this.plN.hasMessages(i);
    }

    public final Message PJ(int i) {
        return this.plN.obtainMessage(i);
    }

    private RunnableC1024c M(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.plO.a(aVar);
        return aVar.plR;
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
    public static class RunnableC1024c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> plS;

        RunnableC1024c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.plS = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.plS.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.etU();
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
        a plP;
        @Nullable
        a plQ;
        @NonNull
        final RunnableC1024c plR;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.plR = new RunnableC1024c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC1024c etU() {
            this.lock.lock();
            try {
                if (this.plQ != null) {
                    this.plQ.plP = this.plP;
                }
                if (this.plP != null) {
                    this.plP.plQ = this.plQ;
                }
                this.plQ = null;
                this.plP = null;
                this.lock.unlock();
                return this.plR;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.plP != null) {
                    this.plP.plQ = aVar;
                }
                aVar.plP = this.plP;
                this.plP = aVar;
                aVar.plQ = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC1024c N(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.plP; aVar != null; aVar = aVar.plP) {
                    if (aVar.runnable == runnable) {
                        return aVar.etU();
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
