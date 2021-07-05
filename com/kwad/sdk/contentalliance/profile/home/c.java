package com.kwad.sdk.contentalliance.profile.home;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.c.e;
import com.kwad.sdk.contentalliance.profile.home.c.f;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.a.a;
import com.kwad.sdk.lib.a.d;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends d implements a.InterfaceC0470a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SceneImpl f35333i;
    public ProfileHomeParam j;
    public com.kwad.sdk.contentalliance.profile.home.b.b k;
    public com.kwad.sdk.lib.a.a l;
    public com.kwad.sdk.core.i.a m;

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

    public static c a(ProfileHomeParam profileHomeParam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, profileHomeParam)) == null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("KEY_PROFILE_HOME_PARAM", profileHomeParam);
            c cVar = new c();
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
            Serializable serializable = arguments.getSerializable("KEY_PROFILE_HOME_PARAM");
            if (serializable instanceof ProfileHomeParam) {
                ProfileHomeParam profileHomeParam = (ProfileHomeParam) serializable;
                this.j = profileHomeParam;
                this.f35333i = new SceneImpl(profileHomeParam.mEntryScene);
                URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 3);
                uRLPackage.putParams(URLPackage.KEY_AUTHOR_ID, this.j.mAuthorId);
                this.f35333i.setUrlPackage(uRLPackage);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private com.kwad.sdk.contentalliance.profile.home.b.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            com.kwad.sdk.contentalliance.profile.home.b.b bVar = new com.kwad.sdk.contentalliance.profile.home.b.b();
            bVar.f35327a = this;
            bVar.f35328b = this.f35333i;
            bVar.f35329c = this.f38502c;
            com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f38500a, 70);
            this.m = aVar;
            aVar.a();
            bVar.f35331e = this.m;
            bVar.f35330d = this.j;
            return bVar;
        }
        return (com.kwad.sdk.contentalliance.profile.home.b.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.a.d
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ksad_profile_fragment_home : invokeV.intValue;
    }

    @Override // com.kwad.sdk.lib.a.d
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.id.ksad_tab_strip : invokeV.intValue;
    }

    @Override // com.kwad.sdk.lib.a.d
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.id.ksad_profile_view_pager : invokeV.intValue;
    }

    @Override // com.kwad.sdk.lib.a.d
    public List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new ArrayList() : (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.a.a.InterfaceC0470a
    @NonNull
    public Presenter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.home.c.d());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.home.c.c());
            presenter.a((Presenter) new f());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.home.c.b());
            presenter.a((Presenter) new e());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.profile.home.c.a());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroyView();
            com.kwad.sdk.contentalliance.profile.home.b.b bVar = this.k;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            com.kwad.sdk.core.i.a aVar = this.m;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.lib.a.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) {
            if (!k() && getActivity() != null) {
                getActivity().finish();
                return;
            }
            super.onViewCreated(view, bundle);
            this.k = l();
            if (this.l == null) {
                this.l = new com.kwad.sdk.lib.a.a(this, this);
            }
            this.l.a(this.k);
        }
    }
}
