package com.kwad.sdk.contentalliance.detail.photo.d;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public long f32273a;

    /* renamed from: b  reason: collision with root package name */
    public PhotoInfo f32274b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32275c;

    /* renamed from: d  reason: collision with root package name */
    public long f32276d;

    public d(@NonNull AdTemplate adTemplate, long j) {
        this.f32275c = adTemplate;
        this.f32273a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.f32274b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.f32276d = j;
    }

    public AdTemplate a() {
        return this.f32275c;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.d.k(this.f32274b);
    }
}
