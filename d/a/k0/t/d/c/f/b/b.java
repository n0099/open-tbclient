package d.a.k0.t.d.c.f.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f61245e;

    /* renamed from: f  reason: collision with root package name */
    public String f61246f;

    /* renamed from: g  reason: collision with root package name */
    public String f61247g;

    /* renamed from: h  reason: collision with root package name */
    public String f61248h;

    /* renamed from: i  reason: collision with root package name */
    public String f61249i;
    public String j;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61245e = jSONObject.optString("user_id");
        this.f61246f = jSONObject.optString("user_name");
        this.f61247g = jSONObject.optString("user_nickname");
        this.f61248h = jSONObject.optString("portrait");
        this.f61249i = jSONObject.optString("user_brief");
        jSONObject.optLong("start_time");
        this.j = jSONObject.optString("remark");
    }
}
