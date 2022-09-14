package com.kwad.components.ad.splashscreen.b;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes7.dex */
public final class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void h(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, viewGroup) == null) && this.yF.xV == 0) {
            DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
            if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(viewGroup.getContext(), 12.0f);
                    marginLayoutParams.topMargin = com.kwad.sdk.b.kwai.a.a(viewGroup.getContext(), 12.0f);
                }
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        AdInfo.AdSplashInfo adSplashInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            KsLogoView ksLogoView = (KsLogoView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0911f9);
            this.bq = ksLogoView;
            h(ksLogoView);
            if (this.yF.mAdTemplate.adInfoList.isEmpty() || (adSplashInfo = this.yF.mAdTemplate.adInfoList.get(0).adSplashInfo) == null) {
                return;
            }
            if (adSplashInfo.logoPosition == 0) {
                this.bq.setVisibility(8);
                return;
            }
            this.bq.setVisibility(0);
            this.bq.T(this.yF.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }
}
