package com.kwad.sdk.contentalliance.detail.photo.comment;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f32636a;

    /* renamed from: b  reason: collision with root package name */
    public PhotoInfo f32637b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32638c;

    /* renamed from: d  reason: collision with root package name */
    public long f32639d;

    /* renamed from: e  reason: collision with root package name */
    public List<PhotoComment> f32640e;

    public e(@NonNull AdTemplate adTemplate, long j) {
        this.f32638c = adTemplate;
        this.f32636a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.f32637b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.f32639d = j;
    }

    public AdTemplate a() {
        return this.f32638c;
    }

    public void a(@NonNull List<PhotoComment> list) {
        this.f32640e = list;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.c.z(this.f32638c);
    }

    public long c() {
        return this.f32639d;
    }

    public List<PhotoComment> d() {
        return this.f32640e;
    }

    public int e() {
        List<PhotoComment> list = this.f32640e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
