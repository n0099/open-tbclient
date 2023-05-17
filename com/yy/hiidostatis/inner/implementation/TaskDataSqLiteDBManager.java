package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class TaskDataSqLiteDBManager extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public SQLiteDatabase db;

    private String allColumn() {
        return "_DATAID ,_ACT,_AID, _CONTENT , _TRYTIMES , _TIME, _ORDER , _VERIFYMD5 , _TYPE,_CREPID";
    }

    private String insertSql() {
        return "INSERT INTO TASK_DATA(_DATAID ,_ACT,_AID, _CONTENT , _TRYTIMES , _TIME, _ORDER , _VERIFYMD5 , _TYPE, _CREPID) VALUES(?,?,?,?,?,?,?,?,?,?)";
    }

    public TaskDataSqLiteDBManager(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        this.db = getWritableDatabase();
    }

    private Object[] allArgs(TaskData taskData) {
        return new Object[]{taskData.getDataId(), taskData.getAct(), Long.valueOf(taskData.getAid()), taskData.getContent(), Integer.valueOf(taskData.getTryTimes()), Long.valueOf(taskData.getTime()), Long.valueOf(taskData.getOrder()), taskData.getVerifyMd5(), null, Integer.valueOf(taskData.getCrepid())};
    }

    private TaskData transToTaskData(Cursor cursor) {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public TaskDataSet getFirstList(int i) {
        TaskDataSet taskDataSet;
        Throwable th;
        Cursor cursor;
        TaskDataSet taskDataSet2 = null;
        try {
            cursor = this.db.rawQuery(String.format(Locale.ENGLISH, "SELECT %s FROM TASK_DATA ORDER BY _ORDER LIMIT 0,%d", allColumn(), Integer.valueOf(i)), null);
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
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
        if (r1 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<TaskData> getVersion1(SQLiteDatabase sQLiteDatabase) {
        String[] split;
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConcurrentHashMap<String, AtomicInteger> countActRemain() {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TaskData getFirst() {
        Cursor cursor;
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
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TaskData getLast() {
        Cursor cursor;
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

    public TaskDataSet getAll() {
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

    public int size() {
        Cursor rawQuery = this.db.rawQuery("SELECT COUNT(*) FROM TASK_DATA", null);
        if (rawQuery == null) {
            return 0;
        }
        int i = 0;
        while (rawQuery.moveToNext()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public TaskDataSet getFirstList(int i, Collection<String> collection) {
        TaskDataSet taskDataSet;
        Throwable th;
        Cursor cursor;
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
                cursor = this.db.rawQuery(String.format(Locale.ENGLISH, "SELECT %s FROM TASK_DATA where _DATAID not in %s ORDER BY _ORDER LIMIT 0,%d", allColumn(), sb.toString(), Integer.valueOf(i)), null);
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
            return getFirstList(i);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TASK_DATA(_DATAID VARCHAR PRIMARY KEY, _ACT VARCHAR(100),_AID BIGINT, _CREPID INTEGER,_CONTENT TEXT, _TRYTIMES INTEGER,_TIME BIGINT, _ORDER BIGINT, _VERIFYMD5 VARCHAR,_TYPE VARCHAR)");
    }

    public int remove(TaskData taskData) {
        try {
            return this.db.delete("TASK_DATA", "_DATAID = ?", new String[]{taskData.getDataId()});
        } catch (Throwable unused) {
            return 0;
        }
    }

    public boolean save(TaskData taskData) {
        try {
            this.db.execSQL(insertSql(), allArgs(taskData));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            List<TaskData> version1 = getVersion1(sQLiteDatabase);
            sQLiteDatabase.execSQL("drop table TASK_DATA");
            onCreate(sQLiteDatabase);
            if (!version1.isEmpty()) {
                try {
                    this.db = sQLiteDatabase;
                    saveAll(version1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int remove(String str) {
        try {
            return this.db.delete("TASK_DATA", "_DATAID = ?", new String[]{str});
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void remove(List<String> list) {
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

    public void removeAll(TaskDataSet taskDataSet) {
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

    public void saveAll(Collection<TaskData> collection) {
        try {
            try {
                this.db.beginTransaction();
                for (TaskData taskData : collection) {
                    this.db.execSQL(insertSql(), allArgs(taskData));
                }
                this.db.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.db.endTransaction();
        }
    }

    public void update(TaskData taskData) {
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
