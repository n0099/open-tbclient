package d.b.i0.t.j.g.d.d;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f60969f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60970e;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60970e = jSONObject.optString("effect_type_name");
        jSONObject.optInt("effect_type");
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f60969f;
    }
}
