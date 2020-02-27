package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class c implements b {
    private final MediaCrypto mdN;
    private final boolean mdO;

    public MediaCrypto duN() {
        return this.mdN;
    }

    public boolean Pr(String str) {
        return !this.mdO && this.mdN.requiresSecureDecoderComponent(str);
    }
}
