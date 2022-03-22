package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
/* loaded from: classes7.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f41076b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f41077c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f41078d;

    /* renamed from: e  reason: collision with root package name */
    public long f41079e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f41080f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.f41079e) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f41076b.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.a.c.e(this.f41077c);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f41076b.setText(e2);
        this.f41076b.setVisibility(0);
        this.f41076b.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f41077c, 18, ((g) this).a.f40745e);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f40747g;
        this.f41077c = adTemplate;
        this.f41078d = aVar.l;
        this.f41079e = com.kwad.sdk.core.response.a.c.d(adTemplate);
        ((g) this).a.k.a(this.f41080f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f41080f);
        this.f41076b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f41076b = (TextView) a(R.id.obfuscated_res_0x7f091064);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f41076b) {
            ((g) this).a.a(view.getContext(), 40, 2);
        }
    }
}
