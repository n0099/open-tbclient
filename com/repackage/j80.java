package com.repackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes6.dex */
public class j80 extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j80 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ReentrantReadWriteLock a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j80(Context context) {
        super(context, "blcp_track.db", (SQLiteDatabase.CursorFactory) null, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ReentrantReadWriteLock(true);
    }

    public static void d(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, cursor) == null) || cursor == null) {
            return;
        }
        try {
            if (cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static j80 j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (j80.class) {
                    if (b == null) {
                        b = new j80(context);
                    }
                }
            }
            return b;
        }
        return (j80) invokeL.objValue;
    }

    public final boolean a(int i, int i2, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, sQLiteDatabase)) == null) {
            this.a.writeLock().lock();
            Cursor cursor = null;
            boolean z = false;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT flowid FROM flow WHERE flowid = " + i + " AND flowhandle = " + i2, null);
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            z = true;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                d(cursor);
                this.a.writeLock().unlock();
                y80.a("TrackDBHelper", "flow checkFlowExist:" + z);
                return z;
            } catch (Throwable th) {
                d(cursor);
                this.a.writeLock().unlock();
                throw th;
            }
        }
        return invokeIIL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0073, code lost:
        if (r1 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0075, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
        r8.a.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x006a, code lost:
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        this.a.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.beginTransactionNonExclusive();
                int delete = sQLiteDatabase.delete("flow", "begintime < ? AND ? != ?", new String[]{String.valueOf(System.currentTimeMillis() - 604800000), "state", String.valueOf(1)});
                y80.a("TrackDBHelper", "clear expired flow cout:" + delete);
                if (delete > 0) {
                    y80.a("TrackDBHelper", "删除过期数据count:" + delete);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.a.writeLock().unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009d, code lost:
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a6, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a8, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ab, code lost:
        r5.a.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, list) == null) || TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        this.a.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.beginTransactionNonExclusive();
                int size = list.size();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < size; i++) {
                    arrayList.add("?");
                }
                int delete = sQLiteDatabase.delete("flow", "flowid = " + str + " AND flowhandle IN (" + TextUtils.join(",", arrayList) + SmallTailInfo.EMOTION_SUFFIX, (String[]) list.toArray(new String[list.size()]));
                sQLiteDatabase.setTransactionSuccessful();
                if (delete > 0) {
                    y80.a("TrackDBHelper", "flow 删除：" + list.toString() + " success");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.a.writeLock().unlock();
            throw th;
        }
    }

    public void f(s70 s70Var) {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s70Var) == null) {
            if (s70Var == null) {
                y80.a("TrackDBHelper", "flowData is null");
                return;
            }
            this.a.writeLock().lock();
            y80.a("TrackDBHelper", "flow insert to db:" + s70Var.g());
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (SQLException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                writableDatabase.beginTransactionNonExclusive();
                if (a(s70Var.a, s70Var.b, writableDatabase)) {
                    ContentValues h = h(s70Var);
                    String str = "flowid = " + s70Var.a + " AND flowhandle = " + s70Var.b;
                    y80.a("TrackDBHelper", "flow update where:" + str);
                    y80.a("TrackDBHelper", "endFlow update count:" + writableDatabase.update("flow", h, str, null));
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                e = e2;
                sQLiteDatabase = writableDatabase;
                e.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
                throw th;
            }
            this.a.writeLock().unlock();
        }
    }

    public List<x70> g(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList2;
            }
            String str2 = "SELECT * FROM flow WHERE flowid=\"" + str + "\" AND state = 1  limit " + i;
            y80.a("TrackDBHelper", "flow getAllData querySql:" + str2);
            this.a.readLock().lock();
            Cursor cursor = null;
            try {
                try {
                    cursor = getReadableDatabase().rawQuery(str2, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("flowhandle");
                    int columnIndex2 = cursor.getColumnIndex("detail");
                    do {
                        arrayList2.add(new x70(str, cursor.getString(columnIndex), cursor.getString(columnIndex2)));
                        arrayList.add(cursor.getString(columnIndex2));
                    } while (cursor.moveToNext());
                    y80.a("TrackDBHelper", "flow flowID:" + str + ", get data from db count:" + arrayList.size() + ",flow detail:" + arrayList.toString());
                    d(cursor);
                    this.a.readLock().unlock();
                    y80.a("TrackDBHelper", "flow uploadData SIZE:" + arrayList2.size());
                    return arrayList2;
                }
                y80.a("TrackDBHelper", "flow flowID:" + str + ", get data from db count:" + arrayList.size() + ",flow detail:" + arrayList.toString());
                d(cursor);
                this.a.readLock().unlock();
                y80.a("TrackDBHelper", "flow uploadData SIZE:" + arrayList2.size());
                return arrayList2;
            } catch (Throwable th) {
                d(cursor);
                this.a.readLock().unlock();
                throw th;
            }
        }
        return (List) invokeLI.objValue;
    }

    public final ContentValues h(s70 s70Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, s70Var)) == null) {
            ContentValues contentValues = new ContentValues();
            if (s70Var != null) {
                contentValues.put("flowid", Integer.valueOf(s70Var.a));
                contentValues.put("flowhandle", Integer.valueOf(s70Var.b));
                contentValues.put("begintime", Long.valueOf(s70Var.c));
                contentValues.put("endtime", Long.valueOf(s70Var.d));
                contentValues.put("detail", s70Var.f());
                if (s70Var.d == 0) {
                    contentValues.put("state", (Integer) 0);
                } else {
                    contentValues.put("state", (Integer) 1);
                }
                contentValues.put("ext", "");
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            String str2 = "SELECT COUNT(*) FROM flow WHERE flowid=\"" + str + "\" AND state = 1 ";
            this.a.readLock().lock();
            Cursor cursor = null;
            int i = 0;
            try {
                try {
                    cursor = getReadableDatabase().rawQuery(str2, null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        i = cursor.getInt(0);
                    }
                    y80.a("TrackDBHelper", "flow getEndedFlowCount:" + i);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return i;
            } finally {
                d(cursor);
                this.a.readLock().unlock();
            }
        }
        return invokeL.intValue;
    }

    public void k(s70 s70Var) {
        ContentValues h;
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, s70Var) == null) {
            if (s70Var == null) {
                y80.a("TrackDBHelper", "flow must not be null");
                return;
            }
            this.a.writeLock().lock();
            SQLiteDatabase sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            SQLiteDatabase sQLiteDatabase3 = null;
            try {
                try {
                    h = h(s70Var);
                    writableDatabase = getWritableDatabase();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                writableDatabase.beginTransactionNonExclusive();
                if (!a(s70Var.a, s70Var.b, writableDatabase)) {
                    long insert = writableDatabase.insert("flow", null, h);
                    y80.a("TrackDBHelper", "flow saveFlow,rowId:" + insert);
                    sQLiteDatabase2 = insert;
                }
                writableDatabase.setTransactionSuccessful();
                sQLiteDatabase = sQLiteDatabase2;
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    sQLiteDatabase = sQLiteDatabase2;
                }
            } catch (Exception e2) {
                e = e2;
                sQLiteDatabase3 = writableDatabase;
                e.printStackTrace();
                sQLiteDatabase = sQLiteDatabase3;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.endTransaction();
                    sQLiteDatabase = sQLiteDatabase3;
                }
                this.a.writeLock().unlock();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
                throw th;
            }
            this.a.writeLock().unlock();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle TEXT,begintime LONG,endtime LONG,detail TEXT,state INTEGER,ext TEXT );");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, sQLiteDatabase, i, i2) == null) {
            try {
                sQLiteDatabase.beginTransaction();
                while (i < i2) {
                    i++;
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
        }
    }
}
