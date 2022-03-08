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
/* loaded from: classes8.dex */
public class b extends g implements d {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f56127b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f56128c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56129d;

    private void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C2095a(view.getContext()).a(this.f56128c).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.b.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                b.this.b(z);
            }
        }).a(this.f56129d).a(false).a(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i2 = z ? 1 : 153;
        p.a aVar = new p.a();
        aVar.f54623b = i2;
        AdTemplate adTemplate = this.f56128c;
        com.kwad.sdk.reward.a aVar2 = ((g) this).a;
        com.kwad.sdk.core.report.a.a(adTemplate, aVar2.f55767e, aVar, aVar2.f55772j.getTouchCoords(), (String) null);
        ((g) this).a.f55764b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f56128c = aVar.f55769g;
        this.f56129d = aVar.l;
        new f(this.f56127b, this);
        this.f56127b.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.a.a.M(com.kwad.sdk.core.response.a.d.j(this.f56128c)) ? "#B3000000" : "#4D000000"));
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f56128c)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56127b.setClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56127b = (DetailVideoView) a(R.id.ksad_video_player);
    }
}
