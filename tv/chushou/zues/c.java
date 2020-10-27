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
    private final b qdc;
    @VisibleForTesting
    final a qdd;

    public c() {
        this.mLock = new ReentrantLock();
        this.qdd = new a(this.mLock, null);
        this.mCallback = null;
        this.qdc = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.qdd = new a(this.mLock, null);
        this.mCallback = callback;
        this.qdc = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.qdd = new a(this.mLock, null);
        this.mCallback = null;
        this.qdc = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.qdd = new a(this.mLock, null);
        this.mCallback = callback;
        this.qdc = new b(looper, new WeakReference(callback));
    }

    public final boolean o(@NonNull Runnable runnable) {
        return this.qdc.post(O(runnable));
    }

    public final boolean f(Runnable runnable, long j) {
        return this.qdc.postDelayed(O(runnable), j);
    }

    public final void N(Runnable runnable) {
        RunnableC1096c P = this.qdd.P(runnable);
        if (P != null) {
            this.qdc.removeCallbacks(P);
        }
    }

    public final boolean X(Message message) {
        return this.qdc.sendMessage(message);
    }

    public final boolean Ry(int i) {
        return this.qdc.sendEmptyMessage(i);
    }

    public final boolean E(int i, long j) {
        return this.qdc.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.qdc.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.qdc.removeMessages(i);
    }

    public final void cs(Object obj) {
        this.qdc.removeCallbacksAndMessages(obj);
    }

    public final boolean Rz(int i) {
        return this.qdc.hasMessages(i);
    }

    public final Message RA(int i) {
        return this.qdc.obtainMessage(i);
    }

    private RunnableC1096c O(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.qdd.a(aVar);
        return aVar.qdg;
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
    public static class RunnableC1096c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> qdh;

        RunnableC1096c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.qdh = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.qdh.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.eDS();
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
        a qde;
        @Nullable
        a qdf;
        @NonNull
        final RunnableC1096c qdg;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.qdg = new RunnableC1096c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC1096c eDS() {
            this.lock.lock();
            try {
                if (this.qdf != null) {
                    this.qdf.qde = this.qde;
                }
                if (this.qde != null) {
                    this.qde.qdf = this.qdf;
                }
                this.qdf = null;
                this.qde = null;
                this.lock.unlock();
                return this.qdg;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.qde != null) {
                    this.qde.qdf = aVar;
                }
                aVar.qde = this.qde;
                this.qde = aVar;
                aVar.qdf = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC1096c P(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.qde; aVar != null; aVar = aVar.qde) {
                    if (aVar.runnable == runnable) {
                        return aVar.eDS();
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
