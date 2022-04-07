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
/* loaded from: classes5.dex */
public class a extends KSFrameLayout {
    @Nullable
    public KsDrawAd.AdInteractionListener a;
    public AdBaseFrameLayout b;
    public DetailVideoView c;
    public com.kwad.sdk.draw.kwai.b d;
    public Presenter e;
    @NonNull
    public AdTemplate f;
    public AdInfo g;
    public com.kwad.sdk.draw.b.a h;
    public f i;
    public Context j;

    public a(@NonNull Context context) {
        super(context);
        this.j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.j, R.layout.obfuscated_res_0x7f0d042c, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09112a);
        this.b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f091170);
        this.c = detailVideoView;
        detailVideoView.setAd(true);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.kwad.sdk.core.download.a.a.a(new a.C0296a(a.this.d.b.getContext()).a(a.this.d.c).a(a.this.d.d).a(false).a(3).a(new a.b() { // from class: com.kwad.sdk.draw.a.1.1
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
        bVar.b = this.b;
        bVar.c = this.f;
        if (com.kwad.sdk.core.response.a.a.B(this.g)) {
            bVar.d = new com.kwad.sdk.core.download.a.b(this.f);
        }
        bVar.e = this.h;
        bVar.f = new com.kwad.sdk.draw.a.a.a(this.f);
        if (com.kwad.sdk.core.response.a.b.h(this.f)) {
            bVar.g = new com.kwad.sdk.i.b();
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
        if (com.kwad.sdk.core.response.a.b.d(this.f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.a.b.a());
        if (com.kwad.sdk.core.response.a.b.h(this.f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.b.b());
        }
        if (com.kwad.sdk.core.response.a.a.D(this.g)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.d = d();
        Presenter e = e();
        this.e = e;
        e.c(this.b);
        this.e.a(this.d);
        this.i.a();
        this.h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f = adTemplate;
        this.g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        f fVar = new f(this, 70);
        this.i = fVar;
        this.h = new com.kwad.sdk.draw.b.a(this.f, fVar, this.c);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.i;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.draw.b.a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.kwai.b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.e;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }
}
