package d.r.b.a.a.f.e;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends h {

    /* renamed from: b  reason: collision with root package name */
    public String f67741b;

    /* renamed from: c  reason: collision with root package name */
    public long f67742c;

    /* renamed from: d  reason: collision with root package name */
    public int f67743d;

    /* renamed from: e  reason: collision with root package name */
    public int f67744e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f67745f;

    public e(String str) {
        this.f67741b = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f67745f = jSONObject;
            this.f67742c = jSONObject.optLong("uri", 0L);
            this.f67743d = this.f67745f.optInt("appid", -1);
            this.f67744e = this.f67745f.optInt("usedChannel", 0);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageUnicast", "popPacketData error.", e2);
        }
    }

    @Override // d.r.b.a.a.f.e.h
    public void k() {
        try {
            this.f67741b = g();
            JSONObject jSONObject = new JSONObject(this.f67741b);
            this.f67745f = jSONObject;
            this.f67742c = jSONObject.optLong("uri", 0L);
            this.f67743d = this.f67745f.optInt("appid", -1);
            this.f67744e = this.f67745f.optInt("usedChannel", 0);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageUnicast", "popPacketData error.", e2);
        }
    }

    public int l() {
        return this.f67743d;
    }

    public String m() {
        return this.f67741b;
    }

    public long n() {
        return this.f67742c;
    }

    public void o(long j) {
        this.f67742c = j;
    }

    public String toString() {
        return "PSCIMessageUnicast{uri=" + this.f67742c + ", appId=" + this.f67743d + ", channelId=" + this.f67744e + '}';
    }
}
