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
/* loaded from: classes5.dex */
public class b extends KSFrameLayout {
    public a.InterfaceC0320a a;
    public KsNativeAd.VideoPlayListener b;
    public AdBasePvFrameLayout c;
    public DetailVideoView d;
    public com.kwad.sdk.f.kwai.b e;
    public Presenter f;
    public AdTemplate g;
    public AdInfo h;
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
                m.c(b.this.g);
            }
        };
        c();
    }

    private void c() {
        FrameLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0442, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.obfuscated_res_0x7f09113a);
        this.c = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.obfuscated_res_0x7f091180);
        this.d = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.f.kwai.b d() {
        com.kwad.sdk.f.kwai.b bVar = new com.kwad.sdk.f.kwai.b();
        bVar.c = this.c;
        bVar.d = this.g;
        bVar.a = this.a;
        bVar.b = this.b;
        bVar.e = (this.i == null && com.kwad.sdk.core.response.a.a.B(this.h)) ? new com.kwad.sdk.core.download.a.b(this.g) : this.i;
        bVar.f = this.j;
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
        presenter.a(com.kwad.sdk.core.response.a.a.B(this.h) ? new com.kwad.sdk.f.a.f() : new h());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        if (this.j == null) {
            this.j = new com.kwad.sdk.f.b.a(this.g, this.k, this.d, this.l);
        }
        this.e = d();
        Presenter e = e();
        this.f = e;
        e.c(this.c);
        this.f.a(this.e);
        this.k.a();
        this.j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.g = adTemplate;
        this.h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.i = bVar;
        this.l = ksAdVideoPlayConfig;
        this.c.setVisibleListener(this.m);
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
        com.kwad.sdk.f.kwai.b bVar = this.e;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setInnerAdInteractionListener(a.InterfaceC0320a interfaceC0320a) {
        this.a = interfaceC0320a;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.b = videoPlayListener;
    }
}
