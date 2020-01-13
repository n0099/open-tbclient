package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
@TargetApi(16)
/* loaded from: classes5.dex */
public final class c implements b {
    private final MediaCrypto mdc;
    private final boolean mdd;

    public MediaCrypto dtA() {
        return this.mdc;
    }

    public boolean Pe(String str) {
        return !this.mdd && this.mdc.requiresSecureDecoderComponent(str);
    }
}
