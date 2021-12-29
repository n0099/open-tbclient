package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
/* loaded from: classes3.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f59841b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f59842c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59843d;

    /* renamed from: e  reason: collision with root package name */
    public long f59844e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59845f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= b.this.f59844e) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f59841b.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f59842c);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f59841b.setText(e2);
        this.f59841b.setVisibility(0);
        this.f59841b.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f59842c, 18, ((g) this).a.f59453e);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f59455g;
        this.f59842c = adTemplate;
        this.f59843d = aVar.l;
        this.f59844e = com.kwad.sdk.core.response.a.c.d(adTemplate);
        ((g) this).a.f59459k.a(this.f59845f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.f59459k.b(this.f59845f);
        this.f59841b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59841b = (TextView) a(R.id.ksad_detail_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f59841b) {
            ((g) this).a.a(view.getContext(), 40, 2);
        }
    }
}
