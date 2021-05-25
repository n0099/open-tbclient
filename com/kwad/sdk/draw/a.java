package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.view.a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f33040a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f33041b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f33042c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f33043d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f33044e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33045f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33046g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f33047h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.view.b f33048i;
    public Context j;

    public a(@NonNull Context context) {
        super(context);
        this.j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.j, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f33041b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f33042c = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.draw.a.b d() {
        com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
        bVar.f33050a = this.f33040a;
        bVar.f33051b = this.f33041b;
        bVar.f33052c = this.f33045f;
        if (com.kwad.sdk.core.response.b.a.v(this.f33046g)) {
            bVar.f33053d = new com.kwad.sdk.core.download.b.b(this.f33045f);
        }
        bVar.f33054e = this.f33047h;
        bVar.f33055f = new com.kwad.sdk.draw.b.b.a(this.f33045f);
        if (com.kwad.sdk.core.response.b.b.j(this.f33045f)) {
            bVar.f33056g = new c();
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
        if (com.kwad.sdk.core.response.b.b.i(this.f33045f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.j(this.f33045f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.a
    public void a() {
        this.f33043d = d();
        Presenter e2 = e();
        this.f33044e = e2;
        e2.a((View) this.f33041b);
        this.f33044e.a(this.f33043d);
        this.f33048i.a();
        this.f33047h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f33045f = adTemplate;
        this.f33046g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.core.view.b bVar = new com.kwad.sdk.core.view.b(this, 70);
        this.f33048i = bVar;
        this.f33047h = new com.kwad.sdk.draw.c.a(this.f33045f, bVar, this.f33042c);
    }

    @Override // com.kwad.sdk.core.view.a
    public void b() {
        com.kwad.sdk.core.view.b bVar = this.f33048i;
        if (bVar != null) {
            bVar.c();
        }
        com.kwad.sdk.draw.c.a aVar = this.f33047h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.a.b bVar2 = this.f33043d;
        if (bVar2 != null) {
            bVar2.a();
        }
        Presenter presenter = this.f33044e;
        if (presenter != null) {
            presenter.g();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f33040a = adInteractionListener;
    }
}
