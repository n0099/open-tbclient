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
import com.kwad.sdk.utils.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c extends e implements com.kwad.sdk.core.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public com.kwad.components.ad.splashscreen.widget.a c;
    public AdInfo.AdPreloadInfo d;
    public AdInfo e;
    public boolean f;
    public View g;

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
        this.f = false;
    }

    private boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, adInfo)) == null) ? g() || !com.kwad.sdk.core.response.a.a.aO(adInfo) : invokeL.booleanValue;
    }

    private void b(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adInfo) == null) {
            TextView textView = (TextView) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911a9);
            this.b = textView;
            this.d = adInfo.adPreloadInfo;
            textView.setVisibility(8);
            AdInfo.AdPreloadInfo adPreloadInfo = this.d;
            if (adPreloadInfo == null || at.a(adPreloadInfo.preloadTips)) {
                this.b.setVisibility(8);
                return;
            }
            this.b.setVisibility(0);
            this.b.setText(this.d.preloadTips);
        }
    }

    private void c(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, adInfo) == null) {
            this.g = ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f091198);
            if (!com.kwad.sdk.core.response.a.a.aP(adInfo)) {
                this.g.setVisibility(8);
                return;
            }
            this.g.setVisibility(0);
            this.g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.b.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.h();
                    }
                }
            });
            this.g.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int a = this.a.c.a(35);
                        ViewGroup.LayoutParams layoutParams = this.a.g.getLayoutParams();
                        layoutParams.width = a + com.kwad.sdk.b.kwai.a.a(((e) this.a).a.d.getContext(), 66.0f);
                        this.a.g.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private SplashSkipViewModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
            splashSkipViewModel.needShowMiniWindow = ((e) this).a.b();
            int i = this.e.adSplashInfo.imageDisplaySecond;
            if (i <= 0) {
                i = 5;
            }
            AdInfo adInfo = this.e;
            int min = Math.min(adInfo.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.a.a.c(adInfo));
            if (com.kwad.sdk.core.response.a.a.W(this.e)) {
                i = min;
            }
            splashSkipViewModel.skipSecond = i;
            return splashSkipViewModel;
        }
        return (SplashSkipViewModel) invokeV.objValue;
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            return hVar != null && hVar.b() && com.kwad.components.ad.splashscreen.a.b.g() > 0 && !at.a(com.kwad.components.ad.splashscreen.a.b.c());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            if (hVar.a) {
                str = null;
            } else {
                str = hVar.d();
                if (str != null) {
                    ((e) this).a.h();
                    com.kwad.components.ad.splashscreen.h hVar2 = ((e) this).a;
                    hVar2.a = true;
                    hVar2.c.mMiniWindowId = str;
                }
                com.kwad.components.ad.splashscreen.c.a aVar = ((e) this).a.e;
                com.kwad.sdk.core.report.a.a(((e) this).a.c, 114, com.kwad.components.ad.splashscreen.a.b.g(), aVar != null ? (int) (aVar.e() / 1000) : 0);
            }
            if (str == null) {
                ((e) this).a.h();
                JSONObject jSONObject = new JSONObject();
                com.kwad.components.ad.splashscreen.c.a aVar2 = ((e) this).a.e;
                if (aVar2 != null) {
                    try {
                        jSONObject.put("duration", aVar2.e());
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.b.a(e);
                    }
                }
                com.kwad.sdk.core.report.a.a(((e) this).a.c, 1, jSONObject);
            }
        }
    }

    private synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            synchronized (this) {
                if (!this.f && this.c != null) {
                    com.kwad.sdk.core.report.a.c(((e) this).a.c, 124, (JSONObject) null);
                    this.f = true;
                }
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void a() {
        AdBaseFrameLayout adBaseFrameLayout;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.b.a("SkipAdPresenter", "onBind");
            AdInfo i2 = com.kwad.sdk.core.response.a.d.i(((e) this).a.c);
            this.e = i2;
            b(i2);
            if (a(this.e)) {
                adBaseFrameLayout = ((e) this).a.d;
                i = R.id.obfuscated_res_0x7f0911ab;
            } else {
                adBaseFrameLayout = ((e) this).a.d;
                i = R.id.obfuscated_res_0x7f0911a4;
            }
            this.c = (com.kwad.components.ad.splashscreen.widget.a) adBaseFrameLayout.findViewById(i);
            this.c.a(e(), this.e);
            this.c.setOnViewListener(new SkipView.a(this) { // from class: com.kwad.components.ad.splashscreen.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.h();
                    }
                }

                @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.d();
                    }
                }
            });
            c(this.e);
            ((e) this).a.h.a(this);
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.core.d.b.a("SkipAdPresenter", "onPageInvisible");
            this.c.a(this.e);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((e) this).a.d.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.kwad.components.core.c.kwai.b.a() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                            ((e) this.a).a.d.postDelayed(this, 1000L);
                        } else {
                            ((e) this.a).a.g();
                        }
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            ((e) this).a.h.b(this);
            this.c.c();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void m_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.d.b.a("SkipAdPresenter", "onPageVisible");
            this.c.b(this.e);
            i();
        }
    }
}
