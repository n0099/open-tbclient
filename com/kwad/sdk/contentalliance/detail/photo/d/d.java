package com.kwad.sdk.contentalliance.detail.photo.d;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f5647a;
    private PhotoInfo b;
    private AdTemplate c;
    private long d;

    public d(@NonNull AdTemplate adTemplate, long j) {
        this.c = adTemplate;
        this.f5647a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.d = j;
    }

    public AdTemplate a() {
        return this.c;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.d.k(this.b);
    }
}
