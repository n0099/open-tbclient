package d.b.h0.f.f.c;

import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48498c = k.f45772a;

    public d() {
        super("getAppList");
    }

    @Override // d.b.h0.f.i.a
    public d.b.h0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.b.h0.a.p0.b bVar) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", c());
            if (f48498c) {
                Log.i("GetAppListAction", jSONObject2.toString());
            }
        } catch (JSONException e2) {
            if (f48498c) {
                e2.printStackTrace();
            }
        }
        bVar.a(jSONObject2);
        return null;
    }

    public final JSONObject b(PackageInfo packageInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appName", packageInfo.applicationInfo.name);
        jSONObject.put("appPackageName", packageInfo.packageName);
        jSONObject.put("appVersion", packageInfo.versionName);
        jSONObject.put("appIsSystemApp", (packageInfo.applicationInfo.flags & 1) != 0);
        return jSONObject;
    }

    public final JSONArray c() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (PackageInfo packageInfo : AppRuntime.getAppContext().getPackageManager().getInstalledPackages(1)) {
            jSONArray.put(b(packageInfo));
        }
        return jSONArray;
    }
}
