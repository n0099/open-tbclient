package d.a.n0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public String f54252a;

    /* renamed from: b  reason: collision with root package name */
    public long f54253b;

    /* renamed from: c  reason: collision with root package name */
    public long f54254c;

    /* renamed from: d  reason: collision with root package name */
    public long f54255d;

    /* renamed from: e  reason: collision with root package name */
    public String f54256e;

    /* renamed from: f  reason: collision with root package name */
    public String f54257f;

    public long a() {
        return this.f54254c;
    }

    public String b() {
        return this.f54257f;
    }

    public String c() {
        return this.f54256e;
    }

    public long d() {
        return this.f54255d;
    }

    public long e() {
        return this.f54253b;
    }

    public String f() {
        return this.f54252a;
    }

    public void g(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f54252a = jSONObject.optString("splash_video_url");
            this.f54253b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f54254c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f54255d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f54256e = jSONObject.optString("splash_video_h5_url");
            this.f54257f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
