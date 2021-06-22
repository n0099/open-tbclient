package d.a.c.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class q extends c<String> {

    /* renamed from: h  reason: collision with root package name */
    public String f42313h;

    public q(d.a.c.a.k.b bVar, String str) {
        super(bVar);
        this.f42313h = str;
    }

    @Override // d.a.c.e.d.c
    public boolean d(String str) {
        try {
            this.f42266a.f().delete(this.f42267b, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.f42266a.i(th, "clearData");
            return false;
        }
    }

    @Override // d.a.c.e.d.c
    public int g() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
    @Override // d.a.c.e.d.c
    public g<String> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor rawQuery;
        Cursor cursor = null;
        try {
            rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f42267b + " where m_key = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!rawQuery.moveToNext()) {
                d.a.c.e.m.a.a(rawQuery);
                return null;
            }
            g<String> gVar = new g<>();
            gVar.f42280a = rawQuery.getString(0);
            gVar.f42282c = rawQuery.getString(1);
            gVar.f42283d = rawQuery.getLong(2);
            gVar.f42284e = rawQuery.getLong(3);
            gVar.f42285f = rawQuery.getLong(4);
            gVar.f42281b = rawQuery.getString(5);
            d.a.c.e.m.a.a(rawQuery);
            return gVar;
        } catch (Throwable th2) {
            th = th2;
            cursor = rawQuery;
            d.a.c.e.m.a.a(cursor);
            throw th;
        }
    }

    @Override // d.a.c.e.d.c
    public void k(String str, String str2, int i2, int i3) {
    }

    @Override // d.a.c.e.d.c
    public String l(String str) {
        this.f42266a.d("CREATE TABLE IF NOT EXISTS " + this.f42313h + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.f42266a.d("CREATE INDEX if not exists idx_mi_ns ON " + this.f42313h + "(m_ns)");
        return this.f42313h;
    }

    @Override // d.a.c.e.d.c
    public ContentValues p(g<String> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.f42280a);
        contentValues.put("m_ns", gVar.f42282c);
        contentValues.put("m_value", gVar.f42281b);
        contentValues.put("saveTime", Long.valueOf(gVar.f42283d));
        contentValues.put("lastHitTime", Long.valueOf(gVar.f42284e));
        contentValues.put("timeToExpire", Long.valueOf(gVar.f42285f));
        return contentValues;
    }

    @Override // d.a.c.e.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.f42267b + " where m_ns = ?", new String[]{str});
    }
}
