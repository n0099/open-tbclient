package com.yy.transvod.player.common;
/* loaded from: classes10.dex */
public class VideoExtraInfo {
    public static int d = 6;
    public int a = 0;
    public String b = "";
    public byte[] c = null;

    public static native void nativeClassInit();

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoExtraInfo: ");
        sb.append(" mPayload=");
        sb.append(this.a);
        sb.append(" uid=");
        sb.append(this.b);
        if (this.c != null) {
            sb.append(" mStrExtraInfo.size=");
            sb.append(this.c.length);
        }
        return sb.toString();
    }
}
