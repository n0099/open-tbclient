package d.a.o0.v.j.g.d.d;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f66009f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f66010e;

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f66010e = jSONObject.optString("effect_type_name");
        jSONObject.optInt("effect_type");
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f66009f;
    }
}
