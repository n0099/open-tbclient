package com.qq.e.comm.util;
/* loaded from: classes3.dex */
public enum VideoAdValidity {
    VALID("有效且可展示的广告"),
    OVERDUE("过期的广告"),
    SHOWED("已经展示的广告"),
    NONE_CACHE("视频未缓存的广告");
    

    /* renamed from: a  reason: collision with root package name */
    private String f13056a;

    VideoAdValidity(String str) {
        this.f13056a = str;
    }

    public final String getMessage() {
        return this.f13056a;
    }
}
