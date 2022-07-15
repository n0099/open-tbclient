package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes5.dex */
public final class i extends a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public ImageView c;
    public KsLogoView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            super.a((i) adTemplate);
            this.a.setText(com.kwad.sdk.core.response.a.a.z(this.k));
            List<String> V = com.kwad.sdk.core.response.a.a.V(this.k);
            this.d.a(adTemplate);
            if (V.size() > 0) {
                KSImageLoader.loadFeeImage(this.b, V.get(0), this.j);
            } else {
                com.kwad.sdk.core.d.b.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
            }
            com.kwad.sdk.b.kwai.a.a(this, this.a, this.b, this.c);
            setOnClickListener(this);
            if (com.kwad.sdk.core.response.a.a.I(this.k)) {
                a((View.OnClickListener) this);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09101b)).setRatio(0.56f);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090fda);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe0);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fdc);
            this.d = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091047);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d041f : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 == this.c) {
                h();
                return;
            }
            int i = 35;
            if (view2 == this.a) {
                i = 25;
            } else if (view2 == this.b) {
                i = 100;
            }
            if (com.kwad.components.core.c.a.c.a(new a.C0507a(getContext()).a(this.j), 1) == 1) {
                a(i);
                return;
            }
            boolean I = com.kwad.sdk.core.response.a.a.I(this.k);
            a(i);
            if (I) {
                FeedDownloadActivityProxy.launch(this.m, this.j, this.l);
            } else {
                AdWebViewActivityProxy.launch(getContext(), this.j);
            }
        }
    }
}
