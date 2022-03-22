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
/* loaded from: classes7.dex */
public class a extends KSFrameLayout {
    @Nullable
    public KsDrawAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f40299b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f40300c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.kwai.b f40301d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f40302e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f40303f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f40304g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.b.a f40305h;
    public f i;
    public Context j;

    public a(@NonNull Context context) {
        super(context);
        this.j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.j, R.layout.obfuscated_res_0x7f0d0431, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091131);
        this.f40299b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f091177);
        this.f40300c = detailVideoView;
        detailVideoView.setAd(true);
        this.f40300c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.a.a.a(new a.C1956a(a.this.f40301d.f40359b.getContext()).a(a.this.f40301d.f40360c).a(a.this.f40301d.f40361d).a(false).a(3).a(new a.b() { // from class: com.kwad.sdk.draw.a.1.1
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
        bVar.f40359b = this.f40299b;
        bVar.f40360c = this.f40303f;
        if (com.kwad.sdk.core.response.a.a.B(this.f40304g)) {
            bVar.f40361d = new com.kwad.sdk.core.download.a.b(this.f40303f);
        }
        bVar.f40362e = this.f40305h;
        bVar.f40363f = new com.kwad.sdk.draw.a.a.a(this.f40303f);
        if (com.kwad.sdk.core.response.a.b.h(this.f40303f)) {
            bVar.f40364g = new com.kwad.sdk.i.b();
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
        if (com.kwad.sdk.core.response.a.b.d(this.f40303f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.a.b.a());
        if (com.kwad.sdk.core.response.a.b.h(this.f40303f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.b.b());
        }
        if (com.kwad.sdk.core.response.a.a.D(this.f40304g)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f40301d = d();
        Presenter e2 = e();
        this.f40302e = e2;
        e2.c(this.f40299b);
        this.f40302e.a(this.f40301d);
        this.i.a();
        this.f40305h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f40303f = adTemplate;
        this.f40304g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        f fVar = new f(this, 70);
        this.i = fVar;
        this.f40305h = new com.kwad.sdk.draw.b.a(this.f40303f, fVar, this.f40300c);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.i;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.draw.b.a aVar = this.f40305h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.kwai.b bVar = this.f40301d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f40302e;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }
}
