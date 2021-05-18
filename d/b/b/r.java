package d.b.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.tieba.service.AsInstallService;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65046e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65047f;

    public r(Context context, i iVar) {
        super(false, false);
        this.f65046e = context;
        this.f65047f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        int i2;
        int i3;
        String packageName = this.f65046e.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f65047f.p())) {
            jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, packageName);
        } else {
            if (r0.f65049b) {
                r0.a("has zijie pkg", null);
            }
            jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, this.f65047f.p());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.f65046e.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i2 = packageInfo.versionCode;
            } catch (Throwable th) {
                r0.b(th);
                return false;
            }
        } else {
            i2 = 0;
        }
        if (!TextUtils.isEmpty(this.f65047f.g())) {
            jSONObject.put("app_version", this.f65047f.g());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.f65047f.l())) {
            jSONObject.put("app_version_minor", this.f65047f.l());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.f65047f.d() != 0) {
            jSONObject.put("version_code", this.f65047f.d());
        } else {
            jSONObject.put("version_code", i2);
        }
        if (this.f65047f.e() != 0) {
            jSONObject.put("update_version_code", this.f65047f.e());
        } else {
            jSONObject.put("update_version_code", i2);
        }
        if (this.f65047f.f() != 0) {
            jSONObject.put("manifest_version_code", this.f65047f.f());
        } else {
            jSONObject.put("manifest_version_code", i2);
        }
        if (!TextUtils.isEmpty(this.f65047f.c())) {
            jSONObject.put("app_name", this.f65047f.c());
        }
        if (!TextUtils.isEmpty(this.f65047f.h())) {
            jSONObject.put("tweaked_channel", this.f65047f.h());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i3 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.f65046e.getString(i3));
        return true;
    }
}
