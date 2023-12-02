package com.kwad.components.core.webview.tachikoma.c;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.components.l;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public final class d extends Presenter {
    public FrameLayout SA;
    public l SG;
    public e Yv;
    public b aal;

    public final boolean onBackPressed() {
        l lVar = this.SG;
        if (lVar != null && lVar.onBackPressed()) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.SA = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0914da);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = (b) HU();
        this.aal = bVar;
        e eVar = bVar.Yv;
        this.Yv = eVar;
        if (eVar != null) {
            eVar.a(new com.kwad.components.core.webview.tachikoma.e.d() { // from class: com.kwad.components.core.webview.tachikoma.c.d.1
                @Override // com.kwad.components.core.webview.tachikoma.e.d
                public final void fP() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.d
                public final void fX() {
                }
            });
        }
        l a = this.aal.aao.a(null);
        this.SG = a;
        if (a == null) {
            this.aal.aan.callbackPageStatus(false, null);
            this.Yv.getDialog().dismiss();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view2 = this.SG.getView();
        view2.setLayoutParams(layoutParams);
        this.SA.addView(view2);
        this.SG.render();
        this.aal.aan.callbackPageStatus(true, null);
    }
}
