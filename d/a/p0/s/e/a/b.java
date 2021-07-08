package d.a.p0.s.e.a;

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
import d.a.c.e.p.m;
import d.a.p0.i1.h.g;
import d.a.p0.i1.h.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f61966a;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized b f() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (b.class) {
                if (f61966a == null) {
                    f61966a = new b();
                }
                bVar = f61966a;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final int a(d.a.p0.i1.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, aVar)) != null) {
            return invokeL.intValue;
        }
        SQLiteDatabase c2 = g.c();
        int i2 = 0;
        if (c2 == null) {
            return 0;
        }
        try {
            if (o(c2, aVar.b())) {
                ContentValues contentValues = new ContentValues();
                long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(aVar.b());
                contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                int j = h.e().j("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(aVar.b())});
                try {
                    aVar.h(correctUserIdAfterOverflowCut);
                    return j;
                } catch (Exception e2) {
                    e = e2;
                    i2 = j;
                    e.printStackTrace();
                    return i2;
                }
            }
            return 0;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? c(g.c(), j) : invokeJ.booleanValue;
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, j)) == null) {
            try {
                return h.e().b("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
            } catch (Exception e2) {
                e2.printStackTrace();
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
                sQLiteDatabase = g.c();
            }
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = h.e().h("select * from tb_new_friends", new String[0]);
                            if (cursor != null && cursor.moveToNext()) {
                                return cursor.getLong(cursor.getColumnIndex("uid"));
                            }
                        } catch (SQLiteException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return 0L;
                } finally {
                    m.a(cursor);
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public synchronized d.a.p0.i1.g.a e(long j) {
        InterceptResult invokeJ;
        d.a.p0.i1.g.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                aVar = new d.a.p0.i1.g.a();
                Cursor cursor = null;
                try {
                    cursor = h.e().h("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null && cursor.moveToNext()) {
                        aVar.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        aVar.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        aVar.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        aVar.j(cursor.getString(cursor.getColumnIndex("uname")));
                        aVar.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                m.a(cursor);
            }
            return aVar;
        }
        return (d.a.p0.i1.g.a) invokeJ.objValue;
    }

    public List<d.a.p0.i1.g.a> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = h.e().h("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            d.a.p0.i1.g.a aVar = new d.a.p0.i1.g.a();
                            aVar.h(cursor.getLong(cursor.getColumnIndex("uid")));
                            aVar.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                            aVar.i(cursor.getInt(cursor.getColumnIndex("isread")));
                            aVar.j(cursor.getString(cursor.getColumnIndex("uname")));
                            aVar.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                            aVar.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(aVar);
                        }
                        p();
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return arrayList;
            } finally {
                m.a(cursor);
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
                    cursor = h.e().h("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
                    if (cursor != null && cursor.moveToNext()) {
                        return cursor.getInt(0);
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return 0;
            } finally {
                m.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public final int i(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sQLiteDatabase)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = g.c();
            }
            Cursor cursor = null;
            try {
                if (sQLiteDatabase == null) {
                    return 0;
                }
                try {
                    cursor = h.e().h("select * from tb_new_friends", new String[0]);
                    if (cursor != null && cursor.moveToFirst()) {
                        return cursor.getCount();
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return 0;
            } finally {
                m.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public List<d.a.p0.i1.g.a> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SQLiteDatabase c2 = g.c();
            ArrayList arrayList = new ArrayList();
            if (c2 != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = h.e().h("select * from tb_new_friends ORDER BY _id DESC", null);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    d.a.p0.i1.g.a aVar = new d.a.p0.i1.g.a();
                                    aVar.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                    if (aVar.b() < 0) {
                                        a(aVar);
                                    }
                                    aVar.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                    aVar.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                    aVar.j(cursor.getString(cursor.getColumnIndex("uname")));
                                    aVar.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                    aVar.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                    arrayList.add(aVar);
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } catch (SQLiteException e3) {
                        e3.printStackTrace();
                    }
                } finally {
                    m.a(cursor);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, d.a.p0.i1.g.a aVar) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, aVar) == null) || aVar == null || aVar.b() == 0 || TextUtils.isEmpty(aVar.d())) {
            return;
        }
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.c();
        }
        if (sQLiteDatabase != null) {
            c(sQLiteDatabase, aVar.b());
            if (i(sQLiteDatabase) >= 200) {
                b(d(sQLiteDatabase));
            }
            if (sQLiteDatabase != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("uid", Long.valueOf(aVar.b()));
                contentValues.put("uname", aVar.d());
                contentValues.put("uportrait", aVar.e());
                contentValues.put("ucontent", aVar.a());
                contentValues.put("ustatus", Integer.valueOf(aVar.f()));
                contentValues.put("isread", Integer.valueOf(aVar.c()));
                h.e().g("tb_new_friends", null, contentValues);
            }
        }
    }

    public void l(d.a.p0.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            try {
                k(g.c(), aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void m(List<d.a.p0.i1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            try {
                for (d.a.p0.i1.g.a aVar : list) {
                    k(g.c(), aVar);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) ? o(g.c(), j) : invokeJ.booleanValue;
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, sQLiteDatabase, j)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = g.c();
            }
            boolean z = false;
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = h.e().h("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                        if (cursor != null) {
                            if (cursor.moveToFirst()) {
                                z = true;
                            }
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } finally {
                    m.a(cursor);
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
            h.e().j("tb_new_friends", contentValues, null, null);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:22:0x005b). Please submit an issue!!! */
    public int q(d.a.p0.i1.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, aVar)) == null) {
            SQLiteDatabase c2 = g.c();
            int i2 = 0;
            if (c2 != null) {
                try {
                    if (o(c2, aVar.b())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(aVar.f()));
                        contentValues.put("isread", Integer.valueOf(aVar.c()));
                        i2 = h.e().j("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(aVar.b())});
                    } else {
                        k(c2, aVar);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }
}
