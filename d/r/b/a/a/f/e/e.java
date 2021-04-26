package d.r.b.a.a.f.e;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends h {

    /* renamed from: b  reason: collision with root package name */
    public String f67012b;

    /* renamed from: c  reason: collision with root package name */
    public long f67013c;

    /* renamed from: d  reason: collision with root package name */
    public int f67014d;

    /* renamed from: e  reason: collision with root package name */
    public int f67015e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f67016f;

    public e(String str) {
        this.f67012b = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f67016f = jSONObject;
            this.f67013c = jSONObject.optLong("uri", 0L);
            this.f67014d = this.f67016f.optInt("appid", -1);
            this.f67015e = this.f67016f.optInt("usedChannel", 0);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageUnicast", "popPacketData error.", e2);
        }
    }

    @Override // d.r.b.a.a.f.e.h
    public void k() {
        try {
            this.f67012b = g();
            JSONObject jSONObject = new JSONObject(this.f67012b);
            this.f67016f = jSONObject;
            this.f67013c = jSONObject.optLong("uri", 0L);
            this.f67014d = this.f67016f.optInt("appid", -1);
            this.f67015e = this.f67016f.optInt("usedChannel", 0);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageUnicast", "popPacketData error.", e2);
        }
    }

    public int l() {
        return this.f67014d;
    }

    public String m() {
        return this.f67012b;
    }

    public long n() {
        return this.f67013c;
    }

    public void o(long j) {
        this.f67013c = j;
    }

    public String toString() {
        return "PSCIMessageUnicast{uri=" + this.f67013c + ", appId=" + this.f67014d + ", channelId=" + this.f67015e + '}';
    }
}
