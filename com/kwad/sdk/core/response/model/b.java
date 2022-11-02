package com.kwad.sdk.core.response.model;
/* loaded from: classes8.dex */
public final class b {
    public boolean Kh = true;
    public boolean adj;
    public int mHeight;
    public String mUrl;
    public int mWidth;

    public b(String str, int i, int i2, boolean z, boolean z2) {
        this.mUrl = str;
        this.mWidth = i;
        this.mHeight = i2;
        this.adj = z2;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final int getWidth() {
        return this.mWidth;
    }
}
