package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.content.DialogInterface;
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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes2.dex */
public class h extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public RoundAngleImageView f58545f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58546g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58547h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f58548i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadProgressView f58549j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull Context context) {
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
            this.f58548i.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
            this.f58549j.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
            this.f58549j.setOnClickListener(this);
            if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f58529c)) {
                com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f58528b, null, this.f58549j.getAppDownloadListener());
                this.f58547h = bVar;
                bVar.c(this.f58549j.getAppDownloadListener());
                this.f58547h.a((DialogInterface.OnShowListener) this);
                this.f58547h.a((DialogInterface.OnDismissListener) this);
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            super.a(adTemplate);
            this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f58529c));
            List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            if (O.size() >= 1) {
                KSImageLoader.loadFeeImage(this.f58545f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f58528b);
            } else {
                com.kwad.sdk.core.d.a.e("FeedTextLeftImageView", "getImageUrlList size less than one");
            }
            d();
            this.f58546g.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = (TextView) findViewById(R.id.ksad_ad_desc);
            ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
            this.f58545f = roundAngleImageView;
            roundAngleImageView.setRadius(com.kwad.sdk.a.kwai.a.a(getContext(), 3.0f));
            this.f58546g = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.f58549j = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
            this.f58548i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.ksad_feed_text_left_image : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f58546g) {
                m();
            } else {
                com.kwad.sdk.core.download.a.a.a(new a.C2015a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f58528b).a(this.f58547h).a(view == this.f58549j ? 1 : 2).a(view == this.f58549j).a(new a.b(this) { // from class: com.kwad.sdk.feed.widget.h.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ h a;

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
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.k();
                        }
                    }
                }));
            }
        }
    }
}
