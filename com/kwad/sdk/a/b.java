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
import com.kwad.sdk.a.b.g;
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
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.view.a {

    /* renamed from: a  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f32463a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f32464b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32465c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f32466d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.a.a.b f32467e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f32468f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f32469g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f32470h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32471i;
    public com.kwad.sdk.a.c.a j;
    public com.kwad.sdk.core.view.b k;
    public KsAdVideoPlayConfig l;

    public b(@NonNull Context context) {
        super(context);
        c();
    }

    private void c() {
        FrameLayout.inflate(getContext(), R.layout.ksad_native_video_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f32465c = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f32466d = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.a.a.b d() {
        com.kwad.sdk.a.a.b bVar = new com.kwad.sdk.a.a.b();
        bVar.f32459c = this.f32465c;
        bVar.f32460d = this.f32469g;
        bVar.f32457a = this.f32463a;
        bVar.f32458b = this.f32464b;
        bVar.f32461e = (this.f32471i == null && com.kwad.sdk.core.response.b.a.v(this.f32470h)) ? new com.kwad.sdk.core.download.b.b(this.f32469g) : this.f32471i;
        bVar.f32462f = this.j;
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
        presenter.a((Presenter) new g());
        presenter.a(com.kwad.sdk.core.response.b.a.v(this.f32470h) ? new f() : new h());
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.a
    public void a() {
        if (this.j == null) {
            this.j = new com.kwad.sdk.a.c.a(this.f32469g, this.k, this.f32466d, this.l);
        }
        this.f32467e = d();
        Presenter e2 = e();
        this.f32468f = e2;
        e2.a((View) this.f32465c);
        this.f32468f.a(this.f32467e);
        this.k.a();
        this.j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f32469g = adTemplate;
        this.f32470h = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f32471i = bVar;
        this.l = ksAdVideoPlayConfig;
        this.k = new com.kwad.sdk.core.view.b(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.core.view.a
    public void b() {
        com.kwad.sdk.core.view.b bVar = this.k;
        if (bVar != null) {
            bVar.c();
        }
        com.kwad.sdk.a.c.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.a.a.b bVar2 = this.f32467e;
        if (bVar2 != null) {
            bVar2.a();
        }
        Presenter presenter = this.f32468f;
        if (presenter != null) {
            presenter.g();
        }
    }

    public void setAdInteractionListener(KsNativeAd.AdInteractionListener adInteractionListener) {
        this.f32463a = adInteractionListener;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f32464b = videoPlayListener;
    }
}
