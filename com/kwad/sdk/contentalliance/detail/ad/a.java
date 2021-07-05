package com.kwad.sdk.contentalliance.detail.ad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.a.c;
import com.kwad.sdk.contentalliance.detail.a.e;
import com.kwad.sdk.contentalliance.detail.photo.newui.c.b;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f34460h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f34461i;
    public DetailVideoView j;

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

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ksad_content_alliance_detail_ad_2 : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.b.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.a());
            presenter.a((Presenter) new e());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.b.a());
            h hVar = this.f34333e;
            if (hVar != null && hVar.f35248i) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.a());
            }
            if (com.kwad.sdk.core.config.c.e()) {
                h hVar2 = this.f34333e;
                presenter.a((Presenter) new b(hVar2 != null && hVar2.j));
            }
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.a.c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.ad.presenter.b());
            if (com.kwad.sdk.core.config.c.C()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.e.a());
            }
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.a, com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            Bundle arguments = getArguments();
            if (arguments == null) {
                str = "bundle is null";
            } else {
                this.f34460h = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
                Serializable serializable = getArguments().getSerializable("key_template");
                if (serializable instanceof AdTemplate) {
                    this.f34461i = (AdTemplate) serializable;
                    this.j = (DetailVideoView) this.f34294c.findViewById(R.id.ksad_video_player);
                    return this.f34294c;
                }
                str = "data is not instanceof AdTemplate:" + serializable;
            }
            com.kwad.sdk.core.d.a.d("DetailAdFragment", str);
            return this.f34294c;
        }
        return (View) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: p */
    public com.kwad.sdk.contentalliance.detail.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.kwad.sdk.contentalliance.detail.c cVar = new com.kwad.sdk.contentalliance.detail.c();
            cVar.k = this;
            cVar.f34574a = this.f34333e;
            cVar.l = this.f34332d;
            AdTemplate adTemplate = this.f34461i;
            cVar.j = adTemplate;
            cVar.f34582i = this.f34460h;
            if (com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(adTemplate))) {
                cVar.o = new com.kwad.sdk.core.download.b.b(this.f34461i);
            }
            if (com.kwad.sdk.core.response.b.b.p(this.f34461i)) {
                cVar.p = new com.kwad.sdk.c.c();
            }
            com.kwad.sdk.contentalliance.detail.video.b bVar = new com.kwad.sdk.contentalliance.detail.video.b(this, this.f34332d, this.j, this.f34461i, this.f34460h);
            cVar.f34575b.add(bVar);
            cVar.f34576c.add(bVar.d());
            cVar.m = bVar;
            return cVar;
        }
        return (com.kwad.sdk.contentalliance.detail.c) invokeV.objValue;
    }
}
