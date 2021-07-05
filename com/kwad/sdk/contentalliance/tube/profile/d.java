package com.kwad.sdk.contentalliance.tube.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.profile.b.f;
import com.kwad.sdk.contentalliance.tube.profile.b.g;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.contentalliance.tube.a.c<com.kwad.sdk.contentalliance.tube.profile.a.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f35802e;

    /* renamed from: f  reason: collision with root package name */
    public TubeProfileParam f35803f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.a.b f35804g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35805h;

    public d() {
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

    public static d a(TubeProfileParam tubeProfileParam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tubeProfileParam)) == null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("KEY_TUBE_HOME_PARAM", tubeProfileParam);
            d dVar = new d();
            dVar.setArguments(bundle);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    private void a(LayoutInflater layoutInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, layoutInflater) == null) {
            ((ViewGroup) this.f34294c.findViewById(R.id.ksad_tube_fragment_loading)).addView(layoutInflater.inflate(R.layout.ksad_tube_fragment_loading_layout, (ViewGroup) null, false));
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                return false;
            }
            Serializable serializable = arguments.getSerializable("KEY_TUBE_HOME_PARAM");
            if (serializable instanceof TubeProfileParam) {
                TubeProfileParam tubeProfileParam = (TubeProfileParam) serializable;
                this.f35803f = tubeProfileParam;
                this.f35802e = new SceneImpl(tubeProfileParam.mEntryScene);
                URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 7);
                uRLPackage.putParams(URLPackage.KEY_TUBE_ID, this.f35803f.getTubeId());
                this.f35802e.setUrlPackage(uRLPackage);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ksad_tube_fragment_home : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public Presenter d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.kwad.sdk.core.d.a.a("TubeProfileFragment", "onCreatePresenter()");
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.d());
            presenter.a((Presenter) new f());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.b());
            presenter.a((Presenter) new g());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.profile.b.e());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.tube.a.c
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.id.ksad_tube_recycler_view : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: f */
    public com.kwad.sdk.contentalliance.tube.profile.a.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.kwad.sdk.contentalliance.tube.profile.a.b bVar = new com.kwad.sdk.contentalliance.tube.profile.a.b();
            bVar.f35706a = this;
            com.kwad.sdk.core.i.a aVar = new com.kwad.sdk.core.i.a(this, this.f34294c, 70);
            this.f35805h = aVar;
            aVar.a();
            bVar.f35709d = this.f35805h;
            bVar.f35708c = this.f35803f;
            bVar.f35711f = this.f35802e;
            bVar.f35707b = this.f35605d;
            return bVar;
        }
        return (com.kwad.sdk.contentalliance.tube.profile.a.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            a(layoutInflater);
            return this.f34294c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroyView();
            com.kwad.sdk.contentalliance.tube.profile.a.b bVar = this.f35804g;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            com.kwad.sdk.core.i.a aVar = this.f35805h;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, bundle) == null) {
            if (!g() && getActivity() != null) {
                getActivity().finish();
                return;
            }
            super.onViewCreated(view, bundle);
            this.f35804g = c();
        }
    }
}
