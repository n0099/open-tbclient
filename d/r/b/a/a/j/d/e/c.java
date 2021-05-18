package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f67925a;

    public c(String str) {
        a(str);
    }

    public void a(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f67925a = jSONObject.optInt("cmd");
                jSONObject.optInt("appid");
                jSONObject.optLong("uid");
                jSONObject.optString(IAdRequestParam.SEQ);
                d.r.b.a.a.f.d.d.g("ErrorResponse", "jsonObject", jSONObject);
                return;
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("ErrorResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("ErrorResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("ErrorResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
