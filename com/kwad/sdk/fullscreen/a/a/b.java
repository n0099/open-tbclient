package com.kwad.sdk.fullscreen.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35384b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35385c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35386d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35387e;

    /* renamed from: f  reason: collision with root package name */
    public String f35388f;

    /* renamed from: g  reason: collision with root package name */
    public long f35389g;

    /* renamed from: h  reason: collision with root package name */
    public e f35390h = new f() { // from class: com.kwad.sdk.fullscreen.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.f35389g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f35385c.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f35386d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f35385c.getLayoutParams();
        ImageView imageView = this.f35384b;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f35385c.setLayoutParams(layoutParams);
        this.f35385c.setText(j);
        this.f35385c.setVisibility(0);
        this.f35385c.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f35386d, 18, ((com.kwad.sdk.reward.d) this).f36842a.f36604d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f35386d, 40, ((com.kwad.sdk.reward.d) this).f36842a.f36608h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36842a.f36604d);
        ((com.kwad.sdk.reward.d) this).f36842a.f36602b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f36842a.f36606f;
        this.f35386d = adTemplate;
        this.f35389g = com.kwad.sdk.core.response.b.b.i(adTemplate);
        String j = com.kwad.sdk.core.response.b.b.j(this.f35386d);
        this.f35388f = j;
        if (TextUtils.isEmpty(j)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36842a;
        this.f35387e = aVar.j;
        aVar.i.a(this.f35390h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (TextUtils.isEmpty(this.f35388f)) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f36842a.i.b(this.f35390h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35385c = (TextView) b(R.id.ksad_detail_call_btn);
        this.f35384b = (ImageView) b(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35385c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35386d, new a.InterfaceC0396a() { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                public void a() {
                    b.this.g();
                }
            }, this.f35387e);
        }
    }
}
