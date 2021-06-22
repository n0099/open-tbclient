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
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f37154b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37155c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f37156d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37157e;

    /* renamed from: f  reason: collision with root package name */
    public long f37158f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f37159g = new f() { // from class: com.kwad.sdk.reward.b.b.b.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= b.this.f37158f) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f37154b.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f37156d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37154b.getLayoutParams();
        ImageView imageView = this.f37155c;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f37154b.setLayoutParams(layoutParams);
        this.f37154b.setText(j);
        this.f37154b.setVisibility(0);
        this.f37154b.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f37156d, 18, ((com.kwad.sdk.reward.d) this).f37299a.f37051d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f37156d, 40, ((com.kwad.sdk.reward.d) this).f37299a.f37055h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f37299a.f37051d);
        ((com.kwad.sdk.reward.d) this).f37299a.f37049b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f37299a;
        AdTemplate adTemplate = aVar.f37053f;
        this.f37156d = adTemplate;
        this.f37157e = aVar.j;
        this.f37158f = com.kwad.sdk.core.response.b.b.i(adTemplate);
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.a(this.f37159g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.reward.d) this).f37299a.f37056i.b(this.f37159g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37154b = (TextView) b(R.id.ksad_detail_call_btn);
        this.f37155c = (ImageView) b(R.id.ksad_detail_close_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37154b) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37156d, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.b.b.b.b.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                    b.this.g();
                }
            }, this.f37157e);
        }
    }
}
