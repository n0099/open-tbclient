package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class h extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {
    public ViewGroup b;
    public TextView c;
    public AdTemplate d;
    public AdInfo e;
    public com.kwad.sdk.contentalliance.detail.video.d f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c.setText(com.kwad.sdk.core.response.a.a.A(this.e));
        this.b.setOnClickListener(this);
        this.b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.a.a.a(new a.C0304a(this.b.getContext()).a(this.d).a(2).a(new a.b() { // from class: com.kwad.sdk.f.a.h.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(h.this.d, 2, ((com.kwad.sdk.f.kwai.a) h.this).a.c.getTouchCoords());
            }
        }));
    }

    private void g() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.d;
        this.d = adTemplate;
        this.e = com.kwad.sdk.core.response.a.d.j(adTemplate);
        ((com.kwad.sdk.f.kwai.a) this).a.f.a(this.f);
        this.b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f.b(this.f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f091118);
        this.c = (TextView) a(R.id.obfuscated_res_0x7f091047);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        f();
        g();
    }
}
