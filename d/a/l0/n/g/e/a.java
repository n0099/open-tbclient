package d.a.l0.n.g.e;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.n.g.d.c;
import d.a.l0.n.g.d.e;
import d.a.l0.n.h.d;
import d.a.l0.n.h.f;
import d.a.l0.n.h.g;
import d.a.l0.n.h.h;
import d.a.l0.n.h.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f51664b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f51665c = 10;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, d.a.l0.n.g.d.a> f51666a;

    public a() {
        this("ai_apps_pms.db", f51665c);
        b();
    }

    public static a a() {
        if (f51664b == null) {
            synchronized (a.class) {
                if (f51664b == null) {
                    f51664b = new a();
                }
            }
        }
        return f51664b;
    }

    public final void b() {
        ConcurrentHashMap<Class<?>, d.a.l0.n.g.d.a> concurrentHashMap = new ConcurrentHashMap<>();
        this.f51666a = concurrentHashMap;
        concurrentHashMap.put(f.class, new e());
        this.f51666a.put(g.class, new d.a.l0.n.g.d.f());
        this.f51666a.put(PMSAppInfo.class, new d.a.l0.n.g.d.b());
        this.f51666a.put(d.class, new d.a.l0.n.g.d.d());
        this.f51666a.put(d.a.l0.n.h.b.class, new c());
        this.f51666a.put(h.class, new d.a.l0.n.g.d.g());
        this.f51666a.put(i.class, new d.a.l0.n.g.d.h());
    }

    public void c() {
        f51664b = null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (d.a.l0.n.g.d.a aVar : this.f51666a.values()) {
            aVar.a(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        for (d.a.l0.n.g.d.a aVar : this.f51666a.values()) {
            aVar.onUpgrade(sQLiteDatabase, i2, i3);
        }
    }

    public a(String str, int i2) {
        super(AppRuntime.getAppContext(), str, null, i2, null);
    }
}
