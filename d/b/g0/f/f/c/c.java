package d.b.g0.f.f.c;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.heytap.mcssdk.PushManager;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47776c = k.f45051a;

    public c() {
        super("checkAppInstalled");
    }

    @Override // d.b.g0.f.i.a
    public d.b.g0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        if (f47776c) {
            Log.d("checkAppInstalled", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME);
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(31010, "package name is empty");
            return null;
        }
        try {
            PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(optString, 0);
            if (f47776c) {
                Log.d("checkAppInstalled", "packageInfo: " + packageInfo);
            }
            if (packageInfo != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                jSONObject3.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
                jSONObject2.put("data", jSONObject3);
                bVar.a(jSONObject2);
            } else {
                bVar.onFail(31016, "no package info");
            }
        } catch (Exception unused) {
            bVar.onFail(31011, "app is not installed");
        }
        return null;
    }
}
