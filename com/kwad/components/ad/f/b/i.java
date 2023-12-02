package com.kwad.components.ad.f.b;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
/* loaded from: classes10.dex */
public final class i extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    public DetailVideoView mDetailVideoView;

    private void ey() {
        com.kwad.components.core.e.d.a.a(new a.C0644a(this.mDetailVideoView.getContext()).aq(this.mM.mAdTemplate).b(this.mM.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.ad.f.b.i.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(i.this.mM.mAdTemplate, 2, i.this.mM.mH.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.mM.mv.l(this.mDetailVideoView);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.i.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                i.this.mDetailVideoView.setOnClickListener(i.this);
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091500);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setOnClickListener(null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.mDetailVideoView) {
            ey();
            notifyAdClick();
        }
    }
}
