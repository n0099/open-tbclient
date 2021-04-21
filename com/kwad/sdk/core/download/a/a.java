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
    public final Dialog f33921a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f33922b;

    /* renamed from: c  reason: collision with root package name */
    public d f33923c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f33924d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33925e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33926f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33927g;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i) {
        super(context);
        this.f33927g = i;
        this.f33921a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f33922b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f33937d = this.f33922b;
        dVar.f33938e = this.f33925e;
        dVar.f33934a = this.f33927g;
        if (com.kwad.sdk.core.response.b.a.y(this.f33926f)) {
            dVar.f33939f = new com.kwad.sdk.core.download.b.b(this.f33925e);
        }
        dVar.f33935b = new e() { // from class: com.kwad.sdk.core.download.a.a.1
            @Override // com.kwad.sdk.core.download.a.e
            public void a() {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                com.kwad.sdk.core.report.b.o(a.this.f33925e);
                if (a.this.f33921a == null || !a.this.f33921a.isShowing()) {
                    return;
                }
                a.this.f33921a.dismiss();
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
        this.f33923c = d();
        Presenter e2 = e();
        this.f33924d = e2;
        e2.a((View) this.f33922b);
        this.f33924d.a(this.f33923c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f33925e = adTemplate;
        this.f33926f = com.kwad.sdk.core.response.b.c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        d dVar = this.f33923c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f33924d;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void c() {
    }
}
