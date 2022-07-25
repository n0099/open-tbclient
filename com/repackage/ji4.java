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
public class ji4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final ji4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-270341089, "Lcom/repackage/ji4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-270341089, "Lcom/repackage/ji4$a;");
                    return;
                }
            }
            a = new ji4();
        }
    }

    public ji4() {
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

    public static final ji4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (ji4) invokeV.objValue;
    }

    public synchronized long a(li4 li4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, li4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, li4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<li4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (li4 li4Var : list) {
                    h(f, li4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(li4 li4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, li4Var)) == null) {
            if (li4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(li4Var.d()));
            contentValues.put("missionid", Integer.valueOf(li4Var.q()));
            contentValues.put("activitysource", li4Var.e());
            contentValues.put("calltype", Integer.valueOf(li4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(li4Var.x()));
            contentValues.put("browsetimepage", li4Var.g());
            contentValues.put("browsetime", Long.valueOf(li4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(li4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(li4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(li4Var.k()));
            contentValues.put("cleartime", Long.valueOf(li4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(li4Var.t()));
            contentValues.put("tid", Long.valueOf(li4Var.C()));
            contentValues.put("fid", Long.valueOf(li4Var.o()));
            contentValues.put("threadtext", li4Var.B());
            contentValues.put("threadimg", li4Var.z());
            contentValues.put("threadforum", Long.valueOf(li4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(li4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(li4Var.w()));
            contentValues.put("token", li4Var.E());
            contentValues.put("executingMissionList", li4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final li4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            li4 li4Var = new li4();
            li4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
            li4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
            li4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
            li4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
            li4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            li4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            li4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
            li4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            li4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            li4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
            li4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
            li4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            li4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
            li4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
            li4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
            li4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
            li4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            li4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            li4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            li4Var.Q(li4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            li4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
            return li4Var;
        }
        return (li4) invokeL.objValue;
    }

    public synchronized boolean e(li4 li4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, li4Var)) == null) {
            synchronized (this) {
                if (li4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(li4Var.d()), String.valueOf(li4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<li4> f() {
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
                    li4 d = d(rawQuery);
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

    public final long h(SQLiteDatabase sQLiteDatabase, li4 li4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, li4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(li4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(li4 li4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, li4Var)) == null) {
            synchronized (this) {
                if (li4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, li4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, li4 li4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, li4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(li4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(li4Var.d()), String.valueOf(li4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<li4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (li4 li4Var : list) {
                    j(f, li4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
