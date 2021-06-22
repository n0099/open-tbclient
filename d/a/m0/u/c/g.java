package d.a.m0.u.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class g implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f52289a;

    public g(Context context) {
        this.f52289a = context.getApplicationContext();
    }

    @Override // d.a.m0.u.c.b
    public boolean a() {
        return TextUtils.isEmpty(get());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.u.c.b
    /* renamed from: b */
    public String get() {
        return c();
    }

    public final String c() {
        if (d.a.m0.u.d.c.a(this.f52289a, "android.permission.WRITE_SETTINGS")) {
            try {
                return Settings.System.getString(this.f52289a.getContentResolver(), "com.baidu.uuid");
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.u.c.b
    /* renamed from: d */
    public void put(String str) {
        e(str);
    }

    public final void e(String str) {
        if (d.a.m0.u.d.c.a(this.f52289a, "android.permission.WRITE_SETTINGS")) {
            try {
                Settings.System.putString(this.f52289a.getContentResolver(), "com.baidu.uuid", str);
            } catch (Exception unused) {
            }
        }
    }
}
