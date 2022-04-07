package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public class zd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(ac acVar, vc vcVar) {
        InterceptResult invokeLL;
        ic a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, acVar, vcVar)) == null) {
            if (acVar == null || vcVar == null) {
                return false;
            }
            for (Field field : yb.b(acVar.getClass())) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name) && (a = be.a(yb.d(acVar, name))) != null) {
                        Object obj = null;
                        if (vcVar instanceof xc) {
                            obj = a.f(new yd(field.getGenericType()));
                        } else if (vcVar instanceof tc) {
                            obj = a.d(new yd(field.getGenericType()));
                        } else if (vcVar instanceof wc) {
                            obj = a.e(new yd(field.getGenericType()));
                        } else if (vcVar instanceof yc) {
                            obj = a.b(new yd(field.getGenericType()));
                        } else if (vcVar instanceof uc) {
                            obj = a.a(new yd(field.getGenericType()));
                        } else if (vcVar instanceof zc) {
                            obj = a.c(new yd(field.getGenericType()));
                        }
                        if (obj != null) {
                            vcVar.a(name, obj);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
