package d.r.b.a.a.f.e;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends h {

    /* renamed from: b  reason: collision with root package name */
    public String f67698b;

    /* renamed from: c  reason: collision with root package name */
    public long f67699c;

    /* renamed from: d  reason: collision with root package name */
    public int f67700d;

    /* renamed from: e  reason: collision with root package name */
    public int f67701e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f67702f;

    public e(String str) {
        this.f67698b = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f67702f = jSONObject;
            this.f67699c = jSONObject.optLong("uri", 0L);
            this.f67700d = this.f67702f.optInt("appid", -1);
            this.f67701e = this.f67702f.optInt("usedChannel", 0);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageUnicast", "popPacketData error.", e2);
        }
    }

    @Override // d.r.b.a.a.f.e.h
    public void k() {
        try {
            this.f67698b = g();
            JSONObject jSONObject = new JSONObject(this.f67698b);
            this.f67702f = jSONObject;
            this.f67699c = jSONObject.optLong("uri", 0L);
            this.f67700d = this.f67702f.optInt("appid", -1);
            this.f67701e = this.f67702f.optInt("usedChannel", 0);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageUnicast", "popPacketData error.", e2);
        }
    }

    public int l() {
        return this.f67700d;
    }

    public String m() {
        return this.f67698b;
    }

    public long n() {
        return this.f67699c;
    }

    public void o(long j) {
        this.f67699c = j;
    }

    public String toString() {
        return "PSCIMessageUnicast{uri=" + this.f67699c + ", appId=" + this.f67700d + ", channelId=" + this.f67701e + '}';
    }
}
