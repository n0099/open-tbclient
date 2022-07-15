package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
@KsJson
/* loaded from: classes5.dex */
public class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int a;
    public int b;
    public int c;
    public long d;

    public f() {
    }

    public f(int i, int i2, int i3, long j) {
        this.a = i;
        this.b = i2;
        this.c = 1;
        this.d = j;
    }

    public final void a(long j) {
        this.d = j;
    }
}
