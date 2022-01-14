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
    public AdBaseFrameLayout f55791b;

    /* renamed from: c  reason: collision with root package name */
    public d f55792c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f55793d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f55794e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f55795f;

    /* renamed from: g  reason: collision with root package name */
    public final int f55796g;

    /* renamed from: h  reason: collision with root package name */
    public String f55797h;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2, String str) {
        super(context);
        this.f55797h = str;
        this.f55796g = i2;
        this.a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f55791b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f55803c = this.f55791b;
        dVar.f55804d = this.f55794e;
        dVar.a = this.f55796g;
        if (com.kwad.sdk.core.response.a.a.B(this.f55795f)) {
            dVar.f55805e = new com.kwad.sdk.core.download.a.b(this.f55794e);
        }
        dVar.f55802b = new e() { // from class: com.kwad.sdk.core.download.kwai.a.1
            @Override // com.kwad.sdk.core.download.kwai.e
            public void a(boolean z) {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                if (z) {
                    com.kwad.sdk.core.report.a.n(a.this.f55794e);
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
        presenter.a((Presenter) new f(this.f55797h));
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f55792c = d();
        Presenter e2 = e();
        this.f55793d = e2;
        e2.c(this.f55791b);
        this.f55793d.a(this.f55792c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f55794e = adTemplate;
        this.f55795f = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        d dVar = this.f55792c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f55793d;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void c() {
    }
}
