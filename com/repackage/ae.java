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
/* loaded from: classes5.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(vc vcVar, ac acVar) {
        InterceptResult invokeLL;
        Object b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, vcVar, acVar)) == null) {
            if (acVar == null || vcVar == null) {
                return false;
            }
            List<Field> b2 = yb.b(acVar.getClass());
            Set<String> keys = vcVar.getKeys();
            for (Field field : b2) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name)) {
                        if (keys.contains(name)) {
                            Object b3 = vcVar.b(name, field.getGenericType());
                            if (b3 != null) {
                                yb.h(acVar, name, b3);
                            }
                        } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                            Object b4 = vcVar.b(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                            if (b4 != null) {
                                yb.h(acVar, name, b4);
                            }
                        } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (b = vcVar.b(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                            yb.h(acVar, name, b);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
