package com.kwad.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.KsTrendsActivity.class, com.kwad.sdk.contentalliance.trends.b.class);
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.ProfileHomeActivity.class, com.kwad.sdk.contentalliance.profile.home.a.class);
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.ProfileVideoDetailActivity.class, com.kwad.sdk.contentalliance.profile.tabvideo.detail.b.class);
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.TubeProfileActivity.class, com.kwad.sdk.contentalliance.tube.profile.b.class);
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.TubeDetailActivity.class, com.kwad.sdk.contentalliance.tube.detail.b.class);
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.EpisodeDetailActivity.class, com.kwad.sdk.contentalliance.tube.episode.a.class);
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.FragmentActivity4.class, com.kwad.sdk.contentalliance.related.a.class);
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.FragmentActivity5.class, com.kwad.sdk.feed.detail.a.class);
        }
    }
}
