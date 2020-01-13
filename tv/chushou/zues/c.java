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
/* loaded from: classes4.dex */
public class c {
    private final Handler.Callback mCallback;
    private Lock mLock;
    private final b nVq;
    @VisibleForTesting
    final a nVr;

    public c() {
        this.mLock = new ReentrantLock();
        this.nVr = new a(this.mLock, null);
        this.mCallback = null;
        this.nVq = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nVr = new a(this.mLock, null);
        this.mCallback = callback;
        this.nVq = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nVr = new a(this.mLock, null);
        this.mCallback = null;
        this.nVq = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nVr = new a(this.mLock, null);
        this.mCallback = callback;
        this.nVq = new b(looper, new WeakReference(callback));
    }

    public final boolean m(@NonNull Runnable runnable) {
        return this.nVq.post(I(runnable));
    }

    public final boolean d(Runnable runnable, long j) {
        return this.nVq.postDelayed(I(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        RunnableC0800c J = this.nVr.J(runnable);
        if (J != null) {
            this.nVq.removeCallbacks(J);
        }
    }

    public final boolean O(Message message) {
        return this.nVq.sendMessage(message);
    }

    public final boolean Oc(int i) {
        return this.nVq.sendEmptyMessage(i);
    }

    public final boolean L(int i, long j) {
        return this.nVq.sendEmptyMessageDelayed(i, j);
    }

    public final boolean a(Message message, long j) {
        return this.nVq.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nVq.removeMessages(i);
    }

    public final void cp(Object obj) {
        this.nVq.removeCallbacksAndMessages(obj);
    }

    public final boolean Od(int i) {
        return this.nVq.hasMessages(i);
    }

    public final Message Oe(int i) {
        return this.nVq.obtainMessage(i);
    }

    private RunnableC0800c I(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nVr.a(aVar);
        return aVar.nVu;
    }

    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static class RunnableC0800c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> nVv;

        RunnableC0800c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nVv = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nVv.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dOW();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        @NonNull
        Lock lock;
        @Nullable
        a nVs;
        @Nullable
        a nVt;
        @NonNull
        final RunnableC0800c nVu;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nVu = new RunnableC0800c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0800c dOW() {
            this.lock.lock();
            try {
                if (this.nVt != null) {
                    this.nVt.nVs = this.nVs;
                }
                if (this.nVs != null) {
                    this.nVs.nVt = this.nVt;
                }
                this.nVt = null;
                this.nVs = null;
                this.lock.unlock();
                return this.nVu;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nVs != null) {
                    this.nVs.nVt = aVar;
                }
                aVar.nVs = this.nVs;
                this.nVs = aVar;
                aVar.nVt = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0800c J(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nVs; aVar != null; aVar = aVar.nVs) {
                    if (aVar.runnable == runnable) {
                        return aVar.dOW();
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
