package com.kwad.sdk.contentalliance.home.c.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.home.c.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35186b;

    public a() {
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
            AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i;
            PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
            String d2 = d.d(k);
            if (ag.a(d2)) {
                d2 = d.g(k);
            }
            if (ag.a(d2)) {
                return;
            }
            com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38568d).a(d2).a((e<Drawable>) new com.kwad.sdk.c(d2, adTemplate)).a(this.f35186b);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f35186b = (ImageView) b(R.id.ksad_slide_profile_cover);
        }
    }
}
