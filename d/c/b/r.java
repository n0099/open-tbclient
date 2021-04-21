package d.c.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f66001e;

    /* renamed from: f  reason: collision with root package name */
    public final i f66002f;

    public r(Context context, i iVar) {
        super(false, false);
        this.f66001e = context;
        this.f66002f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        int i;
        int i2;
        String packageName = this.f66001e.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f66002f.p())) {
            jSONObject.put("package", packageName);
        } else {
            if (r0.f66004b) {
                r0.a("has zijie pkg", null);
            }
            jSONObject.put("package", this.f66002f.p());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.f66001e.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                r0.b(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.f66002f.g())) {
            jSONObject.put("app_version", this.f66002f.g());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.f66002f.l())) {
            jSONObject.put("app_version_minor", this.f66002f.l());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.f66002f.d() != 0) {
            jSONObject.put("version_code", this.f66002f.d());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.f66002f.e() != 0) {
            jSONObject.put("update_version_code", this.f66002f.e());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.f66002f.f() != 0) {
            jSONObject.put("manifest_version_code", this.f66002f.f());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.f66002f.c())) {
            jSONObject.put(DpStatConstants.KEY_APP_NAME, this.f66002f.c());
        }
        if (!TextUtils.isEmpty(this.f66002f.h())) {
            jSONObject.put("tweaked_channel", this.f66002f.h());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i2 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.f66001e.getString(i2));
        return true;
    }
}
