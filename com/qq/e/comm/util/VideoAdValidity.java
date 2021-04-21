package com.qq.e.comm.util;
/* loaded from: classes6.dex */
public enum VideoAdValidity {
    VALID("有效且可展示的广告"),
    OVERDUE("过期的广告"),
    SHOWED("已经展示的广告"),
    NONE_CACHE("视频未缓存的广告");
    

    /* renamed from: a  reason: collision with root package name */
    public String f38780a;

    VideoAdValidity(String str) {
        this.f38780a = str;
    }

    public final String getMessage() {
        return this.f38780a;
    }
}
