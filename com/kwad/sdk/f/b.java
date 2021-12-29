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
/* loaded from: classes3.dex */
public class b extends KSFrameLayout {
    public a.InterfaceC2108a a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f59061b;

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f59062c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f59063d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.f.kwai.b f59064e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f59065f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f59066g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f59067h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59068i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.f.b.a f59069j;

    /* renamed from: k  reason: collision with root package name */
    public f f59070k;
    public KsAdVideoPlayConfig l;
    public k m;

    public b(@NonNull Context context) {
        super(context);
        this.m = new k() { // from class: com.kwad.sdk.f.b.1
            @Override // com.kwad.sdk.widget.k
            public void a() {
                m.c(b.this.f59066g);
            }
        };
        c();
    }

    private void c() {
        FrameLayout.inflate(getContext(), R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.f59062c = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.f59063d = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.f.kwai.b d() {
        com.kwad.sdk.f.kwai.b bVar = new com.kwad.sdk.f.kwai.b();
        bVar.f59083c = this.f59062c;
        bVar.f59084d = this.f59066g;
        bVar.a = this.a;
        bVar.f59082b = this.f59061b;
        bVar.f59085e = (this.f59068i == null && com.kwad.sdk.core.response.a.a.B(this.f59067h)) ? new com.kwad.sdk.core.download.a.b(this.f59066g) : this.f59068i;
        bVar.f59086f = this.f59069j;
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
        presenter.a(com.kwad.sdk.core.response.a.a.B(this.f59067h) ? new com.kwad.sdk.f.a.f() : new h());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        if (this.f59069j == null) {
            this.f59069j = new com.kwad.sdk.f.b.a(this.f59066g, this.f59070k, this.f59063d, this.l);
        }
        this.f59064e = d();
        Presenter e2 = e();
        this.f59065f = e2;
        e2.c(this.f59062c);
        this.f59065f.a(this.f59064e);
        this.f59070k.a();
        this.f59069j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f59066g = adTemplate;
        this.f59067h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59068i = bVar;
        this.l = ksAdVideoPlayConfig;
        this.f59062c.setVisibleListener(this.m);
        this.f59070k = new f(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.f59070k;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.f.b.a aVar = this.f59069j;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.f.kwai.b bVar = this.f59064e;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f59065f;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setInnerAdInteractionListener(a.InterfaceC2108a interfaceC2108a) {
        this.a = interfaceC2108a;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f59061b = videoPlayListener;
    }
}
