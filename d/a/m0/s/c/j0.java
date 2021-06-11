package d.a.m0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public String f54145a;

    /* renamed from: b  reason: collision with root package name */
    public long f54146b;

    /* renamed from: c  reason: collision with root package name */
    public long f54147c;

    /* renamed from: d  reason: collision with root package name */
    public long f54148d;

    /* renamed from: e  reason: collision with root package name */
    public String f54149e;

    /* renamed from: f  reason: collision with root package name */
    public String f54150f;

    public long a() {
        return this.f54147c;
    }

    public String b() {
        return this.f54150f;
    }

    public String c() {
        return this.f54149e;
    }

    public long d() {
        return this.f54148d;
    }

    public long e() {
        return this.f54146b;
    }

    public String f() {
        return this.f54145a;
    }

    public void g(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f54145a = jSONObject.optString("splash_video_url");
            this.f54146b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f54147c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f54148d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f54149e = jSONObject.optString("splash_video_h5_url");
            this.f54150f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
