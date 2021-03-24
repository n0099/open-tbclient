package d.b.f0.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f42831a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f42832b;

    /* renamed from: c  reason: collision with root package name */
    public Context f42833c;

    public d(Context context) {
        try {
            this.f42833c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f42831a = sharedPreferences;
            this.f42832b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public String a() {
        return this.f42831a.getString("xyus", "");
    }

    public void b(String str) {
        this.f42832b.putString("xyusec", str);
        this.f42832b.commit();
    }

    public String c() {
        return this.f42831a.getString("xyusec", "");
    }
}
