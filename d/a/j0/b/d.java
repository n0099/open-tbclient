package d.a.j0.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f40272a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f40273b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40274c;

    public d(Context context) {
        try {
            this.f40274c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f40272a = sharedPreferences;
            this.f40273b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public String a() {
        return this.f40272a.getString("xyus", "");
    }

    public void b(String str) {
        this.f40273b.putString("xyusec", str);
        this.f40273b.commit();
    }

    public String c() {
        return this.f40272a.getString("xyusec", "");
    }
}
