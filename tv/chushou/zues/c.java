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
    private final b nYk;
    @VisibleForTesting
    final a nYl;

    public c() {
        this.mLock = new ReentrantLock();
        this.nYl = new a(this.mLock, null);
        this.mCallback = null;
        this.nYk = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nYl = new a(this.mLock, null);
        this.mCallback = callback;
        this.nYk = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nYl = new a(this.mLock, null);
        this.mCallback = null;
        this.nYk = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nYl = new a(this.mLock, null);
        this.mCallback = callback;
        this.nYk = new b(looper, new WeakReference(callback));
    }

    public final boolean m(@NonNull Runnable runnable) {
        return this.nYk.post(I(runnable));
    }

    public final boolean d(Runnable runnable, long j) {
        return this.nYk.postDelayed(I(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        RunnableC0809c J = this.nYl.J(runnable);
        if (J != null) {
            this.nYk.removeCallbacks(J);
        }
    }

    public final boolean O(Message message) {
        return this.nYk.sendMessage(message);
    }

    public final boolean Ol(int i) {
        return this.nYk.sendEmptyMessage(i);
    }

    public final boolean K(int i, long j) {
        return this.nYk.sendEmptyMessageDelayed(i, j);
    }

    public final boolean a(Message message, long j) {
        return this.nYk.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nYk.removeMessages(i);
    }

    public final void cq(Object obj) {
        this.nYk.removeCallbacksAndMessages(obj);
    }

    public final boolean Om(int i) {
        return this.nYk.hasMessages(i);
    }

    public final Message On(int i) {
        return this.nYk.obtainMessage(i);
    }

    private RunnableC0809c I(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nYl.a(aVar);
        return aVar.nYo;
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
    public static class RunnableC0809c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> nYp;

        RunnableC0809c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nYp = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nYp.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dQO();
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
        a nYm;
        @Nullable
        a nYn;
        @NonNull
        final RunnableC0809c nYo;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nYo = new RunnableC0809c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0809c dQO() {
            this.lock.lock();
            try {
                if (this.nYn != null) {
                    this.nYn.nYm = this.nYm;
                }
                if (this.nYm != null) {
                    this.nYm.nYn = this.nYn;
                }
                this.nYn = null;
                this.nYm = null;
                this.lock.unlock();
                return this.nYo;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nYm != null) {
                    this.nYm.nYn = aVar;
                }
                aVar.nYm = this.nYm;
                this.nYm = aVar;
                aVar.nYn = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0809c J(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nYm; aVar != null; aVar = aVar.nYm) {
                    if (aVar.runnable == runnable) {
                        return aVar.dQO();
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
