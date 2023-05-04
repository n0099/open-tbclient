package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
/* loaded from: classes8.dex */
public final class h extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    public ViewGroup ke;
    public TextView kf;

    /* JADX INFO: Access modifiers changed from: private */
    public void er() {
        this.kf.setText(com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(this.jL.mAdTemplate)));
        this.ke.setOnClickListener(this);
        this.ke.setVisibility(0);
    }

    private void et() {
        com.kwad.components.core.c.a.a.a(new a.C0596a(this.ke.getContext()).L(this.jL.mAdTemplate).ae(2).a(new a.b() { // from class: com.kwad.components.ad.e.a.h.2
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(h.this.jL.mAdTemplate, 2, h.this.jL.jK.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.jL.jC.i(this.ke);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.h.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                h.this.er();
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
        this.ke.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        et();
        notifyAdClick();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ke = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09138d);
        this.kf = (TextView) findViewById(R.id.obfuscated_res_0x7f091236);
    }
}
