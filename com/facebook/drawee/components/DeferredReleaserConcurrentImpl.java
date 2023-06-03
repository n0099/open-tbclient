package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.facebook.drawee.components.DeferredReleaser;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class DeferredReleaserConcurrentImpl extends DeferredReleaser {
    public final Object mLock = new Object();
    public final Runnable releaseRunnable = new Runnable() { // from class: com.facebook.drawee.components.DeferredReleaserConcurrentImpl.1
        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            synchronized (DeferredReleaserConcurrentImpl.this.mLock) {
                ArrayList arrayList = DeferredReleaserConcurrentImpl.this.mTempList;
                DeferredReleaserConcurrentImpl.this.mTempList = DeferredReleaserConcurrentImpl.this.mPendingReleasables;
                DeferredReleaserConcurrentImpl.this.mPendingReleasables = arrayList;
            }
            int size = DeferredReleaserConcurrentImpl.this.mTempList.size();
            for (int i = 0; i < size; i++) {
                ((DeferredReleaser.Releasable) DeferredReleaserConcurrentImpl.this.mTempList.get(i)).release();
            }
            DeferredReleaserConcurrentImpl.this.mTempList.clear();
        }
    };
    public ArrayList<DeferredReleaser.Releasable> mPendingReleasables = new ArrayList<>();
    public ArrayList<DeferredReleaser.Releasable> mTempList = new ArrayList<>();
    public final Handler mUiHandler = new Handler(Looper.getMainLooper());

    @Override // com.facebook.drawee.components.DeferredReleaser
    @AnyThread
    public void cancelDeferredRelease(DeferredReleaser.Releasable releasable) {
        synchronized (this.mLock) {
            this.mPendingReleasables.remove(releasable);
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    @AnyThread
    public void scheduleDeferredRelease(DeferredReleaser.Releasable releasable) {
        if (!DeferredReleaser.isOnUiThread()) {
            releasable.release();
            return;
        }
        synchronized (this.mLock) {
            if (this.mPendingReleasables.contains(releasable)) {
                return;
            }
            this.mPendingReleasables.add(releasable);
            boolean z = true;
            if (this.mPendingReleasables.size() != 1) {
                z = false;
            }
            if (z) {
                this.mUiHandler.post(this.releaseRunnable);
            }
        }
    }
}
