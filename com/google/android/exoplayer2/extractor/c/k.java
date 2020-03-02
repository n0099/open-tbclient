package com.google.android.exoplayer2.extractor.c;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.extractor.m;
/* loaded from: classes6.dex */
public final class k {
    public final m.a mgb;
    public final boolean mkE;
    public final int mkF;
    public final byte[] mkG;
    @Nullable
    public final String schemeType;

    public k(boolean z, @Nullable String str, int i, byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
        com.google.android.exoplayer2.util.a.checkArgument((bArr2 == null) ^ (i == 0));
        this.mkE = z;
        this.schemeType = str;
        this.mkF = i;
        this.mkG = bArr2;
        this.mgb = new m.a(Pt(str), bArr, i2, i3);
    }

    private static int Pt(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c = 2;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c = 3;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c = 0;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                Log.w("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                return 1;
        }
    }
}
