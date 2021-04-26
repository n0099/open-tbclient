package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f33946b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f33947c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f33948d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0386a c0386a) {
            if (((com.kwad.sdk.draw.a.a) b.this).f33875a.f33876a != null) {
                ((com.kwad.sdk.draw.a.a) b.this).f33875a.f33876a.onAdClicked();
            }
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = ((com.kwad.sdk.draw.a.a) this).f33875a.f33882g;
        this.f33947c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f33948d);
        c cVar2 = this.f33947c;
        FrameLayout frameLayout = this.f33946b;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f33875a;
        cVar2.a(frameLayout, bVar.f33877b, bVar.f33878c, bVar.f33879d);
        this.f33947c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33946b = (FrameLayout) a(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        c cVar = this.f33947c;
        if (cVar != null) {
            cVar.g();
        }
    }
}
