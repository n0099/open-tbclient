package com.kwad.sdk.splashscreen;

import android.content.DialogInterface;
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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bb;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class KsSplashScreenFragment extends com.kwad.sdk.contentalliance.a<g> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f59448d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f59449e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f59450f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f59451g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59452h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.j.b f59453i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f59454j;

    /* renamed from: k  reason: collision with root package name */
    public KsScene f59455k;
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

    public static boolean a(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) {
            AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
            return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
        }
        return invokeL.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || getArguments() == null) {
            return;
        }
        Serializable serializable = getArguments().getSerializable("KsSplashScreenFragment");
        if (!(serializable instanceof AdTemplate)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdTemplate:" + serializable);
            this.f59448d.onAdShowError(0, "返回数据格式错误");
            return;
        }
        Serializable serializable2 = getArguments().getSerializable("adScene");
        if (!(serializable2 instanceof KsScene)) {
            com.kwad.sdk.core.d.a.e(KsFullScreenVideoActivityProxy.TAG, "data is not instanceof AdScene" + serializable);
            this.f59448d.onAdShowError(0, "AdScene 数据错误");
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializable;
        this.f59454j = adTemplate;
        this.f59455k = (KsScene) serializable2;
        this.l = com.kwad.sdk.core.response.a.d.j(adTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
        this.f59449e = build;
        this.f59454j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f59454j);
        this.f59452h = bVar;
        bVar.a((DialogInterface.OnDismissListener) this);
        this.f59452h.a((DialogInterface.OnShowListener) this);
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f59450f = (AdBaseFrameLayout) this.f57156c.findViewById(R.id.ksad_splash_root_container);
            DetailVideoView detailVideoView = (DetailVideoView) this.f57156c.findViewById(R.id.ksad_splash_video_player);
            this.f59451g = detailVideoView;
            detailVideoView.setAd(true);
            this.f59451g.setVisibility(8);
            this.f59450f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.KsSplashScreenFragment.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsSplashScreenFragment a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || bb.a() || !KsSplashScreenFragment.a(this.a.l) || ((com.kwad.sdk.contentalliance.a) this.a).f57155b == null) {
                        return;
                    }
                    ((g) ((com.kwad.sdk.contentalliance.a) this.a).f57155b).a(view.getContext(), 2, 2);
                }
            });
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.sdk.contentalliance.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((g) ((com.kwad.sdk.contentalliance.a) this).f57155b).a();
        }
    }

    public void a(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splashScreenAdInteractionListener) == null) {
            this.f59448d = splashScreenAdInteractionListener;
            T t = ((com.kwad.sdk.contentalliance.a) this).f57155b;
            if (t != 0) {
                ((g) t).a = splashScreenAdInteractionListener;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.a(getContext(), this.l) : (Presenter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.a
    /* renamed from: e */
    public g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.kwad.sdk.core.j.b bVar = new com.kwad.sdk.core.j.b(this, this.f57156c, 70);
            this.f59453i = bVar;
            bVar.a();
            if (this.f59449e == null) {
                this.f59449e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
            }
            g gVar = new g();
            gVar.a = this.f59448d;
            gVar.f59578e = this.f59450f;
            gVar.f59577d = this.f59454j;
            gVar.f59581h = this.f59455k;
            gVar.f59576c = this.f59449e;
            gVar.f59582i = this.f59453i;
            gVar.f59580g = this.f59452h;
            if (com.kwad.sdk.core.response.a.a.P(this.l)) {
                com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.f59454j, this.f59451g, this.f59449e);
                gVar.f59579f = aVar;
                gVar.f59582i.a(aVar);
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            T t = ((com.kwad.sdk.contentalliance.a) this).f57155b;
            if (((g) t).f59579f != null) {
                ((g) t).f59579f.j();
            }
        }
    }

    @Override // com.kwad.sdk.h.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
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
            this.f59453i.b();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dialogInterface) == null) {
            boolean b2 = dialogInterface instanceof com.kwad.sdk.core.download.kwai.b ? ((com.kwad.sdk.core.download.kwai.b) dialogInterface).b() : false;
            try {
                if (this.f59448d != null) {
                    if (b2) {
                        this.f59448d.onDownloadTipsDialogDismiss();
                    } else {
                        this.f59448d.onDownloadTipsDialogCancel();
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            this.f59453i.i();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            this.f59453i.h();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dialogInterface) == null) {
            try {
                if (this.f59448d != null) {
                    this.f59448d.onDownloadTipsDialogShow();
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            f();
            g();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.IFragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.setUserVisibleHint(z);
            this.f59453i.a(z);
        }
    }
}
