package d.a.n0.v.d.c.f.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f65246e;

    /* renamed from: f  reason: collision with root package name */
    public String f65247f;

    /* renamed from: g  reason: collision with root package name */
    public String f65248g;

    /* renamed from: h  reason: collision with root package name */
    public String f65249h;

    /* renamed from: i  reason: collision with root package name */
    public String f65250i;
    public String j;

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65246e = jSONObject.optString("user_id");
        this.f65247f = jSONObject.optString("user_name");
        this.f65248g = jSONObject.optString("user_nickname");
        this.f65249h = jSONObject.optString("portrait");
        this.f65250i = jSONObject.optString("user_brief");
        jSONObject.optLong("start_time");
        this.j = jSONObject.optString("remark");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }
}
