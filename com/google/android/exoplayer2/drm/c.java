package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class c implements b {
    private final MediaCrypto mfG;
    private final boolean mfH;

    public MediaCrypto dvn() {
        return this.mfG;
    }

    public boolean Ps(String str) {
        return !this.mfH && this.mfG.requiresSecureDecoderComponent(str);
    }
}
