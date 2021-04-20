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
    public ImageView f35289b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35290c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35291d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35292e;

    /* renamed from: f  reason: collision with root package name */
    public String f35293f;

    /* renamed from: g  reason: collision with root package name */
    public long f35294g;

    /* renamed from: h  reason: collision with root package name */
    public e f35295h = new f() { // from class: com.kwad.sdk.fullscreen.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.f35294g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f35290c.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f35291d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f35290c.getLayoutParams();
        ImageView imageView = this.f35289b;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f35290c.setLayoutParams(layoutParams);
        this.f35290c.setText(j);
        this.f35290c.setVisibility(0);
        this.f35290c.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f35291d, 18, ((com.kwad.sdk.reward.d) this).f36747a.f36509d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f35291d, 40, ((com.kwad.sdk.reward.d) this).f36747a.f36513h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36747a.f36509d);
        ((com.kwad.sdk.reward.d) this).f36747a.f36507b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f36747a.f36511f;
        this.f35291d = adTemplate;
        this.f35294g = com.kwad.sdk.core.response.b.b.i(adTemplate);
        String j = com.kwad.sdk.core.response.b.b.j(this.f35291d);
        this.f35293f = j;
        if (TextUtils.isEmpty(j)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36747a;
        this.f35292e = aVar.j;
        aVar.i.a(this.f35295h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (TextUtils.isEmpty(this.f35293f)) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f36747a.i.b(this.f35295h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35290c = (TextView) b(R.id.ksad_detail_call_btn);
        this.f35289b = (ImageView) b(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35290c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35291d, new a.InterfaceC0393a() { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                public void a() {
                    b.this.g();
                }
            }, this.f35292e);
        }
    }
}
