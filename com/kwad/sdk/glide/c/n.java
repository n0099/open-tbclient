package com.kwad.sdk.glide.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class n extends KsFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.c.a f37656a;

    /* renamed from: b  reason: collision with root package name */
    public final l f37657b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<n> f37658c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public n f37659d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.g f37660e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f37661f;

    /* loaded from: classes7.dex */
    public static class a implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<n> f37662a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37662a = new WeakReference<>(nVar);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return super.toString() + "{fragment=" + this.f37662a.get() + "}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n() {
        this(new com.kwad.sdk.glide.c.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((com.kwad.sdk.glide.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public n(@NonNull com.kwad.sdk.glide.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37657b = new a(this);
        this.f37658c = new HashSet();
        this.f37656a = aVar;
    }

    private void a(KsFragmentManager ksFragmentManager, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, ksFragmentManager, activity) == null) {
            e();
            n a2 = com.kwad.sdk.glide.c.a(getActivity()).g().a(ksFragmentManager, activity);
            this.f37659d = a2;
            if (equals(a2)) {
                return;
            }
            this.f37659d.a(this);
        }
    }

    private void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, nVar) == null) {
            this.f37658c.add(nVar);
        }
    }

    private void b(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, nVar) == null) {
            this.f37658c.remove(nVar);
        }
    }

    @Nullable
    private KsFragment d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            KsFragment parentFragment = getParentFragment();
            return parentFragment != null ? parentFragment : this.f37661f;
        }
        return (KsFragment) invokeV.objValue;
    }

    private void e() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (nVar = this.f37659d) == null) {
            return;
        }
        nVar.b(this);
        this.f37659d = null;
    }

    @NonNull
    public com.kwad.sdk.glide.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37656a : (com.kwad.sdk.glide.c.a) invokeV.objValue;
    }

    public void a(@Nullable KsFragment ksFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksFragment) == null) {
            this.f37661f = ksFragment;
            if (ksFragment == null || ksFragment.getActivity() == null) {
                return;
            }
            a(ksFragment.getFragmentManager(), ksFragment.getActivity());
        }
    }

    public void a(@Nullable com.kwad.sdk.glide.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f37660e = gVar;
        }
    }

    @Nullable
    public com.kwad.sdk.glide.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37660e : (com.kwad.sdk.glide.g) invokeV.objValue;
    }

    @NonNull
    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37657b : (l) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            super.onAttach(context);
            try {
                a(getFragmentManager(), getActivity());
            } catch (IllegalStateException e2) {
                if (Log.isLoggable(SupportRequestManagerFragment.TAG, 5)) {
                    Log.w(SupportRequestManagerFragment.TAG, "Unable to register fragment with root", e2);
                }
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.f37656a.c();
            e();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetach();
            this.f37661f = null;
            e();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStart();
            this.f37656a.a();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            this.f37656a.b();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return super.toString() + "{parent=" + d() + "}";
        }
        return (String) invokeV.objValue;
    }
}
