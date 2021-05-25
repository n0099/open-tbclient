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
    public String f68059b;

    /* renamed from: c  reason: collision with root package name */
    public int f68060c;

    /* renamed from: d  reason: collision with root package name */
    public String f68061d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68063f;

    /* renamed from: a  reason: collision with root package name */
    public int f68058a = 2046;

    /* renamed from: e  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.l> f68062e = new ArrayList();

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
                if (this.f68058a == optInt) {
                    jSONObject.optLong("uid");
                    this.f68059b = jSONObject.optString(IAdRequestParam.SEQ);
                    jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    this.f68060c = jSONObject.optInt("result");
                    this.f68061d = jSONObject.optString("message");
                    this.f68062e.addAll(a(jSONObject.optJSONArray("userAccountHistoryInfos")));
                    this.f68063f = jSONObject.optBoolean("hasMore");
                    return;
                }
                throw new Exception(this.f68058a + " != " + optInt);
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
