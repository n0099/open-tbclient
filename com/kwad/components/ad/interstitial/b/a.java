package com.kwad.components.ad.interstitial.b;

import android.view.OrientationEventListener;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.utils.ag;
/* loaded from: classes9.dex */
public final class a extends b {
    public ComplianceTextView gc;
    public OrientationEventListener gd;
    public KsAutoCloseView ge;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final c cVar) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(cVar.gi.getContext()) { // from class: com.kwad.components.ad.interstitial.b.a.2
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i) {
                a.this.b(cVar);
            }
        };
        this.gd = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.gd.enable();
        } else {
            this.gd.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        e((View) this.gc);
        if (ag.zL()) {
            com.kwad.sdk.b.kwai.a.b(this.ge, 0, com.kwad.sdk.b.kwai.a.a(getContext(), 25.0f), 0, 0);
        } else {
            com.kwad.sdk.b.kwai.a.b(this.ge, 0, 0, 0, 0);
        }
        this.gc.setVisibility(0);
        this.gc.setAdTemplate(cVar.mAdTemplate);
    }

    private void e(View view2) {
        int a = com.kwad.sdk.b.kwai.a.a(getContext(), 4.0f);
        int a2 = com.kwad.sdk.b.kwai.a.a(getContext(), 4.0f);
        com.kwad.sdk.b.kwai.a.b(view2, a2, a, a2, 0);
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        final c cVar = (c) xR();
        cVar.a(new c.e() { // from class: com.kwad.components.ad.interstitial.b.a.1
            @Override // com.kwad.components.ad.interstitial.b.c.e
            public final void onError() {
                a.this.b(cVar);
                a.this.a(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f09126b);
        this.ge = (KsAutoCloseView) findViewById(R.id.obfuscated_res_0x7f0912ac);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.gd;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }
}
