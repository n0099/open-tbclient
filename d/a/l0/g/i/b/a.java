package d.a.l0.g.i.b;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50764c = k.f46875a;

    public a() {
        super("GetAppUseDuration");
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (f50764c) {
            Log.e("GetAppUseDuration", "params is " + jSONObject.toString());
        }
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(202, "params may be error");
        } else {
            b(optString, bVar);
        }
        return null;
    }

    public final void b(String str, @NonNull d.a.l0.a.u0.b bVar) {
        try {
            if (c()) {
                PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    List<UsageStats> queryUsageStats = ((UsageStatsManager) AppRuntime.getAppContext().getSystemService("usagestats")).queryUsageStats(3, packageInfo.firstInstallTime, Calendar.getInstance().getTimeInMillis());
                    if (queryUsageStats.size() == 0) {
                        bVar.onFail(101, "noPermission");
                        return;
                    }
                    for (UsageStats usageStats : queryUsageStats) {
                        if (TextUtils.equals(usageStats.getPackageName(), str)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("appUseDuration", usageStats.getTotalTimeInForeground());
                            jSONObject.put("data", jSONObject2);
                            bVar.a(jSONObject);
                            return;
                        }
                    }
                    bVar.onFail(31016, "no package info");
                    return;
                }
                bVar.onFail(31016, "no package info");
                return;
            }
            bVar.onFail(101, "noPermission");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            bVar.onFail(31011, "app is not installed");
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final boolean c() {
        return ((AppOpsManager) AppRuntime.getAppContext().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), AppRuntime.getAppContext().getPackageName()) == 0;
    }
}
