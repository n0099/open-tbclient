package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes6.dex */
public class ee {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(zc zcVar, ec ecVar) {
        InterceptResult invokeLL;
        Object b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, zcVar, ecVar)) == null) {
            if (ecVar == null || zcVar == null) {
                return false;
            }
            List<Field> b2 = cc.b(ecVar.getClass());
            Set<String> keys = zcVar.getKeys();
            for (Field field : b2) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name)) {
                        if (keys.contains(name)) {
                            Object b3 = zcVar.b(name, field.getGenericType());
                            if (b3 != null) {
                                cc.h(ecVar, name, b3);
                            }
                        } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                            Object b4 = zcVar.b(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                            if (b4 != null) {
                                cc.h(ecVar, name, b4);
                            }
                        } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (b = zcVar.b(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                            cc.h(ecVar, name, b);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
