package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface CloseableReferenceLeakTracker {

    /* loaded from: classes7.dex */
    public interface Listener {
        void onCloseableReferenceLeak(SharedReference sharedReference, @Nullable Throwable th);
    }

    boolean isSet();

    void setListener(@Nullable Listener listener);

    void trackCloseableReferenceLeak(SharedReference sharedReference, @Nullable Throwable th);
}
