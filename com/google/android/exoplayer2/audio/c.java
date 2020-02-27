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
    public static final c maF = new c(new int[]{2}, 2);
    private final int[] maG;
    private final int maH;

    public static c gq(Context context) {
        return aJ(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static c aJ(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return maF;
        }
        return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    c(int[] iArr, int i) {
        if (iArr != null) {
            this.maG = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.maG);
        } else {
            this.maG = new int[0];
        }
        this.maH = i;
    }

    public boolean Jd(int i) {
        return Arrays.binarySearch(this.maG, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return Arrays.equals(this.maG, cVar.maG) && this.maH == cVar.maH;
        }
        return false;
    }

    public int hashCode() {
        return this.maH + (Arrays.hashCode(this.maG) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maH + ", supportedEncodings=" + Arrays.toString(this.maG) + "]";
    }
}
