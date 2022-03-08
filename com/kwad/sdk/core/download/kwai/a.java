package com.kwad.sdk.core.download.kwai;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes7.dex */
public class a extends KSFrameLayout {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f54353b;

    /* renamed from: c  reason: collision with root package name */
    public d f54354c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f54355d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f54356e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f54357f;

    /* renamed from: g  reason: collision with root package name */
    public final int f54358g;

    /* renamed from: h  reason: collision with root package name */
    public String f54359h;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2, String str) {
        super(context);
        this.f54359h = str;
        this.f54358g = i2;
        this.a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f54353b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f54365c = this.f54353b;
        dVar.f54366d = this.f54356e;
        dVar.a = this.f54358g;
        if (com.kwad.sdk.core.response.a.a.B(this.f54357f)) {
            dVar.f54367e = new com.kwad.sdk.core.download.a.b(this.f54356e);
        }
        dVar.f54364b = new e() { // from class: com.kwad.sdk.core.download.kwai.a.1
            @Override // com.kwad.sdk.core.download.kwai.e
            public void a(boolean z) {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                if (z) {
                    com.kwad.sdk.core.report.a.n(a.this.f54356e);
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
        presenter.a((Presenter) new f(this.f54359h));
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f54354c = d();
        Presenter e2 = e();
        this.f54355d = e2;
        e2.c(this.f54353b);
        this.f54355d.a(this.f54354c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f54356e = adTemplate;
        this.f54357f = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        d dVar = this.f54354c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f54355d;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void c() {
    }
}
