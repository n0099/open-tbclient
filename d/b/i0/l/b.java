package d.b.i0.l;

import android.os.Build;
import com.baidu.apollon.statistics.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.b.c.e.p.j;
import d.b.i0.r.y.l;
import d.b.i0.r.y.n;
import d.b.i0.r.y.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends n {
    public b(l lVar) {
        super(lVar);
    }

    @o(isAsync = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        String cuid = TbadkCoreApplication.getInst().getCuid();
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        int k = d.b.c.e.p.l.k(b());
        int i = d.b.c.e.p.l.i(b());
        String str3 = String.valueOf(k) + "," + String.valueOf(i);
        String versionName = TbadkCoreApplication.getInst().getVersionName();
        try {
            jSONObject.put("systemName", "android");
            jSONObject.put("systemVersion", str);
            jSONObject.put("model", str2);
            jSONObject.put("cuid", cuid);
            jSONObject.put("resolution", str3);
            jSONObject.put("appVersion", versionName);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @o(isAsync = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        int i;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (j.H()) {
            i = 1;
            str = CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
        } else if (j.t()) {
            i = 3;
            str = "2G";
        } else if (j.u()) {
            i = 4;
            str = g.f3909b;
        } else if (j.v()) {
            i = 5;
            str = "4G";
        } else {
            i = 0;
            str = "NotReachable";
        }
        try {
            jSONObject.put("netStatus", i);
            jSONObject.put("netDesc", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @o(isAsync = false, value = "showToast")
    private void showToast(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        BdToast.c(b(), jSONObject.optString("message")).q();
    }

    @Override // d.b.i0.r.y.n
    public String g() {
        return "TBHY_COMMON_Utils";
    }
}
