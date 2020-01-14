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
    public static final c lZW = new c(new int[]{2}, 2);
    private final int[] lZX;
    private final int lZY;

    public static c gr(Context context) {
        return aJ(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static c aJ(Intent intent) {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return lZW;
        }
        return new c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    c(int[] iArr, int i) {
        if (iArr != null) {
            this.lZX = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.lZX);
        } else {
            this.lZX = new int[0];
        }
        this.lZY = i;
    }

    public boolean IY(int i) {
        return Arrays.binarySearch(this.lZX, i) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return Arrays.equals(this.lZX, cVar.lZX) && this.lZY == cVar.lZY;
        }
        return false;
    }

    public int hashCode() {
        return this.lZY + (Arrays.hashCode(this.lZX) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.lZY + ", supportedEncodings=" + Arrays.toString(this.lZX) + "]";
    }
}
