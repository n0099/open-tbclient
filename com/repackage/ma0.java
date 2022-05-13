package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes6.dex */
public class ma0 implements qa0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h90 a;
    public final int b;
    public boolean c;

    public ma0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = pb0.a().b();
    }

    @Override // com.repackage.qa0
    public void a(String str) {
        h90 h90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (h90Var = this.a) == null) {
            return;
        }
        h90Var.O(str);
    }

    @Override // com.repackage.oa0
    public void b() {
        h90 h90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (h90Var = this.a) == null) {
            return;
        }
        h90Var.P();
    }

    @Override // com.repackage.oa0
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.repackage.oa0
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.repackage.oa0
    public void e() {
        h90 h90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (h90Var = this.a) == null) {
            return;
        }
        h90Var.T();
    }

    @Override // com.repackage.qa0
    public void f() {
        h90 h90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (h90Var = this.a) == null) {
            return;
        }
        h90Var.K();
    }

    @Override // com.repackage.oa0
    public void g() {
        h90 h90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (h90Var = this.a) == null) {
            return;
        }
        h90Var.U();
    }

    @Override // com.repackage.ra0
    public void h() {
        h90 h90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (h90Var = this.a) == null) {
            return;
        }
        h90Var.Q();
    }

    @Override // com.repackage.qa0
    public View i(FragmentActivity fragmentActivity, Fragment fragment, String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        FragmentManager supportFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{fragmentActivity, fragment, str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            j("onCreateView hostType:   page: " + str);
            if (this.a == null) {
                int i = this.b;
                if (fragment != null) {
                    supportFragmentManager = fragment.getChildFragmentManager();
                } else {
                    supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                }
                this.a = new h90(fragmentActivity, i, supportFragmentManager, str, str2, this.c, str3, str4, z);
                m90.s(fragmentActivity, "", "zhibopindao");
            }
            return this.a.z();
        }
        return (View) invokeCommon.objValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            LiveFeedPageSdk.m("LiveFeedPageViewImpl " + str + GlideException.IndentedAppendable.INDENT + this.a);
        }
    }

    @Override // com.repackage.qa0
    public void onUserVisibleHint(boolean z) {
        h90 h90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (h90Var = this.a) == null) {
            return;
        }
        h90Var.V(z);
    }
}
