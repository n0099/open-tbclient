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
/* loaded from: classes7.dex */
public class b extends KSFrameLayout {
    public a.InterfaceC1981a a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f40452b;

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f40453c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f40454d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.f.kwai.b f40455e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f40456f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f40457g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f40458h;
    public com.kwad.sdk.core.download.a.b i;
    public com.kwad.sdk.f.b.a j;
    public f k;
    public KsAdVideoPlayConfig l;
    public k m;

    public b(@NonNull Context context) {
        super(context);
        this.m = new k() { // from class: com.kwad.sdk.f.b.1
            @Override // com.kwad.sdk.widget.k
            public void a() {
                m.c(b.this.f40457g);
            }
        };
        c();
    }

    private void c() {
        FrameLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0453, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.obfuscated_res_0x7f091131);
        this.f40453c = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.obfuscated_res_0x7f091177);
        this.f40454d = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.f.kwai.b d() {
        com.kwad.sdk.f.kwai.b bVar = new com.kwad.sdk.f.kwai.b();
        bVar.f40468c = this.f40453c;
        bVar.f40469d = this.f40457g;
        bVar.a = this.a;
        bVar.f40467b = this.f40452b;
        bVar.f40470e = (this.i == null && com.kwad.sdk.core.response.a.a.B(this.f40458h)) ? new com.kwad.sdk.core.download.a.b(this.f40457g) : this.i;
        bVar.f40471f = this.j;
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
        presenter.a(com.kwad.sdk.core.response.a.a.B(this.f40458h) ? new com.kwad.sdk.f.a.f() : new h());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        if (this.j == null) {
            this.j = new com.kwad.sdk.f.b.a(this.f40457g, this.k, this.f40454d, this.l);
        }
        this.f40455e = d();
        Presenter e2 = e();
        this.f40456f = e2;
        e2.c(this.f40453c);
        this.f40456f.a(this.f40455e);
        this.k.a();
        this.j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f40457g = adTemplate;
        this.f40458h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.i = bVar;
        this.l = ksAdVideoPlayConfig;
        this.f40453c.setVisibleListener(this.m);
        this.k = new f(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.k;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.f.b.a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.f.kwai.b bVar = this.f40455e;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f40456f;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setInnerAdInteractionListener(a.InterfaceC1981a interfaceC1981a) {
        this.a = interfaceC1981a;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f40452b = videoPlayListener;
    }
}
