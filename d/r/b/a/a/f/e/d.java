package d.r.b.a.a.f.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends h {

    /* renamed from: b  reason: collision with root package name */
    public String f67691b;

    /* renamed from: c  reason: collision with root package name */
    public String f67692c;

    /* renamed from: d  reason: collision with root package name */
    public int f67693d;

    /* renamed from: e  reason: collision with root package name */
    public int f67694e;

    /* renamed from: f  reason: collision with root package name */
    public int f67695f;

    /* renamed from: g  reason: collision with root package name */
    public int f67696g;

    /* renamed from: h  reason: collision with root package name */
    public String f67697h;

    public d(byte[] bArr) {
        super(bArr);
    }

    @Override // d.r.b.a.a.f.e.h
    public void k() {
        try {
            this.f67691b = g();
            JSONObject jSONObject = new JSONObject(this.f67691b);
            this.f67692c = jSONObject.optString(IAdRequestParam.SEQ);
            this.f67693d = jSONObject.optInt("result");
            this.f67694e = jSONObject.optInt("cmd");
            this.f67695f = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.f67696g = jSONObject.optInt("version");
            this.f67697h = jSONObject.optString("jsonMsg");
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageResponse", "popPacketData error", e2);
        }
    }

    public String l() {
        if (d.r.b.a.a.f.a.c().a() == ProtocolType.HTTP) {
            return this.f67697h;
        }
        return d.r.b.a.a.f.a.c().a() == ProtocolType.SERVICE ? this.f67691b : "";
    }

    public String toString() {
        return "PSCIMessageResponse{result=" + this.f67693d + ", cmd=" + this.f67694e + ", appId=" + this.f67695f + ", version=" + this.f67696g + ", seq=" + this.f67692c + ",responseJson=" + this.f67691b + '}';
    }
}
