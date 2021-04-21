package d.b.c.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.BdCacheService;
import d.b.c.e.d.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.c.a.k.b f42407a;

    /* renamed from: b  reason: collision with root package name */
    public String f42408b;

    /* renamed from: c  reason: collision with root package name */
    public e.b f42409c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f42410d;

    /* renamed from: e  reason: collision with root package name */
    public int f42411e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<String> f42412f = new LinkedList<>();

    /* renamed from: g  reason: collision with root package name */
    public Object f42413g = new Object();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.m();
        }
    }

    public c(d.b.c.a.k.b bVar) {
        this.f42407a = bVar;
    }

    public synchronized void a(String str, boolean z) {
        synchronized (this.f42413g) {
            if (this.f42412f.contains(str)) {
                return;
            }
            this.f42412f.addLast(str);
            if (z) {
                j();
            }
        }
    }

    public void b(g<T> gVar) {
        String a2;
        try {
            synchronized (this.f42413g) {
                this.f42412f.remove(gVar.f42421a);
            }
            ContentValues p = p(gVar);
            SQLiteDatabase f2 = this.f42407a.f();
            if (f2.update(this.f42408b, p, "m_key = ?", new String[]{gVar.f42421a}) == 0) {
                f2.insert(this.f42408b, null, p);
                if (this.f42410d != null) {
                    j();
                }
            }
            if (this.f42409c == null || (a2 = this.f42409c.a(gVar)) == null) {
                return;
            }
            e(a2);
        } catch (Throwable th) {
            this.f42407a.i(th, "addOrUpdateTextCacheItem");
        }
    }

    public void c(String str) {
        this.f42411e = 0;
        synchronized (this.f42413g) {
            this.f42412f.clear();
        }
        if (d(str)) {
            BdCacheService.l().g().b(str);
        }
    }

    public abstract boolean d(String str);

    public int e(String str) {
        try {
            return this.f42407a.f().delete(this.f42408b, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.f42407a.i(th, "deleteCacheItem");
            return 0;
        }
    }

    public g<T> f(String str) {
        try {
            return i(this.f42407a.f(), str);
        } catch (Throwable th) {
            this.f42407a.i(th, "get");
            return null;
        }
    }

    public abstract int g();

    public d.b.c.a.k.b h() {
        return this.f42407a;
    }

    public abstract g<T> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public void j() {
        e.a aVar;
        if (this.f42410d != null) {
            this.f42411e++;
            if (this.f42411e >= ((int) Math.min(aVar.getMaxSize() * 0.2d, 5.0d))) {
                this.f42411e = 0;
                d.b.c.e.m.h.a().b(new a());
            }
        }
    }

    public abstract void k(String str, String str2, int i, int i2);

    public abstract String l(String str);

    public void m() {
        String removeFirst;
        if (this.f42412f.isEmpty()) {
            return;
        }
        SQLiteDatabase f2 = this.f42407a.f();
        f2.beginTransaction();
        while (true) {
            try {
                synchronized (this.f42413g) {
                    if (this.f42412f.isEmpty()) {
                        break;
                    }
                    removeFirst = this.f42412f.removeFirst();
                }
                f2.delete(this.f42408b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
            } finally {
                try {
                } finally {
                }
            }
        }
        f2.setTransactionSuccessful();
        this.f42411e = 0;
    }

    public void n(String str) {
        e.a aVar = this.f42410d;
        if (aVar == null) {
            return;
        }
        Cursor cursor = null;
        try {
            aVar.g();
            cursor = q(this.f42407a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.f42421a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f42424d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f42425e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f42426f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String h2 = this.f42410d.h(gVar);
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
        e.b bVar = this.f42409c;
        if (bVar == null) {
            return;
        }
        Cursor cursor = null;
        try {
            bVar.d();
            cursor = q(this.f42407a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.f42421a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f42424d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f42425e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f42426f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String f2 = this.f42409c.f(gVar);
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
        this.f42408b = str;
        if (eVar instanceof e.b) {
            this.f42409c = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.f42410d = (e.a) eVar;
        }
    }
}
