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
    public KsNativeAd.AdInteractionListener f31672a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f31673b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f31674c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f31675d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.a.a.b f31676e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f31677f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f31678g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f31679h;
    public com.kwad.sdk.core.download.b.b i;
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
        this.f31674c = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f31675d = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.a.a.b d() {
        com.kwad.sdk.a.a.b bVar = new com.kwad.sdk.a.a.b();
        bVar.f31668c = this.f31674c;
        bVar.f31669d = this.f31678g;
        bVar.f31666a = this.f31672a;
        bVar.f31667b = this.f31673b;
        bVar.f31670e = (this.i == null && com.kwad.sdk.core.response.b.a.y(this.f31679h)) ? new com.kwad.sdk.core.download.b.b(this.f31678g) : this.i;
        bVar.f31671f = this.j;
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
        presenter.a(com.kwad.sdk.core.response.b.a.y(this.f31679h) ? new f() : new h());
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f31676e = d();
        Presenter e2 = e();
        this.f31677f = e2;
        e2.a((View) this.f31674c);
        this.f31677f.a(this.f31676e);
        this.k.a();
        this.j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f31678g = adTemplate;
        this.f31679h = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = bVar;
        this.l = ksAdVideoPlayConfig;
        g gVar = new g(getParent() == null ? this : (View) getParent(), 30);
        this.k = gVar;
        this.j = new com.kwad.sdk.a.c.a(this.f31678g, gVar, this.f31675d, ksAdVideoPlayConfig);
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
        com.kwad.sdk.a.a.b bVar = this.f31676e;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f31677f;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void setAdInteractionListener(KsNativeAd.AdInteractionListener adInteractionListener) {
        this.f31672a = adInteractionListener;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f31673b = videoPlayListener;
    }
}
