package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes6.dex */
public class j implements i {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public b f32925a;

    /* renamed from: b  reason: collision with root package name */
    public b f32926b;

    public j(@NonNull b bVar) {
        this.f32925a = bVar;
        this.f32926b = bVar;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int a(AdTemplate adTemplate) {
        return this.f32925a.a(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a() {
        this.f32926b.a();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i) {
        this.f32926b.a(i);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i, AdTemplate adTemplate) {
        this.f32925a.a(i, adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(d dVar) {
        this.f32926b.a(dVar);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public boolean a(@NonNull b bVar) {
        b bVar2 = this.f32926b;
        if (bVar2 == bVar) {
            return false;
        }
        bVar2.d();
        this.f32926b = bVar;
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int b(AdTemplate adTemplate) {
        return this.f32926b.a(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b() {
        this.f32926b.d();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b(d dVar) {
        this.f32926b.b(dVar);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    @NonNull
    public b c() {
        return this.f32925a;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public List<AdTemplate> d() {
        return this.f32926b.b();
    }
}
