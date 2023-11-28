package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
@KsJson
/* loaded from: classes10.dex */
public class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int adStyle;
    public long ayM;
    public int count;
    public int taskType;

    public f() {
    }

    public f(int i, int i2, int i3, long j) {
        this.adStyle = i;
        this.taskType = i2;
        this.count = 1;
        this.ayM = j;
    }

    public final void aj(long j) {
        this.ayM = j;
    }
}
