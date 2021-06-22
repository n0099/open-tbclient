package d.a.h.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class b extends ContextWrapper {

    /* renamed from: b  reason: collision with root package name */
    public static b f43684b;

    /* renamed from: a  reason: collision with root package name */
    public h f43685a;

    public b() {
        super(null);
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f43684b == null) {
                f43684b = new b();
            }
            bVar = f43684b;
        }
        return bVar;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    /* renamed from: b */
    public h getResources() {
        if (this.f43685a == null) {
            this.f43685a = new h(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
        }
        return this.f43685a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        if (d.a.h.a.k.c.c(this)) {
            return d.a(str, this);
        }
        return super.getSharedPreferences(str, i2);
    }
}
