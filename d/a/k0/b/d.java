package d.a.k0.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f44093a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f44094b;

    /* renamed from: c  reason: collision with root package name */
    public Context f44095c;

    public d(Context context) {
        try {
            this.f44095c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f44093a = sharedPreferences;
            this.f44094b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
        }
    }

    public String a() {
        return this.f44093a.getString("xyus", "");
    }

    public void b(String str) {
        this.f44094b.putString("xyusec", str);
        this.f44094b.commit();
    }

    public String c() {
        return this.f44093a.getString("xyusec", "");
    }
}
