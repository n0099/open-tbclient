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
    public AdBaseFrameLayout f55836b;

    /* renamed from: c  reason: collision with root package name */
    public d f55837c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f55838d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f55839e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f55840f;

    /* renamed from: g  reason: collision with root package name */
    public final int f55841g;

    /* renamed from: h  reason: collision with root package name */
    public String f55842h;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2, String str) {
        super(context);
        this.f55842h = str;
        this.f55841g = i2;
        this.a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f55836b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f55848c = this.f55836b;
        dVar.f55849d = this.f55839e;
        dVar.a = this.f55841g;
        if (com.kwad.sdk.core.response.a.a.B(this.f55840f)) {
            dVar.f55850e = new com.kwad.sdk.core.download.a.b(this.f55839e);
        }
        dVar.f55847b = new e() { // from class: com.kwad.sdk.core.download.kwai.a.1
            @Override // com.kwad.sdk.core.download.kwai.e
            public void a(boolean z) {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                if (z) {
                    com.kwad.sdk.core.report.a.n(a.this.f55839e);
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
        presenter.a((Presenter) new f(this.f55842h));
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f55837c = d();
        Presenter e2 = e();
        this.f55838d = e2;
        e2.c(this.f55836b);
        this.f55838d.a(this.f55837c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f55839e = adTemplate;
        this.f55840f = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        d dVar = this.f55837c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f55838d;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void c() {
    }
}
