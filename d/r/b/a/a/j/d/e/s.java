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
    public String f68069a;

    /* renamed from: b  reason: collision with root package name */
    public int f68070b;

    /* renamed from: c  reason: collision with root package name */
    public String f68071c;

    /* renamed from: d  reason: collision with root package name */
    public long f68072d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, f.a> f68073e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, f.b> f68074f;

    public s(String str) {
        a(str);
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f68069a = jSONObject.optString(IAdRequestParam.SEQ, "");
            jSONObject.optLong("uid", 0L);
            this.f68070b = jSONObject.optInt("result", 0);
            this.f68071c = jSONObject.optString("message", "");
            this.f68072d = jSONObject.optLong("minAmountLimit", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("accountList");
            this.f68073e = new HashMap();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        f.a aVar = new f.a();
                        aVar.f67810a = optJSONObject.optInt("currencyType", 0);
                        aVar.f67811b = optJSONObject.optLong("amount", 0L);
                        aVar.f67812c = optJSONObject.optLong("freezed", 0L);
                        aVar.f67813d = optJSONObject.optInt("accountFrozen", 0);
                        this.f68073e.put(Integer.valueOf(aVar.f67810a), aVar);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("accountPeriodList");
            this.f68074f = new HashMap();
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    f.b bVar = new f.b();
                    bVar.f67816a = optJSONObject2.optInt("currencyType", 0);
                    bVar.f67817b = optJSONObject2.optInt("amount", 0);
                    bVar.f67818c = optJSONObject2.optLong("startTime", 0L);
                    bVar.f67819d = optJSONObject2.optLong("endTime", 0L);
                    this.f68074f.put(Integer.valueOf(bVar.f67816a), bVar);
                }
            }
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserAccountResponse", "parserResponse error.", e2);
        }
    }
}
