package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.chromium.base.annotations.CalledByNative;
/* loaded from: classes2.dex */
public class ThreadUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Object sLock = new Object();
    public static boolean sThreadAssertsDisabled;
    public static Handler sUiThreadHandler;
    public static boolean sWillOverride;

    /* loaded from: classes2.dex */
    public static class ThreadChecker {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public boolean mDestroyed;
        public final long mThreadId = Process.myTid();

        public void assertOnValidThread() {
        }

        public void assertOnValidThreadAndState() {
            assertOnValidThread();
            if (!this.mDestroyed) {
                return;
            }
            throw new IllegalStateException("Operation is not allowed after destroy().");
        }

        public void destroy() {
            assertOnValidThreadAndState();
            this.mDestroyed = true;
        }
    }

    public static void assertOnBackgroundThread() {
        if (sThreadAssertsDisabled) {
        }
    }

    public static void assertOnUiThread() {
        if (sThreadAssertsDisabled) {
        }
    }

    public static void checkUiThread() {
        if (!sThreadAssertsDisabled && !runningOnUiThread()) {
            throw new IllegalStateException("Must be called on the UI thread.");
        }
    }

    public static Handler getUiThreadHandler() {
        boolean z;
        synchronized (sLock) {
            if (sUiThreadHandler == null) {
                if (!sWillOverride) {
                    sUiThreadHandler = new Handler(Looper.getMainLooper());
                    z = true;
                } else {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
            } else {
                z = false;
            }
        }
        if (z) {
            TraceEvent.onUiThreadReady();
        }
        return sUiThreadHandler;
    }

    public static Looper getUiThreadLooper() {
        return getUiThreadHandler().getLooper();
    }

    public static boolean runningOnUiThread() {
        if (getUiThreadHandler().getLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    @CalledByNative
    public static boolean isThreadPriorityAudio(int i) {
        if (Process.getThreadPriority(i) == -16) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> futureTask) {
        getUiThreadHandler().post(futureTask);
        return futureTask;
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(Callable<T> callable) {
        return runOnUiThread(new FutureTask(callable));
    }

    @Deprecated
    public static <T> T runOnUiThreadBlocking(Callable<T> callable) throws ExecutionException {
        FutureTask futureTask = new FutureTask(callable);
        runOnUiThread(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted waiting for callable", e);
        }
    }

    @Deprecated
    public static <T> T runOnUiThreadBlockingNoException(Callable<T> callable) {
        try {
            return (T) runOnUiThreadBlocking(callable);
        } catch (ExecutionException e) {
            throw new RuntimeException("Error occurred waiting for callable", e);
        }
    }

    public static void setThreadAssertsDisabledForTesting(boolean z) {
        sThreadAssertsDisabled = z;
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int i) {
        Process.setThreadPriority(i, -16);
    }

    public static void setWillOverrideUiThread(boolean z) {
        synchronized (sLock) {
            sWillOverride = z;
        }
    }

    @Deprecated
    public static void postOnUiThread(Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> futureTask) {
        if (runningOnUiThread()) {
            futureTask.run();
        } else {
            postOnUiThread((FutureTask) futureTask);
        }
        return futureTask;
    }

    @Deprecated
    public static void runOnUiThreadBlocking(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        postOnUiThread(futureTask);
        try {
            futureTask.get();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred while waiting for runnable", e);
        }
    }

    @Deprecated
    public static void postOnUiThreadDelayed(Runnable runnable, long j) {
        getUiThreadHandler().postDelayed(runnable, j);
    }

    @Deprecated
    public static void runOnUiThread(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
        } else {
            getUiThreadHandler().post(runnable);
        }
    }

    public static void setUiThread(Looper looper) {
        synchronized (sLock) {
            if (looper == null) {
                sUiThreadHandler = null;
                return;
            }
            if (sUiThreadHandler != null && sUiThreadHandler.getLooper() != looper) {
                throw new RuntimeException("UI thread looper is already set to " + sUiThreadHandler.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + looper);
            }
            sUiThreadHandler = new Handler(looper);
            TraceEvent.onUiThreadReady();
        }
    }
}
