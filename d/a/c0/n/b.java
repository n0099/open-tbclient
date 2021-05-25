package d.a.c0.n;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static String a(int i2, String str, String str2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str2)) {
            str3 = "statecode={" + i2 + "};order_no={" + str + "};notify=" + str2;
        } else {
            str3 = "statecode={" + i2 + "};order_no={" + str + "};notify={" + str2 + "}";
        }
        try {
            jSONObject.put("statusCode", i2);
            jSONObject.put("statusMsg", str2);
            jSONObject.put("responseData", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
