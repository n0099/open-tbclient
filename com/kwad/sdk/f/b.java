package com.kwad.sdk.f;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.f.a;
import com.kwad.sdk.f.a.c;
import com.kwad.sdk.f.a.d;
import com.kwad.sdk.f.a.e;
import com.kwad.sdk.f.a.g;
import com.kwad.sdk.f.a.h;
import com.kwad.sdk.f.a.i;
import com.kwad.sdk.f.a.j;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.k;
/* loaded from: classes8.dex */
public class b extends KSFrameLayout {
    public a.InterfaceC2120a a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f55400b;

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f55401c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f55402d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.f.kwai.b f55403e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f55404f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f55405g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f55406h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55407i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.f.b.a f55408j;
    public f k;
    public KsAdVideoPlayConfig l;
    public k m;

    public b(@NonNull Context context) {
        super(context);
        this.m = new k() { // from class: com.kwad.sdk.f.b.1
            @Override // com.kwad.sdk.widget.k
            public void a() {
                m.c(b.this.f55405g);
            }
        };
        c();
    }

    private void c() {
        FrameLayout.inflate(getContext(), R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.f55401c = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.f55402d = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.f.kwai.b d() {
        com.kwad.sdk.f.kwai.b bVar = new com.kwad.sdk.f.kwai.b();
        bVar.f55420c = this.f55401c;
        bVar.f55421d = this.f55405g;
        bVar.a = this.a;
        bVar.f55419b = this.f55400b;
        bVar.f55422e = (this.f55407i == null && com.kwad.sdk.core.response.a.a.B(this.f55406h)) ? new com.kwad.sdk.core.download.a.b(this.f55405g) : this.f55407i;
        bVar.f55423f = this.f55408j;
        return bVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new e());
        presenter.a((Presenter) new c());
        presenter.a((Presenter) new i());
        presenter.a((Presenter) new j());
        presenter.a((Presenter) new d());
        presenter.a((Presenter) new com.kwad.sdk.f.a.b());
        presenter.a((Presenter) new com.kwad.sdk.f.a.k());
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.l;
        if (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            presenter.a((Presenter) new com.kwad.sdk.f.a.a());
        }
        presenter.a((Presenter) new g());
        presenter.a(com.kwad.sdk.core.response.a.a.B(this.f55406h) ? new com.kwad.sdk.f.a.f() : new h());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        if (this.f55408j == null) {
            this.f55408j = new com.kwad.sdk.f.b.a(this.f55405g, this.k, this.f55402d, this.l);
        }
        this.f55403e = d();
        Presenter e2 = e();
        this.f55404f = e2;
        e2.c(this.f55401c);
        this.f55404f.a(this.f55403e);
        this.k.a();
        this.f55408j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f55405g = adTemplate;
        this.f55406h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f55407i = bVar;
        this.l = ksAdVideoPlayConfig;
        this.f55401c.setVisibleListener(this.m);
        this.k = new f(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.k;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.f.b.a aVar = this.f55408j;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.f.kwai.b bVar = this.f55403e;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f55404f;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setInnerAdInteractionListener(a.InterfaceC2120a interfaceC2120a) {
        this.a = interfaceC2120a;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f55400b = videoPlayListener;
    }
}
