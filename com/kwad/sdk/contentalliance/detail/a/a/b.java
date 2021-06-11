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
    public TextView f32493b;

    /* renamed from: c  reason: collision with root package name */
    public String f32494c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f32495d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32496e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32497f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f32498g = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                ao.a(b.this.f32493b, b.this.f32494c, b.this.e());
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                b.this.f32493b.setText(b.this.f32494c);
                b.this.f32493b.setVisibility(0);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e() {
        AdTemplate adTemplate = this.f32496e;
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
        com.kwad.sdk.core.report.b.a(this.f32496e, 25, this.f32495d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        AdTemplate adTemplate = cVar.j;
        this.f32496e = adTemplate;
        this.f32497f = cVar.o;
        this.f32494c = com.kwad.sdk.core.response.b.c.w(adTemplate);
        if (com.kwad.sdk.core.response.b.c.c(this.f32496e)) {
            this.f32493b.post(this.f32498g);
        } else if (ag.a(this.f32494c)) {
            this.f32493b.setVisibility(8);
            return;
        } else {
            this.f32493b.setText(this.f32494c);
        }
        this.f32493b.setVisibility(0);
        this.f32493b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32493b.removeCallbacks(this.f32498g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32495d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32493b = (TextView) b(R.id.ksad_bottom_content_describe);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f32496e)) {
            com.kwad.sdk.core.download.b.a.a(this.f32493b.getContext(), this.f32496e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    b.this.f();
                }
            }, this.f32497f);
        }
    }
}
