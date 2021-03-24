package d.b.b.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.b.a.k.b f41715a;

    public p(Context context, d.b.b.a.k.b bVar) {
        this.f41715a = bVar;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.f41689a);
            contentValues.put("tableName", hVar.f41690b);
            contentValues.put("maxSize", Integer.valueOf(hVar.f41691c));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.f41693e));
            contentValues.put("cacheType", hVar.f41692d);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.f41694f));
            SQLiteDatabase f2 = this.f41715a.f();
            if (f2 == null || f2.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.f41689a}) != 0) {
                return;
            }
            f2.insert("cache_meta_info", null, contentValues);
        } catch (Throwable th) {
            this.f41715a.i(th, "addOrUpdate");
        }
    }

    public int b(String str) {
        try {
            if (c(str) == null) {
                return 0;
            }
            return this.f41715a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.f41715a.i(th, "delete");
            return 0;
        }
    }

    public h c(String str) {
        Cursor cursor;
        try {
            cursor = this.f41715a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    h hVar = new h();
                    hVar.f41689a = cursor.getString(0);
                    hVar.f41690b = cursor.getString(1);
                    hVar.f41691c = cursor.getInt(2);
                    hVar.f41692d = cursor.getString(3);
                    hVar.f41693e = cursor.getInt(4);
                    hVar.f41694f = cursor.getLong(5);
                    return hVar;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    this.f41715a.i(th, "get");
                    return null;
                } finally {
                    d.b.b.e.m.a.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }
}
