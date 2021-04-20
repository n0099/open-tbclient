package d.c.d.b.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.c.d.b.l;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f66695a;

    /* renamed from: b  reason: collision with root package name */
    public d.c.d.b.g f66696b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f66697c;

    public b(@NonNull Context context, @NonNull d.c.d.b.g gVar) {
        this.f66695a = context;
        this.f66696b = gVar;
    }

    public static boolean b(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    @Nullable
    public Map<String, Object> a() {
        Map<String, Object> a2 = this.f66696b.a();
        if (a2 == null) {
            a2 = new HashMap<>(4);
        }
        if (b(a2)) {
            try {
                PackageInfo packageInfo = this.f66695a.getPackageManager().getPackageInfo(this.f66695a.getPackageName(), 128);
                a2.put("version_name", packageInfo.versionName);
                a2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (a2.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = a2.get("version_code");
                    }
                    a2.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                a2.put("version_name", l.b.l(this.f66695a));
                a2.put("version_code", Integer.valueOf(l.b.m(this.f66695a)));
                if (a2.get("update_version_code") == null) {
                    a2.put("update_version_code", a2.get("version_code"));
                }
            }
        }
        return a2;
    }

    @Nullable
    public Map<String, Object> c() {
        if (this.f66697c == null) {
            this.f66697c = this.f66696b.g();
        }
        return this.f66697c;
    }

    @NonNull
    public d.c.d.b.g d() {
        return this.f66696b;
    }

    public String e() {
        return l.b.k(this.f66695a);
    }

    public String f() {
        return this.f66696b.b();
    }
}
