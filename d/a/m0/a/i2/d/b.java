package d.a.m0.a.i2.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f46811b = new JSONArray();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (a.f46810a) {
                Log.d("LaunchTraceCollector", "event is empty");
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionId", str);
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject.put("info", str2);
            b(jSONObject);
        } catch (JSONException e2) {
            if (a.f46810a) {
                Log.w("LaunchTraceCollector", Log.getStackTraceString(e2));
            }
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f46811b.put(jSONObject);
        }
    }

    public void c() {
        this.f46811b = new JSONArray();
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("launchLog", this.f46811b);
        } catch (JSONException e2) {
            if (a.f46810a) {
                Log.e("LaunchTraceCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
