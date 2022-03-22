package com.kwad.sdk.reward.presenter;

import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.af;
/* loaded from: classes7.dex */
public class l extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f41021b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f41022c;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        DetailVideoView detailVideoView;
        int i;
        super.a();
        this.f41021b = (DetailVideoView) a(R.id.obfuscated_res_0x7f091177);
        this.f41022c = (ViewGroup) a(R.id.obfuscated_res_0x7f09100f);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f40747g);
        if (!(!af.e(q())) || (!f() && !g())) {
            this.f41022c.setVisibility(8);
            return;
        }
        this.f41022c.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.M(j)) {
            detailVideoView = this.f41021b;
            i = 17;
        } else {
            detailVideoView = this.f41021b;
            i = 21;
        }
        detailVideoView.a(i);
    }
}
