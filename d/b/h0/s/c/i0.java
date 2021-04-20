package d.b.h0.s.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51593a;

    /* renamed from: b  reason: collision with root package name */
    public long f51594b;

    /* renamed from: c  reason: collision with root package name */
    public long f51595c;

    /* renamed from: d  reason: collision with root package name */
    public long f51596d;

    /* renamed from: e  reason: collision with root package name */
    public String f51597e;

    /* renamed from: f  reason: collision with root package name */
    public String f51598f;

    public long a() {
        return this.f51595c;
    }

    public String b() {
        return this.f51598f;
    }

    public String c() {
        return this.f51597e;
    }

    public long d() {
        return this.f51596d;
    }

    public long e() {
        return this.f51594b;
    }

    public String f() {
        return this.f51593a;
    }

    public void g(String str) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f51593a = jSONObject.optString("splash_video_url");
            this.f51594b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f51595c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f51596d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f51597e = jSONObject.optString("splash_video_h5_url");
            this.f51598f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
