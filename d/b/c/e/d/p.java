package d.b.c.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.c.a.k.b f42453a;

    public p(Context context, d.b.c.a.k.b bVar) {
        this.f42453a = bVar;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.f42427a);
            contentValues.put("tableName", hVar.f42428b);
            contentValues.put("maxSize", Integer.valueOf(hVar.f42429c));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.f42431e));
            contentValues.put("cacheType", hVar.f42430d);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.f42432f));
            SQLiteDatabase f2 = this.f42453a.f();
            if (f2 == null || f2.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.f42427a}) != 0) {
                return;
            }
            f2.insert("cache_meta_info", null, contentValues);
        } catch (Throwable th) {
            this.f42453a.i(th, "addOrUpdate");
        }
    }

    public int b(String str) {
        try {
            if (c(str) == null) {
                return 0;
            }
            return this.f42453a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.f42453a.i(th, "delete");
            return 0;
        }
    }

    public h c(String str) {
        Cursor cursor;
        try {
            cursor = this.f42453a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    h hVar = new h();
                    hVar.f42427a = cursor.getString(0);
                    hVar.f42428b = cursor.getString(1);
                    hVar.f42429c = cursor.getInt(2);
                    hVar.f42430d = cursor.getString(3);
                    hVar.f42431e = cursor.getInt(4);
                    hVar.f42432f = cursor.getLong(5);
                    return hVar;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    this.f42453a.i(th, "get");
                    return null;
                } finally {
                    d.b.c.e.m.a.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }
}
