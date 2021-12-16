package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedDownloadActivityProxy;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59104f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59105g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f59106h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f59107i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f59108j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            super.a(adTemplate);
            this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f59110c));
            this.f59108j.a(adTemplate);
            List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f59110c);
            if (O.size() >= 3) {
                KSImageLoader.loadFeeImage(this.f59104f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f59109b);
                KSImageLoader.loadFeeImage(this.f59105g, O.get(1), ((com.kwad.sdk.feed.widget.base.a) this).f59109b);
                KSImageLoader.loadFeeImage(this.f59106h, O.get(2), ((com.kwad.sdk.feed.widget.base.a) this).f59109b);
            } else {
                com.kwad.sdk.core.d.a.e("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
            }
            this.f59107i.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = (TextView) findViewById(R.id.ksad_ad_desc);
            ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
            this.f59104f = (ImageView) findViewById(R.id.ksad_ad_image_left);
            this.f59105g = (ImageView) findViewById(R.id.ksad_ad_image_mid);
            this.f59106h = (ImageView) findViewById(R.id.ksad_ad_image_right);
            this.f59107i = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.f59108j = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.ksad_feed_text_above_group_image : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f59107i) {
                m();
            } else if (com.kwad.sdk.core.download.a.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f59109b, 1) == 1) {
                k();
            } else {
                boolean B = com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f59110c);
                k();
                if (B) {
                    FeedDownloadActivityProxy.launch(((com.kwad.sdk.feed.widget.base.a) this).f59112e, ((com.kwad.sdk.feed.widget.base.a) this).f59109b, ((com.kwad.sdk.feed.widget.base.a) this).f59111d);
                } else {
                    AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f59109b);
                }
            }
        }
    }
}
