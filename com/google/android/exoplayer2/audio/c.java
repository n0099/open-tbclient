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
    public static final c maS = new c(new int[]{2}, 2);
    private final int[] maT;
    private final int maU;

    public static c gq(Context context) {
        return aJ(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static c aJ(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return maS;
        }
        return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    c(int[] iArr, int i) {
        if (iArr != null) {
            this.maT = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.maT);
        } else {
            this.maT = new int[0];
        }
        this.maU = i;
    }

    public boolean Jd(int i) {
        return Arrays.binarySearch(this.maT, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return Arrays.equals(this.maT, cVar.maT) && this.maU == cVar.maU;
        }
        return false;
    }

    public int hashCode() {
        return this.maU + (Arrays.hashCode(this.maT) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maU + ", supportedEncodings=" + Arrays.toString(this.maT) + "]";
    }
}
