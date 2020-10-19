package org.webrtc;

import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
class RefCountDelegate implements RefCounted {
    private final AtomicInteger refCount = new AtomicInteger(1);
    @Nullable
    private final Runnable releaseCallback;

    public RefCountDelegate(@Nullable Runnable runnable) {
        this.releaseCallback = runnable;
    }

    @Override // org.webrtc.RefCounted
    public void release() {
        if (this.refCount.decrementAndGet() != 0 || this.releaseCallback == null) {
            return;
        }
        this.releaseCallback.run();
    }

    @Override // org.webrtc.RefCounted
    public void retain() {
        this.refCount.incrementAndGet();
    }
}
