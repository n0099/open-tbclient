package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.loader.Loader;
/* loaded from: classes2.dex */
public abstract class DelegateFragment extends Fragment implements IDelegateFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String REAL_BASE_CLASS = "real_base_class";
    public transient /* synthetic */ FieldHolder $fh;
    public IFragmentLifecycle mBase;

    public DelegateFragment(KsFragment ksFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBase = ksFragment;
    }

    @Override // com.kwad.sdk.api.core.fragment.IDelegateFragment
    public Activity getActivity2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getActivity() : (Activity) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IDelegateFragment
    public KsFragment getBase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (KsFragment) this.mBase : (KsFragment) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.mBase.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.mBase.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            super.onAttach(activity);
            this.mBase.onAttach(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            super.onAttach(context);
            this.mBase.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fragment) == null) {
            if (fragment instanceof IDelegateFragment) {
                this.mBase.onAttachFragment(((IDelegateFragment) fragment).getBase());
            } else if (fragment == null) {
                this.mBase.onAttachFragment(null);
            } else {
                throw new RuntimeException(fragment + " is not a DelegateFragment or DelegateDialogFragment");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mBase.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, menuItem)) == null) ? this.mBase.onContextItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            if (bundle != null) {
                try {
                    KsFragment ksFragment = (KsFragment) Loader.get().getRealClassLoader().loadClass((String) bundle.get(REAL_BASE_CLASS)).newInstance();
                    this.mBase = ksFragment;
                    ksFragment.setBase(this);
                } catch (Exception unused) {
                }
                bundle.clear();
            }
            super.onCreate(bundle);
            this.mBase.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) ? this.mBase.onCreateAnimation(i2, z, i3) : (Animation) invokeCommon.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) ? this.mBase.onCreateAnimator(i2, z, i3) : (Animator) invokeCommon.objValue;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, contextMenu, view, contextMenuInfo) == null) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            this.mBase.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, menu, menuInflater) == null) {
            super.onCreateOptionsMenu(menu, menuInflater);
            this.mBase.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) ? this.mBase.onCreateView(layoutInflater, viewGroup, bundle) : (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.mBase.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyOptionsMenu();
            this.mBase.onDestroyOptionsMenu();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroyView();
            this.mBase.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDetach();
            this.mBase.onDetach();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bundle)) == null) ? super.onGetLayoutInflater(bundle) : (LayoutInflater) invokeL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.onHiddenChanged(z);
            this.mBase.onHiddenChanged(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, activity, attributeSet, bundle) == null) {
            super.onInflate(activity, attributeSet, bundle);
            this.mBase.onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, context, attributeSet, bundle) == null) {
            super.onInflate(context, attributeSet, bundle);
            this.mBase.onInflate(context, attributeSet, bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onLowMemory();
            this.mBase.onLowMemory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            super.onMultiWindowModeChanged(z);
            this.mBase.onMultiWindowModeChanged(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, menuItem)) == null) ? this.mBase.onOptionsItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, menu) == null) {
            super.onOptionsMenuClosed(menu);
            this.mBase.onOptionsMenuClosed(menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            this.mBase.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            super.onPictureInPictureModeChanged(z);
            this.mBase.onPictureInPictureModeChanged(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, menu) == null) {
            super.onPrepareOptionsMenu(menu);
            this.mBase.onPrepareOptionsMenu(menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048606, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            this.mBase.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onResume();
            this.mBase.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.mBase.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString(REAL_BASE_CLASS, this.mBase.getClass().getName());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onStart();
            this.mBase.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onStop();
            this.mBase.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.mBase.onViewCreated(view, bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            super.onViewStateRestored(bundle);
            this.mBase.onViewStateRestored(bundle);
        }
    }

    public void setBase(KsFragment ksFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, ksFragment) == null) {
            this.mBase = ksFragment;
        }
    }
}
