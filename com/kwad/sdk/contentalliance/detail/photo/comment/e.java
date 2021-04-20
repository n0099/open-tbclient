package com.kwad.sdk.contentalliance.detail.photo.comment;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f32541a;

    /* renamed from: b  reason: collision with root package name */
    public PhotoInfo f32542b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32543c;

    /* renamed from: d  reason: collision with root package name */
    public long f32544d;

    /* renamed from: e  reason: collision with root package name */
    public List<PhotoComment> f32545e;

    public e(@NonNull AdTemplate adTemplate, long j) {
        this.f32543c = adTemplate;
        this.f32541a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.f32542b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.f32544d = j;
    }

    public AdTemplate a() {
        return this.f32543c;
    }

    public void a(@NonNull List<PhotoComment> list) {
        this.f32545e = list;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.c.z(this.f32543c);
    }

    public long c() {
        return this.f32544d;
    }

    public List<PhotoComment> d() {
        return this.f32545e;
    }

    public int e() {
        List<PhotoComment> list = this.f32545e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
