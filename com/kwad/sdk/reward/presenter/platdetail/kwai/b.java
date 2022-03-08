package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f56140b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f56141c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56142d;

    /* renamed from: e  reason: collision with root package name */
    public long f56143e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56144f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (j3 >= b.this.f56143e) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f56140b.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f56141c);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f56140b.setText(e2);
        this.f56140b.setVisibility(0);
        this.f56140b.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f56141c, 18, ((g) this).a.f55767e);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f55769g;
        this.f56141c = adTemplate;
        this.f56142d = aVar.l;
        this.f56143e = com.kwad.sdk.core.response.a.c.d(adTemplate);
        ((g) this).a.k.a(this.f56144f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f56144f);
        this.f56140b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56140b = (TextView) a(R.id.ksad_detail_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56140b) {
            ((g) this).a.a(view.getContext(), 40, 2);
        }
    }
}
