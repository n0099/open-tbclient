package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.b.i;
import com.kwad.components.ad.splashscreen.b.j;
import com.kwad.components.ad.splashscreen.b.k;
import com.kwad.components.ad.splashscreen.b.l;
import com.kwad.components.ad.splashscreen.b.m;
import com.kwad.components.ad.splashscreen.b.n;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.core.g.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsSplashScreenAd.SplashScreenAdInteractionListener d;
    public KsVideoPlayConfig e;
    public AdBaseFrameLayout f;
    public DetailVideoView g;
    public com.kwad.components.core.c.a.b h;
    public com.kwad.components.ad.splashscreen.d.c i;
    public AdTemplate j;
    public KsScene k;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
    }

    public static d a(Context context, @NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, ksScene, adResultData)) == null) {
            AdTemplate adTemplate = new AdTemplate();
            if (!adResultData.getAdTemplateList().isEmpty()) {
                adTemplate = adResultData.getAdTemplateList().get(0);
            }
            adTemplate.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.a.a();
            com.kwad.components.ad.splashscreen.monitor.a.c(adTemplate);
            d dVar = new d(context);
            dVar.a(ksScene, adTemplate);
            return dVar;
        }
        return (d) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Presenter a(Context context, AdInfo adInfo, KsScene ksScene) {
        InterceptResult invokeLLL;
        Presenter gVar;
        Presenter mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, adInfo, ksScene)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.components.ad.splashscreen.b.b());
            presenter.a((Presenter) new com.kwad.components.ad.splashscreen.b.c());
            presenter.a((Presenter) new l());
            if (com.kwad.sdk.core.response.a.a.W(adInfo)) {
                presenter.a((Presenter) new com.kwad.components.ad.splashscreen.b.d());
                gVar = new n();
            } else {
                gVar = new com.kwad.components.ad.splashscreen.b.g();
            }
            presenter.a(gVar);
            SceneImpl sceneImpl = new SceneImpl();
            if (ksScene instanceof SceneImpl) {
                sceneImpl = (SceneImpl) ksScene;
            }
            boolean b = com.kwad.components.ad.splashscreen.local.d.b(context, adInfo, sceneImpl);
            boolean c = com.kwad.components.ad.splashscreen.local.d.c(context, adInfo, sceneImpl);
            boolean a = com.kwad.components.ad.splashscreen.local.d.a(adInfo);
            if (com.kwad.components.ad.splashscreen.local.d.d(context, adInfo, sceneImpl)) {
                mVar = new k();
            } else if (b) {
                mVar = new j();
            } else if (!c) {
                if (a) {
                    mVar = new m();
                }
                if (com.kwad.sdk.core.response.a.a.K(adInfo)) {
                    presenter.a((Presenter) new com.kwad.components.ad.splashscreen.b.f());
                }
                presenter.a((Presenter) new com.kwad.components.ad.splashscreen.b.a());
                return presenter;
            } else {
                mVar = new i();
            }
            presenter.a(mVar);
            if (com.kwad.sdk.core.response.a.a.K(adInfo)) {
            }
            presenter.a((Presenter) new com.kwad.components.ad.splashscreen.b.a());
            return presenter;
        }
        return (Presenter) invokeLLL.objValue;
    }

    private void a(KsScene ksScene, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, ksScene, adTemplate) == null) {
            this.k = ksScene;
            this.j = adTemplate;
            d();
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.g.c
    /* renamed from: c */
    public h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            com.kwad.components.ad.splashscreen.d.c cVar = new com.kwad.components.ad.splashscreen.d.c(this.c, 70);
            this.i = cVar;
            cVar.b();
            if (this.e == null) {
                this.e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).build();
            }
            h hVar = new h();
            hVar.a(this.d);
            hVar.d = this.f;
            AdTemplate adTemplate = this.j;
            hVar.c = adTemplate;
            hVar.g = this.k;
            hVar.b = this.e;
            adTemplate.mMiniWindowId = hVar.c();
            hVar.h = this.i;
            hVar.f = this.h;
            if (com.kwad.sdk.core.response.a.a.W(this.l)) {
                com.kwad.components.ad.splashscreen.c.a aVar = new com.kwad.components.ad.splashscreen.c.a(this.j, this.g, this.e);
                hVar.e = aVar;
                hVar.h.a(aVar);
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.l = com.kwad.sdk.core.response.a.d.i(this.j);
            KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).build();
            this.e = build;
            this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.j);
            this.h = bVar;
            bVar.a((DialogInterface.OnDismissListener) this);
            this.h.a((DialogInterface.OnShowListener) this);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f = (AdBaseFrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0911aa);
            DetailVideoView detailVideoView = (DetailVideoView) this.c.findViewById(R.id.obfuscated_res_0x7f0911b3);
            this.g = detailVideoView;
            detailVideoView.setAd(true);
            this.g.setVisibility(8);
            this.f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.d.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || com.kwad.sdk.b.kwai.a.a() || !d.a(this.a.l) || this.a.b == null) {
                        return;
                    }
                    ((h) this.a.b).a(view2.getContext(), 53, 2);
                }
            });
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.components.core.g.c
    @NonNull
    public final Presenter a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a(getContext(), this.l, this.k) : (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.c
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d046a : invokeV.intValue;
    }

    @Override // com.kwad.components.core.g.c, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            T t = this.b;
            if (((h) t).e != null) {
                ((h) t).e.j();
            }
        }
    }

    @Override // com.kwad.components.core.g.c, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            this.i.c();
            ((h) this.b).a();
            f();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dialogInterface) == null) {
            boolean b = dialogInterface instanceof com.kwad.components.core.c.kwai.b ? ((com.kwad.components.core.c.kwai.b) dialogInterface).b() : false;
            try {
                if (this.d != null) {
                    if (b) {
                        this.d.onDownloadTipsDialogDismiss();
                    } else {
                        this.d.onDownloadTipsDialogCancel();
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
            }
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dialogInterface) == null) {
            try {
                if (this.d != null) {
                    this.d.onDownloadTipsDialogShow();
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
            }
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view2, i) == null) {
            super.onVisibilityChanged(view2, i);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onWindowVisibilityChanged(i);
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, splashScreenAdInteractionListener) == null) {
            this.d = splashScreenAdInteractionListener;
            T t = this.b;
            if (t != 0) {
                ((h) t).a(splashScreenAdInteractionListener);
            }
        }
    }
}
