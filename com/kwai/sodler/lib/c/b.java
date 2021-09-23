package com.kwai.sodler.lib.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.w;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f74710a = "plugin.signature";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2133750292, "Lcom/kwai/sodler/lib/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2133750292, "Lcom/kwai/sodler/lib/c/b;");
        }
    }

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                String str = f74710a;
                com.kwai.sodler.lib.a.e(str, "Can not get signature, error = " + e2.getLocalizedMessage());
                com.kwai.sodler.lib.a.a(f74710a, e2);
                return null;
            }
        }
        return (Signature[]) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                Signature[] a2 = a(context);
                if (a2 != null && a2.length >= 1) {
                    return w.a(a2[0].toByteArray());
                }
                return "";
            } catch (Exception e2) {
                com.kwai.sodler.lib.a.a(f74710a, e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
