package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.view.b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private KsDrawAd.AdInteractionListener f9971a;

    /* renamed from: b  reason: collision with root package name */
    private AdBaseFrameLayout f9972b;
    private DetailVideoView c;
    private com.kwad.sdk.draw.a.b d;
    private Presenter e;
    @NonNull
    private AdTemplate f;
    private AdInfo g;
    private com.kwad.sdk.draw.c.a h;
    private g i;
    private Context j;

    public a(@NonNull Context context) {
        super(context);
        this.j = context;
        c();
    }

    private void c() {
        inflate(this.j, R.layout.ksad_draw_layout, this);
        this.f9972b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.c = (DetailVideoView) this.f9972b.findViewById(R.id.ksad_video_player);
        this.c.setAd(true);
    }

    private com.kwad.sdk.draw.a.b d() {
        com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
        bVar.f9974a = this.f9971a;
        bVar.f9975b = this.f9972b;
        bVar.c = this.f;
        if (com.kwad.sdk.core.response.b.a.y(this.g)) {
            bVar.d = new com.kwad.sdk.core.download.b.b(this.f);
        }
        bVar.e = this.h;
        bVar.f = new com.kwad.sdk.draw.b.b.a(this.f);
        if (com.kwad.sdk.core.response.b.b.p(this.f)) {
            bVar.g = new c();
        }
        return bVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.draw.b.a.a());
        presenter.a((Presenter) new com.kwad.sdk.draw.b.a());
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c());
        presenter.a((Presenter) new com.kwad.sdk.draw.b.b());
        presenter.a((Presenter) new com.kwad.sdk.draw.b.b.b());
        if (com.kwad.sdk.core.response.b.b.o(this.f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.p(this.f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    protected void a() {
        this.d = d();
        this.e = e();
        this.e.a((View) this.f9972b);
        this.e.a(this.d);
        this.i.a();
        this.h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f = adTemplate;
        this.g = com.kwad.sdk.core.response.b.c.j(this.f);
        this.i = new g(this, 70);
        this.h = new com.kwad.sdk.draw.c.a(this.f, this.i, this.c);
    }

    @Override // com.kwad.sdk.core.view.b
    protected void b() {
        if (this.i != null) {
            this.i.c();
        }
        if (this.h != null) {
            this.h.b();
        }
        if (this.d != null) {
            this.d.a();
        }
        if (this.e != null) {
            this.e.j();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f9971a = adInteractionListener;
    }
}
