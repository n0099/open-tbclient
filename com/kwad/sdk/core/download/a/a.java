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
    public final Dialog f33826a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f33827b;

    /* renamed from: c  reason: collision with root package name */
    public d f33828c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f33829d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33830e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33831f;

    /* renamed from: g  reason: collision with root package name */
    public final int f33832g;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i) {
        super(context);
        this.f33832g = i;
        this.f33826a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f33827b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.f33842d = this.f33827b;
        dVar.f33843e = this.f33830e;
        dVar.f33839a = this.f33832g;
        if (com.kwad.sdk.core.response.b.a.y(this.f33831f)) {
            dVar.f33844f = new com.kwad.sdk.core.download.b.b(this.f33830e);
        }
        dVar.f33840b = new e() { // from class: com.kwad.sdk.core.download.a.a.1
            @Override // com.kwad.sdk.core.download.a.e
            public void a() {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                com.kwad.sdk.core.report.b.o(a.this.f33830e);
                if (a.this.f33826a == null || !a.this.f33826a.isShowing()) {
                    return;
                }
                a.this.f33826a.dismiss();
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
        this.f33828c = d();
        Presenter e2 = e();
        this.f33829d = e2;
        e2.a((View) this.f33827b);
        this.f33829d.a(this.f33828c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f33830e = adTemplate;
        this.f33831f = com.kwad.sdk.core.response.b.c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        d dVar = this.f33828c;
        if (dVar != null) {
            dVar.a();
        }
        Presenter presenter = this.f33829d;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void c() {
    }
}
