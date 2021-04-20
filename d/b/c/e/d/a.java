package d.b.c.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {

    /* renamed from: h  reason: collision with root package name */
    public String f42166h;

    public a(d.b.c.a.k.b bVar, String str) {
        super(bVar);
        this.f42166h = str;
    }

    @Override // d.b.c.e.d.c
    public boolean d(String str) {
        try {
            this.f42167a.f().delete(this.f42168b, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            d.b.c.a.k.b bVar = this.f42167a;
            bVar.i(th, "failed to clear from " + str);
            return false;
        }
    }

    @Override // d.b.c.e.d.c
    public int g() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, byte[]] */
    @Override // d.b.c.e.d.c
    public g<byte[]> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor rawQuery;
        Cursor cursor = null;
        try {
            rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f42168b + " where m_key = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!rawQuery.moveToNext()) {
                d.b.c.e.m.a.a(rawQuery);
                return null;
            }
            g<byte[]> gVar = new g<>();
            gVar.f42181a = rawQuery.getString(0);
            gVar.f42183c = rawQuery.getString(1);
            gVar.f42184d = rawQuery.getLong(2);
            gVar.f42185e = rawQuery.getLong(3);
            gVar.f42186f = rawQuery.getLong(4);
            gVar.f42182b = rawQuery.getBlob(5);
            d.b.c.e.m.a.a(rawQuery);
            return gVar;
        } catch (Throwable th2) {
            th = th2;
            cursor = rawQuery;
            d.b.c.e.m.a.a(cursor);
            throw th;
        }
    }

    @Override // d.b.c.e.d.c
    public void k(String str, String str2, int i, int i2) {
    }

    @Override // d.b.c.e.d.c
    public String l(String str) {
        this.f42167a.d("CREATE TABLE IF NOT EXISTS " + this.f42166h + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.f42167a.d("CREATE INDEX if not exists idx_mi_ns ON " + this.f42166h + "(m_ns)");
        return this.f42166h;
    }

    @Override // d.b.c.e.d.c
    public ContentValues p(g<byte[]> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.f42181a);
        contentValues.put("m_ns", gVar.f42183c);
        contentValues.put("m_value", gVar.f42182b);
        contentValues.put("saveTime", Long.valueOf(gVar.f42184d));
        contentValues.put("lastHitTime", Long.valueOf(gVar.f42185e));
        contentValues.put("timeToExpire", Long.valueOf(gVar.f42186f));
        return contentValues;
    }

    @Override // d.b.c.e.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.f42168b + " where m_ns = ?", new String[]{str});
    }
}
