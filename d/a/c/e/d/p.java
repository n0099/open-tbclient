package d.a.c.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.c.a.k.b f38556a;

    public p(Context context, d.a.c.a.k.b bVar) {
        this.f38556a = bVar;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.f38530a);
            contentValues.put("tableName", hVar.f38531b);
            contentValues.put("maxSize", Integer.valueOf(hVar.f38532c));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.f38534e));
            contentValues.put("cacheType", hVar.f38533d);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.f38535f));
            SQLiteDatabase f2 = this.f38556a.f();
            if (f2 == null || f2.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.f38530a}) != 0) {
                return;
            }
            f2.insert("cache_meta_info", null, contentValues);
        } catch (Throwable th) {
            this.f38556a.i(th, "addOrUpdate");
        }
    }

    public int b(String str) {
        try {
            if (c(str) == null) {
                return 0;
            }
            return this.f38556a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.f38556a.i(th, "delete");
            return 0;
        }
    }

    public h c(String str) {
        Cursor cursor;
        try {
            cursor = this.f38556a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    h hVar = new h();
                    hVar.f38530a = cursor.getString(0);
                    hVar.f38531b = cursor.getString(1);
                    hVar.f38532c = cursor.getInt(2);
                    hVar.f38533d = cursor.getString(3);
                    hVar.f38534e = cursor.getInt(4);
                    hVar.f38535f = cursor.getLong(5);
                    return hVar;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    this.f38556a.i(th, "get");
                    return null;
                } finally {
                    d.a.c.e.m.a.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }
}
