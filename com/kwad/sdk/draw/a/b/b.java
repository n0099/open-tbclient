package com.kwad.sdk.draw.a.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.b;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f56919b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f56920c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f56921d = new b.c() { // from class: com.kwad.sdk.draw.a.b.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            if (((com.kwad.sdk.draw.kwai.a) b.this).a.a != null) {
                ((com.kwad.sdk.draw.kwai.a) b.this).a.a.onAdClicked();
            }
        }
    };

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.i.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a.f56955g;
        this.f56920c = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.f56921d);
        com.kwad.sdk.i.b bVar2 = this.f56920c;
        FrameLayout frameLayout = this.f56919b;
        com.kwad.sdk.draw.kwai.b bVar3 = ((com.kwad.sdk.draw.kwai.a) this).a;
        bVar2.a(frameLayout, bVar3.f56950b, bVar3.f56951c, bVar3.f56952d);
        this.f56920c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.i.b bVar = this.f56920c;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56919b = (FrameLayout) a(R.id.ksad_play_end_web_card_container);
    }
}
