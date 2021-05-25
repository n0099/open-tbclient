package d.a.c.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class q extends c<String> {

    /* renamed from: h  reason: collision with root package name */
    public String f38557h;

    public q(d.a.c.a.k.b bVar, String str) {
        super(bVar);
        this.f38557h = str;
    }

    @Override // d.a.c.e.d.c
    public boolean d(String str) {
        try {
            this.f38510a.f().delete(this.f38511b, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.f38510a.i(th, "clearData");
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
            rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f38511b + " where m_key = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!rawQuery.moveToNext()) {
                d.a.c.e.m.a.a(rawQuery);
                return null;
            }
            g<String> gVar = new g<>();
            gVar.f38524a = rawQuery.getString(0);
            gVar.f38526c = rawQuery.getString(1);
            gVar.f38527d = rawQuery.getLong(2);
            gVar.f38528e = rawQuery.getLong(3);
            gVar.f38529f = rawQuery.getLong(4);
            gVar.f38525b = rawQuery.getString(5);
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
        this.f38510a.d("CREATE TABLE IF NOT EXISTS " + this.f38557h + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.f38510a.d("CREATE INDEX if not exists idx_mi_ns ON " + this.f38557h + "(m_ns)");
        return this.f38557h;
    }

    @Override // d.a.c.e.d.c
    public ContentValues p(g<String> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.f38524a);
        contentValues.put("m_ns", gVar.f38526c);
        contentValues.put("m_value", gVar.f38525b);
        contentValues.put("saveTime", Long.valueOf(gVar.f38527d));
        contentValues.put("lastHitTime", Long.valueOf(gVar.f38528e));
        contentValues.put("timeToExpire", Long.valueOf(gVar.f38529f));
        return contentValues;
    }

    @Override // d.a.c.e.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.f38511b + " where m_ns = ?", new String[]{str});
    }
}
