package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;
@TargetApi(21)
/* loaded from: classes4.dex */
public final class c {
    public static final c lWc = new c(new int[]{2}, 2);
    private final int[] lWd;
    private final int lWe;

    public static c gq(Context context) {
        return aJ(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static c aJ(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return lWc;
        }
        return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    c(int[] iArr, int i) {
        if (iArr != null) {
            this.lWd = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.lWd);
        } else {
            this.lWd = new int[0];
        }
        this.lWe = i;
    }

    public boolean IP(int i) {
        return Arrays.binarySearch(this.lWd, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return Arrays.equals(this.lWd, cVar.lWd) && this.lWe == cVar.lWe;
        }
        return false;
    }

    public int hashCode() {
        return this.lWe + (Arrays.hashCode(this.lWd) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.lWe + ", supportedEncodings=" + Arrays.toString(this.lWd) + "]";
    }
}
