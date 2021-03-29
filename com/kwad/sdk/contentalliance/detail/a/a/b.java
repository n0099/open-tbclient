package com.kwad.sdk.contentalliance.detail.a.a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f31945b;

    /* renamed from: c  reason: collision with root package name */
    public String f31946c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f31947d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f31948e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31949f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f31950g = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                ao.a(b.this.f31945b, b.this.f31946c, b.this.e());
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                b.this.f31945b.setText(b.this.f31946c);
                b.this.f31945b.setVisibility(0);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e() {
        AdTemplate adTemplate = this.f31948e;
        String v = adTemplate != null ? com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.j(adTemplate)) : "广告";
        TextView textView = new TextView(o());
        textView.setText(v);
        textView.setPadding(ao.a(o(), 2.0f), ao.a(o(), 0.0f), ao.a(o(), 2.0f), ao.a(o(), 1.0f));
        textView.setGravity(17);
        textView.setTextColor(-1291845633);
        textView.setBackground(o().getResources().getDrawable(R.drawable.ksad_content_logo_bg));
        textView.setTextSize(10.0f);
        return ao.a(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.report.b.a(this.f31948e, 25, this.f31947d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        AdTemplate adTemplate = cVar.j;
        this.f31948e = adTemplate;
        this.f31949f = cVar.o;
        this.f31946c = com.kwad.sdk.core.response.b.c.w(adTemplate);
        if (com.kwad.sdk.core.response.b.c.c(this.f31948e)) {
            this.f31945b.post(this.f31950g);
        } else if (ag.a(this.f31946c)) {
            this.f31945b.setVisibility(8);
            return;
        } else {
            this.f31945b.setText(this.f31946c);
        }
        this.f31945b.setVisibility(0);
        this.f31945b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f31945b.removeCallbacks(this.f31950g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31947d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f31945b = (TextView) b(R.id.ksad_bottom_content_describe);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f31948e)) {
            com.kwad.sdk.core.download.b.a.a(this.f31945b.getContext(), this.f31948e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    b.this.f();
                }
            }, this.f31949f);
        }
    }
}
