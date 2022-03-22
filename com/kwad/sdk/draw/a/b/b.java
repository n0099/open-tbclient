package com.kwad.sdk.draw.a.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.b;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f40330b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f40331c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f40332d = new b.c() { // from class: com.kwad.sdk.draw.a.b.b.1
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
        com.kwad.sdk.i.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a.f40364g;
        this.f40331c = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.f40332d);
        com.kwad.sdk.i.b bVar2 = this.f40331c;
        FrameLayout frameLayout = this.f40330b;
        com.kwad.sdk.draw.kwai.b bVar3 = ((com.kwad.sdk.draw.kwai.a) this).a;
        bVar2.a(frameLayout, bVar3.f40359b, bVar3.f40360c, bVar3.f40361d);
        this.f40331c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.i.b bVar = this.f40331c;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40330b = (FrameLayout) a(R.id.obfuscated_res_0x7f0910c1);
    }
}
