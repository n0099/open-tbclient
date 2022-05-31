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
public class jh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final jh4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-271264610, "Lcom/repackage/jh4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-271264610, "Lcom/repackage/jh4$a;");
                    return;
                }
            }
            a = new jh4();
        }
    }

    public jh4() {
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

    public static final jh4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (jh4) invokeV.objValue;
    }

    public synchronized long a(lh4 lh4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lh4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, lh4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<lh4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (lh4 lh4Var : list) {
                    h(f, lh4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lh4Var)) == null) {
            if (lh4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(lh4Var.d()));
            contentValues.put("missionid", Integer.valueOf(lh4Var.q()));
            contentValues.put("activitysource", lh4Var.e());
            contentValues.put("calltype", Integer.valueOf(lh4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(lh4Var.x()));
            contentValues.put("browsetimepage", lh4Var.g());
            contentValues.put("browsetime", Long.valueOf(lh4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(lh4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(lh4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(lh4Var.k()));
            contentValues.put("cleartime", Long.valueOf(lh4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(lh4Var.t()));
            contentValues.put("tid", Long.valueOf(lh4Var.C()));
            contentValues.put("fid", Long.valueOf(lh4Var.o()));
            contentValues.put("threadtext", lh4Var.B());
            contentValues.put("threadimg", lh4Var.z());
            contentValues.put("threadforum", Long.valueOf(lh4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(lh4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(lh4Var.w()));
            contentValues.put("token", lh4Var.E());
            contentValues.put("executingMissionList", lh4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final lh4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            lh4 lh4Var = new lh4();
            lh4Var.S(cursor.getInt(cursor.getColumnIndex("activityid")));
            lh4Var.b0(cursor.getInt(cursor.getColumnIndex("missionid")));
            lh4Var.T(cursor.getString(cursor.getColumnIndex("activitysource")));
            lh4Var.W(cursor.getInt(cursor.getColumnIndex("calltype")));
            lh4Var.f0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            lh4Var.V(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            lh4Var.U(cursor.getLong(cursor.getColumnIndex("browsetime")));
            lh4Var.i0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            lh4Var.a0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            lh4Var.Y(cursor.getInt(cursor.getColumnIndex("cleartype")));
            lh4Var.X(cursor.getLong(cursor.getColumnIndex("cleartime")));
            lh4Var.d0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            lh4Var.k0(cursor.getLong(cursor.getColumnIndex("tid")));
            lh4Var.Z(cursor.getLong(cursor.getColumnIndex("fid")));
            lh4Var.j0(cursor.getString(cursor.getColumnIndex("threadtext")));
            lh4Var.h0(cursor.getString(cursor.getColumnIndex("threadimg")));
            lh4Var.g0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            lh4Var.m0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            lh4Var.e0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            lh4Var.P(lh4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            lh4Var.l0(cursor.getString(cursor.getColumnIndex("token")));
            return lh4Var;
        }
        return (lh4) invokeL.objValue;
    }

    public synchronized boolean e(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lh4Var)) == null) {
            synchronized (this) {
                if (lh4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(lh4Var.d()), String.valueOf(lh4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<lh4> f() {
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
                    lh4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                mi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, lh4 lh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, lh4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(lh4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lh4Var)) == null) {
            synchronized (this) {
                if (lh4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, lh4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, lh4 lh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, lh4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(lh4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(lh4Var.d()), String.valueOf(lh4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<lh4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (lh4 lh4Var : list) {
                    j(f, lh4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
