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
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes2.dex */
public class b extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f59461b;

    public b() {
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
                    marginLayoutParams.leftMargin = com.kwad.sdk.a.kwai.a.a(viewGroup.getContext(), 12.0f);
                    marginLayoutParams.topMargin = com.kwad.sdk.a.kwai.a.a(viewGroup.getContext(), 12.0f);
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
            com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
            this.a = gVar;
            KsLogoView ksLogoView = (KsLogoView) gVar.f59578e.findViewById(R.id.ksad_splash_logo_container);
            this.f59461b = ksLogoView;
            a((ViewGroup) ksLogoView);
            if (this.a.f59577d.adInfoList.isEmpty() || (adSplashInfo = this.a.f59577d.adInfoList.get(0).adSplashInfo) == null) {
                return;
            }
            if (adSplashInfo.logoPosition == 0) {
                this.f59461b.setVisibility(8);
                return;
            }
            this.f59461b.setVisibility(0);
            this.f59461b.a(this.a.f59577d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c_();
        }
    }
}
