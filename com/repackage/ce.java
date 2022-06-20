package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
public class ce {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(dc dcVar, yc ycVar) {
        InterceptResult invokeLL;
        lc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dcVar, ycVar)) == null) {
            if (dcVar == null || ycVar == null) {
                return false;
            }
            for (Field field : bc.b(dcVar.getClass())) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name) && (a = ee.a(bc.d(dcVar, name))) != null) {
                        Object obj = null;
                        if (ycVar instanceof ad) {
                            obj = a.f(new be(field.getGenericType()));
                        } else if (ycVar instanceof wc) {
                            obj = a.d(new be(field.getGenericType()));
                        } else if (ycVar instanceof zc) {
                            obj = a.e(new be(field.getGenericType()));
                        } else if (ycVar instanceof bd) {
                            obj = a.b(new be(field.getGenericType()));
                        } else if (ycVar instanceof xc) {
                            obj = a.a(new be(field.getGenericType()));
                        } else if (ycVar instanceof cd) {
                            obj = a.c(new be(field.getGenericType()));
                        }
                        if (obj != null) {
                            ycVar.a(name, obj);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
