package com.kwad.sdk.f.a;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class i extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {
    public DetailVideoView b;
    public AdTemplate c;
    public com.kwad.sdk.contentalliance.detail.video.d d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            i.this.b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.a.a.a(new a.C0296a(this.b.getContext()).a(this.c).a(((com.kwad.sdk.f.kwai.a) this).a.e).a(new a.b() { // from class: com.kwad.sdk.f.a.i.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(i.this.c, 2, ((com.kwad.sdk.f.kwai.a) i.this).a.c.getTouchCoords());
            }
        }));
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.c = bVar.d;
        bVar.f.a(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b.setOnClickListener(null);
        ((com.kwad.sdk.f.kwai.a) this).a.f.b(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (DetailVideoView) a(R.id.obfuscated_res_0x7f091171);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.b) {
            e();
            f();
        }
    }
}
