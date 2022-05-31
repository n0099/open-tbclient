package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class f9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static b9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof b9) {
                return (b9) context;
            }
            if (context instanceof c9) {
                return ((c9) context).getPageContext();
            }
            Field b = bi.b(context.getClass(), e9.class);
            if (b == null || (a = bi.a(context, b)) == null || !(a instanceof e9) || !(a instanceof c9)) {
                return null;
            }
            return ((c9) a).getPageContext();
        }
        return (b9) invokeL.objValue;
    }

    public static c9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof c9) {
                return (c9) context;
            }
            Field b = bi.b(context.getClass(), e9.class);
            if (b == null || (a = bi.a(context, b)) == null || !(a instanceof e9) || !(a instanceof c9)) {
                return null;
            }
            return (c9) a;
        }
        return (c9) invokeL.objValue;
    }

    public static e9 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof e9) {
                return (e9) context;
            }
            if (context instanceof c9) {
                Object orignalPage = ((c9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof e9) {
                    return (e9) orignalPage;
                }
            }
            Field b = bi.b(context.getClass(), e9.class);
            if (b == null || (a = bi.a(context, b)) == null || !(a instanceof e9)) {
                return null;
            }
            return (e9) a;
        }
        return (e9) invokeL.objValue;
    }
}
