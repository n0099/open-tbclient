package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f33191b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f33192c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f33193d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0373a c0373a) {
            if (((com.kwad.sdk.draw.a.a) b.this).f33120a.f33121a != null) {
                ((com.kwad.sdk.draw.a.a) b.this).f33120a.f33121a.onAdClicked();
            }
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = ((com.kwad.sdk.draw.a.a) this).f33120a.f33127g;
        this.f33192c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f33193d);
        c cVar2 = this.f33192c;
        FrameLayout frameLayout = this.f33191b;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f33120a;
        cVar2.a(frameLayout, bVar.f33122b, bVar.f33123c, bVar.f33124d);
        this.f33192c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33191b = (FrameLayout) a(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        c cVar = this.f33192c;
        if (cVar != null) {
            cVar.g();
        }
    }
}
