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
/* loaded from: classes5.dex */
public class dj5 {
    public static /* synthetic */ Interceptable $ic;
    public static dj5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public dj5() {
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

    public static synchronized dj5 f() {
        InterceptResult invokeV;
        dj5 dj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (dj5.class) {
                if (a == null) {
                    a = new dj5();
                }
                dj5Var = a;
            }
            return dj5Var;
        }
        return (dj5) invokeV.objValue;
    }

    public final int a(n37 n37Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, n37Var)) != null) {
            return invokeL.intValue;
        }
        SQLiteDatabase c = y37.c();
        int i = 0;
        if (c == null) {
            return 0;
        }
        try {
            if (o(c, n37Var.b())) {
                ContentValues contentValues = new ContentValues();
                long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(n37Var.b());
                contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                int update = z37.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(n37Var.b())});
                try {
                    n37Var.h(correctUserIdAfterOverflowCut);
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
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? c(y37.c(), j) : invokeJ.booleanValue;
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, j)) == null) {
            try {
                return z37.d().delete("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
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
                sQLiteDatabase = y37.c();
            }
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = z37.d().e("select * from tb_new_friends", new String[0]);
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
                    mi.a(cursor);
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public synchronized n37 e(long j) {
        InterceptResult invokeJ;
        n37 n37Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                n37Var = new n37();
                Cursor cursor = null;
                try {
                    cursor = z37.d().e("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null && cursor.moveToNext()) {
                        n37Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        n37Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        n37Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        n37Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                        n37Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                mi.a(cursor);
            }
            return n37Var;
        }
        return (n37) invokeJ.objValue;
    }

    public List<n37> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = z37.d().e("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            n37 n37Var = new n37();
                            n37Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                            n37Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                            n37Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                            n37Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                            n37Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                            n37Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(n37Var);
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
                mi.a(cursor);
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
                    cursor = z37.d().e("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
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
                mi.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public final int i(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sQLiteDatabase)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = y37.c();
            }
            Cursor cursor = null;
            try {
                if (sQLiteDatabase == null) {
                    return 0;
                }
                try {
                    cursor = z37.d().e("select * from tb_new_friends", new String[0]);
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
                mi.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public List<n37> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SQLiteDatabase c = y37.c();
            ArrayList arrayList = new ArrayList();
            if (c != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = z37.d().e("select * from tb_new_friends ORDER BY _id DESC", null);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    n37 n37Var = new n37();
                                    n37Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                    if (n37Var.b() < 0) {
                                        a(n37Var);
                                    }
                                    n37Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                    n37Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                    n37Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                                    n37Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                    n37Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                    arrayList.add(n37Var);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    mi.a(cursor);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, n37 n37Var) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, n37Var) == null) || n37Var == null || n37Var.b() == 0 || TextUtils.isEmpty(n37Var.d())) {
            return;
        }
        if (sQLiteDatabase == null) {
            sQLiteDatabase = y37.c();
        }
        if (sQLiteDatabase != null) {
            c(sQLiteDatabase, n37Var.b());
            if (i(sQLiteDatabase) >= 200) {
                b(d(sQLiteDatabase));
            }
            if (sQLiteDatabase != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("uid", Long.valueOf(n37Var.b()));
                contentValues.put("uname", n37Var.d());
                contentValues.put("uportrait", n37Var.e());
                contentValues.put("ucontent", n37Var.a());
                contentValues.put("ustatus", Integer.valueOf(n37Var.f()));
                contentValues.put("isread", Integer.valueOf(n37Var.c()));
                z37.d().insert("tb_new_friends", null, contentValues);
            }
        }
    }

    public void l(n37 n37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, n37Var) == null) {
            try {
                k(y37.c(), n37Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(List<n37> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            try {
                for (n37 n37Var : list) {
                    k(y37.c(), n37Var);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) ? o(y37.c(), j) : invokeJ.booleanValue;
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, sQLiteDatabase, j)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = y37.c();
            }
            boolean z = false;
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = z37.d().e("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
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
                    mi.a(cursor);
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
            z37.d().update("tb_new_friends", contentValues, null, null);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:22:0x005b). Please submit an issue!!! */
    public int q(n37 n37Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, n37Var)) == null) {
            SQLiteDatabase c = y37.c();
            int i = 0;
            if (c != null) {
                try {
                    if (o(c, n37Var.b())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(n37Var.f()));
                        contentValues.put("isread", Integer.valueOf(n37Var.c()));
                        i = z37.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(n37Var.b())});
                    } else {
                        k(c, n37Var);
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
