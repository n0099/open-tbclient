package d.a.i0.u.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class g implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f48331a;

    public g(Context context) {
        this.f48331a = context.getApplicationContext();
    }

    @Override // d.a.i0.u.c.b
    public boolean a() {
        return TextUtils.isEmpty(get());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.u.c.b
    /* renamed from: b */
    public String get() {
        return c();
    }

    public final String c() {
        if (d.a.i0.u.d.c.a(this.f48331a, "android.permission.WRITE_SETTINGS")) {
            try {
                return Settings.System.getString(this.f48331a.getContentResolver(), "com.baidu.uuid");
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.u.c.b
    /* renamed from: d */
    public void put(String str) {
        e(str);
    }

    public final void e(String str) {
        if (d.a.i0.u.d.c.a(this.f48331a, "android.permission.WRITE_SETTINGS")) {
            try {
                Settings.System.putString(this.f48331a.getContentResolver(), "com.baidu.uuid", str);
            } catch (Exception unused) {
            }
        }
    }
}
