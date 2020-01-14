package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
@TargetApi(16)
/* loaded from: classes5.dex */
public final class c implements b {
    private final MediaCrypto mdh;
    private final boolean mdi;

    public MediaCrypto dtC() {
        return this.mdh;
    }

    public boolean Pe(String str) {
        return !this.mdi && this.mdh.requiresSecureDecoderComponent(str);
    }
}
