package d.r.b.a.a.j.d.e;

import com.baidu.android.imsdk.db.TableDefine;
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
    public long f67283b;

    /* renamed from: c  reason: collision with root package name */
    public String f67284c;

    /* renamed from: d  reason: collision with root package name */
    public String f67285d;

    /* renamed from: e  reason: collision with root package name */
    public int f67286e;

    /* renamed from: f  reason: collision with root package name */
    public String f67287f;

    /* renamed from: g  reason: collision with root package name */
    public int f67288g;

    /* renamed from: h  reason: collision with root package name */
    public d.r.b.a.a.i.c.h f67289h;

    /* renamed from: a  reason: collision with root package name */
    public int f67282a = 2021;

    /* renamed from: i  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.j> f67290i = new ArrayList();
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
                eVar.f67075a = optJSONObject.optInt("offers_currency_type");
                eVar.f67076b = optJSONObject.optLong("offers_currency_amount");
                eVar.f67077c = optJSONObject.optString("offers_currency_name");
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
                gVar.f67091a = optJSONObject.optString("id");
                gVar.f67092b = optJSONObject.optString("name");
                gVar.f67094d = optJSONObject.optString("payChannel");
                gVar.f67093c = optJSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
                gVar.f67095e = optJSONObject.optString("payMethod");
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
                jVar.f67103a = optJSONObject.optInt(IAdRequestParam.CELL_ID);
                jVar.f67104b = optJSONObject.optString("offersTips");
                jVar.f67105c = optJSONObject.optString("name");
                jVar.f67106d = optJSONObject.optInt("level");
                jVar.f67107e = Double.valueOf(optJSONObject.optDouble("srcAmount"));
                jVar.f67108f = optJSONObject.optString("srcCurrencySymbol");
                jVar.f67109g = optJSONObject.optLong("destAmount");
                jVar.f67110h = optJSONObject.optInt("offersType");
                jVar.f67111i = optJSONObject.optInt("offersRate");
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
                kVar.f67112a = optJSONObject.optInt(PersonalBackgroundPreviewActivityConfig.PROPID);
                kVar.f67113b = optJSONObject.optInt("count");
                kVar.f67114c = optJSONObject.optInt("type");
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
                if (this.f67282a == optInt) {
                    this.f67288g = jSONObject.optInt("result");
                    this.f67283b = jSONObject.optLong("uid");
                    this.f67284c = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f67285d = jSONObject.optString("expand");
                    this.f67286e = jSONObject.optInt("currencyType");
                    this.f67287f = jSONObject.optString("currencyName");
                    this.f67289h = new d.r.b.a.a.i.c.h();
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(com.alipay.sdk.sys.a.j));
                    this.f67289h.f67097b = jSONObject2.optString("payChargeAmountLimit");
                    this.f67289h.f67098c = jSONObject2.optString("customerServiceMsg");
                    this.f67289h.f67096a = jSONObject2.optInt("payChargeAmountLimit");
                    this.f67289h.f67099d = jSONObject2.optString("successMsg");
                    this.f67290i.addAll(c(jSONObject.optJSONArray("confList")));
                    this.j.addAll(b(jSONObject.optJSONArray("payWayList")));
                    return;
                }
                throw new Exception(this.f67282a + " != " + optInt);
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
        return "GetChargeCurrencyConfigResponse{cmd=" + this.f67282a + ", uid=" + this.f67283b + ", seq='" + this.f67284c + "', expand='" + this.f67285d + "', currencyType=" + this.f67286e + ", confList=" + this.f67290i + '}';
    }
}
