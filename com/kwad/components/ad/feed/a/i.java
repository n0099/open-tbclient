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
    public KsLogoView bq;
    public TextView de;
    public ImageView df;
    public ImageView dg;

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
    public final void bg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091068)).setRatio(0.56f);
            this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f091027);
            this.df = (ImageView) findViewById(R.id.obfuscated_res_0x7f09102d);
            this.dg = (ImageView) findViewById(R.id.obfuscated_res_0x7f091029);
            this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091094);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            super.c((i) adTemplate);
            this.de.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
            List<String> aA = com.kwad.sdk.core.response.a.a.aA(this.mAdInfo);
            this.bq.T(adTemplate);
            if (aA.size() > 0) {
                KSImageLoader.loadFeeImage(this.df, aA.get(0), this.mAdTemplate);
            } else {
                com.kwad.sdk.core.e.b.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
            }
            com.kwad.sdk.b.kwai.a.a(this, this.de, this.df, this.dg);
            setOnClickListener(this);
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                bf();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0422 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 == this.dg) {
                pX();
                return;
            }
            int i = 35;
            if (view2 == this.de) {
                i = 25;
            } else if (view2 == this.df) {
                i = 100;
            }
            if (com.kwad.components.core.c.a.d.a(new a.C0354a(getContext()).L(this.mAdTemplate), 1) == 1) {
                aq(i);
                return;
            }
            boolean am = com.kwad.sdk.core.response.a.a.am(this.mAdInfo);
            aq(i);
            if (am) {
                FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.lp);
            } else {
                AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
            }
        }
    }
}
