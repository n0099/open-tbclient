package d.a.j0.g2.e;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f54552a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f54553b = 0;

    public int a() {
        return this.f54553b;
    }

    public int b() {
        return this.f54552a;
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f54552a = jSONObject.optInt("error_code", -1);
            jSONObject.optString("error_msg", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.f54553b = optJSONObject.optInt("msg_count");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
