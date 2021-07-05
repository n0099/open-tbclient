package com.kwad.sdk.feed.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.a.a.b.f;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.feed.a.a.a.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.a.b.b f37376c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.sdk.feed.a.b.b bVar) {
        super(ksFragment, recyclerView, new com.kwad.sdk.contentalliance.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment, recyclerView, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((KsFragment) objArr2[0], (RecyclerView) objArr2[1], (com.kwad.sdk.lib.widget.recycler.a.e) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37376c = bVar;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 == 0) {
                i3 = R.layout.ksad_content_feed_home_item_photo;
            } else if (i2 == 1) {
                i3 = R.layout.ksad_content_feed_home_item_ad;
            } else if (i2 == 2) {
                i3 = R.layout.ksad_content_feed_home_item_photo_single_small;
            } else if (i2 == 3) {
                i3 = R.layout.ksad_content_feed_home_item_ad_single_small;
            } else if (i2 == 4) {
                i3 = R.layout.ksad_content_feed_home_item_photo_single_large;
            } else if (i2 != 5) {
                return new View(viewGroup.getContext());
            } else {
                i3 = R.layout.ksad_content_feed_home_item_ad_single_large;
            }
            return ao.a(viewGroup, i3, false);
        }
        return (View) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: a */
    public com.kwad.sdk.feed.a.a.a.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.kwad.sdk.feed.a.a.a.b() : (com.kwad.sdk.feed.a.a.a.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public Presenter a(int i2) {
        InterceptResult invokeI;
        Presenter aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Presenter presenter = new Presenter();
            if (i2 == 0) {
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.c());
                aVar = new com.kwad.sdk.feed.a.a.b.b.a();
            } else if (i2 == 1) {
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.c());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.a());
                aVar = new com.kwad.sdk.feed.a.a.b.a.c();
            } else if (i2 == 2) {
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new f());
                aVar = new com.kwad.sdk.feed.a.a.b.b.b();
            } else if (i2 == 3) {
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
                presenter.a((Presenter) new f());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.c());
                aVar = new com.kwad.sdk.feed.a.a.b.b();
            } else if (i2 != 4) {
                if (i2 == 5) {
                    presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                    presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                    presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
                    presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.e());
                    presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.d());
                    presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.c());
                    aVar = new com.kwad.sdk.feed.a.a.b.b();
                }
                return presenter;
            } else {
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.e());
                aVar = new com.kwad.sdk.feed.a.a.b.b.b();
            }
            presenter.a(aVar);
            return presenter;
        }
        return (Presenter) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.feed.a.a.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, bVar, i2) == null) {
            super.a((b) bVar, i2);
            AdTemplate adTemplate = (AdTemplate) this.f38536a.get(i2);
            if (com.kwad.sdk.core.response.b.c.b(adTemplate) || !com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(adTemplate))) {
                bVar.f37315b = null;
            } else {
                bVar.f37315b = new com.kwad.sdk.core.download.b.b(adTemplate);
            }
            bVar.f37314a = this.f37376c;
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public boolean a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z && !z2 : invokeCommon.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<M> list = this.f38536a;
            if (list == 0 || i2 >= list.size() || (adTemplate = (AdTemplate) this.f38536a.get(i2)) == null) {
                return -1;
            }
            int i3 = adTemplate.mPageInfo.pageType;
            if (i3 == 0 || i3 == 1) {
                return !com.kwad.sdk.core.response.b.c.b(adTemplate) ? 1 : 0;
            }
            if (i3 == 2) {
                return com.kwad.sdk.core.response.b.c.b(adTemplate) ? 2 : 3;
            } else if (i3 != 3) {
                return -1;
            } else {
                return com.kwad.sdk.core.response.b.c.b(adTemplate) ? 4 : 5;
            }
        }
        return invokeI.intValue;
    }
}
