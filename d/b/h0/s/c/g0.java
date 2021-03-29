package d.b.h0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51167a;

    /* renamed from: b  reason: collision with root package name */
    public long f51168b;

    /* renamed from: c  reason: collision with root package name */
    public long f51169c;

    /* renamed from: d  reason: collision with root package name */
    public long f51170d;

    /* renamed from: e  reason: collision with root package name */
    public String f51171e;

    /* renamed from: f  reason: collision with root package name */
    public String f51172f;

    public long a() {
        return this.f51169c;
    }

    public String b() {
        return this.f51172f;
    }

    public String c() {
        return this.f51171e;
    }

    public long d() {
        return this.f51170d;
    }

    public long e() {
        return this.f51168b;
    }

    public String f() {
        return this.f51167a;
    }

    public void g(String str) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f51167a = jSONObject.optString("splash_video_url");
            this.f51168b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f51169c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f51170d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f51171e = jSONObject.optString("splash_video_h5_url");
            this.f51172f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
