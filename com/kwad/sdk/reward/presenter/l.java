package com.kwad.sdk.reward.presenter;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.af;
/* loaded from: classes4.dex */
public class l extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f57725b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f57726c;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        DetailVideoView detailVideoView;
        int i2;
        super.a();
        this.f57725b = (DetailVideoView) a(R.id.ksad_video_player);
        this.f57726c = (ViewGroup) a(R.id.ksad_activity_apk_info_area);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f57419g);
        if (!(!af.e(q())) || (!f() && !g())) {
            this.f57726c.setVisibility(8);
            return;
        }
        this.f57726c.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.M(j2)) {
            detailVideoView = this.f57725b;
            i2 = 17;
        } else {
            detailVideoView = this.f57725b;
            i2 = 21;
        }
        detailVideoView.a(i2);
    }
}
