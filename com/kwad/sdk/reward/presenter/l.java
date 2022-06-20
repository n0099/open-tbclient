package com.kwad.sdk.reward.presenter;

import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.af;
/* loaded from: classes5.dex */
public class l extends com.kwad.sdk.reward.g {
    public DetailVideoView b;
    public ViewGroup c;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        DetailVideoView detailVideoView;
        int i;
        super.a();
        this.b = (DetailVideoView) a(R.id.obfuscated_res_0x7f091132);
        this.c = (ViewGroup) a(R.id.obfuscated_res_0x7f090fca);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.g);
        if (!(!af.e(q())) || (!f() && !g())) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.M(j)) {
            detailVideoView = this.b;
            i = 17;
        } else {
            detailVideoView = this.b;
            i = 21;
        }
        detailVideoView.a(i);
    }
}
