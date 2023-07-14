package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class RefCountCloseableReference<T> extends CloseableReference<T> {
    public RefCountCloseableReference(SharedReference<T> sharedReference, CloseableReference.LeakHandler leakHandler, @Nullable Throwable th) {
        super(sharedReference, leakHandler, th);
    }

    public RefCountCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.LeakHandler leakHandler, @Nullable Throwable th) {
        super(t, resourceReleaser, leakHandler, th);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.CloseableReference
    /* renamed from: clone */
    public CloseableReference<T> mo163clone() {
        Preconditions.checkState(isValid());
        return new RefCountCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
    }
}
