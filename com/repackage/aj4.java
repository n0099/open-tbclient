package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class aj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final aj4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-527079927, "Lcom/repackage/aj4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-527079927, "Lcom/repackage/aj4$a;");
                    return;
                }
            }
            a = new aj4();
        }
    }

    public aj4() {
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

    public static final aj4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (aj4) invokeV.objValue;
    }

    public synchronized long a(cj4 cj4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cj4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, cj4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<cj4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (cj4 cj4Var : list) {
                    h(f, cj4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(cj4 cj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cj4Var)) == null) {
            if (cj4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(cj4Var.d()));
            contentValues.put("missionid", Integer.valueOf(cj4Var.q()));
            contentValues.put("activitysource", cj4Var.e());
            contentValues.put("calltype", Integer.valueOf(cj4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(cj4Var.x()));
            contentValues.put("browsetimepage", cj4Var.g());
            contentValues.put("browsetime", Long.valueOf(cj4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(cj4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(cj4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(cj4Var.k()));
            contentValues.put("cleartime", Long.valueOf(cj4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(cj4Var.t()));
            contentValues.put("tid", Long.valueOf(cj4Var.C()));
            contentValues.put("fid", Long.valueOf(cj4Var.o()));
            contentValues.put("threadtext", cj4Var.B());
            contentValues.put("threadimg", cj4Var.z());
            contentValues.put("threadforum", Long.valueOf(cj4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(cj4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(cj4Var.w()));
            contentValues.put("token", cj4Var.E());
            contentValues.put("executingMissionList", cj4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final cj4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            cj4 cj4Var = new cj4();
            cj4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
            cj4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
            cj4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
            cj4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
            cj4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            cj4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            cj4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
            cj4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            cj4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            cj4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
            cj4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
            cj4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            cj4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
            cj4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
            cj4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
            cj4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
            cj4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            cj4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            cj4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            cj4Var.Q(cj4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            cj4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
            return cj4Var;
        }
        return (cj4) invokeL.objValue;
    }

    public synchronized boolean e(cj4 cj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cj4Var)) == null) {
            synchronized (this) {
                if (cj4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(cj4Var.d()), String.valueOf(cj4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<cj4> f() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                linkedList = new LinkedList();
                Cursor rawQuery = f.rawQuery("SELECT * FROM activity_mission_info", null);
                while (rawQuery.moveToNext()) {
                    cj4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                ri.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, cj4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(cj4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(cj4 cj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cj4Var)) == null) {
            synchronized (this) {
                if (cj4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, cj4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, cj4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(cj4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(cj4Var.d()), String.valueOf(cj4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<cj4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (cj4 cj4Var : list) {
                    j(f, cj4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
