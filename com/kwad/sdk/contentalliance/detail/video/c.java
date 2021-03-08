package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f5746a;
    public long b;

    public c() {
        this.b = -1L;
    }

    public c(long j) {
        this.b = -1L;
        this.f5746a = j;
    }

    public c(long j, long j2) {
        this.b = -1L;
        this.f5746a = j;
        this.b = j2;
    }

    @NonNull
    public static c a(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.c.c(adTemplate) ? new c(com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate)), adTemplate.mKsPlayerClickTimeParam) : new c(com.kwad.sdk.core.response.b.d.k(com.kwad.sdk.core.response.b.c.k(adTemplate)), adTemplate.mKsPlayerClickTimeParam);
    }
}
