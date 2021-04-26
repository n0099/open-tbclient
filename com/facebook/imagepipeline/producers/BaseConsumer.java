package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public abstract class BaseConsumer<T> implements Consumer<T> {
    public boolean mIsFinished = false;

    public static boolean isLast(int i2) {
        return (i2 & 1) == 1;
    }

    public static boolean isNotLast(int i2) {
        return !isLast(i2);
    }

    public static int simpleStatusForIsLast(boolean z) {
        return z ? 1 : 0;
    }

    public static boolean statusHasAnyFlag(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static boolean statusHasFlag(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static int turnOffStatusFlag(int i2, int i3) {
        return i2 & (~i3);
    }

    public static int turnOnStatusFlag(int i2, int i3) {
        return i2 | i3;
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onCancellation() {
        if (this.mIsFinished) {
            return;
        }
        this.mIsFinished = true;
        try {
            onCancellationImpl();
        } catch (Exception e2) {
            onUnhandledException(e2);
        }
    }

    public abstract void onCancellationImpl();

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onFailure(Throwable th) {
        if (this.mIsFinished) {
            return;
        }
        this.mIsFinished = true;
        try {
            onFailureImpl(th);
        } catch (Exception e2) {
            onUnhandledException(e2);
        }
    }

    public abstract void onFailureImpl(Throwable th);

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onNewResult(@Nullable T t, int i2) {
        if (this.mIsFinished) {
            return;
        }
        this.mIsFinished = isLast(i2);
        try {
            onNewResultImpl(t, i2);
        } catch (Exception e2) {
            onUnhandledException(e2);
        }
    }

    public abstract void onNewResultImpl(T t, int i2);

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onProgressUpdate(float f2) {
        if (this.mIsFinished) {
            return;
        }
        try {
            onProgressUpdateImpl(f2);
        } catch (Exception e2) {
            onUnhandledException(e2);
        }
    }

    public void onProgressUpdateImpl(float f2) {
    }

    public void onUnhandledException(Exception exc) {
        FLog.wtf(getClass(), "unhandled exception", exc);
    }
}
