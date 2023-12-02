package com.kwad.components.ad.interstitial.e;

import android.view.OrientationEventListener;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class a extends b {
    public ComplianceTextView jF;
    public OrientationEventListener jG;
    public KsAutoCloseView jH;

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) HU();
        b(cVar);
        a(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jF = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f09133b);
        this.jH = (KsAutoCloseView) findViewById(R.id.obfuscated_res_0x7f091383);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.jG;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    private void a(final c cVar) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(cVar.io.getContext()) { // from class: com.kwad.components.ad.interstitial.e.a.1
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i) {
                a.this.b(cVar);
            }
        };
        this.jG = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.jG.enable();
        } else {
            this.jG.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        h(this.jF);
        if (!ai.isOrientationPortrait()) {
            com.kwad.sdk.d.a.a.b(this.jH, 0, 0, 0, 0);
        } else {
            com.kwad.sdk.d.a.a.b(this.jH, 0, com.kwad.sdk.d.a.a.a(getContext(), 25.0f), 0, 0);
        }
        this.jF.setVisibility(0);
        this.jF.setAdTemplate(cVar.mAdTemplate);
    }

    private void h(View view2) {
        int a = com.kwad.sdk.d.a.a.a(getContext(), 4.0f);
        int a2 = com.kwad.sdk.d.a.a.a(getContext(), 4.0f);
        com.kwad.sdk.d.a.a.b(view2, a2, a, a2, 0);
    }
}
