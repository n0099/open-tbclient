package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q {

    /* renamed from: b  reason: collision with root package name */
    public String f67330b;

    /* renamed from: c  reason: collision with root package name */
    public int f67331c;

    /* renamed from: d  reason: collision with root package name */
    public String f67332d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67334f;

    /* renamed from: a  reason: collision with root package name */
    public int f67329a = 2046;

    /* renamed from: e  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.l> f67333e = new ArrayList();

    public q(String str) {
        b(str);
    }

    public final List<d.r.b.a.a.i.c.l> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.l lVar = new d.r.b.a.a.i.c.l();
                optJSONObject.optInt("id");
                optJSONObject.optLong("uid");
                optJSONObject.optLong("currencyType");
                optJSONObject.optLong("amountChange");
                optJSONObject.optLong("amountRemain");
                optJSONObject.optLong("freezedChange");
                optJSONObject.optLong("freezedRemain");
                optJSONObject.optInt("optType");
                optJSONObject.optLong("optTime");
                optJSONObject.optString("optName");
                optJSONObject.optString("description");
                arrayList.add(lVar);
            }
        }
        return arrayList;
    }

    public void b(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f67329a == optInt) {
                    jSONObject.optLong("uid");
                    this.f67330b = jSONObject.optString(IAdRequestParam.SEQ);
                    jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    this.f67331c = jSONObject.optInt("result");
                    this.f67332d = jSONObject.optString("message");
                    this.f67333e.addAll(a(jSONObject.optJSONArray("userAccountHistoryInfos")));
                    this.f67334f = jSONObject.optBoolean("hasMore");
                    return;
                }
                throw new Exception(this.f67329a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("GetUserAccountHistoryResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("GetUserAccountHistoryResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("GetUserAccountHistoryResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
