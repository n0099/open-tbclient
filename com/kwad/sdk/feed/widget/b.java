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
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f73275a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f73276f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f73277g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f73278h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f73279i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f73280j;

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
            this.f73275a.setText(com.kwad.sdk.core.response.b.a.m(((com.kwad.sdk.feed.widget.base.a) this).f73284c));
            this.f73280j.a(adTemplate);
            List<String> E = com.kwad.sdk.core.response.b.a.E(((com.kwad.sdk.feed.widget.base.a) this).f73284c);
            if (E.size() >= 3) {
                KSImageLoader.loadFeeImage(this.f73276f, E.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f73283b);
                KSImageLoader.loadFeeImage(this.f73277g, E.get(1), ((com.kwad.sdk.feed.widget.base.a) this).f73283b);
                KSImageLoader.loadFeeImage(this.f73278h, E.get(2), ((com.kwad.sdk.feed.widget.base.a) this).f73283b);
            } else {
                com.kwad.sdk.core.d.a.e("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
            }
            this.f73279i.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f73275a = (TextView) findViewById(R.id.ksad_ad_desc);
            ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
            this.f73276f = (ImageView) findViewById(R.id.ksad_ad_image_left);
            this.f73277g = (ImageView) findViewById(R.id.ksad_ad_image_mid);
            this.f73278h = (ImageView) findViewById(R.id.ksad_ad_image_right);
            this.f73279i = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.f73280j = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
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
            if (view == this.f73279i) {
                m();
            } else if (com.kwad.sdk.core.download.b.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f73283b, 1) == 1) {
                k();
            } else {
                boolean v = com.kwad.sdk.core.response.b.a.v(((com.kwad.sdk.feed.widget.base.a) this).f73284c);
                k();
                if (v) {
                    FeedDownloadActivityProxy.launch(((com.kwad.sdk.feed.widget.base.a) this).f73286e, ((com.kwad.sdk.feed.widget.base.a) this).f73283b, ((com.kwad.sdk.feed.widget.base.a) this).f73285d);
                } else {
                    AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f73283b);
                }
            }
        }
    }
}
