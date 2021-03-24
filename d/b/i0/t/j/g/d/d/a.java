package d.b.i0.t.j.g.d.d;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f60968f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60969e;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60969e = jSONObject.optString("effect_type_name");
        jSONObject.optInt("effect_type");
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f60968f;
    }
}
