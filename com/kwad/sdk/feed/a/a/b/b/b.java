package com.kwad.sdk.feed.a.a.b.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.c;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f37364b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37365c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37366d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37367e;

    public b() {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a;
            AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f38573i;
            c.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f38568d).a(com.kwad.sdk.core.response.b.c.q(adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f37364b);
            String v = com.kwad.sdk.core.response.b.c.v(adTemplate);
            if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(adTemplate)) {
                v = o().getString(R.string.ksad_ad_default_username_normal);
            }
            this.f37365c.setText(v);
            String x = com.kwad.sdk.core.response.b.c.x(adTemplate);
            if (ag.a(x)) {
                this.f37366d.setVisibility(8);
            } else {
                this.f37366d.setText(x);
                this.f37366d.setVisibility(0);
            }
            this.f37367e.setText(String.format("%s 人点赞", ag.a(d.m(adTemplate.photoInfo))));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f37364b = (ImageView) b(R.id.ksad_feed_item_author_icon);
            this.f37365c = (TextView) b(R.id.ksad_feed_item_author_name);
            this.f37366d = (TextView) b(R.id.ksad_feed_item_photo_desc);
            this.f37367e = (TextView) b(R.id.ksad_feed_item_author_like_count);
        }
    }
}
