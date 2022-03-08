package com.kwad.sdk.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.i.a;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f55949b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f55950c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f55951d = false;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55952e = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            b.this.f55950c = j3;
            b.this.f55951d = j2 - j3 < 800;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public f f55953f = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.4
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) b.this).a.p != null) {
                ((g) b.this).a.p.c();
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public b.c f55954g = new b.c() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) b.this).a.f55764b.a();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55950c = 0L;
        this.f55951d = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f55769g;
        com.kwad.sdk.i.a aVar2 = aVar.p;
        if (aVar2 != null) {
            aVar.x = true;
            aVar2.a(this.f55954g);
            aVar2.a(this.f55949b, ((g) this).a.f55772j, adTemplate);
            aVar2.a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.2
                @Override // com.kwad.sdk.i.a.b
                public void a(boolean z) {
                    ((g) b.this).a.x = z;
                }
            });
            aVar2.a(((g) this).a.f55770h);
            aVar2.a();
            aVar2.a(new a.InterfaceC2124a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.3
                @Override // com.kwad.sdk.i.a.InterfaceC2124a
                public void a() {
                    if (((g) b.this).a.f55764b != null) {
                        long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(((g) b.this).a.f55769g));
                        boolean z = true;
                        if (p >= 0 && !b.this.f55951d && b.this.f55950c < p) {
                            z = false;
                        }
                        if (z) {
                            ((g) b.this).a.f55764b.e();
                        }
                    }
                }
            });
            ((g) this).a.a(this.f55953f);
            ((g) this).a.k.a(this.f55952e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f55953f);
        ((g) this).a.k.b(this.f55952e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55949b = (FrameLayout) a(R.id.ksad_landing_page_container);
    }
}
