package com.kwad.sdk.core.download.kwai;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes4.dex */
public class a extends KSFrameLayout {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f56003b;

    /* renamed from: c  reason: collision with root package name */
    public d f56004c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f56005d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f56006e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f56007f;

    /* renamed from: g  reason: collision with root package name */
    public final int f56008g;

    /* renamed from: h  reason: collision with root package name */
    public String f56009h;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2, String str) {
        super(context);
        this.f56009h = str;
        this.f56008g = i2;
        this.a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f56003b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f56015c = this.f56003b;
        dVar.f56016d = this.f56006e;
        dVar.a = this.f56008g;
        if (com.kwad.sdk.core.response.a.a.B(this.f56007f)) {
            dVar.f56017e = new com.kwad.sdk.core.download.a.b(this.f56006e);
        }
        dVar.f56014b = new e() { // from class: com.kwad.sdk.core.download.kwai.a.1
            @Override // com.kwad.sdk.core.download.kwai.e
            public void a(boolean z) {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                if (z) {
                    com.kwad.sdk.core.report.a.n(a.this.f56006e);
                }
                if (a.this.a == null || !a.this.a.isShowing()) {
                    return;
                }
                a.this.a.a(z);
            }
        };
        return dVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new f(this.f56009h));
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f56004c = d();
        Presenter e2 = e();
        this.f56005d = e2;
        e2.c(this.f56003b);
        this.f56005d.a(this.f56004c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f56006e = adTemplate;
        this.f56007f = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        d dVar = this.f56004c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f56005d;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void c() {
    }
}
