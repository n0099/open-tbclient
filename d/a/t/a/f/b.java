package d.a.t.a.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.yy.gslbsdk.db.ProbeTB;
import d.a.t.a.a.g;
import d.a.t.a.h.e;
import d.a.t.a.h.f;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.t.a.f.a {

    /* renamed from: b  reason: collision with root package name */
    public a f68343b;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);

        void onFailure(int i2, String str);
    }

    public b(Context context, a aVar) {
        this.f68342a = context;
        this.f68343b = aVar;
    }

    @Override // d.a.t.a.f.c.b
    public Map<String, String> getHeaders() {
        return null;
    }

    @Override // d.a.t.a.f.c.b
    public String getHost() {
        int a2 = d.a.t.a.h.c.a(this.f68342a);
        if (a2 == 1) {
            return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
        } else if (a2 == 2) {
            return "http://sz-shaheenv-al-b.bcc-szwg.baidu.com:8911/rest/5.0/generate_lcm_token";
        } else if (d.a.t.a.h.c.b(this.f68342a)) {
            return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
        } else {
            return "https://pim.baidu.com/rest/5.0/generate_lcm_token";
        }
    }

    @Override // d.a.t.a.f.c.b
    public String getMediaType() {
        return "application/json";
    }

    @Override // d.a.t.a.f.c.b
    public byte[] getRequestParameter() {
        try {
            JSONObject jSONObject = (JSONObject) d.a.t.a.h.b.c(this.f68342a, true);
            return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // d.a.t.a.f.c.d
    public void onFailure(int i2, String str) {
        this.f68343b.onFailure(i2, str);
    }

    @Override // d.a.t.a.f.c.d
    public void onSuccess(byte[] bArr) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(new String(bArr));
            e.a("GetTokenRequest", "onSuccess :" + jSONObject2.toString());
            int optInt = jSONObject2.optInt("error_code", -1);
            String optString = jSONObject2.optString("error_msg", "");
            d.a.t.a.a.a.h(this.f68342a).g(601110).c("token_end", System.currentTimeMillis()).b("connect_state", 1).d("P2", jSONObject2.toString()).d("con_err_code", "P2");
            if (optInt == 0) {
                f.r(this.f68342a, jSONObject2.optBoolean("bddns_enable", false));
                String optString2 = jSONObject2.optString("token");
                JSONArray jSONArray = jSONObject2.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                if (!TextUtils.isEmpty(optString2) && jSONArray != null && jSONArray.length() >= 1) {
                    f.x(this.f68342a, jSONArray.length());
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                        f.w(this.f68342a, jSONObject3.optString(ProbeTB.PROTOCOL) + ":" + jSONObject3.optString("domain") + ":" + jSONObject3.optString(ClientCookie.PORT_ATTR), i2);
                    }
                    f.t(this.f68342a, jSONObject2.optInt("ipv6_strategy", 3));
                    this.f68343b.a(optString2);
                    f.z(this.f68342a, optString2);
                    try {
                        String optString3 = jSONObject2.optString("client_log_config", "");
                        if (TextUtils.isEmpty(optString3)) {
                            return;
                        }
                        JSONObject jSONObject4 = new JSONObject(optString3);
                        g.j(this.f68342a, jSONObject4.optInt("client_upload_log_switch", 0));
                        JSONArray jSONArray2 = jSONObject4.getJSONArray("realtime_log_switch");
                        if (jSONArray2 != null && jSONArray2.length() > 0) {
                            for (int i3 = 0; i3 < jSONArray2.length() && (jSONObject = jSONArray2.getJSONObject(i3)) != null; i3++) {
                                g.i(this.f68342a, jSONObject.optInt("id", 0), jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0));
                            }
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        a aVar = this.f68343b;
                        aVar.onFailure(10001, "Json Exception" + e2);
                        e.b("GetTokenRequest", "Json Exception");
                        return;
                    }
                }
                this.f68343b.onFailure(10002, "token or protocol is empty");
                d.a.t.a.a.a.h(this.f68342a).g(601110).c("flow_end_time", System.currentTimeMillis()).e();
                return;
            }
            this.f68343b.onFailure(optInt, optString);
        } catch (JSONException e3) {
            a aVar2 = this.f68343b;
            aVar2.onFailure(10001, "parse response exception ：" + e3);
        }
    }
}
