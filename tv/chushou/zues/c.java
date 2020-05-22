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
    private final b nMY;
    @VisibleForTesting
    final a nMZ;

    public c() {
        this.mLock = new ReentrantLock();
        this.nMZ = new a(this.mLock, null);
        this.mCallback = null;
        this.nMY = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nMZ = new a(this.mLock, null);
        this.mCallback = callback;
        this.nMY = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nMZ = new a(this.mLock, null);
        this.mCallback = null;
        this.nMY = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nMZ = new a(this.mLock, null);
        this.mCallback = callback;
        this.nMY = new b(looper, new WeakReference(callback));
    }

    public final boolean r(@NonNull Runnable runnable) {
        return this.nMY.post(Q(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.nMY.postDelayed(Q(runnable), j);
    }

    public final void P(Runnable runnable) {
        RunnableC0915c R = this.nMZ.R(runnable);
        if (R != null) {
            this.nMY.removeCallbacks(R);
        }
    }

    public final boolean R(Message message) {
        return this.nMY.sendMessage(message);
    }

    public final boolean Kq(int i) {
        return this.nMY.sendEmptyMessage(i);
    }

    public final boolean A(int i, long j) {
        return this.nMY.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.nMY.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nMY.removeMessages(i);
    }

    public final void cg(Object obj) {
        this.nMY.removeCallbacksAndMessages(obj);
    }

    public final boolean Kr(int i) {
        return this.nMY.hasMessages(i);
    }

    public final Message Ks(int i) {
        return this.nMY.obtainMessage(i);
    }

    private RunnableC0915c Q(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nMZ.a(aVar);
        return aVar.nNc;
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
    public static class RunnableC0915c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> nNd;

        RunnableC0915c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nNd = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nNd.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dRE();
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
        a nNa;
        @Nullable
        a nNb;
        @NonNull
        final RunnableC0915c nNc;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nNc = new RunnableC0915c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0915c dRE() {
            this.lock.lock();
            try {
                if (this.nNb != null) {
                    this.nNb.nNa = this.nNa;
                }
                if (this.nNa != null) {
                    this.nNa.nNb = this.nNb;
                }
                this.nNb = null;
                this.nNa = null;
                this.lock.unlock();
                return this.nNc;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nNa != null) {
                    this.nNa.nNb = aVar;
                }
                aVar.nNa = this.nNa;
                this.nNa = aVar;
                aVar.nNb = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0915c R(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nNa; aVar != null; aVar = aVar.nNa) {
                    if (aVar.runnable == runnable) {
                        return aVar.dRE();
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
