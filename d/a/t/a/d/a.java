package d.a.t.a.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.t.a.a.c;
import d.a.t.a.a.h;
import d.a.t.a.h.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f68338b;

    /* renamed from: a  reason: collision with root package name */
    public ReentrantReadWriteLock f68339a;

    public a(Context context) {
        super(context, "blcp_track.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f68339a = new ReentrantReadWriteLock(true);
    }

    public static void c(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static a i(Context context) {
        if (f68338b == null) {
            synchronized (a.class) {
                if (f68338b == null) {
                    f68338b = new a(context);
                }
            }
        }
        return f68338b;
    }

    public final boolean a(int i2, int i3, SQLiteDatabase sQLiteDatabase) {
        this.f68339a.writeLock().lock();
        Cursor cursor = null;
        boolean z = false;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT flowid FROM flow WHERE flowid = " + i2 + " AND flowhandle = " + i3, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = true;
                    }
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            c(cursor);
            this.f68339a.writeLock().unlock();
            e.a("TrackDBHelper", "flow checkFlowExist:" + z);
            return z;
        } catch (Throwable th) {
            c(cursor);
            this.f68339a.writeLock().unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
        if (r1 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0073, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0076, code lost:
        r8.f68339a.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0068, code lost:
        if (r1 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        this.f68339a.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.beginTransactionNonExclusive();
                int delete = sQLiteDatabase.delete("flow", "begintime < ? AND ? != ?", new String[]{String.valueOf(System.currentTimeMillis() - 604800000), "state", String.valueOf(1)});
                e.a("TrackDBHelper", "clear expired flow cout:" + delete);
                if (delete > 0) {
                    e.a("TrackDBHelper", "删除过期数据count:" + delete);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.f68339a.writeLock().unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0099, code lost:
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a2, code lost:
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a4, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
        r5.f68339a.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b0, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        this.f68339a.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.beginTransactionNonExclusive();
                int size = list.size();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add("?");
                }
                int delete = sQLiteDatabase.delete("flow", "flowid = " + str + " AND flowhandle IN (" + TextUtils.join(",", arrayList) + SmallTailInfo.EMOTION_SUFFIX, (String[]) list.toArray(new String[list.size()]));
                sQLiteDatabase.setTransactionSuccessful();
                if (delete > 0) {
                    e.a("TrackDBHelper", "flow 删除：" + list.toString() + " success");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.f68339a.writeLock().unlock();
            throw th;
        }
    }

    public void e(c cVar) {
        SQLiteDatabase writableDatabase;
        if (cVar == null) {
            e.a("TrackDBHelper", "flowData is null");
            return;
        }
        this.f68339a.writeLock().lock();
        e.a("TrackDBHelper", "flow insert to db:" + cVar.g());
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
            } catch (SQLException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransactionNonExclusive();
            if (a(cVar.f68226a, cVar.f68227b, writableDatabase)) {
                ContentValues g2 = g(cVar);
                String str = "flowid = " + cVar.f68226a + " AND flowhandle = " + cVar.f68227b;
                e.a("TrackDBHelper", "flow update where:" + str);
                e.a("TrackDBHelper", "endFlow update count:" + writableDatabase.update("flow", g2, str, null));
            }
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e3) {
            e = e3;
            sQLiteDatabase = writableDatabase;
            e.printStackTrace();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.f68339a.writeLock().unlock();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.f68339a.writeLock().unlock();
            throw th;
        }
        this.f68339a.writeLock().unlock();
    }

    public List<h> f(String str, int i2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList2;
        }
        String str2 = "SELECT * FROM flow WHERE flowid=\"" + str + "\" AND state = 1  limit " + i2;
        e.a("TrackDBHelper", "flow getAllData querySql:" + str2);
        this.f68339a.readLock().lock();
        Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().rawQuery(str2, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("flowhandle");
                int columnIndex2 = cursor.getColumnIndex("detail");
                do {
                    arrayList2.add(new h(str, cursor.getString(columnIndex), cursor.getString(columnIndex2)));
                    arrayList.add(cursor.getString(columnIndex2));
                } while (cursor.moveToNext());
                e.a("TrackDBHelper", "flow flowID:" + str + ", get data from db count:" + arrayList.size() + ",flow detail:" + arrayList.toString());
                c(cursor);
                this.f68339a.readLock().unlock();
                e.a("TrackDBHelper", "flow uploadData SIZE:" + arrayList2.size());
                return arrayList2;
            }
            e.a("TrackDBHelper", "flow flowID:" + str + ", get data from db count:" + arrayList.size() + ",flow detail:" + arrayList.toString());
            c(cursor);
            this.f68339a.readLock().unlock();
            e.a("TrackDBHelper", "flow uploadData SIZE:" + arrayList2.size());
            return arrayList2;
        } catch (Throwable th) {
            c(cursor);
            this.f68339a.readLock().unlock();
            throw th;
        }
    }

    public final ContentValues g(c cVar) {
        ContentValues contentValues = new ContentValues();
        if (cVar != null) {
            contentValues.put("flowid", Integer.valueOf(cVar.f68226a));
            contentValues.put("flowhandle", Integer.valueOf(cVar.f68227b));
            contentValues.put("begintime", Long.valueOf(cVar.f68228c));
            contentValues.put("endtime", Long.valueOf(cVar.f68229d));
            contentValues.put("detail", cVar.f());
            if (cVar.f68229d == 0) {
                contentValues.put("state", (Integer) 0);
            } else {
                contentValues.put("state", (Integer) 1);
            }
            contentValues.put("ext", "");
        }
        return contentValues;
    }

    public int h(String str) {
        String str2 = "SELECT COUNT(*) FROM flow WHERE flowid=\"" + str + "\" AND state = 1 ";
        this.f68339a.readLock().lock();
        Cursor cursor = null;
        int i2 = 0;
        try {
            try {
                cursor = getReadableDatabase().rawQuery(str2, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    i2 = cursor.getInt(0);
                }
                e.a("TrackDBHelper", "flow getEndedFlowCount:" + i2);
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            return i2;
        } finally {
            c(cursor);
            this.f68339a.readLock().unlock();
        }
    }

    public void j(c cVar) {
        ContentValues g2;
        SQLiteDatabase writableDatabase;
        if (cVar == null) {
            e.a("TrackDBHelper", "flow must not be null");
            return;
        }
        this.f68339a.writeLock().lock();
        SQLiteDatabase sQLiteDatabase = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
            try {
                g2 = g(cVar);
                writableDatabase = getWritableDatabase();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            writableDatabase.beginTransactionNonExclusive();
            if (!a(cVar.f68226a, cVar.f68227b, writableDatabase)) {
                long insert = writableDatabase.insert("flow", null, g2);
                e.a("TrackDBHelper", "flow saveFlow,rowId:" + insert);
                sQLiteDatabase2 = insert;
            }
            writableDatabase.setTransactionSuccessful();
            sQLiteDatabase = sQLiteDatabase2;
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
                sQLiteDatabase = sQLiteDatabase2;
            }
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase3 = writableDatabase;
            e.printStackTrace();
            sQLiteDatabase = sQLiteDatabase3;
            if (sQLiteDatabase3 != null) {
                sQLiteDatabase3.endTransaction();
                sQLiteDatabase = sQLiteDatabase3;
            }
            this.f68339a.writeLock().unlock();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.f68339a.writeLock().unlock();
            throw th;
        }
        this.f68339a.writeLock().unlock();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle TEXT,begintime LONG,endtime LONG,detail TEXT,state INTEGER,ext TEXT );");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        try {
            sQLiteDatabase.beginTransaction();
            while (i2 < i3) {
                i2++;
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
