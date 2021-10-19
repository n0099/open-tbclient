package com.kwad.sdk.splashscreen;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.splashscreen.a.e;
import com.kwad.sdk.splashscreen.a.f;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class KsSplashScreenFragment extends com.kwad.sdk.contentalliance.a<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f74093d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f74094e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f74095f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f74096g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f74097h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.j.b f74098i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f74099j;
    public KsScene k;
    public AdInfo l;
    public boolean m;

    public KsSplashScreenFragment() {
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

    public static KsSplashScreenFragment a(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ksScene, adResultData)) == null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("adScene", ksScene);
            if (!adResultData.adTemplateList.isEmpty()) {
                bundle.putSerializable("KsSplashScreenFragment", adResultData.adTemplateList.get(0));
            }
            KsSplashScreenFragment ksSplashScreenFragment = new KsSplashScreenFragment();
            ksSplashScreenFragment.setArguments(bundle);
            return ksSplashScreenFragment;
        }
        return (KsSplashScreenFragment) invokeLL.objValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || getArguments() == null) {
            return;
        }
        Serializable serializable = getArguments().getSerializable("KsSplashScreenFragment");
        if (!(serializable instanceof AdTemplate)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdTemplate:" + serializable);
            this.f74093d.onAdShowError(0, "返回数据格式错误");
            return;
        }
        Serializable serializable2 = getArguments().getSerializable("adScene");
        if (!(serializable2 instanceof KsScene)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdScene" + serializable);
            this.f74093d.onAdShowError(0, "AdScene 数据错误");
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializable;
        this.f74099j = adTemplate;
        this.k = (KsScene) serializable2;
        this.l = com.kwad.sdk.core.response.b.c.i(adTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f74094e = build;
        this.f74099j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        this.f74097h = new com.kwad.sdk.core.download.b.b(this.f74099j);
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f74095f = (AdBaseFrameLayout) this.f71733c.findViewById(R.id.ksad_splash_root_container);
            DetailVideoView detailVideoView = (DetailVideoView) this.f71733c.findViewById(R.id.ksad_splash_video_player);
            this.f74096g = detailVideoView;
            detailVideoView.setAd(true);
            this.f74096g.setVisibility(8);
            this.f74095f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsSplashScreenFragment f74100a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f74100a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && com.kwad.sdk.core.config.c.J()) {
                        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f74100a.f74099j, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f74101a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f74101a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                            public void a() {
                                String d2;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.f74101a.f74100a.f74093d != null) {
                                        this.f74101a.f74100a.f74093d.onAdClicked();
                                    }
                                    if (!com.kwad.sdk.core.response.b.a.v(this.f74101a.f74100a.l) && (d2 = ((d) ((com.kwad.sdk.contentalliance.a) this.f74101a.f74100a).f71732b).d()) != null) {
                                        ((d) ((com.kwad.sdk.contentalliance.a) this.f74101a.f74100a).f71732b).f74218b = true;
                                        ((d) ((com.kwad.sdk.contentalliance.a) this.f74101a.f74100a).f71732b).f74220d.mMiniWindowId = d2;
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        if (((com.kwad.sdk.contentalliance.a) this.f74101a.f74100a).f71732b != null && ((d) ((com.kwad.sdk.contentalliance.a) this.f74101a.f74100a).f71732b).f74222f != null) {
                                            jSONObject.put("duration", ((d) ((com.kwad.sdk.contentalliance.a) this.f74101a.f74100a).f71732b).f74222f.c());
                                        }
                                    } catch (JSONException e2) {
                                        com.kwad.sdk.core.d.a.a(e2);
                                    }
                                    com.kwad.sdk.core.report.a.a(this.f74101a.f74100a.f74099j, jSONObject, this.f74101a.f74100a.f74095f.getTouchCoords(), (String) null);
                                }
                            }
                        }, this.f74100a.f74097h, false);
                    }
                }
            });
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.sdk.contentalliance.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((d) ((com.kwad.sdk.contentalliance.a) this).f71732b).a();
        }
    }

    public void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splashScreenAdInteractionListener) == null) {
            this.f74093d = splashScreenAdInteractionListener;
            T t = ((com.kwad.sdk.contentalliance.a) this).f71732b;
            if (t != 0) {
                ((d) t).f74217a = splashScreenAdInteractionListener;
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.ksad_splash_screen : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.a
    @NonNull
    public Presenter d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.b());
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.d());
            presenter.a(com.kwad.sdk.core.response.b.a.F(this.l) ? new f() : new com.kwad.sdk.splashscreen.a.c());
            presenter.a((Presenter) new e());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.a
    /* renamed from: e */
    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.kwad.sdk.core.j.b bVar = new com.kwad.sdk.core.j.b(this, this.f71733c, 70);
            this.f74098i = bVar;
            bVar.a();
            if (this.f74094e == null) {
                this.f74094e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
            }
            d dVar = new d();
            dVar.f74217a = this.f74093d;
            dVar.f74221e = this.f74095f;
            dVar.f74220d = this.f74099j;
            dVar.f74224h = this.k;
            dVar.f74219c = this.f74094e;
            dVar.f74225i = this.f74098i;
            dVar.f74223g = this.f74097h;
            if (com.kwad.sdk.core.response.b.a.F(this.l)) {
                com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.f74099j, this.f74096g, this.f74094e);
                dVar.f74222f = aVar;
                dVar.f74225i.a(aVar);
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            T t = ((com.kwad.sdk.contentalliance.a) this).f71732b;
            if (((d) t).f74222f != null) {
                ((d) t).f74222f.j();
            }
        }
    }

    @Override // com.kwad.sdk.c.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            h();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroyView();
            this.f74098i.b();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            this.f74098i.h();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            this.f74098i.g();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            f();
            g();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.IFragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            super.setUserVisibleHint(z);
            this.f74098i.a(z);
        }
    }
}
