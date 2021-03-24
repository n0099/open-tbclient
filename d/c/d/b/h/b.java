package d.c.d.b.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.c.d.b.l;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f65849a;

    /* renamed from: b  reason: collision with root package name */
    public d.c.d.b.g f65850b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f65851c;

    public b(@NonNull Context context, @NonNull d.c.d.b.g gVar) {
        this.f65849a = context;
        this.f65850b = gVar;
    }

    public static boolean b(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    @Nullable
    public Map<String, Object> a() {
        Map<String, Object> a2 = this.f65850b.a();
        if (a2 == null) {
            a2 = new HashMap<>(4);
        }
        if (b(a2)) {
            try {
                PackageInfo packageInfo = this.f65849a.getPackageManager().getPackageInfo(this.f65849a.getPackageName(), 128);
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
                a2.put("version_name", l.b.l(this.f65849a));
                a2.put("version_code", Integer.valueOf(l.b.m(this.f65849a)));
                if (a2.get("update_version_code") == null) {
                    a2.put("update_version_code", a2.get("version_code"));
                }
            }
        }
        return a2;
    }

    @Nullable
    public Map<String, Object> c() {
        if (this.f65851c == null) {
            this.f65851c = this.f65850b.g();
        }
        return this.f65851c;
    }

    @NonNull
    public d.c.d.b.g d() {
        return this.f65850b;
    }

    public String e() {
        return l.b.k(this.f65849a);
    }

    public String f() {
        return this.f65850b.b();
    }
}
