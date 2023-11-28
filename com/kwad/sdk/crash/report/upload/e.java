package com.kwad.sdk.crash.report.upload;
/* loaded from: classes10.dex */
public final class e {
    public static e aGo = new e(-11, "Please init.");
    public static e aGp = new e(-12, "error when zip_file");
    public static e aGq = new e(-13, "There is no valid network.");
    public static e aGr = new e(-14, "Token is invalid.");
    public static e aGs = new e(-15, "upload task execute frequence exceed.");
    public static e aGt = new e(-16, "process request fail.");
    public static e aGu = new e(-17, "sever response error http code");
    public static e aGv = new e(-18, "sever response error result code");
    public static e aGw = new e(-19, "server bad response.");
    public final int aGx;
    public final String aGy;

    public e(int i, String str) {
        this.aGx = i;
        this.aGy = str;
    }

    public final String wd() {
        return this.aGy;
    }
}
