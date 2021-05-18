package d.a.j0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public String f50401a;

    /* renamed from: b  reason: collision with root package name */
    public long f50402b;

    /* renamed from: c  reason: collision with root package name */
    public long f50403c;

    /* renamed from: d  reason: collision with root package name */
    public long f50404d;

    /* renamed from: e  reason: collision with root package name */
    public String f50405e;

    /* renamed from: f  reason: collision with root package name */
    public String f50406f;

    public long a() {
        return this.f50403c;
    }

    public String b() {
        return this.f50406f;
    }

    public String c() {
        return this.f50405e;
    }

    public long d() {
        return this.f50404d;
    }

    public long e() {
        return this.f50402b;
    }

    public String f() {
        return this.f50401a;
    }

    public void g(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f50401a = jSONObject.optString("splash_video_url");
            this.f50402b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f50403c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f50404d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f50405e = jSONObject.optString("splash_video_h5_url");
            this.f50406f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
