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
/* loaded from: classes6.dex */
public class li4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final li4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-213082787, "Lcom/repackage/li4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-213082787, "Lcom/repackage/li4$a;");
                    return;
                }
            }
            a = new li4();
        }
    }

    public li4() {
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

    public static final li4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (li4) invokeV.objValue;
    }

    public synchronized long a(ni4 ni4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ni4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, ni4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<ni4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (ni4 ni4Var : list) {
                    h(f, ni4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(ni4 ni4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ni4Var)) == null) {
            if (ni4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(ni4Var.d()));
            contentValues.put("missionid", Integer.valueOf(ni4Var.q()));
            contentValues.put("activitysource", ni4Var.e());
            contentValues.put("calltype", Integer.valueOf(ni4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(ni4Var.x()));
            contentValues.put("browsetimepage", ni4Var.g());
            contentValues.put("browsetime", Long.valueOf(ni4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(ni4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(ni4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(ni4Var.k()));
            contentValues.put("cleartime", Long.valueOf(ni4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(ni4Var.t()));
            contentValues.put("tid", Long.valueOf(ni4Var.C()));
            contentValues.put("fid", Long.valueOf(ni4Var.o()));
            contentValues.put("threadtext", ni4Var.B());
            contentValues.put("threadimg", ni4Var.z());
            contentValues.put("threadforum", Long.valueOf(ni4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(ni4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(ni4Var.w()));
            contentValues.put("token", ni4Var.E());
            contentValues.put("executingMissionList", ni4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final ni4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            ni4 ni4Var = new ni4();
            ni4Var.S(cursor.getInt(cursor.getColumnIndex("activityid")));
            ni4Var.b0(cursor.getInt(cursor.getColumnIndex("missionid")));
            ni4Var.T(cursor.getString(cursor.getColumnIndex("activitysource")));
            ni4Var.W(cursor.getInt(cursor.getColumnIndex("calltype")));
            ni4Var.f0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            ni4Var.V(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            ni4Var.U(cursor.getLong(cursor.getColumnIndex("browsetime")));
            ni4Var.i0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            ni4Var.a0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            ni4Var.Y(cursor.getInt(cursor.getColumnIndex("cleartype")));
            ni4Var.X(cursor.getLong(cursor.getColumnIndex("cleartime")));
            ni4Var.d0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            ni4Var.k0(cursor.getLong(cursor.getColumnIndex("tid")));
            ni4Var.Z(cursor.getLong(cursor.getColumnIndex("fid")));
            ni4Var.j0(cursor.getString(cursor.getColumnIndex("threadtext")));
            ni4Var.h0(cursor.getString(cursor.getColumnIndex("threadimg")));
            ni4Var.g0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            ni4Var.m0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            ni4Var.e0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            ni4Var.P(ni4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            ni4Var.l0(cursor.getString(cursor.getColumnIndex("token")));
            return ni4Var;
        }
        return (ni4) invokeL.objValue;
    }

    public synchronized boolean e(ni4 ni4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ni4Var)) == null) {
            synchronized (this) {
                if (ni4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(ni4Var.d()), String.valueOf(ni4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<ni4> f() {
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
                    ni4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                pi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, ni4 ni4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, ni4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(ni4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(ni4 ni4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ni4Var)) == null) {
            synchronized (this) {
                if (ni4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, ni4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, ni4 ni4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, ni4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(ni4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(ni4Var.d()), String.valueOf(ni4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<ni4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (ni4 ni4Var : list) {
                    j(f, ni4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
