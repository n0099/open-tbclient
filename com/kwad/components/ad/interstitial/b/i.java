package com.kwad.components.ad.interstitial.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class i extends com.kwad.components.ad.interstitial.b.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int hE = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public c gh;
    public a hC;
    public b hD;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView hF;
        public TextView hG;
        public TextView hH;
        public KsPriceView hI;

        public a() {
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
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String appIconUrl;
        public String hJ;
        public CharSequence hK;
        public String hL;
        public String hM;
        public String price;

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

        public final void A(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.hM = str;
            }
        }

        public final void a(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
                this.hK = charSequence;
            }
        }

        public final CharSequence dA() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hK : (CharSequence) invokeV.objValue;
        }

        public final String dB() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.hL : (String) invokeV.objValue;
        }

        public final String dC() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.hM : (String) invokeV.objValue;
        }

        public final String dz() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hJ : (String) invokeV.objValue;
        }

        public final String getAppIconUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.appIconUrl : (String) invokeV.objValue;
        }

        public final String getPrice() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.price : (String) invokeV.objValue;
        }

        public final void w(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.appIconUrl = str;
            }
        }

        public final void x(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.hJ = str;
            }
        }

        public final void y(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.hL = str;
            }
        }

        public final void z(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.price = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(228459977, "Lcom/kwad/components/ad/interstitial/b/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(228459977, "Lcom/kwad/components/ad/interstitial/b/i;");
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hC = new a();
        this.hD = new b();
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, this, aVar, bVar, adInfo, adTemplate) == null) {
            ImageView imageView = aVar.hF;
            if (TextUtils.isEmpty(bVar.getAppIconUrl())) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                if (com.kwad.sdk.core.response.a.a.bD(adInfo)) {
                    KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c05));
                } else {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f080c05);
                    KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, hE);
                }
            }
            aVar.hG.setText(bVar.dz());
            if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
                aVar.hI.d(bVar.getPrice(), bVar.dB(), true);
                aVar.hI.setVisibility(0);
                aVar.hH.setVisibility(8);
                dy();
            } else {
                aVar.hH.setText(bVar.dA());
            }
            this.gh.gj.g(bVar.dC(), 0);
        }
    }

    private void dy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            View findViewById = this.gh.gj.findViewById(R.id.obfuscated_res_0x7f091048);
            View findViewById2 = this.gh.gj.findViewById(R.id.obfuscated_res_0x7f0911ee);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.weight = 2.68f;
            findViewById.setLayoutParams(layoutParams);
            findViewById2.setVisibility(8);
        }
    }

    private void e(AdInfo adInfo) {
        b bVar;
        String string;
        b bVar2;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adInfo) == null) {
            if (com.kwad.sdk.core.response.a.a.bD(adInfo)) {
                this.hD.w(com.kwad.sdk.core.response.a.a.bI(adInfo));
                this.hD.x(com.kwad.sdk.core.response.a.a.bm(adInfo));
                CharSequence e = com.kwad.sdk.core.response.a.a.e(adInfo, com.kwad.components.core.widget.f.PD);
                if (TextUtils.isEmpty(e)) {
                    e = com.kwad.sdk.core.response.a.a.bH(adInfo);
                }
                this.hD.a(e);
                if (com.kwad.sdk.core.response.a.a.bE(adInfo)) {
                    this.hD.A(com.kwad.components.ad.c.b.ah());
                } else {
                    this.hD.A(com.kwad.components.ad.c.b.ak());
                }
            } else if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
                AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
                this.hD.w(bN.icon);
                this.hD.x(bN.name);
                this.hD.y(bN.originPrice);
                this.hD.z(bN.price);
                this.hD.A(com.kwad.components.ad.c.b.ai());
            } else if (com.kwad.sdk.core.response.a.a.am(adInfo)) {
                this.hD.w(com.kwad.sdk.core.response.a.a.bn(adInfo));
                if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ae(adInfo))) {
                    bVar2 = this.hD;
                    string2 = com.kwad.sdk.core.response.a.a.ae(adInfo);
                } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                    bVar2 = this.hD;
                    string2 = getContext().getString(R.string.obfuscated_res_0x7f0f09b9);
                } else {
                    bVar2 = this.hD;
                    string2 = adInfo.advertiserInfo.adAuthorText;
                }
                bVar2.x(string2);
                this.hD.a(com.kwad.sdk.core.response.a.a.ad(adInfo));
                this.hD.A(com.kwad.sdk.core.response.a.a.al(adInfo));
            } else {
                this.hD.w(com.kwad.sdk.core.response.a.a.bn(adInfo));
                if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.af(adInfo))) {
                    bVar = this.hD;
                    string = com.kwad.sdk.core.response.a.a.af(adInfo);
                } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                    bVar = this.hD;
                    string = getContext().getString(R.string.obfuscated_res_0x7f0f09b9);
                } else {
                    bVar = this.hD;
                    string = adInfo.advertiserInfo.adAuthorText;
                }
                bVar.x(string);
                this.hD.a(com.kwad.sdk.core.response.a.a.ad(adInfo));
                this.hD.A(com.kwad.sdk.core.response.a.a.al(adInfo));
            }
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            c cVar = (c) xR();
            this.gh = cVar;
            AdTemplate adTemplate = cVar.mAdTemplate;
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.hC.hF = (ImageView) this.gh.gj.findViewById(R.id.obfuscated_res_0x7f091062);
            this.hC.hG = (TextView) this.gh.gj.findViewById(R.id.obfuscated_res_0x7f091066);
            this.hC.hH = (TextView) this.gh.gj.findViewById(R.id.obfuscated_res_0x7f09105e);
            this.hC.hI = (KsPriceView) this.gh.gj.findViewById(R.id.obfuscated_res_0x7f09113c);
            e(this.mAdInfo);
            a(this.hC, this.hD, this.mAdInfo, this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
        }
    }
}
