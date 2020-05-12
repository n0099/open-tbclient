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
    private final b nsb;
    @VisibleForTesting
    final a nsc;

    public c() {
        this.mLock = new ReentrantLock();
        this.nsc = new a(this.mLock, null);
        this.mCallback = null;
        this.nsb = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nsc = new a(this.mLock, null);
        this.mCallback = callback;
        this.nsb = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nsc = new a(this.mLock, null);
        this.mCallback = null;
        this.nsb = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nsc = new a(this.mLock, null);
        this.mCallback = callback;
        this.nsb = new b(looper, new WeakReference(callback));
    }

    public final boolean p(@NonNull Runnable runnable) {
        return this.nsb.post(O(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.nsb.postDelayed(O(runnable), j);
    }

    public final void N(Runnable runnable) {
        RunnableC0853c P = this.nsc.P(runnable);
        if (P != null) {
            this.nsb.removeCallbacks(P);
        }
    }

    public final boolean N(Message message) {
        return this.nsb.sendMessage(message);
    }

    public final boolean JF(int i) {
        return this.nsb.sendEmptyMessage(i);
    }

    public final boolean A(int i, long j) {
        return this.nsb.sendEmptyMessageDelayed(i, j);
    }

    public final boolean a(Message message, long j) {
        return this.nsb.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nsb.removeMessages(i);
    }

    public final void ca(Object obj) {
        this.nsb.removeCallbacksAndMessages(obj);
    }

    public final boolean JG(int i) {
        return this.nsb.hasMessages(i);
    }

    public final Message JH(int i) {
        return this.nsb.obtainMessage(i);
    }

    private RunnableC0853c O(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nsc.a(aVar);
        return aVar.nsf;
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
    public static class RunnableC0853c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> nsg;

        RunnableC0853c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nsg = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nsg.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dJK();
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
        a nsd;
        @Nullable
        a nse;
        @NonNull
        final RunnableC0853c nsf;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nsf = new RunnableC0853c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0853c dJK() {
            this.lock.lock();
            try {
                if (this.nse != null) {
                    this.nse.nsd = this.nsd;
                }
                if (this.nsd != null) {
                    this.nsd.nse = this.nse;
                }
                this.nse = null;
                this.nsd = null;
                this.lock.unlock();
                return this.nsf;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nsd != null) {
                    this.nsd.nse = aVar;
                }
                aVar.nsd = this.nsd;
                this.nsd = aVar;
                aVar.nse = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0853c P(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nsd; aVar != null; aVar = aVar.nsd) {
                    if (aVar.runnable == runnable) {
                        return aVar.dJK();
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
