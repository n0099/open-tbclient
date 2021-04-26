package com.kwad.sdk.reward.b.c.a;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f34507b;

    /* renamed from: c  reason: collision with root package name */
    public f f34508c = new f() { // from class: com.kwad.sdk.reward.b.c.a.a.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) a.this).f34594a.t || ((d) a.this).f34594a.m == null) {
                return;
            }
            ((d) a.this).f34594a.m.c();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public a.b f34509d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0386a c0386a) {
            ((d) a.this).f34594a.f34317b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f34594a;
        AdTemplate adTemplate = aVar.f34321f;
        com.kwad.sdk.c.a aVar2 = aVar.m;
        if (aVar2 != null) {
            aVar.s = true;
            aVar2.a(this.f34509d);
            aVar2.a(this.f34507b, ((d) this).f34594a.f34323h, adTemplate);
            aVar2.a(new a.b() { // from class: com.kwad.sdk.reward.b.c.a.a.1
                @Override // com.kwad.sdk.c.a.b
                public void a(boolean z) {
                    ((d) a.this).f34594a.s = z;
                }
            });
            aVar2.a(((d) this).f34594a.f34322g);
            aVar2.a();
            aVar2.a(new a.InterfaceC0366a() { // from class: com.kwad.sdk.reward.b.c.a.a.2
                @Override // com.kwad.sdk.c.a.InterfaceC0366a
                public void a() {
                    if (((d) a.this).f34594a.f34317b != null) {
                        ((d) a.this).f34594a.f34317b.e();
                    }
                }
            });
            ((d) this).f34594a.a(this.f34508c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34507b = (FrameLayout) a(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f34594a.b(this.f34508c);
    }
}
