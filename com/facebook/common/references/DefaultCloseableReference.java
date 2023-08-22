package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class DefaultCloseableReference<T> extends CloseableReference<T> {
    public static final String TAG = "DefaultCloseableReference";

    public DefaultCloseableReference(SharedReference<T> sharedReference, CloseableReference.LeakHandler leakHandler, @Nullable Throwable th) {
        super(sharedReference, leakHandler, th);
    }

    public DefaultCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.LeakHandler leakHandler, @Nullable Throwable th) {
        super(t, resourceReleaser, leakHandler, th);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.CloseableReference
    /* renamed from: clone */
    public CloseableReference<T> mo166clone() {
        Preconditions.checkState(isValid());
        return new DefaultCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
    }

    @Override // com.facebook.common.references.CloseableReference
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                FLog.w(TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), this.mSharedReference.get().getClass().getName());
                this.mLeakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                close();
            }
        } finally {
            super.finalize();
        }
    }
}
