package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f34590b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f34591c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f34592d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (((com.kwad.sdk.draw.a.a) b.this).f34521a.f34522a != null) {
                ((com.kwad.sdk.draw.a.a) b.this).f34521a.f34522a.onAdClicked();
            }
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = ((com.kwad.sdk.draw.a.a) this).f34521a.f34528g;
        this.f34591c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f34592d);
        c cVar2 = this.f34591c;
        FrameLayout frameLayout = this.f34590b;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34521a;
        cVar2.a(frameLayout, bVar.f34523b, bVar.f34524c, bVar.f34525d);
        this.f34591c.g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        c cVar = this.f34591c;
        if (cVar != null) {
            cVar.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34590b = (FrameLayout) b(R.id.ksad_play_end_web_card_container);
    }
}
