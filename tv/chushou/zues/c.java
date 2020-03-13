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
    private final b nWx;
    @VisibleForTesting
    final a nWy;

    public c() {
        this.mLock = new ReentrantLock();
        this.nWy = new a(this.mLock, null);
        this.mCallback = null;
        this.nWx = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nWy = new a(this.mLock, null);
        this.mCallback = callback;
        this.nWx = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nWy = new a(this.mLock, null);
        this.mCallback = null;
        this.nWx = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nWy = new a(this.mLock, null);
        this.mCallback = callback;
        this.nWx = new b(looper, new WeakReference(callback));
    }

    public final boolean m(@NonNull Runnable runnable) {
        return this.nWx.post(I(runnable));
    }

    public final boolean d(Runnable runnable, long j) {
        return this.nWx.postDelayed(I(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        RunnableC0808c J = this.nWy.J(runnable);
        if (J != null) {
            this.nWx.removeCallbacks(J);
        }
    }

    public final boolean O(Message message) {
        return this.nWx.sendMessage(message);
    }

    public final boolean Of(int i) {
        return this.nWx.sendEmptyMessage(i);
    }

    public final boolean K(int i, long j) {
        return this.nWx.sendEmptyMessageDelayed(i, j);
    }

    public final boolean a(Message message, long j) {
        return this.nWx.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nWx.removeMessages(i);
    }

    public final void cq(Object obj) {
        this.nWx.removeCallbacksAndMessages(obj);
    }

    public final boolean Og(int i) {
        return this.nWx.hasMessages(i);
    }

    public final Message Oh(int i) {
        return this.nWx.obtainMessage(i);
    }

    private RunnableC0808c I(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nWy.a(aVar);
        return aVar.nWB;
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
    public static class RunnableC0808c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> nWC;

        RunnableC0808c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nWC = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nWC.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dQo();
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
        a nWA;
        @NonNull
        final RunnableC0808c nWB;
        @Nullable
        a nWz;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nWB = new RunnableC0808c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0808c dQo() {
            this.lock.lock();
            try {
                if (this.nWA != null) {
                    this.nWA.nWz = this.nWz;
                }
                if (this.nWz != null) {
                    this.nWz.nWA = this.nWA;
                }
                this.nWA = null;
                this.nWz = null;
                this.lock.unlock();
                return this.nWB;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nWz != null) {
                    this.nWz.nWA = aVar;
                }
                aVar.nWz = this.nWz;
                this.nWz = aVar;
                aVar.nWA = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0808c J(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nWz; aVar != null; aVar = aVar.nWz) {
                    if (aVar.runnable == runnable) {
                        return aVar.dQo();
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
