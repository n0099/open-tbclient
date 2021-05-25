package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class w {

    /* renamed from: e  reason: collision with root package name */
    public int f68099e;

    /* renamed from: a  reason: collision with root package name */
    public int f68095a = 2068;

    /* renamed from: b  reason: collision with root package name */
    public String f68096b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f68097c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f68098d = "";

    /* renamed from: f  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.n> f68100f = new ArrayList();

    public w(String str) {
        e(str);
    }

    public final String a() {
        return this.f68098d;
    }

    public final GetUserYbDetailsResult b() {
        return new GetUserYbDetailsResult(this.f68097c, this.f68099e, this.f68100f);
    }

    public final int c() {
        return this.f68097c;
    }

    public final String d() {
        return this.f68096b;
    }

    public void e(String str) {
        boolean z = true;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean z3 = str.charAt(!z2 ? i2 : length) <= ' ';
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i2++;
            } else {
                z2 = true;
            }
        }
        if (Intrinsics.areEqual("", str.subSequence(i2, length + 1).toString())) {
            d.r.b.a.a.f.d.d.e("GetUserYbDetailsResponsee", "parserResponse error, jsonMsg is empty.", new Object[0]);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("cmd");
            if (this.f68095a == optInt) {
                jSONObject.optLong("uid");
                String optString = jSONObject.optString(IAdRequestParam.SEQ);
                Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(\"seq\")");
                this.f68096b = optString;
                this.f68097c = jSONObject.optInt("result");
                String optString2 = jSONObject.optString("message");
                Intrinsics.checkExpressionValueIsNotNull(optString2, "jsonObject.optString(\"message\")");
                this.f68098d = optString2;
                jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                jSONObject.optInt("usedChannel");
                Intrinsics.checkExpressionValueIsNotNull(jSONObject.optString("expand"), "jsonObject.optString(\"expand\")");
                this.f68099e = jSONObject.optInt("total");
                JSONArray optJSONArray = jSONObject.optJSONArray("dataList");
                if (optJSONArray != null) {
                    if (optJSONArray.length() <= 0) {
                        z = false;
                    }
                    if (!z) {
                        optJSONArray = null;
                    }
                    if (optJSONArray != null) {
                        int length2 = optJSONArray.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                            d.r.b.a.a.i.c.n nVar = new d.r.b.a.a.i.c.n();
                            nVar.f67850g = optJSONObject.optString("balance");
                            nVar.f67844a = optJSONObject.optString("comment");
                            nVar.f67845b = optJSONObject.optString("date");
                            nVar.f67852i = optJSONObject.optString("income");
                            nVar.f67851h = optJSONObject.optString("moneyType");
                            nVar.f67847d = optJSONObject.optString("other");
                            nVar.j = optJSONObject.optString("outgo");
                            nVar.f67849f = optJSONObject.optString("tips");
                            nVar.f67848e = optJSONObject.optString("tradeType");
                            nVar.f67846c = optJSONObject.optString("status");
                            this.f68100f.add(nVar);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new Exception(String.valueOf(this.f68095a) + " != " + optInt);
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserYbDetailsResponsee", "parserResponse error.", e2);
        } catch (Exception e3) {
            d.r.b.a.a.f.d.d.d("GetUserYbDetailsResponsee", "parserResponse error.", e3);
        }
    }
}
