package com.kwad.sdk.crash.report.upload;
/* loaded from: classes7.dex */
public final class e {
    public static e ahP = new e(-11, "Please init.");
    public static e ahQ = new e(-12, "error when zip_file");
    public static e ahR = new e(-13, "There is no valid network.");
    public static e ahS = new e(-14, "Token is invalid.");
    public static e ahT = new e(-15, "upload task execute frequence exceed.");
    public static e ahU = new e(-16, "process request fail.");
    public static e ahV = new e(-17, "sever response error http code");
    public static e ahW = new e(-18, "sever response error result code");
    public static e ahX = new e(-19, "server bad response.");
    public final int ahY;
    public final String ahZ;

    public e(int i, String str) {
        this.ahY = i;
        this.ahZ = str;
    }

    public final String wX() {
        return this.ahZ;
    }
}
