package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.r.b.a.a.i.c.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public String f67340a;

    /* renamed from: b  reason: collision with root package name */
    public int f67341b;

    /* renamed from: c  reason: collision with root package name */
    public String f67342c;

    /* renamed from: d  reason: collision with root package name */
    public long f67343d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, f.a> f67344e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, f.b> f67345f;

    public s(String str) {
        a(str);
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f67340a = jSONObject.optString(IAdRequestParam.SEQ, "");
            jSONObject.optLong("uid", 0L);
            this.f67341b = jSONObject.optInt("result", 0);
            this.f67342c = jSONObject.optString("message", "");
            this.f67343d = jSONObject.optLong("minAmountLimit", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("accountList");
            this.f67344e = new HashMap();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        f.a aVar = new f.a();
                        aVar.f67081a = optJSONObject.optInt("currencyType", 0);
                        aVar.f67082b = optJSONObject.optLong("amount", 0L);
                        aVar.f67083c = optJSONObject.optLong("freezed", 0L);
                        aVar.f67084d = optJSONObject.optInt("accountFrozen", 0);
                        this.f67344e.put(Integer.valueOf(aVar.f67081a), aVar);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("accountPeriodList");
            this.f67345f = new HashMap();
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    f.b bVar = new f.b();
                    bVar.f67087a = optJSONObject2.optInt("currencyType", 0);
                    bVar.f67088b = optJSONObject2.optInt("amount", 0);
                    bVar.f67089c = optJSONObject2.optLong("startTime", 0L);
                    bVar.f67090d = optJSONObject2.optLong("endTime", 0L);
                    this.f67345f.put(Integer.valueOf(bVar.f67087a), bVar);
                }
            }
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserAccountResponse", "parserResponse error.", e2);
        }
    }
}
