package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public interface CloseableReferenceLeakTracker {

    /* loaded from: classes12.dex */
    public interface Listener {
        void onCloseableReferenceLeak(SharedReference<Object> sharedReference);
    }

    void setListener(@Nullable Listener listener);

    void trackCloseableReferenceLeak(SharedReference<Object> sharedReference);
}
