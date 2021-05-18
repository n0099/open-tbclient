package d.a.i0.a.v2;

import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45176a = d.a.i0.a.k.f43025a;

    public static JSONObject a(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", str);
        jSONObject.put("swan", str2);
        jSONObject.put("type", AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA);
        jSONObject.put("error", str3);
        return jSONObject;
    }

    public static JSONObject b(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext", a(str, str2, str3));
            jSONObject.put(IAdRequestParam.OS, "android");
            jSONObject.put("type", CommonTbJsBridge.GET_APIS);
            jSONObject.put("from", "swan");
        } catch (JSONException e2) {
            if (f45176a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void c(@Nullable String str) {
        String str2;
        try {
            str2 = d.a.i0.a.h0.u.g.N().V().swanCoreVersionName;
        } catch (Exception e2) {
            if (f45176a) {
                e2.printStackTrace();
            }
            str2 = "";
        }
        if (str == null) {
            str = "";
        }
        d.a.i0.a.j2.b.k("1087", b("2", str2, str));
    }

    public static void d() {
        String str;
        try {
            str = d.a.i0.a.h0.u.g.N().V().swanCoreVersionName;
        } catch (Exception e2) {
            if (f45176a) {
                e2.printStackTrace();
            }
            str = "";
        }
        d.a.i0.a.j2.b.k("1087", b("1", str, ""));
    }
}
