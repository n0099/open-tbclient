package com.repackage;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            h14 h14Var = new h14();
            h14Var.a = str;
            x04.c().a(new w04(50000, h14Var));
        }
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            h14 h14Var = new h14();
            h14Var.a = str;
            x04.c().a(new w04(90000, h14Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            e14 e14Var = new e14();
            e14Var.b = str;
            e14Var.c = i;
            e14Var.d = z ? 1 : 0;
            e14Var.a = str2;
            x04.c().a(new w04(100000, e14Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            h14 h14Var = new h14();
            h14Var.a = str;
            x04.c().a(new w04(20000, h14Var));
        }
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            h14 h14Var = new h14();
            h14Var.a = str;
            x04.c().a(new w04(60000, h14Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            h14 h14Var = new h14();
            h14Var.a = str;
            x04.c().a(new w04(10000, h14Var));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            h14 h14Var = new h14();
            h14Var.a = str;
            x04.c().a(new w04(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, h14Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            e14 e14Var = new e14();
            e14Var.b = str;
            e14Var.c = i;
            e14Var.d = z ? 1 : 0;
            e14Var.a = str2;
            x04.c().a(new w04(70000, e14Var));
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            f14 f14Var = new f14();
            f14Var.b = str;
            f14Var.a = str2;
            x04.c().a(new w04(30000, f14Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            g14 g14Var = new g14();
            g14Var.b = str;
            g14Var.c = i;
            g14Var.a = str2;
            x04.c().a(new w04(80000, g14Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            e14 e14Var = new e14();
            e14Var.b = str;
            e14Var.c = i;
            e14Var.d = z ? 1 : 0;
            e14Var.a = str2;
            x04.c().a(new w04(110000, e14Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            h14 h14Var = new h14();
            h14Var.a = str;
            x04.c().a(new w04(120000, h14Var));
        }
    }
}
