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
    public TextView f57623b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f57624c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57625d;

    /* renamed from: e  reason: collision with root package name */
    public long f57626e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57627f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= b.this.f57626e) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f57623b.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f57624c);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f57623b.setText(e2);
        this.f57623b.setVisibility(0);
        this.f57623b.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f57624c, 18, ((g) this).a.f57250e);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f57252g;
        this.f57624c = adTemplate;
        this.f57625d = aVar.l;
        this.f57626e = com.kwad.sdk.core.response.a.c.d(adTemplate);
        ((g) this).a.k.a(this.f57627f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f57627f);
        this.f57623b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57623b = (TextView) a(R.id.ksad_detail_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57623b) {
            ((g) this).a.a(view.getContext(), 40, 2);
        }
    }
}
