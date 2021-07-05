package com.kwad.sdk.contentalliance.detail.b;

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
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.detail.a.c;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f34554h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f34555i;
    public b j;
    public KsContentPage.SubShowItem k;

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

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.j = bVar;
        }
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.ksad_fragment_empty_container : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.a.c.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.b.a.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.detail.b.a.b());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.detail.a, com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            Bundle arguments = getArguments();
            if (arguments == null) {
                return this.f34294c;
            }
            this.f34554h = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
            Serializable serializable = getArguments().getSerializable("key_template");
            if (serializable instanceof AdTemplate) {
                this.f34555i = (AdTemplate) serializable;
                if (this.j == null) {
                    this.j = new b();
                }
                this.k = this.j.a(this.f34555i);
                this.f34294c.removeAllViews();
                KsContentPage.SubShowItem subShowItem = this.k;
                if (subShowItem != null) {
                    View instantiateItem = subShowItem.instantiateItem();
                    if (instantiateItem != null) {
                        if (instantiateItem.getParent() != null) {
                            ((ViewGroup) instantiateItem.getParent()).removeView(instantiateItem);
                        }
                        this.f34294c.addView(instantiateItem);
                    } else {
                        e.i(this.f34555i);
                    }
                }
                return this.f34294c;
            }
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
            cVar.j = this.f34555i;
            cVar.f34582i = this.f34554h;
            cVar.q = this.j;
            cVar.l = this.f34332d;
            return cVar;
        }
        return (com.kwad.sdk.contentalliance.detail.c) invokeV.objValue;
    }
}
