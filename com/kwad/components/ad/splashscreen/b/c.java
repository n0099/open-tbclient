package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ax;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends e implements com.kwad.sdk.core.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo py;
    public boolean yA;
    public View yB;
    public TextView yx;
    public com.kwad.components.ad.splashscreen.widget.a yy;
    public AdInfo.AdPreloadInfo yz;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.yA = false;
    }

    private SplashSkipViewModel jW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
            splashSkipViewModel.needShowMiniWindow = this.yF.jz();
            int i = this.py.adSplashInfo.imageDisplaySecond;
            if (i <= 0) {
                i = 5;
            }
            AdInfo adInfo = this.py;
            int min = Math.min(adInfo.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.a.a.B(adInfo));
            if (com.kwad.sdk.core.response.a.a.aB(this.py)) {
                i = min;
            }
            splashSkipViewModel.skipSecond = i;
            return splashSkipViewModel;
        }
        return (SplashSkipViewModel) invokeV.objValue;
    }

    private boolean jX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            return hVar != null && hVar.jz() && com.kwad.components.ad.splashscreen.a.b.jP() > 0 && !ax.dT(com.kwad.components.ad.splashscreen.a.b.jL());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            if (hVar.yb) {
                str = null;
            } else {
                str = hVar.jC();
                if (str != null) {
                    this.yF.jG();
                    com.kwad.components.ad.splashscreen.h hVar2 = this.yF;
                    hVar2.yb = true;
                    hVar2.mAdTemplate.mMiniWindowId = str;
                }
                com.kwad.components.ad.splashscreen.c.a aVar = this.yF.yc;
                com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, 114, com.kwad.components.ad.splashscreen.a.b.jP(), aVar != null ? (int) (aVar.getCurrentPosition() / 1000) : 0);
            }
            if (str == null) {
                this.yF.jG();
                JSONObject jSONObject = new JSONObject();
                com.kwad.components.ad.splashscreen.c.a aVar2 = this.yF.yc;
                if (aVar2 != null) {
                    try {
                        jSONObject.put("duration", aVar2.getCurrentPosition());
                    } catch (JSONException e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                    }
                }
                com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, 1, jSONObject);
            }
        }
    }

    private synchronized void ka() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this) {
                if (!this.yA && this.yy != null) {
                    if (com.kwad.sdk.core.response.a.a.bz(this.py) && com.kwad.sdk.core.response.a.a.bA(this.py)) {
                        com.kwad.sdk.core.report.a.c(this.yF.mAdTemplate, 124, (JSONObject) null);
                        this.yA = true;
                    }
                }
            }
        }
    }

    private boolean p(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, adInfo)) == null) ? jX() || !com.kwad.sdk.core.response.a.a.bx(adInfo) : invokeL.booleanValue;
    }

    private void q(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, adInfo) == null) {
            TextView textView = (TextView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091297);
            this.yx = textView;
            this.yz = adInfo.adPreloadInfo;
            textView.setVisibility(8);
            AdInfo.AdPreloadInfo adPreloadInfo = this.yz;
            if (adPreloadInfo == null || ax.dT(adPreloadInfo.preloadTips)) {
                this.yx.setVisibility(8);
                return;
            }
            this.yx.setVisibility(0);
            this.yx.setText(this.yz.preloadTips);
        }
    }

    private void r(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, adInfo) == null) {
            this.yB = this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091286);
            if (!com.kwad.sdk.core.response.a.a.by(adInfo)) {
                this.yB.setVisibility(8);
                return;
            }
            this.yB.setVisibility(0);
            this.yB.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.b.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c yC;

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
                    this.yC = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.yC.jY();
                    }
                }
            });
            this.yB.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c yC;

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
                    this.yC = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((View) this.yC.yy).post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.c.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 yD;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.yD = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    int Y = this.yD.yC.yy.Y(35);
                                    ViewGroup.LayoutParams layoutParams = this.yD.yC.yB.getLayoutParams();
                                    layoutParams.width = Y + com.kwad.sdk.b.kwai.a.a(this.yD.yC.yF.mRootContainer.getContext(), 66.0f);
                                    this.yD.yC.yB.setLayoutParams(layoutParams);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.e.b.d("SkipAdPresenter", "onPageVisible");
            this.yy.t(this.py);
            ka();
        }
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.core.e.b.d("SkipAdPresenter", "onPageInvisible");
            this.yy.s(this.py);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void aq() {
        AdBaseFrameLayout adBaseFrameLayout;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            com.kwad.sdk.core.e.b.d("SkipAdPresenter", "onBind");
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
            this.py = bQ;
            q(bQ);
            if (p(this.py)) {
                adBaseFrameLayout = this.yF.mRootContainer;
                i = R.id.obfuscated_res_0x7f091299;
            } else {
                adBaseFrameLayout = this.yF.mRootContainer;
                i = R.id.obfuscated_res_0x7f091292;
            }
            this.yy = (com.kwad.components.ad.splashscreen.widget.a) adBaseFrameLayout.findViewById(i);
            this.yy.a(jW(), this.py);
            this.yy.setOnViewListener(new SkipView.a(this) { // from class: com.kwad.components.ad.splashscreen.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c yC;

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
                    this.yC = this;
                }

                @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
                public final void kb() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.yC.jY();
                    }
                }

                @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
                public final void kc() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.yC.jZ();
                    }
                }
            });
            r(this.py);
            this.yF.yd.a(this);
        }
    }

    public final void jZ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.yF.mRootContainer.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c yC;

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
                    this.yC = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.kwad.components.core.c.kwai.b.mq() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                            this.yC.yF.mRootContainer.postDelayed(this, 1000L);
                        } else {
                            this.yC.yF.jF();
                        }
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            this.yF.yd.b(this);
            this.yy.bj();
        }
    }
}
