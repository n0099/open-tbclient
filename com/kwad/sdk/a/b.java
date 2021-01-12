package com.kwad.sdk.a;

import android.content.Context;
import android.view.View;
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
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.core.view.b {

    /* renamed from: a  reason: collision with root package name */
    private KsNativeAd.AdInteractionListener f8139a;

    /* renamed from: b  reason: collision with root package name */
    private KsNativeAd.VideoPlayListener f8140b;
    private AdBaseFrameLayout c;
    private DetailVideoView d;
    private com.kwad.sdk.a.a.b e;
    private Presenter f;
    private AdTemplate g;
    private AdInfo h;
    private com.kwad.sdk.core.download.b.b i;
    private com.kwad.sdk.a.c.a j;
    private g k;
    private KsAdVideoPlayConfig l;

    public b(@NonNull Context context) {
        super(context);
        c();
    }

    private void c() {
        inflate(getContext(), R.layout.ksad_native_video_layout, this);
        this.c = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.d = (DetailVideoView) this.c.findViewById(R.id.ksad_video_player);
        this.d.setAd(true);
    }

    private com.kwad.sdk.a.a.b d() {
        com.kwad.sdk.a.a.b bVar = new com.kwad.sdk.a.a.b();
        bVar.c = this.c;
        bVar.d = this.g;
        bVar.f8137a = this.f8139a;
        bVar.f8138b = this.f8140b;
        if (this.i == null && com.kwad.sdk.core.response.b.a.y(this.h)) {
            bVar.e = new com.kwad.sdk.core.download.b.b(this.g);
        } else {
            bVar.e = this.i;
        }
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
        presenter.a((Presenter) new com.kwad.sdk.a.b.b());
        presenter.a((Presenter) new k());
        if (this.l == null || !this.l.isDataFlowAutoStart()) {
            presenter.a((Presenter) new com.kwad.sdk.a.b.a());
        }
        presenter.a((Presenter) new com.kwad.sdk.a.b.g());
        if (com.kwad.sdk.core.response.b.a.y(this.h)) {
            presenter.a((Presenter) new f());
        } else {
            presenter.a((Presenter) new h());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    protected void a() {
        this.e = d();
        this.f = e();
        this.f.a((View) this.c);
        this.f.a(this.e);
        this.k.a();
        this.j.a();
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.g = adTemplate;
        this.h = com.kwad.sdk.core.response.b.c.j(this.g);
        this.i = bVar;
        this.l = ksAdVideoPlayConfig;
        this.k = new g(getParent() == null ? this : (View) getParent(), 30);
        this.j = new com.kwad.sdk.a.c.a(this.g, this.k, this.d, ksAdVideoPlayConfig);
    }

    @Override // com.kwad.sdk.core.view.b
    protected void b() {
        if (this.k != null) {
            this.k.c();
        }
        if (this.j != null) {
            this.j.b();
        }
        if (this.e != null) {
            this.e.a();
        }
        if (this.f != null) {
            this.f.j();
        }
    }

    public void setAdInteractionListener(KsNativeAd.AdInteractionListener adInteractionListener) {
        this.f8139a = adInteractionListener;
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f8140b = videoPlayListener;
    }
}
