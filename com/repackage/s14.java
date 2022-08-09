package com.repackage;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class s14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            z14 z14Var = new z14();
            z14Var.a = str;
            p14.c().a(new o14(50000, z14Var));
        }
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            z14 z14Var = new z14();
            z14Var.a = str;
            p14.c().a(new o14(90000, z14Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            w14 w14Var = new w14();
            w14Var.b = str;
            w14Var.c = i;
            w14Var.d = z ? 1 : 0;
            w14Var.a = str2;
            p14.c().a(new o14(100000, w14Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            z14 z14Var = new z14();
            z14Var.a = str;
            p14.c().a(new o14(20000, z14Var));
        }
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            z14 z14Var = new z14();
            z14Var.a = str;
            p14.c().a(new o14(60000, z14Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            z14 z14Var = new z14();
            z14Var.a = str;
            p14.c().a(new o14(10000, z14Var));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            z14 z14Var = new z14();
            z14Var.a = str;
            p14.c().a(new o14(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, z14Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            w14 w14Var = new w14();
            w14Var.b = str;
            w14Var.c = i;
            w14Var.d = z ? 1 : 0;
            w14Var.a = str2;
            p14.c().a(new o14(70000, w14Var));
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            x14 x14Var = new x14();
            x14Var.b = str;
            x14Var.a = str2;
            p14.c().a(new o14(30000, x14Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            y14 y14Var = new y14();
            y14Var.b = str;
            y14Var.c = i;
            y14Var.a = str2;
            p14.c().a(new o14(80000, y14Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            w14 w14Var = new w14();
            w14Var.b = str;
            w14Var.c = i;
            w14Var.d = z ? 1 : 0;
            w14Var.a = str2;
            p14.c().a(new o14(110000, w14Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            z14 z14Var = new z14();
            z14Var.a = str;
            p14.c().a(new o14(120000, z14Var));
        }
    }
}
