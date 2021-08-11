package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class TaskDataSqLiteDBManager extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DATABASE_VERSION = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase db;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskDataSqLiteDBManager(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.db = getWritableDatabase();
    }

    private Object[] allArgs(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, taskData)) == null) ? new Object[]{taskData.getDataId(), taskData.getAct(), Long.valueOf(taskData.getAid()), taskData.getContent(), Integer.valueOf(taskData.getTryTimes()), Long.valueOf(taskData.getTime()), Long.valueOf(taskData.getOrder()), taskData.getVerifyMd5(), null, Integer.valueOf(taskData.getCrepid())} : (Object[]) invokeL.objValue;
    }

    private String allColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? "_DATAID ,_ACT,_AID, _CONTENT , _TRYTIMES , _TIME, _ORDER , _VERIFYMD5 , _TYPE,_CREPID" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<TaskData> getVersion1(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, sQLiteDatabase)) != null) {
            return (List) invokeL.objValue;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT _DATAID ,_CONTENT , _TRYTIMES , _TIME, _ORDER , _VERIFYMD5 , _TYPE FROM TASK_DATA", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    cursor.getString(0);
                    String string = cursor.getString(1);
                    String str = "";
                    String str2 = "";
                    for (String str3 : string.split("&")) {
                        if (str3.startsWith("act=")) {
                            str = str3.substring(4);
                        } else if (str3.startsWith("guid=")) {
                            str2 = str3.substring(5);
                        }
                    }
                    TaskData taskData = new TaskData(str);
                    taskData.setDataId(str2);
                    taskData.setContent(string);
                    taskData.setTryTimes(cursor.getInt(2));
                    taskData.setTime(cursor.getLong(3));
                    taskData.setOrder(cursor.getLong(4));
                    taskData.setVerifyMd5(cursor.getString(5));
                    taskData.setAid(0L);
                    taskData.setCrepid(0);
                    arrayList.add(taskData);
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private String insertSql() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? "INSERT INTO TASK_DATA(_DATAID ,_ACT,_AID, _CONTENT , _TRYTIMES , _TIME, _ORDER , _VERIFYMD5 , _TYPE, _CREPID) VALUES(?,?,?,?,?,?,?,?,?,?)" : (String) invokeV.objValue;
    }

    private TaskData transToTaskData(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, cursor)) == null) {
            TaskData taskData = new TaskData(cursor.getString(1));
            taskData.setDataId(cursor.getString(0));
            taskData.setAid(cursor.getLong(2));
            taskData.setContent(cursor.getString(3));
            taskData.setTryTimes(cursor.getInt(4));
            taskData.setTime(cursor.getLong(5));
            taskData.setOrder(cursor.getLong(6));
            taskData.setVerifyMd5(cursor.getString(7));
            taskData.setCrepid(cursor.getInt(8));
            return taskData;
        }
        return (TaskData) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConcurrentHashMap<String, AtomicInteger> countActRemain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (ConcurrentHashMap) invokeV.objValue;
        }
        ConcurrentHashMap<String, AtomicInteger> concurrentHashMap = new ConcurrentHashMap<>();
        Cursor cursor = null;
        try {
            cursor = this.db.rawQuery("select _ACT,COUNT(_ACT) from TASK_DATA group by _ACT", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    concurrentHashMap.put(cursor.getString(0), new AtomicInteger(cursor.getInt(1)));
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public TaskDataSet getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TaskDataSet taskDataSet = null;
            Cursor rawQuery = this.db.rawQuery(String.format(Locale.ENGLISH, "SELECT %s FROM TASK_DATA ORDER BY _ORDER", allColumn()), null);
            if (rawQuery != null) {
                taskDataSet = new TaskDataSet();
                while (rawQuery.moveToNext()) {
                    taskDataSet.save(transToTaskData(rawQuery));
                }
                rawQuery.close();
            }
            return taskDataSet;
        }
        return (TaskDataSet) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (r0 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TaskData getFirst() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return (TaskData) invokeV.objValue;
        }
        TaskData taskData = null;
        try {
            cursor = this.db.rawQuery(String.format("SELECT %s FROM TASK_DATA ORDER BY _ORDER LIMIT 0,1", allColumn()), null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        taskData = transToTaskData(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public TaskDataSet getFirstList(int i2) {
        InterceptResult invokeI;
        TaskDataSet taskDataSet;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048579, this, i2)) != null) {
            return (TaskDataSet) invokeI.objValue;
        }
        TaskDataSet taskDataSet2 = null;
        try {
            cursor = this.db.rawQuery(String.format(Locale.ENGLISH, "SELECT %s FROM TASK_DATA ORDER BY _ORDER LIMIT 0,%d", allColumn(), Integer.valueOf(i2)), null);
            if (cursor != null) {
                try {
                    taskDataSet = new TaskDataSet();
                    while (cursor.moveToNext()) {
                        try {
                            taskDataSet.save(transToTaskData(cursor));
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                return taskDataSet;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                    taskDataSet2 = taskDataSet;
                } catch (Throwable th3) {
                    taskDataSet = null;
                    th = th3;
                }
            }
            if (cursor != null) {
                cursor.close();
                return taskDataSet2;
            }
            return taskDataSet2;
        } catch (Throwable th4) {
            taskDataSet = null;
            th = th4;
            cursor = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (r0 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TaskData getLast() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
            return (TaskData) invokeV.objValue;
        }
        TaskData taskData = null;
        try {
            cursor = this.db.rawQuery(String.format("SELECT %s FROM TASK_DATA ORDER BY _ORDER DESC LIMIT 0,1", allColumn()), null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        taskData = transToTaskData(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TASK_DATA(_DATAID VARCHAR PRIMARY KEY, _ACT VARCHAR(100),_AID BIGINT, _CREPID INTEGER,_CONTENT TEXT, _TRYTIMES INTEGER,_TIME BIGINT, _ORDER BIGINT, _VERIFYMD5 VARCHAR,_TYPE VARCHAR)");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, sQLiteDatabase, i2, i3) == null) && i2 == 1) {
            List<TaskData> version1 = getVersion1(sQLiteDatabase);
            sQLiteDatabase.execSQL("drop table TASK_DATA");
            onCreate(sQLiteDatabase);
            if (version1.isEmpty()) {
                return;
            }
            try {
                this.db = sQLiteDatabase;
                saveAll(version1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public int remove(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, taskData)) == null) {
            try {
                return this.db.delete("TASK_DATA", "_DATAID = ?", new String[]{taskData.getDataId()});
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public void removeAll(TaskDataSet taskDataSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, taskDataSet) == null) {
            this.db.beginTransaction();
            try {
                Iterator<TaskData> it = taskDataSet.iterator();
                while (it.hasNext()) {
                    this.db.execSQL("DELETE FROM TASK_DATA WHERE _DATAID = ?", new Object[]{it.next().getDataId()});
                }
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
    }

    public boolean save(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, taskData)) == null) {
            try {
                this.db.execSQL(insertSql(), allArgs(taskData));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void saveAll(Collection<TaskData> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, collection) == null) {
            try {
                try {
                    this.db.beginTransaction();
                    for (TaskData taskData : collection) {
                        this.db.execSQL(insertSql(), allArgs(taskData));
                    }
                    this.db.setTransactionSuccessful();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.db.endTransaction();
            }
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Cursor rawQuery = this.db.rawQuery("SELECT COUNT(*) FROM TASK_DATA", null);
            if (rawQuery != null) {
                int i2 = 0;
                while (rawQuery.moveToNext()) {
                    i2 = rawQuery.getInt(0);
                }
                rawQuery.close();
                return i2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void update(TaskData taskData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, taskData) == null) {
            this.db.beginTransaction();
            try {
                this.db.execSQL("DELETE FROM TASK_DATA WHERE _DATAID = ?", new Object[]{taskData.getDataId()});
                this.db.execSQL(insertSql(), allArgs(taskData));
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
    }

    public int remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
                return this.db.delete("TASK_DATA", "_DATAID = ?", new String[]{str});
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, INVOKE, MOVE_EXCEPTION] complete} */
    public void remove(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            try {
                this.db.beginTransaction();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    this.db.delete("TASK_DATA", "_DATAID = ?", new String[]{it.next()});
                }
                this.db.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public TaskDataSet getFirstList(int i2, Collection<String> collection) {
        InterceptResult invokeIL;
        TaskDataSet taskDataSet;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(1048580, this, i2, collection)) != null) {
            return (TaskDataSet) invokeIL.objValue;
        }
        if (collection != null && !collection.isEmpty()) {
            StringBuilder sb = new StringBuilder(500);
            sb.append("(");
            for (String str : collection) {
                sb.append("'");
                sb.append(str);
                sb.append("'");
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            TaskDataSet taskDataSet2 = null;
            try {
                cursor = this.db.rawQuery(String.format(Locale.ENGLISH, "SELECT %s FROM TASK_DATA where _DATAID not in %s ORDER BY _ORDER LIMIT 0,%d", allColumn(), sb.toString(), Integer.valueOf(i2)), null);
                if (cursor != null) {
                    try {
                        taskDataSet = new TaskDataSet();
                        while (cursor.moveToNext()) {
                            try {
                                taskDataSet.save(transToTaskData(cursor));
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    th.printStackTrace();
                                    return taskDataSet;
                                } finally {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                            }
                        }
                        taskDataSet2 = taskDataSet;
                    } catch (Throwable th3) {
                        taskDataSet = null;
                        th = th3;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return taskDataSet2;
                }
                return taskDataSet2;
            } catch (Throwable th4) {
                taskDataSet = null;
                th = th4;
                cursor = null;
            }
        } else {
            return getFirstList(i2);
        }
    }
}
