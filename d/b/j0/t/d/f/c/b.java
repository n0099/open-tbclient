package d.b.j0.t.d.f.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f62516g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f62517e;

    /* renamed from: f  reason: collision with root package name */
    public String f62518f;

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62517e = jSONObject.optString("url");
        this.f62518f = jSONObject.optString("pic");
        jSONObject.optLong("start_time", 0L);
        jSONObject.optLong("end_time", 0L);
        jSONObject.optString("name");
        jSONObject.optInt("id");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f62516g;
    }
}
