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
    public long f67264a;

    /* renamed from: b  reason: collision with root package name */
    public int f67265b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f67266c;

    /* renamed from: d  reason: collision with root package name */
    public int f67267d;

    /* renamed from: e  reason: collision with root package name */
    public String f67268e;

    /* renamed from: f  reason: collision with root package name */
    public String f67269f;

    public h(long j, int i2, List<Integer> list, int i3, String str, String str2, String str3) {
        this.f67269f = "";
        this.f67264a = j;
        this.f67265b = i2;
        this.f67266c = list;
        this.f67267d = i3;
        this.f67268e = str;
        this.f67269f = str3;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.f67266c;
        if (list != null) {
            for (Integer num : list) {
                jSONArray.put(num);
            }
        }
        try {
            jSONObject.put("cmd", 1060);
            jSONObject.put("uid", this.f67264a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67265b);
            jSONObject.put("usedChannelList", jSONArray);
            jSONObject.put("currencyType", this.f67267d);
            jSONObject.put(IAdRequestParam.SEQ, this.f67268e);
            jSONObject.put("expand", this.f67269f);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigChannelsRequest", "GetChargeCurrencyConfigChannelsRequest error.", e2);
            return "";
        }
    }
}
