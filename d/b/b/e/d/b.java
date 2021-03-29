package d.b.b.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class b extends c<byte[]> {
    public b(d.b.b.a.k.b bVar) {
        super(bVar);
    }

    @Override // d.b.b.e.d.c
    public boolean d(String str) {
        d.b.b.a.k.b bVar = this.f41670a;
        bVar.d("DROP TABLE IF EXISTS " + this.f41671b);
        return true;
    }

    @Override // d.b.b.e.d.c
    public int g() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [T, byte[]] */
    @Override // d.b.b.e.d.c
    public g<byte[]> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f41671b + " where m_key = ?", new String[]{str});
            try {
                if (!rawQuery.moveToNext()) {
                    d.b.b.e.m.a.a(rawQuery);
                    return null;
                }
                g<byte[]> gVar = new g<>();
                gVar.f41684a = rawQuery.getString(0);
                gVar.f41687d = rawQuery.getLong(1);
                gVar.f41688e = rawQuery.getLong(2);
                gVar.f41689f = rawQuery.getLong(3);
                gVar.f41685b = rawQuery.getBlob(4);
                d.b.b.e.m.a.a(rawQuery);
                return gVar;
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                d.b.b.e.m.a.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // d.b.b.e.d.c
    public void k(String str, String str2, int i, int i2) {
    }

    @Override // d.b.b.e.d.c
    public String l(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_b" + hashCode;
        this.f41670a.d("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        return str2;
    }

    @Override // d.b.b.e.d.c
    public ContentValues p(g<byte[]> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.f41684a);
        contentValues.put("m_value", gVar.f41685b);
        contentValues.put("saveTime", Long.valueOf(gVar.f41687d));
        contentValues.put("lastHitTime", Long.valueOf(gVar.f41688e));
        contentValues.put("timeToExpire", Long.valueOf(gVar.f41689f));
        return contentValues;
    }

    @Override // d.b.b.e.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.f41671b, new String[0]);
    }
}
