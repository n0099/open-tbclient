package com.repackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ad4<?> a;

    public zc4(ad4<?> ad4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ad4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ad4Var;
    }

    public static final zc4 b(ad4<?> ad4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ad4Var)) == null) ? new zc4(ad4Var) : (zc4) invokeL.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.e.V();
        }
    }

    public View B(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str, context, attributeSet)) == null) ? this.a.e.onCreateView(view2, str, context, attributeSet) : (View) invokeLLLL.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.u();
        }
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, parcelable, list) == null) {
            this.a.e.b0(parcelable, list);
        }
    }

    public void E(sd4<String, fd4> sd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sd4Var) == null) {
            this.a.v(sd4Var);
        }
    }

    public sd4<String, fd4> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.w() : (sd4) invokeV.objValue;
    }

    public List<Fragment> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.e.c0() : (List) invokeV.objValue;
    }

    public Parcelable H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.e.e0() : (Parcelable) invokeV.objValue;
    }

    public void a(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fragment) == null) {
            ad4<?> ad4Var = this.a;
            ad4Var.e.j(ad4Var, ad4Var, fragment);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.e.n();
        }
    }

    public void d(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, configuration) == null) {
            this.a.e.o(configuration);
        }
    }

    public boolean e(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, menuItem)) == null) ? this.a.e.p(menuItem) : invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.e.q();
        }
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, menu, menuInflater)) == null) ? this.a.e.r(menu, menuInflater) : invokeLL.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.e.s();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.e.u();
        }
    }

    public boolean j(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, menuItem)) == null) ? this.a.e.v(menuItem) : invokeL.booleanValue;
    }

    public void k(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, menu) == null) {
            this.a.e.w(menu);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.e.x();
        }
    }

    public boolean m(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, menu)) == null) ? this.a.e.y(menu) : invokeL.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.e.z();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a.e.A();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.a.e.B();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.a.e.C();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.a.c();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.a.d();
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.a.e(z);
        }
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048603, this, str, fileDescriptor, printWriter, strArr) == null) {
            this.a.f(str, fileDescriptor, printWriter, strArr);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.a.e.E() : invokeV.booleanValue;
    }

    public List<Fragment> w(List<Fragment> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, list)) == null) {
            if (this.a.e.d == null) {
                return null;
            }
            if (list == null) {
                list = new ArrayList<>(x());
            }
            list.addAll(this.a.e.d);
            return list;
        }
        return (List) invokeL.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ArrayList<Fragment> arrayList = this.a.e.d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public bd4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.a.g() : (bd4) invokeV.objValue;
    }

    public fd4 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.a.j() : (fd4) invokeV.objValue;
    }
}
