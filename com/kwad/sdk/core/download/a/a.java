package com.kwad.sdk.core.download.a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.view.b {

    /* renamed from: a  reason: collision with root package name */
    public final Dialog f33537a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f33538b;

    /* renamed from: c  reason: collision with root package name */
    public d f33539c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f33540d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33541e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33542f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33543g;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i) {
        super(context);
        this.f33543g = i;
        this.f33537a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f33538b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f33553d = this.f33538b;
        dVar.f33554e = this.f33541e;
        dVar.f33550a = this.f33543g;
        if (com.kwad.sdk.core.response.b.a.y(this.f33542f)) {
            dVar.f33555f = new com.kwad.sdk.core.download.b.b(this.f33541e);
        }
        dVar.f33551b = new e() { // from class: com.kwad.sdk.core.download.a.a.1
            @Override // com.kwad.sdk.core.download.a.e
            public void a() {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                com.kwad.sdk.core.report.b.o(a.this.f33541e);
                if (a.this.f33537a == null || !a.this.f33537a.isShowing()) {
                    return;
                }
                a.this.f33537a.dismiss();
            }
        };
        return dVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new f());
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f33539c = d();
        Presenter e2 = e();
        this.f33540d = e2;
        e2.a((View) this.f33538b);
        this.f33540d.a(this.f33539c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f33541e = adTemplate;
        this.f33542f = com.kwad.sdk.core.response.b.c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        d dVar = this.f33539c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f33540d;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void c() {
    }
}
