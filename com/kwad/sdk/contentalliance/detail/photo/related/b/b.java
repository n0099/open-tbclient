package com.kwad.sdk.contentalliance.detail.photo.related.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.photo.related.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f34921b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34922c;

    /* renamed from: d  reason: collision with root package name */
    public int f34923d;

    /* renamed from: e  reason: collision with root package name */
    public int f34924e;

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
            AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i;
            PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
            int e2 = com.kwad.sdk.core.response.b.d.e(k);
            int f2 = com.kwad.sdk.core.response.b.d.f(k);
            ViewGroup.LayoutParams layoutParams = this.f34921b.getLayoutParams();
            if (e2 <= 0 || f2 <= 0) {
                layoutParams.height = this.f34924e;
                com.kwad.sdk.core.d.a.a("LookRelatedCoverPresenter", "videoWidth or videoHeight is 0 int position=" + ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38572h);
            } else {
                layoutParams.height = (int) (((this.f34923d * f2) * 1.0f) / e2);
            }
            this.f34921b.setLayoutParams(layoutParams);
            String g2 = com.kwad.sdk.core.response.b.d.g(k);
            if (ag.a(g2)) {
                g2 = com.kwad.sdk.core.response.b.d.d(k);
            }
            com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38568d).a(g2).a((e<Drawable>) new com.kwad.sdk.c(g2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_realted_video_cover_bg)).c(o().getResources().getDrawable(R.drawable.ksad_realted_video_cover_bg)).a(this.f34922c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f34921b = b(R.id.ksad_related_video_item_root);
            this.f34922c = (ImageView) b(R.id.ksad_related_video_cover);
            this.f34923d = ((ao.c(o()) - ao.a(o(), R.dimen.ksad_content_related_video_item_padding)) - (ao.a(o(), R.dimen.ksad_content_related_video_item_margin) * 2)) / 2;
            this.f34924e = ao.a(o(), R.dimen.ksad_content_related_video_item_default_height);
        }
    }
}
