package d.a.g0.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f40766a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f40767b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40768c;

    public d(Context context) {
        try {
            this.f40768c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f40766a = sharedPreferences;
            this.f40767b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }

    public String a() {
        return this.f40766a.getString("xyus", "");
    }

    public void b(String str) {
        this.f40767b.putString("xyusec", str);
        this.f40767b.commit();
    }

    public String c() {
        return this.f40766a.getString("xyusec", "");
    }
}
