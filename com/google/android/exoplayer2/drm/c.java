package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
@TargetApi(16)
/* loaded from: classes4.dex */
public final class c implements b {
    private final MediaCrypto lZk;
    private final boolean lZl;

    public MediaCrypto dso() {
        return this.lZk;
    }

    public boolean OT(String str) {
        return !this.lZl && this.lZk.requiresSecureDecoderComponent(str);
    }
}
