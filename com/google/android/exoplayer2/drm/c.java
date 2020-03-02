package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class c implements b {
    private final MediaCrypto mdP;
    private final boolean mdQ;

    public MediaCrypto duP() {
        return this.mdP;
    }

    public boolean Pr(String str) {
        return !this.mdQ && this.mdP.requiresSecureDecoderComponent(str);
    }
}
