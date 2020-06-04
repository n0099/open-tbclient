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
    private final b nOi;
    @VisibleForTesting
    final a nOj;

    public c() {
        this.mLock = new ReentrantLock();
        this.nOj = new a(this.mLock, null);
        this.mCallback = null;
        this.nOi = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nOj = new a(this.mLock, null);
        this.mCallback = callback;
        this.nOi = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nOj = new a(this.mLock, null);
        this.mCallback = null;
        this.nOi = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nOj = new a(this.mLock, null);
        this.mCallback = callback;
        this.nOi = new b(looper, new WeakReference(callback));
    }

    public final boolean r(@NonNull Runnable runnable) {
        return this.nOi.post(Q(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.nOi.postDelayed(Q(runnable), j);
    }

    public final void P(Runnable runnable) {
        RunnableC0916c R = this.nOj.R(runnable);
        if (R != null) {
            this.nOi.removeCallbacks(R);
        }
    }

    public final boolean R(Message message) {
        return this.nOi.sendMessage(message);
    }

    public final boolean Ks(int i) {
        return this.nOi.sendEmptyMessage(i);
    }

    public final boolean A(int i, long j) {
        return this.nOi.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.nOi.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nOi.removeMessages(i);
    }

    public final void cg(Object obj) {
        this.nOi.removeCallbacksAndMessages(obj);
    }

    public final boolean Kt(int i) {
        return this.nOi.hasMessages(i);
    }

    public final Message Ku(int i) {
        return this.nOi.obtainMessage(i);
    }

    private RunnableC0916c Q(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nOj.a(aVar);
        return aVar.nOm;
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
    public static class RunnableC0916c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> nOn;

        RunnableC0916c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nOn = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nOn.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dRS();
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
        a nOk;
        @Nullable
        a nOl;
        @NonNull
        final RunnableC0916c nOm;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nOm = new RunnableC0916c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0916c dRS() {
            this.lock.lock();
            try {
                if (this.nOl != null) {
                    this.nOl.nOk = this.nOk;
                }
                if (this.nOk != null) {
                    this.nOk.nOl = this.nOl;
                }
                this.nOl = null;
                this.nOk = null;
                this.lock.unlock();
                return this.nOm;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nOk != null) {
                    this.nOk.nOl = aVar;
                }
                aVar.nOk = this.nOk;
                this.nOk = aVar;
                aVar.nOl = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0916c R(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nOk; aVar != null; aVar = aVar.nOk) {
                    if (aVar.runnable == runnable) {
                        return aVar.dRS();
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
