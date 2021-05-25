package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: b  reason: collision with root package name */
    public long f68012b;

    /* renamed from: c  reason: collision with root package name */
    public String f68013c;

    /* renamed from: d  reason: collision with root package name */
    public String f68014d;

    /* renamed from: e  reason: collision with root package name */
    public int f68015e;

    /* renamed from: f  reason: collision with root package name */
    public String f68016f;

    /* renamed from: g  reason: collision with root package name */
    public int f68017g;

    /* renamed from: h  reason: collision with root package name */
    public d.r.b.a.a.i.c.h f68018h;

    /* renamed from: a  reason: collision with root package name */
    public int f68011a = 2021;

    /* renamed from: i  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.j> f68019i = new ArrayList();
    public List<d.r.b.a.a.i.c.g> j = new ArrayList();

    public k(String str) {
        e(str);
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
                eVar.f67804a = optJSONObject.optInt("offers_currency_type");
                eVar.f67805b = optJSONObject.optLong("offers_currency_amount");
                eVar.f67806c = optJSONObject.optString("offers_currency_name");
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    public List<d.r.b.a.a.i.c.g> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.g gVar = new d.r.b.a.a.i.c.g();
                gVar.f67820a = optJSONObject.optString("id");
                gVar.f67821b = optJSONObject.optString("name");
                gVar.f67823d = optJSONObject.optString("payChannel");
                gVar.f67822c = optJSONObject.optString("tips");
                gVar.f67824e = optJSONObject.optString("payMethod");
                arrayList.add(gVar);
            }
        }
        return arrayList;
    }

    public List<d.r.b.a.a.i.c.j> c(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.j jVar = new d.r.b.a.a.i.c.j();
                jVar.f67832a = optJSONObject.optInt(IAdRequestParam.CELL_ID);
                jVar.f67833b = optJSONObject.optString("offersTips");
                jVar.f67834c = optJSONObject.optString("name");
                jVar.f67835d = optJSONObject.optInt("level");
                jVar.f67836e = Double.valueOf(optJSONObject.optDouble("srcAmount"));
                jVar.f67837f = optJSONObject.optString("srcCurrencySymbol");
                jVar.f67838g = optJSONObject.optLong("destAmount");
                jVar.f67839h = optJSONObject.optInt("offersType");
                jVar.f67840i = optJSONObject.optInt("offersRate");
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
                jVar.y.addAll(d(optJSONObject.optJSONArray("props")));
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

    public final List<d.r.b.a.a.i.c.k> d(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.k kVar = new d.r.b.a.a.i.c.k();
                kVar.f67841a = optJSONObject.optInt(PersonalBackgroundPreviewActivityConfig.PROPID);
                kVar.f67842b = optJSONObject.optInt("count");
                kVar.f67843c = optJSONObject.optInt("type");
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    public void e(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f68011a == optInt) {
                    this.f68017g = jSONObject.optInt("result");
                    this.f68012b = jSONObject.optLong("uid");
                    this.f68013c = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f68014d = jSONObject.optString("expand");
                    this.f68015e = jSONObject.optInt("currencyType");
                    this.f68016f = jSONObject.optString("currencyName");
                    this.f68018h = new d.r.b.a.a.i.c.h();
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(com.alipay.sdk.sys.a.j));
                    this.f68018h.f67826b = jSONObject2.optString("payChargeAmountLimit");
                    this.f68018h.f67827c = jSONObject2.optString("customerServiceMsg");
                    this.f68018h.f67825a = jSONObject2.optInt("payChargeAmountLimit");
                    this.f68018h.f67828d = jSONObject2.optString("successMsg");
                    this.f68019i.addAll(c(jSONObject.optJSONArray("confList")));
                    this.j.addAll(b(jSONObject.optJSONArray("payWayList")));
                    return;
                }
                throw new Exception(this.f68011a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("GetChargeCurrencyConfigResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }

    public String toString() {
        return "GetChargeCurrencyConfigResponse{cmd=" + this.f68011a + ", uid=" + this.f68012b + ", seq='" + this.f68013c + "', expand='" + this.f68014d + "', currencyType=" + this.f68015e + ", confList=" + this.f68019i + '}';
    }
}
