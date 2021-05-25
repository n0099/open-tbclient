package d.r.b.a.a.f.e;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends h {

    /* renamed from: b  reason: collision with root package name */
    public String f67724b;

    /* renamed from: c  reason: collision with root package name */
    public long f67725c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67726d;

    public b(String str) {
        this.f67724b = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f67726d = jSONObject;
            this.f67725c = jSONObject.optLong("uri", 0L);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageBroadcast", "popPacketData error.", e2);
        }
    }

    @Override // d.r.b.a.a.f.e.h
    public void k() {
        try {
            this.f67724b = g();
            JSONObject jSONObject = new JSONObject(this.f67724b);
            this.f67726d = jSONObject;
            this.f67725c = jSONObject.optLong("uri", 0L);
        } catch (Exception e2) {
            d.r.b.a.a.f.d.d.d("PSCIMessageBroadcast", "popPacketData error.", e2);
        }
    }

    public JSONObject l() {
        return this.f67726d;
    }

    public String m() {
        return this.f67724b;
    }

    public void n(long j) {
        this.f67725c = j;
    }

    public String toString() {
        return "PSCIMessageBroadcast{uri=" + this.f67725c + '}';
    }
}
