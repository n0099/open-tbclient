package d.r.b.a.a.f.e;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends g {

    /* renamed from: b  reason: collision with root package name */
    public String f66998b;

    /* renamed from: c  reason: collision with root package name */
    public int f66999c;

    /* renamed from: d  reason: collision with root package name */
    public int f67000d;

    /* renamed from: e  reason: collision with root package name */
    public int f67001e;

    /* renamed from: f  reason: collision with root package name */
    public String f67002f;

    /* renamed from: g  reason: collision with root package name */
    public String f67003g;

    /* renamed from: h  reason: collision with root package name */
    public String f67004h;

    public c(int i2, int i3, int i4, String str, String str2, String str3) {
        this.f66999c = i2;
        this.f67000d = i3;
        this.f67001e = i4;
        this.f67002f = str;
        this.f67003g = str2;
        this.f67004h = str3;
        d.r.b.a.a.f.d.d.c("PSCIMessageRequest", "request info: cmd = %d, appId = %d, version = %d, traceid = %d,jsonMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2, str3);
        t();
    }

    @Override // d.r.b.a.a.f.e.g
    public int k() {
        return this.f66998b.getBytes().length + 4;
    }

    @Override // d.r.b.a.a.f.e.g
    public void l() {
        j(this.f66998b);
    }

    public int m() {
        return this.f67000d;
    }

    public int n() {
        return this.f66999c;
    }

    public String o() {
        return this.f67004h;
    }

    public String p() {
        return this.f67002f;
    }

    public String q() {
        return this.f67003g;
    }

    public int r() {
        return this.f67001e;
    }

    public final void s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", this.f66999c);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67000d);
            jSONObject.put("version", this.f67001e);
            jSONObject.put("ticket", this.f67002f);
            jSONObject.put("traceid", this.f67003g);
            jSONObject.put("jsonMsg", this.f67004h);
            this.f66998b = jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageRequest", "packageRequestJson error", e2);
        }
    }

    public final void t() {
        if (d.r.b.a.a.f.a.c().a() == ProtocolType.HTTP) {
            s();
        } else if (d.r.b.a.a.f.a.c().a() == ProtocolType.SERVICE) {
            this.f66998b = this.f67004h;
        } else {
            d.r.b.a.a.f.d.d.e("PSCIMessageRequest", "packageRequestJson ProtocolType error ", new Object[0]);
        }
    }

    public String toString() {
        return "PSCIMessageRequest{cmd=" + this.f66999c + ", appId=" + this.f67000d + ", version=" + this.f67001e + ", traceid=" + this.f67003g + ", jsonMsg='" + this.f67004h + "'}";
    }

    public c(byte[] bArr) {
        e(bArr);
        try {
            String h2 = h();
            JSONObject jSONObject = new JSONObject(h2);
            this.f66999c = jSONObject.optInt("cmd");
            this.f67000d = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.f67001e = jSONObject.optInt("version");
            this.f67002f = jSONObject.optString("ticket");
            this.f67003g = jSONObject.optString("traceId");
            if (d.r.b.a.a.f.a.c().a() == ProtocolType.SERVICE) {
                this.f67004h = h2;
            } else if (d.r.b.a.a.f.a.c().a() == ProtocolType.HTTP) {
                this.f67004h = jSONObject.optString("jsonMsg");
            } else {
                d.r.b.a.a.f.d.d.e("PSCIMessageRequest", "PSCIMessageRequest construct ProtocolType error ", new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
