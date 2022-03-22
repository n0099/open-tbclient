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
    public AdBaseFrameLayout f39479b;

    /* renamed from: c  reason: collision with root package name */
    public d f39480c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f39481d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f39482e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f39483f;

    /* renamed from: g  reason: collision with root package name */
    public final int f39484g;

    /* renamed from: h  reason: collision with root package name */
    public String f39485h;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i, String str) {
        super(context);
        this.f39485h = str;
        this.f39484g = i;
        this.a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d042b, this);
        this.f39479b = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091131);
    }

    private d d() {
        d dVar = new d();
        dVar.f39491c = this.f39479b;
        dVar.f39492d = this.f39482e;
        dVar.a = this.f39484g;
        if (com.kwad.sdk.core.response.a.a.B(this.f39483f)) {
            dVar.f39493e = new com.kwad.sdk.core.download.a.b(this.f39482e);
        }
        dVar.f39490b = new e() { // from class: com.kwad.sdk.core.download.kwai.a.1
            @Override // com.kwad.sdk.core.download.kwai.e
            public void a(boolean z) {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                if (z) {
                    com.kwad.sdk.core.report.a.n(a.this.f39482e);
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
        presenter.a((Presenter) new f(this.f39485h));
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f39480c = d();
        Presenter e2 = e();
        this.f39481d = e2;
        e2.c(this.f39479b);
        this.f39481d.a(this.f39480c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f39482e = adTemplate;
        this.f39483f = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        d dVar = this.f39480c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f39481d;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void c() {
    }
}
