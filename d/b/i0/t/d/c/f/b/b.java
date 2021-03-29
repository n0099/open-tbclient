package d.b.i0.t.d.c.f.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60358e;

    /* renamed from: f  reason: collision with root package name */
    public String f60359f;

    /* renamed from: g  reason: collision with root package name */
    public String f60360g;

    /* renamed from: h  reason: collision with root package name */
    public String f60361h;
    public String i;
    public String j;

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60358e = jSONObject.optString("user_id");
        this.f60359f = jSONObject.optString("user_name");
        this.f60360g = jSONObject.optString("user_nickname");
        this.f60361h = jSONObject.optString("portrait");
        this.i = jSONObject.optString("user_brief");
        jSONObject.optLong("start_time");
        this.j = jSONObject.optString("remark");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
