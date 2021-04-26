package d.a.i0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public String f49582a;

    /* renamed from: b  reason: collision with root package name */
    public long f49583b;

    /* renamed from: c  reason: collision with root package name */
    public long f49584c;

    /* renamed from: d  reason: collision with root package name */
    public long f49585d;

    /* renamed from: e  reason: collision with root package name */
    public String f49586e;

    /* renamed from: f  reason: collision with root package name */
    public String f49587f;

    public long a() {
        return this.f49584c;
    }

    public String b() {
        return this.f49587f;
    }

    public String c() {
        return this.f49586e;
    }

    public long d() {
        return this.f49585d;
    }

    public long e() {
        return this.f49583b;
    }

    public String f() {
        return this.f49582a;
    }

    public void g(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f49582a = jSONObject.optString("splash_video_url");
            this.f49583b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f49584c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f49585d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f49586e = jSONObject.optString("splash_video_h5_url");
            this.f49587f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
