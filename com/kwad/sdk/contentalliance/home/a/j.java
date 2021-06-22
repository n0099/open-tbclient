package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes6.dex */
public class j implements i {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public b f33316a;

    /* renamed from: b  reason: collision with root package name */
    public b f33317b;

    public j(@NonNull b bVar) {
        this.f33316a = bVar;
        this.f33317b = bVar;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int a(AdTemplate adTemplate) {
        return this.f33316a.a(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a() {
        this.f33317b.a();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i2) {
        this.f33317b.a(i2);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i2, AdTemplate adTemplate) {
        this.f33316a.a(i2, adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(d dVar) {
        this.f33317b.a(dVar);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public boolean a(@NonNull b bVar) {
        b bVar2 = this.f33317b;
        if (bVar2 == bVar) {
            return false;
        }
        bVar2.d();
        this.f33317b = bVar;
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int b(AdTemplate adTemplate) {
        return this.f33317b.a(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b() {
        this.f33317b.d();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b(d dVar) {
        this.f33317b.b(dVar);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    @NonNull
    public b c() {
        return this.f33316a;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public List<AdTemplate> d() {
        return this.f33317b.b();
    }
}
