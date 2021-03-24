package d.b.s.a.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.s.a.g.e;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.s.a.e.a {

    /* renamed from: b  reason: collision with root package name */
    public a f64654b;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);

        void onFailure(int i, String str);
    }

    public b(Context context, a aVar) {
        this.f64653a = context;
        this.f64654b = aVar;
    }

    @Override // d.b.s.a.e.c.b
    public Map<String, String> getHeaders() {
        return null;
    }

    @Override // d.b.s.a.e.c.b
    public String getHost() {
        int a2 = d.b.s.a.g.b.a(this.f64653a);
        if (a2 == 1) {
            return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
        } else if (a2 == 2) {
            return "http://bjyz-migrate-big-mem-xyq-02.epc.baidu.com:8911/rest/5.0/generate_lcm_token";
        } else if (d.b.s.a.g.b.b(this.f64653a)) {
            return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
        } else {
            return "https://pim.baidu.com/rest/5.0/generate_lcm_token";
        }
    }

    @Override // d.b.s.a.e.c.b
    public String getMediaType() {
        return "application/json";
    }

    @Override // d.b.s.a.e.c.b
    public byte[] getRequestParameter() {
        try {
            JSONObject jSONObject = (JSONObject) d.b.s.a.g.a.c(this.f64653a, true);
            return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // d.b.s.a.e.c.d
    public void onFailure(int i, String str) {
        this.f64654b.onFailure(i, str);
    }

    @Override // d.b.s.a.e.c.d
    public void onSuccess(byte[] bArr) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(new String(bArr));
            d.b.s.a.g.d.a("GetTokenRequest", "onSuccess :" + jSONObject2.toString());
            int optInt = jSONObject2.optInt("error_code", -1);
            String optString = jSONObject2.optString("error_msg", "");
            if (optInt == 0) {
                e.r(this.f64653a, jSONObject2.optBoolean("bddns_enable", false));
                String optString2 = jSONObject2.optString("token");
                JSONArray jSONArray = jSONObject2.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                if (!TextUtils.isEmpty(optString2) && jSONArray != null && jSONArray.length() >= 1) {
                    e.x(this.f64653a, jSONArray.length());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray.get(i);
                        e.w(this.f64653a, jSONObject3.optString("protocol") + ":" + jSONObject3.optString("domain") + ":" + jSONObject3.optString(ClientCookie.PORT_ATTR), i);
                    }
                    e.t(this.f64653a, jSONObject2.optInt("ipv6_strategy", 3));
                    this.f64654b.a(optString2);
                    e.z(this.f64653a, optString2);
                    try {
                        String optString3 = jSONObject2.optString("client_log_config", "");
                        if (TextUtils.isEmpty(optString3)) {
                            return;
                        }
                        JSONObject jSONObject4 = new JSONObject(optString3);
                        d.b.s.a.a.d.s(this.f64653a, jSONObject4.optInt("client_upload_log_switch", 0));
                        JSONArray jSONArray2 = jSONObject4.getJSONArray("realtime_log_switch");
                        if (jSONArray2 != null && jSONArray2.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray2.length() && (jSONObject = jSONArray2.getJSONObject(i2)) != null; i2++) {
                                d.b.s.a.a.d.p(this.f64653a, jSONObject.optInt("id", 0), jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0));
                            }
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        d.b.s.a.g.d.b("GetTokenRequest", "Json Exception");
                        return;
                    }
                }
                this.f64654b.onFailure(10002, "token or protocol is empty");
                return;
            }
            this.f64654b.onFailure(optInt, optString);
        } catch (JSONException e2) {
            a aVar = this.f64654b;
            aVar.onFailure(10001, "parse response exception ：" + e2);
        }
    }
}
