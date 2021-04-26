package d.a.c.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class r extends c<String> {
    public r(d.a.c.a.k.b bVar) {
        super(bVar);
    }

    @Override // d.a.c.e.d.c
    public boolean d(String str) {
        d.a.c.a.k.b bVar = this.f39601a;
        bVar.d("DROP TABLE IF EXISTS " + this.f39602b);
        return true;
    }

    @Override // d.a.c.e.d.c
    public int g() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
    @Override // d.a.c.e.d.c
    public g<String> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f39602b + " where m_key = ?", new String[]{str});
            try {
                if (!rawQuery.moveToNext()) {
                    d.a.c.e.m.a.a(rawQuery);
                    return null;
                }
                g<String> gVar = new g<>();
                gVar.f39615a = rawQuery.getString(0);
                gVar.f39618d = rawQuery.getLong(1);
                gVar.f39619e = rawQuery.getLong(2);
                gVar.f39620f = rawQuery.getLong(3);
                gVar.f39616b = rawQuery.getString(4);
                d.a.c.e.m.a.a(rawQuery);
                return gVar;
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                d.a.c.e.m.a.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // d.a.c.e.d.c
    public void k(String str, String str2, int i2, int i3) {
    }

    @Override // d.a.c.e.d.c
    public String l(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_t" + hashCode;
        this.f39601a.d("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        return str2;
    }

    @Override // d.a.c.e.d.c
    public ContentValues p(g<String> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.f39615a);
        contentValues.put("m_value", gVar.f39616b);
        contentValues.put("saveTime", Long.valueOf(gVar.f39618d));
        contentValues.put("lastHitTime", Long.valueOf(gVar.f39619e));
        contentValues.put("timeToExpire", Long.valueOf(gVar.f39620f));
        return contentValues;
    }

    @Override // d.a.c.e.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.f39602b, new String[0]);
    }
}
