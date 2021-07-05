package d.a.r0.a;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.r0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1214a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f54527a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-972616937, "Ld/a/r0/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-972616937, "Ld/a/r0/a/a$a;");
                    return;
                }
            }
            f54527a = new a();
        }
    }

    public a() {
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

    public static final a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C1214a.f54527a : (a) invokeV.objValue;
    }

    public synchronized long a(c cVar) {
        InterceptResult invokeL;
        long h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                h2 = h(f2, cVar);
                f2.setTransactionSuccessful();
                f2.endTransaction();
            }
            return h2;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                for (c cVar : list) {
                    h(f2, cVar);
                }
                f2.setTransactionSuccessful();
                f2.endTransaction();
            }
        }
    }

    public final ContentValues c(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(cVar.d()));
            contentValues.put("missionid", Integer.valueOf(cVar.q()));
            contentValues.put("activitysource", cVar.e());
            contentValues.put("calltype", Integer.valueOf(cVar.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(cVar.x()));
            contentValues.put("browsetimepage", cVar.g());
            contentValues.put("browsetime", Long.valueOf(cVar.f()));
            contentValues.put("threadnum", Integer.valueOf(cVar.A()));
            contentValues.put("forumnum", Integer.valueOf(cVar.p()));
            contentValues.put("cleartype", Integer.valueOf(cVar.k()));
            contentValues.put("cleartime", Long.valueOf(cVar.j()));
            contentValues.put("specificcleartime", Long.valueOf(cVar.t()));
            contentValues.put("tid", Long.valueOf(cVar.C()));
            contentValues.put("fid", Long.valueOf(cVar.o()));
            contentValues.put("threadtext", cVar.B());
            contentValues.put("threadimg", cVar.z());
            contentValues.put("threadforum", Long.valueOf(cVar.y()));
            contentValues.put("totalLimit", Integer.valueOf(cVar.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(cVar.w()));
            contentValues.put("token", cVar.E());
            contentValues.put("executingMissionList", cVar.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final c d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            c cVar = new c();
            cVar.S(cursor.getInt(cursor.getColumnIndex("activityid")));
            cVar.b0(cursor.getInt(cursor.getColumnIndex("missionid")));
            cVar.T(cursor.getString(cursor.getColumnIndex("activitysource")));
            cVar.W(cursor.getInt(cursor.getColumnIndex("calltype")));
            cVar.f0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            cVar.V(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            cVar.U(cursor.getLong(cursor.getColumnIndex("browsetime")));
            cVar.i0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            cVar.a0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            cVar.Y(cursor.getInt(cursor.getColumnIndex("cleartype")));
            cVar.X(cursor.getLong(cursor.getColumnIndex("cleartime")));
            cVar.d0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            cVar.k0(cursor.getLong(cursor.getColumnIndex("tid")));
            cVar.Z(cursor.getLong(cursor.getColumnIndex("fid")));
            cVar.j0(cursor.getString(cursor.getColumnIndex("threadtext")));
            cVar.h0(cursor.getString(cursor.getColumnIndex("threadimg")));
            cVar.g0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            cVar.m0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            cVar.e0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            cVar.P(cVar.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            cVar.l0(cursor.getString(cursor.getColumnIndex("token")));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public synchronized boolean e(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return false;
                }
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                int delete = f2.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(cVar.d()), String.valueOf(cVar.q())});
                f2.setTransactionSuccessful();
                f2.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<c> f() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                linkedList = new LinkedList();
                Cursor rawQuery = f2.rawQuery("SELECT * FROM activity_mission_info", null);
                while (rawQuery.moveToNext()) {
                    c d2 = d(rawQuery);
                    if (d2 != null) {
                        linkedList.add(d2);
                    }
                }
                f2.setTransactionSuccessful();
                d.a.c.e.p.m.a(rawQuery);
                f2.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, cVar)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(cVar));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return -1L;
                }
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                long j = j(f2, cVar);
                f2.setTransactionSuccessful();
                f2.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, cVar)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(cVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(cVar.d()), String.valueOf(cVar.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f2.beginTransaction();
                for (c cVar : list) {
                    j(f2, cVar);
                }
                f2.setTransactionSuccessful();
                f2.endTransaction();
            }
        }
    }
}
