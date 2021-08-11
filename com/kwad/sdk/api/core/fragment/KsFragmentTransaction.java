package com.kwad.sdk.api.core.fragment;

import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes10.dex */
public class KsFragmentTransaction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentTransaction mBase;

    public KsFragmentTransaction(FragmentTransaction fragmentTransaction) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentTransaction};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBase = fragmentTransaction;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction add(int i2, KsFragment ksFragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, ksFragment)) == null) {
            this.mBase.add(i2, ksFragment.getBase());
            return this;
        }
        return (KsFragmentTransaction) invokeIL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction add(int i2, KsFragment ksFragment, @Nullable String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, ksFragment, str)) == null) {
            this.mBase.add(i2, ksFragment.getBase(), str);
            return this;
        }
        return (KsFragmentTransaction) invokeILL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction add(KsFragment ksFragment, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ksFragment, str)) == null) {
            this.mBase.add(ksFragment.getBase(), str);
            return this;
        }
        return (KsFragmentTransaction) invokeLL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction addSharedElement(View view, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, str)) == null) {
            this.mBase.addSharedElement(view, str);
            return this;
        }
        return (KsFragmentTransaction) invokeLL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction addToBackStack(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.mBase.addToBackStack(str);
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction attach(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ksFragment)) == null) {
            this.mBase.attach(ksFragment.getBase());
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public int commit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mBase.commit() : invokeV.intValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public int commitAllowingStateLoss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBase.commitAllowingStateLoss() : invokeV.intValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void commitNow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mBase.commitNow();
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void commitNowAllowingStateLoss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mBase.commitNowAllowingStateLoss();
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction detach(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, ksFragment)) == null) {
            this.mBase.detach(ksFragment.getBase());
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction disallowAddToBackStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.mBase.disallowAddToBackStack();
            return this;
        }
        return (KsFragmentTransaction) invokeV.objValue;
    }

    public FragmentTransaction getBase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mBase : (FragmentTransaction) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction hide(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ksFragment)) == null) {
            this.mBase.hide(ksFragment.getBase());
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isAddToBackStackAllowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mBase.isAddToBackStackAllowed() : invokeV.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mBase.isEmpty() : invokeV.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction remove(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, ksFragment)) == null) {
            this.mBase.remove(ksFragment.getBase());
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction replace(int i2, KsFragment ksFragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i2, ksFragment)) == null) {
            this.mBase.replace(i2, ksFragment.getBase());
            return this;
        }
        return (KsFragmentTransaction) invokeIL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction replace(int i2, KsFragment ksFragment, @Nullable String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048594, this, i2, ksFragment, str)) == null) {
            this.mBase.replace(i2, ksFragment.getBase(), str);
            return this;
        }
        return (KsFragmentTransaction) invokeILL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction runOnCommit(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, runnable)) == null) {
            this.mBase.runOnCommit(runnable);
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public KsFragmentTransaction setAllowOptimization(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.mBase.setAllowOptimization(z);
            return this;
        }
        return (KsFragmentTransaction) invokeZ.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setBreadCrumbShortTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            this.mBase.setBreadCrumbShortTitle(i2);
            return this;
        }
        return (KsFragmentTransaction) invokeI.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, charSequence)) == null) {
            this.mBase.setBreadCrumbShortTitle(charSequence);
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setBreadCrumbTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            this.mBase.setBreadCrumbTitle(i2);
            return this;
        }
        return (KsFragmentTransaction) invokeI.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, charSequence)) == null) {
            this.mBase.setBreadCrumbTitle(charSequence);
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setCustomAnimations(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048601, this, i2, i3)) == null) {
            this.mBase.setCustomAnimations(i2, i3);
            return this;
        }
        return (KsFragmentTransaction) invokeII.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setCustomAnimations(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048602, this, i2, i3, i4, i5)) == null) {
            this.mBase.setCustomAnimations(i2, i3, i4, i5);
            return this;
        }
        return (KsFragmentTransaction) invokeIIII.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setPrimaryNavigationFragment(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, ksFragment)) == null) {
            this.mBase.setPrimaryNavigationFragment(ksFragment.getBase());
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setReorderingAllowed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            this.mBase.setReorderingAllowed(z);
            return this;
        }
        return (KsFragmentTransaction) invokeZ.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setTransition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            this.mBase.setTransition(i2);
            return this;
        }
        return (KsFragmentTransaction) invokeI.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction setTransitionStyle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            this.mBase.setTransitionStyle(i2);
            return this;
        }
        return (KsFragmentTransaction) invokeI.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction show(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, ksFragment)) == null) {
            this.mBase.show(ksFragment.getBase());
            return this;
        }
        return (KsFragmentTransaction) invokeL.objValue;
    }
}
