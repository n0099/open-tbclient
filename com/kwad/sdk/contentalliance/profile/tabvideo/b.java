package com.kwad.sdk.contentalliance.profile.tabvideo;

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
import com.kwad.sdk.lib.widget.recycler.a.e;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ProfileTabVideoParam f35381c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.kwad.sdk.lib.a.c<?, AdTemplate> cVar, RecyclerView recyclerView, ProfileTabVideoParam profileTabVideoParam) {
        super(cVar, recyclerView, new com.kwad.sdk.contentalliance.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, recyclerView, profileTabVideoParam};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((KsFragment) objArr2[0], (RecyclerView) objArr2[1], (e) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35381c = profileTabVideoParam;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? ao.a(viewGroup, R.layout.ksad_profile_fragment_tab_video_item_layout, false) : (View) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: a */
    public com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b() : (com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public Presenter a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.a.b.b());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.a.b.c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.a.b.d());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.a.b.a());
            return presenter;
        }
        return (Presenter) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.contentalliance.profile.tabvideo.a.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, bVar, i2) == null) {
            super.a((b) bVar, i2);
            bVar.f35374a = this.f35381c;
        }
    }
}
