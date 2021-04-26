package d.a.h0.q.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class g implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f47601a;

    public g(Context context) {
        if (context != null) {
            this.f47601a = context.getApplicationContext();
            return;
        }
        throw new RuntimeException("context can not be null");
    }

    @Override // d.a.h0.q.c.b
    public boolean a() {
        return TextUtils.isEmpty(get());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.q.c.b
    /* renamed from: b */
    public String get() {
        return c();
    }

    public final String c() {
        if (d.a.h0.q.d.c.a(this.f47601a, "android.permission.WRITE_SETTINGS")) {
            try {
                return Settings.System.getString(this.f47601a.getContentResolver(), "com.baidu.uuid");
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.q.c.b
    /* renamed from: d */
    public void put(String str) {
        e(str);
    }

    public final void e(String str) {
        if (d.a.h0.q.d.c.a(this.f47601a, "android.permission.WRITE_SETTINGS")) {
            try {
                Settings.System.putString(this.f47601a.getContentResolver(), "com.baidu.uuid", str);
            } catch (Exception unused) {
            }
        }
    }
}
