package d.a.o0.t2.f0.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f64891a;

    /* renamed from: b  reason: collision with root package name */
    public double f64892b;

    /* renamed from: c  reason: collision with root package name */
    public double f64893c;

    public static e b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        e eVar = new e();
        eVar.f64891a = jSONObject.optString("bottom_picture", "");
        jSONObject.optInt("cover_shadow_switch", 0);
        eVar.f64892b = jSONObject.optDouble("player_width_ratio", 0.0d);
        eVar.f64893c = jSONObject.optDouble("right_margin_ratio", 0.0d);
        jSONObject.optDouble("player_height_clipping_ratio", 0.0d);
        return eVar;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f64891a);
    }
}
