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
    public final Dialog f34160a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34161b;

    /* renamed from: c  reason: collision with root package name */
    public d f34162c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f34163d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34164e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f34165f;

    /* renamed from: g  reason: collision with root package name */
    public final int f34166g;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2) {
        super(context);
        this.f34166g = i2;
        this.f34160a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f34161b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f34176d = this.f34161b;
        dVar.f34177e = this.f34164e;
        dVar.f34173a = this.f34166g;
        if (com.kwad.sdk.core.response.b.a.y(this.f34165f)) {
            dVar.f34178f = new com.kwad.sdk.core.download.b.b(this.f34164e);
        }
        dVar.f34174b = new e() { // from class: com.kwad.sdk.core.download.a.a.1
            @Override // com.kwad.sdk.core.download.a.e
            public void a() {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                com.kwad.sdk.core.report.b.o(a.this.f34164e);
                if (a.this.f34160a == null || !a.this.f34160a.isShowing()) {
                    return;
                }
                a.this.f34160a.dismiss();
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
        this.f34162c = d();
        Presenter e2 = e();
        this.f34163d = e2;
        e2.a((View) this.f34161b);
        this.f34163d.a(this.f34162c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f34164e = adTemplate;
        this.f34165f = com.kwad.sdk.core.response.b.c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        d dVar = this.f34162c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f34163d;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void c() {
    }
}
