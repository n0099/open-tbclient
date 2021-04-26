package d.a.c.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.c.a.k.b f39647a;

    public p(Context context, d.a.c.a.k.b bVar) {
        this.f39647a = bVar;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.f39621a);
            contentValues.put("tableName", hVar.f39622b);
            contentValues.put("maxSize", Integer.valueOf(hVar.f39623c));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.f39625e));
            contentValues.put("cacheType", hVar.f39624d);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.f39626f));
            SQLiteDatabase f2 = this.f39647a.f();
            if (f2 == null || f2.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.f39621a}) != 0) {
                return;
            }
            f2.insert("cache_meta_info", null, contentValues);
        } catch (Throwable th) {
            this.f39647a.i(th, "addOrUpdate");
        }
    }

    public int b(String str) {
        try {
            if (c(str) == null) {
                return 0;
            }
            return this.f39647a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.f39647a.i(th, "delete");
            return 0;
        }
    }

    public h c(String str) {
        Cursor cursor;
        try {
            cursor = this.f39647a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    h hVar = new h();
                    hVar.f39621a = cursor.getString(0);
                    hVar.f39622b = cursor.getString(1);
                    hVar.f39623c = cursor.getInt(2);
                    hVar.f39624d = cursor.getString(3);
                    hVar.f39625e = cursor.getInt(4);
                    hVar.f39626f = cursor.getLong(5);
                    return hVar;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    this.f39647a.i(th, "get");
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
