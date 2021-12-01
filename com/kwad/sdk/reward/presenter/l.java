package com.kwad.sdk.reward.presenter;

import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.af;
/* loaded from: classes2.dex */
public class l extends com.kwad.sdk.reward.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f59192b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f59193c;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        DetailVideoView detailVideoView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f59192b = (DetailVideoView) a(R.id.ksad_video_player);
            this.f59193c = (ViewGroup) a(R.id.ksad_activity_apk_info_area);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f58874g);
            if (!(!af.e(q())) || (!f() && !g())) {
                this.f59193c.setVisibility(8);
                return;
            }
            this.f59193c.setVisibility(0);
            if (!com.kwad.sdk.core.response.a.a.M(j2)) {
                detailVideoView = this.f59192b;
                i2 = 17;
            } else {
                detailVideoView = this.f59192b;
                i2 = 21;
            }
            detailVideoView.a(i2);
        }
    }
}
