package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f35244b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f35245c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f35246d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (((com.kwad.sdk.draw.a.a) b.this).f35173a.f35174a != null) {
                ((com.kwad.sdk.draw.a.a) b.this).f35173a.f35174a.onAdClicked();
            }
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = ((com.kwad.sdk.draw.a.a) this).f35173a.f35180g;
        this.f35245c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f35246d);
        c cVar2 = this.f35245c;
        FrameLayout frameLayout = this.f35244b;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f35173a;
        cVar2.a(frameLayout, bVar.f35175b, bVar.f35176c, bVar.f35177d);
        this.f35245c.g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        c cVar = this.f35245c;
        if (cVar != null) {
            cVar.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35244b = (FrameLayout) b(R.id.ksad_play_end_web_card_container);
    }
}
