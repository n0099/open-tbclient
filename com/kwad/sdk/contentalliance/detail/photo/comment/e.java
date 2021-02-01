package com.kwad.sdk.contentalliance.detail.photo.comment;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private long f8454a;

    /* renamed from: b  reason: collision with root package name */
    private PhotoInfo f8455b;
    private AdTemplate c;
    private long d;
    private List<PhotoComment> e;

    public e(@NonNull AdTemplate adTemplate, long j) {
        this.c = adTemplate;
        this.f8454a = com.kwad.sdk.core.response.b.c.e(adTemplate);
        this.f8455b = com.kwad.sdk.core.response.b.c.k(adTemplate);
        this.d = j;
    }

    public AdTemplate a() {
        return this.c;
    }

    public void a(@NonNull List<PhotoComment> list) {
        this.e = list;
    }

    public long b() {
        return com.kwad.sdk.core.response.b.c.z(this.c);
    }

    public long c() {
        return this.d;
    }

    public List<PhotoComment> d() {
        return this.e;
    }

    public int e() {
        if (this.e != null) {
            return this.e.size();
        }
        return 0;
    }
}
