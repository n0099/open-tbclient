package d.a.n0.v.j.g.d.d;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f62169f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f62170e;

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62170e = jSONObject.optString("effect_type_name");
        jSONObject.optInt("effect_type");
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f62169f;
    }
}
