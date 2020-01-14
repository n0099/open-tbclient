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
    private final b nVv;
    @VisibleForTesting
    final a nVw;

    public c() {
        this.mLock = new ReentrantLock();
        this.nVw = new a(this.mLock, null);
        this.mCallback = null;
        this.nVv = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nVw = new a(this.mLock, null);
        this.mCallback = callback;
        this.nVv = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.nVw = new a(this.mLock, null);
        this.mCallback = null;
        this.nVv = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.nVw = new a(this.mLock, null);
        this.mCallback = callback;
        this.nVv = new b(looper, new WeakReference(callback));
    }

    public final boolean m(@NonNull Runnable runnable) {
        return this.nVv.post(I(runnable));
    }

    public final boolean d(Runnable runnable, long j) {
        return this.nVv.postDelayed(I(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        RunnableC0800c J = this.nVw.J(runnable);
        if (J != null) {
            this.nVv.removeCallbacks(J);
        }
    }

    public final boolean O(Message message) {
        return this.nVv.sendMessage(message);
    }

    public final boolean Oc(int i) {
        return this.nVv.sendEmptyMessage(i);
    }

    public final boolean L(int i, long j) {
        return this.nVv.sendEmptyMessageDelayed(i, j);
    }

    public final boolean a(Message message, long j) {
        return this.nVv.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.nVv.removeMessages(i);
    }

    public final void cp(Object obj) {
        this.nVv.removeCallbacksAndMessages(obj);
    }

    public final boolean Od(int i) {
        return this.nVv.hasMessages(i);
    }

    public final Message Oe(int i) {
        return this.nVv.obtainMessage(i);
    }

    private RunnableC0800c I(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.nVw.a(aVar);
        return aVar.nVz;
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
        private final WeakReference<Runnable> nVA;

        RunnableC0800c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.nVA = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.nVA.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dOY();
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
        a nVx;
        @Nullable
        a nVy;
        @NonNull
        final RunnableC0800c nVz;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.nVz = new RunnableC0800c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0800c dOY() {
            this.lock.lock();
            try {
                if (this.nVy != null) {
                    this.nVy.nVx = this.nVx;
                }
                if (this.nVx != null) {
                    this.nVx.nVy = this.nVy;
                }
                this.nVy = null;
                this.nVx = null;
                this.lock.unlock();
                return this.nVz;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.nVx != null) {
                    this.nVx.nVy = aVar;
                }
                aVar.nVx = this.nVx;
                this.nVx = aVar;
                aVar.nVy = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0800c J(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.nVx; aVar != null; aVar = aVar.nVx) {
                    if (aVar.runnable == runnable) {
                        return aVar.dOY();
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
