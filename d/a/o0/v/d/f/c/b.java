package d.a.o0.v.d.f.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f65555g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f65556e;

    /* renamed from: f  reason: collision with root package name */
    public String f65557f;

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65556e = jSONObject.optString("url");
        this.f65557f = jSONObject.optString("pic");
        jSONObject.optLong("start_time", 0L);
        jSONObject.optLong(ResultTB.ENDTIME, 0L);
        jSONObject.optString("name");
        jSONObject.optInt("id");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f65555g;
    }
}
