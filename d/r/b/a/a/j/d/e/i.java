package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: b  reason: collision with root package name */
    public long f67957b;

    /* renamed from: c  reason: collision with root package name */
    public String f67958c;

    /* renamed from: d  reason: collision with root package name */
    public String f67959d;

    /* renamed from: e  reason: collision with root package name */
    public int f67960e;

    /* renamed from: a  reason: collision with root package name */
    public int f67956a = 2060;

    /* renamed from: f  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.j> f67961f = new ArrayList();

    public i(String str) {
        d(str);
    }

    public final List<d.r.b.a.a.i.c.e> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.e eVar = new d.r.b.a.a.i.c.e();
                eVar.f67761a = optJSONObject.optInt("offers_currency_type");
                eVar.f67762b = optJSONObject.optLong("offers_currency_amount");
                eVar.f67763c = optJSONObject.optString("offers_currency_name");
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    public List<d.r.b.a.a.i.c.j> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.j jVar = new d.r.b.a.a.i.c.j();
                jVar.f67789a = optJSONObject.optInt(IAdRequestParam.CELL_ID);
                jVar.f67790b = optJSONObject.optString("offersTips");
                jVar.f67791c = optJSONObject.optString("name");
                jVar.f67792d = optJSONObject.optInt("level");
                jVar.f67793e = Double.valueOf(optJSONObject.optDouble("srcAmount"));
                jVar.f67794f = optJSONObject.optString("srcCurrencySymbol");
                jVar.f67795g = optJSONObject.optLong("destAmount");
                jVar.f67796h = optJSONObject.optInt("offersType");
                jVar.f67797i = optJSONObject.optInt("offersRate");
                jVar.j = optJSONObject.optBoolean("offers_currency_same");
                jVar.l = optJSONObject.optString("offers_currency_name");
                jVar.k = optJSONObject.optInt("offers_currency_type");
                jVar.m = optJSONObject.optBoolean("hasAct");
                jVar.n = optJSONObject.optBoolean("hasCurrencyAct");
                jVar.o = optJSONObject.optBoolean("hasDestCurrencyAct");
                jVar.p = optJSONObject.optLong("spAmount");
                jVar.q = optJSONObject.optLong("spSumAmount");
                jVar.r = optJSONObject.optBoolean("hasOtherCurrencyAct");
                jVar.s = optJSONObject.optInt("otherCurrenciesSum");
                jVar.t.addAll(a(optJSONObject.optJSONArray("otherCurrencies")));
                jVar.u = optJSONObject.optBoolean("hasFirstRush");
                jVar.v = optJSONObject.optLong("firstRushAmount");
                jVar.w = optJSONObject.optBoolean("hasPropsAct");
                jVar.x = optJSONObject.optInt("propsSum");
                jVar.y.addAll(c(optJSONObject.optJSONArray("props")));
                jVar.z = Double.valueOf(optJSONObject.optDouble("chargeRate"));
                jVar.A = optJSONObject.optString("productId");
                jVar.B = optJSONObject.optString("expand");
                jVar.C = optJSONObject.optString("currencyCode");
                jVar.D = optJSONObject.optString("otherPrice");
                jVar.E = optJSONObject.optString("payChannel");
                jVar.F = optJSONObject.optString("payMethod");
                jVar.G = optJSONObject.optString("subChannel");
                jVar.H = optJSONObject.optString("payType");
                jVar.I = optJSONObject.optInt("usedChannelType");
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public final List<d.r.b.a.a.i.c.k> c(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.k kVar = new d.r.b.a.a.i.c.k();
                kVar.f67798a = optJSONObject.optInt(PersonalBackgroundPreviewActivityConfig.PROPID);
                kVar.f67799b = optJSONObject.optInt("count");
                kVar.f67800c = optJSONObject.optInt("type");
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    public void d(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f67956a == optInt) {
                    this.f67957b = jSONObject.optLong("uid");
                    this.f67958c = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f67959d = jSONObject.optString("expand");
                    this.f67960e = jSONObject.optInt("currencyType");
                    this.f67961f.addAll(b(jSONObject.optJSONArray("confList")));
                    return;
                }
                throw new Exception(this.f67956a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigChannelsResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigChannelsResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("GetChargeCurrencyConfigChannelsResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }

    public String toString() {
        return "GetChargeCurrencyConfigChannelsResponse{cmd=" + this.f67956a + ", uid=" + this.f67957b + ", seq='" + this.f67958c + "', expand='" + this.f67959d + "', currencyType=" + this.f67960e + ", confList=" + this.f67961f + '}';
    }
}
