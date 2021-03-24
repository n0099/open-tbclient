package d.b.h0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51166a;

    /* renamed from: b  reason: collision with root package name */
    public long f51167b;

    /* renamed from: c  reason: collision with root package name */
    public long f51168c;

    /* renamed from: d  reason: collision with root package name */
    public long f51169d;

    /* renamed from: e  reason: collision with root package name */
    public String f51170e;

    /* renamed from: f  reason: collision with root package name */
    public String f51171f;

    public long a() {
        return this.f51168c;
    }

    public String b() {
        return this.f51171f;
    }

    public String c() {
        return this.f51170e;
    }

    public long d() {
        return this.f51169d;
    }

    public long e() {
        return this.f51167b;
    }

    public String f() {
        return this.f51166a;
    }

    public void g(String str) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f51166a = jSONObject.optString("splash_video_url");
            this.f51167b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f51168c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f51169d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f51170e = jSONObject.optString("splash_video_h5_url");
            this.f51171f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
