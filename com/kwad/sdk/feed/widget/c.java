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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f73288a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f73289f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f73290g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73291h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f73292i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadProgressView f73293j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context) {
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

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
            ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.m(((com.kwad.sdk.feed.widget.base.a) this).f73284c));
            textView.setText(com.kwad.sdk.core.response.b.a.u(((com.kwad.sdk.feed.widget.base.a) this).f73284c));
            findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
            textView.setOnClickListener(this);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
            ImageView imageView = (ImageView) findViewById(R.id.ksad_app_icon);
            ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.o(((com.kwad.sdk.feed.widget.base.a) this).f73284c));
            imageView.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.b.a.n(((com.kwad.sdk.feed.widget.base.a) this).f73284c), ((com.kwad.sdk.feed.widget.base.a) this).f73283b, 8);
            ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.m(((com.kwad.sdk.feed.widget.base.a) this).f73284c));
            this.f73293j.a(((com.kwad.sdk.feed.widget.base.a) this).f73283b);
            this.f73293j.setOnClickListener(this);
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f73283b, null, this.f73293j.getAppDownloadListener());
            this.f73291h = bVar;
            bVar.c(this.f73293j.getAppDownloadListener());
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            super.a(adTemplate);
            this.f73288a.setText(com.kwad.sdk.core.response.b.a.m(((com.kwad.sdk.feed.widget.base.a) this).f73284c));
            this.f73292i.a(adTemplate);
            List<String> E = com.kwad.sdk.core.response.b.a.E(((com.kwad.sdk.feed.widget.base.a) this).f73284c);
            if (E.size() >= 1) {
                KSImageLoader.loadFeeImage(this.f73289f, E.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f73283b);
            } else {
                com.kwad.sdk.core.d.a.e("FeedTextAboveImageView", "getImageUrlList size less than one");
            }
            if (com.kwad.sdk.core.response.b.a.v(((com.kwad.sdk.feed.widget.base.a) this).f73284c)) {
                g();
            } else {
                d();
            }
            this.f73290g.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f73288a = (TextView) findViewById(R.id.ksad_ad_desc);
            ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
            this.f73289f = (ImageView) findViewById(R.id.ksad_ad_image);
            this.f73290g = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.f73292i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
            this.f73293j = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.ksad_feed_text_above_image : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f73290g) {
                m();
            } else {
                com.kwad.sdk.core.download.b.a.a(av.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f73283b, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.feed.widget.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f73294a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f73294a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f73294a.k();
                        }
                    }
                }, this.f73291h, view == this.f73293j);
            }
        }
    }
}
