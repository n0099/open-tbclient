package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.contentalliance.detail.photo.f.a<g> {

    /* renamed from: d  reason: collision with root package name */
    public g f32364d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32365e;

    /* loaded from: classes6.dex */
    public interface a {
        void a(@NonNull AdTemplate adTemplate, long j);
    }

    private void h() {
        for (a aVar : ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32157f) {
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
            aVar.a(cVar.j, cVar.i);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j;
        this.f32365e = adTemplate;
        long t = com.kwad.sdk.core.response.b.c.t(adTemplate);
        if (com.kwad.sdk.core.config.c.C()) {
            t++;
        }
        this.f32364d.setCommentCount(t);
        this.f32364d.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32364d.setOnClickListener(null);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32364d = (g) ((com.kwad.sdk.contentalliance.detail.photo.f.a) this).f32359b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public g g() {
        return new g(o());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.kwad.sdk.core.response.b.c.c(this.f32365e) || com.kwad.sdk.core.config.c.C()) {
            h();
        } else {
            p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        }
        com.kwad.sdk.core.report.e.f(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j);
    }
}
