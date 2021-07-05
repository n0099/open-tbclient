package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.lib.a.c<AdResultData, AdTemplate> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f35391d;

    /* renamed from: e  reason: collision with root package name */
    public ProfileTabVideoParam f35392e;

    public c() {
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

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                return false;
            }
            Serializable serializable = arguments.getSerializable("KEY_PROFILE_TAB_VIDEO_PARAM");
            if (serializable instanceof ProfileTabVideoParam) {
                ProfileTabVideoParam profileTabVideoParam = (ProfileTabVideoParam) serializable;
                this.f35392e = profileTabVideoParam;
                if (profileTabVideoParam.isValid()) {
                    SceneImpl sceneImpl = new SceneImpl(this.f35392e.mEntryScene);
                    this.f35391d = sceneImpl;
                    sceneImpl.setUrlPackage(this.f35392e.mURLPackage);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ksad_profile_fragment_tab_video : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: a */
    public RecyclerView.ItemDecoration b(AdResultData adResultData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData)) == null) ? new a(3, ao.a(getContext(), 2.0f), ao.a(getContext(), 2.0f)) : (RecyclerView.ItemDecoration) invokeL.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public void a(@NonNull Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, presenter) == null) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.tabvideo.b.a());
        }
    }

    @Override // com.kwad.sdk.lib.a.c
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.id.ksad_recycler_view : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: b */
    public RecyclerView.LayoutManager a(AdResultData adResultData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, adResultData)) == null) ? new StaggeredGridLayoutManager(3, 1) : (RecyclerView.LayoutManager) invokeL.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new d(this.f35391d, this.f35392e) : (com.kwad.sdk.lib.b.c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new b(this, this.f38494b, this.f35392e) : (com.kwad.sdk.lib.widget.recycler.c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            if (k() || (activity = getActivity()) == null) {
                super.onCreate(bundle);
            } else {
                activity.finish();
            }
        }
    }
}
