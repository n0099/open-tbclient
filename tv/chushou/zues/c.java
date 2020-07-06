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
    private final b ojZ;
    @VisibleForTesting
    final a oka;

    public c() {
        this.mLock = new ReentrantLock();
        this.oka = new a(this.mLock, null);
        this.mCallback = null;
        this.ojZ = new b();
    }

    public c(@Nullable Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.oka = new a(this.mLock, null);
        this.mCallback = callback;
        this.ojZ = new b(new WeakReference(callback));
    }

    public c(@NonNull Looper looper) {
        this.mLock = new ReentrantLock();
        this.oka = new a(this.mLock, null);
        this.mCallback = null;
        this.ojZ = new b(looper);
    }

    public c(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        this.mLock = new ReentrantLock();
        this.oka = new a(this.mLock, null);
        this.mCallback = callback;
        this.ojZ = new b(looper, new WeakReference(callback));
    }

    public final boolean r(@NonNull Runnable runnable) {
        return this.ojZ.post(Q(runnable));
    }

    public final boolean e(Runnable runnable, long j) {
        return this.ojZ.postDelayed(Q(runnable), j);
    }

    public final void P(Runnable runnable) {
        RunnableC0936c R = this.oka.R(runnable);
        if (R != null) {
            this.ojZ.removeCallbacks(R);
        }
    }

    public final boolean R(Message message) {
        return this.ojZ.sendMessage(message);
    }

    public final boolean Lz(int i) {
        return this.ojZ.sendEmptyMessage(i);
    }

    public final boolean B(int i, long j) {
        return this.ojZ.sendEmptyMessageDelayed(i, j);
    }

    public final boolean b(Message message, long j) {
        return this.ojZ.sendMessageDelayed(message, j);
    }

    public final void removeMessages(int i) {
        this.ojZ.removeMessages(i);
    }

    public final void ch(Object obj) {
        this.ojZ.removeCallbacksAndMessages(obj);
    }

    public final boolean LA(int i) {
        return this.ojZ.hasMessages(i);
    }

    public final Message LB(int i) {
        return this.ojZ.obtainMessage(i);
    }

    private RunnableC0936c Q(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.mLock, runnable);
        this.oka.a(aVar);
        return aVar.okd;
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
    public static class RunnableC0936c implements Runnable {
        private final WeakReference<a> mReference;
        private final WeakReference<Runnable> oke;

        RunnableC0936c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.oke = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.oke.get();
            a aVar = this.mReference.get();
            if (aVar != null) {
                aVar.dWC();
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
        a okb;
        @Nullable
        a okc;
        @NonNull
        final RunnableC0936c okd;
        @NonNull
        final Runnable runnable;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.okd = new RunnableC0936c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0936c dWC() {
            this.lock.lock();
            try {
                if (this.okc != null) {
                    this.okc.okb = this.okb;
                }
                if (this.okb != null) {
                    this.okb.okc = this.okc;
                }
                this.okc = null;
                this.okb = null;
                this.lock.unlock();
                return this.okd;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public void a(@NonNull a aVar) {
            this.lock.lock();
            try {
                if (this.okb != null) {
                    this.okb.okc = aVar;
                }
                aVar.okb = this.okb;
                this.okb = aVar;
                aVar.okc = this;
            } finally {
                this.lock.unlock();
            }
        }

        @Nullable
        public RunnableC0936c R(Runnable runnable) {
            this.lock.lock();
            try {
                for (a aVar = this.okb; aVar != null; aVar = aVar.okb) {
                    if (aVar.runnable == runnable) {
                        return aVar.dWC();
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
