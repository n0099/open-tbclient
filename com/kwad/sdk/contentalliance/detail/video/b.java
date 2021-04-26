package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f32781a;

    /* renamed from: b  reason: collision with root package name */
    public long f32782b;

    public b() {
        this.f32782b = -1L;
    }

    public b(long j, long j2) {
        this.f32782b = -1L;
        this.f32781a = j;
        this.f32782b = j2;
    }

    @NonNull
    public static b a(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.c.a(adTemplate) ? new b(com.kwad.sdk.core.response.b.a.i(com.kwad.sdk.core.response.b.c.g(adTemplate)), adTemplate.mKsPlayerClickTimeParam) : new b(com.kwad.sdk.core.response.b.d.d(com.kwad.sdk.core.response.b.c.h(adTemplate)), adTemplate.mKsPlayerClickTimeParam);
    }
}
