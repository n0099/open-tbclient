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
/* loaded from: classes5.dex */
public class a extends KSFrameLayout {
    public final b a;
    public AdBaseFrameLayout b;
    public d c;
    public Presenter d;
    @NonNull
    public AdTemplate e;
    public AdInfo f;
    public final int g;
    public String h;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i, String str) {
        super(context);
        this.h = str;
        this.g = i;
        this.a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0426, this);
        this.b = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09112a);
    }

    private d d() {
        d dVar = new d();
        dVar.c = this.b;
        dVar.d = this.e;
        dVar.a = this.g;
        if (com.kwad.sdk.core.response.a.a.B(this.f)) {
            dVar.e = new com.kwad.sdk.core.download.a.b(this.e);
        }
        dVar.b = new e() { // from class: com.kwad.sdk.core.download.kwai.a.1
            @Override // com.kwad.sdk.core.download.kwai.e
            public void a(boolean z) {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                if (z) {
                    com.kwad.sdk.core.report.a.n(a.this.e);
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
        presenter.a((Presenter) new f(this.h));
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.c = d();
        Presenter e = e();
        this.d = e;
        e.c(this.b);
        this.d.a(this.c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.e = adTemplate;
        this.f = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        d dVar = this.c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.d;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void c() {
    }
}
