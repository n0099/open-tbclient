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
/* loaded from: classes5.dex */
public class c {
    private final Handler.Callback mCallback;
    private Lock mLock;
    private final b ojW;
    @VisibleForTesting
    final a ojX;

    public c() {
        this.mLock = new ReentrantLock();
        this.ojX = new a(this.mLock, null);
        this.mCallback = null;
        this.ojW = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.ojX = new a(this.mLock, null);
        this.mCallback = callback;
        this.ojW = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.ojX = new a(this.mLock, null);
        this.mCallback = null;
        this.ojW = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.ojX = new a(this.mLock, null);
        this.mCallback = callback;
        this.ojW = new b(looper, new WeakReference(callback));
    }

    public final boolean r(@NonNull Runnable runnable) {
        return this.ojW.post(Q(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.ojW.postDelayed(Q(runnable), j);
    }

    public final void P(Runnable runnable) {
        RunnableC0935c R = this.ojX.R(runnable);
        if (R != null) {
            this.ojW.removeCallbacks(R);
        }
    }

    public final boolean R(Message message) {
        return this.ojW.sendMessage(message);
    }

    public final boolean Lz(int i) {
        return this.ojW.sendEmptyMessage(i);
    }

    public final boolean B(int i, long j) {
        return this.ojW.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.ojW.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.ojW.removeMessages(i);
    }

    public final void ch(Object obj) {
        this.ojW.removeCallbacksAndMessages(obj);
    }

    public final boolean LA(int i) {
        return this.ojW.hasMessages(i);
    }

    public final Message LB(int i) {
        return this.ojW.obtainMessage(i);
    }

    private RunnableC0935c Q(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.ojX.a(aVar);
        return aVar.oka;
    }

    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public static class RunnableC0935c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> okb;

        RunnableC0935c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.okb = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.okb.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dWy();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        @NonNull
        Lock lock;
        @Nullable
        a ojY;
        @Nullable
        a ojZ;
        @NonNull
        final RunnableC0935c oka;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.oka = new RunnableC0935c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0935c dWy() {
            this.lock.lock();
            try {
                if (this.ojZ != null) {
                    this.ojZ.ojY = this.ojY;
                }
                if (this.ojY != null) {
                    this.ojY.ojZ = this.ojZ;
                }
                this.ojZ = null;
                this.ojY = null;
                this.lock.unlock();
                return this.oka;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.ojY != null) {
                    this.ojY.ojZ = aVar;
                }
                aVar.ojY = this.ojY;
                this.ojY = aVar;
                aVar.ojZ = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0935c R(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.ojY; aVar != null; aVar = aVar.ojY) {
                    if (aVar.runnable == runnable) {
                        return aVar.dWy();
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
