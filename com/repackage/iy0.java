package com.repackage;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, ky0... ky0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, ky0VarArr) == null) {
            int i = 0;
            for (ky0 ky0Var : ky0VarArr) {
                for (Column column : ky0Var.b().c()) {
                    hy0.h(column, cursor, i);
                    i++;
                }
            }
        }
    }
}
