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
    private final b qoa;
    @VisibleForTesting
    final a qob;

    public c() {
        this.mLock = new ReentrantLock();
        this.qob = new a(this.mLock, null);
        this.mCallback = null;
        this.qoa = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.qob = new a(this.mLock, null);
        this.mCallback = callback;
        this.qoa = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.qob = new a(this.mLock, null);
        this.mCallback = null;
        this.qoa = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.qob = new a(this.mLock, null);
        this.mCallback = callback;
        this.qoa = new b(looper, new WeakReference(callback));
    }

    public final boolean o(@NonNull Runnable runnable) {
        return this.qoa.post(O(runnable));
    }

    public final boolean f(Runnable runnable, long j) {
        return this.qoa.postDelayed(O(runnable), j);
    }

    public final void N(Runnable runnable) {
        RunnableC1119c P = this.qob.P(runnable);
        if (P != null) {
            this.qoa.removeCallbacks(P);
        }
    }

    public final boolean X(Message message) {
        return this.qoa.sendMessage(message);
    }

    public final boolean Sv(int i) {
        return this.qoa.sendEmptyMessage(i);
    }

    public final boolean D(int i, long j) {
        return this.qoa.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.qoa.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.qoa.removeMessages(i);
    }

    public final void ct(Object obj) {
        this.qoa.removeCallbacksAndMessages(obj);
    }

    public final boolean Sw(int i) {
        return this.qoa.hasMessages(i);
    }

    public final Message Sx(int i) {
        return this.qoa.obtainMessage(i);
    }

    private RunnableC1119c O(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.qob.a(aVar);
        return aVar.qoe;
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
    public static class RunnableC1119c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> qof;

        RunnableC1119c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.qof = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.qof.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.eHI();
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
        a qoc;
        @Nullable
        a qod;
        @NonNull
        final RunnableC1119c qoe;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.qoe = new RunnableC1119c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC1119c eHI() {
            this.lock.lock();
            try {
                if (this.qod != null) {
                    this.qod.qoc = this.qoc;
                }
                if (this.qoc != null) {
                    this.qoc.qod = this.qod;
                }
                this.qod = null;
                this.qoc = null;
                this.lock.unlock();
                return this.qoe;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.qoc != null) {
                    this.qoc.qod = aVar;
                }
                aVar.qoc = this.qoc;
                this.qoc = aVar;
                aVar.qod = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC1119c P(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.qoc; aVar != null; aVar = aVar.qoc) {
                    if (aVar.runnable == runnable) {
                        return aVar.eHI();
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
