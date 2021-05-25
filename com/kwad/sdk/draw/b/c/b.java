package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f33120b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f33121c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f33122d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0374a c0374a) {
            if (((com.kwad.sdk.draw.a.a) b.this).f33049a.f33050a != null) {
                ((com.kwad.sdk.draw.a.a) b.this).f33049a.f33050a.onAdClicked();
            }
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = ((com.kwad.sdk.draw.a.a) this).f33049a.f33056g;
        this.f33121c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f33122d);
        c cVar2 = this.f33121c;
        FrameLayout frameLayout = this.f33120b;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f33049a;
        cVar2.a(frameLayout, bVar.f33051b, bVar.f33052c, bVar.f33053d);
        this.f33121c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33120b = (FrameLayout) a(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        c cVar = this.f33121c;
        if (cVar != null) {
            cVar.g();
        }
    }
}
