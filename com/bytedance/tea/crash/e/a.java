package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f7635a;
    private Map<String, Object> c;
    private com.bytedance.tea.crash.d pwk;

    public a(@NonNull Context context, @NonNull com.bytedance.tea.crash.d dVar) {
        this.f7635a = context;
        this.pwk = dVar;
    }

    @Nullable
    public Map<String, Object> a() {
        Map<String, Object> a2 = this.pwk.a();
        if (a2 == null) {
            a2 = new HashMap<>(4);
        }
        if (a(a2)) {
            try {
                PackageInfo packageInfo = this.f7635a.getPackageManager().getPackageInfo(this.f7635a.getPackageName(), 128);
                a2.put(SharedPrefConfig.VERSION_NAME, packageInfo.versionName);
                a2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (a2.get("update_version_code") == null) {
                    Object obj = null;
                    if (packageInfo.applicationInfo.metaData != null) {
                        obj = packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE");
                    }
                    if (obj == null) {
                        obj = a2.get("version_code");
                    }
                    a2.put("update_version_code", obj);
                }
            } catch (Throwable th) {
                a2.put(SharedPrefConfig.VERSION_NAME, com.bytedance.tea.crash.g.a.e(this.f7635a));
                a2.put("version_code", Integer.valueOf(com.bytedance.tea.crash.g.a.f(this.f7635a)));
                if (a2.get("update_version_code") == null) {
                    a2.put("update_version_code", a2.get("version_code"));
                }
            }
        }
        return a2;
    }

    @Nullable
    public Map<String, Object> b() {
        if (this.c == null) {
            this.c = this.pwk.g();
        }
        return this.c;
    }

    public static boolean a(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey(SharedPrefConfig.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    @NonNull
    public com.bytedance.tea.crash.d erf() {
        return this.pwk;
    }

    public String d() {
        return com.bytedance.tea.crash.g.a.d(this.f7635a);
    }

    public String e() {
        return this.pwk.b();
    }
}
