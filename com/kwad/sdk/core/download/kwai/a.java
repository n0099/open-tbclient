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
/* loaded from: classes3.dex */
public class a extends KSFrameLayout {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f57986b;

    /* renamed from: c  reason: collision with root package name */
    public d f57987c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f57988d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57989e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f57990f;

    /* renamed from: g  reason: collision with root package name */
    public final int f57991g;

    /* renamed from: h  reason: collision with root package name */
    public String f57992h;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2, String str) {
        super(context);
        this.f57992h = str;
        this.f57991g = i2;
        this.a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f57986b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f57998c = this.f57986b;
        dVar.f57999d = this.f57989e;
        dVar.a = this.f57991g;
        if (com.kwad.sdk.core.response.a.a.B(this.f57990f)) {
            dVar.f58000e = new com.kwad.sdk.core.download.a.b(this.f57989e);
        }
        dVar.f57997b = new e() { // from class: com.kwad.sdk.core.download.kwai.a.1
            @Override // com.kwad.sdk.core.download.kwai.e
            public void a(boolean z) {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                if (z) {
                    com.kwad.sdk.core.report.a.n(a.this.f57989e);
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
        presenter.a((Presenter) new f(this.f57992h));
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f57987c = d();
        Presenter e2 = e();
        this.f57988d = e2;
        e2.c(this.f57986b);
        this.f57988d.a(this.f57987c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f57989e = adTemplate;
        this.f57990f = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        d dVar = this.f57987c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f57988d;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void c() {
    }
}
