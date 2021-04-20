package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f34880b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f34881c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f34882d = new a.b() { // from class: com.kwad.sdk.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (((com.kwad.sdk.draw.a.a) b.this).f34811a.f34812a != null) {
                ((com.kwad.sdk.draw.a.a) b.this).f34811a.f34812a.onAdClicked();
            }
        }
    };

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = ((com.kwad.sdk.draw.a.a) this).f34811a.f34818g;
        this.f34881c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f34882d);
        c cVar2 = this.f34881c;
        FrameLayout frameLayout = this.f34880b;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34811a;
        cVar2.a(frameLayout, bVar.f34813b, bVar.f34814c, bVar.f34815d);
        this.f34881c.g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        c cVar = this.f34881c;
        if (cVar != null) {
            cVar.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34880b = (FrameLayout) b(R.id.ksad_play_end_web_card_container);
    }
}
