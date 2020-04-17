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
    private final b nrY;
    @VisibleForTesting
    final a nrZ;

    public c() {
        this.mLock = new ReentrantLock();
        this.nrZ = new a(this.mLock, null);
        this.mCallback = null;
        this.nrY = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nrZ = new a(this.mLock, null);
        this.mCallback = callback;
        this.nrY = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nrZ = new a(this.mLock, null);
        this.mCallback = null;
        this.nrY = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nrZ = new a(this.mLock, null);
        this.mCallback = callback;
        this.nrY = new b(looper, new WeakReference(callback));
    }

    public final boolean p(@NonNull Runnable runnable) {
        return this.nrY.post(O(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.nrY.postDelayed(O(runnable), j);
    }

    public final void N(Runnable runnable) {
        RunnableC0832c P = this.nrZ.P(runnable);
        if (P != null) {
            this.nrY.removeCallbacks(P);
        }
    }

    public final boolean N(Message message) {
        return this.nrY.sendMessage(message);
    }

    public final boolean JF(int i) {
        return this.nrY.sendEmptyMessage(i);
    }

    public final boolean A(int i, long j) {
        return this.nrY.sendEmptyMessageDelayed(i, j);
    }

    public final boolean a(Message message, long j) {
        return this.nrY.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nrY.removeMessages(i);
    }

    public final void bZ(Object obj) {
        this.nrY.removeCallbacksAndMessages(obj);
    }

    public final boolean JG(int i) {
        return this.nrY.hasMessages(i);
    }

    public final Message JH(int i) {
        return this.nrY.obtainMessage(i);
    }

    private RunnableC0832c O(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nrZ.a(aVar);
        return aVar.nsc;
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
    public static class RunnableC0832c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> nsd;

        RunnableC0832c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nsd = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nsd.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dJN();
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
        a nsa;
        @Nullable
        a nsb;
        @NonNull
        final RunnableC0832c nsc;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nsc = new RunnableC0832c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0832c dJN() {
            this.lock.lock();
            try {
                if (this.nsb != null) {
                    this.nsb.nsa = this.nsa;
                }
                if (this.nsa != null) {
                    this.nsa.nsb = this.nsb;
                }
                this.nsb = null;
                this.nsa = null;
                this.lock.unlock();
                return this.nsc;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nsa != null) {
                    this.nsa.nsb = aVar;
                }
                aVar.nsa = this.nsa;
                this.nsa = aVar;
                aVar.nsb = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0832c P(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nsa; aVar != null; aVar = aVar.nsa) {
                    if (aVar.runnable == runnable) {
                        return aVar.dJN();
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
