package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f67950a;

    /* renamed from: b  reason: collision with root package name */
    public int f67951b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f67952c;

    /* renamed from: d  reason: collision with root package name */
    public int f67953d;

    /* renamed from: e  reason: collision with root package name */
    public String f67954e;

    /* renamed from: f  reason: collision with root package name */
    public String f67955f;

    public h(long j, int i2, List<Integer> list, int i3, String str, String str2, String str3) {
        this.f67955f = "";
        this.f67950a = j;
        this.f67951b = i2;
        this.f67952c = list;
        this.f67953d = i3;
        this.f67954e = str;
        this.f67955f = str3;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.f67952c;
        if (list != null) {
            for (Integer num : list) {
                jSONArray.put(num);
            }
        }
        try {
            jSONObject.put("cmd", 1060);
            jSONObject.put("uid", this.f67950a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67951b);
            jSONObject.put("usedChannelList", jSONArray);
            jSONObject.put("currencyType", this.f67953d);
            jSONObject.put(IAdRequestParam.SEQ, this.f67954e);
            jSONObject.put("expand", this.f67955f);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigChannelsRequest", "GetChargeCurrencyConfigChannelsRequest error.", e2);
            return "";
        }
    }
}
