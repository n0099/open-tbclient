package d.c.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b2 extends v1 {

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f65800f = {60000, 60000, 60000, AppConfig.TIMESTAMP_AVAILABLE_DURATION, AppConfig.TIMESTAMP_AVAILABLE_DURATION, AppConfig.TIMESTAMP_AVAILABLE_DURATION, 180000, 180000};

    /* renamed from: g  reason: collision with root package name */
    public static final long[] f65801g = {180000, 180000, 360000, 360000, 540000, 540000};

    /* renamed from: h  reason: collision with root package name */
    public static final long[] f65802h = {10000, 10000, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    /* renamed from: d  reason: collision with root package name */
    public j f65803d;

    /* renamed from: e  reason: collision with root package name */
    public e2 f65804e;

    public b2(Context context, j jVar, e2 e2Var) {
        super(context);
        this.f65803d = jVar;
        this.f65804e = e2Var;
    }

    @Override // d.c.b.v1
    public boolean a() {
        return true;
    }

    @Override // d.c.b.v1
    public long b() {
        return this.f65803d.w() + (this.f65804e.i() ? Constants.IM_TRACK_DURATION_MS : 43200000);
    }

    @Override // d.c.b.v1
    public long[] c() {
        int v = this.f65803d.v();
        if (v != 0) {
            if (v != 1) {
                if (v != 2) {
                    r0.b(null);
                    return f65801g;
                }
                return f65800f;
            }
            return f65801g;
        }
        return f65802h;
    }

    @Override // d.c.b.v1
    public boolean d() {
        JSONObject jSONObject = new JSONObject();
        JSONObject c2 = this.f65803d.c();
        if (c2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", c2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject f2 = x.f(y.a(this.f65933a, this.f65803d.c(), x.b().b(), true, a.k()), jSONObject);
            if (f2 != null) {
                return this.f65803d.h(f2, f2.optString(Constants.KEY_DEVICE_ID, ""), f2.optString("install_id", ""), f2.optString("ssid", ""));
            }
            return false;
        }
        r0.b(null);
        return false;
    }

    @Override // d.c.b.v1
    public String e() {
        return com.baidu.mapsdkplatform.comapi.map.r.f7699a;
    }
}
