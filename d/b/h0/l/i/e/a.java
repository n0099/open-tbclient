package d.b.h0.l.i.e;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.l.i.d.c;
import d.b.h0.l.i.d.e;
import d.b.h0.l.k.d;
import d.b.h0.l.k.f;
import d.b.h0.l.k.g;
import d.b.h0.l.k.h;
import d.b.h0.l.k.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f49616b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f49617c = 10;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, d.b.h0.l.i.d.a> f49618a;

    public a() {
        this("ai_apps_pms.db", f49617c);
        b();
    }

    public static a a() {
        if (f49616b == null) {
            synchronized (a.class) {
                if (f49616b == null) {
                    f49616b = new a();
                }
            }
        }
        return f49616b;
    }

    public final void b() {
        ConcurrentHashMap<Class<?>, d.b.h0.l.i.d.a> concurrentHashMap = new ConcurrentHashMap<>();
        this.f49618a = concurrentHashMap;
        concurrentHashMap.put(f.class, new e());
        this.f49618a.put(g.class, new d.b.h0.l.i.d.f());
        this.f49618a.put(PMSAppInfo.class, new d.b.h0.l.i.d.b());
        this.f49618a.put(d.class, new d.b.h0.l.i.d.d());
        this.f49618a.put(d.b.h0.l.k.b.class, new c());
        this.f49618a.put(h.class, new d.b.h0.l.i.d.g());
        this.f49618a.put(d.b.h0.l.j.a.class, new d.b.h0.l.j.b.a());
        this.f49618a.put(i.class, new d.b.h0.l.i.d.h());
    }

    public void c() {
        f49616b = null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (d.b.h0.l.i.d.a aVar : this.f49618a.values()) {
            aVar.a(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (d.b.h0.l.i.d.a aVar : this.f49618a.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }
}
