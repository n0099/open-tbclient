package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            u14 u14Var = new u14();
            u14Var.a = str;
            k14.c().a(new j14(50000, u14Var));
        }
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            u14 u14Var = new u14();
            u14Var.a = str;
            k14.c().a(new j14(90000, u14Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            r14 r14Var = new r14();
            r14Var.b = str;
            r14Var.c = i;
            r14Var.d = z ? 1 : 0;
            r14Var.a = str2;
            k14.c().a(new j14(100000, r14Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            u14 u14Var = new u14();
            u14Var.a = str;
            k14.c().a(new j14(20000, u14Var));
        }
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            u14 u14Var = new u14();
            u14Var.a = str;
            k14.c().a(new j14(60000, u14Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            u14 u14Var = new u14();
            u14Var.a = str;
            k14.c().a(new j14(10000, u14Var));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            u14 u14Var = new u14();
            u14Var.a = str;
            k14.c().a(new j14(40000, u14Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            r14 r14Var = new r14();
            r14Var.b = str;
            r14Var.c = i;
            r14Var.d = z ? 1 : 0;
            r14Var.a = str2;
            k14.c().a(new j14(70000, r14Var));
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            s14 s14Var = new s14();
            s14Var.b = str;
            s14Var.a = str2;
            k14.c().a(new j14(30000, s14Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            t14 t14Var = new t14();
            t14Var.b = str;
            t14Var.c = i;
            t14Var.a = str2;
            k14.c().a(new j14(80000, t14Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            r14 r14Var = new r14();
            r14Var.b = str;
            r14Var.c = i;
            r14Var.d = z ? 1 : 0;
            r14Var.a = str2;
            k14.c().a(new j14(110000, r14Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            u14 u14Var = new u14();
            u14Var.a = str;
            k14.c().a(new j14(120000, u14Var));
        }
    }
}
