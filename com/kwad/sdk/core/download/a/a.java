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
public class a extends com.kwad.sdk.core.view.a {

    /* renamed from: a  reason: collision with root package name */
    public final Dialog f32122a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f32123b;

    /* renamed from: c  reason: collision with root package name */
    public d f32124c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f32125d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32126e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f32127f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32128g;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2) {
        super(context);
        this.f32128g = i2;
        this.f32122a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f32123b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f32138d = this.f32123b;
        dVar.f32139e = this.f32126e;
        dVar.f32135a = this.f32128g;
        if (com.kwad.sdk.core.response.b.a.v(this.f32127f)) {
            dVar.f32140f = new com.kwad.sdk.core.download.b.b(this.f32126e);
        }
        dVar.f32136b = new e() { // from class: com.kwad.sdk.core.download.a.a.1
            @Override // com.kwad.sdk.core.download.a.e
            public void a() {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                com.kwad.sdk.core.report.b.m(a.this.f32126e);
                if (a.this.f32122a == null || !a.this.f32122a.isShowing()) {
                    return;
                }
                a.this.f32122a.dismiss();
            }
        };
        return dVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new f());
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.a
    public void a() {
        this.f32124c = d();
        Presenter e2 = e();
        this.f32125d = e2;
        e2.a((View) this.f32123b);
        this.f32125d.a(this.f32124c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f32126e = adTemplate;
        this.f32127f = com.kwad.sdk.core.response.b.c.g(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.a
    public void b() {
        d dVar = this.f32124c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f32125d;
        if (presenter != null) {
            presenter.g();
        }
    }

    public void c() {
    }
}
