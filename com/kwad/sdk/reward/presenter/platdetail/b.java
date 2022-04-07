package com.kwad.sdk.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes5.dex */
public class b extends g implements d {
    public DetailVideoView b;
    public AdTemplate c;
    public com.kwad.sdk.core.download.a.b d;

    private void a(View view2, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C0296a(view2.getContext()).a(this.c).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.b.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                b.this.b(z);
            }
        }).a(this.d).a(false).a(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i = z ? 1 : 153;
        p.a aVar = new p.a();
        aVar.b = i;
        AdTemplate adTemplate = this.c;
        com.kwad.sdk.reward.a aVar2 = ((g) this).a;
        com.kwad.sdk.core.report.a.a(adTemplate, aVar2.e, aVar, aVar2.j.getTouchCoords(), (String) null);
        ((g) this).a.b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.c = aVar.g;
        this.d = aVar.l;
        new f(this.b, this);
        this.b.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.a.a.M(com.kwad.sdk.core.response.a.d.j(this.c)) ? "#B3000000" : "#4D000000"));
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.c)) {
            a(view2, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b.setClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (DetailVideoView) a(R.id.obfuscated_res_0x7f091170);
    }
}
