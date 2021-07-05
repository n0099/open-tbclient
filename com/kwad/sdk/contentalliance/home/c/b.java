package com.kwad.sdk.contentalliance.home.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.contentalliance.home.c.a.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f35179c;

    /* renamed from: d  reason: collision with root package name */
    public c f35180d;

    /* renamed from: e  reason: collision with root package name */
    public int f35181e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f35182f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f35183g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f35184h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public View f35185i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(KsFragment ksFragment, RecyclerView recyclerView, SlidePlayViewPager slidePlayViewPager) {
        super(ksFragment, recyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment, recyclerView, slidePlayViewPager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((KsFragment) objArr2[0], (RecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35182f = new LinkedList();
        this.f35179c = slidePlayViewPager;
    }

    private void b(AdTemplate adTemplate, @Nullable View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, this, adTemplate, view, z) == null) {
            int indexOf = this.f38536a.indexOf(adTemplate);
            com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyVideoStateChange selectedPosition:" + indexOf);
            if (indexOf != -1) {
                for (a aVar : this.f35182f) {
                    aVar.a(indexOf, view, z);
                }
            }
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int indexOf = this.f38536a.indexOf(this.f35183g);
            com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyOnSelectChanged selectedPosition:" + indexOf);
            if (indexOf != -1) {
                for (a aVar : this.f35182f) {
                    aVar.a(indexOf, this.f35183g);
                }
            }
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? ao.a(viewGroup, R.layout.ksad_content_slide_home_profile_item, false) : (View) invokeLI.objValue;
    }

    public AdTemplate a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35183g : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public Presenter a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.b());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.c());
            return presenter;
        }
        return (Presenter) invokeI.objValue;
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f35185i = view;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.contentalliance.home.c.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, bVar, i2) == null) {
            super.a((b) bVar, i2);
            bVar.f35176a = this.f35179c;
            bVar.f35177b = this.f35185i;
            bVar.f35178c = this;
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f35180d = cVar;
        }
    }

    public void a(AdTemplate adTemplate, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, adTemplate, view, z) == null) {
            b(adTemplate, view, z);
        }
    }

    public void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.contentalliance.detail.video.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, adTemplate, bVar) == null) {
            this.f35183g = adTemplate;
            this.f35184h = bVar;
            l();
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f35181e = i2;
        }
    }

    public com.kwad.sdk.contentalliance.detail.video.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35184h : (com.kwad.sdk.contentalliance.detail.video.b) invokeV.objValue;
    }

    public List<a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f35182f : (List) invokeV.objValue;
    }

    public c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f35180d : (c) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f35181e : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: g */
    public com.kwad.sdk.contentalliance.home.c.a.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new com.kwad.sdk.contentalliance.home.c.a.b() : (com.kwad.sdk.contentalliance.home.c.a.b) invokeV.objValue;
    }
}
