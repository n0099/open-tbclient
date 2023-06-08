package org.chromium.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.tkb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public final class CallbackController {
    @Nullable
    @GuardedBy("mReadWriteLock")
    public ArrayList<WeakReference<Cancelable>> mCancelables = new ArrayList<>();
    public final ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock(true);

    /* loaded from: classes2.dex */
    public interface Cancelable {
        void cancel();
    }

    /* loaded from: classes2.dex */
    public static class AutoCloseableLock implements AutoCloseable {
        public boolean mIsLocked;
        public final Lock mLock;

        public AutoCloseableLock(Lock lock, boolean z) {
            this.mLock = lock;
            this.mIsLocked = z;
        }

        public static AutoCloseableLock lock(Lock lock) {
            lock.lock();
            return new AutoCloseableLock(lock, true);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.mIsLocked) {
                this.mIsLocked = false;
                this.mLock.unlock();
                return;
            }
            throw new IllegalStateException("mLock isn't locked.");
        }
    }

    /* loaded from: classes2.dex */
    public class CancelableCallback<T> implements Cancelable, Callback<T> {
        @GuardedBy("mReadWriteLock")
        public Callback<T> mCallback;

        @Override // org.chromium.base.Callback
        public /* synthetic */ Runnable bind(T t) {
            return tkb.$default$bind(this, t);
        }

        public CancelableCallback(@NonNull Callback<T> callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mCallback = null;
        }

        @Override // org.chromium.base.Callback
        public void onResult(T t) {
            AutoCloseableLock lock = AutoCloseableLock.lock(CallbackController.this.mReadWriteLock.readLock());
            try {
                if (this.mCallback != null) {
                    this.mCallback.onResult(t);
                }
                if (lock != null) {
                    lock.close();
                }
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class CancelableRunnable implements Cancelable, Runnable {
        @GuardedBy("mReadWriteLock")
        public Runnable mRunnable;

        public CancelableRunnable(@NonNull Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mRunnable = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoCloseableLock lock = AutoCloseableLock.lock(CallbackController.this.mReadWriteLock.readLock());
            try {
                if (this.mRunnable != null) {
                    this.mRunnable.run();
                }
                if (lock != null) {
                    lock.close();
                }
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @GuardedBy("mReadWriteLock")
    private void checkNotCanceled() {
        if (this.mCancelables != null) {
            return;
        }
        throw new IllegalStateException("This CallbackController has already been destroyed.");
    }

    public Runnable makeCancelable(@NonNull Runnable runnable) {
        AutoCloseableLock lock = AutoCloseableLock.lock(this.mReadWriteLock.writeLock());
        try {
            checkNotCanceled();
            CancelableRunnable cancelableRunnable = new CancelableRunnable(runnable);
            this.mCancelables.add(new WeakReference<>(cancelableRunnable));
            if (lock != null) {
                lock.close();
            }
            return cancelableRunnable;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void destroy() {
        AutoCloseableLock lock = AutoCloseableLock.lock(this.mReadWriteLock.writeLock());
        try {
            checkNotCanceled();
            for (Cancelable cancelable : CollectionUtil.strengthen(this.mCancelables)) {
                cancelable.cancel();
            }
            this.mCancelables = null;
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public <T> Callback<T> makeCancelable(@NonNull Callback<T> callback) {
        AutoCloseableLock lock = AutoCloseableLock.lock(this.mReadWriteLock.writeLock());
        try {
            checkNotCanceled();
            CancelableCallback cancelableCallback = new CancelableCallback(callback);
            this.mCancelables.add(new WeakReference<>(cancelableCallback));
            if (lock != null) {
                lock.close();
            }
            return cancelableCallback;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
