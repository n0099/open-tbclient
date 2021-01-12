package com.kwad.sdk.core.download.a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.core.view.b {

    /* renamed from: a  reason: collision with root package name */
    private final Dialog f9091a;

    /* renamed from: b  reason: collision with root package name */
    private AdBaseFrameLayout f9092b;
    private d c;
    private Presenter d;
    @NonNull
    private AdTemplate e;
    private AdInfo f;
    private final int g;

    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i) {
        super(context);
        this.g = i;
        this.f9091a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.f9092b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    private d d() {
        d dVar = new d();
        dVar.d = this.f9092b;
        dVar.e = this.e;
        dVar.f9098a = this.g;
        if (com.kwad.sdk.core.response.b.a.y(this.f)) {
            dVar.f = new com.kwad.sdk.core.download.b.b(this.e);
        }
        dVar.f9099b = new e() { // from class: com.kwad.sdk.core.download.a.a.1
            @Override // com.kwad.sdk.core.download.a.e
            public void a() {
                com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                com.kwad.sdk.core.report.b.o(a.this.e);
                if (a.this.f9091a == null || !a.this.f9091a.isShowing()) {
                    return;
                }
                a.this.f9091a.dismiss();
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
    protected void a() {
        this.c = d();
        this.d = e();
        this.d.a((View) this.f9092b);
        this.d.a(this.c);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.e = adTemplate;
        this.f = com.kwad.sdk.core.response.b.c.j(this.e);
    }

    @Override // com.kwad.sdk.core.view.b
    protected void b() {
        if (this.c != null) {
            this.c.a();
        }
        if (this.d != null) {
            this.d.j();
        }
    }

    public void c() {
    }
}
