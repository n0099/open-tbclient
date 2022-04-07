package com.repackage;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, xz0... xz0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, xz0VarArr) == null) {
            int i = 0;
            for (xz0 xz0Var : xz0VarArr) {
                for (Column column : xz0Var.b().c()) {
                    uz0.h(column, cursor, i);
                    i++;
                }
            }
        }
    }
}
