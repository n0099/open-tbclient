package com.kwad.components.ad.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.k.b;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.draw.a.a {
    public com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.bO.bN != null) {
                b.this.bO.bN.onAdClicked();
            }
        }
    };
    @Nullable
    public com.kwad.components.ad.k.b ci;
    public FrameLayout da;

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.k.b bVar = this.bO.ci;
        this.ci = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.cR);
        com.kwad.components.ad.k.b bVar2 = this.ci;
        FrameLayout frameLayout = this.da;
        com.kwad.components.ad.draw.a.b bVar3 = this.bO;
        bVar2.a(frameLayout, bVar3.mRootContainer, bVar3.mAdTemplate, bVar3.mApkDownloadHelper);
        this.ci.a((b.InterfaceC0606b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.da = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0913e8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.k.b bVar = this.ci;
        if (bVar != null) {
            bVar.lP();
        }
    }
}
