package com.kwad.sdk.contentalliance.detail.photo.d;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f8766a;

    /* renamed from: b  reason: collision with root package name */
    private PhotoInfo f8767b;
    private AdTemplate c;
    private long d;

    public d(@NonNull AdTemplate adTemplate, long j) {
        this.c = adTemplate;
        this.f8766a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.f8767b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.d = j;
    }

    public AdTemplate a() {
        return this.c;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.d.k(this.f8767b);
    }
}
