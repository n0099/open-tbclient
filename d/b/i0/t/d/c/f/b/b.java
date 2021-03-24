package d.b.i0.t.d.c.f.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60357e;

    /* renamed from: f  reason: collision with root package name */
    public String f60358f;

    /* renamed from: g  reason: collision with root package name */
    public String f60359g;

    /* renamed from: h  reason: collision with root package name */
    public String f60360h;
    public String i;
    public String j;

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60357e = jSONObject.optString("user_id");
        this.f60358f = jSONObject.optString("user_name");
        this.f60359g = jSONObject.optString("user_nickname");
        this.f60360h = jSONObject.optString("portrait");
        this.i = jSONObject.optString("user_brief");
        jSONObject.optLong("start_time");
        this.j = jSONObject.optString("remark");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
