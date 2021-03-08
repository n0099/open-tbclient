package com.qq.e.comm.util;
/* loaded from: classes4.dex */
public class AdError {

    /* renamed from: a  reason: collision with root package name */
    private int f7594a;
    private String b;

    public AdError() {
    }

    public AdError(int i, String str) {
        this.f7594a = i;
        this.b = str;
    }

    public int getErrorCode() {
        return this.f7594a;
    }

    public String getErrorMsg() {
        return this.b;
    }
}
