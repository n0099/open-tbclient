package com.kwad.components.ad.draw.a.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.i.b;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    public com.kwad.sdk.core.webview.a.kwai.a bJ = new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.draw.a.b.b.1
        @Override // com.kwad.sdk.core.webview.a.kwai.a
        public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
            if (b.this.aK.aJ != null) {
                b.this.aK.aJ.onAdClicked();
            }
        }
    };
    public FrameLayout bS;
    @Nullable
    public com.kwad.components.ad.i.b bb;

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.i.b bVar = this.aK.bb;
        this.bb = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.bJ);
        com.kwad.components.ad.i.b bVar2 = this.bb;
        FrameLayout frameLayout = this.bS;
        com.kwad.components.ad.draw.kwai.b bVar3 = this.aK;
        bVar2.a(frameLayout, bVar3.mRootContainer, bVar3.mAdTemplate, bVar3.mApkDownloadHelper);
        this.bb.a((b.InterfaceC0610b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bS = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09133e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.i.b bVar = this.bb;
        if (bVar != null) {
            bVar.bt();
        }
    }
}
