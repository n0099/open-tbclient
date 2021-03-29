package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class NoOpCloseableReferenceLeakTracker implements CloseableReferenceLeakTracker {
    @Override // com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker
    public void setListener(@Nullable CloseableReferenceLeakTracker.Listener listener) {
    }

    @Override // com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker
    public void trackCloseableReferenceLeak(SharedReference<Object> sharedReference) {
    }
}
