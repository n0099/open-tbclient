package d.b.b.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.b.a.k.b f41716a;

    public p(Context context, d.b.b.a.k.b bVar) {
        this.f41716a = bVar;
    }

    public void a(h hVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", hVar.f41690a);
            contentValues.put("tableName", hVar.f41691b);
            contentValues.put("maxSize", Integer.valueOf(hVar.f41692c));
            contentValues.put("cacheVersion", Integer.valueOf(hVar.f41694e));
            contentValues.put("cacheType", hVar.f41693d);
            contentValues.put("lastActiveTime", Long.valueOf(hVar.f41695f));
            SQLiteDatabase f2 = this.f41716a.f();
            if (f2 == null || f2.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.f41690a}) != 0) {
                return;
            }
            f2.insert("cache_meta_info", null, contentValues);
        } catch (Throwable th) {
            this.f41716a.i(th, "addOrUpdate");
        }
    }

    public int b(String str) {
        try {
            if (c(str) == null) {
                return 0;
            }
            return this.f41716a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.f41716a.i(th, "delete");
            return 0;
        }
    }

    public h c(String str) {
        Cursor cursor;
        try {
            cursor = this.f41716a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    h hVar = new h();
                    hVar.f41690a = cursor.getString(0);
                    hVar.f41691b = cursor.getString(1);
                    hVar.f41692c = cursor.getInt(2);
                    hVar.f41693d = cursor.getString(3);
                    hVar.f41694e = cursor.getInt(4);
                    hVar.f41695f = cursor.getLong(5);
                    return hVar;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    this.f41716a.i(th, "get");
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
