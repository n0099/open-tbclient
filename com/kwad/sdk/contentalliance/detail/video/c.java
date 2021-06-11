package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f33120a;

    /* renamed from: b  reason: collision with root package name */
    public long f33121b;

    public c() {
        this.f33121b = -1L;
    }

    public c(long j) {
        this.f33121b = -1L;
        this.f33120a = j;
    }

    public c(long j, long j2) {
        this.f33121b = -1L;
        this.f33120a = j;
        this.f33121b = j2;
    }

    @NonNull
    public static c a(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.c.c(adTemplate) ? new c(com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate)), adTemplate.mKsPlayerClickTimeParam) : new c(com.kwad.sdk.core.response.b.d.k(com.kwad.sdk.core.response.b.c.k(adTemplate)), adTemplate.mKsPlayerClickTimeParam);
    }
}
