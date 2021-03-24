package d.b.i0.p0.y1;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.adp.lib.util.BdLog;
import d.b.h0.r.y.l;
import d.b.h0.r.y.n;
import d.b.h0.r.y.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends n {
    public e(l lVar) {
        super(lVar);
    }

    @o(isAsync = false, value = "isGameInstall")
    private JSONObject isGameInstall(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        String optString = jSONObject.optString("packagename");
        try {
            PackageInfo packageInfo = b().getPackageManager().getPackageInfo(optString, 0);
            if (packageInfo != null && packageInfo.packageName.equals(optString)) {
                jSONObject2.put("isInstall", true);
            } else {
                jSONObject2.put("isInstall", false);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            try {
                jSONObject2.put("isInstall", false);
            } catch (JSONException unused) {
                BdLog.e(e2.getMessage());
            }
        } catch (JSONException e3) {
            BdLog.e(e3.getMessage());
        }
        return jSONObject2;
    }

    @Override // d.b.h0.r.y.n
    public String g() {
        return "TBHY_COMMON_IS_GAME_INSTALL";
    }
}
