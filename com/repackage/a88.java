package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a88 implements ul7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public c88 b;

    public a88(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = new c88(str);
    }

    @Override // com.repackage.ul7
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && m(str)) {
            pr8.d().j(this.a, pr8.i(VideoPlatformStatic.c(), this.b.d(), this.b.b()));
        }
    }

    @Override // com.repackage.ul7
    public void b(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2}) == null) && m(str)) {
            this.b.f();
            this.b.i();
            this.b.k();
            this.b.a(new r78(i, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // com.repackage.ul7
    public void c(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2) == null) && m(str)) {
            this.b.f();
            this.b.a(new r78(i, "edit", i, str2));
        }
    }

    @Override // com.repackage.ul7
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (m(str)) {
                return this.b.g();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ul7
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.b.h() : invokeL.booleanValue;
    }

    @Override // com.repackage.ul7
    public void f(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048581, this, str, i, str2) == null) && m(str)) {
            this.b.f();
            this.b.a(new r78(i, BundleOpProvider.METHOD_BUNDLE_RECORD, i, str2));
        }
    }

    @Override // com.repackage.ul7
    public void g(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) && m(str)) {
            this.b.f();
            this.b.i();
            this.b.k();
            this.b.a(new r78(402, AlbumActivityConfig.FROM_WRITE, i, str2));
        }
    }

    @Override // com.repackage.ul7
    public void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) && m(str)) {
            this.b.a(new r78(503, str2, -4399, ""));
        }
    }

    @Override // com.repackage.ul7
    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && m(str)) {
            this.b.a(new r78(501, str2, -4399, ""));
        }
    }

    @Override // com.repackage.ul7
    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && m(str)) {
            this.b.k();
            this.b.a(new r78(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.repackage.ul7
    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && m(str)) {
            this.b.k();
            this.b.j();
            this.b.a(new r78(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // com.repackage.ul7
    public void l(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048587, this, str, i, str2) == null) && m(str)) {
            if (i != 103 && i != 105 && i != 106 && i != 107 && i != 104) {
                this.b.a(new r78(i, str2, -4399, ""));
                return;
            }
            this.b.f();
            this.b.a(new r78(i, str2, i, VideoPlatformStatic.g(i)));
        }
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? (!TextUtils.equals(this.a, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.a)) ? false : true : invokeL.booleanValue;
    }
}
