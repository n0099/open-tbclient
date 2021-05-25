package d.r.b.a.a.f.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends h {

    /* renamed from: b  reason: collision with root package name */
    public String f67734b;

    /* renamed from: c  reason: collision with root package name */
    public String f67735c;

    /* renamed from: d  reason: collision with root package name */
    public int f67736d;

    /* renamed from: e  reason: collision with root package name */
    public int f67737e;

    /* renamed from: f  reason: collision with root package name */
    public int f67738f;

    /* renamed from: g  reason: collision with root package name */
    public int f67739g;

    /* renamed from: h  reason: collision with root package name */
    public String f67740h;

    public d(byte[] bArr) {
        super(bArr);
    }

    @Override // d.r.b.a.a.f.e.h
    public void k() {
        try {
            this.f67734b = g();
            JSONObject jSONObject = new JSONObject(this.f67734b);
            this.f67735c = jSONObject.optString(IAdRequestParam.SEQ);
            this.f67736d = jSONObject.optInt("result");
            this.f67737e = jSONObject.optInt("cmd");
            this.f67738f = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.f67739g = jSONObject.optInt("version");
            this.f67740h = jSONObject.optString("jsonMsg");
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageResponse", "popPacketData error", e2);
        }
    }

    public String l() {
        if (d.r.b.a.a.f.a.c().a() == ProtocolType.HTTP) {
            return this.f67740h;
        }
        return d.r.b.a.a.f.a.c().a() == ProtocolType.SERVICE ? this.f67734b : "";
    }

    public String toString() {
        return "PSCIMessageResponse{result=" + this.f67736d + ", cmd=" + this.f67737e + ", appId=" + this.f67738f + ", version=" + this.f67739g + ", seq=" + this.f67735c + ",responseJson=" + this.f67734b + '}';
    }
}
