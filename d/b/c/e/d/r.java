package d.b.c.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class r extends c<String> {
    public r(d.b.c.a.k.b bVar) {
        super(bVar);
    }

    @Override // d.b.c.e.d.c
    public boolean d(String str) {
        d.b.c.a.k.b bVar = this.f42167a;
        bVar.d("DROP TABLE IF EXISTS " + this.f42168b);
        return true;
    }

    @Override // d.b.c.e.d.c
    public int g() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
    @Override // d.b.c.e.d.c
    public g<String> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f42168b + " where m_key = ?", new String[]{str});
            try {
                if (!rawQuery.moveToNext()) {
                    d.b.c.e.m.a.a(rawQuery);
                    return null;
                }
                g<String> gVar = new g<>();
                gVar.f42181a = rawQuery.getString(0);
                gVar.f42184d = rawQuery.getLong(1);
                gVar.f42185e = rawQuery.getLong(2);
                gVar.f42186f = rawQuery.getLong(3);
                gVar.f42182b = rawQuery.getString(4);
                d.b.c.e.m.a.a(rawQuery);
                return gVar;
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                d.b.c.e.m.a.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // d.b.c.e.d.c
    public void k(String str, String str2, int i, int i2) {
    }

    @Override // d.b.c.e.d.c
    public String l(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_t" + hashCode;
        this.f42167a.d("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        return str2;
    }

    @Override // d.b.c.e.d.c
    public ContentValues p(g<String> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.f42181a);
        contentValues.put("m_value", gVar.f42182b);
        contentValues.put("saveTime", Long.valueOf(gVar.f42184d));
        contentValues.put("lastHitTime", Long.valueOf(gVar.f42185e));
        contentValues.put("timeToExpire", Long.valueOf(gVar.f42186f));
        return contentValues;
    }

    @Override // d.b.c.e.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.f42168b, new String[0]);
    }
}
