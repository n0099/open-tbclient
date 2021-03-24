package d.b.b.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.BdCacheService;
import d.b.b.e.d.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.b.a.k.b f41669a;

    /* renamed from: b  reason: collision with root package name */
    public String f41670b;

    /* renamed from: c  reason: collision with root package name */
    public e.b f41671c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f41672d;

    /* renamed from: e  reason: collision with root package name */
    public int f41673e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<String> f41674f = new LinkedList<>();

    /* renamed from: g  reason: collision with root package name */
    public Object f41675g = new Object();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.m();
        }
    }

    public c(d.b.b.a.k.b bVar) {
        this.f41669a = bVar;
    }

    public synchronized void a(String str, boolean z) {
        synchronized (this.f41675g) {
            if (this.f41674f.contains(str)) {
                return;
            }
            this.f41674f.addLast(str);
            if (z) {
                j();
            }
        }
    }

    public void b(g<T> gVar) {
        String a2;
        try {
            synchronized (this.f41675g) {
                this.f41674f.remove(gVar.f41683a);
            }
            ContentValues p = p(gVar);
            SQLiteDatabase f2 = this.f41669a.f();
            if (f2.update(this.f41670b, p, "m_key = ?", new String[]{gVar.f41683a}) == 0) {
                f2.insert(this.f41670b, null, p);
                if (this.f41672d != null) {
                    j();
                }
            }
            if (this.f41671c == null || (a2 = this.f41671c.a(gVar)) == null) {
                return;
            }
            e(a2);
        } catch (Throwable th) {
            this.f41669a.i(th, "addOrUpdateTextCacheItem");
        }
    }

    public void c(String str) {
        this.f41673e = 0;
        synchronized (this.f41675g) {
            this.f41674f.clear();
        }
        if (d(str)) {
            BdCacheService.l().g().b(str);
        }
    }

    public abstract boolean d(String str);

    public int e(String str) {
        try {
            return this.f41669a.f().delete(this.f41670b, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.f41669a.i(th, "deleteCacheItem");
            return 0;
        }
    }

    public g<T> f(String str) {
        try {
            return i(this.f41669a.f(), str);
        } catch (Throwable th) {
            this.f41669a.i(th, "get");
            return null;
        }
    }

    public abstract int g();

    public d.b.b.a.k.b h() {
        return this.f41669a;
    }

    public abstract g<T> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public void j() {
        e.a aVar = this.f41672d;
        if (aVar != null) {
            this.f41673e++;
            double maxSize = aVar.getMaxSize();
            Double.isNaN(maxSize);
            if (this.f41673e >= ((int) Math.min(maxSize * 0.2d, 5.0d))) {
                this.f41673e = 0;
                d.b.b.e.m.h.a().b(new a());
            }
        }
    }

    public abstract void k(String str, String str2, int i, int i2);

    public abstract String l(String str);

    public void m() {
        String removeFirst;
        if (this.f41674f.isEmpty()) {
            return;
        }
        SQLiteDatabase f2 = this.f41669a.f();
        f2.beginTransaction();
        while (true) {
            try {
                synchronized (this.f41675g) {
                    if (this.f41674f.isEmpty()) {
                        break;
                    }
                    removeFirst = this.f41674f.removeFirst();
                }
                f2.delete(this.f41670b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
            } finally {
                try {
                } finally {
                }
            }
        }
        f2.setTransactionSuccessful();
        this.f41673e = 0;
    }

    public void n(String str) {
        e.a aVar = this.f41672d;
        if (aVar == null) {
            return;
        }
        Cursor cursor = null;
        try {
            aVar.g();
            cursor = q(this.f41669a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.f41683a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f41686d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f41687e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f41688f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String h2 = this.f41672d.h(gVar);
                if (h2 != null) {
                    a(h2, false);
                }
            }
            m();
        } finally {
            try {
            } finally {
            }
        }
    }

    public void o(String str) {
        e.b bVar = this.f41671c;
        if (bVar == null) {
            return;
        }
        Cursor cursor = null;
        try {
            bVar.d();
            cursor = q(this.f41669a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.f41683a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f41686d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f41687e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f41688f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String f2 = this.f41671c.f(gVar);
                if (f2 != null) {
                    a(f2, false);
                }
            }
            m();
        } finally {
            try {
            } finally {
            }
        }
    }

    public abstract ContentValues p(g<T> gVar);

    public abstract Cursor q(SQLiteDatabase sQLiteDatabase, String str);

    public void r(e eVar, String str) {
        this.f41670b = str;
        if (eVar instanceof e.b) {
            this.f41671c = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.f41672d = (e.a) eVar;
        }
    }
}
