package com.kwad.sdk.f;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
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
/* loaded from: classes4.dex */
public class b extends KSFrameLayout {
    public a.InterfaceC2141a a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f57050b;

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f57051c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f57052d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.f.kwai.b f57053e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f57054f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f57055g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f57056h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57057i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.f.b.a f57058j;
    public f k;
    public KsAdVideoPlayConfig l;
    public k m;

    public b(@NonNull Context context) {
        super(context);
        this.m = new k() { // from class: com.kwad.sdk.f.b.1
            @Override // com.kwad.sdk.widget.k
            public void a() {
                m.c(b.this.f57055g);
            }
        };
        c();
    }

    private void c() {
        FrameLayout.inflate(getContext(), R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.f57051c = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.f57052d = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.f.kwai.b d() {
        com.kwad.sdk.f.kwai.b bVar = new com.kwad.sdk.f.kwai.b();
        bVar.f57070c = this.f57051c;
        bVar.f57071d = this.f57055g;
        bVar.a = this.a;
        bVar.f57069b = this.f57050b;
        bVar.f57072e = (this.f57057i == null && com.kwad.sdk.core.response.a.a.B(this.f57056h)) ? new com.kwad.sdk.core.download.a.b(this.f57055g) : this.f57057i;
        bVar.f57073f = this.f57058j;
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
        presenter.a(com.kwad.sdk.core.response.a.a.B(this.f57056h) ? new com.kwad.sdk.f.a.f() : new h());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        if (this.f57058j == null) {
            this.f57058j = new com.kwad.sdk.f.b.a(this.f57055g, this.k, this.f57052d, this.l);
        }
        this.f57053e = d();
        Presenter e2 = e();
        this.f57054f = e2;
        e2.c(this.f57051c);
        this.f57054f.a(this.f57053e);
        this.k.a();
        this.f57058j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f57055g = adTemplate;
        this.f57056h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57057i = bVar;
        this.l = ksAdVideoPlayConfig;
        this.f57051c.setVisibleListener(this.m);
        this.k = new f(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.k;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.f.b.a aVar = this.f57058j;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.f.kwai.b bVar = this.f57053e;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f57054f;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setInnerAdInteractionListener(a.InterfaceC2141a interfaceC2141a) {
        this.a = interfaceC2141a;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f57050b = videoPlayListener;
    }
}
