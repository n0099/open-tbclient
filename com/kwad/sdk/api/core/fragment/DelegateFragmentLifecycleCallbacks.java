package com.kwad.sdk.api.core.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
/* loaded from: classes2.dex */
public class DelegateFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final KsFragmentManager.FragmentLifecycleCallbacks mBase;
    public final KsFragmentManager mFragmentManager;

    public DelegateFragmentLifecycleCallbacks(KsFragmentManager ksFragmentManager, KsFragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragmentManager, fragmentLifecycleCallbacks};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBase = fragmentLifecycleCallbacks;
        this.mFragmentManager = ksFragmentManager;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, fragmentManager, fragment, bundle) == null) {
            super.onFragmentActivityCreated(fragmentManager, fragment, bundle);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentActivityCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragmentManager, fragment, context) == null) {
            super.onFragmentAttached(fragmentManager, fragment, context);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentAttached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), context);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, fragmentManager, fragment, bundle) == null) {
            super.onFragmentCreated(fragmentManager, fragment, bundle);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, fragmentManager, fragment) == null) {
            super.onFragmentDestroyed(fragmentManager, fragment);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentDestroyed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, fragmentManager, fragment) == null) {
            super.onFragmentDetached(fragmentManager, fragment);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentDetached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, fragmentManager, fragment) == null) {
            super.onFragmentPaused(fragmentManager, fragment);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentPaused(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, fragmentManager, fragment, context) == null) {
            super.onFragmentPreAttached(fragmentManager, fragment, context);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentPreAttached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), context);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, fragmentManager, fragment, bundle) == null) {
            super.onFragmentPreCreated(fragmentManager, fragment, bundle);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentPreCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fragmentManager, fragment) == null) {
            super.onFragmentResumed(fragmentManager, fragment);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentResumed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, fragmentManager, fragment, bundle) == null) {
            super.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentSaveInstanceState(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, fragmentManager, fragment) == null) {
            super.onFragmentStarted(fragmentManager, fragment);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentStarted(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, fragmentManager, fragment) == null) {
            super.onFragmentStopped(fragmentManager, fragment);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentStopped(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, fragmentManager, fragment, view, bundle) == null) {
            super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentViewCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), view, bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, fragmentManager, fragment) == null) {
            super.onFragmentViewDestroyed(fragmentManager, fragment);
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onFragmentViewDestroyed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
            }
        }
    }
}
