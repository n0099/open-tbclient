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
public class mi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final mi4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-184453636, "Lcom/repackage/mi4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-184453636, "Lcom/repackage/mi4$a;");
                    return;
                }
            }
            a = new mi4();
        }
    }

    public mi4() {
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

    public static final mi4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (mi4) invokeV.objValue;
    }

    public synchronized long a(oi4 oi4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oi4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, oi4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<oi4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (oi4 oi4Var : list) {
                    h(f, oi4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(oi4 oi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oi4Var)) == null) {
            if (oi4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(oi4Var.d()));
            contentValues.put("missionid", Integer.valueOf(oi4Var.q()));
            contentValues.put("activitysource", oi4Var.e());
            contentValues.put("calltype", Integer.valueOf(oi4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(oi4Var.x()));
            contentValues.put("browsetimepage", oi4Var.g());
            contentValues.put("browsetime", Long.valueOf(oi4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(oi4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(oi4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(oi4Var.k()));
            contentValues.put("cleartime", Long.valueOf(oi4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(oi4Var.t()));
            contentValues.put("tid", Long.valueOf(oi4Var.C()));
            contentValues.put("fid", Long.valueOf(oi4Var.o()));
            contentValues.put("threadtext", oi4Var.B());
            contentValues.put("threadimg", oi4Var.z());
            contentValues.put("threadforum", Long.valueOf(oi4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(oi4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(oi4Var.w()));
            contentValues.put("token", oi4Var.E());
            contentValues.put("executingMissionList", oi4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final oi4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            oi4 oi4Var = new oi4();
            oi4Var.S(cursor.getInt(cursor.getColumnIndex("activityid")));
            oi4Var.b0(cursor.getInt(cursor.getColumnIndex("missionid")));
            oi4Var.T(cursor.getString(cursor.getColumnIndex("activitysource")));
            oi4Var.W(cursor.getInt(cursor.getColumnIndex("calltype")));
            oi4Var.f0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            oi4Var.V(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            oi4Var.U(cursor.getLong(cursor.getColumnIndex("browsetime")));
            oi4Var.i0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            oi4Var.a0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            oi4Var.Y(cursor.getInt(cursor.getColumnIndex("cleartype")));
            oi4Var.X(cursor.getLong(cursor.getColumnIndex("cleartime")));
            oi4Var.d0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            oi4Var.k0(cursor.getLong(cursor.getColumnIndex("tid")));
            oi4Var.Z(cursor.getLong(cursor.getColumnIndex("fid")));
            oi4Var.j0(cursor.getString(cursor.getColumnIndex("threadtext")));
            oi4Var.h0(cursor.getString(cursor.getColumnIndex("threadimg")));
            oi4Var.g0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            oi4Var.m0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            oi4Var.e0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            oi4Var.P(oi4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            oi4Var.l0(cursor.getString(cursor.getColumnIndex("token")));
            return oi4Var;
        }
        return (oi4) invokeL.objValue;
    }

    public synchronized boolean e(oi4 oi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, oi4Var)) == null) {
            synchronized (this) {
                if (oi4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(oi4Var.d()), String.valueOf(oi4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<oi4> f() {
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
                    oi4 d = d(rawQuery);
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

    public final long h(SQLiteDatabase sQLiteDatabase, oi4 oi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, oi4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(oi4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(oi4 oi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, oi4Var)) == null) {
            synchronized (this) {
                if (oi4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, oi4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, oi4 oi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, oi4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(oi4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(oi4Var.d()), String.valueOf(oi4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<oi4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (oi4 oi4Var : list) {
                    j(f, oi4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
