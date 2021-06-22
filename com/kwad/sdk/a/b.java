package com.kwad.sdk.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.a.b.c;
import com.kwad.sdk.a.b.d;
import com.kwad.sdk.a.b.e;
import com.kwad.sdk.a.b.f;
import com.kwad.sdk.a.b.h;
import com.kwad.sdk.a.b.i;
import com.kwad.sdk.a.b.j;
import com.kwad.sdk.a.b.k;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.view.b {

    /* renamed from: a  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f32311a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f32312b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32313c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f32314d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.a.a.b f32315e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f32316f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f32317g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f32318h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32319i;
    public com.kwad.sdk.a.c.a j;
    public g k;
    public KsAdVideoPlayConfig l;

    public b(@NonNull Context context) {
        super(context);
        c();
    }

    private void c() {
        FrameLayout.inflate(getContext(), R.layout.ksad_native_video_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f32313c = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f32314d = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.a.a.b d() {
        com.kwad.sdk.a.a.b bVar = new com.kwad.sdk.a.a.b();
        bVar.f32307c = this.f32313c;
        bVar.f32308d = this.f32317g;
        bVar.f32305a = this.f32311a;
        bVar.f32306b = this.f32312b;
        bVar.f32309e = (this.f32319i == null && com.kwad.sdk.core.response.b.a.y(this.f32318h)) ? new com.kwad.sdk.core.download.b.b(this.f32317g) : this.f32319i;
        bVar.f32310f = this.j;
        return bVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new e());
        presenter.a((Presenter) new c());
        presenter.a((Presenter) new i());
        presenter.a((Presenter) new j());
        presenter.a((Presenter) new d());
        presenter.a((Presenter) new com.kwad.sdk.a.b.b());
        presenter.a((Presenter) new k());
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.l;
        if (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            presenter.a((Presenter) new com.kwad.sdk.a.b.a());
        }
        presenter.a((Presenter) new com.kwad.sdk.a.b.g());
        presenter.a(com.kwad.sdk.core.response.b.a.y(this.f32318h) ? new f() : new h());
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f32315e = d();
        Presenter e2 = e();
        this.f32316f = e2;
        e2.a((View) this.f32313c);
        this.f32316f.a(this.f32315e);
        this.k.a();
        this.j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f32317g = adTemplate;
        this.f32318h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f32319i = bVar;
        this.l = ksAdVideoPlayConfig;
        g gVar = new g(getParent() == null ? this : (View) getParent(), 30);
        this.k = gVar;
        this.j = new com.kwad.sdk.a.c.a(this.f32317g, gVar, this.f32314d, ksAdVideoPlayConfig);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
        com.kwad.sdk.a.c.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.a.a.b bVar = this.f32315e;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f32316f;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void setAdInteractionListener(KsNativeAd.AdInteractionListener adInteractionListener) {
        this.f32311a = adInteractionListener;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f32312b = videoPlayListener;
    }
}
