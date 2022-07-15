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
/* loaded from: classes5.dex */
public final class i extends com.kwad.components.ad.interstitial.b.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int f = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public AdInfo b;
    public AdTemplate c;
    public a d;
    public b e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;
        public TextView b;
        public TextView c;
        public KsPriceView d;

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

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public CharSequence c;
        public String d;
        public String e;
        public String f;

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

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public final void a(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
                this.c = charSequence;
            }
        }

        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.b = str;
            }
        }

        public final CharSequence c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (CharSequence) invokeV.objValue;
        }

        public final void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.d = str;
            }
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.e = str;
            }
        }

        public final String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        public final void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.f = str;
            }
        }

        public final String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f : (String) invokeV.objValue;
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
        this.d = new a();
        this.e = new b();
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, this, aVar, bVar, adInfo, adTemplate) == null) {
            ImageView imageView = aVar.a;
            if (TextUtils.isEmpty(bVar.a())) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                if (com.kwad.sdk.core.response.a.a.aT(adInfo)) {
                    KSImageLoader.loadCircleIcon(imageView, bVar.a(), u().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bc0));
                } else {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f080bc0);
                    KSImageLoader.loadWithRadius(imageView, bVar.a(), adTemplate, f);
                }
            }
            aVar.b.setText(bVar.b());
            if (com.kwad.components.ad.interstitial.kwai.b.b(adInfo)) {
                aVar.d.a(bVar.e(), bVar.d(), true);
                aVar.d.setVisibility(0);
                aVar.c.setVisibility(8);
                g();
            } else {
                aVar.c.setText(bVar.c());
            }
            this.a.e.a(bVar.f(), 0);
        }
    }

    private void a(AdInfo adInfo) {
        b bVar;
        String string;
        b bVar2;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, adInfo) == null) {
            if (com.kwad.sdk.core.response.a.a.aT(adInfo)) {
                this.e.a(com.kwad.sdk.core.response.a.a.aZ(adInfo));
                this.e.b(com.kwad.sdk.core.response.a.a.aD(adInfo));
                CharSequence a2 = com.kwad.sdk.core.response.a.a.a(adInfo, com.kwad.components.core.widget.f.a);
                if (TextUtils.isEmpty(a2)) {
                    a2 = com.kwad.sdk.core.response.a.a.aX(adInfo);
                }
                this.e.a(a2);
                if (com.kwad.sdk.core.response.a.a.aU(adInfo)) {
                    this.e.e(com.kwad.components.ad.c.b.a());
                } else {
                    this.e.e(com.kwad.components.ad.c.b.d());
                }
            } else if (com.kwad.components.ad.interstitial.kwai.b.b(adInfo)) {
                AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(adInfo);
                this.e.a(bd.icon);
                this.e.b(bd.name);
                this.e.c(bd.originPrice);
                this.e.d(bd.price);
                this.e.e(com.kwad.components.ad.c.b.b());
            } else if (com.kwad.sdk.core.response.a.a.I(adInfo)) {
                this.e.a(com.kwad.sdk.core.response.a.a.aE(adInfo));
                if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(adInfo))) {
                    bVar2 = this.e;
                    string2 = com.kwad.sdk.core.response.a.a.A(adInfo);
                } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                    bVar2 = this.e;
                    string2 = u().getString(R.string.obfuscated_res_0x7f0f09a0);
                } else {
                    bVar2 = this.e;
                    string2 = adInfo.advertiserInfo.adAuthorText;
                }
                bVar2.b(string2);
                this.e.a((CharSequence) com.kwad.sdk.core.response.a.a.z(adInfo));
                this.e.e(com.kwad.sdk.core.response.a.a.H(adInfo));
            } else {
                this.e.a(com.kwad.sdk.core.response.a.a.aE(adInfo));
                if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.B(adInfo))) {
                    bVar = this.e;
                    string = com.kwad.sdk.core.response.a.a.B(adInfo);
                } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                    bVar = this.e;
                    string = u().getString(R.string.obfuscated_res_0x7f0f09a0);
                } else {
                    bVar = this.e;
                    string = adInfo.advertiserInfo.adAuthorText;
                }
                bVar.b(string);
                this.e.a((CharSequence) com.kwad.sdk.core.response.a.a.z(adInfo));
                this.e.e(com.kwad.sdk.core.response.a.a.H(adInfo));
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            View findViewById = this.a.e.findViewById(R.id.obfuscated_res_0x7f090fdb);
            View findViewById2 = this.a.e.findViewById(R.id.obfuscated_res_0x7f09119d);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.weight = 2.68f;
            findViewById.setLayoutParams(layoutParams);
            findViewById2.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = (c) t();
            this.a = cVar;
            AdTemplate adTemplate = cVar.a;
            this.c = adTemplate;
            this.b = com.kwad.sdk.core.response.a.d.i(adTemplate);
            this.d.a = (ImageView) this.a.e.findViewById(R.id.obfuscated_res_0x7f090ff5);
            this.d.b = (TextView) this.a.e.findViewById(R.id.obfuscated_res_0x7f090ff9);
            this.d.c = (TextView) this.a.e.findViewById(R.id.obfuscated_res_0x7f090ff1);
            this.d.d = (KsPriceView) this.a.e.findViewById(R.id.obfuscated_res_0x7f0910cc);
            a(this.b);
            a(this.d, this.e, this.b, this.c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
        }
    }
}
