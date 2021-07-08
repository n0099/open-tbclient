package com.kwad.sdk.api.core.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes6.dex */
public class KsFragmentManager {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentManager mBase;

    @KsAdSdkDynamicApi
    @Keep
    /* loaded from: classes6.dex */
    public static abstract class FragmentLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FragmentManager.FragmentLifecycleCallbacks mBase;

        @Keep
        public FragmentLifecycleCallbacks() {
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

        @Keep
        public FragmentManager.FragmentLifecycleCallbacks getBase() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBase : (FragmentManager.FragmentLifecycleCallbacks) invokeV.objValue;
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentActivityCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksFragmentManager, ksFragment, bundle) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentAttached(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, ksFragmentManager, ksFragment, context) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, ksFragmentManager, ksFragment, bundle) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentDestroyed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, ksFragmentManager, ksFragment) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentDetached(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, ksFragmentManager, ksFragment) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentPaused(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, ksFragmentManager, ksFragment) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentPreAttached(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, ksFragmentManager, ksFragment, context) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentPreCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksFragmentManager, ksFragment, bundle) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentResumed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, ksFragmentManager, ksFragment) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentSaveInstanceState(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048586, this, ksFragmentManager, ksFragment, bundle) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentStarted(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, ksFragmentManager, ksFragment) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentStopped(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, ksFragmentManager, ksFragment) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentViewCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, View view, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048589, this, ksFragmentManager, ksFragment, view, bundle) == null) {
            }
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentViewDestroyed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, ksFragmentManager, ksFragment) == null) {
            }
        }

        @Keep
        public void setBase(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, fragmentLifecycleCallbacks) == null) {
                this.mBase = fragmentLifecycleCallbacks;
            }
        }
    }

    @Keep
    public KsFragmentManager(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBase = fragmentManager;
    }

    @KsAdSdkDynamicApi
    @Keep
    public static void enableDebugLogging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            enableDebugLogging(z);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction beginTransaction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new KsFragmentTransaction(this.mBase.beginTransaction()) : (KsFragmentTransaction) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fileDescriptor, printWriter, strArr) == null) {
            this.mBase.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean executePendingTransactions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBase.executePendingTransactions() : invokeV.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragment findFragmentById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            Fragment findFragmentById = this.mBase.findFragmentById(i2);
            if (findFragmentById instanceof IDelegateFragment) {
                return ((IDelegateFragment) findFragmentById).getBase();
            }
            if (findFragmentById == null) {
                return null;
            }
            throw new RuntimeException(findFragmentById + " is not a DelegateFragment");
        }
        return (KsFragment) invokeI.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragment findFragmentByTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Fragment findFragmentByTag = this.mBase.findFragmentByTag(str);
            if (findFragmentByTag instanceof IDelegateFragment) {
                return ((IDelegateFragment) findFragmentByTag).getBase();
            }
            if (findFragmentByTag == null) {
                return null;
            }
            throw new RuntimeException(findFragmentByTag + " is not a DelegateFragment");
        }
        return (KsFragment) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public int getBackStackEntryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBase.getBackStackEntryCount() : invokeV.intValue;
    }

    @Keep
    public FragmentManager getBase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mBase : (FragmentManager) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragment getFragment(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, str)) == null) {
            Fragment fragment = this.mBase.getFragment(bundle, str);
            if (fragment instanceof IDelegateFragment) {
                return ((IDelegateFragment) fragment).getBase();
            }
            if (fragment == null) {
                return null;
            }
            throw new RuntimeException(fragment + " is not a DelegateFragment or DelegateDialogFragment");
        }
        return (KsFragment) invokeLL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public List<KsFragment> getFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<Fragment> fragments = this.mBase.getFragments();
            ArrayList arrayList = new ArrayList(fragments.size());
            for (Fragment fragment : fragments) {
                if (!(fragment instanceof IDelegateFragment)) {
                    throw new RuntimeException(fragment + " is not a DelegateFragment");
                }
                arrayList.add(((IDelegateFragment) fragment).getBase());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mBase.isDestroyed() : invokeV.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isStateSaved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mBase.isStateSaved() : invokeV.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public KsFragmentTransaction openTransaction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new KsFragmentTransaction(this.mBase.beginTransaction()) : (KsFragmentTransaction) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void popBackStack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mBase.popBackStack();
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void popBackStack(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.mBase.popBackStack(i2, i3);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void popBackStack(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i2) == null) {
            this.mBase.popBackStack(str, i2);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean popBackStackImmediate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mBase.popBackStackImmediate() : invokeV.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean popBackStackImmediate(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) ? this.mBase.popBackStackImmediate(i2, i3) : invokeII.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean popBackStackImmediate(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) ? this.mBase.popBackStackImmediate(str, i2) : invokeLI.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void putFragment(Bundle bundle, String str, KsFragment ksFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, bundle, str, ksFragment) == null) {
            this.mBase.putFragment(bundle, str, ksFragment.getBase());
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, fragmentLifecycleCallbacks, z) == null) {
            fragmentLifecycleCallbacks.setBase(new DelegateFragmentLifecycleCallbacks(this, fragmentLifecycleCallbacks));
            this.mBase.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks.getBase(), z);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsSavedState saveFragmentInstanceState(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, ksFragment)) == null) ? new KsSavedState(this.mBase.saveFragmentInstanceState(ksFragment.getBase())) : (KsSavedState) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fragmentLifecycleCallbacks) == null) {
            this.mBase.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks.getBase());
        }
    }
}
