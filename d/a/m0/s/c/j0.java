package d.a.m0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public String f50469a;

    /* renamed from: b  reason: collision with root package name */
    public long f50470b;

    /* renamed from: c  reason: collision with root package name */
    public long f50471c;

    /* renamed from: d  reason: collision with root package name */
    public long f50472d;

    /* renamed from: e  reason: collision with root package name */
    public String f50473e;

    /* renamed from: f  reason: collision with root package name */
    public String f50474f;

    public long a() {
        return this.f50471c;
    }

    public String b() {
        return this.f50474f;
    }

    public String c() {
        return this.f50473e;
    }

    public long d() {
        return this.f50472d;
    }

    public long e() {
        return this.f50470b;
    }

    public String f() {
        return this.f50469a;
    }

    public void g(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f50469a = jSONObject.optString("splash_video_url");
            this.f50470b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f50471c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f50472d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f50473e = jSONObject.optString("splash_video_h5_url");
            this.f50474f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
