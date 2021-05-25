package d.a.c.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.BdCacheService;
import d.a.c.e.d.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.c.a.k.b f38510a;

    /* renamed from: b  reason: collision with root package name */
    public String f38511b;

    /* renamed from: c  reason: collision with root package name */
    public e.b f38512c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f38513d;

    /* renamed from: e  reason: collision with root package name */
    public int f38514e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<String> f38515f = new LinkedList<>();

    /* renamed from: g  reason: collision with root package name */
    public Object f38516g = new Object();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.m();
        }
    }

    public c(d.a.c.a.k.b bVar) {
        this.f38510a = bVar;
    }

    public synchronized void a(String str, boolean z) {
        synchronized (this.f38516g) {
            if (this.f38515f.contains(str)) {
                return;
            }
            this.f38515f.addLast(str);
            if (z) {
                j();
            }
        }
    }

    public void b(g<T> gVar) {
        String d2;
        try {
            synchronized (this.f38516g) {
                this.f38515f.remove(gVar.f38524a);
            }
            ContentValues p = p(gVar);
            SQLiteDatabase f2 = this.f38510a.f();
            if (f2.update(this.f38511b, p, "m_key = ?", new String[]{gVar.f38524a}) == 0) {
                f2.insert(this.f38511b, null, p);
                if (this.f38513d != null) {
                    j();
                }
            }
            if (this.f38512c == null || (d2 = this.f38512c.d(gVar)) == null) {
                return;
            }
            e(d2);
        } catch (Throwable th) {
            this.f38510a.i(th, "addOrUpdateTextCacheItem");
        }
    }

    public void c(String str) {
        this.f38514e = 0;
        synchronized (this.f38516g) {
            this.f38515f.clear();
        }
        if (d(str)) {
            BdCacheService.l().g().b(str);
        }
    }

    public abstract boolean d(String str);

    public int e(String str) {
        try {
            return this.f38510a.f().delete(this.f38511b, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.f38510a.i(th, "deleteCacheItem");
            return 0;
        }
    }

    public g<T> f(String str) {
        try {
            return i(this.f38510a.f(), str);
        } catch (Throwable th) {
            this.f38510a.i(th, "get");
            return null;
        }
    }

    public abstract int g();

    public d.a.c.a.k.b h() {
        return this.f38510a;
    }

    public abstract g<T> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public void j() {
        e.a aVar;
        if (this.f38513d != null) {
            this.f38514e++;
            if (this.f38514e >= ((int) Math.min(aVar.getMaxSize() * 0.2d, 5.0d))) {
                this.f38514e = 0;
                d.a.c.e.m.h.a().b(new a());
            }
        }
    }

    public abstract void k(String str, String str2, int i2, int i3);

    public abstract String l(String str);

    public void m() {
        String removeFirst;
        if (this.f38515f.isEmpty()) {
            return;
        }
        SQLiteDatabase f2 = this.f38510a.f();
        f2.beginTransaction();
        while (true) {
            try {
                synchronized (this.f38516g) {
                    if (this.f38515f.isEmpty()) {
                        break;
                    }
                    removeFirst = this.f38515f.removeFirst();
                }
                f2.delete(this.f38511b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
            } finally {
                try {
                } finally {
                }
            }
        }
        f2.setTransactionSuccessful();
        this.f38514e = 0;
    }

    public void n(String str) {
        e.a aVar = this.f38513d;
        if (aVar == null) {
            return;
        }
        Cursor cursor = null;
        try {
            aVar.c();
            cursor = q(this.f38510a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.f38524a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f38527d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f38528e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f38529f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String h2 = this.f38513d.h(gVar);
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
        e.b bVar = this.f38512c;
        if (bVar == null) {
            return;
        }
        Cursor cursor = null;
        try {
            bVar.e();
            cursor = q(this.f38510a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.f38524a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f38527d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f38528e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f38529f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String g2 = this.f38512c.g(gVar);
                if (g2 != null) {
                    a(g2, false);
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
        this.f38511b = str;
        if (eVar instanceof e.b) {
            this.f38512c = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.f38513d = (e.a) eVar;
        }
    }
}
