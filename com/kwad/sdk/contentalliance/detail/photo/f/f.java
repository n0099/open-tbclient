package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.contentalliance.detail.photo.f.a<g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public g f34797d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34798e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(@NonNull AdTemplate adTemplate, long j);
    }

    public f() {
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

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            for (a aVar : ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34579f) {
                com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
                aVar.a(cVar.j, cVar.f34582i);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            this.f34798e = adTemplate;
            long t = com.kwad.sdk.core.response.b.c.t(adTemplate);
            if (com.kwad.sdk.core.config.c.C()) {
                t++;
            }
            this.f34797d.setCommentCount(t);
            this.f34797d.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f34797d.setOnClickListener(null);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34797d = (g) ((com.kwad.sdk.contentalliance.detail.photo.f.a) this).f34792b;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public g g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new g(o()) : (g) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!com.kwad.sdk.core.response.b.c.c(this.f34798e) || com.kwad.sdk.core.config.c.C()) {
                h();
            } else {
                p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
            }
            com.kwad.sdk.core.report.e.f(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j);
        }
    }
}
