package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentActivity;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes2.dex */
public abstract class BaseProxyFragmentActivity extends KsFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IFragmentActivityProxy mDelegate;

    public BaseProxyFragmentActivity() {
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

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.attachBaseContext(Wrapper.wrapContextIfNeed(context));
            IFragmentActivityProxy delegate = getDelegate(context);
            this.mDelegate = delegate;
            delegate.setProxyFragmentActivity(this);
            this.mDelegate.setActivity(this);
        }
    }

    @NonNull
    public abstract IFragmentActivityProxy getDelegate(Context context);

    @Override // android.app.Activity
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
            if (externalClassLoader != null) {
                Intent intent = super.getIntent();
                intent.setExtrasClassLoader(externalClassLoader);
                return intent;
            }
            return super.getIntent();
        }
        return (Intent) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.mDelegate.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.onApplyThemeResource(theme, i2, z);
            this.mDelegate.onApplyThemeResource(theme, i2, z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragmentActivity
    public void onAttachFragment(KsFragment ksFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ksFragment) == null) {
            super.onAttachFragment(ksFragment);
            this.mDelegate.onAttachFragment(ksFragment);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mDelegate.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, activity, charSequence) == null) {
            super.onChildTitleChanged(activity, charSequence);
            this.mDelegate.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mDelegate.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            this.mDelegate.onPreCreate(bundle);
            super.onCreate(bundle);
            this.mDelegate.onCreate(bundle);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mDelegate.onPreDestroy();
            super.onDestroy();
            this.mDelegate.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, keyEvent)) == null) ? this.mDelegate.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i2, keyEvent)) == null) ? this.mDelegate.onKeyLongPress(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, keyEvent)) == null) ? this.mDelegate.onKeyUp(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            super.onNewIntent(intent);
            this.mDelegate.onNewIntent(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mDelegate.onPrePause();
            super.onPause();
            this.mDelegate.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onPostCreate(bundle);
            this.mDelegate.onPostCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPostResume();
            this.mDelegate.onPostResume();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onRestart();
            this.mDelegate.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            this.mDelegate.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.mDelegate.onPreResume();
            super.onResume();
            this.mDelegate.onResume();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            this.mDelegate.onPreSaveInstanceState(bundle);
            super.onSaveInstanceState(bundle);
            this.mDelegate.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.mDelegate.onPreStart();
            super.onStart();
            this.mDelegate.onStart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.mDelegate.onPreStop();
            super.onStop();
            this.mDelegate.onStop();
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, charSequence, i2) == null) {
            super.onTitleChanged(charSequence, i2);
            this.mDelegate.onTitleChanged(charSequence, i2);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onUserLeaveHint();
            this.mDelegate.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, intent) == null) {
            if (intent != null) {
                intent.putExtra("key_start_time", SystemClock.uptimeMillis());
            }
            super.startActivity(intent);
        }
    }

    public void superOnBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onBackPressed();
        }
    }

    public boolean superOnKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i2, keyEvent)) == null) ? super.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    public boolean superOnKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i2, keyEvent)) == null) ? super.onKeyLongPress(i2, keyEvent) : invokeIL.booleanValue;
    }

    public boolean superOnKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) ? super.onKeyUp(i2, keyEvent) : invokeIL.booleanValue;
    }
}
