package com.thunder.livesdk.video;
/* loaded from: classes6.dex */
public class ThunderPublishLowStreamVideoConfig {
    public int encodeFrameRate = 0;
    public int encodeBitrate = 0;
    public int encodeResolutionHeight = 0;
    public int encodeResolutionWidth = 0;
    public int type = 1;

    public String toString() {
        return "lowStream{encW=" + this.encodeResolutionWidth + " encH=" + this.encodeResolutionHeight + " fps=" + this.encodeFrameRate + " bitrate=" + this.encodeBitrate + " type=" + this.type + "}";
    }
}
