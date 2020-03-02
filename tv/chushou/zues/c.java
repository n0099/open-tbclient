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
    private final b nWm;
    @VisibleForTesting
    final a nWn;

    public c() {
        this.mLock = new ReentrantLock();
        this.nWn = new a(this.mLock, null);
        this.mCallback = null;
        this.nWm = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nWn = new a(this.mLock, null);
        this.mCallback = callback;
        this.nWm = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nWn = new a(this.mLock, null);
        this.mCallback = null;
        this.nWm = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nWn = new a(this.mLock, null);
        this.mCallback = callback;
        this.nWm = new b(looper, new WeakReference(callback));
    }

    public final boolean m(@NonNull Runnable runnable) {
        return this.nWm.post(I(runnable));
    }

    public final boolean d(Runnable runnable, long j) {
        return this.nWm.postDelayed(I(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        RunnableC0808c J = this.nWn.J(runnable);
        if (J != null) {
            this.nWm.removeCallbacks(J);
        }
    }

    public final boolean O(Message message) {
        return this.nWm.sendMessage(message);
    }

    public final boolean Of(int i) {
        return this.nWm.sendEmptyMessage(i);
    }

    public final boolean K(int i, long j) {
        return this.nWm.sendEmptyMessageDelayed(i, j);
    }

    public final boolean a(Message message, long j) {
        return this.nWm.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nWm.removeMessages(i);
    }

    public final void cq(Object obj) {
        this.nWm.removeCallbacksAndMessages(obj);
    }

    public final boolean Og(int i) {
        return this.nWm.hasMessages(i);
    }

    public final Message Oh(int i) {
        return this.nWm.obtainMessage(i);
    }

    private RunnableC0808c I(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nWn.a(aVar);
        return aVar.nWq;
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
        private final WeakReference<Runnable> nWr;

        RunnableC0808c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nWr = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nWr.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dQn();
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
        a nWo;
        @Nullable
        a nWp;
        @NonNull
        final RunnableC0808c nWq;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nWq = new RunnableC0808c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0808c dQn() {
            this.lock.lock();
            try {
                if (this.nWp != null) {
                    this.nWp.nWo = this.nWo;
                }
                if (this.nWo != null) {
                    this.nWo.nWp = this.nWp;
                }
                this.nWp = null;
                this.nWo = null;
                this.lock.unlock();
                return this.nWq;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nWo != null) {
                    this.nWo.nWp = aVar;
                }
                aVar.nWo = this.nWo;
                this.nWo = aVar;
                aVar.nWp = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0808c J(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nWo; aVar != null; aVar = aVar.nWo) {
                    if (aVar.runnable == runnable) {
                        return aVar.dQn();
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
