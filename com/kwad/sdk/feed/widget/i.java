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
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes10.dex */
public class i extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f72959a;

    /* renamed from: f  reason: collision with root package name */
    public RoundAngleImageView f72960f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f72961g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f72962h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f72963i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadProgressView f72964j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull Context context) {
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
            this.f72963i.a(((com.kwad.sdk.feed.widget.base.a) this).f72929b);
            this.f72964j.a(((com.kwad.sdk.feed.widget.base.a) this).f72929b);
            this.f72964j.setOnClickListener(this);
            if (com.kwad.sdk.core.response.b.a.v(((com.kwad.sdk.feed.widget.base.a) this).f72930c)) {
                com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f72929b, null, this.f72964j.getAppDownloadListener());
                this.f72962h = bVar;
                bVar.c(this.f72964j.getAppDownloadListener());
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            super.a(adTemplate);
            this.f72959a.setText(com.kwad.sdk.core.response.b.a.m(((com.kwad.sdk.feed.widget.base.a) this).f72930c));
            List<String> E = com.kwad.sdk.core.response.b.a.E(((com.kwad.sdk.feed.widget.base.a) this).f72930c);
            if (E.size() >= 1) {
                KSImageLoader.loadFeeImage(this.f72960f, E.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f72929b);
            } else {
                com.kwad.sdk.core.d.a.e("FeedTextRightImageView", "getImageUrlList size less than one");
            }
            d();
            this.f72961g.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f72959a = (TextView) findViewById(R.id.ksad_ad_desc);
            ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
            this.f72960f = roundAngleImageView;
            roundAngleImageView.setRadius(av.a(getContext(), 3.0f));
            this.f72961g = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.f72964j = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
            this.f72963i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.ksad_feed_text_right_image : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f72961g) {
                m();
            } else {
                com.kwad.sdk.core.download.b.a.a(av.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f72929b, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.feed.widget.i.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f72965a;

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
                        this.f72965a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f72965a.k();
                        }
                    }
                }, this.f72962h, view == this.f72964j);
            }
        }
    }
}
