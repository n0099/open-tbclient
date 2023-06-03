package com.yy.transvod.player.common;
/* loaded from: classes10.dex */
public class MixAudioExtraInfo {
    public String a;
    public int b;

    public static native void nativeClassInit();

    public MixAudioExtraInfo() {
        this.a = "";
        this.b = -1;
    }

    public String toString() {
        return " uid=" + this.a + " volume=" + this.b;
    }

    public MixAudioExtraInfo(String str, int i) {
        this.a = str;
        this.b = i;
    }
}
