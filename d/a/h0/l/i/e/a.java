package d.a.h0.l.i.e;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.l.i.d.c;
import d.a.h0.l.i.d.e;
import d.a.h0.l.k.d;
import d.a.h0.l.k.f;
import d.a.h0.l.k.g;
import d.a.h0.l.k.h;
import d.a.h0.l.k.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f47123b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f47124c = 10;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, d.a.h0.l.i.d.a> f47125a;

    public a() {
        this("ai_apps_pms.db", f47124c);
        b();
    }

    public static a a() {
        if (f47123b == null) {
            synchronized (a.class) {
                if (f47123b == null) {
                    f47123b = new a();
                }
            }
        }
        return f47123b;
    }

    public final void b() {
        ConcurrentHashMap<Class<?>, d.a.h0.l.i.d.a> concurrentHashMap = new ConcurrentHashMap<>();
        this.f47125a = concurrentHashMap;
        concurrentHashMap.put(f.class, new e());
        this.f47125a.put(g.class, new d.a.h0.l.i.d.f());
        this.f47125a.put(PMSAppInfo.class, new d.a.h0.l.i.d.b());
        this.f47125a.put(d.class, new d.a.h0.l.i.d.d());
        this.f47125a.put(d.a.h0.l.k.b.class, new c());
        this.f47125a.put(h.class, new d.a.h0.l.i.d.g());
        this.f47125a.put(d.a.h0.l.j.a.class, new d.a.h0.l.j.b.a());
        this.f47125a.put(i.class, new d.a.h0.l.i.d.h());
    }

    public void c() {
        f47123b = null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (d.a.h0.l.i.d.a aVar : this.f47125a.values()) {
            aVar.a(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        for (d.a.h0.l.i.d.a aVar : this.f47125a.values()) {
            aVar.onUpgrade(sQLiteDatabase, i2, i3);
        }
    }

    public a(String str, int i2) {
        super(AppRuntime.getAppContext(), str, null, i2, null);
    }
}
