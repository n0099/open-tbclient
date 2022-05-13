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
/* loaded from: classes6.dex */
public class jk5 {
    public static /* synthetic */ Interceptable $ic;
    public static jk5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public jk5() {
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

    public static synchronized jk5 f() {
        InterceptResult invokeV;
        jk5 jk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (jk5.class) {
                if (a == null) {
                    a = new jk5();
                }
                jk5Var = a;
            }
            return jk5Var;
        }
        return (jk5) invokeV.objValue;
    }

    public final int a(l57 l57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, l57Var)) != null) {
            return invokeL.intValue;
        }
        SQLiteDatabase c = w57.c();
        int i = 0;
        if (c == null) {
            return 0;
        }
        try {
            if (o(c, l57Var.b())) {
                ContentValues contentValues = new ContentValues();
                long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(l57Var.b());
                contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                int update = x57.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(l57Var.b())});
                try {
                    l57Var.h(correctUserIdAfterOverflowCut);
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
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? c(w57.c(), j) : invokeJ.booleanValue;
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, j)) == null) {
            try {
                return x57.d().delete("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
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
                sQLiteDatabase = w57.c();
            }
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = x57.d().e("select * from tb_new_friends", new String[0]);
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
                    ni.a(cursor);
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public synchronized l57 e(long j) {
        InterceptResult invokeJ;
        l57 l57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                l57Var = new l57();
                Cursor cursor = null;
                try {
                    cursor = x57.d().e("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null && cursor.moveToNext()) {
                        l57Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        l57Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        l57Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        l57Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                        l57Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                ni.a(cursor);
            }
            return l57Var;
        }
        return (l57) invokeJ.objValue;
    }

    public List<l57> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = x57.d().e("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            l57 l57Var = new l57();
                            l57Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                            l57Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                            l57Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                            l57Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                            l57Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                            l57Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(l57Var);
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
                ni.a(cursor);
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
                    cursor = x57.d().e("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
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
                ni.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public final int i(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sQLiteDatabase)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = w57.c();
            }
            Cursor cursor = null;
            try {
                if (sQLiteDatabase == null) {
                    return 0;
                }
                try {
                    cursor = x57.d().e("select * from tb_new_friends", new String[0]);
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
                ni.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public List<l57> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SQLiteDatabase c = w57.c();
            ArrayList arrayList = new ArrayList();
            if (c != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = x57.d().e("select * from tb_new_friends ORDER BY _id DESC", null);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    l57 l57Var = new l57();
                                    l57Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                    if (l57Var.b() < 0) {
                                        a(l57Var);
                                    }
                                    l57Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                    l57Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                    l57Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                                    l57Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                    l57Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                    arrayList.add(l57Var);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    ni.a(cursor);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, l57 l57Var) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, l57Var) == null) || l57Var == null || l57Var.b() == 0 || TextUtils.isEmpty(l57Var.d())) {
            return;
        }
        if (sQLiteDatabase == null) {
            sQLiteDatabase = w57.c();
        }
        if (sQLiteDatabase != null) {
            c(sQLiteDatabase, l57Var.b());
            if (i(sQLiteDatabase) >= 200) {
                b(d(sQLiteDatabase));
            }
            if (sQLiteDatabase != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("uid", Long.valueOf(l57Var.b()));
                contentValues.put("uname", l57Var.d());
                contentValues.put("uportrait", l57Var.e());
                contentValues.put("ucontent", l57Var.a());
                contentValues.put("ustatus", Integer.valueOf(l57Var.f()));
                contentValues.put("isread", Integer.valueOf(l57Var.c()));
                x57.d().insert("tb_new_friends", null, contentValues);
            }
        }
    }

    public void l(l57 l57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, l57Var) == null) {
            try {
                k(w57.c(), l57Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(List<l57> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            try {
                for (l57 l57Var : list) {
                    k(w57.c(), l57Var);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) ? o(w57.c(), j) : invokeJ.booleanValue;
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, sQLiteDatabase, j)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = w57.c();
            }
            boolean z = false;
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = x57.d().e("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
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
                    ni.a(cursor);
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
            x57.d().update("tb_new_friends", contentValues, null, null);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:22:0x005b). Please submit an issue!!! */
    public int q(l57 l57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, l57Var)) == null) {
            SQLiteDatabase c = w57.c();
            int i = 0;
            if (c != null) {
                try {
                    if (o(c, l57Var.b())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(l57Var.f()));
                        contentValues.put("isread", Integer.valueOf(l57Var.c()));
                        i = x57.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(l57Var.b())});
                    } else {
                        k(c, l57Var);
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
