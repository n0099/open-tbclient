package com.repackage;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            i14 i14Var = new i14();
            i14Var.a = str;
            y04.c().a(new x04(50000, i14Var));
        }
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            i14 i14Var = new i14();
            i14Var.a = str;
            y04.c().a(new x04(90000, i14Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            f14 f14Var = new f14();
            f14Var.b = str;
            f14Var.c = i;
            f14Var.d = z ? 1 : 0;
            f14Var.a = str2;
            y04.c().a(new x04(100000, f14Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            i14 i14Var = new i14();
            i14Var.a = str;
            y04.c().a(new x04(20000, i14Var));
        }
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            i14 i14Var = new i14();
            i14Var.a = str;
            y04.c().a(new x04(60000, i14Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            i14 i14Var = new i14();
            i14Var.a = str;
            y04.c().a(new x04(10000, i14Var));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            i14 i14Var = new i14();
            i14Var.a = str;
            y04.c().a(new x04(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, i14Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            f14 f14Var = new f14();
            f14Var.b = str;
            f14Var.c = i;
            f14Var.d = z ? 1 : 0;
            f14Var.a = str2;
            y04.c().a(new x04(70000, f14Var));
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            g14 g14Var = new g14();
            g14Var.b = str;
            g14Var.a = str2;
            y04.c().a(new x04(30000, g14Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            h14 h14Var = new h14();
            h14Var.b = str;
            h14Var.c = i;
            h14Var.a = str2;
            y04.c().a(new x04(80000, h14Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            f14 f14Var = new f14();
            f14Var.b = str;
            f14Var.c = i;
            f14Var.d = z ? 1 : 0;
            f14Var.a = str2;
            y04.c().a(new x04(110000, f14Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            i14 i14Var = new i14();
            i14Var.a = str;
            y04.c().a(new x04(120000, i14Var));
        }
    }
}
