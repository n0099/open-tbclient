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
    public int f68056e;

    /* renamed from: a  reason: collision with root package name */
    public int f68052a = 2068;

    /* renamed from: b  reason: collision with root package name */
    public String f68053b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f68054c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f68055d = "";

    /* renamed from: f  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.n> f68057f = new ArrayList();

    public w(String str) {
        e(str);
    }

    public final String a() {
        return this.f68055d;
    }

    public final GetUserYbDetailsResult b() {
        return new GetUserYbDetailsResult(this.f68054c, this.f68056e, this.f68057f);
    }

    public final int c() {
        return this.f68054c;
    }

    public final String d() {
        return this.f68053b;
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
            if (this.f68052a == optInt) {
                jSONObject.optLong("uid");
                String optString = jSONObject.optString(IAdRequestParam.SEQ);
                Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(\"seq\")");
                this.f68053b = optString;
                this.f68054c = jSONObject.optInt("result");
                String optString2 = jSONObject.optString("message");
                Intrinsics.checkExpressionValueIsNotNull(optString2, "jsonObject.optString(\"message\")");
                this.f68055d = optString2;
                jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                jSONObject.optInt("usedChannel");
                Intrinsics.checkExpressionValueIsNotNull(jSONObject.optString("expand"), "jsonObject.optString(\"expand\")");
                this.f68056e = jSONObject.optInt("total");
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
                            nVar.f67807g = optJSONObject.optString("balance");
                            nVar.f67801a = optJSONObject.optString("comment");
                            nVar.f67802b = optJSONObject.optString("date");
                            nVar.f67809i = optJSONObject.optString("income");
                            nVar.f67808h = optJSONObject.optString("moneyType");
                            nVar.f67804d = optJSONObject.optString("other");
                            nVar.j = optJSONObject.optString("outgo");
                            nVar.f67806f = optJSONObject.optString("tips");
                            nVar.f67805e = optJSONObject.optString("tradeType");
                            nVar.f67803c = optJSONObject.optString("status");
                            this.f68057f.add(nVar);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new Exception(String.valueOf(this.f68052a) + " != " + optInt);
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserYbDetailsResponsee", "parserResponse error.", e2);
        } catch (Exception e3) {
            d.r.b.a.a.f.d.d.d("GetUserYbDetailsResponsee", "parserResponse error.", e3);
        }
    }
}
