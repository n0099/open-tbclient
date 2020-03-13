package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class c implements b {
    private final MediaCrypto mea;
    private final boolean meb;

    public MediaCrypto duQ() {
        return this.mea;
    }

    public boolean Ps(String str) {
        return !this.meb && this.mea.requiresSecureDecoderComponent(str);
    }
}
