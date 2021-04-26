package d.r.b.a.a.f.e;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends h {

    /* renamed from: b  reason: collision with root package name */
    public String f66995b;

    /* renamed from: c  reason: collision with root package name */
    public long f66996c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f66997d;

    public b(String str) {
        this.f66995b = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f66997d = jSONObject;
            this.f66996c = jSONObject.optLong("uri", 0L);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageBroadcast", "popPacketData error.", e2);
        }
    }

    @Override // d.r.b.a.a.f.e.h
    public void k() {
        try {
            this.f66995b = g();
            JSONObject jSONObject = new JSONObject(this.f66995b);
            this.f66997d = jSONObject;
            this.f66996c = jSONObject.optLong("uri", 0L);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageBroadcast", "popPacketData error.", e2);
        }
    }

    public JSONObject l() {
        return this.f66997d;
    }

    public String m() {
        return this.f66995b;
    }

    public void n(long j) {
        this.f66996c = j;
    }

    public String toString() {
        return "PSCIMessageBroadcast{uri=" + this.f66996c + '}';
    }
}
