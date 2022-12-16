package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.LifecycleObserver;
@Keep
/* loaded from: classes8.dex */
public class KsLifecycleObserver {
    public LifecycleObserver mBase;

    public LifecycleObserver getBase() {
        return this.mBase;
    }

    public void setBase(LifecycleObserver lifecycleObserver) {
        this.mBase = lifecycleObserver;
    }
}
