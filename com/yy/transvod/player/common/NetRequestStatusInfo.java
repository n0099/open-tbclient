package com.yy.transvod.player.common;
/* loaded from: classes10.dex */
public class NetRequestStatusInfo {
    public String a;
    public String b = "";
    public boolean c = false;
    public int d = -1;

    public static native void nativeClassInit();

    public String toString() {
        return "NetRequestStatusInfo:  mUrl=" + this.a + " serverIP=" + this.b + " mConnected=" + this.c + " mHttpCode=" + this.d;
    }
}
