package com.kwad.sdk.contentalliance.detail.photo.comment;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f32251a;

    /* renamed from: b  reason: collision with root package name */
    public PhotoInfo f32252b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32253c;

    /* renamed from: d  reason: collision with root package name */
    public long f32254d;

    /* renamed from: e  reason: collision with root package name */
    public List<PhotoComment> f32255e;

    public e(@NonNull AdTemplate adTemplate, long j) {
        this.f32253c = adTemplate;
        this.f32251a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.f32252b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.f32254d = j;
    }

    public AdTemplate a() {
        return this.f32253c;
    }

    public void a(@NonNull List<PhotoComment> list) {
        this.f32255e = list;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.c.z(this.f32253c);
    }

    public long c() {
        return this.f32254d;
    }

    public List<PhotoComment> d() {
        return this.f32255e;
    }

    public int e() {
        List<PhotoComment> list = this.f32255e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
