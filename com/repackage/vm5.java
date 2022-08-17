package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class vm5 {
    public static /* synthetic */ Interceptable $ic;
    public static vm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public vm5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized vm5 f() {
        InterceptResult invokeV;
        vm5 vm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (vm5.class) {
                if (a == null) {
                    a = new vm5();
                }
                vm5Var = a;
            }
            return vm5Var;
        }
        return (vm5) invokeV.objValue;
    }

    public final int a(g77 g77Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, g77Var)) != null) {
            return invokeL.intValue;
        }
        SQLiteDatabase c = r77.c();
        int i = 0;
        if (c == null) {
            return 0;
        }
        try {
            if (o(c, g77Var.b())) {
                ContentValues contentValues = new ContentValues();
                long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(g77Var.b());
                contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                int update = s77.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(g77Var.b())});
                try {
                    g77Var.h(correctUserIdAfterOverflowCut);
                    return update;
                } catch (Exception e) {
                    e = e;
                    i = update;
                    e.printStackTrace();
                    return i;
                }
            }
            return 0;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? c(r77.c(), j) : invokeJ.booleanValue;
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, j)) == null) {
            try {
                return s77.d().delete("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public final long d(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sQLiteDatabase)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = r77.c();
            }
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = s77.d().e("select * from tb_new_friends", new String[0]);
                            if (cursor != null && cursor.moveToNext()) {
                                return cursor.getLong(cursor.getColumnIndex("uid"));
                            }
                        } catch (SQLiteException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return 0L;
                } finally {
                    ri.a(cursor);
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public synchronized g77 e(long j) {
        InterceptResult invokeJ;
        g77 g77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                g77Var = new g77();
                Cursor cursor = null;
                try {
                    cursor = s77.d().e("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null && cursor.moveToNext()) {
                        g77Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        g77Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        g77Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        g77Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                        g77Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                ri.a(cursor);
            }
            return g77Var;
        }
        return (g77) invokeJ.objValue;
    }

    public List<g77> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = s77.d().e("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            g77 g77Var = new g77();
                            g77Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                            g77Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                            g77Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                            g77Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                            g77Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                            g77Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(g77Var);
                        }
                        p();
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return arrayList;
            } finally {
                ri.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = s77.d().e("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
                    if (cursor != null && cursor.moveToNext()) {
                        return cursor.getInt(0);
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            } finally {
                ri.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public final int i(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sQLiteDatabase)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = r77.c();
            }
            Cursor cursor = null;
            try {
                if (sQLiteDatabase == null) {
                    return 0;
                }
                try {
                    cursor = s77.d().e("select * from tb_new_friends", new String[0]);
                    if (cursor != null && cursor.moveToFirst()) {
                        return cursor.getCount();
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            } finally {
                ri.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public List<g77> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SQLiteDatabase c = r77.c();
            ArrayList arrayList = new ArrayList();
            if (c != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = s77.d().e("select * from tb_new_friends ORDER BY _id DESC", null);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    g77 g77Var = new g77();
                                    g77Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                    if (g77Var.b() < 0) {
                                        a(g77Var);
                                    }
                                    g77Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                    g77Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                    g77Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                                    g77Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                    g77Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                    arrayList.add(g77Var);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    ri.a(cursor);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, g77 g77Var) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, g77Var) == null) || g77Var == null || g77Var.b() == 0 || TextUtils.isEmpty(g77Var.d())) {
            return;
        }
        if (sQLiteDatabase == null) {
            sQLiteDatabase = r77.c();
        }
        if (sQLiteDatabase != null) {
            c(sQLiteDatabase, g77Var.b());
            if (i(sQLiteDatabase) >= 200) {
                b(d(sQLiteDatabase));
            }
            if (sQLiteDatabase != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("uid", Long.valueOf(g77Var.b()));
                contentValues.put("uname", g77Var.d());
                contentValues.put("uportrait", g77Var.e());
                contentValues.put("ucontent", g77Var.a());
                contentValues.put("ustatus", Integer.valueOf(g77Var.f()));
                contentValues.put("isread", Integer.valueOf(g77Var.c()));
                s77.d().insert("tb_new_friends", null, contentValues);
            }
        }
    }

    public void l(g77 g77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, g77Var) == null) {
            try {
                k(r77.c(), g77Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(List<g77> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            try {
                for (g77 g77Var : list) {
                    k(r77.c(), g77Var);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) ? o(r77.c(), j) : invokeJ.booleanValue;
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, sQLiteDatabase, j)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = r77.c();
            }
            boolean z = false;
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = s77.d().e("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                        if (cursor != null) {
                            if (cursor.moveToFirst()) {
                                z = true;
                            }
                        }
                    } catch (SQLiteException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    ri.a(cursor);
                }
            }
            return z;
        }
        return invokeLJ.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isread", (Integer) 1);
            s77.d().update("tb_new_friends", contentValues, null, null);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:22:0x005b). Please submit an issue!!! */
    public int q(g77 g77Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, g77Var)) == null) {
            SQLiteDatabase c = r77.c();
            int i = 0;
            if (c != null) {
                try {
                    if (o(c, g77Var.b())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(g77Var.f()));
                        contentValues.put("isread", Integer.valueOf(g77Var.c()));
                        i = s77.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(g77Var.b())});
                    } else {
                        k(c, g77Var);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }
}
