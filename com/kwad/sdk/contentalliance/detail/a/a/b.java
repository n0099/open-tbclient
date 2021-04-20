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
    public TextView f32234b;

    /* renamed from: c  reason: collision with root package name */
    public String f32235c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f32236d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32237e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32238f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f32239g = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                ao.a(b.this.f32234b, b.this.f32235c, b.this.e());
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                b.this.f32234b.setText(b.this.f32235c);
                b.this.f32234b.setVisibility(0);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e() {
        AdTemplate adTemplate = this.f32237e;
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
        com.kwad.sdk.core.report.b.a(this.f32237e, 25, this.f32236d.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a;
        AdTemplate adTemplate = cVar.j;
        this.f32237e = adTemplate;
        this.f32238f = cVar.o;
        this.f32235c = com.kwad.sdk.core.response.b.c.w(adTemplate);
        if (com.kwad.sdk.core.response.b.c.c(this.f32237e)) {
            this.f32234b.post(this.f32239g);
        } else if (ag.a(this.f32235c)) {
            this.f32234b.setVisibility(8);
            return;
        } else {
            this.f32234b.setText(this.f32235c);
        }
        this.f32234b.setVisibility(0);
        this.f32234b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32234b.removeCallbacks(this.f32239g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32236d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32234b = (TextView) b(R.id.ksad_bottom_content_describe);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f32237e)) {
            com.kwad.sdk.core.download.b.a.a(this.f32234b.getContext(), this.f32237e, new a.InterfaceC0393a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                public void a() {
                    b.this.f();
                }
            }, this.f32238f);
        }
    }
}
