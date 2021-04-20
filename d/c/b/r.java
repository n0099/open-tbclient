package d.c.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65906e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65907f;

    public r(Context context, i iVar) {
        super(false, false);
        this.f65906e = context;
        this.f65907f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        int i;
        int i2;
        String packageName = this.f65906e.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f65907f.p())) {
            jSONObject.put("package", packageName);
        } else {
            if (r0.f65909b) {
                r0.a("has zijie pkg", null);
            }
            jSONObject.put("package", this.f65907f.p());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.f65906e.getPackageManager().getPackageInfo(packageName, 0);
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
        if (!TextUtils.isEmpty(this.f65907f.g())) {
            jSONObject.put("app_version", this.f65907f.g());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.f65907f.l())) {
            jSONObject.put("app_version_minor", this.f65907f.l());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.f65907f.d() != 0) {
            jSONObject.put("version_code", this.f65907f.d());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.f65907f.e() != 0) {
            jSONObject.put("update_version_code", this.f65907f.e());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.f65907f.f() != 0) {
            jSONObject.put("manifest_version_code", this.f65907f.f());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.f65907f.c())) {
            jSONObject.put(DpStatConstants.KEY_APP_NAME, this.f65907f.c());
        }
        if (!TextUtils.isEmpty(this.f65907f.h())) {
            jSONObject.put("tweaked_channel", this.f65907f.h());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i2 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.f65906e.getString(i2));
        return true;
    }
}
