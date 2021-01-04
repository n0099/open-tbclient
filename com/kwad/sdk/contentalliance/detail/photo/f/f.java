package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.p;
/* loaded from: classes5.dex */
public class f extends com.kwad.sdk.contentalliance.detail.photo.f.a<g> {
    private g d;
    private AdTemplate e;

    /* loaded from: classes5.dex */
    public interface a {
        void a(@NonNull AdTemplate adTemplate, long j);
    }

    private void h() {
        for (a aVar : this.f8692a.f) {
            aVar.a(this.f8692a.j, this.f8692a.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.e = this.f8692a.j;
        long t = com.kwad.sdk.core.response.b.c.t(this.f8692a.j);
        if (com.kwad.sdk.core.config.c.C()) {
            t++;
        }
        this.d.setCommentCount(t);
        this.d.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.d.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (g) this.f8813b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public g g() {
        return new g(o());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.kwad.sdk.core.response.b.c.c(this.e)) {
            h();
        } else if (com.kwad.sdk.core.config.c.C()) {
            h();
        } else {
            p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        }
        com.kwad.sdk.core.report.e.f(this.f8692a.j);
    }
}
