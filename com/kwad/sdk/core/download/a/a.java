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
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.view.b {

    /* renamed from: a  reason: collision with root package name */
    public final Dialog f34258a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34259b;

    /* renamed from: c  reason: collision with root package name */
    public d f34260c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f34261d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34262e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f34263f;

    /* renamed from: g  reason: collision with root package name */
    public final int f34264g;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2) {
        super(context);
        this.f34264g = i2;
        this.f34258a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f34259b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f34274d = this.f34259b;
        dVar.f34275e = this.f34262e;
        dVar.f34271a = this.f34264g;
        if (com.kwad.sdk.core.response.b.a.y(this.f34263f)) {
            dVar.f34276f = new com.kwad.sdk.core.download.b.b(this.f34262e);
        }
        dVar.f34272b = new e() { // from class: com.kwad.sdk.core.download.a.a.1
            @Override // com.kwad.sdk.core.download.a.e
            public void a() {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                com.kwad.sdk.core.report.b.o(a.this.f34262e);
                if (a.this.f34258a == null || !a.this.f34258a.isShowing()) {
                    return;
                }
                a.this.f34258a.dismiss();
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
        this.f34260c = d();
        Presenter e2 = e();
        this.f34261d = e2;
        e2.a((View) this.f34259b);
        this.f34261d.a(this.f34260c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f34262e = adTemplate;
        this.f34263f = com.kwad.sdk.core.response.b.c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        d dVar = this.f34260c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f34261d;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void c() {
    }
}
