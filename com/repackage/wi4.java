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
public class wi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final wi4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(101837874, "Lcom/repackage/wi4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(101837874, "Lcom/repackage/wi4$a;");
                    return;
                }
            }
            a = new wi4();
        }
    }

    public wi4() {
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

    public static final wi4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (wi4) invokeV.objValue;
    }

    public synchronized long a(yi4 yi4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yi4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, yi4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<yi4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (yi4 yi4Var : list) {
                    h(f, yi4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yi4Var)) == null) {
            if (yi4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(yi4Var.d()));
            contentValues.put("missionid", Integer.valueOf(yi4Var.q()));
            contentValues.put("activitysource", yi4Var.e());
            contentValues.put("calltype", Integer.valueOf(yi4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(yi4Var.x()));
            contentValues.put("browsetimepage", yi4Var.g());
            contentValues.put("browsetime", Long.valueOf(yi4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(yi4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(yi4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(yi4Var.k()));
            contentValues.put("cleartime", Long.valueOf(yi4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(yi4Var.t()));
            contentValues.put("tid", Long.valueOf(yi4Var.C()));
            contentValues.put("fid", Long.valueOf(yi4Var.o()));
            contentValues.put("threadtext", yi4Var.B());
            contentValues.put("threadimg", yi4Var.z());
            contentValues.put("threadforum", Long.valueOf(yi4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(yi4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(yi4Var.w()));
            contentValues.put("token", yi4Var.E());
            contentValues.put("executingMissionList", yi4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final yi4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            yi4 yi4Var = new yi4();
            yi4Var.S(cursor.getInt(cursor.getColumnIndex("activityid")));
            yi4Var.b0(cursor.getInt(cursor.getColumnIndex("missionid")));
            yi4Var.T(cursor.getString(cursor.getColumnIndex("activitysource")));
            yi4Var.W(cursor.getInt(cursor.getColumnIndex("calltype")));
            yi4Var.f0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            yi4Var.V(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            yi4Var.U(cursor.getLong(cursor.getColumnIndex("browsetime")));
            yi4Var.i0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            yi4Var.a0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            yi4Var.Y(cursor.getInt(cursor.getColumnIndex("cleartype")));
            yi4Var.X(cursor.getLong(cursor.getColumnIndex("cleartime")));
            yi4Var.d0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            yi4Var.k0(cursor.getLong(cursor.getColumnIndex("tid")));
            yi4Var.Z(cursor.getLong(cursor.getColumnIndex("fid")));
            yi4Var.j0(cursor.getString(cursor.getColumnIndex("threadtext")));
            yi4Var.h0(cursor.getString(cursor.getColumnIndex("threadimg")));
            yi4Var.g0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            yi4Var.m0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            yi4Var.e0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            yi4Var.P(yi4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            yi4Var.l0(cursor.getString(cursor.getColumnIndex("token")));
            return yi4Var;
        }
        return (yi4) invokeL.objValue;
    }

    public synchronized boolean e(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yi4Var)) == null) {
            synchronized (this) {
                if (yi4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(yi4Var.d()), String.valueOf(yi4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<yi4> f() {
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
                    yi4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                ni.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, yi4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(yi4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, yi4Var)) == null) {
            synchronized (this) {
                if (yi4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, yi4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, yi4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(yi4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(yi4Var.d()), String.valueOf(yi4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<yi4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (yi4 yi4Var : list) {
                    j(f, yi4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
