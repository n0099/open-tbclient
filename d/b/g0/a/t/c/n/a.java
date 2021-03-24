package d.b.g0.a.t.c.n;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.PushManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.t.b.d {
    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b q(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-CheckAppInstall", "start check app install");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-CheckAppInstall", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-CheckAppInstall", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("name");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.g("Api-CheckAppInstall", "packageName empty");
            return new d.b.g0.a.t.e.b(201, "parameter error");
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = h().getPackageManager().getPackageInfo(optString, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            d.b.g0.a.c0.c.c("Api-CheckAppInstall", e2.getMessage(), e2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (packageInfo != null) {
                jSONObject.put("hasApp", true);
                jSONObject.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                jSONObject.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
            } else {
                jSONObject.put("hasApp", false);
            }
            return new d.b.g0.a.t.e.b(0, "success", jSONObject);
        } catch (JSONException e3) {
            d.b.g0.a.c0.c.c("Api-CheckAppInstall", e3.getMessage(), e3);
            return new d.b.g0.a.t.e.b(1001, e3.getMessage());
        }
    }
}
