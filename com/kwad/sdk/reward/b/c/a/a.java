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
    public FrameLayout f33681b;

    /* renamed from: c  reason: collision with root package name */
    public f f33682c = new f() { // from class: com.kwad.sdk.reward.b.c.a.a.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) a.this).f33768a.t || ((d) a.this).f33768a.m == null) {
                return;
            }
            ((d) a.this).f33768a.m.c();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public a.b f33683d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0374a c0374a) {
            ((d) a.this).f33768a.f33491b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f33768a;
        AdTemplate adTemplate = aVar.f33495f;
        com.kwad.sdk.c.a aVar2 = aVar.m;
        if (aVar2 != null) {
            aVar.s = true;
            aVar2.a(this.f33683d);
            aVar2.a(this.f33681b, ((d) this).f33768a.f33497h, adTemplate);
            aVar2.a(new a.b() { // from class: com.kwad.sdk.reward.b.c.a.a.1
                @Override // com.kwad.sdk.c.a.b
                public void a(boolean z) {
                    ((d) a.this).f33768a.s = z;
                }
            });
            aVar2.a(((d) this).f33768a.f33496g);
            aVar2.a();
            aVar2.a(new a.InterfaceC0354a() { // from class: com.kwad.sdk.reward.b.c.a.a.2
                @Override // com.kwad.sdk.c.a.InterfaceC0354a
                public void a() {
                    if (((d) a.this).f33768a.f33491b != null) {
                        ((d) a.this).f33768a.f33491b.e();
                    }
                }
            });
            ((d) this).f33768a.a(this.f33682c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33681b = (FrameLayout) a(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f33768a.b(this.f33682c);
    }
}
