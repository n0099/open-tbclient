package d.r.b.a.a.f.e;

import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends g {

    /* renamed from: b  reason: collision with root package name */
    public String f67684b;

    /* renamed from: c  reason: collision with root package name */
    public int f67685c;

    /* renamed from: d  reason: collision with root package name */
    public int f67686d;

    /* renamed from: e  reason: collision with root package name */
    public int f67687e;

    /* renamed from: f  reason: collision with root package name */
    public String f67688f;

    /* renamed from: g  reason: collision with root package name */
    public String f67689g;

    /* renamed from: h  reason: collision with root package name */
    public String f67690h;

    public c(int i2, int i3, int i4, String str, String str2, String str3) {
        this.f67685c = i2;
        this.f67686d = i3;
        this.f67687e = i4;
        this.f67688f = str;
        this.f67689g = str2;
        this.f67690h = str3;
        d.r.b.a.a.f.d.d.c("PSCIMessageRequest", "request info: cmd = %d, appId = %d, version = %d, traceid = %d,jsonMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2, str3);
        t();
    }

    @Override // d.r.b.a.a.f.e.g
    public int k() {
        return this.f67684b.getBytes().length + 4;
    }

    @Override // d.r.b.a.a.f.e.g
    public void l() {
        j(this.f67684b);
    }

    public int m() {
        return this.f67686d;
    }

    public int n() {
        return this.f67685c;
    }

    public String o() {
        return this.f67690h;
    }

    public String p() {
        return this.f67688f;
    }

    public String q() {
        return this.f67689g;
    }

    public int r() {
        return this.f67687e;
    }

    public final void s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", this.f67685c);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67686d);
            jSONObject.put("version", this.f67687e);
            jSONObject.put("ticket", this.f67688f);
            jSONObject.put("traceid", this.f67689g);
            jSONObject.put("jsonMsg", this.f67690h);
            this.f67684b = jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageRequest", "packageRequestJson error", e2);
        }
    }

    public final void t() {
        if (d.r.b.a.a.f.a.c().a() == ProtocolType.HTTP) {
            s();
        } else if (d.r.b.a.a.f.a.c().a() == ProtocolType.SERVICE) {
            this.f67684b = this.f67690h;
        } else {
            d.r.b.a.a.f.d.d.e("PSCIMessageRequest", "packageRequestJson ProtocolType error ", new Object[0]);
        }
    }

    public String toString() {
        return "PSCIMessageRequest{cmd=" + this.f67685c + ", appId=" + this.f67686d + ", version=" + this.f67687e + ", traceid=" + this.f67689g + ", jsonMsg='" + this.f67690h + "'}";
    }

    public c(byte[] bArr) {
        e(bArr);
        try {
            String h2 = h();
            JSONObject jSONObject = new JSONObject(h2);
            this.f67685c = jSONObject.optInt("cmd");
            this.f67686d = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.f67687e = jSONObject.optInt("version");
            this.f67688f = jSONObject.optString("ticket");
            this.f67689g = jSONObject.optString("traceId");
            if (d.r.b.a.a.f.a.c().a() == ProtocolType.SERVICE) {
                this.f67690h = h2;
            } else if (d.r.b.a.a.f.a.c().a() == ProtocolType.HTTP) {
                this.f67690h = jSONObject.optString("jsonMsg");
            } else {
                d.r.b.a.a.f.d.d.e("PSCIMessageRequest", "PSCIMessageRequest construct ProtocolType error ", new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
