package d.a.h0.f.f.c;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.heytap.mcssdk.PushManager;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45957c = k.f43101a;

    public c() {
        super("checkAppInstalled");
    }

    @Override // d.a.h0.f.i.a
    public d.a.h0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.a.h0.a.p0.b bVar) {
        if (f45957c) {
            Log.d("checkAppInstalled", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(31010, "package name is empty");
            return null;
        }
        try {
            PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(optString, 0);
            if (f45957c) {
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
