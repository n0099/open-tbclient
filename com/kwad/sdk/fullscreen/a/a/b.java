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
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35770b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35771c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35772d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35773e;

    /* renamed from: f  reason: collision with root package name */
    public String f35774f;

    /* renamed from: g  reason: collision with root package name */
    public long f35775g;

    /* renamed from: h  reason: collision with root package name */
    public e f35776h = new f() { // from class: com.kwad.sdk.fullscreen.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.f35775g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f35771c.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f35772d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f35771c.getLayoutParams();
        ImageView imageView = this.f35770b;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f35771c.setLayoutParams(layoutParams);
        this.f35771c.setText(j);
        this.f35771c.setVisibility(0);
        this.f35771c.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f35772d, 18, ((com.kwad.sdk.reward.d) this).f37299a.f37051d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f35772d, 40, ((com.kwad.sdk.reward.d) this).f37299a.f37055h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f37299a.f37051d);
        ((com.kwad.sdk.reward.d) this).f37299a.f37049b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f37299a.f37053f;
        this.f35772d = adTemplate;
        this.f35775g = com.kwad.sdk.core.response.b.b.i(adTemplate);
        String j = com.kwad.sdk.core.response.b.b.j(this.f35772d);
        this.f35774f = j;
        if (TextUtils.isEmpty(j)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37299a;
        this.f35773e = aVar.j;
        aVar.f37056i.a(this.f35776h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (TextUtils.isEmpty(this.f35774f)) {
            return;
        }
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.b(this.f35776h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35771c = (TextView) b(R.id.ksad_detail_call_btn);
        this.f35770b = (ImageView) b(R.id.ksad_skip_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35771c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35772d, new a.InterfaceC0382a() { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                    b.this.g();
                }
            }, this.f35773e);
        }
    }
}
