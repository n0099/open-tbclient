package com.kwad.components.core.h;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.BaseSystemDialogFragment;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.utils.q;
/* loaded from: classes5.dex */
public abstract class e extends BaseSystemDialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private int a(FragmentTransaction fragmentTransaction, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, fragmentTransaction, str)) == null) {
            try {
                q.a(this, "mDismissed", Boolean.FALSE);
                q.a(this, "mShownByMe", Boolean.TRUE);
                q.a(this, "mViewDestroyed", Boolean.FALSE);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
            }
            return fragmentTransaction.add(this, str).commitAllowingStateLoss();
        }
        return invokeLL.intValue;
    }

    public abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    @Override // android.app.DialogFragment
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (getActivity().isFinishing()) {
                    return;
                }
                super.dismissAllowingStateLoss();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) ? a(Wrapper.wrapInflaterIfNeed(layoutInflater), viewGroup) : (View) invokeLLL.objValue;
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fragmentTransaction, str)) == null) {
            try {
                return super.show(fragmentTransaction, str);
            } catch (Throwable unused) {
                return a(fragmentTransaction, str);
            }
        }
        return invokeLL.intValue;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, fragmentManager, str) == null) {
            try {
                try {
                    super.show(fragmentManager, str);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.b(th);
                    a(fragmentManager.beginTransaction(), str);
                }
            } catch (Throwable unused) {
                q.a((Object) this, "showAllowingStateLoss", fragmentManager, str);
            }
        }
    }
}
