package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qg5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755381070, "Lcom/repackage/qg5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755381070, "Lcom/repackage/qg5;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            vt4.k().D("key_youngster_verify");
        }
    }

    public static String b(og5 og5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, og5Var)) == null) {
            if (og5Var == null || StringUtils.isNull(og5Var.c()) || StringUtils.isNull(og5Var.b()) || StringUtils.isNull(og5Var.a())) {
                return "";
            }
            return og5Var.c() + "," + og5Var.b() + "," + og5Var.a();
        }
        return (String) invokeL.objValue;
    }

    public static og5 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String[] split = str.split(",");
            if (split.length > 2) {
                return new og5(split[0], split[1], split[2]);
            }
            return null;
        }
        return (og5) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String q = vt4.k().q("key_youngster_verify", "");
            if (StringUtils.isNull(q)) {
                a();
                return false;
            }
            og5 c = c(q);
            if (c == null) {
                return false;
            }
            return str.equals(c.a());
        }
        return invokeL.booleanValue;
    }

    public static void f(String str) {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || StringUtils.isNull(str) || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        vt4.k().y("key_youngster_verify", b(new og5(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
    }
}
