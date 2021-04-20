package d.b.f0.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f43224a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f43225b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43226c;

    public d(Context context) {
        try {
            this.f43226c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f43224a = sharedPreferences;
            this.f43225b = sharedPreferences.edit();
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public String a() {
        return this.f43224a.getString("xyus", "");
    }

    public void b(String str) {
        this.f43225b.putString("xyusec", str);
        this.f43225b.commit();
    }

    public String c() {
        return this.f43224a.getString("xyusec", "");
    }
}
