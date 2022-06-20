package com.kwad.sdk.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.i.a;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes5.dex */
public class b extends g {
    public FrameLayout b;
    public volatile long c = 0;
    public volatile boolean d = false;
    public com.kwad.sdk.contentalliance.detail.video.d e = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            super.a(j, j2);
            b.this.c = j2;
            b.this.d = j - j2 < 800;
        }
    };
    public f f = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.4
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) b.this).a.p != null) {
                ((g) b.this).a.p.c();
            }
        }
    };
    public b.c g = new b.c() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) b.this).a.b.a();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = 0L;
        this.d = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.g;
        com.kwad.sdk.i.a aVar2 = aVar.p;
        if (aVar2 != null) {
            aVar.x = true;
            aVar2.a(this.g);
            aVar2.a(this.b, ((g) this).a.j, adTemplate);
            aVar2.a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.2
                @Override // com.kwad.sdk.i.a.b
                public void a(boolean z) {
                    ((g) b.this).a.x = z;
                }
            });
            aVar2.a(((g) this).a.h);
            aVar2.a();
            aVar2.a(new a.InterfaceC0333a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.3
                @Override // com.kwad.sdk.i.a.InterfaceC0333a
                public void a() {
                    if (((g) b.this).a.b != null) {
                        long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(((g) b.this).a.g));
                        boolean z = true;
                        if (p >= 0 && !b.this.d && b.this.c < p) {
                            z = false;
                        }
                        if (z) {
                            ((g) b.this).a.b.e();
                        }
                    }
                }
            });
            ((g) this).a.a(this.f);
            ((g) this).a.k.a(this.e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f);
        ((g) this).a.k.b(this.e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (FrameLayout) a(R.id.obfuscated_res_0x7f09106d);
    }
}
