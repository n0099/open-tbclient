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
/* loaded from: classes7.dex */
public class z80 implements d90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u70 a;
    public final int b;
    public boolean c;

    public z80() {
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
        this.b = ca0.a().b();
    }

    @Override // com.repackage.d90
    public void a(String str) {
        u70 u70Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (u70Var = this.a) == null) {
            return;
        }
        u70Var.O(str);
    }

    @Override // com.repackage.b90
    public void b() {
        u70 u70Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (u70Var = this.a) == null) {
            return;
        }
        u70Var.P();
    }

    @Override // com.repackage.b90
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.repackage.b90
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.repackage.b90
    public void e() {
        u70 u70Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (u70Var = this.a) == null) {
            return;
        }
        u70Var.T();
    }

    @Override // com.repackage.d90
    public void f() {
        u70 u70Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (u70Var = this.a) == null) {
            return;
        }
        u70Var.K();
    }

    @Override // com.repackage.b90
    public void g() {
        u70 u70Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (u70Var = this.a) == null) {
            return;
        }
        u70Var.U();
    }

    @Override // com.repackage.e90
    public void h() {
        u70 u70Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (u70Var = this.a) == null) {
            return;
        }
        u70Var.Q();
    }

    @Override // com.repackage.d90
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
                this.a = new u70(fragmentActivity, i, supportFragmentManager, str, str2, this.c, str3, str4, z);
                z70.s(fragmentActivity, "", "zhibopindao");
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

    @Override // com.repackage.d90
    public void onUserVisibleHint(boolean z) {
        u70 u70Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (u70Var = this.a) == null) {
            return;
        }
        u70Var.V(z);
    }
}
