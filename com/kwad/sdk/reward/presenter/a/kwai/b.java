package com.kwad.sdk.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.i.a;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes7.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f40909b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f40910c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f40911d = false;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40912e = new e() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            super.a(j, j2);
            b.this.f40910c = j2;
            b.this.f40911d = j - j2 < 800;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public f f40913f = new f() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.4
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) b.this).a.p != null) {
                ((g) b.this).a.p.c();
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public b.c f40914g = new b.c() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) b.this).a.f40742b.a();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40910c = 0L;
        this.f40911d = false;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f40747g;
        com.kwad.sdk.i.a aVar2 = aVar.p;
        if (aVar2 != null) {
            aVar.x = true;
            aVar2.a(this.f40914g);
            aVar2.a(this.f40909b, ((g) this).a.j, adTemplate);
            aVar2.a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.2
                @Override // com.kwad.sdk.i.a.b
                public void a(boolean z) {
                    ((g) b.this).a.x = z;
                }
            });
            aVar2.a(((g) this).a.f40748h);
            aVar2.a();
            aVar2.a(new a.InterfaceC1985a() { // from class: com.kwad.sdk.reward.presenter.a.kwai.b.3
                @Override // com.kwad.sdk.i.a.InterfaceC1985a
                public void a() {
                    if (((g) b.this).a.f40742b != null) {
                        long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(((g) b.this).a.f40747g));
                        boolean z = true;
                        if (p >= 0 && !b.this.f40911d && b.this.f40910c < p) {
                            z = false;
                        }
                        if (z) {
                            ((g) b.this).a.f40742b.e();
                        }
                    }
                }
            });
            ((g) this).a.a(this.f40913f);
            ((g) this).a.k.a(this.f40912e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f40913f);
        ((g) this).a.k.b(this.f40912e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40909b = (FrameLayout) a(R.id.obfuscated_res_0x7f0910b2);
    }
}
