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
    private final b oWt;
    @VisibleForTesting
    final a oWu;

    public c() {
        this.mLock = new ReentrantLock();
        this.oWu = new a(this.mLock, null);
        this.mCallback = null;
        this.oWt = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.oWu = new a(this.mLock, null);
        this.mCallback = callback;
        this.oWt = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.oWu = new a(this.mLock, null);
        this.mCallback = null;
        this.oWt = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.oWu = new a(this.mLock, null);
        this.mCallback = callback;
        this.oWt = new b(looper, new WeakReference(callback));
    }

    public final boolean o(@NonNull Runnable runnable) {
        return this.oWt.post(M(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.oWt.postDelayed(M(runnable), j);
    }

    public final void L(Runnable runnable) {
        RunnableC1006c N = this.oWu.N(runnable);
        if (N != null) {
            this.oWt.removeCallbacks(N);
        }
    }

    public final boolean S(Message message) {
        return this.oWt.sendMessage(message);
    }

    public final boolean Pb(int i) {
        return this.oWt.sendEmptyMessage(i);
    }

    public final boolean C(int i, long j) {
        return this.oWt.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.oWt.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.oWt.removeMessages(i);
    }

    public final void cl(Object obj) {
        this.oWt.removeCallbacksAndMessages(obj);
    }

    public final boolean Pc(int i) {
        return this.oWt.hasMessages(i);
    }

    public final Message Pd(int i) {
        return this.oWt.obtainMessage(i);
    }

    private RunnableC1006c M(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.oWu.a(aVar);
        return aVar.oWx;
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
    public static class RunnableC1006c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> oWy;

        RunnableC1006c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.oWy = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.oWy.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.eqj();
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
        a oWv;
        @Nullable
        a oWw;
        @NonNull
        final RunnableC1006c oWx;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.oWx = new RunnableC1006c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC1006c eqj() {
            this.lock.lock();
            try {
                if (this.oWw != null) {
                    this.oWw.oWv = this.oWv;
                }
                if (this.oWv != null) {
                    this.oWv.oWw = this.oWw;
                }
                this.oWw = null;
                this.oWv = null;
                this.lock.unlock();
                return this.oWx;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.oWv != null) {
                    this.oWv.oWw = aVar;
                }
                aVar.oWv = this.oWv;
                this.oWv = aVar;
                aVar.oWw = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC1006c N(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.oWv; aVar != null; aVar = aVar.oWv) {
                    if (aVar.runnable == runnable) {
                        return aVar.eqj();
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
