package com.kwad.sdk.splashscreen.a;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class a extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f39212a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f39213b;

    public a() {
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

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, viewGroup) == null) {
            DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
            if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = ao.a(viewGroup.getContext(), 12.0f);
                    marginLayoutParams.topMargin = ao.a(viewGroup.getContext(), 12.0f);
                }
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        AdInfo.AdSplashInfo adSplashInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
            this.f39212a = cVar;
            KsLogoView ksLogoView = (KsLogoView) cVar.f39277d.findViewById(R.id.ksad_splash_logo_container);
            this.f39213b = ksLogoView;
            a((ViewGroup) ksLogoView);
            if (this.f39212a.f39276c.adInfoList.isEmpty() || (adSplashInfo = this.f39212a.f39276c.adInfoList.get(0).adSplashInfo) == null) {
                return;
            }
            if (adSplashInfo.logoPosition == 0) {
                this.f39213b.setVisibility(8);
                return;
            }
            this.f39213b.setVisibility(0);
            this.f39213b.a(this.f39212a.f39276c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
        }
    }
}
