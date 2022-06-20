package com.repackage;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            s04 s04Var = new s04();
            s04Var.a = str;
            i04.c().a(new h04(50000, s04Var));
        }
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            s04 s04Var = new s04();
            s04Var.a = str;
            i04.c().a(new h04(90000, s04Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            p04 p04Var = new p04();
            p04Var.b = str;
            p04Var.c = i;
            p04Var.d = z ? 1 : 0;
            p04Var.a = str2;
            i04.c().a(new h04(100000, p04Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            s04 s04Var = new s04();
            s04Var.a = str;
            i04.c().a(new h04(20000, s04Var));
        }
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            s04 s04Var = new s04();
            s04Var.a = str;
            i04.c().a(new h04(60000, s04Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            s04 s04Var = new s04();
            s04Var.a = str;
            i04.c().a(new h04(10000, s04Var));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            s04 s04Var = new s04();
            s04Var.a = str;
            i04.c().a(new h04(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, s04Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            p04 p04Var = new p04();
            p04Var.b = str;
            p04Var.c = i;
            p04Var.d = z ? 1 : 0;
            p04Var.a = str2;
            i04.c().a(new h04(70000, p04Var));
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            q04 q04Var = new q04();
            q04Var.b = str;
            q04Var.a = str2;
            i04.c().a(new h04(30000, q04Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            r04 r04Var = new r04();
            r04Var.b = str;
            r04Var.c = i;
            r04Var.a = str2;
            i04.c().a(new h04(80000, r04Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            p04 p04Var = new p04();
            p04Var.b = str;
            p04Var.c = i;
            p04Var.d = z ? 1 : 0;
            p04Var.a = str2;
            i04.c().a(new h04(110000, p04Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            s04 s04Var = new s04();
            s04Var.a = str;
            i04.c().a(new h04(120000, s04Var));
        }
    }
}
