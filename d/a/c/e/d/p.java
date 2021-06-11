package d.a.c.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.c.a.k.b f42209a;

    public p(Context context, d.a.c.a.k.b bVar) {
        this.f42209a = bVar;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.f42183a);
            contentValues.put("tableName", hVar.f42184b);
            contentValues.put("maxSize", Integer.valueOf(hVar.f42185c));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.f42187e));
            contentValues.put("cacheType", hVar.f42186d);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.f42188f));
            SQLiteDatabase f2 = this.f42209a.f();
            if (f2 == null || f2.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.f42183a}) != 0) {
                return;
            }
            f2.insert("cache_meta_info", null, contentValues);
        } catch (Throwable th) {
            this.f42209a.i(th, "addOrUpdate");
        }
    }

    public int b(String str) {
        try {
            if (c(str) == null) {
                return 0;
            }
            return this.f42209a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.f42209a.i(th, "delete");
            return 0;
        }
    }

    public h c(String str) {
        Cursor cursor;
        try {
            cursor = this.f42209a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    h hVar = new h();
                    hVar.f42183a = cursor.getString(0);
                    hVar.f42184b = cursor.getString(1);
                    hVar.f42185c = cursor.getInt(2);
                    hVar.f42186d = cursor.getString(3);
                    hVar.f42187e = cursor.getInt(4);
                    hVar.f42188f = cursor.getLong(5);
                    return hVar;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    this.f42209a.i(th, "get");
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
