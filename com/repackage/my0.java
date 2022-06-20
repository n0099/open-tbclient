package com.repackage;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class my0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, oy0... oy0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, oy0VarArr) == null) {
            int i = 0;
            for (oy0 oy0Var : oy0VarArr) {
                for (Column column : oy0Var.b().c()) {
                    ly0.h(column, cursor, i);
                    i++;
                }
            }
        }
    }
}
