package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f8609a;

    /* renamed from: b  reason: collision with root package name */
    public long f8610b;

    public c() {
        this.f8610b = -1L;
    }

    public c(long j) {
        this.f8610b = -1L;
        this.f8609a = j;
    }

    public c(long j, long j2) {
        this.f8610b = -1L;
        this.f8609a = j;
        this.f8610b = j2;
    }

    @NonNull
    public static c a(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.c.c(adTemplate) ? new c(com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate)), adTemplate.mKsPlayerClickTimeParam) : new c(com.kwad.sdk.core.response.b.d.k(com.kwad.sdk.core.response.b.c.k(adTemplate)), adTemplate.mKsPlayerClickTimeParam);
    }
}
