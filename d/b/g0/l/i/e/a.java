package d.b.g0.l.i.e;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.l.i.d.c;
import d.b.g0.l.i.d.e;
import d.b.g0.l.k.d;
import d.b.g0.l.k.f;
import d.b.g0.l.k.g;
import d.b.g0.l.k.h;
import d.b.g0.l.k.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f48895b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f48896c = 10;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, d.b.g0.l.i.d.a> f48897a;

    public a() {
        this("ai_apps_pms.db", f48896c);
        b();
    }

    public static a a() {
        if (f48895b == null) {
            synchronized (a.class) {
                if (f48895b == null) {
                    f48895b = new a();
                }
            }
        }
        return f48895b;
    }

    public final void b() {
        ConcurrentHashMap<Class<?>, d.b.g0.l.i.d.a> concurrentHashMap = new ConcurrentHashMap<>();
        this.f48897a = concurrentHashMap;
        concurrentHashMap.put(f.class, new e());
        this.f48897a.put(g.class, new d.b.g0.l.i.d.f());
        this.f48897a.put(PMSAppInfo.class, new d.b.g0.l.i.d.b());
        this.f48897a.put(d.class, new d.b.g0.l.i.d.d());
        this.f48897a.put(d.b.g0.l.k.b.class, new c());
        this.f48897a.put(h.class, new d.b.g0.l.i.d.g());
        this.f48897a.put(d.b.g0.l.j.a.class, new d.b.g0.l.j.b.a());
        this.f48897a.put(i.class, new d.b.g0.l.i.d.h());
    }

    public void c() {
        f48895b = null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (d.b.g0.l.i.d.a aVar : this.f48897a.values()) {
            aVar.a(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (d.b.g0.l.i.d.a aVar : this.f48897a.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }
}
