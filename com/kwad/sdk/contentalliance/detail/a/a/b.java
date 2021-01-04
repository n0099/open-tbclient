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
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private TextView f8591b;
    private String c;
    private AdBaseFrameLayout d;
    private AdTemplate e;
    private com.kwad.sdk.core.download.b.b f;
    private Runnable g = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                ao.a(b.this.f8591b, b.this.c, b.this.e());
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
                b.this.f8591b.setText(b.this.c);
                b.this.f8591b.setVisibility(0);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e() {
        String v = this.e != null ? com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.j(this.e)) : "广告";
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
        com.kwad.sdk.core.report.b.a(this.e, 25, this.d.getTouchCoords());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.e = this.f8692a.j;
        this.f = this.f8692a.o;
        this.c = com.kwad.sdk.core.response.b.c.w(this.e);
        if (com.kwad.sdk.core.response.b.c.c(this.e)) {
            this.f8591b.post(this.g);
            this.f8591b.setVisibility(0);
            this.f8591b.setOnClickListener(this);
        } else if (ag.a(this.c)) {
            this.f8591b.setVisibility(8);
        } else {
            this.f8591b.setText(this.c);
            this.f8591b.setVisibility(0);
            this.f8591b.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8591b.removeCallbacks(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f8591b = (TextView) b(R.id.ksad_bottom_content_describe);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.e)) {
            com.kwad.sdk.core.download.b.a.a(this.f8591b.getContext(), this.e, new a.InterfaceC1064a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
                public void a() {
                    b.this.f();
                }
            }, this.f);
        }
    }
}
