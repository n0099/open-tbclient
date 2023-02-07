package com.kwad.components.ad.splashscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
/* loaded from: classes8.dex */
public final class d extends com.kwad.components.core.g.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsScene fn;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public DetailVideoView mDetailVideoView;
    public boolean mPageDismissCalled;
    public AdBaseFrameLayout mRootContainer;
    public KsVideoPlayConfig mVideoPlayConfig;
    public KsSplashScreenAd.SplashScreenAdInteractionListener xT;
    public com.kwad.components.ad.splashscreen.d.d xU;
    public int xV;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"WrongConstant"})
    public d(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        V(i);
    }

    private void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            this.xV = i;
            ViewGroup jt = jt();
            this.iB = jt;
            this.mRootContainer = (AdBaseFrameLayout) jt.findViewById(R.id.obfuscated_res_0x7f0912db);
            DetailVideoView detailVideoView = (DetailVideoView) this.iB.findViewById(R.id.obfuscated_res_0x7f0912e4);
            this.mDetailVideoView = detailVideoView;
            detailVideoView.setAd(true);
            this.mDetailVideoView.setVisibility(8);
            this.mRootContainer.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d xW;

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
                    this.xW = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || com.kwad.sdk.b.kwai.a.ro() || !d.n(this.xW.mAdInfo) || this.xW.EH == null) {
                        return;
                    }
                    ((h) this.xW.EH).c(view2.getContext(), 53, 2);
                }
            });
        }
    }

    public static d a(Context context, @NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, ksScene, adResultData)) == null) {
            AdTemplate adTemplate = new AdTemplate();
            if (!adResultData.getAdTemplateList().isEmpty()) {
                adTemplate = adResultData.getAdTemplateList().get(0);
            }
            adTemplate.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.splash.monitor.a.qG();
            com.kwad.components.splash.monitor.a.W(adTemplate);
            d dVar = new d(context, com.kwad.sdk.core.response.a.d.bQ(adTemplate).adSplashInfo.skipButtonPosition);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, adInfo, ksScene)) == null) {
            Presenter presenter = new Presenter();
            presenter.a(new com.kwad.components.ad.splashscreen.b.b());
            presenter.a(new com.kwad.components.ad.splashscreen.b.c());
            presenter.a(new l());
            if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
                presenter.a(new com.kwad.components.ad.splashscreen.b.d());
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
            boolean o = com.kwad.components.ad.splashscreen.local.d.o(adInfo);
            if (com.kwad.components.ad.splashscreen.local.d.d(context, adInfo, sceneImpl)) {
                mVar = new k();
            } else if (b) {
                mVar = new j();
            } else if (!c) {
                if (o) {
                    mVar = new m();
                }
                if (com.kwad.sdk.core.response.a.a.ao(adInfo)) {
                    presenter.a(new com.kwad.components.ad.splashscreen.b.f());
                }
                presenter.a(new com.kwad.components.ad.splashscreen.b.a());
                return presenter;
            } else {
                mVar = new i();
            }
            presenter.a(mVar);
            if (com.kwad.sdk.core.response.a.a.ao(adInfo)) {
            }
            presenter.a(new com.kwad.components.ad.splashscreen.b.a());
            return presenter;
        }
        return (Presenter) invokeLLL.objValue;
    }

    private void a(KsScene ksScene, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, ksScene, adTemplate) == null) {
            this.fn = ksScene;
            this.mAdTemplate = adTemplate;
            dT();
        }
    }

    private void dT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
            this.mVideoPlayConfig = build;
            this.mAdTemplate.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnDismissListener(this);
            this.mApkDownloadHelper.setOnShowListener(this);
        }
    }

    private int getSplashLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            int i = this.xV;
            return i == 1 ? R.layout.obfuscated_res_0x7f0d0487 : i == 0 ? R.layout.obfuscated_res_0x7f0d0488 : i == 2 ? R.layout.obfuscated_res_0x7f0d0485 : i == 3 ? R.layout.obfuscated_res_0x7f0d0486 : R.layout.obfuscated_res_0x7f0d0488;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.g.c
    /* renamed from: js */
    public h jv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            com.kwad.components.ad.splashscreen.d.d dVar = new com.kwad.components.ad.splashscreen.d.d(this.iB, 70);
            this.xU = dVar;
            dVar.qi();
            if (this.mVideoPlayConfig == null) {
                this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
            }
            h hVar = new h();
            hVar.setSplashScreenAdListener(this.xT);
            hVar.mRootContainer = this.mRootContainer;
            AdTemplate adTemplate = this.mAdTemplate;
            hVar.mAdTemplate = adTemplate;
            hVar.fn = this.fn;
            hVar.mVideoPlayConfig = this.mVideoPlayConfig;
            adTemplate.mMiniWindowId = hVar.jB();
            hVar.yd = this.xU;
            hVar.mApkDownloadHelper = this.mApkDownloadHelper;
            hVar.xV = this.xV;
            if (com.kwad.sdk.core.response.a.a.aB(this.mAdInfo)) {
                com.kwad.components.ad.splashscreen.c.a aVar = new com.kwad.components.ad.splashscreen.c.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
                hVar.yc = aVar;
                hVar.yd.a(aVar);
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && com.kwad.components.ad.splashscreen.d.c.d(getContext(), getWidth(), getHeight()) && this.xV != 0) {
            if (com.kwad.components.ad.splashscreen.d.c.c((h) this.EH) == 2) {
                com.kwad.components.ad.splashscreen.d.c.a(findViewById(R.id.obfuscated_res_0x7f0912d9), -1, 16, 16, -1);
            } else if (com.kwad.components.ad.splashscreen.d.c.c((h) this.EH) == 3) {
                com.kwad.components.ad.splashscreen.d.c.a(findViewById(R.id.obfuscated_res_0x7f0912d9), -1, 16, -1, 16);
            }
        }
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adInfo)) == null) {
            AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
            return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
        }
        return invokeL.booleanValue;
    }

    private void notifyPageDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.kwai.kwai.c.rd().rg();
            if (this.mPageDismissCalled) {
                return;
            }
            this.mPageDismissCalled = true;
        }
    }

    @Override // com.kwad.components.core.g.c
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getSplashLayoutId() : invokeV.intValue;
    }

    @Override // com.kwad.components.core.g.c
    public final ViewGroup jt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (ViewGroup) FrameLayout.inflate(getContext(), getSplashLayoutId(), this) : (ViewGroup) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.c, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d xW;

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
                    this.xW = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.xW.ju();
                    }
                }
            });
            T t = this.EH;
            if (((h) t).yc != null) {
                ((h) t).yc.kA();
            }
        }
    }

    @Override // com.kwad.components.core.g.c
    @NonNull
    public final Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(getContext(), this.mAdInfo, this.fn) : (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.c, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            this.xU.qj();
            ((h) this.EH).release();
            notifyPageDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dialogInterface) == null) {
            boolean mr = dialogInterface instanceof com.kwad.components.core.c.kwai.b ? ((com.kwad.components.core.c.kwai.b) dialogInterface).mr() : false;
            try {
                if (this.xT != null) {
                    if (mr) {
                        this.xT.onDownloadTipsDialogDismiss();
                    } else {
                        this.xT.onDownloadTipsDialogCancel();
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dialogInterface) == null) {
            try {
                if (this.xT != null) {
                    this.xT.onDownloadTipsDialogShow();
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i) == null) {
            super.onVisibilityChanged(view2, i);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onWindowVisibilityChanged(i);
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, splashScreenAdInteractionListener) == null) {
            this.xT = splashScreenAdInteractionListener;
            T t = this.EH;
            if (t != 0) {
                ((h) t).setSplashScreenAdListener(splashScreenAdInteractionListener);
            }
        }
    }
}
