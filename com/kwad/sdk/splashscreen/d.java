package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
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
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.splashscreen.a.h;
import com.kwad.sdk.splashscreen.a.i;
import com.kwad.sdk.splashscreen.a.j;
import com.kwad.sdk.utils.bb;
/* loaded from: classes2.dex */
public class d extends com.kwad.sdk.contentalliance.b<g> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f59565d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f59566e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f59567f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f59568g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59569h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.j.f f59570i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f59571j;

    /* renamed from: k  reason: collision with root package name */
    public KsScene f59572k;
    public AdInfo l;
    public boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Presenter a(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Presenter fVar;
        Presenter iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, adInfo)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.b());
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.c());
            presenter.a((Presenter) new h());
            if (com.kwad.sdk.core.response.a.a.P(adInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.d());
                fVar = new j();
            } else {
                fVar = new com.kwad.sdk.splashscreen.a.f();
            }
            presenter.a(fVar);
            if (!g.a(context, adInfo)) {
                if (b(adInfo)) {
                    iVar = new i();
                }
                if (com.kwad.sdk.core.response.a.a.D(adInfo)) {
                    presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.e());
                }
                presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
                return presenter;
            }
            iVar = new com.kwad.sdk.splashscreen.a.g();
            presenter.a(iVar);
            if (com.kwad.sdk.core.response.a.a.D(adInfo)) {
            }
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
            return presenter;
        }
        return (Presenter) invokeLL.objValue;
    }

    public static d a(Context context, @NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, ksScene, adResultData)) == null) {
            AdTemplate adTemplate = new AdTemplate();
            if (!adResultData.adTemplateList.isEmpty()) {
                adTemplate = adResultData.adTemplateList.get(0);
            }
            d dVar = new d(context);
            dVar.a(ksScene, adTemplate);
            return dVar;
        }
        return (d) invokeLLL.objValue;
    }

    private void a(KsScene ksScene, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, ksScene, adTemplate) == null) {
            this.f59572k = ksScene;
            this.f59571j = adTemplate;
            e();
        }
    }

    public static boolean a(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adInfo)) == null) {
            AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
            return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adInfo)) == null) {
            AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
            return adSplashInfo != null && adSplashInfo.splashShowClickButtonSwitch == 1;
        }
        return invokeL.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.l = com.kwad.sdk.core.response.a.d.j(this.f59571j);
            KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
            this.f59566e = build;
            this.f59571j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f59571j);
            this.f59569h = bVar;
            bVar.a((DialogInterface.OnDismissListener) this);
            this.f59569h.a((DialogInterface.OnShowListener) this);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f59567f = (AdBaseFrameLayout) this.f57158c.findViewById(R.id.ksad_splash_root_container);
            DetailVideoView detailVideoView = (DetailVideoView) this.f57158c.findViewById(R.id.ksad_splash_video_player);
            this.f59568g = detailVideoView;
            detailVideoView.setAd(true);
            this.f59568g.setVisibility(8);
            this.f59567f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

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
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || bb.a() || !d.a(this.a.l) || this.a.f57157b == null) {
                        return;
                    }
                    ((g) this.a.f57157b).a(view.getContext(), 2, 2);
                }
            });
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.sdk.contentalliance.b
    @NonNull
    public Presenter c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a(getContext(), this.l) : (Presenter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: d */
    public g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.kwad.sdk.core.j.f fVar = new com.kwad.sdk.core.j.f(this.f57158c, 70);
            this.f59570i = fVar;
            fVar.a();
            if (this.f59566e == null) {
                this.f59566e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
            }
            g gVar = new g();
            gVar.a = this.f59565d;
            gVar.f59578e = this.f59567f;
            AdTemplate adTemplate = this.f59571j;
            gVar.f59577d = adTemplate;
            gVar.f59581h = this.f59572k;
            gVar.f59576c = this.f59566e;
            adTemplate.mMiniWindowId = gVar.c();
            gVar.f59582i = this.f59570i;
            gVar.f59580g = this.f59569h;
            if (com.kwad.sdk.core.response.a.a.P(this.l)) {
                com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.f59571j, this.f59568g, this.f59566e);
                gVar.f59579f = aVar;
                gVar.f59582i.a(aVar);
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.ksad_splash_screen : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            T t = this.f57157b;
            if (((g) t).f59579f != null) {
                ((g) t).f59579f.j();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            this.f59570i.b();
            T t = this.f57157b;
            com.kwad.sdk.splashscreen.b.a aVar = ((g) t).f59579f;
            ((g) t).a();
            g();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dialogInterface) == null) {
            boolean b2 = dialogInterface instanceof com.kwad.sdk.core.download.kwai.b ? ((com.kwad.sdk.core.download.kwai.b) dialogInterface).b() : false;
            try {
                if (this.f59565d != null) {
                    if (b2) {
                        this.f59565d.onDownloadTipsDialogDismiss();
                    } else {
                        this.f59565d.onDownloadTipsDialogCancel();
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dialogInterface) == null) {
            try {
                if (this.f59565d != null) {
                    this.f59565d.onDownloadTipsDialogShow();
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
        }
    }

    public void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, splashScreenAdInteractionListener) == null) {
            this.f59565d = splashScreenAdInteractionListener;
            T t = this.f57157b;
            if (t != 0) {
                ((g) t).a = splashScreenAdInteractionListener;
            }
        }
    }
}
