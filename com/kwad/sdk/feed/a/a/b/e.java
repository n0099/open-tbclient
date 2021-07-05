package com.kwad.sdk.feed.a.a.b;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RCRatioFrameLayout;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.feed.a.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RCRatioFrameLayout f37373b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37374c;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        RCRatioFrameLayout rCRatioFrameLayout;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i;
            com.kwad.sdk.core.response.model.c o = com.kwad.sdk.core.response.b.c.o(adTemplate);
            int c2 = o.c();
            int b2 = o.b();
            String a2 = o.a();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f37373b.getLayoutParams();
            if (b2 >= c2) {
                marginLayoutParams.width = ao.a(o(), R.dimen.ksad_content_feed_item_single_large_width);
                rCRatioFrameLayout = this.f37373b;
                f2 = 1.3333334f;
            } else {
                marginLayoutParams.width = -1;
                rCRatioFrameLayout = this.f37373b;
                f2 = 0.75f;
            }
            rCRatioFrameLayout.setRatio(f2);
            this.f37373b.setLayoutParams(marginLayoutParams);
            com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38568d).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_large_bg)).c(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_large_bg)).a(this.f37374c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f37373b = (RCRatioFrameLayout) b(R.id.ksad_cover_container);
            this.f37374c = (ImageView) b(R.id.ksad_feed_item_cover);
        }
    }
}
