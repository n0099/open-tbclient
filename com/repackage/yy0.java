package com.repackage;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, az0... az0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, az0VarArr) == null) {
            int i = 0;
            for (az0 az0Var : az0VarArr) {
                for (Column column : az0Var.b().c()) {
                    xy0.h(column, cursor, i);
                    i++;
                }
            }
        }
    }
}
