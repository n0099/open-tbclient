package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
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
/* loaded from: classes8.dex */
public class a extends KSFrameLayout {
    @Nullable
    public KsDrawAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f55234b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f55235c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.kwai.b f55236d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f55237e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f55238f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f55239g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.b.a f55240h;

    /* renamed from: i  reason: collision with root package name */
    public f f55241i;

    /* renamed from: j  reason: collision with root package name */
    public Context f55242j;

    public a(@NonNull Context context) {
        super(context);
        this.f55242j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.f55242j, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f55234b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f55235c = detailVideoView;
        detailVideoView.setAd(true);
        this.f55235c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.a.a.a(new a.C2095a(a.this.f55236d.f55300b.getContext()).a(a.this.f55236d.f55301c).a(a.this.f55236d.f55302d).a(false).a(3).a(new a.b() { // from class: com.kwad.sdk.draw.a.1.1
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
        bVar.f55300b = this.f55234b;
        bVar.f55301c = this.f55238f;
        if (com.kwad.sdk.core.response.a.a.B(this.f55239g)) {
            bVar.f55302d = new com.kwad.sdk.core.download.a.b(this.f55238f);
        }
        bVar.f55303e = this.f55240h;
        bVar.f55304f = new com.kwad.sdk.draw.a.a.a(this.f55238f);
        if (com.kwad.sdk.core.response.a.b.h(this.f55238f)) {
            bVar.f55305g = new com.kwad.sdk.i.b();
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
        if (com.kwad.sdk.core.response.a.b.d(this.f55238f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.a.b.a());
        if (com.kwad.sdk.core.response.a.b.h(this.f55238f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.b.b());
        }
        if (com.kwad.sdk.core.response.a.a.D(this.f55239g)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f55236d = d();
        Presenter e2 = e();
        this.f55237e = e2;
        e2.c(this.f55234b);
        this.f55237e.a(this.f55236d);
        this.f55241i.a();
        this.f55240h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f55238f = adTemplate;
        this.f55239g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        f fVar = new f(this, 70);
        this.f55241i = fVar;
        this.f55240h = new com.kwad.sdk.draw.b.a(this.f55238f, fVar, this.f55235c);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.f55241i;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.draw.b.a aVar = this.f55240h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.kwai.b bVar = this.f55236d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f55237e;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }
}
