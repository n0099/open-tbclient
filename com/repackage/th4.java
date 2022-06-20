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
/* loaded from: classes7.dex */
public class th4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final th4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(15026900, "Lcom/repackage/th4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(15026900, "Lcom/repackage/th4$a;");
                    return;
                }
            }
            a = new th4();
        }
    }

    public th4() {
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

    public static final th4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (th4) invokeV.objValue;
    }

    public synchronized long a(vh4 vh4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vh4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, vh4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<vh4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (vh4 vh4Var : list) {
                    h(f, vh4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(vh4 vh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vh4Var)) == null) {
            if (vh4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(vh4Var.d()));
            contentValues.put("missionid", Integer.valueOf(vh4Var.q()));
            contentValues.put("activitysource", vh4Var.e());
            contentValues.put("calltype", Integer.valueOf(vh4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(vh4Var.x()));
            contentValues.put("browsetimepage", vh4Var.g());
            contentValues.put("browsetime", Long.valueOf(vh4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(vh4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(vh4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(vh4Var.k()));
            contentValues.put("cleartime", Long.valueOf(vh4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(vh4Var.t()));
            contentValues.put("tid", Long.valueOf(vh4Var.C()));
            contentValues.put("fid", Long.valueOf(vh4Var.o()));
            contentValues.put("threadtext", vh4Var.B());
            contentValues.put("threadimg", vh4Var.z());
            contentValues.put("threadforum", Long.valueOf(vh4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(vh4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(vh4Var.w()));
            contentValues.put("token", vh4Var.E());
            contentValues.put("executingMissionList", vh4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final vh4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            vh4 vh4Var = new vh4();
            vh4Var.S(cursor.getInt(cursor.getColumnIndex("activityid")));
            vh4Var.b0(cursor.getInt(cursor.getColumnIndex("missionid")));
            vh4Var.T(cursor.getString(cursor.getColumnIndex("activitysource")));
            vh4Var.W(cursor.getInt(cursor.getColumnIndex("calltype")));
            vh4Var.f0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            vh4Var.V(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            vh4Var.U(cursor.getLong(cursor.getColumnIndex("browsetime")));
            vh4Var.i0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            vh4Var.a0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            vh4Var.Y(cursor.getInt(cursor.getColumnIndex("cleartype")));
            vh4Var.X(cursor.getLong(cursor.getColumnIndex("cleartime")));
            vh4Var.d0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            vh4Var.k0(cursor.getLong(cursor.getColumnIndex("tid")));
            vh4Var.Z(cursor.getLong(cursor.getColumnIndex("fid")));
            vh4Var.j0(cursor.getString(cursor.getColumnIndex("threadtext")));
            vh4Var.h0(cursor.getString(cursor.getColumnIndex("threadimg")));
            vh4Var.g0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            vh4Var.m0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            vh4Var.e0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            vh4Var.P(vh4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            vh4Var.l0(cursor.getString(cursor.getColumnIndex("token")));
            return vh4Var;
        }
        return (vh4) invokeL.objValue;
    }

    public synchronized boolean e(vh4 vh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vh4Var)) == null) {
            synchronized (this) {
                if (vh4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(vh4Var.d()), String.valueOf(vh4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<vh4> f() {
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
                    vh4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                qi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, vh4 vh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, vh4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(vh4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(vh4 vh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, vh4Var)) == null) {
            synchronized (this) {
                if (vh4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, vh4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, vh4 vh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, vh4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(vh4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(vh4Var.d()), String.valueOf(vh4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<vh4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (vh4 vh4Var : list) {
                    j(f, vh4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
