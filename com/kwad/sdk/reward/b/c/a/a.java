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
    public FrameLayout f33752b;

    /* renamed from: c  reason: collision with root package name */
    public f f33753c = new f() { // from class: com.kwad.sdk.reward.b.c.a.a.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) a.this).f33839a.t || ((d) a.this).f33839a.m == null) {
                return;
            }
            ((d) a.this).f33839a.m.c();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public a.b f33754d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.a.4
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0373a c0373a) {
            ((d) a.this).f33839a.f33562b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f33839a;
        AdTemplate adTemplate = aVar.f33566f;
        com.kwad.sdk.c.a aVar2 = aVar.m;
        if (aVar2 != null) {
            aVar.s = true;
            aVar2.a(this.f33754d);
            aVar2.a(this.f33752b, ((d) this).f33839a.f33568h, adTemplate);
            aVar2.a(new a.b() { // from class: com.kwad.sdk.reward.b.c.a.a.1
                @Override // com.kwad.sdk.c.a.b
                public void a(boolean z) {
                    ((d) a.this).f33839a.s = z;
                }
            });
            aVar2.a(((d) this).f33839a.f33567g);
            aVar2.a();
            aVar2.a(new a.InterfaceC0353a() { // from class: com.kwad.sdk.reward.b.c.a.a.2
                @Override // com.kwad.sdk.c.a.InterfaceC0353a
                public void a() {
                    if (((d) a.this).f33839a.f33562b != null) {
                        ((d) a.this).f33839a.f33562b.e();
                    }
                }
            });
            ((d) this).f33839a.a(this.f33753c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33752b = (FrameLayout) a(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f33839a.b(this.f33753c);
    }
}
