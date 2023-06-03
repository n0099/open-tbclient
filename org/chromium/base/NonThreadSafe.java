package org.chromium.base;

import androidx.annotation.VisibleForTesting;
/* loaded from: classes2.dex */
public class NonThreadSafe {
    public Long mThreadId;

    public NonThreadSafe() {
        ensureThreadIdAssigned();
    }

    private void ensureThreadIdAssigned() {
        if (this.mThreadId == null) {
            this.mThreadId = Long.valueOf(Thread.currentThread().getId());
        }
    }

    public synchronized boolean calledOnValidThread() {
        ensureThreadIdAssigned();
        return this.mThreadId.equals(Long.valueOf(Thread.currentThread().getId()));
    }

    @VisibleForTesting
    public synchronized void detachFromThread() {
        this.mThreadId = null;
    }
}
