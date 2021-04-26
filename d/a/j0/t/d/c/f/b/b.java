package d.a.j0.t.d.c.f.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60521e;

    /* renamed from: f  reason: collision with root package name */
    public String f60522f;

    /* renamed from: g  reason: collision with root package name */
    public String f60523g;

    /* renamed from: h  reason: collision with root package name */
    public String f60524h;

    /* renamed from: i  reason: collision with root package name */
    public String f60525i;
    public String j;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60521e = jSONObject.optString("user_id");
        this.f60522f = jSONObject.optString("user_name");
        this.f60523g = jSONObject.optString("user_nickname");
        this.f60524h = jSONObject.optString("portrait");
        this.f60525i = jSONObject.optString("user_brief");
        jSONObject.optLong("start_time");
        this.j = jSONObject.optString("remark");
    }
}
