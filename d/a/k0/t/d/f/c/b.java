package d.a.k0.t.d.f.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61428g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f61429e;

    /* renamed from: f  reason: collision with root package name */
    public String f61430f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f61428g;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61429e = jSONObject.optString("url");
        this.f61430f = jSONObject.optString("pic");
        jSONObject.optLong("start_time", 0L);
        jSONObject.optLong("end_time", 0L);
        jSONObject.optString("name");
        jSONObject.optInt("id");
    }
}
