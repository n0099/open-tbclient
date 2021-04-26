package d.r.b.a.a.f.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends h {

    /* renamed from: b  reason: collision with root package name */
    public String f67005b;

    /* renamed from: c  reason: collision with root package name */
    public String f67006c;

    /* renamed from: d  reason: collision with root package name */
    public int f67007d;

    /* renamed from: e  reason: collision with root package name */
    public int f67008e;

    /* renamed from: f  reason: collision with root package name */
    public int f67009f;

    /* renamed from: g  reason: collision with root package name */
    public int f67010g;

    /* renamed from: h  reason: collision with root package name */
    public String f67011h;

    public d(byte[] bArr) {
        super(bArr);
    }

    @Override // d.r.b.a.a.f.e.h
    public void k() {
        try {
            this.f67005b = g();
            JSONObject jSONObject = new JSONObject(this.f67005b);
            this.f67006c = jSONObject.optString(IAdRequestParam.SEQ);
            this.f67007d = jSONObject.optInt("result");
            this.f67008e = jSONObject.optInt("cmd");
            this.f67009f = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.f67010g = jSONObject.optInt("version");
            this.f67011h = jSONObject.optString("jsonMsg");
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageResponse", "popPacketData error", e2);
        }
    }

    public String l() {
        if (d.r.b.a.a.f.a.c().a() == ProtocolType.HTTP) {
            return this.f67011h;
        }
        return d.r.b.a.a.f.a.c().a() == ProtocolType.SERVICE ? this.f67005b : "";
    }

    public String toString() {
        return "PSCIMessageResponse{result=" + this.f67007d + ", cmd=" + this.f67008e + ", appId=" + this.f67009f + ", version=" + this.f67010g + ", seq=" + this.f67006c + ",responseJson=" + this.f67005b + '}';
    }
}
