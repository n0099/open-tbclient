package d.b.f0.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f42832a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f42833b;

    /* renamed from: c  reason: collision with root package name */
    public Context f42834c;

    public d(Context context) {
        try {
            this.f42834c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f42832a = sharedPreferences;
            this.f42833b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public String a() {
        return this.f42832a.getString("xyus", "");
    }

    public void b(String str) {
        this.f42833b.putString("xyusec", str);
        this.f42833b.commit();
    }

    public String c() {
        return this.f42832a.getString("xyusec", "");
    }
}
