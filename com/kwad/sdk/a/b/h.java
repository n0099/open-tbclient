package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public class h extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f8158b;
    private TextView c;
    private AdTemplate d;
    private AdInfo e;
    private com.kwad.sdk.contentalliance.detail.video.e f = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c.setText(com.kwad.sdk.core.response.b.a.w(this.e));
        this.f8158b.setOnClickListener(this);
        this.f8158b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f8158b.getContext(), this.d, new a.InterfaceC1088a() { // from class: com.kwad.sdk.a.b.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1088a
            public void a() {
                com.kwad.sdk.core.report.b.a(h.this.d, 2, h.this.f8136a.c.getTouchCoords());
            }
        }, null);
    }

    private void g() {
        this.f8136a.f8137a.onAdClicked(this.f8158b, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = this.f8136a.d;
        this.e = com.kwad.sdk.core.response.b.c.j(this.d);
        this.f8136a.f.a(this.f);
        this.f8158b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8136a.f.b(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8158b = (ViewGroup) b(R.id.ksad_video_complete_h5_container);
        this.c = (TextView) b(R.id.ksad_h5_open);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
        g();
    }
}
