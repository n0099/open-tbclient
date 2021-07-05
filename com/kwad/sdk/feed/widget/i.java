package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes7.dex */
public class i extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37472f;

    /* renamed from: g  reason: collision with root package name */
    public RoundAngleImageView f37473g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f37474h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37475i;
    public TextProgressBar j;
    public TextView k;
    public View l;
    public KsLogoView m;
    public KsAppDownloadListener n;

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
        this.n = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.feed.widget.i.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ i f37476a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37476a = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f37476a.k.setVisibility(8);
                    this.f37476a.j.setVisibility(0);
                    this.f37476a.j.a(com.kwad.sdk.core.response.b.a.a(), i4);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f37476a.k.setText(com.kwad.sdk.core.response.b.a.w(this.f37476a.f37440b));
                    this.f37476a.k.setVisibility(0);
                    this.f37476a.j.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f37476a.k.setVisibility(8);
                    this.f37476a.j.setVisibility(0);
                    this.f37476a.j.a(com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this.f37476a).f37439a), this.f37476a.j.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f37476a.k.setText(com.kwad.sdk.core.response.b.a.w(this.f37476a.f37440b));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f37476a.k.setVisibility(8);
                    this.f37476a.j.setVisibility(0);
                    this.f37476a.j.a(com.kwad.sdk.core.response.b.a.b(), this.f37476a.j.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    this.f37476a.k.setVisibility(8);
                    this.f37476a.j.setVisibility(0);
                    this.f37476a.j.a(com.kwad.sdk.core.response.b.a.a(i4), i4);
                }
            }
        };
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            TextView textView = (TextView) findViewById(R.id.ksad_app_download_before);
            this.k = textView;
            textView.setText(com.kwad.sdk.core.response.b.a.w(this.f37440b));
            this.k.setVisibility(0);
            this.k.setOnClickListener(this);
            this.m.a(((com.kwad.sdk.feed.widget.base.a) this).f37439a);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.j = textProgressBar;
            textProgressBar.setTextDimen(ao.a(getContext(), 11.0f));
            this.j.a(-1, -45056);
            this.j.setVisibility(8);
            this.l.setOnClickListener(this);
            if (com.kwad.sdk.core.response.b.a.y(this.f37440b)) {
                this.f37475i = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f37439a, null, this.n);
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            super.a(adTemplate);
            this.f37472f.setText(com.kwad.sdk.core.response.b.a.n(this.f37440b));
            List<String> I = com.kwad.sdk.core.response.b.a.I(this.f37440b);
            if (I.size() >= 1) {
                KSImageLoader.loadFeeImage(this.f37473g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f37439a);
            } else {
                com.kwad.sdk.core.d.a.d("FeedTextRightImageView", "getImageUrlList size less than one");
            }
            f();
            this.f37474h.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f37472f = (TextView) findViewById(R.id.ksad_ad_desc);
            ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
            this.f37473g = roundAngleImageView;
            roundAngleImageView.setRadius(ao.a(getContext(), 3.0f));
            this.f37474h = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.l = findViewById(R.id.ksad_app_download_cover);
            this.m = (KsLogoView) findViewById(R.id.ksad_feed_logo);
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
            if (view == this.f37474h) {
                l();
                return;
            }
            com.kwad.sdk.core.download.b.b.a(this.f37475i, view == this.l);
            com.kwad.sdk.core.download.b.a.a(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f37439a, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.feed.widget.i.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ i f37477a;

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
                    this.f37477a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37477a.k();
                    }
                }
            }, this.f37475i);
        }
    }
}
