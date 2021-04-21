package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f34975b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f34976c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f34977d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (((com.kwad.sdk.draw.a.a) b.this).f34906a.f34907a != null) {
                ((com.kwad.sdk.draw.a.a) b.this).f34906a.f34907a.onAdClicked();
            }
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = ((com.kwad.sdk.draw.a.a) this).f34906a.f34913g;
        this.f34976c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f34977d);
        c cVar2 = this.f34976c;
        FrameLayout frameLayout = this.f34975b;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34906a;
        cVar2.a(frameLayout, bVar.f34908b, bVar.f34909c, bVar.f34910d);
        this.f34976c.g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        c cVar = this.f34976c;
        if (cVar != null) {
            cVar.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34975b = (FrameLayout) b(R.id.ksad_play_end_web_card_container);
    }
}
