package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes.dex */
public abstract class BaseConsumer<T> implements Consumer<T> {
    public boolean mIsFinished = false;

    public static boolean isLast(int i) {
        return (i & 1) == 1;
    }

    public static boolean isNotLast(int i) {
        return !isLast(i);
    }

    public static int simpleStatusForIsLast(boolean z) {
        return z ? 1 : 0;
    }

    public static boolean statusHasAnyFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean statusHasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static int turnOffStatusFlag(int i, int i2) {
        return i & (i2 ^ (-1));
    }

    public static int turnOnStatusFlag(int i, int i2) {
        return i | i2;
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
    public synchronized void onNewResult(@Nullable T t, int i) {
        if (this.mIsFinished) {
            return;
        }
        this.mIsFinished = isLast(i);
        try {
            onNewResultImpl(t, i);
        } catch (Exception e2) {
            onUnhandledException(e2);
        }
    }

    public abstract void onNewResultImpl(T t, int i);

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
