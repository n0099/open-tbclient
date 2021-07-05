package com.kwad.sdk.lib.a;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final KsFragment f38461a;

    /* renamed from: b  reason: collision with root package name */
    public final InterfaceC0470a f38462b;

    /* renamed from: c  reason: collision with root package name */
    public Presenter f38463c;

    /* renamed from: com.kwad.sdk.lib.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0470a {
        @NonNull
        Presenter e();
    }

    public a(KsFragment ksFragment, InterfaceC0470a interfaceC0470a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment, interfaceC0470a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38461a = ksFragment;
        this.f38462b = interfaceC0470a;
        KsFragmentManager fragmentManager = ksFragment.getFragmentManager();
        if (fragmentManager != null) {
            a(fragmentManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f38463c == null) {
            Presenter e2 = this.f38462b.e();
            this.f38463c = e2;
            e2.a(this.f38461a.getView());
        }
    }

    private void a(@NonNull KsFragmentManager ksFragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, ksFragmentManager) == null) {
            ksFragmentManager.registerFragmentLifecycleCallbacks(new KsFragmentManager.FragmentLifecycleCallbacks(this) { // from class: com.kwad.sdk.lib.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f38464a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38464a = this;
                }

                @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
                public void onFragmentDestroyed(KsFragmentManager ksFragmentManager2, KsFragment ksFragment) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, ksFragmentManager2, ksFragment) == null) {
                        super.onFragmentDestroyed(ksFragmentManager2, ksFragment);
                        if (ksFragment == this.f38464a.f38461a) {
                            ksFragmentManager2.unregisterFragmentLifecycleCallbacks(this);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
                public void onFragmentViewCreated(KsFragmentManager ksFragmentManager2, KsFragment ksFragment, View view, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksFragmentManager2, ksFragment, view, bundle) == null) {
                        super.onFragmentViewCreated(ksFragmentManager2, ksFragment, view, bundle);
                        if (ksFragment == this.f38464a.f38461a) {
                            this.f38464a.a();
                        }
                    }
                }

                @Override // com.kwad.sdk.api.core.fragment.KsFragmentManager.FragmentLifecycleCallbacks
                public void onFragmentViewDestroyed(KsFragmentManager ksFragmentManager2, KsFragment ksFragment) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ksFragmentManager2, ksFragment) == null) {
                        super.onFragmentViewDestroyed(ksFragmentManager2, ksFragment);
                        if (ksFragment == this.f38464a.f38461a) {
                            this.f38464a.b();
                        }
                    }
                }
            }, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Presenter presenter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65540, this) == null) || (presenter = this.f38463c) == null) {
            return;
        }
        presenter.j();
        this.f38463c = null;
    }

    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            a();
            this.f38463c.a(obj);
        }
    }
}
