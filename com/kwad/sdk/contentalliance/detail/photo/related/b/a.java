package com.kwad.sdk.contentalliance.detail.photo.related.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.related.RelatedVideoDetailParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.related.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    private void e() {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (sceneImpl = ((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i).mAdScene) == null) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38570f.g());
        RelatedVideoDetailParam relatedVideoDetailParam = new RelatedVideoDetailParam();
        relatedVideoDetailParam.mEntryScene = sceneImpl.entryScene;
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a;
        relatedVideoDetailParam.mSelectedPosition = ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) callercontext).f38572h;
        relatedVideoDetailParam.mSourcePhotoId = String.valueOf(com.kwad.sdk.core.response.b.c.z(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) callercontext).f34919a));
        com.kwad.sdk.contentalliance.related.a.a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38568d, 1000, relatedVideoDetailParam);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            e.a((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i, 1, "related_video_list");
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            l().setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || ao.a()) {
            return;
        }
        e();
        f();
    }
}
