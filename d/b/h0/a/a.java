package d.b.h0.a;

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

    /* renamed from: d.b.h0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1039a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f49498a = new a();
    }

    public static final a g() {
        return C1039a.f49498a;
    }

    public synchronized long a(b bVar) {
        long h2;
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        h2 = h(f2, bVar);
        f2.setTransactionSuccessful();
        f2.endTransaction();
        return h2;
    }

    public synchronized void b(List<b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        for (b bVar : list) {
            h(f2, bVar);
        }
        f2.setTransactionSuccessful();
        f2.endTransaction();
    }

    public final ContentValues c(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("activityid", Integer.valueOf(bVar.d()));
        contentValues.put("missionid", Integer.valueOf(bVar.q()));
        contentValues.put("activitysource", bVar.e());
        contentValues.put("calltype", Integer.valueOf(bVar.i()));
        contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(bVar.x()));
        contentValues.put("browsetimepage", bVar.g());
        contentValues.put("browsetime", Long.valueOf(bVar.f()));
        contentValues.put("threadnum", Integer.valueOf(bVar.A()));
        contentValues.put("forumnum", Integer.valueOf(bVar.p()));
        contentValues.put("cleartype", Integer.valueOf(bVar.k()));
        contentValues.put("cleartime", Long.valueOf(bVar.j()));
        contentValues.put("specificcleartime", Long.valueOf(bVar.t()));
        contentValues.put("tid", Long.valueOf(bVar.C()));
        contentValues.put("fid", Long.valueOf(bVar.o()));
        contentValues.put("threadtext", bVar.B());
        contentValues.put("threadimg", bVar.z());
        contentValues.put("threadforum", Long.valueOf(bVar.y()));
        contentValues.put("totalLimit", Integer.valueOf(bVar.F()));
        contentValues.put("completedLimitCount", Integer.valueOf(bVar.w()));
        contentValues.put("token", bVar.E());
        contentValues.put("executingMissionList", bVar.b());
        return contentValues;
    }

    public final b d(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        b bVar = new b();
        bVar.S(cursor.getInt(cursor.getColumnIndex("activityid")));
        bVar.b0(cursor.getInt(cursor.getColumnIndex("missionid")));
        bVar.T(cursor.getString(cursor.getColumnIndex("activitysource")));
        bVar.W(cursor.getInt(cursor.getColumnIndex("calltype")));
        bVar.f0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
        bVar.V(cursor.getString(cursor.getColumnIndex("browsetimepage")));
        bVar.U(cursor.getLong(cursor.getColumnIndex("browsetime")));
        bVar.i0(cursor.getInt(cursor.getColumnIndex("threadnum")));
        bVar.a0(cursor.getInt(cursor.getColumnIndex("forumnum")));
        bVar.Y(cursor.getInt(cursor.getColumnIndex("cleartype")));
        bVar.X(cursor.getLong(cursor.getColumnIndex("cleartime")));
        bVar.d0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
        bVar.k0(cursor.getLong(cursor.getColumnIndex("tid")));
        bVar.Z(cursor.getLong(cursor.getColumnIndex("fid")));
        bVar.j0(cursor.getString(cursor.getColumnIndex("threadtext")));
        bVar.h0(cursor.getString(cursor.getColumnIndex("threadimg")));
        bVar.g0(cursor.getInt(cursor.getColumnIndex("threadforum")));
        bVar.m0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
        bVar.e0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
        bVar.P(bVar.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
        bVar.l0(cursor.getString(cursor.getColumnIndex("token")));
        return bVar;
    }

    public synchronized boolean e(b bVar) {
        if (bVar == null) {
            return false;
        }
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        int delete = f2.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.d()), String.valueOf(bVar.q())});
        f2.setTransactionSuccessful();
        f2.endTransaction();
        return delete >= 0;
    }

    public synchronized List<b> f() {
        LinkedList linkedList;
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        linkedList = new LinkedList();
        Cursor rawQuery = f2.rawQuery("SELECT * FROM activity_mission_info", null);
        while (rawQuery.moveToNext()) {
            b d2 = d(rawQuery);
            if (d2 != null) {
                linkedList.add(d2);
            }
        }
        f2.setTransactionSuccessful();
        d.b.b.e.p.m.a(rawQuery);
        f2.endTransaction();
        return linkedList;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, b bVar) {
        try {
            return sQLiteDatabase.insert("activity_mission_info", null, c(bVar));
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized long i(b bVar) {
        if (bVar == null) {
            return -1L;
        }
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        long j = j(f2, bVar);
        f2.setTransactionSuccessful();
        f2.endTransaction();
        return j;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, b bVar) {
        try {
            return sQLiteDatabase.update("activity_mission_info", c(bVar), "activityid = ? and missionid = ?", new String[]{String.valueOf(bVar.d()), String.valueOf(bVar.q())});
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public synchronized void k(List<b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        f2.beginTransaction();
        for (b bVar : list) {
            j(f2, bVar);
        }
        f2.setTransactionSuccessful();
        f2.endTransaction();
    }
}
