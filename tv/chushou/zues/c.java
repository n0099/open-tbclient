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
    private final b nWk;
    @VisibleForTesting
    final a nWl;

    public c() {
        this.mLock = new ReentrantLock();
        this.nWl = new a(this.mLock, null);
        this.mCallback = null;
        this.nWk = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nWl = new a(this.mLock, null);
        this.mCallback = callback;
        this.nWk = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nWl = new a(this.mLock, null);
        this.mCallback = null;
        this.nWk = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nWl = new a(this.mLock, null);
        this.mCallback = callback;
        this.nWk = new b(looper, new WeakReference(callback));
    }

    public final boolean m(@NonNull Runnable runnable) {
        return this.nWk.post(I(runnable));
    }

    public final boolean d(Runnable runnable, long j) {
        return this.nWk.postDelayed(I(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        RunnableC0808c J = this.nWl.J(runnable);
        if (J != null) {
            this.nWk.removeCallbacks(J);
        }
    }

    public final boolean O(Message message) {
        return this.nWk.sendMessage(message);
    }

    public final boolean Of(int i) {
        return this.nWk.sendEmptyMessage(i);
    }

    public final boolean K(int i, long j) {
        return this.nWk.sendEmptyMessageDelayed(i, j);
    }

    public final boolean a(Message message, long j) {
        return this.nWk.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nWk.removeMessages(i);
    }

    public final void cq(Object obj) {
        this.nWk.removeCallbacksAndMessages(obj);
    }

    public final boolean Og(int i) {
        return this.nWk.hasMessages(i);
    }

    public final Message Oh(int i) {
        return this.nWk.obtainMessage(i);
    }

    private RunnableC0808c I(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nWl.a(aVar);
        return aVar.nWo;
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
        private final WeakReference<Runnable> nWp;

        RunnableC0808c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nWp = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nWp.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dQl();
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
        a nWm;
        @Nullable
        a nWn;
        @NonNull
        final RunnableC0808c nWo;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nWo = new RunnableC0808c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0808c dQl() {
            this.lock.lock();
            try {
                if (this.nWn != null) {
                    this.nWn.nWm = this.nWm;
                }
                if (this.nWm != null) {
                    this.nWm.nWn = this.nWn;
                }
                this.nWn = null;
                this.nWm = null;
                this.lock.unlock();
                return this.nWo;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nWm != null) {
                    this.nWm.nWn = aVar;
                }
                aVar.nWm = this.nWm;
                this.nWm = aVar;
                aVar.nWn = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0808c J(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nWm; aVar != null; aVar = aVar.nWm) {
                    if (aVar.runnable == runnable) {
                        return aVar.dQl();
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
