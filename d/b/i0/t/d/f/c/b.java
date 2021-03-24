package d.b.i0.t.d.f.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60530g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60531e;

    /* renamed from: f  reason: collision with root package name */
    public String f60532f;

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60531e = jSONObject.optString("url");
        this.f60532f = jSONObject.optString("pic");
        jSONObject.optLong("start_time", 0L);
        jSONObject.optLong("end_time", 0L);
        jSONObject.optString("name");
        jSONObject.optInt("id");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f60530g;
    }
}
