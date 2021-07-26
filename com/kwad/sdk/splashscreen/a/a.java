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
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class a extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.d f36580a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f36581b;

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
                    marginLayoutParams.leftMargin = av.a(viewGroup.getContext(), 12.0f);
                    marginLayoutParams.topMargin = av.a(viewGroup.getContext(), 12.0f);
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
            com.kwad.sdk.splashscreen.d dVar = (com.kwad.sdk.splashscreen.d) l();
            this.f36580a = dVar;
            KsLogoView ksLogoView = (KsLogoView) dVar.f36667e.findViewById(R.id.ksad_splash_logo_container);
            this.f36581b = ksLogoView;
            a((ViewGroup) ksLogoView);
            if (this.f36580a.f36666d.adInfoList.isEmpty() || (adSplashInfo = this.f36580a.f36666d.adInfoList.get(0).adSplashInfo) == null) {
                return;
            }
            if (adSplashInfo.logoPosition == 0) {
                this.f36581b.setVisibility(8);
                return;
            }
            this.f36581b.setVisibility(0);
            this.f36581b.a(this.f36580a.f36666d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
        }
    }
}
