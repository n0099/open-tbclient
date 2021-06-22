package d.a.n0.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.n0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1154a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f52387a = new a();
    }

    public static final a g() {
        return C1154a.f52387a;
    }

    public synchronized long a(c cVar) {
        long h2;
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        h2 = h(f2, cVar);
        f2.setTransactionSuccessful();
        f2.endTransaction();
        return h2;
    }

    public synchronized void b(List<c> list) {
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

    public final ContentValues c(c cVar) {
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

    public final c d(Cursor cursor) {
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

    public synchronized boolean e(c cVar) {
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

    public synchronized List<c> f() {
        LinkedList linkedList;
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
        return linkedList;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, c cVar) {
        try {
            return sQLiteDatabase.insert("activity_mission_info", null, c(cVar));
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized long i(c cVar) {
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

    public final long j(SQLiteDatabase sQLiteDatabase, c cVar) {
        try {
            return sQLiteDatabase.update("activity_mission_info", c(cVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(cVar.d()), String.valueOf(cVar.q())});
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized void k(List<c> list) {
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
