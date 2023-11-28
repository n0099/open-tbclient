package com.kwad.sdk;
/* loaded from: classes10.dex */
public final class e {
    public static final e akj = new e(10000, "其他异常");
    public static final e akk = new e(10001, "初始化参数异常");
    public int code;
    public String msg;

    public e(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}
