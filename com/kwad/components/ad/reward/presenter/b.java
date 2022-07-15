package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public AdInfo c;

    public b(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = adInfo;
    }

    public static void a(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, imageView, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(KsAdSDKImpl.get().getContext(), str, imageView, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str2, inputStream, decodedResult)) == null) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
                return invokeLLL.booleanValue;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view2, decodedResult) == null) {
                }
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((a) this).a.g;
            if (adTemplate.adInfoList.size() > 0) {
                String k = com.kwad.sdk.core.response.a.a.k(adTemplate.adInfoList.get(0));
                this.b.setVisibility(e());
                a(this.b, k);
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.id.obfuscated_res_0x7f091005 : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context u = u();
            if (!com.kwad.components.ad.reward.l.b(((a) this).a.g) || ae.e(u)) {
                if (!com.kwad.components.ad.reward.l.a(((a) this).a.g) || ae.e(u)) {
                    if (!com.kwad.sdk.core.response.a.d.w(((a) this).a.g) || ae.e(u)) {
                        return (com.kwad.sdk.core.response.a.a.ar(this.c) || com.kwad.components.ad.reward.kwai.b.d(this.c) || !com.kwad.sdk.core.response.a.b.n(this.c)) ? 8 : 0;
                    }
                    return 0;
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            this.b = (ImageView) b(d());
        }
    }
}
