package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class h9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static d9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof d9) {
                return (d9) context;
            }
            if (context instanceof e9) {
                return ((e9) context).getPageContext();
            }
            Field b = fi.b(context.getClass(), g9.class);
            if (b == null || (a = fi.a(context, b)) == null || !(a instanceof g9) || !(a instanceof e9)) {
                return null;
            }
            return ((e9) a).getPageContext();
        }
        return (d9) invokeL.objValue;
    }

    public static e9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof e9) {
                return (e9) context;
            }
            Field b = fi.b(context.getClass(), g9.class);
            if (b == null || (a = fi.a(context, b)) == null || !(a instanceof g9) || !(a instanceof e9)) {
                return null;
            }
            return (e9) a;
        }
        return (e9) invokeL.objValue;
    }

    public static g9 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof g9) {
                return (g9) context;
            }
            if (context instanceof e9) {
                Object orignalPage = ((e9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof g9) {
                    return (g9) orignalPage;
                }
            }
            Field b = fi.b(context.getClass(), g9.class);
            if (b == null || (a = fi.a(context, b)) == null || !(a instanceof g9)) {
                return null;
            }
            return (g9) a;
        }
        return (g9) invokeL.objValue;
    }
}
