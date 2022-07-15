package com.kwad.sdk.crash.report.upload;
/* loaded from: classes5.dex */
public final class e {
    public static e a = new e(-11, "Please init.");
    public static e b = new e(-12, "error when zip_file");
    public static e c = new e(-13, "There is no valid network.");
    public static e d = new e(-14, "Token is invalid.");
    public static e e = new e(-15, "upload task execute frequence exceed.");
    public static e f = new e(-16, "process request fail.");
    public static e g = new e(-17, "sever response error http code");
    public static e h = new e(-18, "sever response error result code");
    public static e i = new e(-19, "server bad response.");
    public final int j;
    public final String k;

    public e(int i2, String str) {
        this.j = i2;
        this.k = str;
    }

    public final String a() {
        return this.k;
    }
}
