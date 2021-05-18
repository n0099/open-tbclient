package com.kwad.sdk.draw.c;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.b;
/* loaded from: classes6.dex */
public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33195a;

    /* renamed from: b  reason: collision with root package name */
    public long f33196b;

    /* renamed from: c  reason: collision with root package name */
    public b f33197c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f33198d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f33199e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f33200f = new b.a() { // from class: com.kwad.sdk.draw.c.a.2
        @Override // com.kwad.sdk.core.view.b.a
        public void a(boolean z) {
            if (!z) {
                a.this.d();
                return;
            }
            if (a.this.f33199e == null) {
                a aVar = a.this;
                aVar.f33199e = new com.kwad.sdk.contentalliance.detail.video.b(aVar.f33196b, System.currentTimeMillis());
                a.this.f33198d.a(a.this.f33199e);
            }
            a.this.c();
        }
    };

    public a(@NonNull AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        this.f33195a = adTemplate;
        this.f33196b = com.kwad.sdk.core.response.b.a.i(c.g(adTemplate));
        this.f33197c = bVar;
        this.f33198d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f33198d.a(new c.e() { // from class: com.kwad.sdk.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.a(System.currentTimeMillis());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f33197c.d()) {
            this.f33198d.a(new com.kwad.sdk.contentalliance.detail.video.b(this.f33196b, j));
            this.f33198d.e();
        }
    }

    private void f() {
        this.f33198d.a(new c.a().a(com.kwad.sdk.core.response.b.c.i(this.f33195a)).b(d.b(com.kwad.sdk.core.response.b.c.h(this.f33195a))).a(this.f33195a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f33195a)).a());
        this.f33198d.d();
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f33198d.a() == null) {
            f();
        }
        a(currentTimeMillis);
        this.f33197c.a(this.f33200f);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f33198d.a(dVar);
    }

    public void b() {
        this.f33199e = null;
        this.f33197c.b(this.f33200f);
        this.f33198d.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f33198d.b(dVar);
    }

    public void c() {
        this.f33198d.f();
        com.kwad.sdk.utils.b.a().a(false);
    }

    public void d() {
        this.f33198d.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f33198d;
        if (aVar != null) {
            aVar.m();
            this.f33198d.h();
        }
    }
}
