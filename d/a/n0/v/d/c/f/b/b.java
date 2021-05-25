package d.a.n0.v.d.c.f.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f61533e;

    /* renamed from: f  reason: collision with root package name */
    public String f61534f;

    /* renamed from: g  reason: collision with root package name */
    public String f61535g;

    /* renamed from: h  reason: collision with root package name */
    public String f61536h;

    /* renamed from: i  reason: collision with root package name */
    public String f61537i;
    public String j;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61533e = jSONObject.optString("user_id");
        this.f61534f = jSONObject.optString("user_name");
        this.f61535g = jSONObject.optString("user_nickname");
        this.f61536h = jSONObject.optString("portrait");
        this.f61537i = jSONObject.optString("user_brief");
        jSONObject.optLong("start_time");
        this.j = jSONObject.optString("remark");
    }
}
