package com.kwad.components.ad.e.a;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.DetailVideoView;
/* loaded from: classes8.dex */
public final class i extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    public DetailVideoView mDetailVideoView;

    private void et() {
        com.kwad.components.core.c.a.a.a(new a.C0594a(this.mDetailVideoView.getContext()).L(this.jL.mAdTemplate).b(this.jL.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.ad.e.a.i.2
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(i.this.jL.mAdTemplate, 2, i.this.jL.jK.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.jL.jC.i(this.mDetailVideoView);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.i.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                i.this.mDetailVideoView.setOnClickListener(i.this);
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.mDetailVideoView) {
            et();
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091397);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setOnClickListener(null);
    }
}
