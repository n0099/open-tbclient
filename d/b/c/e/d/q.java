package d.b.c.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class q extends c<String> {

    /* renamed from: h  reason: collision with root package name */
    public String f42454h;

    public q(d.b.c.a.k.b bVar, String str) {
        super(bVar);
        this.f42454h = str;
    }

    @Override // d.b.c.e.d.c
    public boolean d(String str) {
        try {
            this.f42407a.f().delete(this.f42408b, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.f42407a.i(th, "clearData");
            return false;
        }
    }

    @Override // d.b.c.e.d.c
    public int g() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
    @Override // d.b.c.e.d.c
    public g<String> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor rawQuery;
        Cursor cursor = null;
        try {
            rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f42408b + " where m_key = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!rawQuery.moveToNext()) {
                d.b.c.e.m.a.a(rawQuery);
                return null;
            }
            g<String> gVar = new g<>();
            gVar.f42421a = rawQuery.getString(0);
            gVar.f42423c = rawQuery.getString(1);
            gVar.f42424d = rawQuery.getLong(2);
            gVar.f42425e = rawQuery.getLong(3);
            gVar.f42426f = rawQuery.getLong(4);
            gVar.f42422b = rawQuery.getString(5);
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
        this.f42407a.d("CREATE TABLE IF NOT EXISTS " + this.f42454h + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.f42407a.d("CREATE INDEX if not exists idx_mi_ns ON " + this.f42454h + "(m_ns)");
        return this.f42454h;
    }

    @Override // d.b.c.e.d.c
    public ContentValues p(g<String> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.f42421a);
        contentValues.put("m_ns", gVar.f42423c);
        contentValues.put("m_value", gVar.f42422b);
        contentValues.put("saveTime", Long.valueOf(gVar.f42424d));
        contentValues.put("lastHitTime", Long.valueOf(gVar.f42425e));
        contentValues.put("timeToExpire", Long.valueOf(gVar.f42426f));
        return contentValues;
    }

    @Override // d.b.c.e.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.f42408b + " where m_ns = ?", new String[]{str});
    }
}
