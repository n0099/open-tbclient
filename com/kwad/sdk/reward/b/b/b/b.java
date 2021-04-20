package com.kwad.sdk.reward.b.b.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f36608b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36609c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f36610d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36611e;

    /* renamed from: f  reason: collision with root package name */
    public long f36612f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f36613g = new f() { // from class: com.kwad.sdk.reward.b.b.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.f36612f) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f36608b.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f36610d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f36608b.getLayoutParams();
        ImageView imageView = this.f36609c;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f36608b.setLayoutParams(layoutParams);
        this.f36608b.setText(j);
        this.f36608b.setVisibility(0);
        this.f36608b.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f36610d, 18, ((com.kwad.sdk.reward.d) this).f36747a.f36509d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f36610d, 40, ((com.kwad.sdk.reward.d) this).f36747a.f36513h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36747a.f36509d);
        ((com.kwad.sdk.reward.d) this).f36747a.f36507b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36747a;
        AdTemplate adTemplate = aVar.f36511f;
        this.f36610d = adTemplate;
        this.f36611e = aVar.j;
        this.f36612f = com.kwad.sdk.core.response.b.b.i(adTemplate);
        ((com.kwad.sdk.reward.d) this).f36747a.i.a(this.f36613g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f36747a.i.b(this.f36613g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36608b = (TextView) b(R.id.ksad_detail_call_btn);
        this.f36609c = (ImageView) b(R.id.ksad_detail_close_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36608b) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36610d, new a.InterfaceC0393a() { // from class: com.kwad.sdk.reward.b.b.b.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                public void a() {
                    b.this.g();
                }
            }, this.f36611e);
        }
    }
}
