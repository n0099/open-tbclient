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
    private final b osF;
    @VisibleForTesting
    final a osG;

    public c() {
        this.mLock = new ReentrantLock();
        this.osG = new a(this.mLock, null);
        this.mCallback = null;
        this.osF = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.osG = new a(this.mLock, null);
        this.mCallback = callback;
        this.osF = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.osG = new a(this.mLock, null);
        this.mCallback = null;
        this.osF = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.osG = new a(this.mLock, null);
        this.mCallback = callback;
        this.osF = new b(looper, new WeakReference(callback));
    }

    public final boolean r(@NonNull Runnable runnable) {
        return this.osF.post(P(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.osF.postDelayed(P(runnable), j);
    }

    public final void O(Runnable runnable) {
        RunnableC0951c Q = this.osG.Q(runnable);
        if (Q != null) {
            this.osF.removeCallbacks(Q);
        }
    }

    public final boolean R(Message message) {
        return this.osF.sendMessage(message);
    }

    public final boolean LT(int i) {
        return this.osF.sendEmptyMessage(i);
    }

    public final boolean B(int i, long j) {
        return this.osF.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.osF.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.osF.removeMessages(i);
    }

    public final void ch(Object obj) {
        this.osF.removeCallbacksAndMessages(obj);
    }

    public final boolean LU(int i) {
        return this.osF.hasMessages(i);
    }

    public final Message LV(int i) {
        return this.osF.obtainMessage(i);
    }

    private RunnableC0951c P(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.osG.a(aVar);
        return aVar.osJ;
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
    public static class RunnableC0951c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> osK;

        RunnableC0951c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.osK = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.osK.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dZY();
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
        a osH;
        @Nullable
        a osI;
        @NonNull
        final RunnableC0951c osJ;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.osJ = new RunnableC0951c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0951c dZY() {
            this.lock.lock();
            try {
                if (this.osI != null) {
                    this.osI.osH = this.osH;
                }
                if (this.osH != null) {
                    this.osH.osI = this.osI;
                }
                this.osI = null;
                this.osH = null;
                this.lock.unlock();
                return this.osJ;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.osH != null) {
                    this.osH.osI = aVar;
                }
                aVar.osH = this.osH;
                this.osH = aVar;
                aVar.osI = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0951c Q(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.osH; aVar != null; aVar = aVar.osH) {
                    if (aVar.runnable == runnable) {
                        return aVar.dZY();
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
