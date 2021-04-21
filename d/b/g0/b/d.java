package d.b.g0.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f43521a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f43522b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43523c;

    public d(Context context) {
        try {
            this.f43523c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f43521a = sharedPreferences;
            this.f43522b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
    }

    public String a() {
        return this.f43521a.getString("xyus", "");
    }

    public void b(String str) {
        this.f43522b.putString("xyusec", str);
        this.f43522b.commit();
    }

    public String c() {
        return this.f43521a.getString("xyusec", "");
    }
}
