package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;
import com.kwad.sdk.api.loader.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes7.dex */
public class KsFragment extends AbstractIFragmentLifecycle implements IFragment, IFragmentLifecycle {
    public static /* synthetic */ Interceptable $ic;
    public static final SimpleArrayMap<String, Class<?>> sClassMap;
    public transient /* synthetic */ FieldHolder $fh;
    public Fragment mBase;
    public KsFragmentManager mChildFragmentManager;
    public KsFragmentManager mFragmentManager;
    public KsLifecycle mLifeCycle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(754010564, "Lcom/kwad/sdk/api/core/fragment/KsFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(754010564, "Lcom/kwad/sdk/api/core/fragment/KsFragment;");
                return;
            }
        }
        sClassMap = new SimpleArrayMap<>();
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBase = new ResFragment(this);
    }

    @Keep
    public KsFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mBase = fragment;
    }

    public static KsFragment instantiate(Context context, String str, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, bundle)) == null) {
            try {
                Class<?> cls = sClassMap.get(str);
                if (cls == null) {
                    cls = context.getClassLoader().loadClass(str);
                    sClassMap.put(str, cls);
                }
                KsFragment ksFragment = (KsFragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                if (bundle != null) {
                    bundle.setClassLoader(ksFragment.getClass().getClassLoader());
                    ksFragment.setArguments(bundle);
                }
                return ksFragment;
            } catch (Exception e2) {
                throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
            }
        }
        return (KsFragment) invokeLLL.objValue;
    }

    private boolean isAllFragmentIsHidden(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, fragment)) == null) {
            Fragment parentFragment = fragment.getParentFragment();
            boolean isHidden = fragment.isHidden();
            return parentFragment == null ? isHidden : isHidden || isAllFragmentIsHidden(parentFragment);
        }
        return invokeL.booleanValue;
    }

    private boolean isKsAdParentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            Fragment parentFragment = this.mBase.getParentFragment();
            return parentFragment != null && (parentFragment instanceof IDelegateFragment);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, fileDescriptor, printWriter, strArr) == null) {
            this.mBase.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Fragment fragment = this.mBase;
            if (fragment instanceof IDelegateFragment) {
                return ((IDelegateFragment) fragment).getActivity2();
            }
            throw new RuntimeException(this.mBase + " must be DelegateFragment or DelegateDialogFragment");
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean getAllowEnterTransitionOverlap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBase.getAllowEnterTransitionOverlap() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean getAllowReturnTransitionOverlap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBase.getAllowReturnTransitionOverlap() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final Bundle getArguments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Bundle arguments = this.mBase.getArguments();
            if (arguments != null) {
                arguments.setClassLoader(Loader.get().getRealClassLoader());
            }
            return arguments;
        }
        return (Bundle) invokeV.objValue;
    }

    @Keep
    public final Fragment getBase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBase : (Fragment) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentManager getChildFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mChildFragmentManager == null) {
                this.mChildFragmentManager = new KsFragmentManager(this.mBase.getChildFragmentManager());
            }
            return this.mChildFragmentManager;
        }
        return (KsFragmentManager) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBase.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public Object getEnterTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mBase.getEnterTransition() : invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Object getExitTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mBase.getExitTransition() : invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentManager getFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mFragmentManager == null) {
                this.mFragmentManager = new KsFragmentManager(this.mBase.getFragmentManager());
            }
            return this.mFragmentManager;
        }
        return (KsFragmentManager) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final Object getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mBase.getHost() : invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mBase.getId() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public final LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bundle)) == null) ? this.mBase.getLayoutInflater(bundle) : (LayoutInflater) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public KsLifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.mLifeCycle == null) {
                this.mLifeCycle = new KsLifecycle(this.mBase.getLifecycle());
            }
            return this.mLifeCycle;
        }
        return (KsLifecycle) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final KsFragment getParentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Fragment parentFragment = this.mBase.getParentFragment();
            if (parentFragment instanceof IDelegateFragment) {
                return ((IDelegateFragment) parentFragment).getBase();
            }
            if (parentFragment == null) {
                return null;
            }
            throw new RuntimeException(parentFragment + " is not a DelegateFragment or DelegateDialogFragment");
        }
        return (KsFragment) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final Object getReenterTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mBase.getReenterTransition() : invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mBase.getResources() : (Resources) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean getRetainInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mBase.getRetainInstance() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Object getReturnTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mBase.getReturnTransition() : invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Object getSharedElementEnterTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mBase.getSharedElementEnterTransition() : invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Object getSharedElementReturnTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mBase.getSharedElementReturnTransition() : invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public final String getString(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? this.mBase.getString(i2) : (String) invokeI.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public final String getString(@StringRes int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048599, this, i2, objArr)) == null) ? this.mBase.getString(i2, objArr) : (String) invokeIL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mBase.getTag() : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final int getTargetRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mBase.getTargetRequestCode() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public final CharSequence getText(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? this.mBase.getText(i2) : (CharSequence) invokeI.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean getUserVisibleHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mBase.getUserVisibleHint() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mBase.getView() : (View) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public final boolean hasOptionsMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mBase.hasOptionsMenu() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isAdded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mBase.isAdded() : invokeV.booleanValue;
    }

    public boolean isAllFragmentIsHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (isKsAdParentFragment()) {
                KsFragment parentFragment = getParentFragment();
                return parentFragment == null ? isHidden() : isHidden() || parentFragment.isAllFragmentIsHidden();
            }
            Fragment fragment = this.mBase;
            Fragment parentFragment2 = fragment.getParentFragment();
            boolean isHidden = fragment.isHidden();
            return parentFragment2 == null ? isHidden : isHidden || isAllFragmentIsHidden(parentFragment2);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isDetached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mBase.isDetached() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mBase.isHidden() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isInLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mBase.isInLayout() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public final boolean isMenuVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mBase.isMenuVisible() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isRemoving() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mBase.isRemoving() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    public final boolean isResumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mBase.isResumed() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isStateSaved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mBase.isStateSaved() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mBase.isVisible() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttachFragment(KsFragment ksFragment) {
        super.onAttachFragment(ksFragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ Animation onCreateAnimation(int i2, boolean z, int i3) {
        return super.onCreateAnimation(i2, z, i3);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ Animator onCreateAnimator(int i2, boolean z, int i3) {
        return super.onCreateAnimator(i2, z, i3);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDetach() {
        super.onDetach();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, bundle)) == null) ? this.mBase.onGetLayoutInflater(bundle) : (LayoutInflater) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void postponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.mBase.postponeEnterTransition();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void registerForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, view) == null) {
            this.mBase.registerForContextMenu(view);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void requestPermissions(@NonNull String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048653, this, strArr, i2) == null) {
            this.mBase.requestPermissions(strArr, i2);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setAllowEnterTransitionOverlap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.mBase.setAllowEnterTransitionOverlap(z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setAllowReturnTransitionOverlap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            this.mBase.setAllowReturnTransitionOverlap(z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setArguments(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, bundle) == null) {
            this.mBase.setArguments(bundle);
        }
    }

    @Keep
    public void setBase(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, fragment) == null) {
            this.mBase = fragment;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setEnterTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, obj) == null) {
            this.mBase.setEnterTransition(obj);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setExitTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, obj) == null) {
            this.mBase.setExitTransition(obj);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setHasOptionsMenu(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.mBase.setHasOptionsMenu(z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    public void setInitialSavedState(@Nullable KsSavedState ksSavedState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, ksSavedState) == null) {
            this.mBase.setInitialSavedState(ksSavedState.getBase());
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setMenuVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.mBase.setMenuVisibility(z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setReenterTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, obj) == null) {
            this.mBase.setReenterTransition(obj);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setRetainInstance(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            this.mBase.setRetainInstance(z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setReturnTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, obj) == null) {
            this.mBase.setReturnTransition(obj);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setSharedElementEnterTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, obj) == null) {
            this.mBase.setSharedElementEnterTransition(obj);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setSharedElementReturnTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, obj) == null) {
            this.mBase.setSharedElementReturnTransition(obj);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
            this.mBase.setUserVisibleHint(z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048669, this, str)) == null) ? this.mBase.shouldShowRequestPermissionRationale(str) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, intent) == null) {
            this.mBase.startActivity(intent);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startActivity(Intent intent, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048671, this, intent, bundle) == null) {
            this.mBase.startActivity(intent, bundle);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048672, this, intent, i2) == null) {
            this.mBase.startActivityForResult(intent, i2);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startActivityForResult(Intent intent, int i2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048673, this, intent, i2, bundle) == null) {
            this.mBase.startActivityForResult(intent, i2, bundle);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startIntentSenderForResult(IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048674, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            this.mBase.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.mBase.startPostponedEnterTransition();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void unregisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, view) == null) {
            this.mBase.unregisterForContextMenu(view);
        }
    }
}
