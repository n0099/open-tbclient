package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes6.dex */
public class j implements i {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public b f32636a;

    /* renamed from: b  reason: collision with root package name */
    public b f32637b;

    public j(@NonNull b bVar) {
        this.f32636a = bVar;
        this.f32637b = bVar;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int a(AdTemplate adTemplate) {
        return this.f32636a.a(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a() {
        this.f32637b.a();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i) {
        this.f32637b.a(i);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i, AdTemplate adTemplate) {
        this.f32636a.a(i, adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(d dVar) {
        this.f32637b.a(dVar);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public boolean a(@NonNull b bVar) {
        b bVar2 = this.f32637b;
        if (bVar2 == bVar) {
            return false;
        }
        bVar2.d();
        this.f32637b = bVar;
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int b(AdTemplate adTemplate) {
        return this.f32637b.a(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b() {
        this.f32637b.d();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b(d dVar) {
        this.f32637b.b(dVar);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    @NonNull
    public b c() {
        return this.f32636a;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public List<AdTemplate> d() {
        return this.f32637b.b();
    }
}
