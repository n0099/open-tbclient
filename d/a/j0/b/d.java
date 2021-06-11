package d.a.j0.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f43953a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f43954b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43955c;

    public d(Context context) {
        try {
            this.f43955c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f43953a = sharedPreferences;
            this.f43954b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public String a() {
        return this.f43953a.getString("xyus", "");
    }

    public void b(String str) {
        this.f43954b.putString("xyusec", str);
        this.f43954b.commit();
    }

    public String c() {
        return this.f43953a.getString("xyusec", "");
    }
}
