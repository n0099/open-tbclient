package com.kwad.sdk.contentalliance.detail.photo.d;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public long f32842a;

    /* renamed from: b  reason: collision with root package name */
    public PhotoInfo f32843b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32844c;

    /* renamed from: d  reason: collision with root package name */
    public long f32845d;

    public d(@NonNull AdTemplate adTemplate, long j) {
        this.f32844c = adTemplate;
        this.f32842a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.f32843b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.f32845d = j;
    }

    public AdTemplate a() {
        return this.f32844c;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.d.k(this.f32843b);
    }
}
