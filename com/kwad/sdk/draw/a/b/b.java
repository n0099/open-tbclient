package com.kwad.sdk.draw.a.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.b;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.draw.kwai.a {
    public FrameLayout b;
    @Nullable
    public com.kwad.sdk.i.b c;
    public b.c d = new b.c() { // from class: com.kwad.sdk.draw.a.b.b.1
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
        com.kwad.sdk.i.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a.g;
        this.c = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.d);
        com.kwad.sdk.i.b bVar2 = this.c;
        FrameLayout frameLayout = this.b;
        com.kwad.sdk.draw.kwai.b bVar3 = ((com.kwad.sdk.draw.kwai.a) this).a;
        bVar2.a(frameLayout, bVar3.b, bVar3.c, bVar3.d);
        this.c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.i.b bVar = this.c;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (FrameLayout) a(R.id.obfuscated_res_0x7f0910ba);
    }
}
