package com.kwad.sdk.feed.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.lib.a.c<AdResultData, AdTemplate> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.feed.a.b.b f37381d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f37382e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f37383f;

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

    public static c a(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ksScene)) == null) {
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putSerializable("KEY_KS_SCENE", ksScene);
            cVar.setArguments(bundle);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                return false;
            }
            Serializable serializable = arguments.getSerializable("KEY_KS_SCENE");
            if (serializable instanceof KsScene) {
                SceneImpl sceneImpl = new SceneImpl((KsScene) serializable);
                this.f37382e = sceneImpl;
                sceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 11));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ksad_content_feed_home_layout : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: a */
    public RecyclerView.ItemDecoration b(AdResultData adResultData) {
        InterceptResult invokeL;
        int a2;
        int a3;
        com.kwad.sdk.contentalliance.profile.tabvideo.a aVar;
        RecyclerView.ItemDecoration itemDecoration;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData)) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f38494b.getLayoutParams();
            int i2 = adResultData.pageInfo.pageType;
            if (i2 == 2) {
                a2 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_small_horizontal_padding);
                a3 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_small_vertical_padding);
                aVar = new com.kwad.sdk.contentalliance.profile.tabvideo.a(1, a2, a3);
            } else if (i2 != 3) {
                int a4 = ao.a(getContext(), R.dimen.ksad_content_feed_item_double_padding);
                itemDecoration = new com.kwad.sdk.contentalliance.detail.photo.related.d(2, a4);
                marginLayoutParams.topMargin = a4;
                marginLayoutParams.leftMargin = a4;
                marginLayoutParams.rightMargin = a4;
                this.f38494b.setLayoutParams(marginLayoutParams);
                return itemDecoration;
            } else {
                a2 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_larger_horizontal_padding);
                a3 = ao.a(getContext(), R.dimen.ksad_content_feed_item_single_larger_vertical_padding);
                aVar = new com.kwad.sdk.contentalliance.profile.tabvideo.a(1, a2, a3);
            }
            marginLayoutParams.topMargin = a3;
            marginLayoutParams.leftMargin = a2;
            marginLayoutParams.rightMargin = a2;
            itemDecoration = aVar;
            this.f38494b.setLayoutParams(marginLayoutParams);
            return itemDecoration;
        }
        return (RecyclerView.ItemDecoration) invokeL.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public void a(@NonNull Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, presenter) == null) {
            presenter.a((Presenter) new com.kwad.sdk.feed.a.c.a());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.c.c());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.c.b());
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, adResultData)) == null) {
            int i2 = adResultData.pageInfo.pageType;
            return (i2 == 2 || i2 == 3) ? new LinearLayoutManager(getContext()) : new StaggeredGridLayoutManager(2, 1);
        }
        return (RecyclerView.LayoutManager) invokeL.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new d(this.f37382e) : (com.kwad.sdk.lib.b.c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new b(this, this.f38494b, this.f37381d) : (com.kwad.sdk.lib.widget.recycler.c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public com.kwad.sdk.lib.a.a.b<AdResultData, AdTemplate> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            com.kwad.sdk.feed.a.b.b bVar = new com.kwad.sdk.feed.a.b.b();
            this.f37381d = bVar;
            bVar.f37378a = this.f37382e;
            com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f38493a, 70);
            this.f37383f = aVar;
            aVar.a();
            com.kwad.sdk.feed.a.b.b bVar2 = this.f37381d;
            bVar2.f37379b = this.f37383f;
            return bVar2;
        }
        return (com.kwad.sdk.lib.a.a.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.lib.a.c
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 6;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            if (k() || (activity = getActivity()) == null) {
                super.onCreate(bundle);
            } else {
                activity.finish();
            }
        }
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroyView();
            com.kwad.sdk.core.i.a aVar = this.f37383f;
            if (aVar != null) {
                aVar.f();
            }
            a.a().e();
        }
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            com.kwad.sdk.core.i.a aVar = this.f37383f;
            if (aVar != null) {
                aVar.d();
            }
        }
    }
}
