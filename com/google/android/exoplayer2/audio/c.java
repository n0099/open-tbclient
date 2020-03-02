package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;
@TargetApi(21)
/* loaded from: classes6.dex */
public final class c {
    public static final c maH = new c(new int[]{2}, 2);
    private final int[] maI;
    private final int maJ;

    public static c gq(Context context) {
        return aJ(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static c aJ(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return maH;
        }
        return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    c(int[] iArr, int i) {
        if (iArr != null) {
            this.maI = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.maI);
        } else {
            this.maI = new int[0];
        }
        this.maJ = i;
    }

    public boolean Jd(int i) {
        return Arrays.binarySearch(this.maI, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return Arrays.equals(this.maI, cVar.maI) && this.maJ == cVar.maJ;
        }
        return false;
    }

    public int hashCode() {
        return this.maJ + (Arrays.hashCode(this.maI) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maJ + ", supportedEncodings=" + Arrays.toString(this.maI) + "]";
    }
}
