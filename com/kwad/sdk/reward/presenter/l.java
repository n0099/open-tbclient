package com.kwad.sdk.reward.presenter;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.af;
/* loaded from: classes3.dex */
public class l extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f57513b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f57514c;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        DetailVideoView detailVideoView;
        int i2;
        super.a();
        this.f57513b = (DetailVideoView) a(R.id.ksad_video_player);
        this.f57514c = (ViewGroup) a(R.id.ksad_activity_apk_info_area);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f57207g);
        if (!(!af.e(q())) || (!f() && !g())) {
            this.f57514c.setVisibility(8);
            return;
        }
        this.f57514c.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.M(j2)) {
            detailVideoView = this.f57513b;
            i2 = 17;
        } else {
            detailVideoView = this.f57513b;
            i2 = 21;
        }
        detailVideoView.a(i2);
    }
}
