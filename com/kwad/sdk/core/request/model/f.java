package com.kwad.sdk.core.request.model;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public long acW;
    public int adStyle;
    public int count;
    public int taskType;

    public f() {
    }

    public f(int i, int i2, int i3, long j) {
        this.adStyle = i;
        this.taskType = i2;
        this.count = 1;
        this.acW = j;
    }

    public final void G(long j) {
        this.acW = j;
    }
}
