package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class DeferredReleaser {
    @Nullable
    public static DeferredReleaser sInstance;
    public final Runnable releaseRunnable = new Runnable() { // from class: com.facebook.drawee.components.DeferredReleaser.1
        @Override // java.lang.Runnable
        public void run() {
            DeferredReleaser.ensureOnUiThread();
            for (Releasable releasable : DeferredReleaser.this.mPendingReleasables) {
                releasable.release();
            }
            DeferredReleaser.this.mPendingReleasables.clear();
        }
    };
    public final Set<Releasable> mPendingReleasables = new HashSet();
    public final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public interface Releasable {
        void release();
    }

    public static void ensureOnUiThread() {
        Preconditions.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }

    public static synchronized DeferredReleaser getInstance() {
        DeferredReleaser deferredReleaser;
        synchronized (DeferredReleaser.class) {
            if (sInstance == null) {
                sInstance = new DeferredReleaser();
            }
            deferredReleaser = sInstance;
        }
        return deferredReleaser;
    }

    public void cancelDeferredRelease(Releasable releasable) {
        ensureOnUiThread();
        this.mPendingReleasables.remove(releasable);
    }

    public void scheduleDeferredRelease(Releasable releasable) {
        ensureOnUiThread();
        if (this.mPendingReleasables.add(releasable) && this.mPendingReleasables.size() == 1) {
            this.mUiHandler.post(this.releaseRunnable);
        }
    }
}
