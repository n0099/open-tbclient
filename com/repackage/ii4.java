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
public class ii4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final ii4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-298970240, "Lcom/repackage/ii4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-298970240, "Lcom/repackage/ii4$a;");
                    return;
                }
            }
            a = new ii4();
        }
    }

    public ii4() {
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

    public static final ii4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (ii4) invokeV.objValue;
    }

    public synchronized long a(ki4 ki4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ki4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, ki4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<ki4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (ki4 ki4Var : list) {
                    h(f, ki4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(ki4 ki4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ki4Var)) == null) {
            if (ki4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(ki4Var.d()));
            contentValues.put("missionid", Integer.valueOf(ki4Var.q()));
            contentValues.put("activitysource", ki4Var.e());
            contentValues.put("calltype", Integer.valueOf(ki4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(ki4Var.x()));
            contentValues.put("browsetimepage", ki4Var.g());
            contentValues.put("browsetime", Long.valueOf(ki4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(ki4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(ki4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(ki4Var.k()));
            contentValues.put("cleartime", Long.valueOf(ki4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(ki4Var.t()));
            contentValues.put("tid", Long.valueOf(ki4Var.C()));
            contentValues.put("fid", Long.valueOf(ki4Var.o()));
            contentValues.put("threadtext", ki4Var.B());
            contentValues.put("threadimg", ki4Var.z());
            contentValues.put("threadforum", Long.valueOf(ki4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(ki4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(ki4Var.w()));
            contentValues.put("token", ki4Var.E());
            contentValues.put("executingMissionList", ki4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final ki4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            ki4 ki4Var = new ki4();
            ki4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
            ki4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
            ki4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
            ki4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
            ki4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            ki4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            ki4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
            ki4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            ki4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            ki4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
            ki4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
            ki4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            ki4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
            ki4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
            ki4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
            ki4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
            ki4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            ki4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            ki4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            ki4Var.Q(ki4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            ki4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
            return ki4Var;
        }
        return (ki4) invokeL.objValue;
    }

    public synchronized boolean e(ki4 ki4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ki4Var)) == null) {
            synchronized (this) {
                if (ki4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(ki4Var.d()), String.valueOf(ki4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<ki4> f() {
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
                    ki4 d = d(rawQuery);
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

    public final long h(SQLiteDatabase sQLiteDatabase, ki4 ki4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, ki4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(ki4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(ki4 ki4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ki4Var)) == null) {
            synchronized (this) {
                if (ki4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, ki4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, ki4 ki4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, ki4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(ki4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(ki4Var.d()), String.valueOf(ki4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<ki4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (ki4 ki4Var : list) {
                    j(f, ki4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
