package com.repackage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes6.dex */
public class df {
    public static /* synthetic */ Interceptable $ic = null;
    public static String d = "_crashtime";
    public static String e = "_crashtype";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public cf c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964042301, "Lcom/repackage/df;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964042301, "Lcom/repackage/df;");
        }
    }

    public df(cf cfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cfVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = null;
        if (cfVar != null) {
            this.c = cfVar;
            if (cfVar.d() > 0 && this.c.c() != null) {
                int e2 = e();
                this.a = e2;
                if (e2 == -1) {
                    g();
                }
            }
            if (!cfVar.h()) {
                this.b = f();
            }
            this.c.a(this.b, true);
            return;
        }
        throw new InvalidParameterException("SwitchHolder data is null");
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        String[] g;
        String[] c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null && this.c.d() > 0) {
                if (this.c.c() != null) {
                    for (String str2 : this.c.c()) {
                        if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                            int i = this.a + 1;
                            this.a = i;
                            j(i);
                            if (this.a >= this.c.d()) {
                                k(this.c.f());
                                this.b = this.c.f();
                                cf cfVar = this.c;
                                cfVar.a(cfVar.f(), false);
                            }
                            return true;
                        }
                    }
                }
                if (this.c.g() != null) {
                    for (String str3 : this.c.g()) {
                        if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                            int i2 = this.a + 1;
                            this.a = i2;
                            j(i2);
                            if (this.a >= this.c.d()) {
                                k(this.c.f());
                                this.b = this.c.f();
                                cf cfVar2 = this.c;
                                cfVar2.a(cfVar2.f(), false);
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public cf b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (cf) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.b() : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.e() : (String) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
            return sharedPreferences.getInt(this.c.e() + d, -1);
        }
        return invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
            return sharedPreferences.getInt(this.c.e() + e, this.c.b());
        }
        return invokeV.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = 0;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : invokeV.intValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a = i;
        }
    }

    public boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.c.d() >= 0 && this.a >= this.c.d() + 2) {
                i = this.c.f();
            }
            if (i == this.b) {
                return false;
            }
            this.b = i;
            this.c.a(i, false);
            k(i);
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            edit.putInt(this.c.e() + d, i);
            edit.commit();
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            edit.putInt(this.c.e() + e, i);
            edit.commit();
        }
    }
}
