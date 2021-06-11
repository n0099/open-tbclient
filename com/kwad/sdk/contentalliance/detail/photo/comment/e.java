package com.kwad.sdk.contentalliance.detail.photo.comment;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f32820a;

    /* renamed from: b  reason: collision with root package name */
    public PhotoInfo f32821b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32822c;

    /* renamed from: d  reason: collision with root package name */
    public long f32823d;

    /* renamed from: e  reason: collision with root package name */
    public List<PhotoComment> f32824e;

    public e(@NonNull AdTemplate adTemplate, long j) {
        this.f32822c = adTemplate;
        this.f32820a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.f32821b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.f32823d = j;
    }

    public AdTemplate a() {
        return this.f32822c;
    }

    public void a(@NonNull List<PhotoComment> list) {
        this.f32824e = list;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.c.z(this.f32822c);
    }

    public long c() {
        return this.f32823d;
    }

    public List<PhotoComment> d() {
        return this.f32824e;
    }

    public int e() {
        List<PhotoComment> list = this.f32824e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
