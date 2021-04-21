package d.b.i0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51929a;

    /* renamed from: b  reason: collision with root package name */
    public long f51930b;

    /* renamed from: c  reason: collision with root package name */
    public long f51931c;

    /* renamed from: d  reason: collision with root package name */
    public long f51932d;

    /* renamed from: e  reason: collision with root package name */
    public String f51933e;

    /* renamed from: f  reason: collision with root package name */
    public String f51934f;

    public long a() {
        return this.f51931c;
    }

    public String b() {
        return this.f51934f;
    }

    public String c() {
        return this.f51933e;
    }

    public long d() {
        return this.f51932d;
    }

    public long e() {
        return this.f51930b;
    }

    public String f() {
        return this.f51929a;
    }

    public void g(String str) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f51929a = jSONObject.optString("splash_video_url");
            this.f51930b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f51931c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f51932d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f51933e = jSONObject.optString("splash_video_h5_url");
            this.f51934f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
