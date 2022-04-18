package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
/* loaded from: classes5.dex */
public class b extends g implements View.OnClickListener {
    public TextView b;
    public AdTemplate c;
    public com.kwad.sdk.core.download.a.b d;
    public long e;
    public com.kwad.sdk.contentalliance.detail.video.d f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.e) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b.getVisibility() == 0) {
            return;
        }
        String e = com.kwad.sdk.core.response.a.c.e(this.c);
        if (TextUtils.isEmpty(e)) {
            return;
        }
        this.b.setText(e);
        this.b.setVisibility(0);
        this.b.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.c, 18, ((g) this).a.e);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.g;
        this.c = adTemplate;
        this.d = aVar.l;
        this.e = com.kwad.sdk.core.response.a.c.d(adTemplate);
        ((g) this).a.k.a(this.f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.k.b(this.f);
        this.b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (TextView) a(R.id.obfuscated_res_0x7f09105e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.b) {
            ((g) this).a.a(view2.getContext(), 40, 2);
        }
    }
}
