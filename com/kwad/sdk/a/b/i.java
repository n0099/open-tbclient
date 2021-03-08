package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class i extends com.kwad.sdk.a.a.a implements View.OnClickListener {
    private DetailVideoView b;
    private AdTemplate c;
    private com.kwad.sdk.contentalliance.detail.video.e d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            i.this.b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.b.a.a(this.b.getContext(), this.c, new a.InterfaceC1111a() { // from class: com.kwad.sdk.a.b.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
            public void a() {
                com.kwad.sdk.core.report.b.a(i.this.c, 2, i.this.f5425a.c.getTouchCoords());
            }
        }, this.f5425a.e);
    }

    private void f() {
        this.f5425a.f5426a.onAdClicked(this.b, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f5425a.d;
        this.f5425a.f.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.b.setOnClickListener(null);
        this.f5425a.f.b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (DetailVideoView) b(R.id.ksad_video_player);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b) {
            e();
            f();
        }
    }
}
