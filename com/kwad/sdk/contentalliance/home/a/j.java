package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes4.dex */
public class j implements i {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private b f8667a;

    /* renamed from: b  reason: collision with root package name */
    private b f8668b;

    public j(@NonNull b bVar) {
        this.f8667a = bVar;
        this.f8668b = bVar;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int a(AdTemplate adTemplate) {
        return this.f8667a.a(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a() {
        this.f8668b.a();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i) {
        this.f8668b.a(i);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i, AdTemplate adTemplate) {
        this.f8667a.a(i, adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(d dVar) {
        this.f8668b.a(dVar);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public boolean a(@NonNull b bVar) {
        if (this.f8668b == bVar) {
            return false;
        }
        this.f8668b.d();
        this.f8668b = bVar;
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int b(AdTemplate adTemplate) {
        return this.f8668b.a(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b() {
        this.f8668b.d();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b(d dVar) {
        this.f8668b.b(dVar);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    @NonNull
    public b c() {
        return this.f8667a;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public List<AdTemplate> d() {
        return this.f8668b.b();
    }
}
