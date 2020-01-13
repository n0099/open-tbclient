package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;
@TargetApi(21)
/* loaded from: classes5.dex */
public final class c {
    public static final c lZR = new c(new int[]{2}, 2);
    private final int[] lZS;
    private final int lZT;

    public static c gr(Context context) {
        return aJ(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static c aJ(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return lZR;
        }
        return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    c(int[] iArr, int i) {
        if (iArr != null) {
            this.lZS = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.lZS);
        } else {
            this.lZS = new int[0];
        }
        this.lZT = i;
    }

    public boolean IY(int i) {
        return Arrays.binarySearch(this.lZS, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return Arrays.equals(this.lZS, cVar.lZS) && this.lZT == cVar.lZT;
        }
        return false;
    }

    public int hashCode() {
        return this.lZT + (Arrays.hashCode(this.lZS) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.lZT + ", supportedEncodings=" + Arrays.toString(this.lZS) + "]";
    }
}
