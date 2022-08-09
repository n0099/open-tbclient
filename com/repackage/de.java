package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes6.dex */
public class de {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(ec ecVar, zc zcVar) {
        InterceptResult invokeLL;
        mc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ecVar, zcVar)) == null) {
            if (ecVar == null || zcVar == null) {
                return false;
            }
            for (Field field : cc.b(ecVar.getClass())) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name) && (a = fe.a(cc.d(ecVar, name))) != null) {
                        Object obj = null;
                        if (zcVar instanceof bd) {
                            obj = a.f(new ce(field.getGenericType()));
                        } else if (zcVar instanceof xc) {
                            obj = a.d(new ce(field.getGenericType()));
                        } else if (zcVar instanceof ad) {
                            obj = a.e(new ce(field.getGenericType()));
                        } else if (zcVar instanceof cd) {
                            obj = a.b(new ce(field.getGenericType()));
                        } else if (zcVar instanceof yc) {
                            obj = a.a(new ce(field.getGenericType()));
                        } else if (zcVar instanceof dd) {
                            obj = a.c(new ce(field.getGenericType()));
                        }
                        if (obj != null) {
                            zcVar.a(name, obj);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
