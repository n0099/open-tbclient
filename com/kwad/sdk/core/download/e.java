package com.kwad.sdk.core.download;
/* loaded from: classes10.dex */
public final class e {
    public volatile boolean ast = false;

    public final void BX() {
        this.ast = true;
    }

    public final boolean BY() {
        if (!this.ast) {
            return true;
        }
        return false;
    }
}
