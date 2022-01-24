package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.a.c;
import com.kwad.sdk.draw.a.d;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes3.dex */
public class a extends KSFrameLayout {
    @Nullable
    public KsDrawAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f56717b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f56718c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.kwai.b f56719d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f56720e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f56721f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f56722g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.b.a f56723h;

    /* renamed from: i  reason: collision with root package name */
    public f f56724i;

    /* renamed from: j  reason: collision with root package name */
    public Context f56725j;

    public a(@NonNull Context context) {
        super(context);
        this.f56725j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.f56725j, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f56717b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f56718c = detailVideoView;
        detailVideoView.setAd(true);
        this.f56718c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.a.a.a(new a.C2106a(a.this.f56719d.f56783b.getContext()).a(a.this.f56719d.f56784c).a(a.this.f56719d.f56785d).a(false).a(3).a(new a.b() { // from class: com.kwad.sdk.draw.a.1.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                    }
                }));
            }
        });
    }

    private com.kwad.sdk.draw.kwai.b d() {
        com.kwad.sdk.draw.kwai.b bVar = new com.kwad.sdk.draw.kwai.b();
        bVar.a = this.a;
        bVar.f56783b = this.f56717b;
        bVar.f56784c = this.f56721f;
        if (com.kwad.sdk.core.response.a.a.B(this.f56722g)) {
            bVar.f56785d = new com.kwad.sdk.core.download.a.b(this.f56721f);
        }
        bVar.f56786e = this.f56723h;
        bVar.f56787f = new com.kwad.sdk.draw.a.a.a(this.f56721f);
        if (com.kwad.sdk.core.response.a.b.h(this.f56721f)) {
            bVar.f56788g = new com.kwad.sdk.i.b();
        }
        return bVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.draw.a.kwai.a());
        presenter.a((Presenter) new com.kwad.sdk.draw.a.b());
        presenter.a((Presenter) new d());
        presenter.a((Presenter) new c());
        presenter.a((Presenter) new com.kwad.sdk.draw.a.a.b());
        if (com.kwad.sdk.core.response.a.b.d(this.f56721f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.a.b.a());
        if (com.kwad.sdk.core.response.a.b.h(this.f56721f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.b.b());
        }
        if (com.kwad.sdk.core.response.a.a.D(this.f56722g)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f56719d = d();
        Presenter e2 = e();
        this.f56720e = e2;
        e2.c(this.f56717b);
        this.f56720e.a(this.f56719d);
        this.f56724i.a();
        this.f56723h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f56721f = adTemplate;
        this.f56722g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        f fVar = new f(this, 70);
        this.f56724i = fVar;
        this.f56723h = new com.kwad.sdk.draw.b.a(this.f56721f, fVar, this.f56718c);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.f56724i;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.draw.b.a aVar = this.f56723h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.kwai.b bVar = this.f56719d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f56720e;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }
}
