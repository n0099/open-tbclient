package com.qq.e.comm.util;
/* loaded from: classes3.dex */
public class AdError {

    /* renamed from: a  reason: collision with root package name */
    private int f13052a;

    /* renamed from: b  reason: collision with root package name */
    private String f13053b;

    public AdError() {
    }

    public AdError(int i, String str) {
        this.f13052a = i;
        this.f13053b = str;
    }

    public int getErrorCode() {
        return this.f13052a;
    }

    public String getErrorMsg() {
        return this.f13053b;
    }
}
